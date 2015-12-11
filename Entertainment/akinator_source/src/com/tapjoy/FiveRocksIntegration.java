// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import com.tapjoy.internal.bf;
import com.tapjoy.internal.fr;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.gd;
import java.util.Hashtable;

// Referenced classes of package com.tapjoy:
//            TJPlacement, TJPlacementListener, TapjoyConnectCore, TJActionRequest

public class FiveRocksIntegration
{

    private static bf a = new bf();

    public FiveRocksIntegration()
    {
    }

    static bf a()
    {
        return a;
    }

    public static void a(Hashtable hashtable)
    {
        if (hashtable != null)
        {
            hashtable = String.valueOf(hashtable.get("TJC_OPTION_ENABLE_LOGGING"));
            if (hashtable != null && hashtable.equalsIgnoreCase("true"))
            {
                gd.a().a(true);
            }
        }
        gd.a().b();
        hashtable = new fu() {

            private fs e(String s)
            {
                return new fs(this, s) {

                    final String a;
                    final _cls1 b;

                    public final void a(String s, String s1)
                    {
                        TJPlacement tjplacement;
                        synchronized (FiveRocksIntegration.a())
                        {
                            tjplacement = (TJPlacement)FiveRocksIntegration.a().get(a);
                        }
                        if (tjplacement != null && tjplacement.a() != null)
                        {
                            s = new TJActionRequest(this, s) {

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
                            s = new TJActionRequest(this, s, s2) {

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
                            tjplacement.a().onRewardRequest(tjplacement, s, s1, i);
                        }
                    }

            
            {
                b = _pcls1;
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

        };
        gd.a().a(hashtable);
    }

    public static void addPlacementCallback(String s, TJPlacement tjplacement)
    {
        synchronized (a)
        {
            a.put(s, tjplacement);
        }
    }

}
