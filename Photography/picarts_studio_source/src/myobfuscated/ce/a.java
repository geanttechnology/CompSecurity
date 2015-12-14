// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialin.android.util.am;

// Referenced classes of package myobfuscated.ce:
//            b

public final class a extends ArrayAdapter
{

    private Context a;

    public a(Context context)
    {
        super(context, 0x7f030254);
        a = context;
        new am(context);
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(a).inflate(0x7f0300b6, viewgroup, false);
        }
        view = (b)getItem(i);
        viewgroup = (TextView)view1.findViewById(0x7f1000f3);
        TextView textview = (TextView)view1.findViewById(0x7f1003da);
        ImageView imageview = (ImageView)view1.findViewById(0x7f1000f2);
        viewgroup.setText(((b) (view)).b);
        imageview.setImageResource(((b) (view)).a);
        if (((b) (view)).c != null)
        {
            textview.setVisibility(0);
            textview.setText(((b) (view)).c);
        } else
        {
            textview.setVisibility(8);
        }
        viewgroup.setEnabled(((b) (view)).d);
        view1.setId(((b) (view)).e);
        return view1;
    }

    public final boolean isEnabled(int i)
    {
        return ((b)getItem(i)).d;
    }
}
