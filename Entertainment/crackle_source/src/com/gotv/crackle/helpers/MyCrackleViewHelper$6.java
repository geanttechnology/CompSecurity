// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.views.dpaddatepicker.DatePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.gotv.crackle.helpers:
//            MyCrackleViewHelper

class val.context
    implements android.view.iewHelper._cls6
{

    final MyCrackleViewHelper this$0;
    final BaseActivity val$context;

    public void onClick(final View datePicker)
    {
        final AlertDialog finalDialog = new android.app.nit>(val$context);
        Object obj = ((LayoutInflater)val$context.getSystemService("layout_inflater")).inflate(0x7f030041, null);
        datePicker = (DatePicker)((View) (obj)).findViewById(0x7f0a00d0);
        finalDialog.tView(((View) (obj)));
        finalDialog.tTitle(val$context.getString(0x7f0b007b));
        obj = (Button)((View) (obj)).findViewById(0x7f0a00d1);
        finalDialog = finalDialog.eate();
        finalDialog.show();
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyCrackleViewHelper._cls6 this$1;
            final DatePicker val$datePicker;
            final AlertDialog val$finalDialog;

            public void onClick(View view)
            {
                view = Calendar.getInstance();
                view.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                MyCrackleViewHelper.access$502(this$0, view.getTime());
                view = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                MyCrackleViewHelper.access$600(this$0).setText(view.format(MyCrackleViewHelper.access$500(this$0)));
                MyCrackleViewHelper.access$000(this$0);
                finalDialog.dismiss();
            }

            
            {
                this$1 = MyCrackleViewHelper._cls6.this;
                datePicker = datepicker;
                finalDialog = alertdialog;
                super();
            }
        });
        datePicker.setFirstFocus();
    }

    _cls1.val.finalDialog()
    {
        this$0 = final_mycrackleviewhelper;
        val$context = BaseActivity.this;
        super();
    }
}
