// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;


// Referenced classes of package com.socialin.android.brushlib.controller:
//            ShapeOverlayController

final class apeType
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[apeEditingMode.values().length];
        try
        {
            b[apeEditingMode.DRAW.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[apeEditingMode.EDIT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        a = new int[apeType.values().length];
        try
        {
            a[apeType.LINE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[apeType.ARROW.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[apeType.SVG.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[apeType.CLIPART.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
