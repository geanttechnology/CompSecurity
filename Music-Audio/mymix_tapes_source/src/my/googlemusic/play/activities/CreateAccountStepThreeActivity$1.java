// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.adapters.search.SearchUserAdapter;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.utils.views.RobotoTextView;

// Referenced classes of package my.googlemusic.play.activities:
//            CreateAccountStepThreeActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final CreateAccountStepThreeActivity this$0;

    public void onFailure(Response response)
    {
        CreateAccountStepThreeActivity.access$602(CreateAccountStepThreeActivity.this, new ArrayList());
        CreateAccountStepThreeActivity.access$702(CreateAccountStepThreeActivity.this, new SearchUserAdapter(CreateAccountStepThreeActivity.this, CreateAccountStepThreeActivity.access$600(CreateAccountStepThreeActivity.this), CreateAccountStepThreeActivity.access$800(CreateAccountStepThreeActivity.this).getUser(), CreateAccountStepThreeActivity.this, CreateAccountStepThreeActivity.access$800(CreateAccountStepThreeActivity.this)));
        ewHolder.access._mth300(CreateAccountStepThreeActivity.access$900(CreateAccountStepThreeActivity.this)).setAdapter(CreateAccountStepThreeActivity.access$700(CreateAccountStepThreeActivity.this));
        CreateAccountStepThreeActivity.access$1100(CreateAccountStepThreeActivity.this, false);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (obj instanceof List)
        {
            CreateAccountStepThreeActivity.access$602(CreateAccountStepThreeActivity.this, (List)obj);
            CreateAccountStepThreeActivity.access$702(CreateAccountStepThreeActivity.this, new SearchUserAdapter(CreateAccountStepThreeActivity.this, CreateAccountStepThreeActivity.access$600(CreateAccountStepThreeActivity.this), CreateAccountStepThreeActivity.access$800(CreateAccountStepThreeActivity.this).getUser(), CreateAccountStepThreeActivity.this, CreateAccountStepThreeActivity.access$800(CreateAccountStepThreeActivity.this)));
            ewHolder.access._mth300(CreateAccountStepThreeActivity.access$900(CreateAccountStepThreeActivity.this)).setAdapter(CreateAccountStepThreeActivity.access$700(CreateAccountStepThreeActivity.this));
            if (CreateAccountStepThreeActivity.access$600(CreateAccountStepThreeActivity.this).size() == 0)
            {
                CreateAccountStepThreeActivity.access$1000(CreateAccountStepThreeActivity.this, true);
                CreateAccountStepThreeActivity.access$1100(CreateAccountStepThreeActivity.this, false);
            } else
            {
                ewHolder.access._mth500(CreateAccountStepThreeActivity.access$900(CreateAccountStepThreeActivity.this)).setText((new StringBuilder()).append(CreateAccountStepThreeActivity.access$600(CreateAccountStepThreeActivity.this).size()).append("").toString());
            }
            CreateAccountStepThreeActivity.access$1100(CreateAccountStepThreeActivity.this, false);
        }
    }

    ewHolder()
    {
        this$0 = CreateAccountStepThreeActivity.this;
        super();
    }
}
