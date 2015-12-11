// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.try;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package io.presage.try:
//            a, d

public final class h extends FrameLayout
{
    public static interface a
    {

        public abstract void a();
    }


    private HashMap a;
    private HashSet b;
    private a c;

    public h(Context context)
    {
        super(context);
        a = new HashMap();
        b = new HashSet();
    }

    public final io.presage.try.a a(String s)
    {
        return (io.presage.try.a)a.get(s);
    }

    public final HashSet a()
    {
        return b;
    }

    public final void a(io.presage.try.a a1)
    {
        addView((View)a1);
        a.put(a1.a(), a1);
        if (a1 instanceof d)
        {
            b.add(a1.a());
        }
    }

    public final void a(a a1)
    {
        c = a1;
    }

    public final Set b()
    {
        return a.keySet();
    }

    public final void b(String s)
    {
        removeView((View)(io.presage.try.a)a.remove(s));
        b.remove(s);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (c != null && 4 == keyevent.getKeyCode() && 1 == keyevent.getAction())
        {
            c.a();
        }
        return super.dispatchKeyEvent(keyevent);
    }
}
