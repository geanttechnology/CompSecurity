// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.dialog;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.amazon.gallery.framework.gallery.actions.PersistentDialogFragment;

// Referenced classes of package com.amazon.gallery.framework.gallery.dialog:
//            ShowDialogSyncTask

public abstract class ShowDialogFragmentSyncTask extends ShowDialogSyncTask
{

    public ShowDialogFragmentSyncTask(FragmentActivity fragmentactivity)
    {
        super(fragmentactivity);
    }

    protected Dialog createDialog()
    {
        return null;
    }

    protected abstract PersistentDialogFragment createDialogFragment();

    protected PersistentDialogFragment getDialogFragment()
    {
        PersistentDialogFragment persistentdialogfragment = createDialogFragment();
        persistentdialogfragment.setOnDismissListener(this);
        return persistentdialogfragment;
    }
}
