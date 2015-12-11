// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.SharedPreferences;
import android.view.View;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.WebFirstDialog;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.NetWorkUtil;
import com.umeng.analytics.MobclickAgent;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class val.dialog1
    implements android.view.ctivity.Mya1._cls3
{

    final val.dialog1 this$1;
    private final WebFirstDialog val$dialog1;

    public void onClick(View view)
    {
        if (MyMainActivity.access$4(cess._mth2(this._cls1.this)).getBoolean("isopen", false) && NetWorkUtil.getAPNType(cess._mth2(this._cls1.this)) != 1)
        {
            MyMainActivity.access$5(cess._mth2(this._cls1.this));
            return;
        }
        if (MyMainActivity.access$6(cess._mth2(this._cls1.this)).queryfile(MyMainActivity.access$18(cess._mth2(this._cls1.this)).getId()) == null)
        {
            cess._mth2(this._cls1.this).MydownloadApk(MyMainActivity.access$18(cess._mth2(this._cls1.this)).getId(), MyMainActivity.access$18(cess._mth2(this._cls1.this)).getTitle(), MyMainActivity.access$18(cess._mth2(this._cls1.this)).getIcon(), MyMainActivity.access$18(cess._mth2(this._cls1.this)).getSerial());
        } else
        {
            MyMainActivity.access$17(cess._mth2(this._cls1.this));
        }
        if (cess._mth2(this._cls1.this).callerD)
        {
            if (MyMainActivity.access$6(cess._mth2(this._cls1.this)).queryfile("com.freepezzle.hexcrush") == null)
            {
                MobclickAgent.onEvent(cess._mth2(this._cls1.this).getApplicationContext(), "web_caller_click");
                cess._mth2(this._cls1.this).MydownloadApk("com.freepezzle.hexcrush", "HEX Crush", "http://android.downloadatoz.com/_201409/img/hex512.png", 8964);
            } else
            {
                MyMainActivity.access$17(cess._mth2(this._cls1.this));
            }
        }
        val$dialog1.dismiss();
    }

    ()
    {
        this$1 = final_;
        val$dialog1 = WebFirstDialog.this;
        super();
    }
}
