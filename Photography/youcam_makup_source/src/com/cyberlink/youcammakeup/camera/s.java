// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import com.android.camera.exif.c;
import com.pf.common.utility.m;
import java.io.IOException;

public class s
{

    public static final int a[] = {
        1, 2, 1, 4, 1, 1, 5, 1, 7
    };

    public static int a(c c1)
    {
        c1 = c1.c(c.j);
        if (c1 == null)
        {
            return 1;
        } else
        {
            return c1.intValue();
        }
    }

    public static c a(byte abyte0[])
    {
        c c1 = new c();
        try
        {
            c1.a(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            m.b("ExifUtils", "Failed to read EXIF data", abyte0);
            return c1;
        }
        return c1;
    }

}
