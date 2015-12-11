// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.os.AsyncTask;
import android.os.Handler;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesDetailActivity

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        openOptionsMenu();
        ((PlayerUserSettings)SeriesDetailActivity.access$100(_fld0).getUserSettings()).setHasSeenMenuOptions(true);
        SeriesDetailActivity.access$200(_fld0).saveUserAsync();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/SeriesDetailActivity$1

/* anonymous class */
    class SeriesDetailActivity._cls1 extends AsyncTask
    {

        final SeriesDetailActivity this$0;

        protected transient Boolean doInBackground(Void avoid[])
        {
            return Boolean.valueOf(((PlayerUserSettings)SeriesDetailActivity.access$000(SeriesDetailActivity.this).getUserSettings()).getHasSeenMenuOptions());
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Boolean boolean1)
        {
            if (!boolean1.booleanValue())
            {
                (new Handler(getMainLooper())).postDelayed(new SeriesDetailActivity._cls1._cls1(), 200L);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Boolean)obj);
        }

            
            {
                this$0 = SeriesDetailActivity.this;
                super();
            }
    }

}
