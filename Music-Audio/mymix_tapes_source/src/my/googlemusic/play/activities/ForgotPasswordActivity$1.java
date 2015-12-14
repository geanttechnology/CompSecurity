// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            ForgotPasswordActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final ForgotPasswordActivity this$0;

    public void onFailure(Response response)
    {
        if (response.getStatus() == 7)
        {
            Toast.with(ForgotPasswordActivity.this).message(response.getContent()).show();
        }
        ForgotPasswordActivity.access$000(ForgotPasswordActivity.this, true);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        Toast.with(ForgotPasswordActivity.this).message("Email sent successfully.").show();
        ForgotPasswordActivity.access$000(ForgotPasswordActivity.this, true);
    }

    ()
    {
        this$0 = ForgotPasswordActivity.this;
        super();
    }
}
