// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AAXParameter, Settings

static class er extends er
{

    protected Boolean getDerivedValue(er er)
    {
        return Settings.getInstance().getBoolean("testingEnabled", null);
    }

    protected volatile Object getDerivedValue(er er)
    {
        return getDerivedValue(er);
    }

    er()
    {
        super("isTest", "debug.test");
    }
}
