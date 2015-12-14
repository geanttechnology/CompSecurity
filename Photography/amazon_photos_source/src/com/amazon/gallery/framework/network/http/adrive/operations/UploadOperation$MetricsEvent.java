// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.adrive.operations;


// Referenced classes of package com.amazon.gallery.framework.network.http.adrive.operations:
//            UploadOperation

public static final class  extends Enum
{

    private static final UploadBandwidth $VALUES[];
    public static final UploadBandwidth S3Upload;
    public static final UploadBandwidth TotalUpload;
    public static final UploadBandwidth UploadBandwidth;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/http/adrive/operations/UploadOperation$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TotalUpload = new <init>("TotalUpload", 0);
        S3Upload = new <init>("S3Upload", 1);
        UploadBandwidth = new <init>("UploadBandwidth", 2);
        $VALUES = (new .VALUES[] {
            TotalUpload, S3Upload, UploadBandwidth
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
