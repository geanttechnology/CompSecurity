// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;


// Referenced classes of package com.inmobi.ads:
//            AdUnit

public static final class  extends Enum
{

    private static final STATE_ACTIVE $VALUES[];
    public static final STATE_ACTIVE STATE_ACTIVE;
    public static final STATE_ACTIVE STATE_ATTACHED;
    public static final STATE_ACTIVE STATE_AVAILABLE;
    public static final STATE_ACTIVE STATE_CREATED;
    public static final STATE_ACTIVE STATE_FAILED;
    public static final STATE_ACTIVE STATE_LOADED;
    public static final STATE_ACTIVE STATE_LOADING;
    public static final STATE_ACTIVE STATE_READY;
    public static final STATE_ACTIVE STATE_RENDERED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/ads/AdUnit$AdState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STATE_CREATED = new <init>("STATE_CREATED", 0);
        STATE_LOADING = new <init>("STATE_LOADING", 1);
        STATE_AVAILABLE = new <init>("STATE_AVAILABLE", 2);
        STATE_FAILED = new <init>("STATE_FAILED", 3);
        STATE_LOADED = new <init>("STATE_LOADED", 4);
        STATE_READY = new <init>("STATE_READY", 5);
        STATE_ATTACHED = new <init>("STATE_ATTACHED", 6);
        STATE_RENDERED = new <init>("STATE_RENDERED", 7);
        STATE_ACTIVE = new <init>("STATE_ACTIVE", 8);
        $VALUES = (new .VALUES[] {
            STATE_CREATED, STATE_LOADING, STATE_AVAILABLE, STATE_FAILED, STATE_LOADED, STATE_READY, STATE_ATTACHED, STATE_RENDERED, STATE_ACTIVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
