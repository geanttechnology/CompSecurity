// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            TemplateButton

class a extends AsyncTask
{

    final String a;
    final TemplateButton b;

    protected transient Bitmap a(Void avoid[])
    {
        BufferedInputStream bufferedinputstream;
        if (a.indexOf("assets://") != 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        bufferedinputstream = new BufferedInputStream(b.getContext().getAssets().open(a.substring("assets://".length())));
        avoid = BitmapFactory.decodeStream(bufferedinputstream);
        bufferedinputstream.close();
        return avoid;
        avoid = BitmapFactory.decodeFile(a);
        return avoid;
        IOException ioexception;
        ioexception;
        avoid = null;
_L2:
        ioexception.printStackTrace();
        return avoid;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            b.setImage(bitmap);
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

    (TemplateButton templatebutton, String s)
    {
        b = templatebutton;
        a = s;
        super();
    }
}
