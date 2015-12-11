// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import a;
import android.os.Parcel;
import android.text.TextUtils;
import avp;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

public class LaunchOptions
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new avp();
    public final int a;
    public boolean b;
    public String c;

    public LaunchOptions()
    {
        Object obj = Locale.getDefault();
        StringBuilder stringbuilder = new StringBuilder(20);
        stringbuilder.append(((Locale) (obj)).getLanguage());
        String s = ((Locale) (obj)).getCountry();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append('-').append(s);
        }
        obj = ((Locale) (obj)).getVariant();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            stringbuilder.append('-').append(((String) (obj)));
        }
        this(1, false, stringbuilder.toString());
    }

    public LaunchOptions(int i, boolean flag, String s)
    {
        a = i;
        b = flag;
        c = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof LaunchOptions))
            {
                return false;
            }
            obj = (LaunchOptions)obj;
            if (b != ((LaunchOptions) (obj)).b || !a.g(c, ((LaunchOptions) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Boolean.valueOf(b), c
        });
    }

    public String toString()
    {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[] {
            Boolean.valueOf(b), c
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        avp.a(this, parcel);
    }

}
