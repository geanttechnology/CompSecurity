// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.util.Log;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebKitFactories, AmazonWebKitFactory

private static class 
{

    static AmazonWebKitFactory FACTORY;

    private static boolean createWebKitFactoryByName(String s)
    {
        try
        {
            FACTORY = (AmazonWebKitFactory)Class.forName(s).newInstance();
            Log.i(AmazonWebKitFactories.access$300(), (new StringBuilder()).append("Successfully create WebKitFactory by name: ").append(s).toString());
        }
        catch (Exception exception)
        {
            Log.w(AmazonWebKitFactories.access$300(), (new StringBuilder()).append("Create WebKitFactoryByName failed: ").append(s).toString());
            return false;
        }
        return true;
    }

    static 
    {
        String s1;
        String s;
        String as[];
        int i;
        int k;
        boolean flag;
        try
        {
            s1 = AmazonWebKitFactories.access$000();
        }
        catch (Exception exception)
        {
            throw new RuntimeException("Unable to initialize webkit factory", exception);
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        s = s1;
        if (s1.length() != 0)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        s = AmazonWebKitFactories.access$100();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() == 0) goto _L2; else goto _L3
_L3:
        s1 = s;
        if (createWebKitFactoryByName(s)) goto _L4; else goto _L2
_L2:
        as = new String[2];
        as[0] = "com.amazon.android.webkit.embedded.EmbeddedWebKitFactory";
        as[1] = "com.amazon.android.webkit.android.AndroidWebKitFactory";
        k = as.length;
        i = 0;
_L8:
        s1 = s;
        if (i >= k) goto _L4; else goto _L5
_L5:
        s1 = as[i];
        flag = createWebKitFactoryByName(s1);
        if (!flag) goto _L6; else goto _L4
_L4:
        if (FACTORY == null)
        {
            throw new RuntimeException("Unable to initialize webkit factory");
        }
        break; /* Loop/switch isn't completed */
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        int j = AmazonWebKitFactories.access$200(s1);
        Log.i(AmazonWebKitFactories.access$300(), (new StringBuilder()).append("Client API Level:4 Factory API Level:").append(j).toString());
        if (j == -1)
        {
            throw new RuntimeException("Unable to detect factory api level");
        }
        AmazonWebKitFactories.access$402(j);
        if (AmazonWebKitFactories.access$400() > 1)
        {
            FACTORY.setTargetApiLevel(Math.min(AmazonWebKitFactories.access$400(), 4));
        }
    }

    private ()
    {
    }
}
