// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            a, GetConnectedNodesResponse, ak, PutDataResponse, 
//            SendMessageResponse

final class an
{
    static abstract class a extends com.google.android.gms.wearable.internal.a
    {

        private com.google.android.gms.common.api.k.b a;

        public final void a(Object obj)
        {
            com.google.android.gms.common.api.k.b b1 = a;
            if (b1 != null)
            {
                b1.a(obj);
                a = null;
            }
        }

        public a(com.google.android.gms.common.api.k.b b1)
        {
            a = b1;
        }
    }

    static final class b extends a
    {

        public final void a(GetConnectedNodesResponse getconnectednodesresponse)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(getconnectednodesresponse.c);
            a(new ac.a(ak.a(getconnectednodesresponse.b), arraylist));
        }

        public b(com.google.android.gms.common.api.k.b b1)
        {
            super(b1);
        }
    }

    static final class c extends com.google.android.gms.wearable.internal.a
    {

        public final void a(Status status)
        {
        }

        c()
        {
        }
    }

    static final class d extends a
    {

        private final List a;

        public final void a(PutDataResponse putdataresponse)
        {
            a(new bg.b(ak.a(putdataresponse.b), putdataresponse.c));
            if (putdataresponse.b != 0)
            {
                for (putdataresponse = a.iterator(); putdataresponse.hasNext(); ((FutureTask)putdataresponse.next()).cancel(true)) { }
            }
        }

        d(com.google.android.gms.common.api.k.b b1, List list)
        {
            super(b1);
            a = list;
        }
    }

    static final class e extends a
    {

        public final void a(SendMessageResponse sendmessageresponse)
        {
            a(new z.a(ak.a(sendmessageresponse.b), sendmessageresponse.c));
        }

        public e(com.google.android.gms.common.api.k.b b1)
        {
            super(b1);
        }
    }

}
