// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.DialogFragment;
import android.view.View;
import android.widget.ProgressBar;
import com.picsart.studio.editor.utils.a;
import com.socialin.android.dialog.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            p

final class a
    implements c
{

    private p a;

    public final void onViewCreated(View view, DialogFragment dialogfragment)
    {
        com.picsart.studio.editor.fragment.p.a(a, (ProgressBar)view.findViewById(0x7f1003fd));
        p.n(a).setProgress(p.j().i);
    }

    (p p1)
    {
        a = p1;
        super();
    }
}
