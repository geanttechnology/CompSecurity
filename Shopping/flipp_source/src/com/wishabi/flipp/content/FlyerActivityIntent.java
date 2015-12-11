// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.RectF;
import com.wishabi.flipp.app.FlyerActivity;
import com.wishabi.flipp.app.bm;

// Referenced classes of package com.wishabi.flipp.content:
//            i, o

public class FlyerActivityIntent extends Intent
{

    public FlyerActivityIntent(Context context, Cursor cursor)
    {
        this(context, cursor, null);
    }

    public FlyerActivityIntent(Context context, Cursor cursor, RectF rectf)
    {
        super(context, com/wishabi/flipp/app/FlyerActivity);
        int j = bm.a;
        a(cursor, rectf);
    }

    public FlyerActivityIntent(Context context, Flyer.Model model, RectF rectf)
    {
        this(context, model, rectf, bm.a);
    }

    public FlyerActivityIntent(Context context, Flyer.Model model, RectF rectf, int j)
    {
        super(context, com/wishabi/flipp/app/FlyerActivity);
        a(new Flyer.Model[] {
            model
        }, 0, rectf, j);
    }

    public FlyerActivityIntent(Context context, o o1)
    {
        super(context, com/wishabi/flipp/app/FlyerActivity);
        context = context.getContentResolver().query(i.a, null, "flyer_id = ?", new String[] {
            Integer.toString(o1.b)
        }, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (context.moveToFirst())
        {
            o1 = o1.a();
            int j = bm.a;
            a(context, o1);
        }
        if (context != null)
        {
            context.close();
        }
        return;
        o1;
        context = null;
_L2:
        if (context != null)
        {
            context.close();
        }
        throw o1;
        o1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(Cursor cursor, RectF rectf)
    {
        int k = cursor.getPosition();
        Flyer.Model amodel[] = new Flyer.Model[cursor.getCount()];
        int j = 0;
        for (boolean flag = cursor.moveToFirst(); flag;)
        {
            amodel[j] = new Flyer.Model(cursor);
            flag = cursor.moveToNext();
            j++;
        }

        a(amodel, k, rectf, bm.a);
    }

    private void a(Flyer.Model amodel[], int j, RectF rectf, int k)
    {
        putExtra("models", amodel);
        putExtra("position", j);
        putExtra("flyer_mode", k - 1);
        if (rectf == null)
        {
            return;
        } else
        {
            putExtra("left", rectf.left);
            putExtra("top", rectf.top);
            putExtra("right", rectf.right);
            putExtra("bottom", rectf.bottom);
            return;
        }
    }
}
