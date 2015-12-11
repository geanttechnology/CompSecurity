// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import com.google.android.gms.wearable.DataMap;
import java.util.concurrent.Callable;

// Referenced classes of package com.adobe.mobile:
//            ConfigSynchronizer

static final class val.dataMap
    implements Callable
{

    final DataMap val$dataMap;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public String call()
        throws Exception
    {
        return val$dataMap.getString("ADOBEMOBILE_STOREDDEFAULTS_ADVERTISING_IDENTIFIER");
    }

    p(DataMap datamap)
    {
        val$dataMap = datamap;
        super();
    }
}
