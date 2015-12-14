// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


public final class RequestCode extends Enum
{

    private static final RequestCode $VALUES[];
    public static final RequestCode CHOOSER;
    public static final RequestCode PC;

    private RequestCode(String s, int i)
    {
        super(s, i);
    }

    public static RequestCode valueOf(String s)
    {
        return (RequestCode)Enum.valueOf(com/amazon/gallery/thor/app/activity/RequestCode, s);
    }

    public static RequestCode[] values()
    {
        return (RequestCode[])$VALUES.clone();
    }

    static 
    {
        CHOOSER = new RequestCode("CHOOSER", 0);
        PC = new RequestCode("PC", 1);
        $VALUES = (new RequestCode[] {
            CHOOSER, PC
        });
    }
}
