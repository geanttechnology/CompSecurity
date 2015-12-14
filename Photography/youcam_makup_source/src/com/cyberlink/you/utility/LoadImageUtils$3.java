// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.ImageView;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.m;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.sticker.StickerObj;

// Referenced classes of package com.cyberlink.you.utility:
//            LoadImageUtils, m

final class e extends AsyncTask
{

    final StickerObj a;
    final String b;
    final String c;
    final ImageView d;
    final com.cyberlink.you.utility.m e;

    protected transient Pair a(Void avoid[])
    {
        avoid = com.cyberlink.you.e.i().a(a.c());
        boolean flag;
        if (avoid != null && avoid.j().equals(com.cyberlink.you.database.atus.b))
        {
            flag = LoadImageUtils.a(b, c, String.valueOf(a.c()), String.valueOf(a.b()));
        } else
        {
            flag = true;
        }
        return Pair.create(Boolean.valueOf(flag), avoid);
    }

    protected void a(Pair pair)
    {
        g.a();
        Context context = g.I().getApplicationContext();
        if (((Boolean)pair.first).booleanValue())
        {
            LoadImageUtils.a(context, a.f(), b, c, d, e);
            return;
        } else
        {
            e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Pair)obj);
    }

    tatus(StickerObj stickerobj, String s, String s1, ImageView imageview, com.cyberlink.you.utility.m m1)
    {
        a = stickerobj;
        b = s;
        c = s1;
        d = imageview;
        e = m1;
        super();
    }
}
