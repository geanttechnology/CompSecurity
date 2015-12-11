// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.o;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.content.af;
import com.wishabi.flipp.content.i;
import java.util.ArrayList;

// Referenced classes of package com.wishabi.flipp.app:
//            cx

final class db
    implements android.view.View.OnClickListener
{

    final cx a;

    db(cx cx1)
    {
        a = cx1;
        super();
    }

    public final void onClick(View view)
    {
        Object obj;
        Object obj1;
        Activity activity;
        obj = null;
        obj1 = null;
        activity = a.getActivity();
        if (activity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Cursor cursor = activity.getContentResolver().query(i.g, null, "_id = ?", new String[] {
            Long.toString(cx.c(a))
        }, null);
        if (cursor == null) goto _L4; else goto _L3
_L3:
        if (!cursor.moveToFirst()) goto _L4; else goto _L5
_L5:
        activity.getContentResolver().delete(i.g, "_id = ?", new String[] {
            Long.toString(cx.c(a))
        });
_L13:
        if (cursor == null) goto _L1; else goto _L6
_L6:
        cursor.close();
        return;
_L4:
        obj1 = new ContentValues();
        ((ContentValues) (obj1)).put("_id", Long.valueOf(cx.c(a)));
        ((ContentValues) (obj1)).put("flyer_id", Integer.valueOf(cx.b(a).c));
        view = activity.getContentResolver().query(i.c, null, "_id = ?", new String[] {
            Long.toString(cx.c(a))
        }, null);
        if (view == null) goto _L8; else goto _L7
_L7:
        if (!view.moveToNext()) goto _L8; else goto _L9
_L9:
        int j = view.getInt(view.getColumnIndexOrThrow("left"));
        int k = view.getInt(view.getColumnIndexOrThrow("top"));
        int l = view.getInt(view.getColumnIndexOrThrow("right"));
        ((ContentValues) (obj1)).put("bottom", Integer.valueOf(view.getInt(view.getColumnIndexOrThrow("bottom"))));
        ((ContentValues) (obj1)).put("top", Integer.valueOf(k));
        ((ContentValues) (obj1)).put("left", Integer.valueOf(j));
        ((ContentValues) (obj1)).put("right", Integer.valueOf(l));
_L14:
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        view.close();
        view = ((View) (obj));
        obj = activity.getContentResolver().query(i.a, null, "_id = ?", new String[] {
            String.valueOf(cx.b(a).c)
        }, null);
        if (obj == null) goto _L11; else goto _L10
_L10:
        view = ((View) (obj));
        if (!((Cursor) (obj)).moveToNext()) goto _L11; else goto _L12
_L12:
        view = ((View) (obj));
        boolean flag;
        if (((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("premium")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view = ((View) (obj));
        ((ContentValues) (obj1)).put("premium", Boolean.valueOf(flag));
_L15:
        view = ((View) (obj));
        a.a.a(new com.wishabi.flipp.content.Flyer.Model(((Cursor) (obj))), cx.c(a), o.e);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        ((Cursor) (obj)).close();
        ((ContentValues) (obj1)).put("merchant", cx.b(a).d);
        ((ContentValues) (obj1)).put("merchant_logo", cx.b(a).e);
        ((ContentValues) (obj1)).put("name", cx.b(a).f);
        ((ContentValues) (obj1)).put("price", cx.b(a).j);
        ((ContentValues) (obj1)).put("thumbnail", cx.b(a).h);
        ((ContentValues) (obj1)).put("valid_to", cx.b(a).p);
        activity.getContentResolver().insert(i.g, ((ContentValues) (obj1)));
        if (cx.d(a) != null && !cx.d(a).isEmpty())
        {
            com.wishabi.flipp.content.a.a(cx.d(a), true, p.b, true);
        }
          goto _L13
        view;
        obj = cursor;
_L16:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw view;
_L8:
        ((ContentValues) (obj1)).put("bottom", Integer.valueOf(0));
        ((ContentValues) (obj1)).put("top", Integer.valueOf(0));
        ((ContentValues) (obj1)).put("left", Integer.valueOf(0));
        ((ContentValues) (obj1)).put("right", Integer.valueOf(0));
          goto _L14
        obj1;
        obj = view;
        view = ((View) (obj1));
_L17:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_681;
        }
        ((Cursor) (obj)).close();
        throw view;
_L11:
        view = ((View) (obj));
        ((ContentValues) (obj1)).put("premium", Boolean.valueOf(false));
          goto _L15
        obj;
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_716;
        }
        view.close();
        throw obj;
        view;
        obj = obj1;
          goto _L16
        view;
        obj = null;
          goto _L17
    }
}
