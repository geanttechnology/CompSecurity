// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;

public class VineNotificationSetting
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineNotificationSetting createFromParcel(Parcel parcel)
        {
            return new VineNotificationSetting(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineNotificationSetting[] newArray(int i)
        {
            return new VineNotificationSetting[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ArrayList choices;
    public boolean isBooleanSetting;
    public String name;
    public String section;
    public String title;
    public String value;

    public VineNotificationSetting(Parcel parcel)
    {
        boolean flag = true;
        super();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        isBooleanSetting = flag;
        name = parcel.readString();
        title = parcel.readString();
        section = parcel.readString();
        value = parcel.readString();
        choices = (ArrayList)parcel.readSerializable();
    }

    public VineNotificationSetting(boolean flag, String s, String s1, String s2, String s3, ArrayList arraylist)
    {
        isBooleanSetting = flag;
        name = s;
        title = s1;
        section = s2;
        value = s3;
        choices = arraylist;
    }

    public void addToMap(HashMap hashmap)
    {
        hashmap.put(name, value);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (isBooleanSetting)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(name);
        parcel.writeString(title);
        parcel.writeString(section);
        parcel.writeString(value);
        parcel.writeSerializable(choices);
    }

}
