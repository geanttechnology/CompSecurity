// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.ui;

import aaa;
import acd;
import afs;
import aft;
import afu;
import afw;
import afx;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import eyz;

public class ScrollAwareHorizontalListView extends eyz
{

    afw a;
    public afx b;
    private int g;
    private acd h;
    private GestureDetector i;
    private android.view.GestureDetector.OnGestureListener j;
    private Runnable k;
    private Runnable l;

    public ScrollAwareHorizontalListView(Context context)
    {
        this(context, null);
    }

    public ScrollAwareHorizontalListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        h = ((KidsApplication)getContext().getApplicationContext()).h().R();
        j = new afs(this);
        k = new aft(this);
        l = new afu(this);
        g = 0;
        i = new GestureDetector(getContext(), j);
        setImportantForAccessibility(1);
    }

    public static int a(ScrollAwareHorizontalListView scrollawarehorizontallistview, int i1)
    {
        scrollawarehorizontallistview.g = i1;
        return i1;
    }

    public static Runnable a(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.l;
    }

    public static acd b(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.h;
    }

    public static Runnable c(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.k;
    }

    public static Scroller d(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.f;
    }

    public static afw e(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.a;
    }

    public static int f(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.d;
    }

    public static int g(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.g;
    }

    public static int h(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.d;
    }

    public static Scroller i(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.f;
    }

    public static afx j(ScrollAwareHorizontalListView scrollawarehorizontallistview)
    {
        return scrollawarehorizontallistview.b;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        post(k);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        super.a(i1);
        removeCallbacks(l);
        postDelayed(l, 200L);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        i.onTouchEvent(motionevent);
        return super.dispatchTouchEvent(motionevent);
    }
}
