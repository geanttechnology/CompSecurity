// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;


// Referenced classes of package com.amazon.gallery.framework.gallery.crop:
//            CropActivity

public static final class I extends Enum
{

    private static final LoadBitmapFailure $VALUES[];
    public static final LoadBitmapFailure CropFailedBitmap;
    public static final LoadBitmapFailure CropFailedUri;
    public static final LoadBitmapFailure CropSuccessBitmap;
    public static final LoadBitmapFailure CropSuccessUri;
    public static final LoadBitmapFailure LoadBitmapFailure;
    public static final LoadBitmapFailure LoadBitmapSuccess;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/amazon/gallery/framework/gallery/crop/CropActivity$MetricsEvent, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        CropSuccessUri = new <init>("CropSuccessUri", 0);
        CropSuccessBitmap = new <init>("CropSuccessBitmap", 1);
        CropFailedUri = new <init>("CropFailedUri", 2);
        CropFailedBitmap = new <init>("CropFailedBitmap", 3);
        LoadBitmapSuccess = new <init>("LoadBitmapSuccess", 4);
        LoadBitmapFailure = new <init>("LoadBitmapFailure", 5);
        $VALUES = (new .VALUES[] {
            CropSuccessUri, CropSuccessBitmap, CropFailedUri, CropFailedBitmap, LoadBitmapSuccess, LoadBitmapFailure
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
