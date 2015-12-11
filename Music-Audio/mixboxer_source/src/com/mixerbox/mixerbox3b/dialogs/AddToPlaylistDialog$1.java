// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            AddToPlaylistDialog

class val.etName
    implements android.view.ToPlaylistDialog._cls1
{

    final AddToPlaylistDialog this$0;
    final EditText val$etName;

    public void onClick(View view)
    {
        val$etName.setText("");
    }

    ()
    {
        this$0 = final_addtoplaylistdialog;
        val$etName = EditText.this;
        super();
    }
}
