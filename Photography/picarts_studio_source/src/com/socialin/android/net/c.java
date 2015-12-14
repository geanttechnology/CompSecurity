// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.net;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.socialin.android.d;
import java.io.File;

// Referenced classes of package com.socialin.android.net:
//            a, b, FileDownloadService

public final class c extends a
{

    public c(Context context)
    {
        super(context);
    }

    static void a(c c1, String s, String s1)
    {
        c1.a(s, s1);
    }

    private void a(String s, String s1)
    {
        Intent intent = new Intent();
        intent.setAction("intent.action.download.complete");
        intent.putExtra("download_status", 2);
        intent.putExtra("download_file_url", s);
        intent.putExtra("download_file_path", s1);
        c.a(intent);
    }

    public final long a(String s, String s1, String s2, String s3, boolean flag)
    {
        long l = s.hashCode();
        s2 = new File(s1);
        if (d.b)
        {
            (new StringBuilder("starting download, url: ")).append(s).append(" path: ").append(s1);
        }
        if (!s2.exists())
        {
            s2 = new Intent();
            s2.putExtra("download_file_url", s);
            s2.putExtra("download_file_path", s1);
            s2.putExtra("add_to_front", flag);
            s2.setClass(a, com/socialin/android/net/FileDownloadService);
            a.startService(s2);
        } else
        if (c != null)
        {
            if (Looper.getMainLooper().getThread() == Thread.currentThread() || !(a instanceof Activity))
            {
                a(s, s1);
                return l;
            } else
            {
                ((Activity)a).runOnUiThread(new Runnable(s, s1) {

                    private String a;
                    private String b;
                    private c c;

                    public final void run()
                    {
                        c.a(c, a, b);
                    }

            
            {
                c = c.this;
                a = s;
                b = s1;
                super();
            }
                });
                return l;
            }
        }
        return l;
    }

    public final BroadcastReceiver a()
    {
        b = new BroadcastReceiver() {

            private c a;

            public final void onReceive(Context context, Intent intent)
            {
                if (a.c != null)
                {
                    a.c.a(intent);
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        return b;
    }

    public final void b()
    {
        try
        {
            a.unregisterReceiver(b);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected final String c()
    {
        return "intent.action.download.complete";
    }
}
