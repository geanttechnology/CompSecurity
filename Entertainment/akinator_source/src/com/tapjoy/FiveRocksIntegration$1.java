// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import com.tapjoy.internal.bf;
import com.tapjoy.internal.fr;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.fu;

// Referenced classes of package com.tapjoy:
//            FiveRocksIntegration, TJPlacement, TJPlacementListener, TapjoyConnectCore, 
//            TJActionRequest

static final class _cls1.a
    implements fu
{

    private fs e(String s)
    {
        return new fs(s) {

            final String a;
            final FiveRocksIntegration._cls1 b;

            public final void a(String s1, String s2)
            {
                TJPlacement tjplacement;
                synchronized (FiveRocksIntegration.a())
                {
                    tjplacement = (TJPlacement)FiveRocksIntegration.a().get(a);
                }
                if (tjplacement != null && tjplacement.a() != null)
                {
                    s1 = new TJActionRequest(this, s1) {

                        final String a;
                        final _cls1 b;

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

            
            {
                b = _pcls1;
                a = s;
                super();
            }
                    };
                    tjplacement.a().onPurchaseRequest(tjplacement, s1, s2);
                }
            }

            public final void a(String s1, String s2, int i, String s3)
            {
                TJPlacement tjplacement;
                synchronized (FiveRocksIntegration.a())
                {
                    tjplacement = (TJPlacement)FiveRocksIntegration.a().get(a);
                }
                if (tjplacement != null && tjplacement.a() != null)
                {
                    s1 = new TJActionRequest(this, s1, s3) {

                        final String a;
                        final String b;
                        final _cls1 c;

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
                c = _pcls1;
                a = s;
                b = s1;
                super();
            }
                    };
                    tjplacement.a().onRewardRequest(tjplacement, s1, s2, i);
                }
            }

            
            {
                b = FiveRocksIntegration._cls1.this;
                a = s;
                super();
            }
        };
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

    _cls1.a()
    {
    }
}
