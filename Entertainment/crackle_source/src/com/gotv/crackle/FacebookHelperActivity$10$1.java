// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class val.datePicker
    implements android.content.ner
{

    final is._cls0 this$1;
    final DatePicker val$datePicker;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Object obj = Calendar.getInstance();
        ((Calendar) (obj)).set(val$datePicker.getYear(), val$datePicker.getMonth(), val$datePicker.getDayOfMonth());
        FacebookHelperActivity.access$502(_fld0, ((Calendar) (obj)).getTime());
        obj = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        FacebookHelperActivity.access$600(_fld0).setText(((SimpleDateFormat) (obj)).format(FacebookHelperActivity.access$500(_fld0)));
        FacebookHelperActivity.access$700(_fld0);
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$datePicker = DatePicker.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/FacebookHelperActivity$10

/* anonymous class */
    class FacebookHelperActivity._cls10
        implements android.view.View.OnClickListener
    {

        final FacebookHelperActivity this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(FacebookHelperActivity.this);
            View view1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030040, null);
            DatePicker datepicker = (DatePicker)view1.findViewById(0x7f0a00d0);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                datepicker.setCalendarViewShown(false);
            }
            view.setView(view1);
            view.setPositiveButton("Ok", datepicker. new FacebookHelperActivity._cls10._cls1());
            view.create().show();
        }

            
            {
                this$0 = FacebookHelperActivity.this;
                super();
            }
    }

}
