// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import java.util.Locale;

public final class  extends Enum
{

    private static final Self $VALUES[];
    public static final Self New;
    public static final Self Self;

    public static  parse(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
         a[];
         ;
        int i;
        int j;
        boolean flag;
        try
        {
            a = values();
            j = a.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
         = a[i];
        flag = .name().equalsIgnoreCase(s);
        if (flag)
        {
            return ;
        }
        i++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L3; else goto _L2
_L2:
        return New;
    }

    public static New valueOf(String s)
    {
        return (New)Enum.valueOf(com/apptentive/android/sdk/module/engagement/interaction/model/NavigateToLinkInteraction$Target, s);
    }

    public static New[] values()
    {
        return (New[])$VALUES.clone();
    }

    public final String lowercaseName()
    {
        return name().toLowerCase(Locale.US);
    }

    static 
    {
        New = new <init>("New", 0);
        Self = new <init>("Self", 1);
        $VALUES = (new .VALUES[] {
            New, Self
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
