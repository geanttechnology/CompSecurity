// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;


// Referenced classes of package com.aio.downloader.views:
//            DragLayout

public static final class  extends Enum
{

    public static final Close Close;
    public static final Close Drag;
    private static final Close ENUM$VALUES[];
    public static final Close Open;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aio/downloader/views/DragLayout$Status, s);
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
        Drag = new <init>("Drag", 0);
        Open = new <init>("Open", 1);
        Close = new <init>("Close", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            Drag, Open, Close
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
