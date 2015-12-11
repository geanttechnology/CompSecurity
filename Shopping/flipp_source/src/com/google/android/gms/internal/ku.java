// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.view.View;
import android.widget.ViewSwitcher;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.android.gms.internal:
//            kt, kr, ks, ej, 
//            et

final class ku
    implements Runnable
{

    final kr a;
    final kt b;
    private final WeakReference c;

    ku(kt kt1, kr kr1)
    {
        b = kt1;
        a = kr1;
        super();
        c = new WeakReference(a);
    }

    public final void run()
    {
        kr kr1;
        v v;
label0:
        {
            b.b = false;
            kr1 = (kr)c.get();
            if (kr1 != null)
            {
                v = b.a;
                android.view.ViewParent viewparent = kr1.a.a.getParent();
                if (!(viewparent instanceof View) || !((View)viewparent).isShown() || !ej.a())
                {
                    break label0;
                }
                kr1.a(v);
            }
            return;
        }
        et.b("Ad is not visible. Not refreshing ad.");
        kr1.b.a(v);
    }
}
