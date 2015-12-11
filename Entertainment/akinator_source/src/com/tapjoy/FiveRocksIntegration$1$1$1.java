// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import com.tapjoy.internal.bf;
import com.tapjoy.internal.fr;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.fu;

// Referenced classes of package com.tapjoy:
//            TJActionRequest, FiveRocksIntegration, TJPlacement, TJPlacementListener, 
//            TapjoyConnectCore

final class a
    implements TJActionRequest
{

    final String a;
    final a b;

    public final void cancelled()
    {
    }

    public final void completed()
    {
    }

    public final String getRequestId()
    {
        return a;
    }

    public final String getToken()
    {
        return null;
    }

    b(b b1, String s)
    {
        b = b1;
        a = s;
        super();
    }

    // Unreferenced inner class com/tapjoy/FiveRocksIntegration$1

/* anonymous class */
    static final class FiveRocksIntegration._cls1
        implements fu
    {

        private fs e(String s)
        {
            return new FiveRocksIntegration._cls1._cls1(this, s);
        }

        public final void a(String s)
        {
        }

        public final void a(String s, fr fr1)
        {
            if (fr1 != null)
            {
                fr1.a(e(s));
            }
        }

        public final void b(String s)
        {
            synchronized (FiveRocksIntegration.a())
            {
                s = (TJPlacement)FiveRocksIntegration.a().get(s);
            }
            if (s != null && s.a() != null)
            {
                s.a().onContentReady(s);
            }
        }

        public final void b(String s, fr fr1)
        {
            if (fr1 != null)
            {
                fr1.a(e(s));
            }
            TapjoyConnectCore.viewWillClose(0);
            TapjoyConnectCore.viewDidClose(0);
            synchronized (FiveRocksIntegration.a())
            {
                s = (TJPlacement)FiveRocksIntegration.a().get(s);
            }
            if (s != null && s.a() != null)
            {
                s.a().onContentDismiss(s);
            }
        }

        public final void c(String s)
        {
            TapjoyConnectCore.viewDidOpen(0);
            synchronized (FiveRocksIntegration.a())
            {
                s = (TJPlacement)FiveRocksIntegration.a().get(s);
            }
            if (s != null && s.a() != null)
            {
                s.a().onContentShow(s);
            }
        }

        public final void d(String s)
        {
        }

    }


    // Unreferenced inner class com/tapjoy/FiveRocksIntegration$1$1

/* anonymous class */
    final class FiveRocksIntegration._cls1._cls1
        implements fs
    {

        final String a;
        final FiveRocksIntegration._cls1 b;

        public final void a(String s, String s1)
        {
            TJPlacement tjplacement;
            synchronized (FiveRocksIntegration.a())
            {
                tjplacement = (TJPlacement)FiveRocksIntegration.a().get(a);
            }
            if (tjplacement != null && tjplacement.a() != null)
            {
                s = new FiveRocksIntegration._cls1._cls1._cls1(this, s);
                tjplacement.a().onPurchaseRequest(tjplacement, s, s1);
            }
        }

        public final void a(String s, String s1, int i, String s2)
        {
            TJPlacement tjplacement;
            synchronized (FiveRocksIntegration.a())
            {
                tjplacement = (TJPlacement)FiveRocksIntegration.a().get(a);
            }
            if (tjplacement != null && tjplacement.a() != null)
            {
                s = new FiveRocksIntegration._cls1._cls1._cls2(s, s2);
                tjplacement.a().onRewardRequest(tjplacement, s, s1, i);
            }
        }

            
            {
                b = _pcls1;
                a = s;
                super();
            }

        // Unreferenced inner class com/tapjoy/FiveRocksIntegration$1$1$2

/* anonymous class */
        final class FiveRocksIntegration._cls1._cls1._cls2
            implements TJActionRequest
        {

            final String a;
            final String b;
            final FiveRocksIntegration._cls1._cls1 c;

            public final void cancelled()
            {
            }

            public final void completed()
            {
            }

            public final String getRequestId()
            {
                return a;
            }

            public final String getToken()
            {
                return b;
            }

                    
                    {
                        c = FiveRocksIntegration._cls1._cls1.this;
                        a = s;
                        b = s1;
                        super();
                    }
        }

    }

}
