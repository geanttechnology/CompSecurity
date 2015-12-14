// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.e;
import com.picsart.shop.a;
import com.picsart.studio.d;
import com.socialin.android.adapter.RecyclerViewAdapter;
import myobfuscated.cb.b;
import myobfuscated.cb.c;

// Referenced classes of package com.picsart.studio.editor.helper:
//            h

public class g extends RecyclerViewAdapter
{

    public int a;
    private String b;
    private Context c;
    private b d;
    private d e;
    private SparseArray f;

    public g(Context context, com.socialin.android.adapter.a a1)
    {
        super(context, a1);
        b = com/picsart/studio/editor/helper/g.getSimpleName();
        a = -1;
        d = new b();
        f = new SparseArray();
        c = context;
        com.bumptech.glide.b.b(context.getApplicationContext()).i().a(0.1F).a(com.bumptech.glide.request.e.b(l.a).a(DownsampleStrategy.d));
        e = new d(context.getApplicationContext());
    }

    static int a(g g1)
    {
        return g1.a;
    }

    static int a(g g1, int i)
    {
        g1.a = i;
        return i;
    }

    static SparseArray b(g g1)
    {
        return g1.f;
    }

    static com.socialin.android.adapter.a c(g g1)
    {
        return g1.clickListener;
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        h h1;
        c c1;
        h1 = (h)viewholder;
        super.onBindViewHolder(h1, i);
        f.put(i, h1);
        c1 = (c)getItem(i);
        if (!c1.i) goto _L2; else goto _L1
_L1:
        if (c1.g == null) goto _L4; else goto _L3
_L3:
        com.bumptech.glide.b.b(e.a).a(h1.a);
        e.c(c1.g, h1.a, (e)((e)com.bumptech.glide.request.e.b(l.a).a(0x7f020567)).a(DownsampleStrategy.d));
_L5:
        Object obj;
        byte abyte0[];
        if (a == i)
        {
            h1.b.setBackgroundResource(0x7f020077);
        } else
        {
            h1.b.setBackgroundResource(0);
        }
        h1.c.setOnClickListener(new android.view.View.OnClickListener(h1, i, c1) {

            private h a;
            private int b;
            private c c;
            private g d;

            public final void onClick(View view)
            {
                if (com.picsart.studio.editor.helper.g.a(d) >= 0 && com.picsart.studio.editor.helper.g.b(d).get(com.picsart.studio.editor.helper.g.a(d)) != null)
                {
                    ((h)com.picsart.studio.editor.helper.g.b(d).get(com.picsart.studio.editor.helper.g.a(d))).b.setBackgroundResource(0);
                }
                a.b.setBackgroundResource(0x7f020077);
                com.picsart.studio.editor.helper.g.a(d, b);
                com.picsart.studio.editor.helper.g.c(d).a(b, null, new Object[] {
                    c.c
                });
            }

            
            {
                d = g.this;
                a = h1;
                b = i;
                c = c1;
                super();
            }
        });
        return;
_L4:
        viewholder = d.a(i);
        if (viewholder != null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        abyte0 = com.picsart.shop.a.a().c(c1.j, c1.l);
        obj = com.socialin.android.util.c.a(abyte0, 0, abyte0.length, null, b);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        obj = new myobfuscated.cd.a(c.getResources(), ((android.graphics.Bitmap) (obj)));
        d.a(i, ((myobfuscated.cd.a) (obj)));
        viewholder = ((android.support.v7.widget.RecyclerView.ViewHolder) (obj));
_L6:
        h1.a.setImageDrawable(viewholder);
          goto _L5
        obj;
_L7:
        com.socialin.android.d.b(b, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L6
_L2:
        com.bumptech.glide.b.b(e.a).a(h1.a);
        e.c(c1.c, h1.a, (e)((e)com.bumptech.glide.request.e.b(l.a).a(0x7f020567)).a(DownsampleStrategy.d));
          goto _L5
        Exception exception;
        exception;
        viewholder = ((android.support.v7.widget.RecyclerView.ViewHolder) (obj));
        obj = exception;
          goto _L7
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return new h(LayoutInflater.from(c).inflate(0x7f030037, viewgroup, false));
    }
}
