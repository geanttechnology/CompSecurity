// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.adapters.search.SearchUserAdapter;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;

// Referenced classes of package my.googlemusic.play.activities:
//            CreateAccountStepThreeActivity

class val.friendUser
    implements my.googlemusic.play.interfaces.val.friendUser
{

    final CreateAccountStepThreeActivity this$0;
    final User val$friendUser;

    public void onFailure(Response response)
    {
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        CreateAccountStepThreeActivity.access$700(CreateAccountStepThreeActivity.this).setFollowing(val$friendUser);
        CreateAccountStepThreeActivity.access$700(CreateAccountStepThreeActivity.this).notifyDataSetChanged();
    }

    ()
    {
        this$0 = final_createaccountstepthreeactivity;
        val$friendUser = User.this;
        super();
    }
}
