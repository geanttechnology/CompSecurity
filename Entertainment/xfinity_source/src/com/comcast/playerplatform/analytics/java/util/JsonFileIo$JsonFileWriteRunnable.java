// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.util;

import java.util.List;

// Referenced classes of package com.comcast.playerplatform.analytics.java.util:
//            JsonFileIo

public class _cls1
    implements Runnable
{

    final List items;
    final listener listener;
    final JsonFileIo this$0;

    public void run()
    {
        try
        {
            saveItems(items);
            listener.ritten();
            return;
        }
        catch (Exception exception)
        {
            listener.listener(exception);
        }
    }

    // Unreferenced inner class com/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable$1

/* anonymous class */
    class _cls1
        implements FileIo.FileWriteListener
    {

        public void onError(Throwable throwable)
        {
        }

        public void onItemsWritten()
        {
        }
    }

}
