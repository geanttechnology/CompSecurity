// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.model;


// Referenced classes of package com.poshmark.ui.model:
//            ActionErrorContext

public static final class  extends Enum
{

    private static final LOW $VALUES[];
    public static final LOW HIGH;
    public static final LOW LOW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/model/ActionErrorContext$Severity, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HIGH = new <init>("HIGH", 0);
        LOW = new <init>("LOW", 1);
        $VALUES = (new .VALUES[] {
            HIGH, LOW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
