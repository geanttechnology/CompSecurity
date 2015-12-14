// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;


// Referenced classes of package com.picsart.studio.view:
//            SlidingUpPanelLayout

final class nelState
{

    static final int a[];

    static 
    {
        a = new int[nelState.values().length];
        try
        {
            a[nelState.EXPANDED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[nelState.ANCHORED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[nelState.HIDDEN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
