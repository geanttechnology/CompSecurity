// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.google.common.base.Joiner;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadControlAction, QueueType

public class UploadActionEvent
{

    private static final String TAG = com/amazon/gallery/framework/network/multiqueueuploader/UploadActionEvent.getSimpleName();
    private final QueueType queueType;
    private final UploadControlAction uploadControlAction;
    private final String uploadSource;

    public UploadActionEvent(QueueType queuetype, UploadControlAction uploadcontrolaction, String s)
    {
        queueType = queuetype;
        uploadControlAction = uploadcontrolaction;
        uploadSource = Joiner.on(".").join(s, TAG, new Object[] {
            uploadcontrolaction.toString()
        });
    }

    public UploadControlAction getAction()
    {
        return uploadControlAction;
    }

    public QueueType getQueueType()
    {
        return queueType;
    }

    public String getUploadSource()
    {
        return uploadSource;
    }

}
