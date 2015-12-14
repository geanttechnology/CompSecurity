// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.util.c;
import com.socialin.android.brushlib.view.DrawingView;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class b extends BaseAdapter
{

    final DrawingActivity a;
    private List b;

    public b(DrawingActivity drawingactivity, List list)
    {
        a = drawingactivity;
        super();
        b = list;
    }

    static List a(b b1)
    {
        return b1.b;
    }

    public final int getCount()
    {
        return DrawingActivity.b(a).h();
    }

    public final volatile Object getItem(int i)
    {
        return null;
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = a.getLayoutInflater().inflate(0x7f0300b1, null);
        }
        com.socialin.android.brushlib.layer.b b1 = (com.socialin.android.brushlib.layer.b)b.get(i);
        ImageView imageview;
        c c1;
        if (DrawingActivity.b(a).c.b == b1)
        {
            viewgroup.setBackgroundResource(0x7f0f0094);
        } else
        {
            viewgroup.setBackgroundResource(0x7f02068f);
        }
        if (b1.f)
        {
            ((ImageView)viewgroup.findViewById(0x7f1003bf)).setImageResource(0x7f020659);
        } else
        {
            ((ImageView)viewgroup.findViewById(0x7f1003bf)).setImageResource(0x7f020264);
        }
        viewgroup.findViewById(0x7f1003bf).setOnClickListener(new android.view.View.OnClickListener(b1) {

            private com.socialin.android.brushlib.layer.b a;
            private b b;

            public final void onClick(View view1)
            {
                view1 = DrawingActivity.b(b.a);
                com.socialin.android.brushlib.layer.b b2 = a;
                boolean flag;
                if (!a.f)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view1.setLayerVisibility(b2, flag);
                DrawingActivity.r(b.a).notifyDataSetChanged();
            }

            
            {
                b = b.this;
                a = b2;
                super();
            }
        });
        if (DrawingActivity.b(a).c.j != null && DrawingActivity.b(a).c.j.d == b1)
        {
            viewgroup.findViewById(0x7f1003c1).setVisibility(0);
        } else
        {
            viewgroup.findViewById(0x7f1003c1).setVisibility(8);
        }
        imageview = (ImageView)viewgroup.findViewById(0x7f1003c0);
        c1 = DrawingActivity.z(a);
        if (c1.a.containsKey(b1))
        {
            view = (BitmapDrawable)c1.a.get(b1);
        } else
        {
            view = new BitmapDrawable(c1.a());
            c1.a.put(b1, view);
        }
        imageview.setImageDrawable(view);
        return viewgroup;
    }
}
