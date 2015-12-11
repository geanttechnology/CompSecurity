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
import android.widget.ImageView;
import android.widget.TextView;
import com.wjj.eneity.RuningApp;
import com.wjj.manager.CommonUtil;
import java.util.List;

// Referenced classes of package com.wjj.adapter.base:
//            MyBaseAdapter

public class BoostPhoneAdapter extends MyBaseAdapter
{
    class ViewHolder
    {

        CheckBox check_box;
        ImageView iv_icon;
        final BoostPhoneAdapter this$0;
        TextView tv_appname;
        TextView tv_appsize;


        public ViewHolder(View view)
        {
            this$0 = BoostPhoneAdapter.this;
            super();
            check_box = (CheckBox)view.findViewById(0x7f070254);
            iv_icon = (ImageView)view.findViewById(0x7f070252);
            tv_appname = (TextView)view.findViewById(0x7f07024e);
            tv_appsize = (TextView)view.findViewById(0x7f070253);
            check_box.setOnCheckedChangeListener(new _cls1());
        }
    }


    public BoostPhoneAdapter(Context context)
    {
        super(context);
    }

    public View MygetView(int i, View view, ViewGroup viewgroup)
    {
        RuningApp runingapp;
        if (view == null)
        {
            view = inflater.inflate(0x7f03005e, null);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        runingapp = (RuningApp)list.get(i);
        ((ViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(i));
        ((ViewHolder) (viewgroup)).tv_appname.setText(runingapp.runingsoftname);
        ((ViewHolder) (viewgroup)).iv_icon.setImageDrawable(runingapp.icon);
        ((ViewHolder) (viewgroup)).tv_appsize.setText(CommonUtil.formatSizeDanwei(runingapp.memory));
        ((ViewHolder) (viewgroup)).check_box.setChecked(runingapp.ischecked);
        return view;
    }

    // Unreferenced inner class com/wjj/adapter/base/BoostPhoneAdapter$ViewHolder$1

/* anonymous class */
    class ViewHolder._cls1
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final ViewHolder this$1;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            int i = ((Integer)check_box.getTag()).intValue();
            ((RuningApp)list.get(i)).ischecked = flag;
        }

            
            {
                this$1 = ViewHolder.this;
                super();
            }
    }

}
