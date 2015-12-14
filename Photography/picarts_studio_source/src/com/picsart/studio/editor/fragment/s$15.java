// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.bumptech.glide.load.engine.GlideException;
import com.picsart.studio.editor.custommasks.Mask;
import com.picsart.studio.editor.custommasks.MaskStateHolder;
import com.picsart.studio.editor.custommasks.c;
import com.picsart.studio.editor.custommasks.d;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a
    implements c
{

    private Mask a;
    private s b;

    public final void a(GlideException glideexception)
    {
        s.a(b, glideexception);
    }

    public final void a(Mask mask)
    {
        int i = 0;
        a.a(s.f(b).g);
        a.a(s.f(b).h, s.f(b).i);
        Spinner spinner = (Spinner)s.i(b).findViewById(0x7f100709);
        SpinnerAdapter spinneradapter = spinner.getAdapter();
        mask = mask.a(false);
        for (int j = spinneradapter.getCount(); i < j && spinneradapter.getItem(i) != mask; i++) { }
        spinner.setSelection(i);
        s.a(b, a);
        s.e(b).a(a);
    }

    sk(s s1, Mask mask)
    {
        b = s1;
        a = mask;
        super();
    }
}
