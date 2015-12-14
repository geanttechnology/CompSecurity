// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.shop.a;
import com.picsart.studio.utils.DynamicHeightImageView;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.d;
import com.socialin.android.util.c;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package myobfuscated.cb:
//            b, d, c, g

public final class f extends android.support.v7.widget.RecyclerView.Adapter
    implements com.bumptech.glide.f
{

    public ArrayList a;
    private LayoutInflater b;
    private myobfuscated.cb.b c;
    private String d;
    private j e;
    private j f;

    public f()
    {
        a = new ArrayList();
        b = null;
        c = new myobfuscated.cb.b();
        d = (new StringBuilder()).append(myobfuscated/cb/d.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    }

    public final volatile j a(Object obj)
    {
        obj = (myobfuscated.cb.c)obj;
        j j1 = e;
        j1.b = f.a(obj);
        return j1.a(obj);
    }

    public final List a(int i)
    {
        return a.subList(i, i + 1);
    }

    public final void a(myobfuscated.cb.c c1)
    {
        a.add(c1);
        notifyDataSetChanged();
    }

    public final int getItemCount()
    {
        return a.size();
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        Object obj;
        g g1;
        g1 = (g)viewholder;
        obj = (myobfuscated.cb.c)a.get(i);
        if (!((myobfuscated.cb.c) (obj)).i) goto _L2; else goto _L1
_L1:
        if (((myobfuscated.cb.c) (obj)).f != null)
        {
            myobfuscated.cb.g.a(g1).setImageDrawable(((myobfuscated.cb.c) (obj)).f);
            return;
        }
        viewholder = c.a(i);
        if (viewholder != null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        obj = com.picsart.shop.a.a().c(((myobfuscated.cb.c) (obj)).j, ((myobfuscated.cb.c) (obj)).l);
        obj = com.socialin.android.util.c.a(((byte []) (obj)), 0, obj.length, null, d);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        obj = new myobfuscated.cd.a(myobfuscated.cb.g.a(g1).getContext().getResources(), ((android.graphics.Bitmap) (obj)));
        c.a(i, ((myobfuscated.cd.a) (obj)));
        viewholder = ((android.support.v7.widget.RecyclerView.ViewHolder) (obj));
_L3:
        myobfuscated.cb.g.a(g1).setImageDrawable(viewholder);
        return;
        obj;
_L4:
        com.socialin.android.d.b(d, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
        if (true) goto _L3; else goto _L2
_L2:
        viewholder = ((myobfuscated.cb.c) (obj)).c;
        String s = ((myobfuscated.cb.c) (obj)).h;
        String s1 = ((myobfuscated.cb.c) (obj)).g;
        if (s != null)
        {
            viewholder = e.a((new StringBuilder("file://")).append(s).toString());
            viewholder.b = f.a((new StringBuilder("file://")).append(s).toString());
            viewholder.a(myobfuscated.cb.g.a(g1));
            return;
        }
        if (s1 != null)
        {
            viewholder = e.a(s1);
            viewholder.b = f.a(s1);
            viewholder.a(myobfuscated.cb.g.a(g1));
            return;
        }
        if (viewholder != null)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        try
        {
            viewholder = c.a(i);
        }
        // Misplaced declaration of an exception variable
        catch (android.support.v7.widget.RecyclerView.ViewHolder viewholder)
        {
            viewholder.printStackTrace();
            return;
        }
        if (viewholder != null)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        viewholder = new myobfuscated.cd.a(myobfuscated.cb.g.a(g1).getContext().getResources(), com.socialin.android.util.c.a(myobfuscated.cb.g.a(g1).getContext().getResources(), ((myobfuscated.cb.c) (obj)).b, null, d));
        c.a(i, viewholder);
        myobfuscated.cb.g.a(g1).setImageDrawable(viewholder);
        return;
        obj = e.a(viewholder);
        obj.b = f.a(viewholder);
        ((j) (obj)).a(myobfuscated.cb.g.a(g1));
        return;
        Exception exception;
        exception;
        viewholder = ((android.support.v7.widget.RecyclerView.ViewHolder) (obj));
        obj = exception;
          goto _L4
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        if (b == null)
        {
            b = LayoutInflater.from(viewgroup.getContext());
        }
        g g1 = new g(b.inflate(0x7f030130, viewgroup, false));
        Object obj = com.bumptech.glide.b.b(viewgroup.getContext());
        e = ((k) (obj)).i().a(com.bumptech.glide.request.e.d(viewgroup.getContext()).a(0x7f020567));
        viewgroup = ((k) (obj)).i();
        obj = com.bumptech.glide.request.e.b(l.c);
        i = SocialinApiV3.SQUARE_THUMB_SIZE;
        f = viewgroup.a(((com.bumptech.glide.request.a) (obj)).a(i, i)).a(myobfuscated.z.b.a());
        return g1;
    }
}
