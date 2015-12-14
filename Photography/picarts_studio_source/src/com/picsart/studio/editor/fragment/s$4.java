// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.EffectsDrawHistoryController;
import com.picsart.effectnew.e;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.custommasks.Mask;
import com.picsart.studio.editor.custommasks.d;
import com.picsart.studio.editor.custommasks.m;
import com.picsart.studio.editor.custommasks.n;
import com.socialin.android.util.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

public final class a
    implements android.view..OnClickListener
{

    public final s a;

    public final void onClick(View view)
    {
        if (s.t(a) || !a.isVisible())
        {
            return;
        }
        ((EditorActivity)a.getActivity()).d();
        view = c.a(s.u(a), s.u(a).getConfig());
        Object obj = new Canvas(view);
        Mask mask = com.picsart.studio.editor.fragment.s.e(a).c;
        if (mask != null)
        {
            mask.a(a.getActivity(), s.u(a), ((Canvas) (obj)));
        }
        obj = s.q(a).c.n.d();
        view = new m(s.u(a), s.j(a), view, ((java.util.ArrayList) (obj)));
        view.a = new n(this);
        view.executeOnExecutor(s.v(a), new Void[0]);
    }

    (s s1)
    {
        a = s1;
        super();
    }
}
