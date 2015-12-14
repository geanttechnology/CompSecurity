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
import com.crashlytics.android.Crashlytics;
import com.fotoable.fotoproedit.activity.filter.TFilterListScrollView;

public class gv extends ArrayAdapter
{

    final TFilterListScrollView a;
    private LayoutInflater b;

    public gv(TFilterListScrollView tfilterlistscrollview, Context context, gy agy[])
    {
        a = tfilterlistscrollview;
        super(context, 0x7f0300ca, agy);
        b = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        gy gy1 = (gy)getItem(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        obj = view;
        view = b.inflate(0x7f0300ca, viewgroup, false);
        obj = view;
        ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0c0127);
        obj = view;
        TextView textview = (TextView)view.findViewById(0x7f0c0128);
        obj = view;
        textview.setText(gy1.b);
        obj = view;
        imagebutton.setTag(gy1.b);
        obj = view;
        viewgroup = new gw(this, null);
        obj = view;
        viewgroup.a = imagebutton;
        obj = view;
        viewgroup.b = textview;
        obj = view;
        view.setTag(viewgroup);
_L11:
        obj = gy1.c;
        if (gy1.a != -1)
        {
            obj = ev.a(a.getResources().getDrawable(gy1.a));
        }
        ((gw) (viewgroup)).a.setImageBitmap(((android.graphics.Bitmap) (obj)));
        if (TFilterListScrollView.access$100(a) != i) goto _L4; else goto _L3
_L3:
        ((gw) (viewgroup)).a.setSelected(true);
_L7:
        return view;
_L2:
        obj = view;
        viewgroup = (gw)view.getTag();
        obj = view;
        ((gw) (viewgroup)).a.setImageBitmap(null);
        obj = view;
        ((gw) (viewgroup)).a.setSelected(false);
        obj = view;
        ((gw) (viewgroup)).a.setTag(gy1.b);
        obj = view;
        try
        {
            ((gw) (viewgroup)).b.setText(gy1.b);
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
        ((gw) (viewgroup)).a.setSelected(false);
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        viewgroup = view;
_L9:
        ((Exception) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return viewgroup;
_L5:
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }
}
