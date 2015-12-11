// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.util.Log;
import java.util.LinkedList;

// Referenced classes of package com.flurry.android.caching:
//            ObjectOperationData

final class n
{

    private LinkedList iA;

    n()
    {
        iA = new LinkedList();
    }

    public final ObjectOperationData bE()
    {
        if (iA.size() > 0)
        {
            return (ObjectOperationData)iA.getFirst();
        } else
        {
            Log.e("AppCloudOperationsManager", "NO SUCH OPERATION");
            return null;
        }
    }

    public final ObjectOperationData bF()
    {
        return (ObjectOperationData)iA.removeFirst();
    }

    public final void j(ObjectOperationData objectoperationdata)
    {
        iA.add(objectoperationdata);
    }
}
