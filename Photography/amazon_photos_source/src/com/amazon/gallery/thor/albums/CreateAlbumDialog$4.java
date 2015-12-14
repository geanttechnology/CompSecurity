// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            CreateAlbumDialog

class val.albumNameInput
    implements android.content.owListener
{

    final CreateAlbumDialog this$0;
    final EditText val$albumNameInput;

    public void onShow(DialogInterface dialoginterface)
    {
        dialoginterface = ((AlertDialog)dialoginterface).getButton(-1);
        boolean flag;
        if (!StringUtils.isEmpty(val$albumNameInput.getText()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dialoginterface.setEnabled(flag);
    }

    ()
    {
        this$0 = final_createalbumdialog;
        val$albumNameInput = EditText.this;
        super();
    }
}
