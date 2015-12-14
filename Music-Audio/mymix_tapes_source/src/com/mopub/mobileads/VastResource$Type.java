// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            VastResource

static final class  extends Enum
{

    private static final IFRAME_RESOURCE $VALUES[];
    public static final IFRAME_RESOURCE HTML_RESOURCE;
    public static final IFRAME_RESOURCE IFRAME_RESOURCE;
    public static final IFRAME_RESOURCE STATIC_RESOURCE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/mobileads/VastResource$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STATIC_RESOURCE = new <init>("STATIC_RESOURCE", 0);
        HTML_RESOURCE = new <init>("HTML_RESOURCE", 1);
        IFRAME_RESOURCE = new <init>("IFRAME_RESOURCE", 2);
        $VALUES = (new .VALUES[] {
            STATIC_RESOURCE, HTML_RESOURCE, IFRAME_RESOURCE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
