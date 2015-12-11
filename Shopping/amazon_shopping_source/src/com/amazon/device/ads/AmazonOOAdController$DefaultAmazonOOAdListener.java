// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            DefaultAdListener, AmazonOOAdListener, AmazonOOAdController, Log, 
//            AmazonOOActionCode, Ad, AmazonOOAdResponse

private class this._cls0 extends DefaultAdListener
    implements AmazonOOAdListener
{

    final AmazonOOAdController this$0;

    public AmazonOOActionCode onAdReceived(Ad ad, AmazonOOAdResponse amazonooadresponse)
    {
        Log.d(LOG_TAG, "Default ad listener called - Ad Received.");
        return AmazonOOActionCode.DISPLAY;
    }

    public void onSpecialUrlClicked(Ad ad, String s)
    {
        Log.d(LOG_TAG, "Default ad listener called - Special URL clicked. Url: %s", new Object[] {
            s
        });
    }

    public ()
    {
        this$0 = AmazonOOAdController.this;
        super("AmazonOOAdController");
    }
}
