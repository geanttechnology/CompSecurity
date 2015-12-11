// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.offerup.android.dto:
//            Rating

public class FollowProfile
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private String avatarNormal;
    private String avatarSquare;
    private boolean hasFacebook;
    private String publicLocationName;
    private Rating rating;
    private int verified;

    public FollowProfile()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAvatarNormal()
    {
        return avatarNormal;
    }

    public String getAvatarSquare()
    {
        return avatarSquare;
    }

    public String getPublicLocationName()
    {
        return publicLocationName;
    }

    public Rating getRating()
    {
        return rating;
    }

    public boolean hasFacebook()
    {
        return hasFacebook;
    }

    public boolean isVerifiedUser()
    {
        return verified == 1;
    }

    public void setAvatarSquare(String s)
    {
        avatarSquare = s;
    }

    public String toString()
    {
        return avatarSquare;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(publicLocationName);
        parcel.writeString(avatarSquare);
        parcel.writeString(avatarNormal);
        parcel.writeParcelable(rating, i);
        parcel.writeInt(verified);
        if (hasFacebook)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }



/*
    static String access$002(FollowProfile followprofile, String s)
    {
        followprofile.publicLocationName = s;
        return s;
    }

*/


/*
    static String access$102(FollowProfile followprofile, String s)
    {
        followprofile.avatarSquare = s;
        return s;
    }

*/


/*
    static String access$202(FollowProfile followprofile, String s)
    {
        followprofile.avatarNormal = s;
        return s;
    }

*/


/*
    static Rating access$302(FollowProfile followprofile, Rating rating1)
    {
        followprofile.rating = rating1;
        return rating1;
    }

*/


/*
    static int access$402(FollowProfile followprofile, int i)
    {
        followprofile.verified = i;
        return i;
    }

*/


/*
    static boolean access$502(FollowProfile followprofile, boolean flag)
    {
        followprofile.hasFacebook = flag;
        return flag;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final FollowProfile createFromParcel(Parcel parcel)
        {
            FollowProfile followprofile = new FollowProfile();
            followprofile.publicLocationName = parcel.readString();
            followprofile.avatarSquare = parcel.readString();
            followprofile.avatarNormal = parcel.readString();
            followprofile.rating = (Rating)parcel.readParcelable(com/offerup/android/dto/Rating.getClassLoader());
            followprofile.verified = parcel.readInt();
            followprofile.hasFacebook = (new OfferUpBoolean(parcel.readInt())).value;
            return followprofile;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final FollowProfile[] newArray(int i)
        {
            return new FollowProfile[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
