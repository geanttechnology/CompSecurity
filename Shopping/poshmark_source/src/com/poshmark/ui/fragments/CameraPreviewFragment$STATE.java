// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            CameraPreviewFragment

static final class  extends Enum
{

    private static final PICK_IMAGE_NO_CAMERA_PRESENT $VALUES[];
    public static final PICK_IMAGE_NO_CAMERA_PRESENT INIT;
    public static final PICK_IMAGE_NO_CAMERA_PRESENT PICK_IMAGE_NO_CAMERA_PRESENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/CameraPreviewFragment$STATE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INIT = new <init>("INIT", 0);
        PICK_IMAGE_NO_CAMERA_PRESENT = new <init>("PICK_IMAGE_NO_CAMERA_PRESENT", 1);
        $VALUES = (new .VALUES[] {
            INIT, PICK_IMAGE_NO_CAMERA_PRESENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
