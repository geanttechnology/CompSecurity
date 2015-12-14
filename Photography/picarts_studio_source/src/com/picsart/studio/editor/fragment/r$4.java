// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.h;
import com.picsart.studio.editor.history.a;
import com.picsart.studio.editor.view.EditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            r

final class a
    implements h
{

    private r a;

    public final void a()
    {
        if (a.getView() != null)
        {
            ((EditorActivity)a.getActivity()).e();
            r r1 = a;
            a a1 = e.a().c;
            if (r1.getView() != null)
            {
                r1.getView().findViewById(0x7f1003a3).setEnabled(a1.c());
                r1.getView().findViewById(0x7f100571).setEnabled(a1.b());
                r1.getView().findViewById(0x7f1005bf).setEnabled(a1.c());
                r1.c.setImage(e.a().b);
                r1.c.invalidate();
            }
        }
    }

    ew(r r1)
    {
        a = r1;
        super();
    }
}
