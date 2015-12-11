// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.adapter:
//            AppGridviewAdapter

class val.in_fo
    implements Runnable
{

    final tId this$1;
    private final DownloadMovieItem val$in_fo;

    public void run()
    {
        try
        {
            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(val$in_fo.getId()).append("&from=google").toString());
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    l.has_apk()
    {
        this$1 = final_has_apk;
        val$in_fo = DownloadMovieItem.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/AppGridviewAdapter$2

/* anonymous class */
    class AppGridviewAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final AppGridviewAdapter this$0;
        private final String val$has_apk;
        private final DownloadMovieItem val$in_fo;

        public void onClick(View view)
        {
            AppGridviewAdapter.access$2(AppGridviewAdapter.this).edit().putString("appname", in_fo.getTitle()).commit();
            if (!has_apk.equals("1")) goto _L2; else goto _L1
_L1:
            (new Thread(new AppGridviewAdapter._cls2._cls1())).start();
            if (!AppGridviewAdapter.access$4(AppGridviewAdapter.this).getBoolean("isopen", false) || NetWorkUtil.getAPNType(AppGridviewAdapter.access$0(AppGridviewAdapter.this)) == 1) goto _L4; else goto _L3
_L3:
            AppGridviewAdapter.access$5(AppGridviewAdapter.this);
_L6:
            return;
_L4:
            if (AppGridviewAdapter.access$6(AppGridviewAdapter.this).queryfile(in_fo.getId()) == null)
            {
                MydownloadApk(in_fo.getId(), in_fo.getTitle(), in_fo.getIcon(), in_fo.getSerial());
                return;
            }
            try
            {
                Toast.makeText(AppGridviewAdapter.access$0(AppGridviewAdapter.this), "It has been in downloading list already.", 1).show();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return;
            }
_L2:
            if (has_apk.equals("0"))
            {
                (new Thread(in_fo. new AppGridviewAdapter._cls2._cls2())).start();
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(in_fo.getId()).toString()));
                AppGridviewAdapter.access$0(AppGridviewAdapter.this).startActivity(view);
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                this$0 = final_appgridviewadapter;
                in_fo = downloadmovieitem;
                has_apk = String.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/adapter/AppGridviewAdapter$2$1

/* anonymous class */
        class AppGridviewAdapter._cls2._cls1
            implements Runnable
        {

            final AppGridviewAdapter._cls2 this$1;
            private final DownloadMovieItem val$in_fo;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(in_fo.getId()).append("&from=apk").toString());
            }

                    
                    {
                        this$1 = AppGridviewAdapter._cls2.this;
                        in_fo = downloadmovieitem;
                        super();
                    }
        }

    }

}
