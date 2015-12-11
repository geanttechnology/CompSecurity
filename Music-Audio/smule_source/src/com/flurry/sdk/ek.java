// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;

// Referenced classes of package com.flurry.sdk:
//            r

public class ek
{

    private final r a;
    private final String b;
    private final boolean c;
    private boolean d;

    public ek(r r1, String s, boolean flag, boolean flag1)
    {
        a = r1;
        b = s;
        c = flag;
        d = flag1;
    }

    public String a()
    {
        return b;
    }

    public boolean b()
    {
        return c;
    }

    public r c()
    {
        return a;
    }

    public boolean d()
    {
        return d;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof ek))
            {
                return false;
            }
            obj = (ek)obj;
            if (!TextUtils.equals(b, ((ek) (obj)).b) || !a.getClass().equals(((ek) (obj)).a.getClass()) || a.d() != ((ek) (obj)).a.d() || c != ((ek) (obj)).c || d != ((ek) (obj)).d)
            {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        return (new StringBuilder("fAdObjectId: ")).append(a.d()).append(", fLaunchUrl: ").append(b).append(", fShouldCloseAd: ").append(c).append(", fSendYCookie: ").append(d).toString();
    }
}
