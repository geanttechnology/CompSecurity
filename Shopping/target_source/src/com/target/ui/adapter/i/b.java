// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.mothership.model.store.interfaces.StoreCapability;
import com.target.ui.adapter.b.e;
import com.target.ui.util.ae;
import com.target.ui.view.DepartmentBadgeView;
import java.util.List;

public class com.target.ui.adapter.i.b extends e
{
    public static interface a
    {

        public abstract void a(StoreCapability storecapability);
    }

    public static class b
    {

        public ImageView action;
        public DepartmentBadgeView icon;
        public TextView name;
        public TextView subText;

        public b(View view)
        {
            name = (TextView)view.findViewById(0x7f1005c3);
            subText = (TextView)view.findViewById(0x7f1005c4);
            icon = (DepartmentBadgeView)view.findViewById(0x7f1005c2);
            action = (ImageView)view.findViewById(0x7f1005c5);
        }
    }


    private a mListener;

    public com.target.ui.adapter.i.b(Context context, List list)
    {
        super(context, list);
    }

    static a a(com.target.ui.adapter.i.b b1)
    {
        return b1.mListener;
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        final StoreCapability storeCapability = (StoreCapability)getItem(i);
        if (view == null)
        {
            view = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301fa, null, false);
            viewgroup = new b(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (b)view.getTag();
        }
        ((b) (viewgroup)).name.setText(storeCapability.a());
        if (!storeCapability.b().isEmpty() || !storeCapability.c().isEmpty())
        {
            ((b) (viewgroup)).action.setVisibility(0);
            ((b) (viewgroup)).action.setImageResource(0x7f020180);
            view.setEnabled(true);
        } else
        {
            ((b) (viewgroup)).action.setVisibility(8);
            view.setEnabled(false);
        }
        if (ae.b(storeCapability.a()) != null)
        {
            ((b) (viewgroup)).icon.setVisibility(0);
            ((b) (viewgroup)).icon.setDepartment(ae.b(storeCapability.a()));
        } else
        {
            ((b) (viewgroup)).icon.setVisibility(8);
        }
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final com.target.ui.adapter.i.b this$0;
            final StoreCapability val$storeCapability;

            public void onClick(View view1)
            {
                if (com.target.ui.adapter.i.b.a(com.target.ui.adapter.i.b.this) != null)
                {
                    com.target.ui.adapter.i.b.a(com.target.ui.adapter.i.b.this).a(storeCapability);
                }
            }

            
            {
                this$0 = com.target.ui.adapter.i.b.this;
                storeCapability = storecapability;
                super();
            }
        });
        return view;
    }
}
