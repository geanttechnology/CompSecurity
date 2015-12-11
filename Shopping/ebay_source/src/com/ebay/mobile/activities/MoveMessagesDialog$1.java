// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.DialogInterface;
import com.ebay.nautilus.domain.data.MessageFolder;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            MoveMessagesDialog

class val.sourceFolder
    implements android.content.ckListener
{

    final MoveMessagesDialog this$0;
    final MessageFolder val$sourceFolder;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i < MoveMessagesDialog.access$000(MoveMessagesDialog.this).size())
        {
            if (getTargetFragment() instanceof MoveMessagesDialogListener)
            {
                ((MoveMessagesDialogListener)getTargetFragment()).onMoveMessagesFolderSelected(MoveMessagesDialog.this, val$sourceFolder, (MessageFolder)MoveMessagesDialog.access$000(MoveMessagesDialog.this).get(i));
            } else
            if (getActivity() instanceof MoveMessagesDialogListener)
            {
                ((MoveMessagesDialogListener)getActivity()).onMoveMessagesFolderSelected(MoveMessagesDialog.this, val$sourceFolder, (MessageFolder)MoveMessagesDialog.access$000(MoveMessagesDialog.this).get(i));
                return;
            }
        }
    }

    MoveMessagesDialogListener()
    {
        this$0 = final_movemessagesdialog;
        val$sourceFolder = MessageFolder.this;
        super();
    }
}
