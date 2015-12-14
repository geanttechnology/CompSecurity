// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.layer;

import myobfuscated.ar.b;

// Referenced classes of package com.socialin.android.brushlib.layer:
//            BlendMode

final class 
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[myobfuscated.ar.b.values().length];
        try
        {
            b[b.NORMAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            b[b.MULTIPLY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            b[b.LIGHTEN.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            b[b.DARKEN.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            b[b.SCREEN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[b.XOR.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            b[b.ADD.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            b[b.OVERLAY.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        a = new int[BlendMode.values().length];
        try
        {
            a[BlendMode.ADD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[BlendMode.OVERLAY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
