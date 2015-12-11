// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.NodeApi;
import java.util.List;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            d, au

public final class ah
    implements NodeApi
{
    public static class a
        implements com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult
    {

        private final List alZ;
        private final Status yz;

        public List getNodes()
        {
            return alZ;
        }

        public Status getStatus()
        {
            return yz;
        }

        public a(Status status, List list)
        {
            yz = status;
            alZ = list;
        }
    }


    public ah()
    {
    }

    public PendingResult getConnectedNodes(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new d() {

            final ah alX;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((au)a1);
            }

            protected void a(au au1)
                throws RemoteException
            {
                au1.q(this);
            }

            protected com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult aw(Status status)
            {
                return new a(status, null);
            }

            protected Result c(Status status)
            {
                return aw(status);
            }

            
            {
                alX = ah.this;
                super();
            }
        });
    }
}
