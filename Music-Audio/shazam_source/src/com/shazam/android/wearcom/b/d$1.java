// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.wearcom.b;

import com.shazam.android.wearcom.service.a;

// Referenced classes of package com.shazam.android.wearcom.b:
//            d

public static final class e.a
{

    public static final int a[];

    static 
    {
        a = new int[com.shazam.android.wearcom.service.a.values().length];
        try
        {
            a[a.b.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[a.a.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
