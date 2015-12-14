// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.activity.EditorActivity;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            l

final class a
    implements android.view..OnClickListener
{

    private l a;

    public final void onClick(View view)
    {
        ((EditorActivity)a.getActivity()).d(a);
    }

    orActivity(l l1)
    {
        a = l1;
        super();
    }
}
