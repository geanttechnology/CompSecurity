// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class GuestsPickerAdapter extends BaseAdapter
{
    public static final class DataType extends Enum
    {

        private static final DataType $VALUES[];
        public static final DataType ADULTS;
        public static final DataType CHILDREN;

        public static DataType valueOf(String s)
        {
            return (DataType)Enum.valueOf(com/groupon/adapter/GuestsPickerAdapter$DataType, s);
        }

        public static DataType[] values()
        {
            return (DataType[])$VALUES.clone();
        }

        static 
        {
            ADULTS = new DataType("ADULTS", 0);
            CHILDREN = new DataType("CHILDREN", 1);
            $VALUES = (new DataType[] {
                ADULTS, CHILDREN
            });
        }

        private DataType(String s, int i)
        {
            super(s, i);
        }
    }


    private final Context context;
    private final List dataList;
    private final DataType dataType;
    private final LayoutInflater inflater;
    private int selectedPosition;

    public GuestsPickerAdapter(Context context1, List list, DataType datatype)
    {
        context = context1;
        dataList = list;
        dataType = datatype;
        inflater = LayoutInflater.from(context1);
    }

    public int getCount()
    {
        if (dataList != null)
        {
            return dataList.size();
        } else
        {
            return 0;
        }
    }

    public Integer getItem(int i)
    {
        if (dataList != null)
        {
            return (Integer)dataList.get(i);
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

    public int getPosition(Integer integer)
    {
        for (int i = 0; i < dataList.size(); i++)
        {
            if (integer.equals(dataList.get(i)))
            {
                return i;
            }
        }

        return 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        TextView textview;
        int j;
        j = ((Integer)dataList.get(i)).intValue();
        viewgroup = inflater.inflate(0x7f03018c, viewgroup, false);
        textview = (TextView)viewgroup.findViewById(0x7f100208);
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$adapter$GuestsPickerAdapter$DataType[];

            static 
            {
                $SwitchMap$com$groupon$adapter$GuestsPickerAdapter$DataType = new int[DataType.values().length];
                try
                {
                    $SwitchMap$com$groupon$adapter$GuestsPickerAdapter$DataType[DataType.ADULTS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$adapter$GuestsPickerAdapter$DataType[DataType.CHILDREN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.adapter.GuestsPickerAdapter.DataType[dataType.ordinal()];
        JVM INSTR tableswitch 1 2: default 76
    //                   1 120
    //                   2 162;
           goto _L1 _L2 _L3
_L1:
        view = "";
_L5:
        textview.setText(view);
        if (i == selectedPosition)
        {
            textview.setTextColor(context.getResources().getColor(0x7f0e01a9));
            textview.setTextSize(1, 20F);
        }
        return viewgroup;
_L2:
        if (j == -1)
        {
            view = "";
        } else
        {
            view = context.getResources().getQuantityString(0x7f0c0000, j, new Object[] {
                Integer.valueOf(j)
            });
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == -1)
        {
            view = "";
        } else
        {
            view = context.getResources().getQuantityString(0x7f0c0003, j, new Object[] {
                Integer.valueOf(j)
            });
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setSelectedPosition(int i)
    {
        selectedPosition = i;
        notifyDataSetChanged();
    }
}
