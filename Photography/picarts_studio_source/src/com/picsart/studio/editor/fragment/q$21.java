// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.AdapterView;
import com.picsart.studio.editor.activity.EditorActivity;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.widget.erView.OnItemClickListener
{

    private q a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            ((EditorActivity)a.getActivity()).a(a, null);
            return;

        case 1: // '\001'
            ((EditorActivity)a.getActivity()).a(a, null);
            return;

        case 2: // '\002'
            ((EditorActivity)a.getActivity()).c(a);
            return;

        case 3: // '\003'
            ((EditorActivity)a.getActivity()).b(a);
            return;

        case 4: // '\004'
            ((EditorActivity)a.getActivity()).a(a, a.i());
            break;
        }
    }

    rActivity(q q1)
    {
        a = q1;
        super();
    }
}
