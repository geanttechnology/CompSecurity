// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib;


// Referenced classes of package com.huewu.pla.lib:
//            b, MultiColumnListView

class c extends b
{

    final MultiColumnListView b;

    public c(MultiColumnListView multicolumnlistview)
    {
        b = multicolumnlistview;
        super(multicolumnlistview, 0x7fffffff);
    }

    public int d()
    {
        return b.getScrollChildBottom();
    }

    public int e()
    {
        return b.getScrollChildTop();
    }
}
