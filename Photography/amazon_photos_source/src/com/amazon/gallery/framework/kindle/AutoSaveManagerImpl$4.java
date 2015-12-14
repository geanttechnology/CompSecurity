// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogAsyncTask;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoSaveManagerImpl

class tagsToShow extends ShowDialogAsyncTask
{

    private Set tagsToShow;
    final AutoSaveManagerImpl this$0;

    protected Dialog createDialog()
    {
        return AutoSaveManagerImpl.access$800(AutoSaveManagerImpl.this, mActivity, tagsToShow, toSaveTagSet.LOCAL_TAGS);
    }

    protected boolean shouldShowDialog()
    {
        AutoSaveManagerImpl.access$600(AutoSaveManagerImpl.this);
        tagsToShow = new HashSet(AutoSaveManagerImpl.access$700(AutoSaveManagerImpl.this));
        if (tagsToShow == null || tagsToShow.size() <= 0)
        {
            GLogger.v(AutoSaveManagerImpl.TAG, "No tags to display for", new Object[0]);
            return false;
        } else
        {
            GLogger.v(AutoSaveManagerImpl.TAG, "Displaying new tag dialog", new Object[0]);
            return true;
        }
    }

    toSaveTagSet(Activity activity)
    {
        this$0 = AutoSaveManagerImpl.this;
        super(activity);
        tagsToShow = null;
    }
}
