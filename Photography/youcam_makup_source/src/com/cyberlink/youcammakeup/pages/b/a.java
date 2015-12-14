// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.b;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.cyberlink.youcammakeup.Globals;

// Referenced classes of package com.cyberlink.youcammakeup.pages.b:
//            c, b

public class a
{

    private Pair a;
    private boolean b;
    private Handler c;
    private b d;

    private a()
    {
        a = null;
        b = false;
        c = new Handler(Looper.getMainLooper());
        d = null;
    }


    static Pair a(a a1, Pair pair)
    {
        a1.a = pair;
        return pair;
    }

    public static a a()
    {
        return com.cyberlink.youcammakeup.pages.b.c.a();
    }

    static void a(a a1, boolean flag)
    {
        a1.a(flag);
    }

    private void a(boolean flag)
    {
        b b1 = d;
        if (b1 != null)
        {
            if (flag)
            {
                Pair pair = a;
                c.post(new Runnable(b1, pair) {

                    final b a;
                    final Pair b;
                    final a c;

                    public void run()
                    {
                        a.a(b);
                        a.b(c, false);
                    }

            
            {
                c = a.this;
                a = b1;
                b = pair;
                super();
            }
                });
            } else
            {
                b1.a(a);
                b = false;
            }
            a = null;
        }
    }

    static boolean b(a a1, boolean flag)
    {
        a1.b = flag;
        return flag;
    }

    public void a(b b1)
    {
        if (b1 == null)
        {
            throw new NullPointerException("onGetBeautyCircleStatusListener cannot be null.");
        } else
        {
            d = b1;
            return;
        }
    }

    public void b()
    {
        if (a != null)
        {
            a(true);
        } else
        if (!b)
        {
            b = true;
            (new AsyncTask() {

                final a a;

                protected transient Pair a(Void avoid[])
                {
                    return com.cyberlink.beautycircle.a.a(Globals.d());
                }

                protected void a(Pair pair)
                {
                    a.a(a, pair);
                    a.a(a, false);
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Pair)obj);
                }

            
            {
                a = a.this;
                super();
            }
            }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

    public void b(b b1)
    {
        if (d != b1)
        {
            d = null;
        }
    }
}
