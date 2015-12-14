// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.socialin.android.util.w;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.collages:
//            e, CollageCreatorView, a

final class a
    implements Runnable
{

    final String a;
    final e b;

    public final void run()
    {
        (new AsyncTask() {

            private e._cls28 a;

            private transient Bitmap a()
            {
                int i = (int)e.b(a.b).a(0).o;
                Bitmap bitmap;
                try
                {
                    bitmap = w.a(a.a, i, i, m.d(a.a));
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    return null;
                }
                return bitmap;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Bitmap)obj;
                e.b(a.b).setBackgroundBitmap(((Bitmap) (obj)), a.a);
                e.b(a.b).invalidate();
            }

            
            {
                a = e._cls28.this;
                super();
            }
        }).execute(new String[] {
            a
        });
    }

    >(e e1, String s)
    {
        b = e1;
        a = s;
        super();
    }
}
