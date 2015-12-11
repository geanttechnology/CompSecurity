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

class val.finalDialog
    implements android.view.wHelper._cls6._cls1
{

    final val.finalDialog this$1;
    final DatePicker val$datePicker;
    final AlertDialog val$finalDialog;

    public void onClick(View view)
    {
        view = Calendar.getInstance();
        view.set(val$datePicker.getYear(), val$datePicker.getMonth(), val$datePicker.getDayOfMonth());
        MyCrackleViewHelper.access$502(_fld0, view.getTime());
        view = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        MyCrackleViewHelper.access$600(_fld0).setText(view.format(MyCrackleViewHelper.access$500(_fld0)));
        MyCrackleViewHelper.access$000(_fld0);
        val$finalDialog.dismiss();
    }

    l.context()
    {
        this$1 = final_context;
        val$datePicker = datepicker;
        val$finalDialog = AlertDialog.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$6

/* anonymous class */
    class MyCrackleViewHelper._cls6
        implements android.view.View.OnClickListener
    {

        final MyCrackleViewHelper this$0;
        final BaseActivity val$context;

        public void onClick(final View datePicker)
        {
            Object obj = new android.app.AlertDialog.Builder(context);
            Object obj1 = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030041, null);
            datePicker = (DatePicker)((View) (obj1)).findViewById(0x7f0a00d0);
            ((android.app.AlertDialog.Builder) (obj)).setView(((View) (obj1)));
            ((android.app.AlertDialog.Builder) (obj)).setTitle(context.getString(0x7f0b007b));
            obj1 = (Button)((View) (obj1)).findViewById(0x7f0a00d1);
            obj = ((android.app.AlertDialog.Builder) (obj)).create();
            ((AlertDialog) (obj)).show();
            ((Button) (obj1)).setOnClickListener(((MyCrackleViewHelper._cls6._cls1) (obj)). new MyCrackleViewHelper._cls6._cls1());
            datePicker.setFirstFocus();
        }

            
            {
                this$0 = final_mycrackleviewhelper;
                context = BaseActivity.this;
                super();
            }
    }

}
