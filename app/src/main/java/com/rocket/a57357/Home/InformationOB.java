package com.rocket.a57357.Home;

import android.os.Parcel;
import android.os.Parcelable;

public class InformationOB implements Parcelable {

    private int mHeader;
    private int mDescription;

    public InformationOB(int header, int description) {
        this.mHeader = header;
        this.mDescription = description;
    }

    protected InformationOB(Parcel in) {
        mHeader = in.readInt();
        mDescription = in.readInt();
    }

    public static final Creator<InformationOB> CREATOR = new Creator<InformationOB>() {
        @Override
        public InformationOB createFromParcel(Parcel in) {
            return new InformationOB(in);
        }

        @Override
        public InformationOB[] newArray(int size) {
            return new InformationOB[size];
        }
    };

    public int getHeader() {
        return mHeader;
    }

    public int getDescription() {
        return mDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mHeader);
        dest.writeInt(mDescription);
    }
}
