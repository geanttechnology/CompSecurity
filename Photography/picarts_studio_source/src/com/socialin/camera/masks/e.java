// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.masks;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.socialin.android.d;
import com.socialin.android.dialog.f;
import com.socialin.android.net.a;
import com.socialin.android.net.b;
import com.socialin.android.photo.i;
import com.socialin.android.util.Utils;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.camera.masks:
//            f

public final class e
    implements android.content.DialogInterface.OnCancelListener, b
{

    public int a;
    public String b;
    public Activity c;
    public ProgressDialog d;
    public com.socialin.camera.masks.f e;
    private long f;
    private Dialog g;

    public e(Activity activity, com.socialin.camera.masks.f f1)
    {
        a = -1;
        b = null;
        f = 0L;
        c = activity;
        e = f1;
    }

    public static void a(i j, int k, a a1)
    {
        int i1 = j.getCount();
        for (int l = 0; l < i1; l++)
        {
            if (l != k)
            {
                a1.a(j.b(l), j.c(l), null, null, false);
            }
        }

        if (k < i1 && k >= 0)
        {
            a1.a(j.b(k), j.c(k), null, null, true);
        }
    }

    public final void a(Intent intent)
    {
        Activity activity;
        if (d.b)
        {
            (new StringBuilder("downloadintent: ")).append(intent.toURI()).append(" pendingPath:").append(b);
        }
        activity = c;
        break MISSING_BLOCK_LABEL_40;
        while (true) 
        {
            int j;
            do
            {
                do
                {
                    return;
                } while (activity == null || !"intent.action.download.complete".equals(intent.getAction()));
                j = intent.getIntExtra("download_status", -1);
                intent = intent.getStringExtra("download_file_path");
                if (j != 1 && j != 2)
                {
                    break;
                }
                if (a != -1 && intent.equals(b))
                {
                    if (e != null)
                    {
                        e.a(a, true);
                    }
                    if (d != null && d.isShowing())
                    {
                        m.b(activity, d);
                    }
                    a = -1;
                    b = null;
                    return;
                }
            } while (true);
            m.b(activity, d);
            if (j == -1 && a != -1)
            {
                if (g == null)
                {
                    Object obj = new f(activity);
                    obj.b = activity.getString(0x7f080306);
                    obj.d = 0x108009b;
                    obj.a = activity.getString(0x7f080307);
                    obj = ((f) (obj)).a(activity.getString(0x7f080308), new android.view.View.OnClickListener(activity) {

                        private Activity a;

                        public final void onClick(View view)
                        {
                            a.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                        }

            
            {
                a = activity;
                super();
            }
                    }).b(activity.getString(0x7f0802a4)).a();
                    if (!activity.isFinishing() && !((Dialog) (obj)).isShowing())
                    {
                        ((Dialog) (obj)).show();
                    }
                    g = ((Dialog) (obj));
                }
                if (!g.isShowing())
                {
                    g.show();
                }
            } else
            if (j == -2)
            {
                long l = System.currentTimeMillis();
                if (Math.abs(f - l) > 10000L)
                {
                    Utils.a(activity, 0x7f080342);
                    f = l;
                }
            }
            if (a != -1 && activity != null && intent.equals(b))
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
