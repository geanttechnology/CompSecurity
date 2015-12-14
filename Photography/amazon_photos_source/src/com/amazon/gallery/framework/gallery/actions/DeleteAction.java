// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ContentFetcher;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogFragmentSyncTask;
import com.amazon.gallery.framework.gallery.messaging.ConfigurationContentFetcher;
import com.amazon.gallery.framework.gallery.messaging.ContentConfigurationEvent;
import com.amazon.gallery.framework.gallery.view.ContentConfiguration;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            MediaItemAction, DeleteFragment, PersistentDialogFragment

public class DeleteAction extends MediaItemAction
{
    protected static final class ActionState extends Enum
    {

        private static final ActionState $VALUES[];
        public static final ActionState ACTIVATED;
        public static final ActionState COMPLETED;

        public static ActionState valueOf(String s)
        {
            return (ActionState)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/DeleteAction$ActionState, s);
        }

        public static ActionState[] values()
        {
            return (ActionState[])$VALUES.clone();
        }

        static 
        {
            ACTIVATED = new ActionState("ACTIVATED", 0);
            COMPLETED = new ActionState("COMPLETED", 1);
            $VALUES = (new ActionState[] {
                ACTIVATED, COMPLETED
            });
        }

        private ActionState(String s, int i)
        {
            super(s, i);
        }
    }

    private static class EventMapKey
    {

        private final MediaItemAction.ActionSource actionSource;
        private final ActionState actionState;
        private final Selection selection;

        public boolean equals(Object obj)
        {
            if (obj != null && (obj instanceof EventMapKey))
            {
                if (((EventMapKey) (obj = (EventMapKey)obj)).selection == selection && ((EventMapKey) (obj)).actionSource == actionSource && ((EventMapKey) (obj)).actionState == actionState)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return selection.hashCode() + actionSource.hashCode() * 31 + actionState.hashCode() * 59;
        }

        public EventMapKey(Selection selection1, MediaItemAction.ActionSource actionsource, ActionState actionstate)
        {
            selection = selection1;
            actionSource = actionsource;
            actionState = actionstate;
        }
    }

    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent DeleteClicked;
        public static final MetricsEvent DeleteFile;
        public static final MetricsEvent MultiSelectDeleteCloudActivated;
        public static final MetricsEvent MultiSelectDeleteCloudAndDeviceActivated;
        public static final MetricsEvent MultiSelectDeleteCloudAndDeviceCompleted;
        public static final MetricsEvent MultiSelectDeleteCloudCompleted;
        public static final MetricsEvent MultiSelectDeleteDeviceActivated;
        public static final MetricsEvent MultiSelectDeleteDeviceCompleted;
        public static final MetricsEvent MultiSelectDeleteUnifiedActivated;
        public static final MetricsEvent MultiSelectDeleteUnifiedCompleted;
        public static final MetricsEvent SingleViewDeleteCloudActivated;
        public static final MetricsEvent SingleViewDeleteCloudCompleted;
        public static final MetricsEvent SingleViewDeleteDeviceActivated;
        public static final MetricsEvent SingleViewDeleteDeviceCompleted;
        public static final MetricsEvent SingleViewDeleteUnifiedActivated;
        public static final MetricsEvent SingleViewDeleteUnifiedCompleted;

        public static MetricsEvent getEvent(Selection selection, MediaItemAction.ActionSource actionsource, ActionState actionstate)
        {
            return (MetricsEvent)DeleteAction.metricsEventMap.get(new EventMapKey(selection, actionsource, actionstate));
        }

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/DeleteAction$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            MultiSelectDeleteDeviceActivated = new MetricsEvent("MultiSelectDeleteDeviceActivated", 0, Selection.LOCAL, MediaItemAction.ActionSource.MULTISELECT, ActionState.ACTIVATED);
            MultiSelectDeleteCloudActivated = new MetricsEvent("MultiSelectDeleteCloudActivated", 1, Selection.CLOUD, MediaItemAction.ActionSource.MULTISELECT, ActionState.ACTIVATED);
            MultiSelectDeleteCloudAndDeviceActivated = new MetricsEvent("MultiSelectDeleteCloudAndDeviceActivated", 2, Selection.CLOUD_AND_LOCAL, MediaItemAction.ActionSource.MULTISELECT, ActionState.ACTIVATED);
            MultiSelectDeleteUnifiedActivated = new MetricsEvent("MultiSelectDeleteUnifiedActivated", 3, Selection.UNIFIED, MediaItemAction.ActionSource.MULTISELECT, ActionState.ACTIVATED);
            MultiSelectDeleteDeviceCompleted = new MetricsEvent("MultiSelectDeleteDeviceCompleted", 4, Selection.LOCAL, MediaItemAction.ActionSource.MULTISELECT, ActionState.COMPLETED);
            MultiSelectDeleteCloudCompleted = new MetricsEvent("MultiSelectDeleteCloudCompleted", 5, Selection.CLOUD, MediaItemAction.ActionSource.MULTISELECT, ActionState.COMPLETED);
            MultiSelectDeleteCloudAndDeviceCompleted = new MetricsEvent("MultiSelectDeleteCloudAndDeviceCompleted", 6, Selection.CLOUD_AND_LOCAL, MediaItemAction.ActionSource.MULTISELECT, ActionState.COMPLETED);
            MultiSelectDeleteUnifiedCompleted = new MetricsEvent("MultiSelectDeleteUnifiedCompleted", 7, Selection.UNIFIED, MediaItemAction.ActionSource.MULTISELECT, ActionState.COMPLETED);
            SingleViewDeleteDeviceActivated = new MetricsEvent("SingleViewDeleteDeviceActivated", 8, Selection.LOCAL, MediaItemAction.ActionSource.SINGLE_VIEW_HAB, ActionState.ACTIVATED);
            SingleViewDeleteCloudActivated = new MetricsEvent("SingleViewDeleteCloudActivated", 9, Selection.CLOUD, MediaItemAction.ActionSource.SINGLE_VIEW_HAB, ActionState.ACTIVATED);
            SingleViewDeleteUnifiedActivated = new MetricsEvent("SingleViewDeleteUnifiedActivated", 10, Selection.UNIFIED, MediaItemAction.ActionSource.SINGLE_VIEW_HAB, ActionState.ACTIVATED);
            SingleViewDeleteDeviceCompleted = new MetricsEvent("SingleViewDeleteDeviceCompleted", 11, Selection.LOCAL, MediaItemAction.ActionSource.SINGLE_VIEW_HAB, ActionState.COMPLETED);
            SingleViewDeleteCloudCompleted = new MetricsEvent("SingleViewDeleteCloudCompleted", 12, Selection.CLOUD, MediaItemAction.ActionSource.SINGLE_VIEW_HAB, ActionState.COMPLETED);
            SingleViewDeleteUnifiedCompleted = new MetricsEvent("SingleViewDeleteUnifiedCompleted", 13, Selection.UNIFIED, MediaItemAction.ActionSource.SINGLE_VIEW_HAB, ActionState.COMPLETED);
            DeleteClicked = new MetricsEvent("DeleteClicked", 14);
            DeleteFile = new MetricsEvent("DeleteFile", 15);
            $VALUES = (new MetricsEvent[] {
                MultiSelectDeleteDeviceActivated, MultiSelectDeleteCloudActivated, MultiSelectDeleteCloudAndDeviceActivated, MultiSelectDeleteUnifiedActivated, MultiSelectDeleteDeviceCompleted, MultiSelectDeleteCloudCompleted, MultiSelectDeleteCloudAndDeviceCompleted, MultiSelectDeleteUnifiedCompleted, SingleViewDeleteDeviceActivated, SingleViewDeleteCloudActivated, 
                SingleViewDeleteUnifiedActivated, SingleViewDeleteDeviceCompleted, SingleViewDeleteCloudCompleted, SingleViewDeleteUnifiedCompleted, DeleteClicked, DeleteFile
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }

        private MetricsEvent(String s, int i, Selection selection, MediaItemAction.ActionSource actionsource, ActionState actionstate)
        {
            super(s, i);
            DeleteAction.metricsEventMap.put(new EventMapKey(selection, actionsource, actionstate), this);
        }
    }

    protected static final class Selection extends Enum
    {

        private static final Selection $VALUES[];
        public static final Selection CLOUD;
        public static final Selection CLOUD_AND_LOCAL;
        public static final Selection DELETE_FROM_ALBUM;
        public static final Selection LOCAL;
        public static final Selection REMOVE_FROM_ALBUM;
        public static final Selection TAG;
        public static final Selection UNIFIED;

        public static Selection valueOf(String s)
        {
            return (Selection)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/DeleteAction$Selection, s);
        }

        public static Selection[] values()
        {
            return (Selection[])$VALUES.clone();
        }

        static 
        {
            CLOUD = new Selection("CLOUD", 0);
            LOCAL = new Selection("LOCAL", 1);
            CLOUD_AND_LOCAL = new Selection("CLOUD_AND_LOCAL", 2);
            UNIFIED = new Selection("UNIFIED", 3);
            TAG = new Selection("TAG", 4);
            REMOVE_FROM_ALBUM = new Selection("REMOVE_FROM_ALBUM", 5);
            DELETE_FROM_ALBUM = new Selection("DELETE_FROM_ALBUM", 6);
            $VALUES = (new Selection[] {
                CLOUD, LOCAL, CLOUD_AND_LOCAL, UNIFIED, TAG, REMOVE_FROM_ALBUM, DELETE_FROM_ALBUM
            });
        }

        private Selection(String s, int i)
        {
            super(s, i);
        }
    }

    protected static final class SourceType extends Enum
    {

        private static final SourceType $VALUES[];
        public static final SourceType CLOUD;
        public static final SourceType DEFAULT;
        public static final SourceType LOCAL;

        public static SourceType valueOf(String s)
        {
            return (SourceType)Enum.valueOf(com/amazon/gallery/framework/gallery/actions/DeleteAction$SourceType, s);
        }

        public static SourceType[] values()
        {
            return (SourceType[])$VALUES.clone();
        }

        static 
        {
            DEFAULT = new SourceType("DEFAULT", 0);
            LOCAL = new SourceType("LOCAL", 1);
            CLOUD = new SourceType("CLOUD", 2);
            $VALUES = (new SourceType[] {
                DEFAULT, LOCAL, CLOUD
            });
        }

        private SourceType(String s, int i)
        {
            super(s, i);
        }
    }


    protected static String KEY_EXTRA_PARENT_OBJECT_ID = "parent_object_id";
    public static final String TAG = com/amazon/gallery/framework/gallery/actions/DeleteAction.getName();
    private static final Map metricsEventMap = new HashMap();
    private boolean hasCloud;
    private boolean hasLocal;
    protected Selection itemSelection;
    private String parentObjectId;
    private SourceType sourceType;

    public DeleteAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e0047);
        parentObjectId = null;
        sourceType = SourceType.DEFAULT;
    }

    protected DeleteAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, int i)
    {
        super(activity, networkconnectivity, photosdemomanager, i);
        parentObjectId = null;
        sourceType = SourceType.DEFAULT;
    }

    private boolean needNetworkToDelete()
    {
        return hasCloud || sourceType == SourceType.CLOUD;
    }

    private void setupAndShowDeleteFragment(boolean flag, List list)
    {
        ViewDescriptor viewdescriptor = getSourceType();
        if (needNetworkToDelete() && networkConnectivity.promptIfOffline(context))
        {
            return;
        } else
        {
            getItemSelection(flag, viewdescriptor);
            showFragment(DeleteFragment.getInstance(actionSource, sourceType, itemSelection, list, parentObjectId));
            return;
        }
    }

    private void showFragment(DeleteFragment deletefragment)
    {
        ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).dismissActiveAndPendingDialogs();
        (new ShowDialogFragmentSyncTask(deletefragment) {

            final DeleteAction this$0;
            final DeleteFragment val$deleteFragment;

            protected PersistentDialogFragment createDialogFragment()
            {
                return deleteFragment;
            }

            
            {
                this$0 = DeleteAction.this;
                deleteFragment = deletefragment;
                super(final_fragmentactivity);
            }
        }).queue();
    }

    public void execute(List list)
    {
        GLogger.d("DeleteAction", "Executing DeleteAction on a List<MediaItem>:", new Object[0]);
        if (list.isEmpty())
        {
            return;
        }
        super.execute(list);
        hasLocal = false;
        hasCloud = false;
        boolean flag = false;
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            MediaItem mediaitem = (MediaItem)iterator.next();
            boolean flag1 = MediaItemUtil.isCloudMediaItem(mediaitem);
            boolean flag2 = MediaItemUtil.isLocalMediaItem(mediaitem);
            if (flag1 && flag2)
            {
                flag = true;
            } else
            if (flag1)
            {
                hasCloud = true;
            } else
            {
                hasLocal = true;
            }
        }

        setupAndShowDeleteFragment(flag, list);
    }

    public void execute(List list, boolean flag, boolean flag1, boolean flag2)
    {
        GLogger.d("DeleteAction", "Executing DeleteAction on a List<MediaItem>:", new Object[0]);
        if (list.isEmpty())
        {
            return;
        } else
        {
            super.execute(list);
            hasCloud = flag;
            hasLocal = flag1;
            setupAndShowDeleteFragment(flag2, list);
            return;
        }
    }

    public void executeTags(List list)
    {
        executeTagsOperation(list);
    }

    public void executeTagsOperation(List list)
    {
        GLogger.d("DeleteAction", (new StringBuilder()).append("Executing DeleteAction on a Tag: ").append(list).toString(), new Object[0]);
        if (list.size() == 0)
        {
            return;
        }
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            if (((Tag)iterator.next()).hasProperty(TagProperty.CLOUD) && networkConnectivity.promptIfOffline(context))
            {
                return;
            }
        }

        itemSelection = Selection.TAG;
        showFragment(DeleteFragment.getInstance(itemSelection, list));
    }

    public void executeWithoutDialog(List list)
    {
        showFragment(DeleteFragment.getInstanceWithoutDialog(list));
    }

    protected void getItemSelection(boolean flag, ViewDescriptor viewdescriptor)
    {
        if (viewdescriptor != null && viewdescriptor.getTag() != null && viewdescriptor.getTag().getType() == TagType.ALBUM)
        {
            itemSelection = Selection.DELETE_FROM_ALBUM;
            return;
        }
        if (flag)
        {
            itemSelection = Selection.UNIFIED;
            return;
        }
        if (hasLocal && hasCloud)
        {
            itemSelection = Selection.CLOUD_AND_LOCAL;
            return;
        }
        if (hasLocal)
        {
            itemSelection = Selection.LOCAL;
            return;
        } else
        {
            itemSelection = Selection.CLOUD;
            return;
        }
    }

    public ViewDescriptor getSourceType()
    {
        Object obj = (ContentConfigurationEvent)(new ConfigurationContentFetcher()).getContentFromProducer();
        ViewDescriptor viewdescriptor;
        if (obj != null)
        {
            obj = ((ContentConfigurationEvent) (obj)).getContentConfiguration();
        } else
        {
            obj = null;
        }
        viewdescriptor = null;
        if (obj != null)
        {
            viewdescriptor = ((ContentConfiguration) (obj)).toViewDescriptor();
        }
        if (viewdescriptor != null && viewdescriptor.getTag() != null)
        {
            static class _cls2
            {

                static final int $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[];

                static 
                {
                    $SwitchMap$com$amazon$gallery$framework$model$tags$TagType = new int[TagType.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.ALBUM.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.FOLDER.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.LOCAL_FOLDER.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.ALL.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls2..SwitchMap.com.amazon.gallery.framework.model.tags.TagType[viewdescriptor.getTag().getType().ordinal()])
            {
            default:
                return viewdescriptor;

            case 1: // '\001'
            case 2: // '\002'
                sourceType = SourceType.CLOUD;
                parentObjectId = viewdescriptor.getTag().getObjectId().toString();
                return viewdescriptor;

            case 3: // '\003'
                sourceType = SourceType.LOCAL;
                return viewdescriptor;

            case 4: // '\004'
                sourceType = SourceType.DEFAULT;
                break;
            }
            return viewdescriptor;
        } else
        {
            sourceType = SourceType.DEFAULT;
            return viewdescriptor;
        }
    }

    protected boolean isValid(Tag tag)
    {
        return true;
    }

    public void recordOnActionMetrics(List list)
    {
        if (actionSource == MediaItemAction.ActionSource.SINGLE_VIEW_HAB)
        {
            profiler.trackEvent(MetricsEvent.DeleteClicked, ClickstreamEventHelper.createClickstreamExtra("ActionEvent", HitType.APP_ACTION));
        }
        if (isWhisperPlayMode())
        {
            list = com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPDeleteAction;
            profiler.trackEvent(list, CustomerMetricsHelper.getExtraEventTag(list.toString()));
        }
    }


}
