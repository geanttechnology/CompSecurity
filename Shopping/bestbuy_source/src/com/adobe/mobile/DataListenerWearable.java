// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.net.Uri;
import atv;
import atw;
import atx;
import java.util.Iterator;

// Referenced classes of package com.adobe.mobile:
//            ConfigSynchronizer

public final class DataListenerWearable
{

    public DataListenerWearable()
    {
    }

    public static void onDataChanged(atw atw1)
    {
        if (atw1 != null)
        {
            atw1 = atw1.iterator();
            while (atw1.hasNext()) 
            {
                Object obj = (atv)atw1.next();
                if (((atv) (obj)).c() == 1)
                {
                    obj = ((atv) (obj)).b();
                    if (obj != null)
                    {
                        Uri uri = ((atx) (obj)).b();
                        if (uri != null && uri.getPath() != null && uri.getPath().startsWith("/abdmobile/data/config/"))
                        {
                            ConfigSynchronizer.restoreConfig(((atx) (obj)));
                        }
                    }
                }
            }
        }
    }
}
