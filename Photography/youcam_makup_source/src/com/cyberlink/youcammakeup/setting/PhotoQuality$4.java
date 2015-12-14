// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.setting;


// Referenced classes of package com.cyberlink.youcammakeup.setting:
//            PhotoQuality

class 
{

    static final int a[];

    static 
    {
        a = new int[PhotoQuality.values().length];
        try
        {
            a[PhotoQuality.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[PhotoQuality.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
