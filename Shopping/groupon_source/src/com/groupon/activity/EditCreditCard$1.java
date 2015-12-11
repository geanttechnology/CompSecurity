// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard

class this._cls0
    implements Runnable
{

    final EditCreditCard this$0;

    public void run()
    {
        countryCodeView.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final EditCreditCard._cls1 this$1;

            public void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = stateView;
                if (EditCreditCard.access$300(this$0))
                {
                    i = 0x7f0802f1;
                } else
                {
                    i = 0x7f0803bf;
                }
                adapterview.setPromptId(i);
                adapterview = postalCodeView;
                if (EditCreditCard.access$300(this$0))
                {
                    i = 0x7f0802e1;
                } else
                {
                    i = 0x7f08042e;
                }
                adapterview.setHint(i);
                adapterview = Strings.toString(countryCodeView.getSelectedItem());
                initializeSpinner(stateView, getStringArray("shipping_state_", adapterview), null);
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$1 = EditCreditCard._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = EditCreditCard.this;
        super();
    }
}
