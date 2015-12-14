// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.wantu.view.TMagFilterListScrollView2;

public class bqp extends ArrayAdapter
{

    final TMagFilterListScrollView2 a;
    private LayoutInflater b;

    public bqp(TMagFilterListScrollView2 tmagfilterlistscrollview2, Context context, bqs abqs[])
    {
        a = tmagfilterlistscrollview2;
        super(context, 0x7f030081, abqs);
        b = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        bqs bqs1 = (bqs)getItem(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        obj = view;
        view = b.inflate(0x7f03009b, viewgroup, false);
        obj = view;
        ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0d01ef);
        obj = view;
        TextView textview = (TextView)view.findViewById(0x7f0d01f0);
        obj = view;
        textview.setText(bqs1.b);
        obj = view;
        imagebutton.setTag(bqs1.b);
        obj = view;
        viewgroup = new bqq(this, null);
        obj = view;
        viewgroup.a = imagebutton;
        obj = view;
        viewgroup.b = textview;
        obj = view;
        view.setTag(viewgroup);
_L3:
        obj = yo.a(yo.a(a.getResources().getDrawable(bqs1.a)), 15F);
        ((bqq) (viewgroup)).a.setImageBitmap(((android.graphics.Bitmap) (obj)));
        return view;
_L2:
        obj = view;
        viewgroup = (bqq)view.getTag();
        obj = view;
        ((bqq) (viewgroup)).a.setImageBitmap(null);
        obj = view;
        ((bqq) (viewgroup)).a.setSelected(false);
        obj = view;
        ((bqq) (viewgroup)).a.setTag(bqs1.b);
        obj = view;
        ((bqq) (viewgroup)).b.setText(bqs1.b);
        obj = view;
        if (TMagFilterListScrollView2.access$100(a) != i)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj = view;
        ((bqq) (viewgroup)).a.setSelected(true);
          goto _L3
        obj = view;
        ((bqq) (viewgroup)).a.setSelected(false);
          goto _L3
        view;
_L5:
        view.printStackTrace();
        return ((View) (obj));
        viewgroup;
        obj = view;
        view = viewgroup;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
