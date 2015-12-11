// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groupon.models.hotel.Destination;

public class DestinationsAdapter extends ArrayAdapter
{

    private final String currentLocationString;
    private boolean isCurrentLocationEnabled;

    public DestinationsAdapter(Context context)
    {
        super(context, 0x7f030111);
        currentLocationString = context.getString(0x7f080118);
    }

    private boolean isHighlightedPosition(int i)
    {
        boolean flag = false;
        boolean flag1 = true;
        if (!isCurrentLocationEnabled)
        {
            if (i == 1 || getCount() == 1)
            {
                flag = true;
            }
            return flag;
        }
        if (i == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public int getCount()
    {
        int j = super.getCount();
        int i;
        if (isCurrentLocationEnabled)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + j;
    }

    public Destination getItem(int i)
    {
        if (isCurrentLocationEnabled)
        {
            if (i == 0)
            {
                return new Destination() {

                    final DestinationsAdapter this$0;

                    public String toString()
                    {
                        return currentLocationString;
                    }

            
            {
                this$0 = DestinationsAdapter.this;
                super();
            }
                };
            } else
            {
                return (Destination)super.getItem(i - 1);
            }
        } else
        {
            return (Destination)super.getItem(i);
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = (TextView)super.getView(i, view, viewgroup);
        int j;
        if (isHighlightedPosition(i))
        {
            j = 0x7f0e0165;
        } else
        {
            j = 0x7f0e00b5;
        }
        view.setTextColor(viewgroup.getContext().getResources().getColor(j));
        if (isCurrentLocationPosition(i))
        {
            i = 0x7f020145;
        } else
        {
            i = 0;
        }
        view.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        return view;
    }

    public boolean isCurrentLocationPosition(int i)
    {
        return isCurrentLocationEnabled && i == 0;
    }

    public void setCurrentLocationEnabled(boolean flag)
    {
        if (flag == isCurrentLocationEnabled)
        {
            return;
        } else
        {
            isCurrentLocationEnabled = flag;
            notifyDataSetChanged();
            return;
        }
    }

}
