// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;

import android.app.Activity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.smule.android.c:
//            v, x, ab

public abstract class t
    implements v
{

    public t()
    {
    }

    protected static String a(x x1)
    {
        if (x1 == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        if (x1.d != null)
        {
            a(stringbuilder, "context", x1.d);
        }
        if (x1.c != null)
        {
            a(stringbuilder, "target", x1.c);
        }
        if (x1.e != null)
        {
            a(stringbuilder, "value", x1.e);
        }
        return stringbuilder.toString();
    }

    private static void a(StringBuilder stringbuilder, String s, String s1)
    {
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append("&");
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        s = URLEncoder.encode(s, "UTF-8");
_L2:
        stringbuilder.append(s);
        stringbuilder.append("=");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        s = URLEncoder.encode(s1, "UTF-8");
_L1:
        stringbuilder.append(s);
        return;
        s = "";
          goto _L1
        stringbuilder;
        throw new RuntimeException("This method requires UTF-8 encoding support", stringbuilder);
        s = "";
          goto _L2
    }

    protected String a(Activity activity)
    {
        if (activity instanceof ab)
        {
            activity = (ab)activity;
            if (!activity.a())
            {
                return null;
            } else
            {
                return activity.b();
            }
        } else
        {
            return activity.getClass().getSimpleName();
        }
    }
}
