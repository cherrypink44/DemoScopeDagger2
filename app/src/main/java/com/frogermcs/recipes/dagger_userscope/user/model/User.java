package com.frogermcs.recipes.dagger_userscope.user.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.frogermcs.recipes.dagger_userscope.api.response.UserResponse;

import org.jetbrains.annotations.NotNull;

import rx.functions.Func1;

public class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
    public String login;
    public long id;
    public String url;
    public String name;
    public String location;
    public String followers;
    public String following;

    public User() {
    }

    protected User(Parcel in) {
        this.login = in.readString();
        this.id = in.readLong();
        this.url = in.readString();
        this.name = in.readString();
        this.location = in.readString();
        this.followers = in.readString();
        this.following = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeLong(this.id);
        dest.writeString(this.url);
        dest.writeString(this.name);
        dest.writeString(this.location);
        dest.writeString(this.followers);
        dest.writeString(this.following);
    }

    @NotNull
    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", followers='" + followers + '\'' +
                ", following='" + following + '\'' +
                '}';
    }

    public static Func1<UserResponse, User> UserResponseToUser() {
        return new Func1<UserResponse, User>() {
            @Override
            public User call(UserResponse userResponse) {
                User user = new User();
                user.login = userResponse.login;
                user.id = userResponse.id;
                user.url = userResponse.url;
                user.name = userResponse.name;
                user.location = userResponse.location;
                user.followers = userResponse.followers + "";
                user.following = userResponse.following + "";
                return user;
            }
        };
    }
}