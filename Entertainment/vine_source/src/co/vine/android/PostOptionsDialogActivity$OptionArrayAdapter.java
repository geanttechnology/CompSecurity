// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Referenced classes of package co.vine.android:
//            PostOptionsDialogActivity

private class this._cls0 extends ArrayAdapter
{

    final PostOptionsDialogActivity this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        viewgroup = (this._cls0)getItem(i);
        TextView textview = (TextView)view.findViewById(0x7f0a014c);
        if (((getItem) (viewgroup)).getItem == 7)
        {
            textview.setTextColor(getResources().getColor(0x7f090081));
        } else
        {
            textview.setTextColor(getResources().getColor(0x7f090078));
        }
        textview.setText(((getItem) (viewgroup)).getItem);
        view.setTag(Integer.valueOf(((getItem) (viewgroup)).getItem));
        return view;
    }

    public (Context context, int i)
    {
        this$0 = PostOptionsDialogActivity.this;
        super(context, i);
    }
}
