// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.a.q;
import com.smule.android.network.core.a;
import com.smule.android.network.core.b;
import com.smule.android.network.models.AccountIcon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

// Referenced classes of package com.smule.android.network.managers:
//            x, y, ab, aa

public class RecommendationManager
{

    protected static RecommendationManager a = null;
    private static final String b = com/smule/android/network/managers/RecommendationManager.getName();

    private RecommendationManager()
    {
    }

    public static RecommendationManager a()
    {
        if (a == null)
        {
            a = new RecommendationManager();
        }
        return a;
    }

    public x a(String s)
    {
        return com.smule.android.network.managers.x.a(q.a(s));
    }

    public Future a(GetRecommendedDemographicSongsCallback getrecommendeddemographicsongscallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(getrecommendeddemographicsongscallback) {

            final GetRecommendedDemographicSongsCallback a;
            final RecommendationManager b;

            public void run()
            {
                com.smule.android.network.core.a.a(a, b.b());
            }

            
            {
                b = RecommendationManager.this;
                a = getrecommendeddemographicsongscallback;
                super();
            }
        });
    }

    public Future a(String s, GetRecommendedSingersCallback getrecommendedsingerscallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(getrecommendedsingerscallback, s) {

            final GetRecommendedSingersCallback a;
            final String b;
            final RecommendationManager c;

            public void run()
            {
                com.smule.android.network.core.a.a(a, c.c(b));
            }

            
            {
                c = RecommendationManager.this;
                a = getrecommendedsingerscallback;
                b = s;
                super();
            }
        });
    }

    public Future a(String s, GetRecommendedSongsBySongCallback getrecommendedsongsbysongcallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(getrecommendedsongsbysongcallback, s) {

            final GetRecommendedSongsBySongCallback a;
            final String b;
            final RecommendationManager c;

            public void run()
            {
                com.smule.android.network.core.a.a(a, c.b(b));
            }

            
            {
                c = RecommendationManager.this;
                a = getrecommendedsongsbysongcallback;
                b = s;
                super();
            }
        });
    }

    public Future a(String s, RecommedationSelectCallback recommedationselectcallback)
    {
        return com.smule.android.network.core.b.a(new Runnable(recommedationselectcallback, s) {

            final RecommedationSelectCallback a;
            final String b;
            final RecommendationManager c;

            public void run()
            {
                com.smule.android.network.core.a.a(a, c.a(b));
            }

            
            {
                c = RecommendationManager.this;
                a = recommedationselectcallback;
                b = s;
                super();
            }
        });
    }

    public y b()
    {
        return com.smule.android.network.managers.y.a(q.a());
    }

    public y b(String s)
    {
        return com.smule.android.network.managers.y.a(q.b(s));
    }

    public ab c(String s)
    {
        return com.smule.android.network.managers.ab.a(q.c(s));
    }


    // Unreferenced inner class com/smule/android/network/managers/RecommendationManager$5

/* anonymous class */
    class _cls5
        implements Runnable
    {

        final aa a;
        private ArrayList b;
        private boolean c;

        static ArrayList a(_cls5 _pcls5)
        {
            return _pcls5.b;
        }

        static ArrayList a(_cls5 _pcls5, ArrayList arraylist)
        {
            _pcls5.b = arraylist;
            return arraylist;
        }

        static boolean a(_cls5 _pcls5, boolean flag)
        {
            _pcls5.c = flag;
            return flag;
        }

        static boolean b(_cls5 _pcls5)
        {
            return _pcls5.c;
        }

        public void run()
        {
            com.smule.android.network.managers.RecommendationManager.a().a("NEW", new GetRecommendedSingersCallback(this) {

                final _cls5 a;

                public void handleResponse(ab ab1)
                {
    class _cls5
        implements Runnable
    {
label0:
                    {
                        if (ab1.a())
                        {
                            AccountIcon accounticon;
                            for (ab1 = ab1.mAccountIcons.iterator(); ab1.hasNext(); com.smule.android.network.managers._cls5.a(a).add(accounticon))
                            {
                                accounticon = (AccountIcon)ab1.next();
                                accounticon.a("NEW");
                            }

                            if (!com.smule.android.network.managers._cls5.b(a))
                            {
                                break label0;
                            }
                            com.smule.android.network.managers._cls5.a(a, new ArrayList(new HashSet(com.smule.android.network.managers._cls5.a(a))));
                            Collections.shuffle(com.smule.android.network.managers._cls5.a(a));
                            a.a.a(com.smule.android.network.managers._cls5.a(a));
                        }
                        return;
                    }
                    com.smule.android.network.managers._cls5.a(a, true);
                }

                public volatile void handleResponse(Object obj)
                {
                    handleResponse((ab)obj);
                }

            
            {
                a = _pcls5;
                super();
            }
            });
            com.smule.android.network.managers.RecommendationManager.a().a("SUGGESTED", new GetRecommendedSingersCallback(this) {

                final _cls5 a;

                public void handleResponse(ab ab1)
                {
label0:
                    {
                        if (ab1.a())
                        {
                            AccountIcon accounticon;
                            for (ab1 = ab1.mAccountIcons.iterator(); ab1.hasNext(); com.smule.android.network.managers._cls5.a(a).add(accounticon))
                            {
                                accounticon = (AccountIcon)ab1.next();
                                accounticon.a("SUGGESTED");
                            }

                            if (!com.smule.android.network.managers._cls5.b(a))
                            {
                                break label0;
                            }
                            com.smule.android.network.managers._cls5.a(a, new ArrayList(new HashSet(com.smule.android.network.managers._cls5.a(a))));
                            Collections.shuffle(com.smule.android.network.managers._cls5.a(a));
                            a.a.a(com.smule.android.network.managers._cls5.a(a));
                        }
                        return;
                    }
                    com.smule.android.network.managers._cls5.a(a, true);
                }

                public volatile void handleResponse(Object obj)
                {
                    handleResponse((ab)obj);
                }

            
            {
                a = _pcls5;
                super();
            }
            });
        }
    }

}
