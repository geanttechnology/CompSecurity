// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.widgetpool.dialogs.g;
import com.cyberlink.youcammakeup.widgetpool.dialogs.m;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            SoftInputUtils, bl

final class t>
    implements m
{

    final bl a;
    final Activity b;
    private Toast c;
    private g d;

    private void a()
    {
        if (c != null)
        {
            c.cancel();
            c = null;
        }
    }

    public boolean a(View view, String s)
    {
label0:
        {
            view = a.a(s);
            boolean flag;
            if (view == eckResult.c)
            {
                a.a(s);
                view = a.a();
                flag = true;
            } else
            if (view == eckResult.b)
            {
                view = a.b();
                flag = false;
            } else
            if (view == eckResult.a)
            {
                view = a.c();
                flag = false;
            } else
            {
                view = null;
                flag = false;
            }
            if (view != null)
            {
                if (b != null)
                {
                    break label0;
                }
                a();
                c = Toast.makeText(Globals.d(), view, 0);
                c.show();
            }
            return flag;
        }
        d.a(b, view, 2000);
        return flag;
    }

    public boolean b(View view, String s)
    {
        a.a(new Exception("User canceled."));
        return true;
    }

    public boolean c(View view, String s)
    {
        a.a(new Exception("User canceled."));
        return true;
    }

    eckResult(bl bl1, Activity activity)
    {
        a = bl1;
        b = activity;
        super();
        c = null;
        d = new g();
    }
}
