// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.VideoView;
import com.liverail.library.a.d;
import com.liverail.library.b.a;

// Referenced classes of package com.liverail.library.f:
//            a, i

class e
    implements android.view.View.OnClickListener
{

    final com.liverail.library.f.a a;

    e(com.liverail.library.f.a a1)
    {
        a = a1;
        super();
    }

    public void onClick(View view)
    {
        com.liverail.library.b.a.a("User has clicked on the ad");
        boolean flag1 = com.liverail.library.f.a.f(a).isPlaying();
        boolean flag;
        if (com.liverail.library.f.a.d(a).n != null && com.liverail.library.f.a.d(a).n.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            view = com.liverail.library.f.a.d(a).n;
        } else
        {
            view = "";
        }
        if (!flag1)
        {
            a.b();
        } else
        {
            if (com.liverail.library.f.a.k(a).i.g)
            {
                a.a();
            }
            if (com.liverail.library.f.a.c(a) != null)
            {
                if (flag && com.liverail.library.f.a.k(a).k)
                {
                    com.liverail.library.f.a.c(a).a(true, view);
                } else
                {
                    com.liverail.library.f.a.c(a).a(false, "");
                }
            }
            if (flag && !com.liverail.library.f.a.k(a).k)
            {
                com.liverail.library.b.a.b((new StringBuilder("Intent url=")).append(view).toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(view));
                a.getContext().startActivity(intent);
                return;
            }
        }
    }
}
