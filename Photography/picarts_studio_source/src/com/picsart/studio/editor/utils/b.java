// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.utils;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.ProgressBar;
import com.picsart.studio.editor.fragment.p;
import com.socialin.android.dialog.a;
import com.socialin.android.util.Utils;

public class b
{

    public p a;

    public b(p p1)
    {
        a = p1;
        super();
    }

    public void a()
    {
        p.o(a);
        String s = a.getString(0x7f0805ca);
        if (p.r(a) != null)
        {
            p.r(a).dismiss();
        }
        Utils.b(a.getActivity(), s);
    }

    public void a(int i)
    {
        p.n(a).setProgress(i);
    }

    public void a(com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions gifoptions)
    {
        if (p.r(a) == null || p.r(a).getDialog() == null) goto _L2; else goto _L1
_L1:
        p.r(a).getDialog().dismiss();
_L4:
        if (a.getActivity() != null)
        {
            p.o(a);
            p.a(a, gifoptions);
        }
        return;
_L2:
        if (p.r(a) != null && a.getActivity() != null)
        {
            FragmentTransaction fragmenttransaction = a.getFragmentManager().beginTransaction();
            fragmenttransaction.remove(p.r(a));
            fragmenttransaction.commit();
            a.getFragmentManager().popBackStack();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
