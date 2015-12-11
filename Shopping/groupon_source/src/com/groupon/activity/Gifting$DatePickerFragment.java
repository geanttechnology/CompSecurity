// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Referenced classes of package com.groupon.activity:
//            Gifting

protected class this._cls0 extends DialogFragment
    implements android.app.istener
{
    protected class MyDatePickerDialog extends DatePickerDialog
    {

        final Gifting.DatePickerFragment this$1;

        public void onDateChanged(DatePicker datepicker, int i, int j, int k)
        {
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            gregoriancalendar.set(1, i);
            gregoriancalendar.set(2, j);
            gregoriancalendar.set(5, k);
            if (gregoriancalendar.before(Gifting.access$500(this$0)))
            {
                datepicker.init(Gifting.access$500(this$0).get(1), Gifting.access$500(this$0).get(2), Gifting.access$500(this$0).get(5), this);
                setSelectedDate(Gifting.access$500(this$0).get(1), Gifting.access$500(this$0).get(2), Gifting.access$500(this$0).get(5));
                super.onDateChanged(datepicker, Gifting.access$500(this$0).get(1), Gifting.access$500(this$0).get(2), Gifting.access$500(this$0).get(5));
                return;
            }
            if (gregoriancalendar.after(Gifting.access$600(this$0)))
            {
                datepicker.init(Gifting.access$600(this$0).get(1), Gifting.access$600(this$0).get(2), Gifting.access$600(this$0).get(5), this);
                setSelectedDate(Gifting.access$600(this$0).get(1), Gifting.access$600(this$0).get(2), Gifting.access$600(this$0).get(5));
                super.onDateChanged(datepicker, Gifting.access$600(this$0).get(1), Gifting.access$600(this$0).get(2), Gifting.access$600(this$0).get(5));
                return;
            } else
            {
                setSelectedDate(i, j, k);
                super.onDateChanged(datepicker, i, j, k);
                return;
            }
        }

        public MyDatePickerDialog(Context context, android.app.DatePickerDialog.OnDateSetListener ondatesetlistener, int i, int j, int k)
        {
            this$1 = Gifting.DatePickerFragment.this;
            super(context, ondatesetlistener, i, j, k);
        }
    }


    final Gifting this$0;

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((DatePickerDialog)getDialog()).updateDate(Gifting.access$400(Gifting.this).get(1), Gifting.access$400(Gifting.this).get(2), Gifting.access$400(Gifting.this).get(5));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new MyDatePickerDialog(getActivity(), this, Gifting.access$400(Gifting.this).get(1), Gifting.access$400(Gifting.this).get(2), Gifting.access$400(Gifting.this).get(5));
        DateFormat dateformat = DateFormat.getDateInstance(0);
        bundle.getDatePicker().setMinDate(Gifting.access$500(Gifting.this).getTimeInMillis());
        bundle.getDatePicker().setMaxDate(Gifting.access$600(Gifting.this).getTimeInMillis());
        setTitle(dateformat.format(Gifting.access$500(Gifting.this).getTime()));
        return bundle;
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        setSelectedDate(i, j, k);
        datepicker = new GregorianCalendar(i, j, k);
        Gifting.access$700(Gifting.this, datepicker);
    }

    public void onDestroyView()
    {
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    protected void setSelectedDate(int i, int j, int k)
    {
        Gifting.access$400(Gifting.this).set(1, i);
        Gifting.access$400(Gifting.this).set(2, j);
        Gifting.access$400(Gifting.this).set(5, k);
    }

    protected MyDatePickerDialog.this._cls1()
    {
        this$0 = Gifting.this;
        super();
    }
}
