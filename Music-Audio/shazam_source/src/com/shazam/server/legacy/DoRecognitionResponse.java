// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy;


// Referenced classes of package com.shazam.server.legacy:
//            ErrorBean, Recognition

public class DoRecognitionResponse
{

    private ErrorBean errorBean;
    private Recognition recognition;

    private DoRecognitionResponse()
    {
    }

    private DoRecognitionResponse(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        errorBean = Builder.access._mth000(builder);
        recognition = Builder.access._mth100(builder);
    }

    DoRecognitionResponse(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public ErrorBean getErrorBean()
    {
        return errorBean;
    }

    public Recognition getRecognition()
    {
        return recognition;
    }
}
