// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialin.android.util.s;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package myobfuscated.cx:
//            b, a

public final class c extends BaseAdapter
{

    final a a;
    private List b;
    private LayoutInflater c;

    public c(a a1, Context context, List list)
    {
        a = a1;
        super();
        b = new ArrayList();
        b = list;
        c = LayoutInflater.from(context);
    }

    public final int getCount()
    {
        return b.size();
    }

    public final Object getItem(int i)
    {
        return b.get(i);
    }

    public final long getItemId(int i)
    {
        return 0L;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        ImageView imageview;
        if (view == null)
        {
            view = c.inflate(0x7f030224, viewgroup, false);
        }
        viewgroup = (b)b.get(i);
        imageview = (ImageView)view.findViewById(0x7f100a05);
        if (myobfuscated.cx.a.f(a))
        {
            TextView textview = (TextView)view.findViewById(0x7f100a06);
            textview.setVisibility(0);
            textview.setText(((b) (viewgroup)).a);
        }
        if (((b) (viewgroup)).f)
        {
            i = ((b) (viewgroup)).c;
        } else
        {
            i = ((b) (viewgroup)).b;
        }
        imageview.setImageResource(i);
        imageview.setOnClickListener(new android.view.View.OnClickListener(viewgroup, imageview) {

            private b a;
            private ImageView b;
            private c c;

            public final void onClick(View view1)
            {
                if (!s.a(c.a.getActivity()) && !a.e)
                {
                    b.setImageResource(a.b);
                    myobfuscated.cx.a.k(c.a);
                    return;
                }
                myobfuscated.cv.c.a(a.d);
                if (a.f)
                {
                    myobfuscated.cx.a.a(c.a, a.d);
                    myobfuscated.cx.a.d(c.a).edit().putBoolean(a.a, false).apply();
                    return;
                } else
                {
                    myobfuscated.cx.a.b(c.a, a.d);
                    return;
                }
            }

            
            {
                c = c.this;
                a = b1;
                b = imageview;
                super();
            }
        });
        return view;
    }
}
