// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.i;

import android.os.Handler;
import com.shazam.g.f;
import com.shazam.model.myshazam.MyShazamTag;
import java.util.LinkedList;
import java.util.Set;

// Referenced classes of package com.shazam.android.a.i:
//            a, c, b

private final class a
    implements f
{

    final int a;
    final a b;
    private final MyShazamTag c;

    private void a()
    {
        com.shazam.android.a.i.a.b(b).remove(c.requestId);
        if (com.shazam.android.a.i.a.b(b).size() < 5 && !com.shazam.android.a.i.a.c(b).a.isEmpty())
        {
            c c1 = com.shazam.android.a.i.a.c(b);
            b b1 = (b)c1.a.removeLast();
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
        com.shazam.android.a.i.a.a(b).post(new Runnable(((MyShazamTag) (obj))) {

            final MyShazamTag a;
            final a.a b;

            public final void run()
            {
                if (((MyShazamTag)b.b.getItem(b.a)).requestId.equals(a.requestId))
                {
                    b.b.a(b.a, a);
                }
            }

            
            {
                b = a.a.this;
                a = myshazamtag;
                super();
            }
        });
        a();
        b.notifyDataSetChanged();
    }

    public yShazamTag(a a1, MyShazamTag myshazamtag, int i)
    {
        b = a1;
        super();
        c = myshazamtag;
        a = i;
    }
}
