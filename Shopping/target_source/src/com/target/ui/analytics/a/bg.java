// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, s

public class bg extends f
{

    private static final String SAVE_FOR_LATER_LEVEL_2 = "shopping cart";
    private static final String SAVE_FOR_LATER_LEVEL_3 = "save for later";

    private bg()
    {
    }

    public static bg j()
    {
        return new bg();
    }

    protected Map b()
    {
        return super.b();
    }

    protected s c()
    {
        return s.SaveForLater;
    }

    protected List d()
    {
        ArrayList arraylist = new ArrayList(2);
        arraylist.add("shopping cart");
        arraylist.add("save for later");
        return arraylist;
    }

    protected Long i()
    {
        return null;
    }
}
