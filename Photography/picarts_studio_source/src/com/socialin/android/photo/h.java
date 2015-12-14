// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.net.a;
import com.socialin.android.net.b;
import com.socialin.android.util.Utils;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo:
//            i, j, g

public final class h
    implements android.content.DialogInterface.OnCancelListener, b
{

    public int a;
    public String b;
    private long c;
    private Activity d;
    private ProgressDialog e;
    private Dialog f;
    private j g;

    public h(Activity activity, j j1)
    {
        a = -1;
        b = null;
        c = 0L;
        d = activity;
        g = j1;
    }

    public static void a(i k, int l, a a1)
    {
        int j1 = k.getCount();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (i1 != l)
            {
                a1.a(k.b(i1), k.c(i1), null, null, false);
            }
        }

        if (l < j1 && l >= 0)
        {
            a1.a(k.b(l), k.c(l), null, null, true);
        }
    }

    public final ProgressDialog a()
    {
        ProgressDialog progressdialog = null;
        if (e != null && e.isShowing())
        {
            progressdialog = e;
        } else
        {
            Activity activity = d;
            if (activity != null)
            {
                e = com.socialin.android.dialog.g.a(activity, null, activity.getString(0x7f08041c));
                e.setCancelable(true);
                e.setOnCancelListener(this);
                return e;
            }
        }
        return progressdialog;
    }

    public final void a(Intent intent)
    {
        Activity activity;
        if (d.b)
        {
            (new StringBuilder("downloadintent: ")).append(intent.toURI()).append(" pendingPath:").append(b);
        }
        activity = d;
        break MISSING_BLOCK_LABEL_40;
        while (true) 
        {
            int k;
            do
            {
                do
                {
                    return;
                } while (activity == null || !"intent.action.download.complete".equals(intent.getAction()));
                k = intent.getIntExtra("download_status", -1);
                intent = intent.getStringExtra("download_file_path");
                if (k != 1 && k != 2)
                {
                    break;
                }
                if (a != -1 && intent.equals(b))
                {
                    if (g != null)
                    {
                        g.a(a);
                    }
                    if (e != null && e.isShowing())
                    {
                        m.b(activity, e);
                    }
                    a = -1;
                    b = null;
                    return;
                }
            } while (true);
            m.b(activity, e);
            if (k == -1 && a != -1)
            {
                if (f == null)
                {
                    f = com.socialin.android.photo.g.a(activity);
                }
                if (!f.isShowing())
                {
                    f.show();
                }
            } else
            if (k == -2)
            {
                long l = System.currentTimeMillis();
                if (Math.abs(c - l) > 10000L)
                {
                    Utils.a(activity, 0x7f080342);
                    c = l;
                }
            }
            if (a != -1 && intent.equals(b))
            {
                b = null;
                a = -1;
                return;
            }
        }
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        a = -1;
        b = null;
    }
}
