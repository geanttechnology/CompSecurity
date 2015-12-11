// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.view.Window;

// Referenced classes of package com.flurry.android:
//            n

final class s
{

    s()
    {
    }

    public static void a(Window window)
    {
        while (window == null || n.SDK_INT < 11) 
        {
            return;
        }
        window.setFlags(0x1000000, 0x1000000);
    }
}
