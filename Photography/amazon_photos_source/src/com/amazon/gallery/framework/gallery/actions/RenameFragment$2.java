// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            RenameFragment

class val.editTextView
    implements android.content.nShowListener
{

    final RenameFragment this$0;
    final EditText val$editTextView;

    public void onShow(DialogInterface dialoginterface)
    {
        ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(val$editTextView, 1);
    }

    ()
    {
        this$0 = final_renamefragment;
        val$editTextView = EditText.this;
        super();
    }
}
