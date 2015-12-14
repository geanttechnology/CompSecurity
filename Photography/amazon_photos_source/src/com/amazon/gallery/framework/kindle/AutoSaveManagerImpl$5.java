// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoSaveManagerImpl

class Task extends ShowDialogSyncTask
{

    final AutoSaveManagerImpl this$0;
    final toSaveTagSet val$tagSet;
    final Set val$tagsToShow;

    protected Dialog createDialog()
    {
        return AutoSaveManagerImpl.access$800(AutoSaveManagerImpl.this, mActivity, val$tagsToShow, val$tagSet);
    }

    toSaveTagSet(toSaveTagSet tosavetagset)
    {
        this$0 = final_autosavemanagerimpl;
        val$tagsToShow = Set.this;
        val$tagSet = tosavetagset;
        super(final_activity);
    }
}
