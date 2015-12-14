// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.login.Loader;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            CreateAccountStepTwoActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final CreateAccountStepTwoActivity this$0;

    public void onFailure(Response response)
    {
        if (response.getStatus() == 7)
        {
            Toast.with(CreateAccountStepTwoActivity.this).message(response.getContent()).show();
        }
        CreateAccountStepTwoActivity.access$700(CreateAccountStepTwoActivity.this, true, "");
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
label0:
        {
            if (obj instanceof User)
            {
                CreateAccountStepTwoActivity.access$700(CreateAccountStepTwoActivity.this, false, "Uploading user photo...");
                if (CreateAccountStepTwoActivity.access$800(CreateAccountStepTwoActivity.this) == null)
                {
                    break label0;
                }
    /* block-local class not found */
    class _cls1 {}

                CreateAccountStepTwoActivity.access$1000(CreateAccountStepTwoActivity.this).uploadImageUser(CreateAccountStepTwoActivity.access$800(CreateAccountStepTwoActivity.this), new _cls1());
                Toast.with(CreateAccountStepTwoActivity.this).message(((User)obj).getMessage()).show();
            }
            return;
        }
        CreateAccountStepTwoActivity.access$900(CreateAccountStepTwoActivity.this).initLoader();
    }

    _cls1()
    {
        this$0 = CreateAccountStepTwoActivity.this;
        super();
    }
}
