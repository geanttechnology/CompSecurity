// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.f;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.l;
import android.support.v4.widget.DrawerLayout;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import com.google.a.a.e;

// Referenced classes of package com.target.ui.f:
//            f, d

public class c
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a SLIDE_BOTTOM;
        public static final a SLIDE_RIGHT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/f/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            SLIDE_RIGHT = new a("SLIDE_RIGHT", 0);
            SLIDE_BOTTOM = new a("SLIDE_BOTTOM", 1);
            $VALUES = (new a[] {
                SLIDE_RIGHT, SLIDE_BOTTOM
            });
        }

        private a(String s, int j)
        {
            super(s, j);
        }
    }


    private int mContainerId;
    private View mDrawer;
    private DrawerLayout mDrawerLayout;
    private h mFragmentManager;

    public c(h h1, int j, DrawerLayout drawerlayout, View view)
    {
        mFragmentManager = h1;
        mContainerId = j;
        mDrawerLayout = drawerlayout;
        mDrawer = view;
    }

    private static Transition a(Object obj)
    {
        try
        {
            obj = (Transition)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        return ((Transition) (obj));
    }

    private static void a(Context context, Fragment fragment, Fragment fragment1)
    {
        fragment.setEnterTransition(TransitionInflater.from(context).inflateTransition(0x10f0002));
        fragment.setExitTransition(TransitionInflater.from(context).inflateTransition(0x10f0002));
        fragment = TransitionInflater.from(context).inflateTransition(0x10f0006);
        fragment.setDuration(context.getResources().getInteger(0x7f0b000b));
        fragment1.setSharedElementEnterTransition(TransitionInflater.from(context).inflateTransition(0x7f050000));
        fragment1.setEnterTransition(TransitionInflater.from(context).inflateTransition(0x10f0002));
        fragment1.setReturnTransition(fragment);
    }

    private static void a(Fragment fragment, Fragment fragment1, f f1, f f2)
    {
        if (f1 != null)
        {
            a(fragment, f1);
        }
        if (f2 != null)
        {
            a(fragment1, f2);
        }
    }

    private static void a(Fragment fragment, f f1)
    {
        Transition transition = a(fragment.getEnterTransition());
        Transition transition1 = a(fragment.getExitTransition());
        Transition transition2 = a(fragment.getReenterTransition());
        Transition transition3 = a(fragment.getReturnTransition());
        Transition transition4 = a(fragment.getSharedElementEnterTransition());
        fragment = a(fragment.getSharedElementReturnTransition());
        android.transition.Transition.TransitionListener transitionlistener = (android.transition.Transition.TransitionListener)f1.b().d();
        android.transition.Transition.TransitionListener transitionlistener1 = (android.transition.Transition.TransitionListener)f1.c().d();
        android.transition.Transition.TransitionListener transitionlistener2 = (android.transition.Transition.TransitionListener)f1.d().d();
        android.transition.Transition.TransitionListener transitionlistener3 = (android.transition.Transition.TransitionListener)f1.e().d();
        android.transition.Transition.TransitionListener transitionlistener4 = (android.transition.Transition.TransitionListener)f1.a().d();
        f1 = (android.transition.Transition.TransitionListener)f1.f().d();
        if (transition != null && transitionlistener != null)
        {
            transition.addListener(transitionlistener);
        }
        if (transition1 != null && transitionlistener1 != null)
        {
            transition1.addListener(transitionlistener1);
        }
        if (transition2 != null && transitionlistener2 != null)
        {
            transition2.addListener(transitionlistener2);
        }
        if (transition3 != null && transitionlistener3 != null)
        {
            transition3.addListener(transitionlistener3);
        }
        if (transition4 != null && transitionlistener4 != null)
        {
            transition4.addListener(transitionlistener4);
        }
        if (fragment != null && f1 != null)
        {
            fragment.addListener(f1);
        }
    }

    private void a(l l1, a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$manager$NavigationFragmentManager$AnimationType[];

            static 
            {
                $SwitchMap$com$target$ui$manager$NavigationFragmentManager$AnimationType = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$manager$NavigationFragmentManager$AnimationType[a.SLIDE_BOTTOM.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$manager$NavigationFragmentManager$AnimationType[a.SLIDE_RIGHT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.manager.NavigationFragmentManager.AnimationType[a1.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 48;
           goto _L1 _L2
_L1:
        int j;
        int k;
        k = 0x7f04000e;
        j = 0x7f040010;
_L4:
        l1.a(k, 0x7f040001, 0x7f040000, j);
        return;
_L2:
        k = 0x7f04000d;
        j = 0x7f04000f;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b(Fragment fragment, d d1, String s)
    {
        l l1 = mFragmentManager.a();
        l1.b(mContainerId, fragment, s);
        l1.a(null);
        l1.a(d1.b(), d1.c());
        l1.a();
        mFragmentManager.b();
        c();
    }

    private void c()
    {
        if (mDrawerLayout != null && mDrawer != null && mDrawerLayout.j(mDrawer))
        {
            mDrawerLayout.i(mDrawer);
        }
    }

    private Fragment d()
    {
        return mFragmentManager.a(mContainerId);
    }

    public static void f(Fragment fragment)
    {
        if (fragment == null)
        {
            return;
        } else
        {
            fragment.setEnterTransition(null);
            fragment.setExitTransition(null);
            return;
        }
    }

    public void a()
    {
        mFragmentManager.a(null, 1);
        c();
    }

    public void a(Fragment fragment)
    {
        a(fragment, g(fragment));
    }

    public void a(Fragment fragment, a a1)
    {
        a(fragment, a1, g(fragment));
    }

    public void a(Fragment fragment, a a1, String s)
    {
        l l1 = mFragmentManager.a();
        a(l1, a1);
        l1.b(mContainerId, fragment, s);
        l1.a(s);
        l1.a();
        mFragmentManager.b();
        c();
    }

    public void a(Fragment fragment, d d1)
    {
        a(fragment, d1, g(fragment));
    }

    public void a(Fragment fragment, d d1, String s)
    {
        Context context = d1.d().getApplicationContext();
        com.target.ui.fragment.common.BaseNavigationFragment basenavigationfragment = d1.e();
        a(context, ((Fragment) (basenavigationfragment)), fragment);
        a(((Fragment) (basenavigationfragment)), fragment, (f)d1.f().d(), (f)d1.g().d());
        b(fragment, d1, s);
    }

    public void a(Fragment fragment, String s)
    {
        mFragmentManager.a(null, 1);
        l l1 = mFragmentManager.a();
        l1.b(mContainerId, fragment, s);
        l1.a();
        mFragmentManager.b();
        c();
    }

    public void a(String s)
    {
        mFragmentManager.a(s, 0);
    }

    public void b()
    {
        mFragmentManager.d();
    }

    public void b(Fragment fragment)
    {
        mFragmentManager.a(null, 1);
        Fragment fragment1 = d();
        if (fragment1 != null && fragment1.getClass().equals(fragment.getClass()))
        {
            c();
            return;
        } else
        {
            a(fragment);
            return;
        }
    }

    public void b(Fragment fragment, String s)
    {
        a(fragment, a.SLIDE_RIGHT, s);
    }

    public void c(Fragment fragment)
    {
        l l1 = mFragmentManager.a();
        l1.a(fragment, g(fragment));
        l1.a();
    }

    public void c(Fragment fragment, String s)
    {
        mFragmentManager.a(null, 1);
        l l1 = mFragmentManager.a();
        l1.b(mContainerId, fragment, s);
        l1.a(null);
        l1.a();
        mFragmentManager.b();
        c();
    }

    public void d(Fragment fragment)
    {
        b(fragment, g(fragment));
    }

    public void d(Fragment fragment, String s)
    {
        if (mFragmentManager.e() == 0)
        {
            a(fragment, s);
            return;
        } else
        {
            b();
            b(fragment, s);
            return;
        }
    }

    public void e(Fragment fragment)
    {
        c(fragment, g(fragment));
    }

    public String g(Fragment fragment)
    {
        return fragment.getClass().getSimpleName();
    }

    public void h(Fragment fragment)
    {
        l l1 = mFragmentManager.a();
        l1.a(fragment);
        l1.a();
    }

    public void i(Fragment fragment)
    {
        d(fragment, g(fragment));
    }
}
