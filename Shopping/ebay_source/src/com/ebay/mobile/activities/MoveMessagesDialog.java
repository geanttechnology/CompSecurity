// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import com.ebay.nautilus.domain.data.MessageFolder;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseDialogFragment

public class MoveMessagesDialog extends BaseDialogFragment
{
    public static interface OnMoveMessagesDialogListener
    {

        public abstract void onMoveMessagesFolderSelected(MoveMessagesDialog movemessagesdialog, MessageFolder messagefolder, MessageFolder messagefolder1);
    }


    private static final String PARAM_FOLDERS = "param_folders";
    private static final String PARAM_MSG_COUNT = "param_msg_count";
    private static final String PARAM_SOURCE_FOLDER = "param_source_folder";
    private List allFolders;

    public MoveMessagesDialog()
    {
    }

    public static MoveMessagesDialog createInstance(Fragment fragment, List list, MessageFolder messagefolder, int i)
    {
        list = new ArrayList(list);
        Object obj = list.listIterator();
        do
        {
            if (!((ListIterator) (obj)).hasNext())
            {
                break;
            }
            MessageFolder messagefolder1 = (MessageFolder)((ListIterator) (obj)).next();
            if (messagefolder1.isSentFolder() || messagefolder1.equals(messagefolder))
            {
                ((ListIterator) (obj)).remove();
            }
        } while (true);
        obj = new Bundle();
        ((Bundle) (obj)).putParcelableArrayList("param_folders", list);
        ((Bundle) (obj)).putInt("param_msg_count", i);
        ((Bundle) (obj)).putParcelable("param_source_folder", messagefolder);
        list = new MoveMessagesDialog();
        list.setArguments(((Bundle) (obj)));
        list.setTargetFragment(fragment, 0);
        return list;
    }

    public static MoveMessagesDialog createInstance(List list, MessageFolder messagefolder, int i)
    {
        return createInstance(null, list, messagefolder, i);
    }

    public Dialog onCreateDialog(final Bundle sourceFolder)
    {
        allFolders = getArguments().getParcelableArrayList("param_folders");
        int k = getArguments().getInt("param_msg_count", 0);
        sourceFolder = (MessageFolder)getArguments().getParcelable("param_source_folder");
        String as[] = new String[allFolders.size()];
        for (int i = 0; i < as.length; i++)
        {
            as[i] = ((MessageFolder)allFolders.get(i)).folderName;
        }

        com.ebay.common.view.util.DialogManager.AlertDialogBuilder alertdialogbuilder = new com.ebay.common.view.util.DialogManager.AlertDialogBuilder(getActivity());
        int j;
        if (k > 1)
        {
            j = 0x7f070633;
        } else
        {
            j = 0x7f070632;
        }
        alertdialogbuilder.setTitle(getResources().getString(j)).setNegativeButton(0x7f0701cc, null).setItems(as, new android.content.DialogInterface.OnClickListener() {

            final MoveMessagesDialog this$0;
            final MessageFolder val$sourceFolder;

            public void onClick(DialogInterface dialoginterface, int l)
            {
                if (l < allFolders.size())
                {
                    if (getTargetFragment() instanceof OnMoveMessagesDialogListener)
                    {
                        ((OnMoveMessagesDialogListener)getTargetFragment()).onMoveMessagesFolderSelected(MoveMessagesDialog.this, sourceFolder, (MessageFolder)allFolders.get(l));
                    } else
                    if (getActivity() instanceof OnMoveMessagesDialogListener)
                    {
                        ((OnMoveMessagesDialogListener)getActivity()).onMoveMessagesFolderSelected(MoveMessagesDialog.this, sourceFolder, (MessageFolder)allFolders.get(l));
                        return;
                    }
                }
            }

            
            {
                this$0 = MoveMessagesDialog.this;
                sourceFolder = messagefolder;
                super();
            }
        });
        return alertdialogbuilder.create();
    }

}
