// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.ui.RecyclingImageView;
import com.wantu.view.TFilterListScrollView;

public class yq extends ArrayAdapter
{

    final TFilterListScrollView a;
    private LayoutInflater b;

    public yq(TFilterListScrollView tfilterlistscrollview, Context context, yt ayt[])
    {
        a = tfilterlistscrollview;
        super(context, 0x7f03003d, ayt);
        b = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        yt yt1 = (yt)getItem(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        obj = view;
        view = b.inflate(0x7f03003d, viewgroup, false);
        obj = view;
        RecyclingImageView recyclingimageview = (RecyclingImageView)view.findViewById(0x7f0c0127);
        obj = view;
        TextView textview = (TextView)view.findViewById(0x7f0c0128);
        obj = view;
        textview.setText(yt1.b);
        obj = view;
        recyclingimageview.setTag(yt1.b);
        obj = view;
        viewgroup = new yr(this, null);
        obj = view;
        viewgroup.a = recyclingimageview;
        obj = view;
        viewgroup.b = textview;
        obj = view;
        view.setTag(viewgroup);
_L11:
        obj = yt1.c;
        if (yt1.a != -1)
        {
            obj = ev.a(a.getResources().getDrawable(yt1.a));
        }
        ((yr) (viewgroup)).a.setImageBitmap(((android.graphics.Bitmap) (obj)));
        if (TFilterListScrollView.access$100(a) != i) goto _L4; else goto _L3
_L3:
        ((yr) (viewgroup)).a.setSelected(true);
_L7:
        return view;
_L2:
        obj = view;
        viewgroup = (yr)view.getTag();
        obj = view;
        ((yr) (viewgroup)).a.setImageBitmap(null);
        obj = view;
        ((yr) (viewgroup)).a.setSelected(false);
        obj = view;
        ((yr) (viewgroup)).a.setTag(yt1.b);
        obj = view;
        try
        {
            ((yr) (viewgroup)).b.setText(yt1.b);
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
        ((yr) (viewgroup)).a.setSelected(false);
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
