// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.wantu.view.TFilterListScrollView;

public class bpw extends ArrayAdapter
{

    final TFilterListScrollView a;
    private LayoutInflater b;

    public bpw(TFilterListScrollView tfilterlistscrollview, Context context, bpz abpz[])
    {
        a = tfilterlistscrollview;
        super(context, 0x7f030081, abpz);
        b = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        bpz bpz1 = (bpz)getItem(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        obj = view;
        view = b.inflate(0x7f03009b, viewgroup, false);
        obj = view;
        ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0d01ef);
        obj = view;
        TextView textview = (TextView)view.findViewById(0x7f0d01f0);
        obj = view;
        textview.setText(bpz1.b);
        obj = view;
        imagebutton.setTag(bpz1.b);
        obj = view;
        viewgroup = new bpx(this, null);
        obj = view;
        viewgroup.a = imagebutton;
        obj = view;
        viewgroup.b = textview;
        obj = view;
        view.setTag(viewgroup);
_L11:
        ((bpx) (viewgroup)).a.setImageBitmap(bpz1.a);
        if (TFilterListScrollView.access$100(a) != i) goto _L4; else goto _L3
_L3:
        ((bpx) (viewgroup)).a.setSelected(true);
_L7:
        return view;
_L2:
        obj = view;
        viewgroup = (bpx)view.getTag();
        obj = view;
        ((bpx) (viewgroup)).a.setImageBitmap(null);
        obj = view;
        ((bpx) (viewgroup)).a.setSelected(false);
        obj = view;
        ((bpx) (viewgroup)).a.setTag(bpz1.b);
        obj = view;
        try
        {
            ((bpx) (viewgroup)).b.setText(bpz1.b);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            viewgroup = ((ViewGroup) (obj));
            obj = view;
        }
          goto _L5
_L4:
        ((bpx) (viewgroup)).a.setSelected(false);
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        viewgroup = view;
_L9:
        ((Exception) (obj)).printStackTrace();
        return viewgroup;
_L5:
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }
}
