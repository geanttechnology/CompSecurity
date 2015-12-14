// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.custommasks.Mask;
import com.picsart.studio.editor.custommasks.MaskStateHolder;
import com.picsart.studio.editor.custommasks.d;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a
    implements android.view.OnClickListener
{

    private s a;

    public final void onClick(View view)
    {
        Mask mask;
        int i;
        mask = s.e(a).c;
        if (!mask.a())
        {
            return;
        }
        i = view.getId();
        if (i != 0x7f1006fd) goto _L2; else goto _L1
_L1:
        mask.a(true, false);
        s.f(a).h = true;
        s.f(a).i = false;
_L4:
        ((EditorActivity)a.getActivity()).d();
        s.a(a, a.getActivity(), mask);
        ((EditorActivity)a.getActivity()).e();
        return;
_L2:
        if (i == 0x7f1006fe)
        {
            mask.a(false, true);
            s.f(a).h = false;
            s.f(a).i = true;
        } else
        if (i == 0x7f100700)
        {
            mask.a(90F);
            view = s.f(a);
            view.g = ((MaskStateHolder) (view)).g + 90F;
            if (s.f(a).g > 360F)
            {
                view = s.f(a);
                view.g = ((MaskStateHolder) (view)).g - 360F;
            }
        } else
        {
            mask.a(-90F);
            view = s.f(a);
            view.g = ((MaskStateHolder) (view)).g - 90F;
            if (s.f(a).g < -360F)
            {
                view = s.f(a);
                view.g = ((MaskStateHolder) (view)).g + 360F;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    rActivity(s s1)
    {
        a = s1;
        super();
    }
}
