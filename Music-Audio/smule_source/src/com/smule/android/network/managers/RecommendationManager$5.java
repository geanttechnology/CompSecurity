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
//            RecommendationManager, aa, ab

class _cls2.a
    implements Runnable
{

    final aa a;
    private ArrayList b;
    private boolean c;

    static ArrayList a(_cls2.a a1)
    {
        return a1.b;
    }

    static ArrayList a(b b1, ArrayList arraylist)
    {
        b1.b = arraylist;
        return arraylist;
    }

    static boolean a(b b1, boolean flag)
    {
        b1.c = flag;
        return flag;
    }

    static boolean b(c c1)
    {
        return c1.c;
    }

    public void run()
    {
        RecommendationManager.a().a("NEW", new _cls1());
        RecommendationManager.a().a("SUGGESTED", new _cls2());
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


    // Unreferenced inner class com/smule/android/network/managers/RecommendationManager$6$2

/* anonymous class */
    class RecommendationManager._cls6._cls2
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
                        accounticon.a("SUGGESTED");
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
