// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.support.v4.app.FragmentActivity;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogFragmentSyncTask;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteAction, DeleteFragment, PersistentDialogFragment

class ntSyncTask extends ShowDialogFragmentSyncTask
{

    final DeleteAction this$0;
    final DeleteFragment val$deleteFragment;

    protected PersistentDialogFragment createDialogFragment()
    {
        return val$deleteFragment;
    }

    gFragment(DeleteFragment deletefragment)
    {
        this$0 = final_deleteaction;
        val$deleteFragment = deletefragment;
        super(FragmentActivity.this);
    }
}
