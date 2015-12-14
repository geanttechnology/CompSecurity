// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.os.AsyncTask;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.m;
import com.cyberlink.you.database.n;
import com.cyberlink.you.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, j, e, h, 
//            f

class c extends AsyncTask
{

    final StickerFragment a;
    private int b;
    private int c;

    private c(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
        b = 0;
        c = 0;
    }

    c(StickerFragment stickerfragment, StickerFragment._cls1 _pcls1)
    {
        this(stickerfragment);
    }

    static int a(c c1)
    {
        int i = c1.c;
        c1.c = i + 1;
        return i;
    }

    private void a()
    {
        int i = StickerFragment.k(a).a(com.cyberlink.you.sticker.StickerFragment.n(a));
        if (i != -1)
        {
            StickerFragment.a(a, i);
            StickerFragment.a(a, com.cyberlink.you.sticker.StickerFragment.n(a));
        } else
        {
            int k = StickerFragment.k(a).a();
            if (k != -1)
            {
                long l = ((StickerPackObj)StickerFragment.k(a).getItem(k)).b();
                StickerFragment.a(a, k);
                StickerFragment.a(a, l);
                return;
            }
            if (StickerFragment.k(a).getCount() > 0 && StickerFragment.o(a))
            {
                if (!StickerFragment.p(a) && !StickerFragment.q(a))
                {
                    StickerFragment.b(a, true);
                    return;
                } else
                {
                    StickerFragment.a(a, 0);
                    StickerFragment.a(a, -2L);
                    return;
                }
            }
        }
    }

    private void a(StickerPackObj stickerpackobj)
    {
        long l = stickerpackobj.b();
        (new com.cyberlink.you.sticker.e(a, stickerpackobj, new h(l) {

            final long a;
            final c b;

            public void a(List list)
            {
                c.a(b);
                if (list != null)
                {
                    list = new f(b.a, list, false, a);
                    StickerFragment.f(b.a).put(String.valueOf(a), list);
                }
                if (StickerFragment.j(b.a) && c.b(b) >= c.c(b))
                {
                    StickerFragment.a(b.a, false);
                    c.d(b);
                }
            }

            
            {
                b = c.this;
                a = l;
                super();
            }
        })).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    static int b(c c1)
    {
        return c1.c;
    }

    static int c(c c1)
    {
        return c1.b;
    }

    static void d(c c1)
    {
        c1.a();
    }

    protected transient List a(Void avoid[])
    {
        Thread.currentThread().setName("StickerFragment.InitStickerTask AsyncTask");
        if (StickerFragment.i(a))
        {
            return null;
        } else
        {
            return e.i().b();
        }
    }

    protected void a(List list)
    {
        if (list != null)
        {
            StickerFragment.k(a).addAll(list);
            if (StickerFragment.l(a))
            {
                StickerPackObj stickerpackobj = new StickerPackObj(-1L, -1L, null, null, null, null, null, (n)null, com.cyberlink.you.database.StickerPackObj.Status.a, -1L, -1L, null, null, null, true, null);
                stickerpackobj.a(com.cyberlink.you.database.StickerPackObj.FunctionType.c);
                StickerFragment.k(a).add(stickerpackobj);
            }
            b = list.size();
            c = 0;
            list = list.iterator();
            do
            {
label0:
                {
                    StickerPackObj stickerpackobj1;
                    if (list.hasNext())
                    {
                        stickerpackobj1 = (StickerPackObj)list.next();
                        if (!StickerFragment.i(a))
                        {
                            break label0;
                        }
                    }
                    if (c < b)
                    {
                        StickerFragment.a(a, true);
                        return;
                    } else
                    {
                        a();
                        return;
                    }
                }
                a(stickerpackobj1);
            } while (true);
        } else
        {
            com.cyberlink.you.sticker.StickerFragment.m(a);
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }
}
