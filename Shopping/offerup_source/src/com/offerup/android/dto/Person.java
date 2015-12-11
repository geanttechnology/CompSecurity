// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.offerup.android.dto:
//            FollowProfile

public class Person
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private String firstName;
    private FollowProfile getProfile;
    private long id;

    public Person()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public FollowProfile getGetProfile()
    {
        return getProfile;
    }

    public long getId()
    {
        return id;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public String toString()
    {
        return (new StringBuilder("Person [firstName=")).append(firstName).append(", getProfile=").append(getProfile).append(", id=").append(id).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeString(firstName);
        parcel.writeParcelable(getProfile, i);
    }



/*
    static long access$002(Person person, long l)
    {
        person.id = l;
        return l;
    }

*/


/*
    static String access$102(Person person, String s)
    {
        person.firstName = s;
        return s;
    }

*/


/*
    static FollowProfile access$202(Person person, FollowProfile followprofile)
    {
        person.getProfile = followprofile;
        return followprofile;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Person createFromParcel(Parcel parcel)
        {
            Person person = new Person();
            person.id = parcel.readLong();
            person.firstName = parcel.readString();
            person.getProfile = (FollowProfile)parcel.readParcelable(com/offerup/android/dto/FollowProfile.getClassLoader());
            return person;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Person[] newArray(int i)
        {
            return new Person[i];
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
