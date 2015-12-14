// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.removablestorage;


// Referenced classes of package com.amazon.gallery.thor.removablestorage:
//            RemovableStorageManager

public static final class  extends Enum
{

    private static final RemovableStorageSetAsPreference $VALUES[];
    public static final RemovableStorageSetAsPreference LocalStorageSetAsPreference;
    public static final RemovableStorageSetAsPreference MediaBadRemoval;
    public static final RemovableStorageSetAsPreference MediaMounted;
    public static final RemovableStorageSetAsPreference MediaUnmounted;
    public static final RemovableStorageSetAsPreference RemovableStorageSetAsPreference;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/removablestorage/RemovableStorageManager$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MediaMounted = new <init>("MediaMounted", 0);
        MediaBadRemoval = new <init>("MediaBadRemoval", 1);
        MediaUnmounted = new <init>("MediaUnmounted", 2);
        LocalStorageSetAsPreference = new <init>("LocalStorageSetAsPreference", 3);
        RemovableStorageSetAsPreference = new <init>("RemovableStorageSetAsPreference", 4);
        $VALUES = (new .VALUES[] {
            MediaMounted, MediaBadRemoval, MediaUnmounted, LocalStorageSetAsPreference, RemovableStorageSetAsPreference
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
