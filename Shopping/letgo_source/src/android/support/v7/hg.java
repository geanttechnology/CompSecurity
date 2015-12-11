// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            iu, he, hd, gh, 
//            hf

public class hg
{

    public hg()
    {
    }

    public hf a(gh gh, ParseUser parseuser, iu iu1)
    {
        if (iu1.b(parseuser))
        {
            return new he(gh, parseuser);
        } else
        {
            return new hd(gh, parseuser);
        }
    }
}
