// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.TextItem;
import com.picsart.studio.editor.item.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements c
{

    private q a;

    public final void a(Item item)
    {
        ((EditorActivity)a.getActivity()).a(a, (TextItem)item);
    }

    rActivity(q q1)
    {
        a = q1;
        super();
    }
}
