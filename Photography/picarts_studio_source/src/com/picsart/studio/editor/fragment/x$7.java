// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.activity.EditorActivity;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            x

final class a
    implements android.view..OnClickListener
{

    private x a;

    public final void onClick(View view)
    {
        ((EditorActivity)a.getActivity()).a(a);
    }

    orActivity(x x1)
    {
        a = x1;
        super();
    }
}
