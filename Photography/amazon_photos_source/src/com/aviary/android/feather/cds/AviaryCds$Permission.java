// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCds

public static final class _cls9 extends Enum
{

    private static final kill $VALUES[];
    public static final kill hires;
    public static final kill kill;
    public static final kill whitelabel;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$Permission, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        hires = new <init>("hires", 0);
        whitelabel = new <init>("whitelabel", 1);
        kill = new <init>("kill", 2);
        $VALUES = (new .VALUES[] {
            hires, whitelabel, kill
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
