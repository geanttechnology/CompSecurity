// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.squareup.timessquare:
//            CalendarGridView, CalendarRowView, Logr, MonthDescriptor, 
//            MonthCellDescriptor, CalendarCellView, CalendarCellDecorator

public class MonthView extends LinearLayout
{
    public static interface Listener
    {

        public abstract void handleClick(MonthCellDescriptor monthcelldescriptor);
    }


    private List decorators;
    CalendarGridView grid;
    private boolean isRtl;
    private Listener listener;
    TextView title;

    public MonthView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public static MonthView create(ViewGroup viewgroup, LayoutInflater layoutinflater, DateFormat dateformat, Listener listener1, Calendar calendar, int i, int j, int k, 
            int l, boolean flag, int i1, List list, Locale locale)
    {
        viewgroup = (MonthView)layoutinflater.inflate(R.layout.month, viewgroup, false);
        viewgroup.setDividerColor(i);
        viewgroup.setDayTextColor(k);
        viewgroup.setTitleTextColor(l);
        viewgroup.setDisplayHeader(flag);
        viewgroup.setHeaderTextColor(i1);
        if (j != 0)
        {
            viewgroup.setDayBackground(j);
        }
        j = calendar.get(7);
        viewgroup.isRtl = isRtl(locale);
        k = calendar.getFirstDayOfWeek();
        layoutinflater = (CalendarRowView)((MonthView) (viewgroup)).grid.getChildAt(0);
        for (i = 0; i < 7; i++)
        {
            calendar.set(7, getDayOfWeek(k, i, ((MonthView) (viewgroup)).isRtl));
            ((TextView)layoutinflater.getChildAt(i)).setText(dateformat.format(calendar.getTime()));
        }

        calendar.set(7, j);
        viewgroup.listener = listener1;
        viewgroup.decorators = list;
        return viewgroup;
    }

    private static int getDayOfWeek(int i, int j, boolean flag)
    {
        j = i + j;
        i = j;
        if (flag)
        {
            i = 8 - j;
        }
        return i;
    }

    private static boolean isRtl(Locale locale)
    {
        boolean flag = false;
        byte byte0 = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        if (byte0 == 1 || byte0 == 2)
        {
            flag = true;
        }
        return flag;
    }

    public List getDecorators()
    {
        return decorators;
    }

    public void init(MonthDescriptor monthdescriptor, List list, boolean flag, Typeface typeface, Typeface typeface1)
    {
        Logr.d("Initializing MonthView (%d) for %s", new Object[] {
            Integer.valueOf(System.identityHashCode(this)), monthdescriptor
        });
        long l1 = System.currentTimeMillis();
        title.setText(monthdescriptor.getLabel());
        int l = list.size();
        grid.setNumRows(l);
label0:
        for (int j = 0; j < 6; j++)
        {
            monthdescriptor = (CalendarRowView)grid.getChildAt(j + 1);
            monthdescriptor.setListener(listener);
            if (j < l)
            {
                monthdescriptor.setVisibility(0);
                List list1 = (List)list.get(j);
                int i = 0;
                do
                {
                    if (i >= list1.size())
                    {
                        continue label0;
                    }
                    MonthCellDescriptor monthcelldescriptor;
                    CalendarCellView calendarcellview;
                    String s;
                    int k;
                    boolean flag1;
                    if (isRtl)
                    {
                        k = 6 - i;
                    } else
                    {
                        k = i;
                    }
                    monthcelldescriptor = (MonthCellDescriptor)list1.get(k);
                    calendarcellview = (CalendarCellView)monthdescriptor.getChildAt(i);
                    s = Integer.toString(monthcelldescriptor.getValue());
                    if (!calendarcellview.getText().equals(s))
                    {
                        calendarcellview.setText(s);
                    }
                    calendarcellview.setEnabled(monthcelldescriptor.isCurrentMonth());
                    if (!flag)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    calendarcellview.setClickable(flag1);
                    calendarcellview.setSelectable(monthcelldescriptor.isSelectable());
                    calendarcellview.setSelected(monthcelldescriptor.isSelected());
                    calendarcellview.setCurrentMonth(monthcelldescriptor.isCurrentMonth());
                    calendarcellview.setToday(monthcelldescriptor.isToday());
                    calendarcellview.setRangeState(monthcelldescriptor.getRangeState());
                    calendarcellview.setHighlighted(monthcelldescriptor.isHighlighted());
                    calendarcellview.setTag(monthcelldescriptor);
                    if (decorators != null)
                    {
                        for (Iterator iterator = decorators.iterator(); iterator.hasNext(); ((CalendarCellDecorator)iterator.next()).decorate(calendarcellview, monthcelldescriptor.getDate())) { }
                    }
                    i++;
                } while (true);
            }
            monthdescriptor.setVisibility(8);
        }

        if (typeface != null)
        {
            title.setTypeface(typeface);
        }
        if (typeface1 != null)
        {
            grid.setTypeface(typeface1);
        }
        Logr.d("MonthView.init took %d ms", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l1)
        });
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        title = (TextView)findViewById(R.id.title);
        grid = (CalendarGridView)findViewById(R.id.calendar_grid);
    }

    public void setDayBackground(int i)
    {
        grid.setDayBackground(i);
    }

    public void setDayTextColor(int i)
    {
        grid.setDayTextColor(i);
    }

    public void setDecorators(List list)
    {
        decorators = list;
    }

    public void setDisplayHeader(boolean flag)
    {
        grid.setDisplayHeader(flag);
    }

    public void setDividerColor(int i)
    {
        grid.setDividerColor(i);
    }

    public void setHeaderTextColor(int i)
    {
        grid.setHeaderTextColor(i);
    }

    public void setTitleTextColor(int i)
    {
        title.setTextColor(i);
    }
}
