// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.model;


// Referenced classes of package com.gotv.crackle.captions.model:
//            CaptionSettings

public static final class  extends Enum
{

    private static final DropShadow $VALUES[];
    public static final DropShadow Depressed;
    public static final DropShadow DropShadow;
    public static final DropShadow None;
    public static final DropShadow Raised;
    public static final DropShadow Uniform;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/gotv/crackle/captions/model/CaptionSettings$CaptionEffects, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        Raised = new <init>("Raised", 1);
        Depressed = new <init>("Depressed", 2);
        Uniform = new <init>("Uniform", 3);
        DropShadow = new <init>("DropShadow", 4);
        $VALUES = (new .VALUES[] {
            None, Raised, Depressed, Uniform, DropShadow
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
