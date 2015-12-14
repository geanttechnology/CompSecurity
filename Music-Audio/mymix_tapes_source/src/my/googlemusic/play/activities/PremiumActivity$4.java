// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.premium.google.IabHelper;
import my.googlemusic.play.utils.premium.google.SecurityKey;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            PremiumActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final PremiumActivity this$0;

    public void onFailure(Response response)
    {
        Toast.with(PremiumActivity.this).message(response.toString()).show();
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        PremiumActivity.access$602(PremiumActivity.this, (String)obj);
        PremiumActivity.access$602(PremiumActivity.this, SecurityKey.convertKey(PremiumActivity.access$600(PremiumActivity.this)));
        PremiumActivity.access$102(PremiumActivity.this, new IabHelper(PremiumActivity.this, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkCey22BSZfedKg1H8kUpzbPzx+MRJFvv1vs32o+1+FlZB0Xp1M77M05Tu8Ds0UR6SielCHWcAy1ScB9uErKisFiznyreWUYBhUnPBCz6061RrjLkRxbcEkM9/LR6BFSj+UjSlHaSMmhUXhxvzWpCzf5G19Uk5KiMj/+gOUxoO/+04QWx6EgdiTPogfbxMcar4BLO4lvBi+tw03VdWBZ6W2KZajQEXkx8kENbfl2wVWEB6v5XHpIFYQ5vDv0eMQZv6jaHl7iwYAJp2xMYzYa82pQNzEfnTX47SZnjueC9wTmDKRtexfagARRbcEVAvOLbZPnb7mXXcKapyHJDehMq6wIDAQAB"));
        PremiumActivity.access$100(PremiumActivity.this).enableDebugLogging(false);
    /* block-local class not found */
    class _cls1 {}

        PremiumActivity.access$100(PremiumActivity.this).startSetup(new _cls1());
    }

    _cls1()
    {
        this$0 = PremiumActivity.this;
        super();
    }
}
