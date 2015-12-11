// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;


// Referenced classes of package com.adobe.mobile:
//            Messages, ReferrerHandler, StaticMethods

static final class ds
    implements Runnable
{

    public void run()
    {
        while (!ReferrerHandler.getReferrerProcessed()) 
        {
            try
            {
                Thread.sleep(100L);
            }
            catch (Exception exception)
            {
                StaticMethods.logWarningFormat("Data Callback - Data Callback Queue Is Interrupted(%s)", new Object[] {
                    exception.getMessage()
                });
            }
        }
    }

    ds()
    {
    }
}
