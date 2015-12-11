// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.request_team_member.b;

import com.target.mothership.model.a.c.a;
import java.util.Comparator;

// Referenced classes of package com.target.ui.fragment.request_team_member.b:
//            a

class this._cls0
    implements Comparator
{

    final com.target.ui.fragment.request_team_member.b.a this$0;

    public int a(a a1, a a2)
    {
        return a1.b().compareTo(a2.b());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((a)obj, (a)obj1);
    }

    ()
    {
        this$0 = com.target.ui.fragment.request_team_member.b.a.this;
        super();
    }
}
