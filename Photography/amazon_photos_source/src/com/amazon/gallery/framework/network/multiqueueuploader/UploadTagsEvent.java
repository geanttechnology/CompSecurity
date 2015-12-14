// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.google.common.base.Joiner;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            BaseUploadEvent, QueueType, UploadStrategy

public class UploadTagsEvent extends BaseUploadEvent
{

    private static final String TAG = com/amazon/gallery/framework/network/multiqueueuploader/UploadTagsEvent.getSimpleName();

    public UploadTagsEvent(List list, QueueType queuetype, UploadStrategy uploadstrategy, String s)
    {
        super(list, queuetype, uploadstrategy, Joiner.on(".").join(s, TAG, new Object[] {
            queuetype
        }));
    }

}
