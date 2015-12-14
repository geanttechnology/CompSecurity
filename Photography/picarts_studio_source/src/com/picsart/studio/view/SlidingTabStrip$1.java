// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;


// Referenced classes of package com.picsart.studio.view:
//            SlidingTabStrip

final class dicatorPosition
{

    static final int a[];

    static 
    {
        a = new int[dicatorPosition.values().length];
        try
        {
            a[dicatorPosition.BOTTOM.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[dicatorPosition.TOP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
