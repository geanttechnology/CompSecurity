// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.network.watchdog.WhisperUploadService;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            ImmediateTriggerListener, QueueType, UploadActionEvent, UploadControlAction, 
//            MultiQueueUploader, UploadMediaItemsEvent, UploadTagsEvent, UploadListenerEvent, 
//            UploadStatusEvent, UploadStrategy

public class MultiQueueUploaderMessageHandler
{

    private static final String TAG = com/amazon/gallery/framework/network/multiqueueuploader/MultiQueueUploaderMessageHandler.getName();
    private final Context appContext;
    private ImmediateTriggerListener immediateTriggerListener;
    private final MultiQueueUploader multiQueueUploader;

    public MultiQueueUploaderMessageHandler(Context context, MultiQueueUploader multiqueueuploader)
    {
        appContext = context;
        multiQueueUploader = multiqueueuploader;
        GlobalMessagingBus.register(this);
    }

    private void startUpload(QueueType queuetype, boolean flag, UploadStrategy uploadstrategy, String s)
    {
        boolean flag1 = true;
        if (immediateTriggerListener != null)
        {
            GLogger.d(TAG, "Waking upload thread to process upload for queue %s", new Object[] {
                queuetype
            });
            immediateTriggerListener.onTrigger(queuetype, flag);
            return;
        }
        Intent intent = new Intent(appContext, com/amazon/gallery/framework/network/watchdog/WhisperUploadService);
        if (uploadstrategy != null)
        {
            intent.putExtra("upload_strategy", uploadstrategy);
        }
        if (queuetype == QueueType.MANUAL)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        intent.putExtra("requeue_manual", flag);
        intent.putExtra("start_source", s);
        appContext.startService(intent);
    }

    public void onActionReceived(UploadActionEvent uploadactionevent)
    {
        QueueType queuetype = uploadactionevent.getQueueType();
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[];
            static final int $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadListenerEvent$Action[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadListenerEvent$Action = new int[UploadListenerEvent.Action.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadListenerEvent$Action[UploadListenerEvent.Action.ADD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadListenerEvent$Action[UploadListenerEvent.Action.REMOVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction = new int[UploadControlAction.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.START.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.RESUME.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.PAUSE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$multiqueueuploader$UploadControlAction[UploadControlAction.CANCEL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction[uploadactionevent.getAction().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            multiQueueUploader.allowUpload(queuetype, true);
            multiQueueUploader.refreshQueue(queuetype);
            startUpload(queuetype, true, null, uploadactionevent.getUploadSource());
            GLogger.i(TAG, "Upload resumed for queue %s", new Object[] {
                queuetype
            });
            return;

        case 3: // '\003'
            multiQueueUploader.allowUpload(queuetype, false);
            GLogger.i(TAG, "Upload paused for queue %s", new Object[] {
                queuetype
            });
            return;

        case 4: // '\004'
            multiQueueUploader.onUploadCancelled(queuetype);
            break;
        }
        multiQueueUploader.clearQueue(queuetype);
        multiQueueUploader.allowUpload(queuetype, false);
    }

    public void onUpload(UploadMediaItemsEvent uploadmediaitemsevent)
    {
        GLogger.d(TAG, "onUpload Media Items %s", new Object[] {
            uploadmediaitemsevent.getQueueType()
        });
        multiQueueUploader.allowUpload(uploadmediaitemsevent.getQueueType(), true);
        multiQueueUploader.uploadMediaItems(uploadmediaitemsevent.getItems(), uploadmediaitemsevent.getQueueType(), uploadmediaitemsevent.getUploadStrategy());
        if (uploadmediaitemsevent.getQueueType() == QueueType.MANUAL)
        {
            startUpload(QueueType.MANUAL, false, uploadmediaitemsevent.getUploadStrategy(), uploadmediaitemsevent.getUploadSource());
        }
    }

    public void onUpload(UploadTagsEvent uploadtagsevent)
    {
        GLogger.d(TAG, "onUpload Tags queue: %s; tags: %s", new Object[] {
            uploadtagsevent.getQueueType(), uploadtagsevent.getItems()
        });
        multiQueueUploader.allowUpload(uploadtagsevent.getQueueType(), true);
        multiQueueUploader.uploadTags(uploadtagsevent.getItems(), uploadtagsevent.getQueueType(), uploadtagsevent.getUploadStrategy());
        if (uploadtagsevent.getQueueType() == QueueType.MANUAL)
        {
            startUpload(QueueType.MANUAL, false, uploadtagsevent.getUploadStrategy(), uploadtagsevent.getUploadSource());
        }
    }

    public void onUploadListenerEvent(UploadListenerEvent uploadlistenerevent)
    {
        switch (_cls1..SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.UploadListenerEvent.Action[uploadlistenerevent.getAction().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            multiQueueUploader.addUploadListener(uploadlistenerevent.getUploadListener());
            return;

        case 2: // '\002'
            multiQueueUploader.removeUploadListener(uploadlistenerevent.getUploadListener());
            break;
        }
    }

    public UploadStatusEvent produceUploadStatusEvent()
    {
        return new UploadStatusEvent(multiQueueUploader.getUploadStatusForAllQueues());
    }

    public void setImmediateTriggerListener(ImmediateTriggerListener immediatetriggerlistener)
    {
        immediateTriggerListener = immediatetriggerlistener;
    }

}
