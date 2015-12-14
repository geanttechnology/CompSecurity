// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.masteraccess;

import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import java.io.File;

public class b
{

    private final long a;
    private final long b;
    private final long c;
    private final File d;

    b(UIImageCodecErrorCode uiimagecodecerrorcode, long l, long l1, long l2, 
            File file)
    {
        a = l;
        b = l1;
        c = l2;
        d = file;
    }

    public long a()
    {
        return b;
    }

    public File b()
    {
        return d;
    }
}
