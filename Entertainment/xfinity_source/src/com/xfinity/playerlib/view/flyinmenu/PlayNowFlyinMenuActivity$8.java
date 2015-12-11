// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.os.AsyncTask;
import android.os.Handler;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayNowFlyinMenuActivity

class this._cls0 extends AsyncTask
{

    final PlayNowFlyinMenuActivity this$0;

    protected transient Boolean doInBackground(Void avoid[])
    {
        return Boolean.valueOf(((PlayerUserSettings)userManager.getUserSettings()).getHasSeenMenuOptions());
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

                final PlayNowFlyinMenuActivity._cls8 this$1;

                public void run()
                {
                    openOptionsMenu();
                    ((PlayerUserSettings)userManager.getUserSettings()).setHasSeenMenuOptions(true);
                    userManager.saveUserAsync();
                }

            
            {
                this$1 = PlayNowFlyinMenuActivity._cls8.this;
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
        this$0 = PlayNowFlyinMenuActivity.this;
        super();
    }
}
