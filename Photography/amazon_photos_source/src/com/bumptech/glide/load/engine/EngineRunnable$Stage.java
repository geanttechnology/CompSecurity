// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;


// Referenced classes of package com.bumptech.glide.load.engine:
//            EngineRunnable

private static final class _cls9 extends Enum
{

    private static final SOURCE $VALUES[];
    public static final SOURCE CACHE;
    public static final SOURCE SOURCE;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/bumptech/glide/load/engine/EngineRunnable$Stage, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        CACHE = new <init>("CACHE", 0);
        SOURCE = new <init>("SOURCE", 1);
        $VALUES = (new .VALUES[] {
            CACHE, SOURCE
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
