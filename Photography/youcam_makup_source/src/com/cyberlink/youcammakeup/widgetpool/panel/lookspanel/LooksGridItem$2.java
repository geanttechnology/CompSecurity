// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.BufferedInputStream;
import java.io.IOException;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel:
//            LooksGridItem

class a extends AsyncTask
{

    final String a;
    final LooksGridItem b;

    protected transient Bitmap a(Void avoid[])
    {
        if (a.indexOf("assets://") == 0)
        {
            try
            {
                avoid = BitmapFactory.decodeStream(new BufferedInputStream(LooksGridItem.e(b).getAssets().open(a.substring("assets://".length()))));
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                return null;
            }
            return avoid;
        } else
        {
            return BitmapFactory.decodeFile(a);
        }
    }

    protected void a(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            LooksGridItem.f(b).setImageBitmap(bitmap);
            return;
        } else
        {
            b.a();
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }

    (LooksGridItem looksgriditem, String s)
    {
        b = looksgriditem;
        a = s;
        super();
    }
}
