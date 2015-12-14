// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.AdapterView;
import com.picsart.studio.editor.custommasks.Mask;
import com.picsart.studio.editor.custommasks.d;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a
    implements android.widget.terView.OnItemSelectedListener
{

    private s a;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        view = s.e(a).c;
        adapterview = (com.picsart.studio.editor.custommasks..BlendMode)adapterview.getItemAtPosition(i);
        if (view != null && view.a(false) != adapterview)
        {
            view.g = adapterview;
            s.a(a, a.getActivity(), view);
        }
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    ask(s s1)
    {
        a = s1;
        super();
    }
}
