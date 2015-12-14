// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import java.util.concurrent.ConcurrentHashMap;

class <init> extends ConcurrentHashMap
{

    private static final long serialVersionUID = 0x8eda185b9a918182L;

    long a(String s, long l)
    {
        s = ((String) (get(s)));
        if (s == null)
        {
            return l;
        } else
        {
            return ((Long)s).longValue();
        }
    }

    boolean a(String s)
    {
        return a(s, false);
    }

    boolean a(String s, boolean flag)
    {
        s = ((String) (get(s)));
        if (s == null)
        {
            return flag;
        } else
        {
            return ((Boolean)s).booleanValue();
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
