// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.dialogs;

import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

// Referenced classes of package com.mixerbox.mixerbox3b.dialogs:
//            AddToPlaylistDialog

class val.iv
    implements android.widget.edChangeListener
{

    final AddToPlaylistDialog this$0;
    final EditText val$etName;
    final ImageView val$iv;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            val$etName.setVisibility(0);
            val$iv.setVisibility(0);
            val$etName.requestFocus();
            return;
        } else
        {
            val$etName.setVisibility(8);
            val$iv.setVisibility(8);
            return;
        }
    }

    ()
    {
        this$0 = final_addtoplaylistdialog;
        val$etName = edittext;
        val$iv = ImageView.this;
        super();
    }
}
