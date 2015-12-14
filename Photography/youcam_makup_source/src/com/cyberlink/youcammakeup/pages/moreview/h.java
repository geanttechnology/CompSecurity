// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            g

class h extends AsyncTask
{

    public long a;
    final g b;

    private h(g g1)
    {
        b = g1;
        super();
    }

    h(g g1, g._cls1 _pcls1)
    {
        this(g1);
    }

    protected transient Bitmap a(String as[])
    {
        return BitmapFactory.decodeFile(as[0]);
    }

    protected void a(Bitmap bitmap)
    {
label0:
        {
            if (a == g.a(b))
            {
                if (bitmap == null)
                {
                    break label0;
                }
                g.b(b).setImageBitmap(bitmap);
            }
            return;
        }
        g.a(b, true);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }
}
