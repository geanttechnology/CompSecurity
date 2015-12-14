// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private int badgePrimary;
    private int badgeSecondary;
    private String bio;
    private int downloadQuality;
    private String email;
    private boolean follower;
    private boolean following;
    private long id;
    private String instagram;
    private String lastName;
    private int lastValidation;
    private String message;
    private String name;
    private boolean premium;
    private String premiumDate;
    private boolean rateUs;
    private int streamQuality;
    private String username;

    public User(long l, String s, String s1, String s2, String s3, String s4, 
            boolean flag, boolean flag1, boolean flag2, int i, int j, int k, int i1, 
            int j1, boolean flag3, String s5, String s6, String s7)
    {
        id = l;
        name = s2;
        email = s1;
        rateUs = flag3;
        message = s4;
        premium = flag;
        username = s;
        lastName = s3;
        follower = flag1;
        following = flag2;
        premiumDate = s5;
        streamQuality = i1;
        lastValidation = i;
        downloadQuality = j1;
        badgePrimary = j;
        badgeSecondary = k;
        instagram = s6;
        bio = s7;
    }

    private User(Parcel parcel)
    {
        boolean flag = true;
        super();
        id = parcel.readLong();
        name = parcel.readString();
        email = parcel.readString();
        message = parcel.readString();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        premium = flag;
        lastName = parcel.readString();
        lastValidation = parcel.readInt();
        username = parcel.readString();
        badgePrimary = parcel.readInt();
        badgeSecondary = parcel.readInt();
        premiumDate = parcel.readString();
        instagram = parcel.readString();
        bio = parcel.readString();
    }

    User(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public static User newSkipInstance()
    {
        return new User(0L, "default", "defaul@mymixtapez.com", "Default", "", "", false, false, false, 0, 0, 0, 0, 0, false, "", "", "");
    }

    public int describeContents()
    {
        return 0;
    }

    public int getBadgePrimary()
    {
        return badgePrimary;
    }

    public int getBadgeSecondary()
    {
        return badgeSecondary;
    }

    public String getBio()
    {
        return bio;
    }

    public int getDownloadQuality()
    {
        return downloadQuality;
    }

    public String getEmail()
    {
        return email;
    }

    public long getId()
    {
        return id;
    }

    public String getInstagram()
    {
        return instagram;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getLastValidation()
    {
        return lastValidation;
    }

    public String getMessage()
    {
        return message;
    }

    public String getName()
    {
        return name;
    }

    public String getPremiumDate()
    {
        return premiumDate;
    }

    public int getStreamQuality()
    {
        return streamQuality;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean isFollower()
    {
        return follower;
    }

    public boolean isFollowing()
    {
        return following;
    }

    public boolean isPremium()
    {
        return premium;
    }

    public boolean isRateUs()
    {
        return rateUs;
    }

    public boolean isSkip()
    {
        return id == 0L;
    }

    public void setFollowing(boolean flag)
    {
        following = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(message);
        if (premium)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(lastName);
        parcel.writeInt(lastValidation);
        parcel.writeString(username);
        parcel.writeInt(badgePrimary);
        parcel.writeInt(badgeSecondary);
        parcel.writeString(premiumDate);
        parcel.writeString(instagram);
        parcel.writeString(bio);
    }


    /* member class not found */
    class _cls1 {}

}
