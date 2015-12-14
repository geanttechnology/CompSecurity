// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cb;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bumptech.glide.request.e;
import com.picsart.shop.a;
import com.socialin.android.util.c;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package myobfuscated.cb:
//            b, e, c

public class d extends BaseAdapter
{

    public final String a = (new StringBuilder()).append(myobfuscated/cb/d.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
    public List b;
    private Context c;
    private int d;
    private boolean e;
    private SparseArray f;
    private com.picsart.studio.d g;
    private e h;
    private b i;

    public d(Context context, int j)
    {
        d = 0;
        e = false;
        f = new SparseArray();
        i = new b();
        b = new ArrayList();
        c = context;
        d = j;
        e = false;
        h = (e)com.bumptech.glide.request.e.c(context.getApplicationContext()).a(0x7f020567);
        g = new com.picsart.studio.d(context.getApplicationContext());
    }

    public final void a(myobfuscated.cb.c c1)
    {
        b.add(c1);
    }

    public int getCount()
    {
        return b.size();
    }

    public Object getItem(int j)
    {
        return b.get(j);
    }

    public long getItemId(int j)
    {
        return (long)j;
    }

    public View getView(int j, View view, ViewGroup viewgroup)
    {
        myobfuscated.cb.e e1;
        Object obj;
        if (view == null)
        {
            viewgroup = LayoutInflater.from(c).inflate(d, viewgroup, false);
            e1 = new myobfuscated.cb.e();
            e1.a = (ImageView)viewgroup.findViewById(0x7f100282);
            f.put(viewgroup.hashCode(), e1);
        } else
        {
            e1 = (myobfuscated.cb.e)f.get(view.hashCode());
            viewgroup = view;
        }
        obj = (myobfuscated.cb.c)b.get(j);
        if (((myobfuscated.cb.c) (obj)).e != null)
        {
            e = true;
            view = ((myobfuscated.cb.c) (obj)).e;
            throw new NullPointerException();
        }
        if (!((myobfuscated.cb.c) (obj)).i) goto _L2; else goto _L1
_L1:
        if (((myobfuscated.cb.c) (obj)).f != null)
        {
            e1.a.setBackgroundDrawable(((myobfuscated.cb.c) (obj)).f);
            return viewgroup;
        }
        view = i.a(j);
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        obj = com.picsart.shop.a.a().c(((myobfuscated.cb.c) (obj)).j, ((myobfuscated.cb.c) (obj)).l);
        obj = com.socialin.android.util.c.a(((byte []) (obj)), 0, obj.length, null, a);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        obj = new myobfuscated.cd.a(c.getResources(), ((android.graphics.Bitmap) (obj)));
        i.a(j, ((myobfuscated.cd.a) (obj)));
        view = ((View) (obj));
_L3:
        if (e)
        {
            e1.a.setBackgroundDrawable(view);
            return viewgroup;
        } else
        {
            e1.a.setImageDrawable(view);
            return viewgroup;
        }
        obj;
_L4:
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L3
_L2:
        String s;
        s = ((myobfuscated.cb.c) (obj)).c;
        String s1 = ((myobfuscated.cb.c) (obj)).h;
        view = ((myobfuscated.cb.c) (obj)).g;
        if (s1 != null)
        {
            g.a((new StringBuilder("file://")).append(s1).toString(), e1.a, h);
            return viewgroup;
        }
        if (view != null)
        {
            g.a(view, e1.a, h);
            return viewgroup;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        try
        {
            view = i.a(j);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return viewgroup;
        }
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        view = new myobfuscated.cd.a(c.getResources(), com.socialin.android.util.c.a(c.getResources(), ((myobfuscated.cb.c) (obj)).b, null, a));
        i.a(j, view);
        if (!e)
        {
            break MISSING_BLOCK_LABEL_473;
        }
        e1.a.setBackgroundDrawable(view);
        return viewgroup;
        e1.a.setImageDrawable(view);
        return viewgroup;
        g.a(s, e1.a, h);
        return viewgroup;
        Exception exception;
        exception;
        view = ((View) (obj));
        obj = exception;
          goto _L4
    }

    public boolean hasStableIds()
    {
        return true;
    }
}
