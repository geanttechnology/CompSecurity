// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j;

import com.j.a.a;
import com.target.ui.j.b.c;
import com.target.ui.j.b.d;
import com.target.ui.j.b.e;
import com.target.ui.j.b.g;
import com.target.ui.j.b.h;
import com.target.ui.j.b.i;
import java.util.Map;

public class b
{

    public static void a()
    {
        k();
        j();
        i();
        l();
        m();
        n();
        o();
    }

    static void b()
    {
        i();
    }

    static void c()
    {
        j();
    }

    static void d()
    {
        k();
    }

    static void e()
    {
        l();
    }

    static void f()
    {
        m();
    }

    static void g()
    {
        n();
    }

    static void h()
    {
        o();
    }

    private static void i()
    {
        com.j.a.a.a("Android List vs Grid view for search/browse", new com.j.a.b() {

            public void a()
            {
                b.b();
            }

            public void a(String s, Map map)
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR lookupswitch 2: default 32
            //                           -1468560237: 71
            //                           -1256140741: 57;
                   goto _L1 _L2 _L3
_L1:
                break; /* Loop/switch isn't completed */
_L2:
                break MISSING_BLOCK_LABEL_71;
_L4:
                switch (byte0)
                {
                default:
                    return;

                case 0: // '\0'
                    com.target.ui.j.b.a.a().d().a(com.target.ui.j.b.e.a.EXPERIMENT_LIST_VIEW);
                    return;

                case 1: // '\001'
                    com.target.ui.j.b.a.a().d().a(com.target.ui.j.b.e.a.EXPERIMENT_GRID_VIEW);
                    break;
                }
                break MISSING_BLOCK_LABEL_110;
_L3:
                if (s.equals("List view for search and browse"))
                {
                    byte0 = 0;
                }
                  goto _L4
                if (s.equals("Grid view for search and browse"))
                {
                    byte0 = 1;
                }
                  goto _L4
            }

            public void a(Map map)
            {
                com.target.ui.j.b.a.a().d().a(com.target.ui.j.b.e.a.EXPERIMENT_DEFAULT);
            }

        });
    }

    private static void j()
    {
        com.j.a.a.a("Android Purchase CTA copy", new com.j.a.b() {

            public void a()
            {
                c();
            }

            public void a(String s, Map map)
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR lookupswitch 4: default 48
            //                           -1399842393: 95
            //                           -13185722: 81
            //                           67174: 123
            //                           1936828424: 109;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                break; /* Loop/switch isn't completed */
_L4:
                break MISSING_BLOCK_LABEL_123;
_L6:
                switch (byte0)
                {
                default:
                    return;

                case 0: // '\0'
                    com.target.ui.j.b.a.a().c().a(com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_SUBMIT_ORDER);
                    return;

                case 1: // '\001'
                    com.target.ui.j.b.a.a().c().a(com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_COMPLETE_ORDER);
                    return;

                case 2: // '\002'
                    com.target.ui.j.b.a.a().c().a(com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_COMPLETE_PURCHASE);
                    return;

                case 3: // '\003'
                    com.target.ui.j.b.a.a().c().a(com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_BUY);
                    break;
                }
                break MISSING_BLOCK_LABEL_188;
_L3:
                if (s.equals("Submit Order"))
                {
                    byte0 = 0;
                }
                  goto _L6
_L2:
                if (s.equals("Complete Order"))
                {
                    byte0 = 1;
                }
                  goto _L6
_L5:
                if (s.equals("Complete Purchase"))
                {
                    byte0 = 2;
                }
                  goto _L6
                if (s.equals("Buy"))
                {
                    byte0 = 3;
                }
                  goto _L6
            }

            public void a(Map map)
            {
                com.target.ui.j.b.a.a().c().a(com.target.ui.j.b.i.a.EXPERIMENT_PURCHASE_CTA_DEFAULT);
            }

        });
    }

    private static void k()
    {
        com.j.a.a.a("Android Express Checkout", new com.j.a.b() {

            public void a()
            {
                d();
            }

            public void a(String s, Map map)
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR tableswitch -1308979344 -1308979344: default 24
            //                           -1308979344 45;
                   goto _L1 _L2
_L2:
                if (s.equals("express"))
                {
                    byte0 = 0;
                }
_L1:
                switch (byte0)
                {
                default:
                    return;

                case 0: // '\0'
                    com.target.ui.j.b.a.a().b().a(com.target.ui.j.b.g.a.EXPERIMENT_SHOW_EXPRESS_CHECKOUT);
                    break;
                }
                return;
            }

            public void a(Map map)
            {
                com.target.ui.j.b.a.a().b().a(com.target.ui.j.b.g.a.EXPERIMENT_DEFAULT);
            }

        });
    }

    private static void l()
    {
        com.j.a.a.a("Android Cart Product Recommendations", new com.j.a.b() {

            public void a()
            {
                e();
            }

            public void a(String s, Map map)
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR tableswitch 1554493146 1554493146: default 24
            //                           1554493146 45;
                   goto _L1 _L2
_L2:
                if (s.equals("cart recommendations"))
                {
                    byte0 = 0;
                }
_L1:
                switch (byte0)
                {
                default:
                    return;

                case 0: // '\0'
                    com.target.ui.j.b.a.a().e().a(com.target.ui.j.b.a.EXPERIMENT_SHOW_RECOMMENDATIONS);
                    break;
                }
                return;
            }

            public void a(Map map)
            {
                com.target.ui.j.b.a.a().e().a(com.target.ui.j.b.a.EXPERIMENT_DEFAULT);
            }

        });
    }

    private static void m()
    {
        com.j.a.a.a("Deals Tab", new com.j.a.b() {

            public void a()
            {
                b.f();
            }

            public void a(String s, Map map)
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR tableswitch -859141586 -859141586: default 24
            //                           -859141586 45;
                   goto _L1 _L2
_L2:
                if (s.equals("NewDealsTab"))
                {
                    byte0 = 0;
                }
_L1:
                switch (byte0)
                {
                default:
                    return;

                case 0: // '\0'
                    com.target.ui.j.b.a.a().f().a(com.target.ui.j.b.c.a.EXPERIMENT_NEW_TAB);
                    break;
                }
                return;
            }

            public void a(Map map)
            {
                com.target.ui.j.b.a.a().f().a(com.target.ui.j.b.c.a.EXPERIMENT_DEFAULT);
            }

        });
    }

    private static void n()
    {
        com.j.a.a.a("Android PLP Grid Product Info", new com.j.a.b() {

            public void a()
            {
                g();
            }

            public void a(String s, Map map)
            {
                byte byte0;
                map = null;
                byte0 = -1;
                s.hashCode();
                JVM INSTR lookupswitch 2: default 36
            //                           -339952821: 81
            //                           1843020933: 67;
                   goto _L1 _L2 _L3
_L1:
                byte0;
                JVM INSTR tableswitch 0 1: default 60
            //                           0 95
            //                           1 102;
                   goto _L4 _L5 _L6
_L4:
                s = map;
_L7:
                if (s == null)
                {
                    return;
                } else
                {
                    com.target.ui.j.b.a.a().g().a(s);
                    return;
                }
_L3:
                if (s.equals("Deals Tag And Rating"))
                {
                    byte0 = 0;
                }
                  goto _L1
_L2:
                if (s.equals("Deals Tag Only"))
                {
                    byte0 = 1;
                }
                  goto _L1
_L5:
                s = com.target.ui.j.b.h.a.EXPERIMENT_DEALS_TAG_AND_RATING;
                  goto _L7
_L6:
                s = com.target.ui.j.b.h.a.EXPERIMENT_DEALS_TAG_ONLY;
                  goto _L7
            }

            public void a(Map map)
            {
                com.target.ui.j.b.a.a().g().a(com.target.ui.j.b.h.a.EXPERIMENT_DEFAULT);
            }

        });
    }

    private static void o()
    {
        com.j.a.a.a("Android Contextual Card Stream", new com.j.a.b() {

            public void a()
            {
                h();
            }

            public void a(String s, Map map)
            {
                byte byte0 = -1;
                s.hashCode();
                JVM INSTR tableswitch 1236287382 1236287382: default 24
            //                           1236287382 45;
                   goto _L1 _L2
_L2:
                if (s.equals("In Store Card Stream"))
                {
                    byte0 = 0;
                }
_L1:
                switch (byte0)
                {
                default:
                    return;

                case 0: // '\0'
                    com.target.ui.j.b.a.a().h().a(com.target.ui.j.b.d.a.EXPERIMENT_SHOW_CARD_STREAM);
                    break;
                }
                return;
            }

            public void a(Map map)
            {
                com.target.ui.j.b.a.a().h().a(com.target.ui.j.b.d.a.EXPERIMENT_DEFAULT);
            }

        });
    }
}
