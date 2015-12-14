// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import com.picsart.studio.editor.fragment.q;

// Referenced classes of package com.picsart.studio.editor.item:
//            Item

public class b
{

    public q a;

    public b(q q1)
    {
        a = q1;
        super();
    }

    public void a(Item item, com.picsart.studio.editor.gizmo.Gizmo.Action action)
    {
        q.a(a, item, action);
    }
}
