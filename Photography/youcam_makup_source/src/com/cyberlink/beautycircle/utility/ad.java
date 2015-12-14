// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.Context;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.utility.g;
import java.util.Locale;

public class ad
{

    public static String a;
    public static String b;
    public static final String c;

    public static String a(Uri uri)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (uri != null) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
_L2:
        Uri uri1 = obj1;
        String s = uri.getHost().toLowerCase(Locale.US);
        uri1 = obj1;
        if (s.endsWith("youtube.com"))
        {
            uri1 = obj1;
            try
            {
                return uri.getQueryParameter("v");
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                uri.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_85;
        }
        uri1 = obj1;
        if (!s.endsWith("youtu.be")) goto _L1; else goto _L3
_L3:
        uri1 = obj1;
        uri = uri.getPath();
        obj = uri;
        if (uri == null) goto _L1; else goto _L4
_L4:
        uri1 = uri;
        uri = uri.substring(1);
        return uri;
        return uri1;
    }

    public static boolean a(Context context, Uri uri)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        String s = a(uri);
        flag = flag1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        flag1 = true;
        flag = flag1;
        if (!g.a(Globals.n().getApplicationContext(), b))
        {
            break MISSING_BLOCK_LABEL_48;
        }
        flag = flag1;
        com.cyberlink.beautycircle.c.e(context, s);
        return true;
        flag = flag1;
        com.cyberlink.beautycircle.c.a(context, uri.toString(), 2);
        return true;
        context;
        context.printStackTrace();
        return flag;
    }

    public static boolean b(Uri uri)
    {
        boolean flag = false;
        try
        {
            uri = a(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            return false;
        }
        if (uri != null)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean c(Uri uri)
    {
        if (uri == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = uri.getHost().toLowerCase(Locale.US).endsWith("youku.com");
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            uri.printStackTrace();
            return false;
        }
        return flag;
    }

    public static boolean d(Uri uri)
    {
        while (b(uri) || c(uri)) 
        {
            return true;
        }
        return false;
    }

    static 
    {
        a = Globals.n().getString(m.share_youtube_api_key);
        b = Globals.n().getString(m.youtube_package_name);
        c = (new StringBuilder()).append("https://www.googleapis.com/youtube/v3/videos?id=%s&key=").append(a).append("&part=%s").toString();
    }
}
