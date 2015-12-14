// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;

final class b
{

    private final String a;
    private final Class b;
    private final Bundle c;
    private Fragment d;

    b(String s, Class class1, Bundle bundle)
    {
        a = s;
        b = class1;
        c = bundle;
    }

    static Fragment a(b b1)
    {
        return b1.d;
    }

    static Fragment a(b b1, Fragment fragment)
    {
        b1.d = fragment;
        return fragment;
    }

    static String b(b b1)
    {
        return b1.a;
    }

    static Class c(b b1)
    {
        return b1.b;
    }

    static Bundle d(b b1)
    {
        return b1.c;
    }
}
