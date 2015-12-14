// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.idunnololz.widgets;

import android.view.animation.Animation;
import android.widget.ExpandableListView;

// Referenced classes of package com.idunnololz.widgets:
//            a, d, b

class d
    implements android.view.animation.ation.AnimationListener
{

    final int a;
    final ExpandableListView b;
    final d c;
    final b d;
    final a e;

    public void onAnimationEnd(Animation animation)
    {
        com.idunnololz.widgets.a.a(e, a);
        b.collapseGroup(a);
        e.notifyDataSetChanged();
        c.d = -1;
        d.setTag(Integer.valueOf(0));
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    stView(a a1, int i, ExpandableListView expandablelistview, d d1, b b1)
    {
        e = a1;
        a = i;
        b = expandablelistview;
        c = d1;
        d = b1;
        super();
    }
}
