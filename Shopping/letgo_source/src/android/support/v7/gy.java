// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            iu, gu, gt, gw, 
//            gv, gh, gx

public class gy
{

    public gy()
    {
    }

    public gx a(String s, gh gh, iu iu1, ParseUser parseuser)
    {
        if (s == null)
        {
            if (iu1.b(parseuser))
            {
                return new gu(gh, parseuser);
            } else
            {
                return new gt(gh, parseuser);
            }
        }
        if (iu1.b(parseuser))
        {
            return new gw(gh, s, parseuser);
        } else
        {
            return new gv(gh, s, parseuser);
        }
    }
}
