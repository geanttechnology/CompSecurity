// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package com.millennialmedia.android:
//            r, HttpMMHeaders, al, OverlaySettings, 
//            v, ab

class InterstitialAd extends r
    implements Parcelable, Externalizable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new InterstitialAd(parcel);
        }

        public final volatile Object[] newArray(int l)
        {
            return new InterstitialAd[l];
        }

    };
    private static final String k = com/millennialmedia/android/InterstitialAd.getName();
    String h;
    String i;
    HttpMMHeaders j;

    public InterstitialAd()
    {
    }

    InterstitialAd(Parcel parcel)
    {
        super(parcel);
        try
        {
            h = parcel.readString();
            i = parcel.readString();
            j = (HttpMMHeaders)parcel.readParcelable(com/millennialmedia/android/HttpMMHeaders.getClassLoader());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            al.a(k, "Interstitial problem reading parcel: ", parcel);
        }
    }

    final void a(Context context, long l)
    {
        Intent intent = new Intent();
        OverlaySettings overlaysettings = new OverlaySettings();
        overlaysettings.r = l;
        overlaysettings.m = h;
        overlaysettings.n = i;
        overlaysettings.o = j;
        overlaysettings.q = true;
        intent.putExtra("settings", overlaysettings);
        intent.putExtra("internalId", l);
        au.b.a(context, intent);
    }

    final boolean a(Context context)
    {
        return true;
    }

    final boolean a(Context context, ab ab1, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (h == null || h.length() <= 0 || i == null || i.length() <= 0 || !v.a(context).a(ab1.f, d)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (h == null || h.length() <= 0 || i == null || i.length() <= 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    final int c()
    {
        return 2;
    }

    final boolean c(Context context)
    {
        return true;
    }

    final String d()
    {
        return "Interstitial";
    }

    public int describeContents()
    {
        return 0;
    }

    public void readExternal(ObjectInput objectinput)
    {
        super.readExternal(objectinput);
        h = (String)objectinput.readObject();
        i = (String)objectinput.readObject();
        j = (HttpMMHeaders)objectinput.readObject();
    }

    public void writeExternal(ObjectOutput objectoutput)
    {
        super.writeExternal(objectoutput);
        objectoutput.writeObject(h);
        objectoutput.writeObject(i);
        objectoutput.writeObject(j);
    }

    public void writeToParcel(Parcel parcel, int l)
    {
        super.writeToParcel(parcel, l);
        parcel.writeString(h);
        parcel.writeString(i);
        parcel.writeParcelable(j, l);
    }

}
