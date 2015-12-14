// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import com.picsart.studio.utils.ItemControl;

// Referenced classes of package com.picsart.shop:
//            h

final class Error
{

    static final int a[];

    static 
    {
        a = new int[ItemControl.values().length];
        try
        {
            a[ItemControl.BANNER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
    }
}
