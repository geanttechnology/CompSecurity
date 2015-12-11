// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import adv;
import adw;
import afx;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class oh
    implements SafeParcelable
{

    public static final afx CREATOR = new afx();
    public static final oh a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public oh(int i, String s, String s1, String s2, String s3)
    {
        b = i;
        c = s;
        d = s1;
        e = s2;
        f = s3;
    }

    public oh(String s, Locale locale, String s1)
    {
        this(1, s, locale.toString(), s1, null);
    }

    public int describeContents()
    {
        afx afx1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof oh))
            {
                return false;
            }
            obj = (oh)obj;
            if (!d.equals(((oh) (obj)).d) || !c.equals(((oh) (obj)).c) || !adv.a(e, ((oh) (obj)).e) || !adv.a(f, ((oh) (obj)).f))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            c, d, e
        });
    }

    public String toString()
    {
        return adv.a(this).a("clientPackageName", c).a("locale", d).a("accountName", e).a("gCoreClientName", f).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        afx afx1 = CREATOR;
        afx.a(this, parcel, i);
    }

    static 
    {
        a = new oh("com.google.android.gms", Locale.ENGLISH, null);
    }
}
