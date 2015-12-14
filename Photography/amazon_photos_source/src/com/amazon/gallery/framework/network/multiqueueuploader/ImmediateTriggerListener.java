// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            QueueType

public interface ImmediateTriggerListener
{

    public abstract void onTrigger(QueueType queuetype, boolean flag);
}
