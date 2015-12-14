// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;


// Referenced classes of package com.amazon.gallery.thor.cds:
//            SyncNotificationObserver

private static final class  extends Enum
{

    private static final INCREMENTAL $VALUES[];
    public static final INCREMENTAL COLDBOOT;
    public static final INCREMENTAL INCREMENTAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/cds/SyncNotificationObserver$SyncState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        COLDBOOT = new <init>("COLDBOOT", 0);
        INCREMENTAL = new <init>("INCREMENTAL", 1);
        $VALUES = (new .VALUES[] {
            COLDBOOT, INCREMENTAL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
