// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.models.AccountIcon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.android.network.managers:
//            ab, aa, RecommendationManager

class a
    implements ecommendedSingersCallback
{

    final handleResponse a;

    public void handleResponse(ab ab1)
    {
label0:
        {
            if (ab1.a())
            {
                AccountIcon accounticon;
                for (ab1 = ab1.mAccountIcons.iterator(); ab1.hasNext(); ecommendedSingersCallback(a).add(accounticon))
                {
                    accounticon = (AccountIcon)ab1.next();
                    accounticon.a("SUGGESTED");
                }

                if (!a(a))
                {
                    break label0;
                }
                a(a, new ArrayList(new HashSet(a(a))));
                Collections.shuffle(a(a));
                a.a.a(a(a));
            }
            return;
        }
        a(a, true);
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((ab)obj);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/smule/android/network/managers/RecommendationManager$5

/* anonymous class */
    class RecommendationManager._cls5
        implements Runnable
    {

        final aa a;
        private ArrayList b;
        private boolean c;

        static ArrayList a(RecommendationManager._cls5 _pcls5)
        {
            return _pcls5.b;
        }

        static ArrayList a(RecommendationManager._cls5 _pcls5, ArrayList arraylist)
        {
            _pcls5.b = arraylist;
            return arraylist;
        }

        static boolean a(RecommendationManager._cls5 _pcls5, boolean flag)
        {
            _pcls5.c = flag;
            return flag;
        }

        static boolean b(RecommendationManager._cls5 _pcls5)
        {
            return _pcls5.c;
        }

        public void run()
        {
            RecommendationManager.a().a("NEW", new RecommendationManager._cls6._cls1());
            RecommendationManager.a().a("SUGGESTED", new RecommendationManager._cls6._cls2(this));
        }

        // Unreferenced inner class com/smule/android/network/managers/RecommendationManager$6$1

/* anonymous class */
        class RecommendationManager._cls6._cls1
            implements RecommendationManager.GetRecommendedSingersCallback
        {

            final RecommendationManager._cls5 a;

            public void handleResponse(ab ab1)
            {
label0:
                {
                    if (ab1.a())
                    {
                        AccountIcon accounticon;
                        for (ab1 = ab1.mAccountIcons.iterator(); ab1.hasNext(); RecommendationManager._cls5.a(a).add(accounticon))
                        {
                            accounticon = (AccountIcon)ab1.next();
                            accounticon.a("NEW");
                        }

                        if (!RecommendationManager._cls5.b(a))
                        {
                            break label0;
                        }
                        RecommendationManager._cls5.a(a, new ArrayList(new HashSet(RecommendationManager._cls5.a(a))));
                        Collections.shuffle(RecommendationManager._cls5.a(a));
                        a.a.a(RecommendationManager._cls5.a(a));
                    }
                    return;
                }
                RecommendationManager._cls5.a(a, true);
            }

            public volatile void handleResponse(Object obj)
            {
                handleResponse((ab)obj);
            }

                    
                    {
                        a = RecommendationManager._cls5.this;
                        super();
                    }
        }

    }

}
