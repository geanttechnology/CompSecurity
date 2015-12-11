// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.net.URI;
import java.net.URISyntaxException;

final class ea
{
    private static final class a
    {

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }


    private final a a = new a((byte)0);

    ea()
    {
    }

    static boolean a(String s)
    {
        try
        {
            new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }
}
