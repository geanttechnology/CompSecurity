// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;


// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

static final class EW_STATE
{

    static final int a[];

    static 
    {
        a = new int[EW_STATE.values().length];
        try
        {
            a[EW_STATE.RESIZED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[EW_STATE.EXPANDED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[EW_STATE.DEFAULT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
