// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.android;

import android.os.Bundle;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public final class Util
{

    private static final String UTF8 = "UTF-8";

    public Util()
    {
    }

    public static Bundle decodeUrl(String s)
    {
        Bundle bundle = new Bundle();
        if (s == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        s = s.split("&");
        j = s.length;
        i = 0;
_L8:
        if (i >= j) goto _L2; else goto _L3
_L3:
        String as[] = s[i].split("=");
        if (as.length != 2) goto _L5; else goto _L4
_L4:
        bundle.putString(URLDecoder.decode(as[0], "UTF-8"), URLDecoder.decode(as[1], "UTF-8"));
          goto _L6
_L5:
        try
        {
            if (as.length == 1)
            {
                bundle.putString(URLDecoder.decode(as[0], "UTF-8"), "");
            }
        }
        catch (UnsupportedEncodingException unsupportedencodingexception) { }
          goto _L6
_L2:
        return bundle;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static Bundle parseUrl(String s)
    {
        s = s.replace("fbconnect", "http");
        Bundle bundle;
        try
        {
            s = new URL(s);
            bundle = decodeUrl(s.getQuery());
            bundle.putAll(decodeUrl(s.getRef()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new Bundle();
        }
        return bundle;
    }
}
