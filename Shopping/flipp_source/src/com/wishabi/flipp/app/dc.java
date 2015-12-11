// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.View;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.o;
import com.wishabi.flipp.content.af;
import com.wishabi.flipp.content.i;

// Referenced classes of package com.wishabi.flipp.app:
//            cx

final class dc
    implements android.view.View.OnClickListener
{

    final cx a;

    dc(cx cx1)
    {
        a = cx1;
        super();
    }

    public final void onClick(View view)
    {
        Activity activity;
        activity = a.getActivity();
        if (activity == null)
        {
            return;
        }
        view = activity.getContentResolver().query(i.a, null, "_id = ?", new String[] {
            String.valueOf(cx.b(a).c)
        }, null);
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (view.moveToNext())
        {
            a.a.a(new com.wishabi.flipp.content.Flyer.Model(view), cx.c(a), o.f);
        }
        if (view != null)
        {
            view.close();
        }
        view = new Intent("android.intent.action.SEND");
        view.putExtra("android.intent.extra.TEXT", a.getResources().getString(0x7f0e012a, new Object[] {
            cx.b(a).d, cx.b(a).a()
        }));
        view.setType("text/plain");
        activity.startActivity(Intent.createChooser(view, null));
        return;
        Exception exception;
        exception;
        view = null;
_L2:
        if (view != null)
        {
            view.close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
