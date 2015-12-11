// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdLoader, AdError

protected class adError extends Exception
{

    private static final long serialVersionUID = 1L;
    private final AdError adError;
    final AdLoader this$0;

    public AdError getAdError()
    {
        return adError;
    }

    public (AdError aderror)
    {
        this$0 = AdLoader.this;
        super();
        adError = aderror;
    }

    public adError(AdError aderror, Throwable throwable)
    {
        this$0 = AdLoader.this;
        super(throwable);
        adError = aderror;
    }
}
