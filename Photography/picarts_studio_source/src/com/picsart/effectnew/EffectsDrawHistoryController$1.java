// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;


// Referenced classes of package com.picsart.effectnew:
//            EffectsDrawHistoryController

final class fectDrawType
{

    static final int a[];

    static 
    {
        a = new int[fectDrawType.values().length];
        try
        {
            a[fectDrawType.DRAW_PATH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[fectDrawType.DRAW_SHAPE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[fectDrawType.INVERT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[fectDrawType.FILL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[fectDrawType.CLEAR.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
