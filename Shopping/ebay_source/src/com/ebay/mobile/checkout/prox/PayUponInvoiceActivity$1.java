// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import com.ebay.app.DatePickerDialogFragment;
import java.text.ParseException;
import java.util.Calendar;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            PayUponInvoiceActivity

class val.now
    implements android.view.nvoiceActivity._cls1
{

    final PayUponInvoiceActivity this$0;
    final Calendar val$now;

    public void onClick(View view)
    {
        view = new com.ebay.app.Builder();
        Object obj = ((TextView)findViewById(0x7f10051d)).getText();
        if (obj != null && !TextUtils.isEmpty(obj.toString()))
        {
            try
            {
                obj = DateFormat.getDateFormat(PayUponInvoiceActivity.this).parse(obj.toString());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(((java.util.Date) (obj)));
                view.setYear(calendar.get(1));
                view.setMonth(calendar.get(2));
                view.setDay(calendar.get(5));
            }
            catch (ParseException parseexception) { }
        } else
        {
            view.setYear(val$now.get(1));
            view.setMonth(val$now.get(2));
            view.setDay(val$now.get(5));
        }
        view.createFromActivity(919, PayUponInvoiceActivity.this).show(getFragmentManager(), "dateOfBirthPicker");
    }

    ()
    {
        this$0 = final_payuponinvoiceactivity;
        val$now = Calendar.this;
        super();
    }
}
