// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.widget.erView.OnItemClickListener
{

    private q a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        q.b(a, i);
    }

    stener(q q1)
    {
        a = q1;
        super();
    }
}
