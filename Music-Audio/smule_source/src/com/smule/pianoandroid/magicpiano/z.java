// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.smule.android.f.c;
import com.smule.pianoandroid.utils.s;
import java.util.ArrayList;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            aa

public class z
    implements ListAdapter
{

    private ArrayList a;

    public z()
    {
    }

    public void a(ArrayList arraylist)
    {
        a = arraylist;
    }

    public boolean areAllItemsEnabled()
    {
        return true;
    }

    public int getCount()
    {
        return a.size();
    }

    public Object getItem(int i)
    {
        return a.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Context context = viewgroup.getContext();
        View view1 = view;
        if (view == null)
        {
            view1 = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030048, viewgroup, false);
        }
        view = (aa)a.get(i);
        viewgroup = (TextView)view1.findViewById(0x7f0a0171);
        viewgroup.setText(((aa) (view)).a);
        ImageView imageview = (ImageView)view1.findViewById(0x7f0a0040);
        ImageView imageview1 = (ImageView)view1.findViewById(0x7f0a0170);
        if (i == 0)
        {
            Bitmap bitmap = s.a().b();
            imageview1.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener(bitmap) {

                final Bitmap a;
                final z b;

                public void onLayoutChange(View view2, int j, int k, int l, int i1, int j1, int k1, 
                        int l1, int i2)
                {
                    c.a((ImageView)view2, a, 0xff444444, true);
                }

            
            {
                b = z.this;
                a = bitmap;
                super();
            }
            });
            c.a(imageview1, bitmap, 0xff444444, true);
            imageview1.setVisibility(0);
            imageview.setVisibility(4);
        } else
        {
            imageview.setImageDrawable(view1.getResources().getDrawable(((aa) (view)).b));
            imageview.setVisibility(0);
            imageview1.setVisibility(4);
        }
        if (((aa) (view)).c.booleanValue())
        {
            viewgroup.setTypeface(com.smule.pianoandroid.utils.z.c(context));
            viewgroup.setTextColor(context.getResources().getColorStateList(0x7f08008f));
        } else
        {
            viewgroup.setTypeface(com.smule.pianoandroid.utils.z.e(context));
            viewgroup.setTextColor(context.getResources().getColorStateList(0x7f08008e));
        }
        viewgroup = (TextView)view1.findViewById(0x7f0a0172);
        if (((aa) (view)).d > 0)
        {
            viewgroup.setVisibility(0);
            viewgroup.setText((new StringBuilder()).append("").append(((aa) (view)).d).toString());
            return view1;
        } else
        {
            viewgroup.setVisibility(8);
            return view1;
        }
    }

    public int getViewTypeCount()
    {
        return 1;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isEmpty()
    {
        return a.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        return true;
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
    }
}
