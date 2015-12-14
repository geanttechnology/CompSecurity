// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import java.net.URI;

public class ac
{

    static final ac a = new ac("0", "http://none");
    public final String b;
    public final URI c;

    ac(String s, String s1)
    {
        b = s;
        if (s1 == null)
        {
            s = URI.create("http://none");
        } else
        {
            s = URI.create(s1);
        }
        c = s;
    }

}
