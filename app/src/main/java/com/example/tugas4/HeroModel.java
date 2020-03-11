package com.example.tugas4;

import android.os.Parcel;
import android.os.Parcelable;

public class HeroModel implements Parcelable {
    String heroNames, heroDetails;
    int heroesImages;



    protected HeroModel(Parcel in) {
        heroNames = in.readString();
        heroDetails = in.readString();
        heroesImages = in.readInt();
    }

    public static final Creator<HeroModel> CREATOR = new Creator<HeroModel>() {
        @Override
        public HeroModel createFromParcel(Parcel in) {
            return new HeroModel(in);
        }

        @Override
        public HeroModel[] newArray(int size) {
            return new HeroModel[size];
        }
    };

    public HeroModel() {

    }

    public String getHeroNames() {
        return heroNames;
    }

    public void setHeroNames(String heroNames) {
        this.heroNames = heroNames;
    }

    public String getHeroDetails() {
        return heroDetails;
    }

    public void setHeroDetails(String heroDetails) {
        this.heroDetails = heroDetails;
    }

    public int getHeroesImages() {
        return heroesImages;
    }

    public void setHeroesImages(int heroesImages) {
        this.heroesImages = heroesImages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(heroNames);
        dest.writeString(heroDetails);
        dest.writeInt(heroesImages);
    }
}