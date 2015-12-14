// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.internet.Response;
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
        Toast.with(PremiumActivity.this).message((String)obj).show();
        PremiumActivity.access$500(PremiumActivity.this);
    }

    ()
    {
        this$0 = PremiumActivity.this;
        super();
    }
}
