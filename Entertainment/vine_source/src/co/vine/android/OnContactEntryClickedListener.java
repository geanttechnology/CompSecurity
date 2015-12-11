// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import co.vine.android.api.VineRecipient;
import co.vine.android.widgets.PromptDialogSupportFragment;
import java.util.HashMap;
import java.util.Set;

// Referenced classes of package co.vine.android:
//            ContactEntry

public abstract class OnContactEntryClickedListener
    implements co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{

    public static final int DIALOG_SELECT_CONTACT_ITEM = 0;
    protected ContactEntry mEntry;
    protected String mValues[];

    public OnContactEntryClickedListener()
    {
    }

    public void onClick(Fragment fragment, ContactEntry contactentry)
    {
        if (contactentry != null)
        {
            Set set = contactentry.valueMimeMap.keySet();
            mValues = (String[])set.toArray(new String[set.size()]);
            mEntry = contactentry;
            contactentry = PromptDialogSupportFragment.newInstance(0);
            contactentry.setItems(mValues);
            contactentry.setTargetFragment(fragment, 0);
            contactentry.setListener(this);
            contactentry.show(fragment.getFragmentManager());
        }
    }

    protected abstract void onContactEntryClicked(ContactEntry contactentry, VineRecipient vinerecipient, int i, String s);

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        Integer integer = (Integer)mEntry.valueMimeMap.get(mValues[j]);
        if (integer != null)
        {
            dialoginterface = null;
            if (integer.intValue() == 1)
            {
                dialoginterface = VineRecipient.fromEmail(mEntry.displayName, -1L, mValues[j], 0L);
            }
            if (integer.intValue() == 2)
            {
                dialoginterface = VineRecipient.fromPhone(mEntry.displayName, -1L, mValues[j], 0L);
            }
            if (dialoginterface != null)
            {
                dialoginterface.contactId = mEntry.contactId;
                onContactEntryClicked(mEntry, dialoginterface, integer.intValue(), mValues[j]);
            }
        }
    }
}
