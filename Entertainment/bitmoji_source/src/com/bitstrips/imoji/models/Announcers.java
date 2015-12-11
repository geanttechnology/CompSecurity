// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.bitstrips.imoji.models:
//            AnnouncerData

public class Announcers
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Announcers createFromParcel(Parcel parcel)
        {
            return new Announcers(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Announcers[] newArray(int i)
        {
            return new Announcers[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static String ENABLED_KEY = "enabled";
    private static String FASHION_ANNOUNCER_KEY = "fashion_announcer";
    private static String ID_KEY = "id";
    private static String LINK_KEY = "link";
    private static String TYPE_KEY = "announcerType";
    AnnouncerData fashion_announcer;

    public Announcers()
    {
    }

    protected Announcers(Parcel parcel)
    {
        fashion_announcer = (AnnouncerData)parcel.readParcelable(com/bitstrips/imoji/models/AnnouncerData.getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public AnnouncerData getFashionAnnouncerData()
    {
        return fashion_announcer;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(fashion_announcer, i);
    }

}
