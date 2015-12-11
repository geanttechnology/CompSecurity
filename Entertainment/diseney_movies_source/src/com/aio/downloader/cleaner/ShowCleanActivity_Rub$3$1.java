// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity_Rub

class this._cls1 extends AsyncTask
{

    final onPostExecute this$1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=com.evzapp.cleanmaster&from=apk");
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/cleaner/ShowCleanActivity_Rub$3

/* anonymous class */
    class ShowCleanActivity_Rub._cls3
        implements android.view.View.OnClickListener
    {

        final ShowCleanActivity_Rub this$0;

        public void onClick(View view)
        {
            try
            {
                (new ShowCleanActivity_Rub._cls3._cls1()).execute(new Void[0]);
                if (ShowCleanActivity_Rub.access$2(ShowCleanActivity_Rub.this).getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
                {
                    ShowCleanActivity_Rub.access$3(ShowCleanActivity_Rub.this);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }
            if (ShowCleanActivity_Rub.access$4(ShowCleanActivity_Rub.this).queryfile("com.evzapp.cleanmaster") == null)
            {
                MydownloadApk("com.evzapp.cleanmaster", "AIO Cleaner & Speed Booster", "https://lh3.googleusercontent.com/b8eWJD74_yw7BqWv0FER9nnJXX_7ihY1Y3pjxJ111xH6q_syFWRVGvcatpgiDaXiJk9l=w300", 0x149a37);
                return;
            }
            ShowCleanActivity_Rub.access$0(ShowCleanActivity_Rub.this);
            return;
        }

            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
    }

}
