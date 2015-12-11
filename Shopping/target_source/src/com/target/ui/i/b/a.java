// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.b;

import com.target.mothership.util.o;
import com.target.ui.util.validation.h;

public class a
{

    private static final int TEAM_MEMBER_ID_MAX_LENGTH = 12;
    private static final int TEAM_MEMBER_ID_MIN_LENGTH = 8;

    public static boolean a(String s)
    {
        if (!o.c(s))
        {
            boolean flag = h.a(s, 8);
            if (!h.b(s, 12) && !flag)
            {
                return true;
            }
        }
        return false;
    }
}
