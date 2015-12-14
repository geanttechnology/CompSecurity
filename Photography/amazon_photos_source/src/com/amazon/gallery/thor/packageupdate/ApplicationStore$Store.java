// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;


// Referenced classes of package com.amazon.gallery.thor.packageupdate:
//            ApplicationStore

public static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN AMAZON_APP_STORE;
    public static final UNKNOWN GOOGLE_PLAY;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/packageupdate/ApplicationStore$Store, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AMAZON_APP_STORE = new <init>("AMAZON_APP_STORE", 0);
        GOOGLE_PLAY = new <init>("GOOGLE_PLAY", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            AMAZON_APP_STORE, GOOGLE_PLAY, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
