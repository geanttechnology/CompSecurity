// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.os.Parcel;

// Referenced classes of package com.digimarc.dms.resolver:
//            Payoff

public class StandardPayoff extends Payoff
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final StandardPayoff createFromParcel(Parcel parcel)
        {
            return new StandardPayoff(new Payoff(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final StandardPayoff[] newArray(int i)
        {
            return null;
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private String msActionToken;
    private String msActionType;
    private String msContent;
    private String msDescription;

    public StandardPayoff(Payoff payoff, String s, String s1, String s2, String s3)
    {
        super(payoff);
        msContent = s;
        msActionType = s1;
        msDescription = s2;
        msActionToken = s3;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getActionToken()
    {
        return msActionToken;
    }

    public String getActionType()
    {
        return msActionType;
    }

    public String getContent()
    {
        return msContent;
    }

    public String getDescription()
    {
        return msDescription;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(msContent);
        parcel.writeString(msActionType);
        parcel.writeString(msDescription);
        parcel.writeString(msActionToken);
    }

}
