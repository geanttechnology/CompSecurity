// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.fragment.list:
//            ListDialogFragment

private static class saveButton
{

    final Button cancelButton;
    private final TextView dialogTitleView;
    final CustomErrorViewWrapper errorEditTextWrapper;
    final View rootView;
    final Button saveButton;
    final EditText titleEditText;

    static TextView a(saveButton savebutton)
    {
        return savebutton.dialogTitleView;
    }

    public (View view)
    {
        rootView = view;
        dialogTitleView = (TextView)view.findViewById(0x7f1000e6);
        titleEditText = (EditText)view.findViewById(0x7f1000e8);
        errorEditTextWrapper = (CustomErrorViewWrapper)view.findViewById(0x7f1000e7);
        cancelButton = (Button)view.findViewById(0x7f1000e9);
        saveButton = (Button)view.findViewById(0x7f1000ea);
    }
}
