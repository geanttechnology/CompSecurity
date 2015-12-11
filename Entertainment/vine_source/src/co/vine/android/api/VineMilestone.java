// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Parcel;
import android.os.Parcelable;

public class VineMilestone
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VineMilestone createFromParcel(Parcel parcel)
        {
            return new VineMilestone(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public VineMilestone[] newArray(int i)
        {
            return new VineMilestone[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String backgroundImageUrl;
    public String backgroundVideoUrl;
    public int blurRadius;
    public String description;
    public String iconUrl;
    public String milestoneUrl;
    public float overlayAlpha;
    public int overlayColor;
    public String title;

    public VineMilestone(Parcel parcel)
    {
        backgroundImageUrl = parcel.readString();
        backgroundVideoUrl = parcel.readString();
        iconUrl = parcel.readString();
        title = parcel.readString();
        description = parcel.readString();
        milestoneUrl = parcel.readString();
        overlayColor = parcel.readInt();
        overlayAlpha = parcel.readFloat();
        blurRadius = parcel.readInt();
    }

    public VineMilestone(String s, String s1, String s2, String s3, String s4, String s5, int i, 
            float f, int j)
    {
        backgroundImageUrl = s;
        backgroundVideoUrl = s1;
        iconUrl = s2;
        title = s3;
        description = s4;
        milestoneUrl = s5;
        overlayColor = i;
        overlayAlpha = f;
        blurRadius = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(backgroundImageUrl);
        parcel.writeString(backgroundVideoUrl);
        parcel.writeString(iconUrl);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(milestoneUrl);
        parcel.writeInt(overlayColor);
        parcel.writeFloat(overlayAlpha);
        parcel.writeInt(blurRadius);
    }

}
