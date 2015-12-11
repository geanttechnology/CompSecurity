// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            iu, ha, gz, gh, 
//            hb

public class hc
{

    public hc()
    {
    }

    public hb a(gh gh, ParseUser parseuser, String s, iu iu1)
    {
        if (iu1.b(parseuser))
        {
            return new ha(gh, parseuser, s);
        } else
        {
            return new gz(gh, parseuser, s);
        }
    }
}
