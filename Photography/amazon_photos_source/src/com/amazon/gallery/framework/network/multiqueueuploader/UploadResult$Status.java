// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadResult

static final class Q extends Enum
{

    private static final FAILED $VALUES[];
    public static final FAILED FAILED;
    public static final FAILED SUCCESSFUL;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadResult$Status, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        SUCCESSFUL = new <init>("SUCCESSFUL", 0);
        FAILED = new <init>("FAILED", 1);
        $VALUES = (new .VALUES[] {
            SUCCESSFUL, FAILED
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
