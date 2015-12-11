// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.validation;

import android.content.Context;
import android.content.res.Resources;
import com.target.ui.util.validation.a.e;
import java.util.List;

public final class c
{

    public static String a(Context context, e e1, int i, int j)
    {
        e1 = e1.reasons;
        if (e1 == null || e1.isEmpty())
        {
            return "";
        }
        context = context.getResources();
        if (e1.contains(com.target.ui.util.validation.a.e.a.EMPTY) || e1.contains(com.target.ui.util.validation.a.e.a.ONLY_SPACES))
        {
            return context.getString(0x7f090060);
        }
        if (e1.contains(com.target.ui.util.validation.a.e.a.TOO_SHORT))
        {
            return String.format(context.getString(0x7f090063), new Object[] {
                Integer.valueOf(i)
            });
        }
        if (e1.contains(com.target.ui.util.validation.a.e.a.TOO_LONG))
        {
            return String.format(context.getString(0x7f090062), new Object[] {
                Integer.valueOf(j)
            });
        }
        if (e1.contains(com.target.ui.util.validation.a.e.a.SPECIAL_CHAR_NOT_ALLOWED))
        {
            return context.getString(0x7f090064);
        } else
        {
            return "";
        }
    }
}
