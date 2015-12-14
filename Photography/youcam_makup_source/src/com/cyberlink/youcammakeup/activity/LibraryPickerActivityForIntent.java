// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.pf.common.utility.m;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity, SplashActivity, EditViewActivityForIntent

public class LibraryPickerActivityForIntent extends LibraryPickerActivity
{

    public static final UUID c = UUID.randomUUID();

    public LibraryPickerActivityForIntent()
    {
    }

    protected void a(Intent intent)
    {
        intent.putExtra("EXTRA_FINISH_ALL_ACTIVITIES", false);
    }

    protected LibraryPickerActivity.State k()
    {
        return new LibraryPickerActivity.State("editViewForIntent");
    }

    protected void l()
    {
        Globals.d().H();
        Globals.d().c(null);
        StatusManager.j().a(null, c);
        if (SplashActivity.a())
        {
            m.b("activity.LibraryPickerActivity", "Need to call parseAndMoveSampleImages()");
            b = false;
            (new AsyncTask() {

                final LibraryPickerActivityForIntent a;

                protected transient Void a(Void avoid[])
                {
                    SplashActivity.c();
                    SplashActivity.d();
                    return null;
                }

                protected void a(Void void1)
                {
                    a.b = true;
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                a = LibraryPickerActivityForIntent.this;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            b = true;
            return;
        }
    }

    protected void n()
    {
        Globals.d().c(null);
    }

    protected Class r()
    {
        return com/cyberlink/youcammakeup/activity/EditViewActivityForIntent;
    }

}
