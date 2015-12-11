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

class this._cls0
    implements android.view.._cls10
{

    final FacebookHelperActivity this$0;

    public void onClick(View view)
    {
        view = new android.app.(FacebookHelperActivity.this);
        View view1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030040, null);
        final DatePicker datePicker = (DatePicker)view1.findViewById(0x7f0a00d0);
        if (android.os.ty.getSystemService >= 11)
        {
            datePicker.setCalendarViewShown(false);
        }
        view.w(view1);
        view.itiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final FacebookHelperActivity._cls10 this$1;
            final DatePicker val$datePicker;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Object obj = Calendar.getInstance();
                ((Calendar) (obj)).set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                FacebookHelperActivity.access$502(this$0, ((Calendar) (obj)).getTime());
                obj = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
                FacebookHelperActivity.access$600(this$0).setText(((SimpleDateFormat) (obj)).format(FacebookHelperActivity.access$500(this$0)));
                FacebookHelperActivity.access$700(this$0);
                dialoginterface.dismiss();
            }

            
            {
                this$1 = FacebookHelperActivity._cls10.this;
                datePicker = datepicker;
                super();
            }
        });
        view.().show();
    }

    _cls1.val.datePicker()
    {
        this$0 = FacebookHelperActivity.this;
        super();
    }
}
