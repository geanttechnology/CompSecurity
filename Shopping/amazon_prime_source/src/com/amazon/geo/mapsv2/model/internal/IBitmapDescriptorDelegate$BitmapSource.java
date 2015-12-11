// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.internal;


// Referenced classes of package com.amazon.geo.mapsv2.model.internal:
//            IBitmapDescriptorDelegate

public static final class Q extends Enum
{

    private static final RSRC_ID $VALUES[];
    public static final RSRC_ID ABS_PATH;
    public static final RSRC_ID ASSET;
    public static final RSRC_ID BITMAP;
    public static final RSRC_ID DEFAULT;
    public static final RSRC_ID DEFAULT_HUE;
    public static final RSRC_ID FILE_NAME;
    public static final RSRC_ID RSRC_ID;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/amazon/geo/mapsv2/model/internal/IBitmapDescriptorDelegate$BitmapSource, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        DEFAULT_HUE = new <init>("DEFAULT_HUE", 1);
        ASSET = new <init>("ASSET", 2);
        BITMAP = new <init>("BITMAP", 3);
        FILE_NAME = new <init>("FILE_NAME", 4);
        ABS_PATH = new <init>("ABS_PATH", 5);
        RSRC_ID = new <init>("RSRC_ID", 6);
        $VALUES = (new .VALUES[] {
            DEFAULT, DEFAULT_HUE, ASSET, BITMAP, FILE_NAME, ABS_PATH, RSRC_ID
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
