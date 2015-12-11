// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.ViewPropertyAnimator;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.fragment.musicdetails.a;

public final class g
    implements a
{

    private final BaseAppCompatActivity b;
    private boolean c;

    public g(BaseAppCompatActivity baseappcompatactivity)
    {
        b = baseappcompatactivity;
    }

    public final void a()
    {
        Toolbar toolbar = b.getToolbar();
        android.support.v7.a.a a1 = b.getSupportActionBar();
        if (a1 != null && toolbar != null && !c)
        {
            c = true;
            toolbar.animate().translationY(-toolbar.getHeight()).setListener(new AnimatorListenerAdapter(a1) {

                final android.support.v7.a.a a;
                final g b;

                public final void onAnimationEnd(Animator animator)
                {
                    a.d();
                }

            
            {
                b = g.this;
                a = a1;
                super();
            }
            });
        }
    }

    public final void b()
    {
        Toolbar toolbar = b.getToolbar();
        android.support.v7.a.a a1 = b.getSupportActionBar();
        if (a1 != null && toolbar != null && c)
        {
            c = false;
            toolbar.setTranslationY(-toolbar.getHeight());
            a1.c();
            toolbar.animate().setListener(null).translationY(0.0F);
        }
    }
}
