// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.os.AsyncTask;
import android.os.Handler;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            EpisodeDetailActivity

class this._cls0 extends AsyncTask
{

    final EpisodeDetailActivity this$0;

    protected transient Boolean doInBackground(Void avoid[])
    {
        return Boolean.valueOf(((PlayerUserSettings)EpisodeDetailActivity.access$000(EpisodeDetailActivity.this).getUserSettings()).getHasSeenMenuOptions());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        if (!boolean1.booleanValue())
        {
            (new Handler(getMainLooper())).postDelayed(new Runnable() {

                final EpisodeDetailActivity._cls1 this$1;

                public void run()
                {
                    openOptionsMenu();
                    ((PlayerUserSettings)EpisodeDetailActivity.access$100(this$0).getUserSettings()).setHasSeenMenuOptions(true);
                    EpisodeDetailActivity.access$200(this$0).saveUserAsync();
                }

            
            {
                this$1 = EpisodeDetailActivity._cls1.this;
                super();
            }
            }, 200L);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    _cls1.this._cls1()
    {
        this$0 = EpisodeDetailActivity.this;
        super();
    }
}
