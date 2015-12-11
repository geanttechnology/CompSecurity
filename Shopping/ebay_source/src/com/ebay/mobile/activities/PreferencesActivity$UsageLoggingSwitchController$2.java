// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;
import android.widget.EditText;
import com.ebay.common.net.api.usage.Usage;

// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

class val.usage
    implements android.content.ntroller._cls2
{

    final val.usage this$1;
    final EditText val$input;
    final EditText val$input2;
    final Usage val$usage;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = val$input.getText().toString();
        String s = val$input2.getText().toString();
        usageLoggingHeader.input2 = dialoginterface;
        val.usage usage1 = (val.input2)getListAdapter();
        if (usage1 != null)
        {
            usage1.ged();
        }
        val$usage.setSessionName(dialoginterface);
        val$usage.setDeviceName(s);
        val$usage.startSession();
    }

    ()
    {
        this$1 = final_;
        val$input = edittext;
        val$input2 = edittext1;
        val$usage = Usage.this;
        super();
    }
}
