// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.groupon.models.GenericAmount;
import com.groupon.models.IncentiveTicket;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            IncentiveTickets

private class <init> extends BaseAdapter
{

    private int checkedIndex;
    final IncentiveTickets this$0;

    public int getCount()
    {
        if (IncentiveTickets.access$000(IncentiveTickets.this) != null)
        {
            return IncentiveTickets.access$000(IncentiveTickets.this).size();
        } else
        {
            return 0;
        }
    }

    public IncentiveTicket getItem(int i)
    {
        if (IncentiveTickets.access$000(IncentiveTickets.this) != null)
        {
            return (IncentiveTicket)IncentiveTickets.access$000(IncentiveTickets.this).get(i);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        IncentiveTicket incentiveticket;
        if (view == null)
        {
            view = ((LayoutInflater)getApplicationContext().getSystemService("layout_inflater")).inflate(0x7f030145, viewgroup, false);
            viewgroup = new nit>(IncentiveTickets.this, null);
            viewgroup.eckBox = (RadioButton)view.findViewById(0x7f1003cc);
            viewgroup.me = (TextView)view.findViewById(0x7f10016b);
            viewgroup.lue = (TextView)view.findViewById(0x7f1003cd);
            viewgroup.fo = (TextView)view.findViewById(0x7f1003ce);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (fo)view.getTag();
        }
        incentiveticket = getItem(i);
        if (incentiveticket != null)
        {
            RadioButton radiobutton = ((getItem) (viewgroup)).eckBox;
            int j;
            boolean flag;
            if (isComingFromCheckout.booleanValue())
            {
                j = 0;
            } else
            {
                j = 8;
            }
            radiobutton.setVisibility(j);
            radiobutton = ((eckBox) (viewgroup)).eckBox;
            if (i == checkedIndex || Strings.equals(incentiveticket.type, selectedTicketType))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            radiobutton.setChecked(flag);
            ((checkedIndex) (viewgroup)).me.setText(incentiveticket.name);
            ((me) (viewgroup)).lue.setText(String.format(getString(0x7f080235), new Object[] {
                incentiveticket.points.getFormattedAmount()
            }));
            ((lue) (viewgroup)).fo.setText(String.format(getString(0x7f080234), new Object[] {
                incentiveticket.minimum_points.getFormattedAmount()
            }));
        }
        return view;
    }

    public void setCheckedIndex(int i)
    {
        checkedIndex = i;
    }

    private ()
    {
        this$0 = IncentiveTickets.this;
        super();
        checkedIndex = -1;
    }

    checkedIndex(checkedIndex checkedindex)
    {
        this();
    }
}
