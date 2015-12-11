// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.wishabi.flipp.content.FormattedString;
import com.wishabi.flipp.content.ab;
import com.wishabi.flipp.util.p;

// Referenced classes of package com.wishabi.flipp.app:
//            FlippApplication, fq, fn, dp, 
//            dq

public final class fp
{

    public static int a(FragmentManager fragmentmanager)
    {
        Context context = FlippApplication.b();
        if (context == null)
        {
            return fq.c;
        } else
        {
            return a(fragmentmanager, null, "tutorial_showed_coupon_badge", new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
                new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0146), new com.wishabi.flipp.content.FormattedString.Format[] {
                    new com.wishabi.flipp.content.FormattedString.Format(ab.a)
                }), new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0147), new com.wishabi.flipp.content.FormattedString.Format[] {
                    new com.wishabi.flipp.content.FormattedString.Format(ab.b)
                }), new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0148), new com.wishabi.flipp.content.FormattedString.Format[] {
                    new com.wishabi.flipp.content.FormattedString.Format(ab.a)
                })
            }), 0x7f0200f4, 0x7f0200f8, null);
        }
    }

    static int a(FragmentManager fragmentmanager, String s, String s1, FormattedString formattedstring, int i, int j, dq dq)
    {
        if (fragmentmanager == null)
        {
            return fq.c;
        }
        SharedPreferences sharedpreferences = p.a();
        if (sharedpreferences == null)
        {
            return fq.c;
        }
        if (sharedpreferences.getBoolean(s1, false))
        {
            return fq.a;
        } else
        {
            formattedstring = fn.a(formattedstring, i, j);
            formattedstring.a = dq;
            formattedstring.show(fragmentmanager, s);
            sharedpreferences.edit().putBoolean(s1, true).commit();
            return fq.b;
        }
    }
}
