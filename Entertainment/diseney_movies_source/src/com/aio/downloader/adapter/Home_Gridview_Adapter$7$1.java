// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Gridview_Adapter

class val.myPosition
    implements Runnable
{

    final  this$1;
    private final int val$myPosition;

    public void run()
    {
        Log.e("bbb", (new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(_fld0).get(val$myPosition)).getId()).append("&from=apk").toString());
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(_fld0).get(val$myPosition)).getId()).append("&from=apk").toString());
    }

    l.mHas_apk()
    {
        this$1 = final_mhas_apk;
        val$myPosition = I.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/Home_Gridview_Adapter$7

/* anonymous class */
    class Home_Gridview_Adapter._cls7
        implements android.view.View.OnClickListener
    {

        final Home_Gridview_Adapter this$0;
        private final String val$mHas_apk;
        private final int val$myPosition;

        public void onClick(View view)
        {
            Home_Gridview_Adapter.access$2(Home_Gridview_Adapter.this).edit().putString("appname", ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getTitle()).commit();
            if (!mHas_apk.equals("1")) goto _L2; else goto _L1
_L1:
            (new Thread(myPosition. new Home_Gridview_Adapter._cls7._cls1())).start();
            if (Home_Gridview_Adapter.access$10(Home_Gridview_Adapter.this).getBoolean("isopen", false) && NetWorkUtil.getAPNType(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this)) != 1)
            {
                Home_Gridview_Adapter.access$11(Home_Gridview_Adapter.this);
                return;
            }
            if (Home_Gridview_Adapter.access$12(Home_Gridview_Adapter.this).queryfile(((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getId()) == null)
            {
                MydownloadApk(((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getId(), ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getTitle(), ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getIcon(), ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getSerial());
            } else
            {
                try
                {
                    Toast.makeText(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), "It has been in downloading list already.", 1).show();
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
            }
_L4:
            (new Handler()).post(new Home_Gridview_Adapter._cls7._cls3());
            return;
_L2:
            if (mHas_apk.equals("0"))
            {
                (new Thread(new Home_Gridview_Adapter._cls7._cls2())).start();
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getId()).toString()));
                Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this).startActivity(view);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }


            
            {
                this$0 = final_home_gridview_adapter;
                myPosition = i;
                mHas_apk = String.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/adapter/Home_Gridview_Adapter$7$2

/* anonymous class */
        class Home_Gridview_Adapter._cls7._cls2
            implements Runnable
        {

            final Home_Gridview_Adapter._cls7 this$1;
            private final int val$myPosition;

            public void run()
            {
                try
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(this$0).get(myPosition)).getId()).append("&from=google").toString());
                    return;
                }
                catch (Exception exception)
                {
                    return;
                }
            }

                    
                    {
                        this$1 = Home_Gridview_Adapter._cls7.this;
                        myPosition = i;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/adapter/Home_Gridview_Adapter$7$3

/* anonymous class */
        class Home_Gridview_Adapter._cls7._cls3
            implements Runnable
        {

            final Home_Gridview_Adapter._cls7 this$1;

            public void run()
            {
                Home_Gridview_Adapter.access$5(this$0).dismiss();
            }

                    
                    {
                        this$1 = Home_Gridview_Adapter._cls7.this;
                        super();
                    }
        }

    }

}
