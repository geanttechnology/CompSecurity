// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.compat;


// Referenced classes of package com.playhaven.android.compat:
//            VendorCompat

public static final class  extends Enum
{

    private static final playhaven_dialog $VALUES[];
    public static final playhaven_dialog playhaven_activity;
    public static final playhaven_dialog playhaven_dialog;
    public static final playhaven_dialog playhaven_exit;
    public static final playhaven_dialog playhaven_loadinganim;
    public static final playhaven_dialog playhaven_overlay;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/playhaven/android/compat/VendorCompat$LAYOUT, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        playhaven_activity = new <init>("playhaven_activity", 0);
        playhaven_overlay = new <init>("playhaven_overlay", 1);
        playhaven_loadinganim = new <init>("playhaven_loadinganim", 2);
        playhaven_exit = new <init>("playhaven_exit", 3);
        playhaven_dialog = new <init>("playhaven_dialog", 4);
        $VALUES = (new .VALUES[] {
            playhaven_activity, playhaven_overlay, playhaven_loadinganim, playhaven_exit, playhaven_dialog
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
