// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.NoupdareversionDialog;
import com.aio.downloader.model.GameInfosVersionModel;
import com.aio.downloader.utils.NetWorkUtil;
import java.io.File;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends Handler
{

    final MyMainActivity this$0;

    public void handleMessage(final Message dialog)
    {
        if (dialog.what != 564) goto _L2; else goto _L1
_L1:
        dialog = (GameInfosVersionModel)dialog.obj;
        MyMainActivity.access$0(MyMainActivity.this, dialog.getUpdatePath());
        if (MyMainActivity.access$1(MyMainActivity.this).equals(""))
        {
            break MISSING_BLOCK_LABEL_168;
        }
        if (!MyMainActivity.access$2(MyMainActivity.this).exists()) goto _L4; else goto _L3
_L3:
        Log.e("bbb", "exists___exists");
        MyMainActivity.access$3(MyMainActivity.this);
_L2:
        return;
_L4:
        Log.e("bbb", "unexists___unexists");
        (new AsyncTask() {

            final MyMainActivity._cls2 this$1;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
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

            
            {
                this$1 = MyMainActivity._cls2.this;
                super();
            }
        }).execute(new Void[0]);
        if (MyMainActivity.access$4(MyMainActivity.this).getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
        {
            MyMainActivity.access$5(MyMainActivity.this);
            return;
        }
        if (MyMainActivity.access$6(MyMainActivity.this).queryfile("com.allinone.downloader") != null) goto _L2; else goto _L5
_L5:
        MydownloadApk1("com.allinone.downloader", "AIO Downloader", "http://img.android.downloadatoz.com/upload/android/other/201504/03/all-in-one-downloader-downloader-pn-1428055219.jpg", 0x2488ef);
        return;
        dialog = new NoupdareversionDialog(MyMainActivity.this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        ((TextView)dialog.findViewById(0x7f070140)).setText("Current version: 3.3.9 is the latest version.");
        ((Button)dialog.findViewById(0x7f07034d)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity._cls2 this$1;
            private final NoupdareversionDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$1 = MyMainActivity._cls2.this;
                dialog = noupdareversiondialog;
                super();
            }
        });
        return;
    }

    _cls2.val.dialog()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
