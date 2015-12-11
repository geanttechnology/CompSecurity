// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.debug;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import com.amazon.now.util.WeblabUtil;

// Referenced classes of package com.amazon.now.debug:
//            DebugActivity

class val.view
    implements android.view.ener
{

    final DebugActivity this$0;
    final CheckBox val$clearAll;
    final View val$view;
    final EditText val$weblabEntryField;

    public void onClick(View view1)
    {
        if (val$clearAll.isChecked())
        {
            WeblabUtil.clearWeblabs();
        }
        WeblabUtil.saveWeblabs(val$weblabEntryField.getText().toString().trim());
        val$clearAll.setChecked(false);
        val$weblabEntryField.setText("");
        DebugActivity.access$300(DebugActivity.this, val$view);
    }

    ()
    {
        this$0 = final_debugactivity;
        val$clearAll = checkbox;
        val$weblabEntryField = edittext;
        val$view = View.this;
        super();
    }
}
