// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.Context;
import android.text.TextUtils;
import com.wishabi.flipp.app.FlippApplication;

public final class g
{

    public static String a(String s)
    {
        Context context = FlippApplication.b();
        if (context != null) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        int i;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        if (!s.equalsIgnoreCase("All Deals"))
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0x7f0e006c;
_L4:
        if (i != 0)
        {
            return context.getString(i);
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (s.equalsIgnoreCase("Baby"))
        {
            i = 0x7f0e006d;
        } else
        if (s.equalsIgnoreCase("Grocery"))
        {
            i = 0x7f0e006e;
        } else
        if (s.equalsIgnoreCase("Health & Beauty"))
        {
            i = 0x7f0e006f;
        } else
        if (s.equalsIgnoreCase("Household"))
        {
            i = 0x7f0e0070;
        } else
        if (s.equalsIgnoreCase("Pets"))
        {
            i = 0x7f0e0072;
        } else
        {
            if (!s.equalsIgnoreCase("Other"))
            {
                break MISSING_BLOCK_LABEL_129;
            }
            i = 0x7f0e0071;
        }
          goto _L4
        i = 0;
          goto _L4
    }
}
