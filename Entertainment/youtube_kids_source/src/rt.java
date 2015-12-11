// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public final class rt
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new ru();
    private final String a;
    private final bgj b;
    private final cwr c;
    private final cxa d;
    private final pr e;
    private final py f;
    private final vc g;
    private final buz h;

    public rt(Parcel parcel)
    {
        ClassLoader classloader = getClass().getClassLoader();
        a = parcel.readString();
        b = (bgj)parcel.readParcelable(classloader);
        c = (cwr)parcel.readParcelable(classloader);
        d = (cxa)parcel.readParcelable(classloader);
        e = (pr)parcel.readParcelable(classloader);
        f = (py)parcel.readParcelable(classloader);
        g = (vc)parcel.readParcelable(classloader);
        h = (buz)parcel.readParcelable(classloader);
    }

    public rt(String s, bgj bgj1, cwr cwr1, cxa cxa1, pr pr1, py py1, vc vc1, 
            buz buz1)
    {
        a = s;
        b = bgj1;
        c = cwr1;
        d = cxa1;
        e = pr1;
        f = py1;
        g = vc1;
        h = buz1;
    }

    static String a(rt rt1)
    {
        return rt1.a;
    }

    static buz b(rt rt1)
    {
        return rt1.h;
    }

    static bgj c(rt rt1)
    {
        return rt1.b;
    }

    static cwr d(rt rt1)
    {
        return rt1.c;
    }

    static cxa e(rt rt1)
    {
        return rt1.d;
    }

    static pr f(rt rt1)
    {
        return rt1.e;
    }

    static py g(rt rt1)
    {
        return rt1.f;
    }

    static vc h(rt rt1)
    {
        return rt1.g;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String toString()
    {
        return String.format(Locale.US, "PlaybackClientManagerState { videoId=%s }", new Object[] {
            a
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(a);
        parcel.writeParcelable(b, 0);
        parcel.writeParcelable(c, 0);
        parcel.writeParcelable(d, 0);
        parcel.writeParcelable(e, 0);
        parcel.writeParcelable(f, 0);
        parcel.writeParcelable(g, 0);
        parcel.writeParcelable(h, 0);
    }

}
