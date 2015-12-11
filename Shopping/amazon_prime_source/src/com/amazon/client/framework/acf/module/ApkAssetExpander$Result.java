// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;


// Referenced classes of package com.amazon.client.framework.acf.module:
//            ApkAssetExpander

public static final class  extends Enum
{

    private static final FAIL_BADARG $VALUES[];
    public static final FAIL_BADARG FAIL_BADARG;
    public static final FAIL_BADARG FAIL_BADREAD;
    public static final FAIL_BADARG FAIL_BADWRITE;
    public static final FAIL_BADARG FAIL_CANCELLED;
    public static final FAIL_BADARG FAIL_CODEOPT;
    public static final FAIL_BADARG FAIL_NATIVE_LIB_EXPANSION;
    public static final FAIL_BADARG FAIL_RESOURCE_EXPANSION;
    public static final FAIL_BADARG OK;
    public static final FAIL_BADARG OK_NO_CHANGE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/client/framework/acf/module/ApkAssetExpander$Result, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OK = new <init>("OK", 0);
        OK_NO_CHANGE = new <init>("OK_NO_CHANGE", 1);
        FAIL_CANCELLED = new <init>("FAIL_CANCELLED", 2);
        FAIL_BADREAD = new <init>("FAIL_BADREAD", 3);
        FAIL_BADWRITE = new <init>("FAIL_BADWRITE", 4);
        FAIL_RESOURCE_EXPANSION = new <init>("FAIL_RESOURCE_EXPANSION", 5);
        FAIL_NATIVE_LIB_EXPANSION = new <init>("FAIL_NATIVE_LIB_EXPANSION", 6);
        FAIL_CODEOPT = new <init>("FAIL_CODEOPT", 7);
        FAIL_BADARG = new <init>("FAIL_BADARG", 8);
        $VALUES = (new .VALUES[] {
            OK, OK_NO_CHANGE, FAIL_CANCELLED, FAIL_BADREAD, FAIL_BADWRITE, FAIL_RESOURCE_EXPANSION, FAIL_NATIVE_LIB_EXPANSION, FAIL_CODEOPT, FAIL_BADARG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
