// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.utility.o;

public class z extends a
{

    private View a;
    private android.view.View.OnClickListener b;
    private android.view.View.OnClickListener c;
    private String d;
    private com.cyberlink.youcammakeup.Globals.ActivityType e;

    public z()
    {
        d = null;
        e = null;
    }

    static com.cyberlink.youcammakeup.Globals.ActivityType a(z z1)
    {
        return z1.e;
    }

    private void b()
    {
label0:
        {
            if (e != null)
            {
                Activity activity = Globals.d().a(e);
                e = null;
                if (activity != null)
                {
                    Object obj;
                    Object obj1;
                    Object obj2;
                    if (activity.isTaskRoot())
                    {
                        obj = com/cyberlink/youcammakeup/activity/LauncherActivity;
                    } else
                    {
                        obj = null;
                    }
                    obj2 = activity.getIntent();
                    obj1 = obj;
                    if (obj2 != null)
                    {
                        obj2 = (Class)((Intent) (obj2)).getSerializableExtra(getResources().getString(0x7f070729));
                        obj1 = obj;
                        if (obj2 != null)
                        {
                            obj1 = obj2;
                        }
                    }
                    if (obj1 != null)
                    {
                        break label0;
                    }
                    activity.finish();
                }
            }
            return;
        }
        obj = new Intent(Globals.d().getApplicationContext(), ((Class) (obj1)));
        ((Intent) (obj)).setFlags(0x10008000);
        startActivity(((Intent) (obj)));
        activity.finish();
    }

    static void b(z z1)
    {
        z1.b();
    }

    static android.view.View.OnClickListener c(z z1)
    {
        return z1.b;
    }

    static android.view.View.OnClickListener d(z z1)
    {
        return z1.c;
    }

    public void a(android.view.View.OnClickListener onclicklistener)
    {
        b = onclicklistener;
    }

    public void a(com.cyberlink.youcammakeup.Globals.ActivityType activitytype)
    {
        e = activitytype;
    }

    public void a(String s)
    {
        d = s;
    }

    public void b(android.view.View.OnClickListener onclicklistener)
    {
        c = onclicklistener;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a(new android.content.DialogInterface.OnDismissListener() {

            final z a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                if (com.cyberlink.youcammakeup.widgetpool.dialogs.z.a(a) != null)
                {
                    dialoginterface = Globals.d().a(com.cyberlink.youcammakeup.widgetpool.dialogs.z.a(a));
                    if (dialoginterface != null)
                    {
                        o.a(dialoginterface);
                    }
                }
                z.b(a);
            }

            
            {
                a = z.this;
                super();
            }
        });
        a.findViewById(0x7f0c0599).setOnClickListener(new android.view.View.OnClickListener() {

            final z a;

            public void onClick(View view)
            {
                if (z.c(a) != null)
                {
                    a.a(null);
                    z.c(a).onClick(view);
                }
            }

            
            {
                a = z.this;
                super();
            }
        });
        a.findViewById(0x7f0c0620).setOnClickListener(new android.view.View.OnClickListener() {

            final z a;

            public void onClick(View view)
            {
                if (z.d(a) != null)
                {
                    z.d(a).onClick(view);
                    return;
                } else
                {
                    z.b(a);
                    return;
                }
            }

            
            {
                a = z.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f030156, viewgroup, false);
        if (d != null && !d.isEmpty())
        {
            ((TextView)a.findViewById(0x7f0c0597)).setText(d);
        }
        return a;
    }
}
