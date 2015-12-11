// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.fragments.advert;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.shazam.android.advert.AdBinderStrategyType;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.advert.b.a;
import com.shazam.android.advert.e;
import com.shazam.android.advert.f.c;
import com.shazam.android.advert.f.d;
import com.shazam.android.advert.g;
import com.shazam.android.advert.h;
import com.shazam.android.aspects.c.b.b;
import com.shazam.android.aspects.fragments.ShazamCustomFragmentAspect;
import com.shazam.android.widget.tagging.n;
import com.shazam.android.widget.tagging.o;

public class FragmentAdBinderAspect extends ShazamCustomFragmentAspect
{

    private ShazamAdView shazamAdView;
    private g strategy;
    private final h strategyFactory;

    public FragmentAdBinderAspect()
    {
        this(new h());
    }

    public FragmentAdBinderAspect(h h1)
    {
        strategyFactory = h1;
    }

    private static a findAnnotationRecursively(Class class1)
    {
        a a1 = (a)class1.getAnnotation(com/shazam/android/advert/b/a);
        Class class2 = class1.getSuperclass();
        class1 = a1;
        if (a1 == null)
        {
            class1 = a1;
            if (class2 != null)
            {
                class1 = findAnnotationRecursively(class2);
            }
        }
        return class1;
    }

    public static boolean isAdVisible(View view)
    {
        return view != null && view.findViewById(0x7f110004) != null && view.findViewById(0x7f110004).getVisibility() == 0;
    }

    public static void notifyFabOfAdVisibility(Fragment fragment, boolean flag)
    {
label0:
        {
            fragment = fragment.getActivity();
            if (fragment != null)
            {
                fragment = n.a(fragment);
                if (fragment != null)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    fragment.d();
                }
            }
            return;
        }
        fragment.e();
    }

    public void onDestroy(b b1)
    {
        ShazamAdView shazamadview = shazamAdView;
        b1.getActivity();
        shazamadview.f();
    }

    public void onPause(b b1)
    {
        strategy.b(b1);
    }

    public void onResume(b b1)
    {
        strategy.a(b1);
    }

    public void onSelected(b b1)
    {
        strategy.d(b1);
    }

    public void onStart(b b1)
    {
        b1.getActivity();
        ShazamAdView.a();
    }

    public void onStop(b b1)
    {
        b1.getActivity();
        ShazamAdView.e();
    }

    public void onUnselected(b b1)
    {
        strategy.c(b1);
    }

    public void onViewCreated(b b1, View view, Bundle bundle)
    {
        shazamAdView = (ShazamAdView)view.findViewById(0x7f110004);
        if (shazamAdView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (b1 instanceof com.shazam.android.advert.h.a)
        {
            shazamAdView.setAdvertSiteIdKeyProvider((com.shazam.android.advert.h.a)b1);
        }
        if (b1 instanceof com.shazam.android.advert.n)
        {
            shazamAdView.setExtraTargetParamsProvider((com.shazam.android.advert.n)b1);
        }
        if (strategy != null) goto _L1; else goto _L3
_L3:
        view = b1.getClass();
        bundle = findAnnotationRecursively(view);
        if (bundle == null)
        {
            throw new RuntimeException((new StringBuilder("Could not find annotation 'WithAd' on fragment class ")).append(view).toString());
        }
        view = bundle.a();
        if (b1 instanceof e)
        {
            view = ((e)b1).a();
        }
        b1 = shazamAdView;
        com.shazam.android.advert.h._cls1.a[view.ordinal()];
        JVM INSTR tableswitch 1 4: default 168
    //                   1 192
    //                   2 207
    //                   3 219
    //                   4 231;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        throw new RuntimeException((new StringBuilder("Strategy was not matched for: ")).append(view).toString());
_L5:
        b1 = new c(b1);
_L10:
        strategy = b1;
        return;
_L6:
        b1 = new com.shazam.android.advert.f.a(b1);
        continue; /* Loop/switch isn't completed */
_L7:
        b1 = new d(b1);
        continue; /* Loop/switch isn't completed */
_L8:
        b1 = new com.shazam.android.advert.f.b();
        if (true) goto _L10; else goto _L9
_L9:
    }
}
