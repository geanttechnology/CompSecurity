// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.support.v4.app.FragmentActivity;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogFragmentSyncTask;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            RenameAction, RenameFragment, PersistentDialogFragment

class ntSyncTask extends ShowDialogFragmentSyncTask
{

    final RenameAction this$0;
    final Tag val$tagToRename;

    protected PersistentDialogFragment createDialogFragment()
    {
        return RenameFragment.getInstance(val$tagToRename, profiler);
    }

    gFragment(Tag tag)
    {
        this$0 = final_renameaction;
        val$tagToRename = tag;
        super(FragmentActivity.this);
    }
}
