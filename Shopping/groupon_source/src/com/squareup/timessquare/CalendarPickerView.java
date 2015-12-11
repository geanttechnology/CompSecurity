// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.squareup.timessquare:
//            MonthCellDescriptor, MonthDescriptor, Logr, MonthView

public class CalendarPickerView extends ListView
{
    public static interface CellClickInterceptor
    {

        public abstract boolean onCellClicked(Date date);
    }

    private class CellClickedListener
        implements MonthView.Listener
    {

        final CalendarPickerView this$0;

        public void handleClick(MonthCellDescriptor monthcelldescriptor)
        {
            Date date = monthcelldescriptor.getDate();
            if (cellClickInterceptor == null || !cellClickInterceptor.onCellClicked(date)) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (CalendarPickerView.betweenDates(date, minCal, maxCal) && isDateSelectable(date))
            {
                break; /* Loop/switch isn't completed */
            }
            if (invalidDateListener != null)
            {
                invalidDateListener.onInvalidDateSelected(date);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            boolean flag = doSelectDate(date, monthcelldescriptor);
            if (dateListener != null)
            {
                if (flag)
                {
                    dateListener.onDateSelected(date);
                    return;
                } else
                {
                    dateListener.onDateUnselected(date);
                    return;
                }
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        private CellClickedListener()
        {
            this$0 = CalendarPickerView.this;
            super();
        }

    }

    public static interface DateSelectableFilter
    {

        public abstract boolean isDateSelectable(Date date);
    }

    private class DefaultOnInvalidDateSelectedListener
        implements OnInvalidDateSelectedListener
    {

        final CalendarPickerView this$0;

        public void onInvalidDateSelected(Date date)
        {
            date = getResources().getString(R.string.invalid_date, new Object[] {
                fullDateFormat.format(minCal.getTime()), fullDateFormat.format(maxCal.getTime())
            });
            Toast.makeText(getContext(), date, 0).show();
        }

        private DefaultOnInvalidDateSelectedListener()
        {
            this$0 = CalendarPickerView.this;
            super();
        }

    }

    public class FluentInitializer
    {

        final CalendarPickerView this$0;

        public FluentInitializer inMode(SelectionMode selectionmode)
        {
            selectionMode = selectionmode;
            validateAndUpdate();
            return this;
        }

        public FluentInitializer withSelectedDate(Date date)
        {
            return withSelectedDates(Arrays.asList(new Date[] {
                date
            }));
        }

        public FluentInitializer withSelectedDates(Collection collection)
        {
            if (selectionMode == SelectionMode.SINGLE && collection.size() > 1)
            {
                throw new IllegalArgumentException("SINGLE mode can't be used with multiple selectedDates");
            }
            if (selectionMode == SelectionMode.RANGE && collection.size() > 2)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("RANGE mode only allows two selectedDates.  You tried to pass ").append(collection.size()).toString());
            }
            if (collection != null)
            {
                Date date;
                for (collection = collection.iterator(); collection.hasNext(); selectDate(date))
                {
                    date = (Date)collection.next();
                }

            }
            scrollToSelectedDates();
            validateAndUpdate();
            return this;
        }

        public FluentInitializer()
        {
            this$0 = CalendarPickerView.this;
            super();
        }
    }

    private class MonthAdapter extends BaseAdapter
    {

        private final LayoutInflater inflater;
        final CalendarPickerView this$0;

        public int getCount()
        {
            return months.size();
        }

        public Object getItem(int i)
        {
            return months.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            view = (MonthView)view;
            if (view == null)
            {
                view = MonthView.create(viewgroup, inflater, weekdayNameFormat, listener, today, dividerColor, dayBackgroundResId, dayTextColorResId, titleTextColor, displayHeader, headerTextColor, decorators, locale);
            } else
            {
                view.setDecorators(decorators);
            }
            view.init((MonthDescriptor)months.get(i), (List)cells.get(i), displayOnly, titleTypeface, dateTypeface);
            return view;
        }

        public boolean isEnabled(int i)
        {
            return false;
        }

        private MonthAdapter()
        {
            this$0 = CalendarPickerView.this;
            super();
            inflater = LayoutInflater.from(getContext());
        }

    }

    private static class MonthCellWithMonthIndex
    {

        public MonthCellDescriptor cell;
        public int monthIndex;

        public MonthCellWithMonthIndex(MonthCellDescriptor monthcelldescriptor, int i)
        {
            cell = monthcelldescriptor;
            monthIndex = i;
        }
    }

    public static interface OnDateSelectedListener
    {

        public abstract void onDateSelected(Date date);

        public abstract void onDateUnselected(Date date);
    }

    public static interface OnInvalidDateSelectedListener
    {

        public abstract void onInvalidDateSelected(Date date);
    }

    public static final class SelectionMode extends Enum
    {

        private static final SelectionMode $VALUES[];
        public static final SelectionMode MULTIPLE;
        public static final SelectionMode RANGE;
        public static final SelectionMode SINGLE;

        public static SelectionMode valueOf(String s)
        {
            return (SelectionMode)Enum.valueOf(com/squareup/timessquare/CalendarPickerView$SelectionMode, s);
        }

        public static SelectionMode[] values()
        {
            return (SelectionMode[])$VALUES.clone();
        }

        static 
        {
            SINGLE = new SelectionMode("SINGLE", 0);
            MULTIPLE = new SelectionMode("MULTIPLE", 1);
            RANGE = new SelectionMode("RANGE", 2);
            $VALUES = (new SelectionMode[] {
                SINGLE, MULTIPLE, RANGE
            });
        }

        private SelectionMode(String s, int i)
        {
            super(s, i);
        }
    }


    private final MonthAdapter adapter = new MonthAdapter();
    private CellClickInterceptor cellClickInterceptor;
    private final List cells = new ArrayList();
    private DateSelectableFilter dateConfiguredListener;
    private OnDateSelectedListener dateListener;
    private Typeface dateTypeface;
    private int dayBackgroundResId;
    private int dayTextColorResId;
    private List decorators;
    private boolean displayHeader;
    private boolean displayOnly;
    private int dividerColor;
    private DateFormat fullDateFormat;
    private int headerTextColor;
    final List highlightedCals = new ArrayList();
    final List highlightedCells = new ArrayList();
    private OnInvalidDateSelectedListener invalidDateListener;
    final MonthView.Listener listener = new CellClickedListener();
    private Locale locale;
    private Calendar maxCal;
    private Calendar minCal;
    private Calendar monthCounter;
    private DateFormat monthNameFormat;
    final List months = new ArrayList();
    final List selectedCals = new ArrayList();
    final List selectedCells = new ArrayList();
    SelectionMode selectionMode;
    private int titleTextColor;
    private Typeface titleTypeface;
    Calendar today;
    private DateFormat weekdayNameFormat;

    public CalendarPickerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        invalidDateListener = new DefaultOnInvalidDateSelectedListener();
        Resources resources = context.getResources();
        attributeset = context.obtainStyledAttributes(attributeset, R.styleable.CalendarPickerView);
        int i = attributeset.getColor(R.styleable.CalendarPickerView_android_background, resources.getColor(R.color.calendar_bg));
        dividerColor = attributeset.getColor(R.styleable.CalendarPickerView_dividerColor, resources.getColor(R.color.calendar_divider));
        dayBackgroundResId = attributeset.getResourceId(R.styleable.CalendarPickerView_dayBackground, R.drawable.calendar_bg_selector);
        dayTextColorResId = attributeset.getResourceId(R.styleable.CalendarPickerView_dayTextColor, R.color.calendar_text_selector);
        titleTextColor = attributeset.getColor(R.styleable.CalendarPickerView_titleTextColor, resources.getColor(R.color.calendar_text_active));
        displayHeader = attributeset.getBoolean(R.styleable.CalendarPickerView_displayHeader, true);
        headerTextColor = attributeset.getColor(R.styleable.CalendarPickerView_headerTextColor, resources.getColor(R.color.calendar_text_active));
        attributeset.recycle();
        setDivider(null);
        setDividerHeight(0);
        setBackgroundColor(i);
        setCacheColorHint(i);
        locale = Locale.getDefault();
        today = Calendar.getInstance(locale);
        minCal = Calendar.getInstance(locale);
        maxCal = Calendar.getInstance(locale);
        monthCounter = Calendar.getInstance(locale);
        monthNameFormat = new SimpleDateFormat(context.getString(R.string.month_name_format), locale);
        weekdayNameFormat = new SimpleDateFormat(context.getString(R.string.day_name_format), locale);
        fullDateFormat = DateFormat.getDateInstance(2, locale);
        if (isInEditMode())
        {
            context = Calendar.getInstance(locale);
            context.add(1, 1);
            init(new Date(), context.getTime()).withSelectedDate(new Date());
        }
    }

    private Date applyMultiSelect(Date date, Calendar calendar)
    {
        Iterator iterator = selectedCells.iterator();
        Object obj;
        do
        {
            obj = date;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (MonthCellDescriptor)iterator.next();
            if (!((MonthCellDescriptor) (obj)).getDate().equals(date))
            {
                continue;
            }
            ((MonthCellDescriptor) (obj)).setSelected(false);
            selectedCells.remove(obj);
            obj = null;
            break;
        } while (true);
        date = selectedCals.iterator();
        do
        {
            if (!date.hasNext())
            {
                break;
            }
            Calendar calendar1 = (Calendar)date.next();
            if (!sameDate(calendar1, calendar))
            {
                continue;
            }
            selectedCals.remove(calendar1);
            break;
        } while (true);
        return ((Date) (obj));
    }

    private static boolean betweenDates(Calendar calendar, Calendar calendar1, Calendar calendar2)
    {
        return betweenDates(calendar.getTime(), calendar1, calendar2);
    }

    static boolean betweenDates(Date date, Calendar calendar, Calendar calendar1)
    {
        calendar = calendar.getTime();
        return (date.equals(calendar) || date.after(calendar)) && date.before(calendar1.getTime());
    }

    private void clearOldSelections()
    {
        Iterator iterator = selectedCells.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MonthCellDescriptor monthcelldescriptor = (MonthCellDescriptor)iterator.next();
            monthcelldescriptor.setSelected(false);
            if (dateListener != null)
            {
                Date date = monthcelldescriptor.getDate();
                if (selectionMode == SelectionMode.RANGE)
                {
                    int i = selectedCells.indexOf(monthcelldescriptor);
                    if (i == 0 || i == selectedCells.size() - 1)
                    {
                        dateListener.onDateUnselected(date);
                    }
                } else
                {
                    dateListener.onDateUnselected(date);
                }
            }
        } while (true);
        selectedCells.clear();
        selectedCals.clear();
    }

    private static boolean containsDate(List list, Calendar calendar)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (sameDate(calendar, (Calendar)list.next()))
            {
                return true;
            }
        }

        return false;
    }

    private static String dbg(Date date, Date date1)
    {
        return (new StringBuilder()).append("minDate: ").append(date).append("\nmaxDate: ").append(date1).toString();
    }

    private boolean doSelectDate(Date date, MonthCellDescriptor monthcelldescriptor)
    {
        Object obj;
        obj = Calendar.getInstance(locale);
        ((Calendar) (obj)).setTime(date);
        setMidnight(((Calendar) (obj)));
        for (Iterator iterator = selectedCells.iterator(); iterator.hasNext(); ((MonthCellDescriptor)iterator.next()).setRangeState(MonthCellDescriptor.RangeState.NONE)) { }
        static class _cls3
        {

            static final int $SwitchMap$com$squareup$timessquare$CalendarPickerView$SelectionMode[];

            static 
            {
                $SwitchMap$com$squareup$timessquare$CalendarPickerView$SelectionMode = new int[SelectionMode.values().length];
                try
                {
                    $SwitchMap$com$squareup$timessquare$CalendarPickerView$SelectionMode[SelectionMode.RANGE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$squareup$timessquare$CalendarPickerView$SelectionMode[SelectionMode.MULTIPLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$squareup$timessquare$CalendarPickerView$SelectionMode[SelectionMode.SINGLE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.squareup.timessquare.CalendarPickerView.SelectionMode[selectionMode.ordinal()];
        JVM INSTR tableswitch 1 3: default 96
    //                   1 127
    //                   2 497
    //                   3 508;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Unknown selectionMode ").append(selectionMode).toString());
_L2:
        if (selectedCals.size() <= 1) goto _L6; else goto _L5
_L5:
        Date date1;
        clearOldSelections();
        date1 = date;
_L8:
        if (date1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (selectedCells.size() == 0 || !((MonthCellDescriptor)selectedCells.get(0)).equals(monthcelldescriptor))
        {
            selectedCells.add(monthcelldescriptor);
            monthcelldescriptor.setSelected(true);
        }
        selectedCals.add(obj);
        if (selectionMode != SelectionMode.RANGE || selectedCells.size() <= 1)
        {
            break; /* Loop/switch isn't completed */
        }
        date = ((MonthCellDescriptor)selectedCells.get(0)).getDate();
        monthcelldescriptor = ((MonthCellDescriptor)selectedCells.get(1)).getDate();
        ((MonthCellDescriptor)selectedCells.get(0)).setRangeState(MonthCellDescriptor.RangeState.FIRST);
        ((MonthCellDescriptor)selectedCells.get(1)).setRangeState(MonthCellDescriptor.RangeState.LAST);
        obj = cells.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            Iterator iterator1 = ((List)((Iterator) (obj)).next()).iterator();
            while (iterator1.hasNext()) 
            {
                Iterator iterator2 = ((List)iterator1.next()).iterator();
                while (iterator2.hasNext()) 
                {
                    MonthCellDescriptor monthcelldescriptor1 = (MonthCellDescriptor)iterator2.next();
                    if (monthcelldescriptor1.getDate().after(date) && monthcelldescriptor1.getDate().before(monthcelldescriptor) && monthcelldescriptor1.isSelectable())
                    {
                        monthcelldescriptor1.setSelected(true);
                        monthcelldescriptor1.setRangeState(MonthCellDescriptor.RangeState.MIDDLE);
                        selectedCells.add(monthcelldescriptor1);
                    }
                }
            }
        } while (true);
_L6:
        date1 = date;
        if (selectedCals.size() == 1)
        {
            date1 = date;
            if (((Calendar) (obj)).before(selectedCals.get(0)))
            {
                clearOldSelections();
                date1 = date;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        date1 = applyMultiSelect(date, ((Calendar) (obj)));
        continue; /* Loop/switch isn't completed */
_L4:
        clearOldSelections();
        date1 = date;
        if (true) goto _L8; else goto _L7
_L7:
        validateAndUpdate();
        return date1 != null;
    }

    private MonthCellWithMonthIndex getMonthCellWithIndexByDate(Date date)
    {
        int i = 0;
        Calendar calendar = Calendar.getInstance(locale);
        calendar.setTime(date);
        date = Calendar.getInstance(locale);
        Iterator iterator = cells.iterator();
label0:
        do
        {
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                Iterator iterator1 = ((List)iterator.next()).iterator();
                MonthCellDescriptor monthcelldescriptor;
label2:
                do
                {
                    if (iterator1.hasNext())
                    {
                        Iterator iterator2 = ((List)iterator1.next()).iterator();
                        do
                        {
                            if (!iterator2.hasNext())
                            {
                                continue label2;
                            }
                            monthcelldescriptor = (MonthCellDescriptor)iterator2.next();
                            date.setTime(monthcelldescriptor.getDate());
                        } while (!sameDate(date, calendar) || !monthcelldescriptor.isSelectable());
                        break;
                    }
                    break label1;
                } while (true);
                return new MonthCellWithMonthIndex(monthcelldescriptor, i);
            }
            i++;
        } while (true);
        return null;
    }

    private boolean isDateSelectable(Date date)
    {
        return dateConfiguredListener == null || dateConfiguredListener.isDateSelectable(date);
    }

    private static Calendar maxDate(List list)
    {
        if (list == null || list.size() == 0)
        {
            return null;
        } else
        {
            Collections.sort(list);
            return (Calendar)list.get(list.size() - 1);
        }
    }

    private static Calendar minDate(List list)
    {
        if (list == null || list.size() == 0)
        {
            return null;
        } else
        {
            Collections.sort(list);
            return (Calendar)list.get(0);
        }
    }

    private static boolean sameDate(Calendar calendar, Calendar calendar1)
    {
        return calendar.get(2) == calendar1.get(2) && calendar.get(1) == calendar1.get(1) && calendar.get(5) == calendar1.get(5);
    }

    private static boolean sameMonth(Calendar calendar, MonthDescriptor monthdescriptor)
    {
        return calendar.get(2) == monthdescriptor.getMonth() && calendar.get(1) == monthdescriptor.getYear();
    }

    private void scrollToSelectedDates()
    {
        Object obj1 = null;
        Integer integer = null;
        Calendar calendar = Calendar.getInstance(locale);
        for (int i = 0; i < months.size();)
        {
            MonthDescriptor monthdescriptor = (MonthDescriptor)months.get(i);
            Object obj2 = obj1;
            Integer integer1 = integer;
            if (obj1 == null)
            {
                obj2 = selectedCals.iterator();
                Object obj;
                do
                {
                    obj = obj1;
                    if (!((Iterator) (obj2)).hasNext())
                    {
                        break;
                    }
                    if (!sameMonth((Calendar)((Iterator) (obj2)).next(), monthdescriptor))
                    {
                        continue;
                    }
                    obj = Integer.valueOf(i);
                    break;
                } while (true);
                obj2 = obj;
                integer1 = integer;
                if (obj == null)
                {
                    obj2 = obj;
                    integer1 = integer;
                    if (integer == null)
                    {
                        obj2 = obj;
                        integer1 = integer;
                        if (sameMonth(calendar, monthdescriptor))
                        {
                            integer1 = Integer.valueOf(i);
                            obj2 = obj;
                        }
                    }
                }
            }
            i++;
            obj1 = obj2;
            integer = integer1;
        }

        if (obj1 != null)
        {
            scrollToSelectedMonth(((Integer) (obj1)).intValue());
        } else
        if (integer != null)
        {
            scrollToSelectedMonth(integer.intValue());
            return;
        }
    }

    private void scrollToSelectedMonth(int i)
    {
        scrollToSelectedMonth(i, false);
    }

    private void scrollToSelectedMonth(final int selectedIndex, final boolean smoothScroll)
    {
        post(new Runnable() {

            final CalendarPickerView this$0;
            final int val$selectedIndex;
            final boolean val$smoothScroll;

            public void run()
            {
                Logr.d("Scrolling to position %d", new Object[] {
                    Integer.valueOf(selectedIndex)
                });
                if (smoothScroll)
                {
                    smoothScrollToPosition(selectedIndex);
                    return;
                } else
                {
                    setSelection(selectedIndex);
                    return;
                }
            }

            
            {
                this$0 = CalendarPickerView.this;
                selectedIndex = i;
                smoothScroll = flag;
                super();
            }
        });
    }

    static void setMidnight(Calendar calendar)
    {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    private void validateAndUpdate()
    {
        if (getAdapter() == null)
        {
            setAdapter(adapter);
        }
        adapter.notifyDataSetChanged();
    }

    private void validateDate(Date date)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("Selected date must be non-null.");
        }
        if (date.before(minCal.getTime()) || date.after(maxCal.getTime()))
        {
            throw new IllegalArgumentException(String.format("SelectedDate must be between minDate and maxDate.%nminDate: %s%nmaxDate: %s%nselectedDate: %s", new Object[] {
                minCal.getTime(), maxCal.getTime(), date
            }));
        } else
        {
            return;
        }
    }

    public void clearHighlightedDates()
    {
        for (Iterator iterator = highlightedCells.iterator(); iterator.hasNext(); ((MonthCellDescriptor)iterator.next()).setHighlighted(false)) { }
        highlightedCells.clear();
        highlightedCals.clear();
        validateAndUpdate();
    }

    public List getDecorators()
    {
        return decorators;
    }

    List getMonthCells(MonthDescriptor monthdescriptor, Calendar calendar)
    {
        Calendar calendar1 = Calendar.getInstance(locale);
        calendar1.setTime(calendar.getTime());
        ArrayList arraylist = new ArrayList();
        calendar1.set(5, 1);
        int i = calendar1.get(7);
        int k = calendar1.getFirstDayOfWeek() - i;
        i = k;
        if (k > 0)
        {
            i = k - 7;
        }
        calendar1.add(5, i);
        Calendar calendar2 = minDate(selectedCals);
        Calendar calendar3 = maxDate(selectedCals);
        while ((calendar1.get(2) < monthdescriptor.getMonth() + 1 || calendar1.get(1) < monthdescriptor.getYear()) && calendar1.get(1) <= monthdescriptor.getYear()) 
        {
            Logr.d("Building week row starting at %s", new Object[] {
                calendar1.getTime()
            });
            ArrayList arraylist1 = new ArrayList();
            arraylist.add(arraylist1);
            int j = 0;
            while (j < 7) 
            {
                Date date = calendar1.getTime();
                MonthCellDescriptor.RangeState rangestate;
                int l;
                boolean flag;
                boolean flag1;
                boolean flag2;
                boolean flag3;
                boolean flag4;
                if (calendar1.get(2) == monthdescriptor.getMonth())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && containsDate(selectedCals, calendar1))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag && betweenDates(calendar1, minCal, maxCal) && isDateSelectable(date))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                flag3 = sameDate(calendar1, today);
                flag4 = containsDate(highlightedCals, calendar1);
                l = calendar1.get(5);
                rangestate = MonthCellDescriptor.RangeState.NONE;
                calendar = rangestate;
                if (selectedCals.size() > 1)
                {
                    if (sameDate(calendar2, calendar1))
                    {
                        calendar = MonthCellDescriptor.RangeState.FIRST;
                    } else
                    if (sameDate(maxDate(selectedCals), calendar1))
                    {
                        calendar = MonthCellDescriptor.RangeState.LAST;
                    } else
                    {
                        calendar = rangestate;
                        if (betweenDates(calendar1, calendar2, calendar3))
                        {
                            calendar = MonthCellDescriptor.RangeState.MIDDLE;
                        }
                    }
                }
                arraylist1.add(new MonthCellDescriptor(date, flag, flag2, flag1, flag3, flag4, l, calendar));
                calendar1.add(5, 1);
                j++;
            }
        }
        return arraylist;
    }

    public Date getSelectedDate()
    {
        if (selectedCals.size() > 0)
        {
            return ((Calendar)selectedCals.get(0)).getTime();
        } else
        {
            return null;
        }
    }

    public List getSelectedDates()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = selectedCells.iterator(); iterator.hasNext(); arraylist.add(((MonthCellDescriptor)iterator.next()).getDate())) { }
        Collections.sort(arraylist);
        return arraylist;
    }

    public void highlightDates(Collection collection)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            Object obj = (Date)collection.next();
            validateDate(((Date) (obj)));
            MonthCellWithMonthIndex monthcellwithmonthindex = getMonthCellWithIndexByDate(((Date) (obj)));
            if (monthcellwithmonthindex != null)
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(((Date) (obj)));
                obj = monthcellwithmonthindex.cell;
                highlightedCells.add(obj);
                highlightedCals.add(calendar);
                ((MonthCellDescriptor) (obj)).setHighlighted(true);
            }
        } while (true);
        validateAndUpdate();
    }

    public FluentInitializer init(Date date, Date date1)
    {
        return init(date, date1, Locale.getDefault());
    }

    public FluentInitializer init(Date date, Date date1, Locale locale1)
    {
        if (date == null || date1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("minDate and maxDate must be non-null.  ").append(dbg(date, date1)).toString());
        }
        if (date.after(date1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("minDate must be before maxDate.  ").append(dbg(date, date1)).toString());
        }
        if (locale1 == null)
        {
            throw new IllegalArgumentException("Locale is null.");
        }
        locale = locale1;
        today = Calendar.getInstance(locale1);
        minCal = Calendar.getInstance(locale1);
        maxCal = Calendar.getInstance(locale1);
        monthCounter = Calendar.getInstance(locale1);
        monthNameFormat = new SimpleDateFormat(getContext().getString(R.string.month_name_format), locale1);
        MonthDescriptor monthdescriptor;
        for (Iterator iterator = months.iterator(); iterator.hasNext(); monthdescriptor.setLabel(monthNameFormat.format(monthdescriptor.getDate())))
        {
            monthdescriptor = (MonthDescriptor)iterator.next();
        }

        weekdayNameFormat = new SimpleDateFormat(getContext().getString(R.string.day_name_format), locale1);
        fullDateFormat = DateFormat.getDateInstance(2, locale1);
        selectionMode = SelectionMode.SINGLE;
        selectedCals.clear();
        selectedCells.clear();
        highlightedCals.clear();
        highlightedCells.clear();
        cells.clear();
        months.clear();
        minCal.setTime(date);
        maxCal.setTime(date1);
        setMidnight(minCal);
        setMidnight(maxCal);
        displayOnly = false;
        maxCal.add(12, -1);
        monthCounter.setTime(minCal.getTime());
        int i = maxCal.get(2);
        for (int j = maxCal.get(1); (monthCounter.get(2) <= i || monthCounter.get(1) < j) && monthCounter.get(1) < j + 1; monthCounter.add(2, 1))
        {
            date = monthCounter.getTime();
            date = new MonthDescriptor(monthCounter.get(2), monthCounter.get(1), date, monthNameFormat.format(date));
            cells.add(getMonthCells(date, monthCounter));
            Logr.d("Adding month %s", new Object[] {
                date
            });
            months.add(date);
        }

        validateAndUpdate();
        return new FluentInitializer();
    }

    protected void onMeasure(int i, int j)
    {
        if (months.isEmpty())
        {
            throw new IllegalStateException("Must have at least one month to display.  Did you forget to call init()?");
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public boolean selectDate(Date date)
    {
        return selectDate(date, false);
    }

    public boolean selectDate(Date date, boolean flag)
    {
        validateDate(date);
        MonthCellWithMonthIndex monthcellwithmonthindex = getMonthCellWithIndexByDate(date);
        boolean flag1;
        if (monthcellwithmonthindex == null || !isDateSelectable(date))
        {
            flag1 = false;
        } else
        {
            boolean flag2 = doSelectDate(date, monthcellwithmonthindex.cell);
            flag1 = flag2;
            if (flag2)
            {
                scrollToSelectedMonth(monthcellwithmonthindex.monthIndex, flag);
                return flag2;
            }
        }
        return flag1;
    }

    public void setCellClickInterceptor(CellClickInterceptor cellclickinterceptor)
    {
        cellClickInterceptor = cellclickinterceptor;
    }

    public void setDateSelectableFilter(DateSelectableFilter dateselectablefilter)
    {
        dateConfiguredListener = dateselectablefilter;
    }

    public void setDateTypeface(Typeface typeface)
    {
        dateTypeface = typeface;
        validateAndUpdate();
    }

    public void setDecorators(List list)
    {
        decorators = list;
        if (adapter != null)
        {
            adapter.notifyDataSetChanged();
        }
    }

    public void setOnDateSelectedListener(OnDateSelectedListener ondateselectedlistener)
    {
        dateListener = ondateselectedlistener;
    }

    public void setOnInvalidDateSelectedListener(OnInvalidDateSelectedListener oninvaliddateselectedlistener)
    {
        invalidDateListener = oninvaliddateselectedlistener;
    }

    public void setTitleTypeface(Typeface typeface)
    {
        titleTypeface = typeface;
        validateAndUpdate();
    }

    public void setTypeface(Typeface typeface)
    {
        setTitleTypeface(typeface);
        setDateTypeface(typeface);
    }























}
