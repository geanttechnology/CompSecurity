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

class val.has_apk
    implements android.view.viewAdapter._cls2
{

    final AppGridviewAdapter this$0;
    private final String val$has_apk;
    private final DownloadMovieItem val$in_fo;

    public void onClick(View view)
    {
        AppGridviewAdapter.access$2(AppGridviewAdapter.this).edit().putString("appname", val$in_fo.getTitle()).commit();
        if (!val$has_apk.equals("1")) goto _L2; else goto _L1
_L1:
        (new Thread(new Runnable() {

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
        })).start();
        if (!AppGridviewAdapter.access$4(AppGridviewAdapter.this).getBoolean("isopen", false) || NetWorkUtil.getAPNType(AppGridviewAdapter.access$0(AppGridviewAdapter.this)) == 1) goto _L4; else goto _L3
_L3:
        AppGridviewAdapter.access$5(AppGridviewAdapter.this);
_L6:
        return;
_L4:
        if (AppGridviewAdapter.access$6(AppGridviewAdapter.this).queryfile(val$in_fo.getId()) == null)
        {
            MydownloadApk(val$in_fo.getId(), val$in_fo.getTitle(), val$in_fo.getIcon(), val$in_fo.getSerial());
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
        if (val$has_apk.equals("0"))
        {
            (new Thread(new Runnable() {

                final AppGridviewAdapter._cls2 this$1;
                private final DownloadMovieItem val$in_fo;

                public void run()
                {
                    try
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(in_fo.getId()).append("&from=google").toString());
                        return;
                    }
                    catch (Exception exception)
                    {
                        return;
                    }
                }

            
            {
                this$1 = AppGridviewAdapter._cls2.this;
                in_fo = downloadmovieitem;
                super();
            }
            })).start();
            view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(val$in_fo.getId()).toString()));
            AppGridviewAdapter.access$0(AppGridviewAdapter.this).startActivity(view);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    _cls2.val.in_fo()
    {
        this$0 = final_appgridviewadapter;
        val$in_fo = downloadmovieitem;
        val$has_apk = String.this;
        super();
    }
}
