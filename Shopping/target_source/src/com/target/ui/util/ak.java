// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.net.Uri;
import com.target.mothership.util.o;

public class ak
{

    public static boolean a(Uri uri)
    {
        if (a(uri.toString(), new String[] {
    "file:///android_asset/htmls/"
}))
        {
            return false;
        }
        if (a(uri.getHost(), new String[] {
    "www.target.com"
}))
        {
            return true;
        }
        if (a(uri.toString(), new String[] {
    "tel:"
}))
        {
            return true;
        }
        return !a(uri.toString(), new String[] {
            "http://m.target.com/", "http://m-secure.target.com/"
        }) ? true : true;
    }

    private static transient boolean a(String s, String as[])
    {
        if (o.g(s))
        {
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                if (s.contains(as[i]))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
