// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class rk
{

    public final boolean a;
    public final boolean b;
    public final int c;
    public final String d;
    public final rt e;
    public final czi f;

    public rk(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        ClassLoader classloader = getClass().getClassLoader();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        b = flag;
        c = parcel.readInt();
        d = parcel.readString();
        e = (rt)parcel.readParcelable(classloader);
        f = (czi)parcel.readParcelable(classloader);
    }

    public rk(boolean flag, boolean flag1, int i, String s, rt rt1, czi czi1)
    {
        a = flag;
        b = flag1;
        c = i;
        d = s;
        e = rt1;
        f = czi1;
    }

    public final String toString()
    {
        String s = String.valueOf(Integer.toHexString(System.identityHashCode(this)));
        boolean flag = a;
        boolean flag1 = b;
        int i = c;
        String s1 = d;
        String s2 = String.valueOf(e);
        return (new StringBuilder(String.valueOf(s).length() + 120 + String.valueOf(s1).length() + String.valueOf(s2).length())).append("ContentVideoState{").append(s).append(" wasStopped=").append(flag).append(" wasEnded=").append(flag1).append(" videoPositionMillis=").append(i).append(" videoCpn=").append(s1).append(" playbackClientMangerState=").append(s2).append("}").toString();
    }
}
