// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import android.net.Uri;
import com.rhythmnewmedia.sdk.y;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

public static final class d
{

    public boolean a;
    public int b;
    public float c;
    public boolean d;

    public static d a(Uri uri)
    {
        String s;
        String s1;
        d d1;
        try
        {
            d1 = new <init>();
            if (uri.getQueryParameter("useBackground") != null)
            {
                d1.a = Boolean.parseBoolean(uri.getQueryParameter("useBackground"));
            }
            s1 = uri.getQueryParameter("backgroundColor");
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            y.c("Error parsing expandProperties: %s", new Object[] {
                uri.toString()
            });
            return null;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (s1.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        s = s1;
        if (s1.charAt(0) == '#')
        {
            s = s1.substring(1);
        }
        d1.b = Integer.parseInt(s, 16);
        if (uri.getQueryParameter("backgroundOpacity") != null)
        {
            d1.c = Float.parseFloat(uri.getQueryParameter("backgroundOpacity"));
        }
        if (uri.getQueryParameter("isModal") != null)
        {
            d1.d = Boolean.parseBoolean(uri.getQueryParameter("isModal"));
        }
        return d1;
    }

    public ()
    {
        a = false;
        b = 0xffffff;
        c = 1.0F;
        d = false;
    }
}
