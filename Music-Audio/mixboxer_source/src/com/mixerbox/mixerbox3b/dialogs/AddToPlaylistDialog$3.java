// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RadioGroup;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            AddToPlaylistDialog

class val.radioGroup
    implements TextWatcher
{

    final AddToPlaylistDialog this$0;
    final RadioGroup val$radioGroup;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        val$radioGroup.check(0x7f070061);
    }

    ()
    {
        this$0 = final_addtoplaylistdialog;
        val$radioGroup = RadioGroup.this;
        super();
    }
}
