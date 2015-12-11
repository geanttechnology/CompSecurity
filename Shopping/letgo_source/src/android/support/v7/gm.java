// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            iu, gk, gj, gh, 
//            gl

public class gm
{

    public gm()
    {
    }

    public gl a(gh gh, ParseUser parseuser, iu iu1)
    {
        if (iu1.b(parseuser))
        {
            return new gk(gh, parseuser, iu1);
        } else
        {
            return new gj(gh, parseuser, iu1);
        }
    }
}
