// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import com.gotv.crackle.base.BaseActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class val.context
    implements android.view.iewHelper._cls7
{

    final MyCrackleViewHelper this$0;
    final BaseActivity val$context;

    public void onClick(View view)
    {
        view = new android.app.nit>(val$context);
        View view1 = ((LayoutInflater)val$context.getSystemService("layout_inflater")).inflate(0x7f030040, null);
        final DatePicker datePicker = (DatePicker)view1.findViewById(0x7f0a00d0);
        if (android.os.te >= 11)
        {
            datePicker.setCalendarViewShown(false);
        }
        view.tView(view1);
        view.tPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final MyCrackleViewHelper._cls7 this$1;
            final DatePicker val$datePicker;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Object obj = Calendar.getInstance();
                ((Calendar) (obj)).set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                MyCrackleViewHelper.access$502(this$0, ((Calendar) (obj)).getTime());
                obj = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                MyCrackleViewHelper.access$600(this$0).setText(((SimpleDateFormat) (obj)).format(MyCrackleViewHelper.access$500(this$0)));
                MyCrackleViewHelper.access$000(this$0);
                dialoginterface.dismiss();
            }

            
            {
                this$1 = MyCrackleViewHelper._cls7.this;
                datePicker = datepicker;
                super();
            }
        });
        view.eate().show();
    }

    _cls1.val.datePicker()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = BaseActivity.this;
        super();
    }
}
