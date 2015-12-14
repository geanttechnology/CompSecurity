// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;


// Referenced classes of package com.picsart.shop:
//            a

final class Error
{

    static final int a[];

    static 
    {
        a = new int[com.picsart.studio.artContext.MemoryType.values().length];
        try
        {
            a[com.picsart.studio.artContext.MemoryType.LOW.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[com.picsart.studio.artContext.MemoryType.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.picsart.studio.artContext.MemoryType.NORMAL_PLUS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.picsart.studio.artContext.MemoryType.HIGH.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.picsart.studio.artContext.MemoryType.XHIGH.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.picsart.studio.artContext.MemoryType.XXHIGH.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
