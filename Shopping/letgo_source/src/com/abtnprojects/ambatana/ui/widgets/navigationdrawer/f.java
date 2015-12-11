// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.content.Context;
import android.support.v7.akj;
import android.support.v7.aky;
import android.support.v7.alc;
import android.support.v7.ih;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.abtnprojects.ambatana.models.DrawerMenuItem;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets.navigationdrawer:
//            l, j, h, i, 
//            a, k, g

public class f extends android.support.v7.widget.RecyclerView.Adapter
{

    private List a;
    private g b;
    private int c;
    private View d;
    private int e;

    public f(List list)
    {
        a = list;
        c = 0;
    }

    static int a(f f1, int i1)
    {
        f1.e = i1;
        return i1;
    }

    static View a(f f1)
    {
        return f1.d;
    }

    static View a(f f1, View view)
    {
        f1.d = view;
        return view;
    }

    private void a(Context context, ImageView imageview)
    {
        aky.a(context).a(0x7f02010f).a(new ih()).a().c().a(imageview);
        imageview.setTag("false");
    }

    static void a(f f1, Context context, ImageView imageview)
    {
        f1.a(context, imageview);
    }

    private boolean a(String s)
    {
        return s != null && !s.equals("false");
    }

    static g b(f f1)
    {
        return f1.b;
    }

    private int d(int i1)
    {
        for (int j1 = 0; j1 < getItemCount(); j1++)
        {
            if (((DrawerMenuItem)a.get(j1)).getId() == i1)
            {
                return j1;
            }
        }

        return -1;
    }

    public k a(ViewGroup viewgroup, int i1)
    {
        Object obj = null;
        i1;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 59
    //                   1 77
    //                   2 95
    //                   3 113;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        viewgroup = obj;
_L7:
        k k1 = l.a(i1, viewgroup);
        if (viewgroup != null)
        {
            viewgroup.setOnClickListener(new android.view.View.OnClickListener(k1) {

                final k a;
                final f b;

                public void onClick(View view)
                {
                    if (f.a(b) != null)
                    {
                        f.a(b).setSelected(false);
                    }
                    f.a(b, a.getAdapterPosition());
                    view.setSelected(true);
                    f.a(b, view);
                    if (f.b(b) != null)
                    {
                        f.b(b).a(a.getAdapterPosition());
                    }
                }

            
            {
                b = f.this;
                a = k1;
                super();
            }
            });
        }
        return k1;
_L2:
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f04004c, viewgroup, false);
        continue; /* Loop/switch isn't completed */
_L3:
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f04004d, viewgroup, false);
        continue; /* Loop/switch isn't completed */
_L4:
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f04004b, viewgroup, false);
        continue; /* Loop/switch isn't completed */
_L5:
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f04004a, viewgroup, false);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(int i1)
    {
        c = i1;
        i1 = d(4);
        if (i1 != -1)
        {
            notifyItemChanged(i1);
        }
    }

    public void a(DrawerMenuItem drawermenuitem)
    {
        int i1 = d(2);
        if (i1 != -1)
        {
            DrawerMenuItem drawermenuitem1 = (DrawerMenuItem)a.get(i1);
            if (!drawermenuitem.equals(drawermenuitem1))
            {
                drawermenuitem1.setFirstText(drawermenuitem.getFirstText());
                drawermenuitem1.setSecondaryText(drawermenuitem.getSecondaryText());
                drawermenuitem1.setUrlImage(drawermenuitem.getUrlImage());
                notifyItemChanged(i1);
            }
        }
    }

    public void a(g g)
    {
        b = g;
    }

    public void a(k k1, int i1)
    {
        boolean flag = false;
        int j1 = getItemViewType(i1);
        DrawerMenuItem drawermenuitem = (DrawerMenuItem)a.get(i1);
        switch (j1)
        {
        default:
            return;

        case 0: // '\0'
            k1 = (j)k1;
            Context context = ((j) (k1)).a.getContext();
            String s = drawermenuitem.getUrlImage();
            String s1 = (String)((j) (k1)).a.getTag();
            if (!a(s))
            {
                a(context, ((j) (k1)).a);
            } else
            {
                i1 = ((flag) ? 1 : 0);
                if (!s.equals(s1))
                {
                    i1 = 1;
                }
                if (s1 == null || i1 != 0)
                {
                    aky.a(context).a(s).a(new ih()).a().c().a(((j) (k1)).a, new akj(k1, s, context) {

                        final j a;
                        final String b;
                        final Context c;
                        final f d;

                        public void a()
                        {
                            a.a.setTag(b);
                        }

                        public void b()
                        {
                            f.a(d, c, a.a);
                        }

            
            {
                d = f.this;
                a = j1;
                b = s;
                c = context;
                super();
            }
                    });
                }
            }
            ((j) (k1)).b.setText(drawermenuitem.getFirstText());
            ((j) (k1)).c.setText(drawermenuitem.getSecondaryText());
            return;

        case 1: // '\001'
            k1 = (h)k1;
            ((h) (k1)).a.setBackgroundResource(drawermenuitem.getIconResource());
            ((h) (k1)).b.setText(drawermenuitem.getFirstText());
            return;

        case 2: // '\002'
            k1 = (i)k1;
            ((i) (k1)).a.setBackgroundResource(drawermenuitem.getIconResource());
            ((i) (k1)).b.setText(drawermenuitem.getFirstText());
            return;

        case 3: // '\003'
            k1 = (a)k1;
            ((a) (k1)).a.setBackgroundResource(drawermenuitem.getIconResource());
            ((a) (k1)).b.setText(drawermenuitem.getFirstText());
            ((a) (k1)).c.setText(Integer.toString(c));
            k1 = ((a) (k1)).c;
            if (c > 0)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            k1.setVisibility(i1);
            return;
        }
    }

    public void b(int i1)
    {
        e = i1;
        notifyItemChanged(i1);
    }

    public long c(int i1)
    {
        return (long)((DrawerMenuItem)a.get(i1)).getId();
    }

    public int getItemCount()
    {
        if (a != null)
        {
            return a.size();
        } else
        {
            return 0;
        }
    }

    public long getItemId(int i1)
    {
        return (long)i1;
    }

    public int getItemViewType(int i1)
    {
        return ((DrawerMenuItem)a.get(i1)).getTypeId();
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i1)
    {
        a((k)viewholder, i1);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i1)
    {
        return a(viewgroup, i1);
    }
}
