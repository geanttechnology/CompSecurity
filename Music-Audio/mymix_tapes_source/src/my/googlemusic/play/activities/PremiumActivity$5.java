// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import java.io.PrintStream;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.premium.google.SecurityKey;

// Referenced classes of package my.googlemusic.play.activities:
//            PremiumActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final PremiumActivity this$0;

    public void onFailure(Response response)
    {
        System.out.println((new StringBuilder()).append("fail get - ").append(response).toString());
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        System.out.println((new StringBuilder()).append("get - ").append(obj).toString());
        PremiumActivity.access$602(PremiumActivity.this, (String)obj);
        PremiumActivity.access$602(PremiumActivity.this, SecurityKey.convertKey(PremiumActivity.access$600(PremiumActivity.this)));
        System.out.println((new StringBuilder()).append("convert to - ").append(PremiumActivity.access$600(PremiumActivity.this)).toString());
    /* block-local class not found */
    class _cls1 {}

        PremiumActivity.access$700(PremiumActivity.this).sendPremiumPass(PremiumActivity.access$600(PremiumActivity.this), new _cls1());
    }

    _cls1()
    {
        this$0 = PremiumActivity.this;
        super();
    }
}
