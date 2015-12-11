// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

// Referenced classes of package com.b.a:
//            b, j

class syncTask extends AsyncTask
{

    final Context a;
    final String b;
    final j c;
    final Runnable d;
    final b e;

    protected transient Void a(Void avoid[])
    {
        try
        {
            avoid = a.getContentResolver().openInputStream(Uri.parse(b));
            c.a(e, avoid, null);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
            return null;
        }
        return null;
    }

    protected void a(Void void1)
    {
        d.run();
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    nnable(b b1, Context context, String s, j j1, Runnable runnable)
    {
        e = b1;
        a = context;
        b = s;
        c = j1;
        d = runnable;
        super();
    }
}
