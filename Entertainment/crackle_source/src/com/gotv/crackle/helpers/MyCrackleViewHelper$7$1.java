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

class val.datePicker
    implements android.content.istener
{

    final is._cls0 this$1;
    final DatePicker val$datePicker;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Object obj = Calendar.getInstance();
        ((Calendar) (obj)).set(val$datePicker.getYear(), val$datePicker.getMonth(), val$datePicker.getDayOfMonth());
        MyCrackleViewHelper.access$502(_fld0, ((Calendar) (obj)).getTime());
        obj = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        MyCrackleViewHelper.access$600(_fld0).setText(((SimpleDateFormat) (obj)).format(MyCrackleViewHelper.access$500(_fld0)));
        MyCrackleViewHelper.access$000(_fld0);
        dialoginterface.dismiss();
    }

    l.context()
    {
        this$1 = final_context;
        val$datePicker = DatePicker.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/helpers/MyCrackleViewHelper$7

/* anonymous class */
    class MyCrackleViewHelper._cls7
        implements android.view.View.OnClickListener
    {

        final MyCrackleViewHelper this$0;
        final BaseActivity val$context;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(context);
            View view1 = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f030040, null);
            DatePicker datepicker = (DatePicker)view1.findViewById(0x7f0a00d0);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                datepicker.setCalendarViewShown(false);
            }
            view.setView(view1);
            view.setPositiveButton("Ok", datepicker. new MyCrackleViewHelper._cls7._cls1());
            view.create().show();
        }

            
            {
                this$0 = final_mycrackleviewhelper;
                context = BaseActivity.this;
                super();
            }
    }

}
