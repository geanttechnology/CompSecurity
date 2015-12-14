// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoSaveManagerImpl, NewFeatureNotification, Keys

class val.activity
    implements android.content.kListener
{

    final AutoSaveManagerImpl this$0;
    final Activity val$activity;
    final toSaveTagSet val$tagSet;
    final Set val$tags;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1)
        {
            AutoSaveManagerImpl.access$500(AutoSaveManagerImpl.this, val$tags);
            AutoSaveManagerImpl.access$900(AutoSaveManagerImpl.this, true, val$tagSet);
        } else
        {
            AutoSaveManagerImpl.access$900(AutoSaveManagerImpl.this, false, val$tagSet);
        }
        NewFeatureNotification.launchNewFeatureNotificationIfNeverSeen((FragmentActivity)val$activity);
        ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveDialog();
    }

    toSaveTagSet()
    {
        this$0 = final_autosavemanagerimpl;
        val$tags = set;
        val$tagSet = tosavetagset;
        val$activity = Activity.this;
        super();
    }
}
