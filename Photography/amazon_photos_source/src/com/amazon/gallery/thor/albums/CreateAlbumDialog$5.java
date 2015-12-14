// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            CreateAlbumDialog

class val.albumNameInput
    implements TextWatcher
{

    final CreateAlbumDialog this$0;
    final EditText val$albumNameInput;

    public void afterTextChanged(Editable editable)
    {
        Button button = ((AlertDialog)CreateAlbumDialog.access$100(CreateAlbumDialog.this)).getButton(-1);
        if (StringUtils.isEmpty(editable))
        {
            button.setEnabled(false);
            return;
        }
        if (!CreateAlbumDialog.access$400(CreateAlbumDialog.this).isValid(editable))
        {
            button.setEnabled(false);
            val$albumNameInput.setError(CreateAlbumDialog.access$500(CreateAlbumDialog.this));
            return;
        } else
        {
            button.setEnabled(true);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    putValidator()
    {
        this$0 = final_createalbumdialog;
        val$albumNameInput = EditText.this;
        super();
    }
}
