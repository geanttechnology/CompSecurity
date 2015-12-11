// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;


// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class  extends Enum
{

    public static final EDownload EDownload;
    private static final EDownload ENUM$VALUES[];
    public static final EDownload EUpload;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/utility/CommonUtil$BearerAction, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        EUpload = new <init>("EUpload", 0);
        EDownload = new <init>("EDownload", 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            EUpload, EDownload
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
