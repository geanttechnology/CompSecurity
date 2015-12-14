// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.model.tags;


// Referenced classes of package com.amazon.gallery.framework.model.tags:
//            TagProperty, CommonTagProperty

public static final class  extends Enum
    implements TagProperty
{

    private static final UPLOADED $VALUES[];
    public static final UPLOADED NOT_UPLOADED;
    public static final UPLOADED NO_UPLOAD_STATE;
    public static final UPLOADED UPLOADED;
    public static final UPLOADED UPLOADING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/model/tags/CommonTagProperty$Status, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_UPLOAD_STATE = new <init>("NO_UPLOAD_STATE", 0);
        NOT_UPLOADED = new <init>("NOT_UPLOADED", 1);
        UPLOADING = new <init>("UPLOADING", 2);
        UPLOADED = new <init>("UPLOADED", 3);
        $VALUES = (new .VALUES[] {
            NO_UPLOAD_STATE, NOT_UPLOADED, UPLOADING, UPLOADED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
