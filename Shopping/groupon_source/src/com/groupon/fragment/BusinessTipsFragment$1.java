// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.db.models.Tip;
import com.groupon.util.Dates;
import com.j256.ormlite.dao.Dao;
import commonlib.adapter.OrmLiteListAdapter;
import java.util.Date;

// Referenced classes of package com.groupon.fragment:
//            BusinessTipsFragment

class this._cls0 extends OrmLiteListAdapter
{

    final BusinessTipsFragment this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (Tip)getItem(i);
        viewgroup = getActivity().getLayoutInflater().inflate(0x7f030050, viewgroup, false);
        TextView textview = (TextView)viewgroup.findViewById(0x7f10016b);
        if (textview != null)
        {
            textview.setText(((Tip) (view)).maskedName);
        }
        textview = (TextView)viewgroup.findViewById(0x7f10016a);
        if (textview != null)
        {
            textview.setText(((Tip) (view)).text.trim());
        }
        textview = (TextView)viewgroup.findViewById(0x7f10016c);
        if (textview != null)
        {
            textview.setText(Dates.getTimeStampStringExtended(getActivity(), ((Tip) (view)).updatedAt.getTime()));
        }
        viewgroup.setTag(Integer.valueOf(i));
        return viewgroup;
    }

    (Dao dao)
    {
        this$0 = BusinessTipsFragment.this;
        super(dao);
    }
}
