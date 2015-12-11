// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            WebRequest

public class status extends Exception
{

    private static final long serialVersionUID = 0xbae28aed93d1c9f4L;
    private final status status;
    final WebRequest this$0;

    public status getStatus()
    {
        return status;
    }

    protected ( , String s)
    {
        this(, s, null);
    }

    protected <init>(<init> <init>1, String s, Throwable throwable)
    {
        this$0 = WebRequest.this;
        super(s, throwable);
        status = <init>1;
    }
}
