// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.fragments:
//            BackedUpFragment

class 
    implements Runnable
{

    String ext[] = {
        ".apk"
    };
    File file;
    final is._cls0 this$1;

    public void run()
    {
        BackedUpFragment.access$6(_fld0, file, ext);
        BackedUpFragment.access$7(_fld0).sendEmptyMessage(0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
        file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIO_BACKUPAPP").toString());
    }

    // Unreferenced inner class com/aio/downloader/fragments/BackedUpFragment$2

/* anonymous class */
    class BackedUpFragment._cls2 extends BroadcastReceiver
    {

        final BackedUpFragment this$0;

        public void onReceive(Context context, Intent intent)
        {
            Log.e("backup", "onClickReceiver");
            BackedUpFragment.access$5(BackedUpFragment.this, new ArrayList());
            if (Environment.getExternalStorageState().equals("mounted"))
            {
                if (BackedUpFragment.access$3(BackedUpFragment.this).size() == 0)
                {
                    (new Thread(new BackedUpFragment._cls2._cls1())).start();
                }
                return;
            } else
            {
                Toast.makeText(getActivity(), "Please insert an external storage device..", 1).show();
                return;
            }
        }


            
            {
                this$0 = BackedUpFragment.this;
                super();
            }
    }

}
