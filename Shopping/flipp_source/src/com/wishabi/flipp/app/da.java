// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.webkit.URLUtil;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.o;
import com.wishabi.flipp.content.af;
import com.wishabi.flipp.content.i;

// Referenced classes of package com.wishabi.flipp.app:
//            cx

final class da
    implements android.view.View.OnClickListener
{

    final af a;
    final cx b;

    da(cx cx1, af af1)
    {
        b = cx1;
        a = af1;
        super();
    }

    public final void onClick(View view)
    {
        Activity activity;
        activity = b.getActivity();
        if (activity == null || !URLUtil.isValidUrl(a.s))
        {
            return;
        }
        view = activity.getContentResolver().query(i.a, null, "_id = ?", new String[] {
            String.valueOf(cx.b(b).c)
        }, null);
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (view.moveToNext())
        {
            a.a.a(new com.wishabi.flipp.content.Flyer.Model(view), cx.c(b), o.b);
        }
        if (view != null)
        {
            view.close();
        }
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a.s)));
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
