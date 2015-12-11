// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.content.Context;
import android.content.res.Resources;
import com.target.mothership.c;

public class m
{

    public static String a(String s)
    {
        s = c.c();
        int i = s.getResources().getIdentifier("default_list_title", "string", s.getPackageName());
        return s.getResources().getString(i);
    }
}
