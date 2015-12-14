// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ai

class a
    implements android.view.OnClickListener
{

    final ai a;

    public void onClick(View view)
    {
        (new AsyncTask() {

            final ai._cls4 a;

            protected transient Void a(Void avoid[])
            {
                try
                {
                    if (ai.c(a.a) == null)
                    {
                        ai.d(a.a).take();
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
                return null;
            }

            protected void a(Void void1)
            {
                void1 = (new Intent(a.a.getActivity(), com/cyberlink/youcammakeup/activity/LauncherActivity)).setFlags(0x4000000);
                a.a.startActivity(void1);
                a.a.getActivity().finish();
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            protected void onPreExecute()
            {
                ai.a(a.a, false);
                b.a(new YMKAfterSavePhotoEvent(com.cyberlink.youcammakeup.clflurry.YMKAfterSavePhotoEvent.FeatureName.f));
            }

            
            {
                a = ai._cls4.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    _cls1.a(ai ai1)
    {
        a = ai1;
        super();
    }
}
