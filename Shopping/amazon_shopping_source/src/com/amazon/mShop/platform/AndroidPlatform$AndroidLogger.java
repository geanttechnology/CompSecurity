// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.platform;

import android.util.Log;
import com.amazon.rio.j2me.client.util.Logger;

// Referenced classes of package com.amazon.mShop.platform:
//            AndroidPlatform

private static class tag
    implements Logger
{

    private final String tag;

    public void error(String s)
    {
        Log.e(tag, s);
    }

    public void info(String s)
    {
        Log.i(tag, s);
    }

    public (Class class1)
    {
        tag = class1.toString();
    }
}
