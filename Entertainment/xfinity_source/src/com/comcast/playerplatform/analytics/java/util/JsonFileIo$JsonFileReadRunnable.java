// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.util;


// Referenced classes of package com.comcast.playerplatform.analytics.java.util:
//            JsonFileIo

public class 
    implements Runnable
{

    final listener listener;
    final JsonFileIo this$0;

    public void run()
    {
        try
        {
            java.util.List list = loadItems();
            listener.ead(list);
            return;
        }
        catch (Exception exception)
        {
            listener.listener(exception);
        }
    }
}
