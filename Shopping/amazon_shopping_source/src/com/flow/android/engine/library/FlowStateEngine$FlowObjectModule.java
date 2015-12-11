// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library;


// Referenced classes of package com.flow.android.engine.library:
//            FlowStateEngine

public static final class  extends Enum
{

    private static final DEEPLEARNING $VALUES[];
    public static final DEEPLEARNING BARCODE;
    public static final DEEPLEARNING DEEPLEARNING;
    public static final DEEPLEARNING IMAGEMATCH;
    public static final DEEPLEARNING LOGO;
    public static final DEEPLEARNING QRCODE;
    public static final DEEPLEARNING TEXT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/flow/android/engine/library/FlowStateEngine$FlowObjectModule, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IMAGEMATCH = new <init>("IMAGEMATCH", 0);
        BARCODE = new <init>("BARCODE", 1);
        QRCODE = new <init>("QRCODE", 2);
        TEXT = new <init>("TEXT", 3);
        LOGO = new <init>("LOGO", 4);
        DEEPLEARNING = new <init>("DEEPLEARNING", 5);
        $VALUES = (new .VALUES[] {
            IMAGEMATCH, BARCODE, QRCODE, TEXT, LOGO, DEEPLEARNING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
