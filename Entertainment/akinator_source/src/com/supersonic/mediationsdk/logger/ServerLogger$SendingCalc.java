// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;


// Referenced classes of package com.supersonic.mediationsdk.logger:
//            ServerLogger

private class initDefaults
{

    private int DEFAULT_DEBUG_LEVEL;
    private int DEFAULT_SIZE;
    private int DEFAULT_TIME;
    final ServerLogger this$0;

    private boolean calc(int i)
    {
        while (error(i) || size() || time()) 
        {
            return true;
        }
        return false;
    }

    private boolean error(int i)
    {
        return i == 3;
    }

    private void initDefaults()
    {
    }

    private boolean size()
    {
        return false;
    }

    private boolean time()
    {
        return false;
    }

    public void notifyEvent(int i)
    {
        if (calc(i))
        {
            ServerLogger.access$000(ServerLogger.this);
        }
    }

    public A()
    {
        this$0 = ServerLogger.this;
        super();
        DEFAULT_SIZE = 1;
        DEFAULT_TIME = 1;
        DEFAULT_DEBUG_LEVEL = 3;
        initDefaults();
    }
}
