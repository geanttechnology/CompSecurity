// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            iu, go, gn, gh, 
//            gp

public class gq
{

    public gq()
    {
    }

    public gp a(gh gh, ParseUser parseuser, iu iu1)
    {
        if (iu1.b(parseuser))
        {
            return new go(gh, parseuser, iu1);
        } else
        {
            return new gn(gh, parseuser, iu1);
        }
    }
}
