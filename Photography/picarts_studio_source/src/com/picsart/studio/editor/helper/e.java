// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;

public final class e
{

    public Bitmap a;
    public String b;

    public e(Bitmap bitmap, String s)
    {
        a = bitmap;
        b = s;
        c();
    }

    public e(String s)
    {
        b = s;
    }

    public final Bitmap a()
    {
        if (a != null && !a.isRecycled())
        {
            return a;
        } else
        {
            return w.g(b);
        }
    }

    public final Point b()
    {
        if (a != null && !a.isRecycled())
        {
            return new Point(a.getWidth(), a.getHeight());
        } else
        {
            return w.h(b);
        }
    }

    public final void c()
    {
        (new ModernAsyncTask() {

            private e a;

            private transient Void a()
            {
                try
                {
                    w.a(a.a, a.b);
                }
                catch (OutOfMemoryError outofmemoryerror)
                {
                    outofmemoryerror.printStackTrace();
                    System.gc();
                }
                return null;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final volatile void onPostExecute(Object obj)
            {
                super.onPostExecute((Void)obj);
                a.a = null;
            }

            
            {
                a = e.this;
                super();
            }
        }).execute(new Void[0]);
    }
}
