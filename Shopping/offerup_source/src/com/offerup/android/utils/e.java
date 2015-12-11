// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.b.a.a.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.offerup.android.utils:
//            d, f

final class e extends AsyncTask
{

    private final f a;
    private int b;
    private final Uri c;
    private d d;

    public e(d d1, Uri uri, int i, f f1)
    {
        d = d1;
        super();
        a = f1;
        c = uri;
        b = i;
    }

    private transient Uri a()
    {
        Uri uri = com.offerup.android.utils.d.a(d, b);
        FileOutputStream fileoutputstream = new FileOutputStream(new File(uri.getPath()));
        Object obj = fileoutputstream;
        Bitmap bitmap = com.offerup.android.utils.d.a(d, c, 800);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        obj = fileoutputstream;
        if (!bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, fileoutputstream))
        {
            break MISSING_BLOCK_LABEL_75;
        }
        obj = fileoutputstream;
        bitmap.recycle();
        try
        {
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            g.a(d, ((Throwable) (obj)));
            return uri;
        }
_L2:
        return uri;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        fileoutputstream = null;
_L5:
        obj = fileoutputstream;
        g.a(d, filenotfoundexception);
        if (fileoutputstream == null) goto _L2; else goto _L1
_L1:
        try
        {
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            g.a(d, ((Throwable) (obj)));
            return uri;
        }
        return uri;
        Exception exception;
        exception;
        obj = null;
_L4:
        if (obj != null)
        {
            try
            {
                ((FileOutputStream) (obj)).flush();
                ((FileOutputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                g.a(d, ioexception);
            }
        }
        throw exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        filenotfoundexception;
          goto _L5
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Uri)obj;
        if (obj != null)
        {
            a.a(((Uri) (obj)));
            return;
        } else
        {
            a.a();
            return;
        }
    }
}
