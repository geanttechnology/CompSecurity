// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.da;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialin.android.util.c;
import java.util.ArrayList;
import java.util.HashMap;

public final class a extends BaseAdapter
{

    public int a;
    public int b;
    private com.socialin.camera.opengl.a c;
    private Activity d;
    private HashMap e;

    public a(Activity activity, com.socialin.camera.opengl.a a1)
    {
        a = 0;
        b = 0;
        c = a1;
        d = activity;
        e = new HashMap();
    }

    public final void a(int i)
    {
        a = i;
        notifyDataSetChanged();
    }

    public final int getCount()
    {
        return c.r.size();
    }

    public final Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        String s;
label0:
        {
            view1 = view;
            if (view == null)
            {
                view1 = LayoutInflater.from(d).inflate(0x7f03004c, viewgroup, false);
            }
            view1.setRotation(b);
            int j = ((Integer)c.r.get(i)).intValue();
            s = com.socialin.camera.opengl.a.a(d, j);
            viewgroup = (Bitmap)e.get(Integer.valueOf(j));
            if (viewgroup != null)
            {
                view = viewgroup;
                if (!viewgroup.isRecycled())
                {
                    break label0;
                }
            }
            view = new android.graphics.BitmapFactory.Options();
            view.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            view = com.socialin.android.util.c.a(d.getResources(), ((Integer)c.s.get(Integer.valueOf(j))).intValue(), view);
            e.put(Integer.valueOf(j), view);
        }
        ((TextView)view1.findViewById(0x7f100234)).setText(s);
        ((ImageView)view1.findViewById(0x7f100233)).setImageBitmap(view);
        if (a == i)
        {
            view1.findViewById(0x7f100235).setVisibility(0);
            return view1;
        } else
        {
            view1.findViewById(0x7f100235).setVisibility(4);
            return view1;
        }
    }
}
