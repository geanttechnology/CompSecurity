// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.gotv.crackle.views.dpaddatepicker.DatePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class this._cls0
    implements android.view.y._cls9
{

    final FacebookHelperActivity this$0;

    public void onClick(final View datePicker)
    {
        final AlertDialog finalDialog = new android.app.>(FacebookHelperActivity.this);
        Object obj = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030041, null);
        datePicker = (DatePicker)((View) (obj)).findViewById(0x7f0a00d0);
        finalDialog.ew(((View) (obj)));
        finalDialog.tle(getString(0x7f0b007b));
        obj = (Button)((View) (obj)).findViewById(0x7f0a00d1);
        finalDialog = finalDialog.e();
        finalDialog.show();
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final FacebookHelperActivity._cls9 this$1;
            final DatePicker val$datePicker;
            final AlertDialog val$finalDialog;

            public void onClick(View view)
            {
                view = Calendar.getInstance();
                view.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                FacebookHelperActivity.access$502(this$0, view.getTime());
                view = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                FacebookHelperActivity.access$600(this$0).setText(view.format(FacebookHelperActivity.access$500(this$0)));
                FacebookHelperActivity.access$700(this$0);
                finalDialog.dismiss();
            }

            
            {
                this$1 = FacebookHelperActivity._cls9.this;
                datePicker = datepicker;
                finalDialog = alertdialog;
                super();
            }
        });
        datePicker.setFirstFocus();
    }

    _cls1.val.finalDialog()
    {
        this$0 = FacebookHelperActivity.this;
        super();
    }
}
