// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogFragmentSyncTask;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            TagAction, RenameFragment, PersistentDialogFragment

public class RenameAction extends TagAction
{

    public static final String TAG = com/amazon/gallery/framework/gallery/actions/RenameAction.getName();
    private NetworkConnectivity networkConnectivity;

    public RenameAction(Activity activity, NetworkConnectivity networkconnectivity, Profiler profiler)
    {
        super(activity, 0x7f0e0043, profiler);
        networkConnectivity = networkconnectivity;
    }

    public boolean canExecuteTags(List list)
    {
        return list.size() == 1 && !((Tag)list.get(0)).hasProperty(TagProperty.CAMERA) && !((Tag)list.get(0)).hasProperty(TagProperty.FREETIME);
    }

    public void execute(Tag tag)
    {
        GLogger.d(TAG, "Executing RenameAction on a List<MediaItem>:", new Object[0]);
        if (tag.hasProperty(TagProperty.CLOUD) && networkConnectivity.promptIfOffline(context))
        {
            return;
        } else
        {
            ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveAndPendingDialogs();
            (new ShowDialogFragmentSyncTask(tag) {

                final RenameAction this$0;
                final Tag val$tagToRename;

                protected PersistentDialogFragment createDialogFragment()
                {
                    return RenameFragment.getInstance(tagToRename, profiler);
                }

            
            {
                this$0 = RenameAction.this;
                tagToRename = tag;
                super(final_fragmentactivity);
            }
            }).queue();
            return;
        }
    }

    public void execute(List list)
    {
    }

    public void executeTags(List list)
    {
        execute((Tag)list.get(0));
    }

}
