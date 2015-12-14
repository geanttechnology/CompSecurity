// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.ui.contextmenu.ContextMenuAction;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.WhisperPlayActivity;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            SelectionAction, ViewDescriptorAction

public abstract class MediaItemAction extends ContextMenuAction
    implements SelectionAction, ViewDescriptorAction
{
    public static final class ActionSource extends Enum
    {

        private static final ActionSource $VALUES[];
        public static final ActionSource MULTISELECT;
        public static final ActionSource SINGLE_VIEW_HAB;

        public static ActionSource valueOf(String s)
        {
            return (ActionSource)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/MediaItemAction$ActionSource, s);
        }

        public static ActionSource[] values()
        {
            return (ActionSource[])$VALUES.clone();
        }

        static 
        {
            MULTISELECT = new ActionSource("MULTISELECT", 0);
            SINGLE_VIEW_HAB = new ActionSource("SINGLE_VIEW_HAB", 1);
            $VALUES = (new ActionSource[] {
                MULTISELECT, SINGLE_VIEW_HAB
            });
        }

        private ActionSource(String s, int i)
        {
            super(s, i);
        }
    }


    protected ActionSource actionSource;
    protected final CloudDriveServiceClientManager cloudDriveServiceClientManager;
    protected final NetworkConnectivity networkConnectivity;
    protected final PhotosDemoManager photosDemoManager;
    protected ComponentProfiler profiler;

    public MediaItemAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, int i)
    {
        super(activity, i);
        actionSource = ActionSource.SINGLE_VIEW_HAB;
        networkConnectivity = networkconnectivity;
        photosDemoManager = photosdemomanager;
        cloudDriveServiceClientManager = (CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        viewdescriptor = new ArrayList(1);
        viewdescriptor.add(mediaitem);
        return canExecute(((List) (viewdescriptor)));
    }

    public boolean canExecute(List list)
    {
        if (list.isEmpty())
        {
            return false;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            if (!isValid((MediaItem)list.next()))
            {
                return false;
            }
        }

        return true;
    }

    public boolean canExecuteTags(List list)
    {
        if (list.isEmpty())
        {
            return false;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            if (!isValid((Tag)list.next()))
            {
                return false;
            }
        }

        return true;
    }

    public void execute(List list)
    {
        recordOnActionMetrics(list);
    }

    public void executeTags(List list)
    {
        throw new UnsupportedOperationException();
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        viewdescriptor = new ArrayList(1);
        viewdescriptor.add(mediaitem);
        execute(viewdescriptor);
    }

    protected Tag getTagFromViewDescriptor(ViewDescriptor viewdescriptor)
    {
        if (viewdescriptor != null)
        {
            return viewdescriptor.getTag();
        } else
        {
            return null;
        }
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        return mediaitem != null;
    }

    protected abstract boolean isValid(Tag tag);

    protected boolean isWhisperPlayMode()
    {
        return ((WhisperPlayActivity)context).isWhisperPlayModeEnabled();
    }

    public abstract void recordOnActionMetrics(List list);

    public void setActionSource(ActionSource actionsource)
    {
        actionSource = actionsource;
    }

    public void setProfiler(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, getClass());
    }
}
