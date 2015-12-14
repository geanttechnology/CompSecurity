// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.rockerhieu.emojicon.EmojiconTextView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            q, p

class a
    implements android.view..OnLayoutChangeListener
{

    final p a;
    final q b;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        q.a(b).removeOnLayoutChangeListener(this);
        if (q.a(b) != null && q.b(b) != null && q.c(b) != null)
        {
            i = q.a(b).getWidth();
            j = q.b(b).getWidth();
            q.c(b).setMaxWidth(i - j);
        }
    }

    (q q1, p p)
    {
        b = q1;
        a = p;
        super();
    }
}
