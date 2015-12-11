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
import com.wjj.eneity.SoftApk;
import com.wjj.utils.CommonUtil;
import java.util.List;

// Referenced classes of package com.wjj.adapter.base:
//            MyBaseAdapter

public class ApkSoftAdapter extends MyBaseAdapter
{
    class ViewHolder
    {

        CheckBox check_box;
        ImageView iv_icon;
        TextView soft_version;
        final ApkSoftAdapter this$0;
        TextView tv_softname;
        TextView tv_softsizi;


        public ViewHolder(View view)
        {
            this$0 = ApkSoftAdapter.this;
            super();
            soft_version = (TextView)view.findViewById(0x7f07024f);
            check_box = (CheckBox)view.findViewById(0x7f070251);
            iv_icon = (ImageView)view.findViewById(0x7f07024d);
            tv_softname = (TextView)view.findViewById(0x7f07024e);
            tv_softsizi = (TextView)view.findViewById(0x7f070250);
            check_box.setOnCheckedChangeListener(new _cls1());
        }
    }


    public ApkSoftAdapter(Context context)
    {
        super(context);
    }

    public static Double roundDouble(double d, int i)
    {
        double d1 = i;
        try
        {
            d1 = Math.pow(10D, d1);
            d = Math.floor(d * d1 + 0.5D) / d1;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return Double.valueOf(d);
    }

    public View MygetView(int i, View view, ViewGroup viewgroup)
    {
        SoftApk softapk;
        if (view == null)
        {
            view = inflater.inflate(0x7f03005d, null);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        softapk = (SoftApk)list.get(i);
        ((ViewHolder) (viewgroup)).check_box.setTag(Integer.valueOf(i));
        ((ViewHolder) (viewgroup)).tv_softname.setText(softapk.apkname);
        ((ViewHolder) (viewgroup)).iv_icon.setImageDrawable(softapk.icon);
        ((ViewHolder) (viewgroup)).tv_softsizi.setText(CommonUtil.formatSize(softapk.apksize));
        ((ViewHolder) (viewgroup)).soft_version.setText(softapk.apkversioncode);
        ((ViewHolder) (viewgroup)).check_box.setChecked(softapk.ischecked);
        return view;
    }

    // Unreferenced inner class com/wjj/adapter/base/ApkSoftAdapter$ViewHolder$1

/* anonymous class */
    class ViewHolder._cls1
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final ViewHolder this$1;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            int i = ((Integer)check_box.getTag()).intValue();
            ((SoftApk)list.get(i)).ischecked = flag;
        }

            
            {
                this$1 = ViewHolder.this;
                super();
            }
    }

}
