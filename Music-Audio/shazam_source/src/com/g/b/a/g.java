// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import java.net.InetAddress;
import java.net.UnknownHostException;

public interface g
{

    public static final g a = new g() {

        public final InetAddress[] a(String s)
        {
            if (s == null)
            {
                throw new UnknownHostException("host == null");
            } else
            {
                return InetAddress.getAllByName(s);
            }
        }

    };

    public abstract InetAddress[] a(String s);

}
