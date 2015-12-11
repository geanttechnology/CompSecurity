// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import com.aio.downloader.dialog.UpdateDialogVerison;
import com.aio.downloader.dialog.UpdateDialogVerison2;
import com.aio.downloader.model.GameInfosVersionModel;
import com.aio.downloader.utils.Myutils;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class val.ntPath
    implements android.view.r
{

    final tActivity this$1;
    private final String val$ntPath;

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165530: 
            updateDialogVersion2.dismiss();
            return;

        case 2131165531: 
            view = new Intent("android.intent.action.VIEW", Uri.parse(val$ntPath));
            break;
        }
        updateDialogVersion2.dismiss();
        startActivity(view);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$ntPath = String.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/MyMainActivity$7

/* anonymous class */
    class MyMainActivity._cls7 extends Handler
    {

        final MyMainActivity this$0;

        public void handleMessage(Message message)
        {
            if (message.what == 564 && MyMainActivity.access$14(MyMainActivity.this))
            {
                info = (GameInfosVersionModel)message.obj;
                message = info.getNtId();
                MyMainActivity.access$0(MyMainActivity.this, info.getUpdatePath());
                if (!MyMainActivity.access$1(MyMainActivity.this).equals(""))
                {
                    Log.v("version", "777777");
                    android.view.View.OnClickListener onclicklistener = new MyMainActivity._cls7._cls1();
                    updateDialogVersion = new UpdateDialogVerison(MyMainActivity.this, 0x7f0c0010, onclicklistener);
                    updateDialogVersion.setCanceledOnTouchOutside(false);
                    try
                    {
                        updateDialogVersion.setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
                    }
                    catch (Exception exception) { }
                }
                if (message != null && !"".equals(message))
                {
                    try
                    {
                        packageInfo = getPackageManager().getPackageInfo(message, 0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Message message)
                    {
                        packageInfo = null;
                        message.printStackTrace();
                    }
                    message = info.getNtPath();
                    if (packageInfo == null && message != null && !"".equals(message))
                    {
                        itemsOnClick2 = message. new MyMainActivity._cls7._cls2();
                        message = new Message();
                        message.what = 10000;
                        handlertimer.sendMessageDelayed(message, 5000L);
                        Log.v("ppp", "10000");
                    }
                }
            }
        }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/activity/MyMainActivity$7$1

/* anonymous class */
        class MyMainActivity._cls7._cls1
            implements android.view.View.OnClickListener
        {

            final MyMainActivity._cls7 this$1;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                default:
                    return;

                case 2131165527: 
                    updateDialogVersion.dismiss();
                    return;

                case 2131165528: 
                    view = new Intent("android.intent.action.VIEW", Uri.parse(MyMainActivity.access$1(this$0)));
                    break;
                }
                updateDialogVersion.dismiss();
                startActivity(view);
            }

                    
                    {
                        this$1 = MyMainActivity._cls7.this;
                        super();
                    }
        }

    }

}
