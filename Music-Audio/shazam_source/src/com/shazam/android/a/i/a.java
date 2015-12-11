// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.i;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.shazam.android.a.b;
import com.shazam.android.fragment.myshazam.g;
import com.shazam.android.fragment.myshazam.i;
import com.shazam.g.e;
import com.shazam.g.f;
import com.shazam.model.Factory;
import com.shazam.model.myshazam.MyShazamTag;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.shazam.android.a.i:
//            c, b

public final class com.shazam.android.a.i.a extends com.shazam.android.a.b
{
    private final class a
        implements f
    {

        final int a;
        final com.shazam.android.a.i.a b;
        private final MyShazamTag c;

        private void a()
        {
            com.shazam.android.a.i.a.b(b).remove(c.requestId);
            if (com.shazam.android.a.i.a.b(b).size() < 5 && !com.shazam.android.a.i.a.c(b).a.isEmpty())
            {
                c c1 = com.shazam.android.a.i.a.c(b);
                com.shazam.android.a.i.b b1 = (com.shazam.android.a.i.b)c1.a.removeLast();
                c1.b.remove(Integer.valueOf(b1.a));
                com.shazam.android.a.i.a.a(b, b1.a, b1.b);
            }
        }

        public final void onDataFailedToLoad()
        {
            a();
        }

        public final void onDataFetched(Object obj)
        {
            obj = (MyShazamTag)obj;
            com.shazam.android.a.i.a.a(b).post(new Runnable(this, ((MyShazamTag) (obj))) {

                final MyShazamTag a;
                final a b;

                public final void run()
                {
                    if (((MyShazamTag)b.b.getItem(b.a)).requestId.equals(a.requestId))
                    {
                        b.b.a(b.a, a);
                    }
                }

            
            {
                b = a1;
                a = myshazamtag;
                super();
            }
            });
            a();
            b.notifyDataSetChanged();
        }

        public a(MyShazamTag myshazamtag, int j)
        {
            b = com.shazam.android.a.i.a.this;
            super();
            c = myshazamtag;
            a = j;
        }
    }

    private final class b
        implements com.shazam.android.widget.button.LikeButton.a
    {

        final com.shazam.android.a.i.a a;

        public final void a()
        {
            a.notifyDataSetChanged();
        }

        private b()
        {
            a = com.shazam.android.a.i.a.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }


    private final Factory c;
    private final Handler d;
    private Set e;
    private c f;
    private final Factory g;
    private final com.shazam.android.widget.button.LikeButton.a h = new b((byte)0);

    public com.shazam.android.a.i.a(Context context, Factory factory, Handler handler, Factory factory1)
    {
        super(context);
        e = Collections.emptySet();
        c = factory;
        d = handler;
        g = factory1;
    }

    static Handler a(com.shazam.android.a.i.a a1)
    {
        return a1.d;
    }

    private void a(int j, MyShazamTag myshazamtag)
    {
        if (myshazamtag.isFull || e.contains(myshazamtag.requestId) || f.b.contains(Integer.valueOf(j)))
        {
            return;
        }
        if (e.size() < 5)
        {
            e.add(myshazamtag.requestId);
            e e1 = (e)c.create(myshazamtag);
            e1.a(new a(myshazamtag, j));
            e1.a();
            return;
        } else
        {
            c c1 = f;
            LinkedList linkedlist = c1.a;
            b.a a1 = new b.a();
            a1.a = j;
            a1.b = myshazamtag;
            linkedlist.add(new com.shazam.android.a.i.b(a1));
            c1.b.add(Integer.valueOf(j));
            return;
        }
    }

    static void a(com.shazam.android.a.i.a a1, int j, MyShazamTag myshazamtag)
    {
        a1.a(j, myshazamtag);
    }

    static Set b(com.shazam.android.a.i.a a1)
    {
        return a1.e;
    }

    static c c(com.shazam.android.a.i.a a1)
    {
        return a1.f;
    }

    public final View a(Context context, ViewGroup viewgroup)
    {
        return (View)g.create(context);
    }

    public final void a(View view, Object obj, int j)
    {
        obj = (MyShazamTag)obj;
        a(j, ((MyShazamTag) (obj)));
        g g1 = (g)view;
        g1.a(((MyShazamTag) (obj)));
        view.setVisibility(0);
        if (g1 instanceof i)
        {
            ((i)g1).setOnLikeCountChangedListener(h);
        }
    }

    public final void a(List list)
    {
        super.a(list);
        e = new HashSet(5);
        f = new c();
    }
}
