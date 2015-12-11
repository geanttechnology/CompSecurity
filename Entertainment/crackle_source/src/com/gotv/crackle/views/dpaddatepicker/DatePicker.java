// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views.dpaddatepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.gotv.crackle.views.dpaddatepicker:
//            NumberPicker

public class DatePicker extends FrameLayout
{
    public static interface OnDateChangedListener
    {

        public abstract void onDateChanged(DatePicker datepicker, int i, int j, int k);
    }

    private static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        public int getDay()
        {
            return mDay;
        }

        public int getMonth()
        {
            return mMonth;
        }

        public int getYear()
        {
            return mYear;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(mYear);
            parcel.writeInt(mMonth);
            parcel.writeInt(mDay);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            mYear = parcel.readInt();
            mMonth = parcel.readInt();
            mDay = parcel.readInt();
        }


        private SavedState(Parcelable parcelable, int i, int j, int k)
        {
            super(parcelable);
            mYear = i;
            mMonth = j;
            mDay = k;
        }

    }


    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_YEAR = 1900;
    private static final int NUMBER_OF_MONTHS = 12;
    private int mDay;
    private final NumberPicker mDayPicker;
    private int mMonth;
    private volatile Locale mMonthLocale;
    private final NumberPicker mMonthPicker;
    private Object mMonthUpdateLock;
    private OnDateChangedListener mOnDateChangedListener;
    private String mShortMonths[];
    private int mYear;
    private final NumberPicker mYearPicker;

    public DatePicker(Context context)
    {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DatePicker(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMonthUpdateLock = new Object();
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03003f, this, true);
        mDayPicker = (NumberPicker)findViewById(0x7f0a00ce);
        mDayPicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        mDayPicker.setSpeed(100L);
        mDayPicker.setOnChangeListener(new NumberPicker.OnChangedListener() {

            final DatePicker this$0;

            public void onChanged(NumberPicker numberpicker, int k, int l)
            {
                mDay = l;
                notifyDateChanged();
            }

            
            {
                this$0 = DatePicker.this;
                super();
            }
        });
        mMonthPicker = (NumberPicker)findViewById(0x7f0a00cd);
        mMonthPicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        String as[] = getShortMonths();
        int j;
        if (as[0].startsWith("1"))
        {
            for (i = 0; i < as.length; i++)
            {
                as[i] = String.valueOf(i + 1);
            }

            mMonthPicker.setRange(1, 12);
        } else
        {
            mMonthPicker.setRange(1, 12, as);
        }
        mMonthPicker.setSpeed(200L);
        mMonthPicker.setOnChangeListener(new NumberPicker.OnChangedListener() {

            final DatePicker this$0;

            public void onChanged(NumberPicker numberpicker, int k, int l)
            {
                mMonth = l - 1;
                adjustMaxDay();
                notifyDateChanged();
                updateDaySpinner();
            }

            
            {
                this$0 = DatePicker.this;
                super();
            }
        });
        mYearPicker = (NumberPicker)findViewById(0x7f0a00cf);
        mYearPicker.setSpeed(100L);
        mYearPicker.setOnChangeListener(new NumberPicker.OnChangedListener() {

            final DatePicker this$0;

            public void onChanged(NumberPicker numberpicker, int k, int l)
            {
                mYear = l;
                adjustMaxDay();
                notifyDateChanged();
                updateDaySpinner();
            }

            
            {
                this$0 = DatePicker.this;
                super();
            }
        });
        context = context.obtainStyledAttributes(attributeset, com.gotv.crackle.handset.R.styleable.DatePicker);
        i = context.getInt(0, 1900);
        j = context.getInt(1, 2100);
        mYearPicker.setRange(i, j);
        context.recycle();
        context = Calendar.getInstance();
        init(context.get(1), context.get(2), context.get(5), null);
        reorderPickers(as);
        if (!isEnabled())
        {
            setEnabled(false);
        }
    }

    private void adjustMaxDay()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, mYear);
        calendar.set(2, mMonth);
        int i = calendar.getActualMaximum(5);
        if (mDay > i)
        {
            mDay = i;
        }
    }

    private String[] getShortMonths()
    {
        Locale locale;
        locale = Locale.getDefault();
        if (locale.equals(mMonthLocale) && mShortMonths != null)
        {
            return mShortMonths;
        }
        Object obj = mMonthUpdateLock;
        obj;
        JVM INSTR monitorenter ;
        if (locale.equals(mMonthLocale))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        mShortMonths = new String[12];
        int i = 0;
_L2:
        if (i >= 12)
        {
            break; /* Loop/switch isn't completed */
        }
        mShortMonths[i] = DateUtils.getMonthString(i + 0, 20);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        mMonthLocale = locale;
        obj;
        JVM INSTR monitorexit ;
        return mShortMonths;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void notifyDateChanged()
    {
        if (mOnDateChangedListener != null)
        {
            mOnDateChangedListener.onDateChanged(this, mYear, mMonth, mDay);
        }
    }

    private void reorderPickers(String as[])
    {
        LinearLayout linearlayout;
        int i;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if (as[0].startsWith("1"))
        {
            as = DateFormat.getDateFormat(getContext());
        } else
        {
            as = DateFormat.getMediumDateFormat(getContext());
        }
        if (as instanceof SimpleDateFormat)
        {
            as = ((SimpleDateFormat)as).toPattern();
        } else
        {
            as = new String(DateFormat.getDateFormatOrder(getContext()));
        }
        linearlayout = (LinearLayout)findViewById(0x7f0a00cc);
        linearlayout.removeAllViews();
        flag4 = false;
        flag3 = false;
        flag2 = false;
        flag1 = false;
        i = 0;
        while (i < as.length()) 
        {
            char c = as.charAt(i);
            boolean flag = flag4;
            boolean flag5;
            boolean flag6;
            if (c == '\'')
            {
                if (!flag4)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            flag4 = flag3;
            flag5 = flag2;
            flag6 = flag1;
            if (!flag)
            {
                if (c == 'd' && !flag3)
                {
                    linearlayout.addView(mDayPicker);
                    flag4 = true;
                    flag6 = flag1;
                    flag5 = flag2;
                } else
                if ((c == 'M' || c == 'L') && !flag2)
                {
                    linearlayout.addView(mMonthPicker);
                    flag5 = true;
                    flag4 = flag3;
                    flag6 = flag1;
                } else
                {
                    flag4 = flag3;
                    flag5 = flag2;
                    flag6 = flag1;
                    if (c == 'y')
                    {
                        flag4 = flag3;
                        flag5 = flag2;
                        flag6 = flag1;
                        if (!flag1)
                        {
                            linearlayout.addView(mYearPicker);
                            flag6 = true;
                            flag4 = flag3;
                            flag5 = flag2;
                        }
                    }
                }
            }
            i++;
            flag3 = flag4;
            flag2 = flag5;
            flag1 = flag6;
            flag4 = flag;
        }
        if (!flag2)
        {
            linearlayout.addView(mMonthPicker);
        }
        if (!flag3)
        {
            linearlayout.addView(mDayPicker);
        }
        if (!flag1)
        {
            linearlayout.addView(mYearPicker);
        }
    }

    private void updateDaySpinner()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(mYear, mMonth, mDay);
        int i = calendar.getActualMaximum(5);
        mDayPicker.setRange(1, i);
        mDayPicker.setCurrent(mDay);
    }

    private void updateSpinners()
    {
        updateDaySpinner();
        mYearPicker.setCurrent(mYear);
        mMonthPicker.setCurrent(mMonth + 1);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        dispatchThawSelfOnly(sparsearray);
    }

    public int getDayOfMonth()
    {
        return mDay;
    }

    public int getMonth()
    {
        return mMonth;
    }

    public int getYear()
    {
        return mYear;
    }

    public void init(int i, int j, int k, OnDateChangedListener ondatechangedlistener)
    {
        mYear = i;
        mMonth = j;
        mDay = k;
        mOnDateChangedListener = ondatechangedlistener;
        updateSpinners();
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        mYear = parcelable.getYear();
        mMonth = parcelable.getMonth();
        mDay = parcelable.getDay();
        updateSpinners();
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), mYear, mMonth, mDay);
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        mDayPicker.setEnabled(flag);
        mMonthPicker.setEnabled(flag);
        mYearPicker.setEnabled(flag);
    }

    public void setFirstFocus()
    {
        if (mMonthPicker != null)
        {
            mMonthPicker.setFirstFocus();
        }
    }

    public void updateDate(int i, int j, int k)
    {
        if (mYear != i || mMonth != j || mDay != k)
        {
            mYear = i;
            mMonth = j;
            mDay = k;
            updateSpinners();
            reorderPickers(getShortMonths());
            notifyDateChanged();
        }
    }


/*
    static int access$002(DatePicker datepicker, int i)
    {
        datepicker.mDay = i;
        return i;
    }

*/



/*
    static int access$202(DatePicker datepicker, int i)
    {
        datepicker.mMonth = i;
        return i;
    }

*/




/*
    static int access$502(DatePicker datepicker, int i)
    {
        datepicker.mYear = i;
        return i;
    }

*/
}
