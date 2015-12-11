// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.wjj.eneity.Canliu;
import java.util.List;

// Referenced classes of package com.wjj.adapter.base:
//            MyBaseAdapter

public class JunkCanliuAdapter extends MyBaseAdapter
{
    class ViewHolder
    {

        CheckBox check_box;
        TextView name;
        TextView size;
        final JunkCanliuAdapter this$0;


        public ViewHolder(View view)
        {
            this$0 = JunkCanliuAdapter.this;
            super();
            check_box = (CheckBox)view.findViewById(0x7f07025b);
            name = (TextView)view.findViewById(0x7f070259);
            size = (TextView)view.findViewById(0x7f07025a);
            check_box.setOnCheckedChangeListener(new _cls1());
        }
    }


    public JunkCanliuAdapter(Context context)
    {
        super(context);
    }

    public View MygetView(int i, View view, ViewGroup viewgroup)
    {
        Canliu canliu;
        if (view == null)
        {
            view = inflater.inflate(0x7f030062, null);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        canliu = (Canliu)list.get(i);
        ((ViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(i));
        ((ViewHolder) (viewgroup)).name.setText(canliu.runingsoftname);
        ((ViewHolder) (viewgroup)).size.setText((new StringBuilder(String.valueOf(canliu.memory))).toString());
        ((ViewHolder) (viewgroup)).check_box.setChecked(canliu.ischecked);
        return view;
    }

    // Unreferenced inner class com/wjj/adapter/base/JunkCanliuAdapter$ViewHolder$1

/* anonymous class */
    class ViewHolder._cls1
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final ViewHolder this$1;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            int i = ((Integer)check_box.getTag()).intValue();
            ((Canliu)list.get(i)).ischecked = flag;
        }

            
            {
                this$1 = ViewHolder.this;
                super();
            }
    }

}
