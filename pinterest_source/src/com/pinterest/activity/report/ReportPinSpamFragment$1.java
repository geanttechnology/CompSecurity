// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.activity.report;

import java.util.ArrayList;

// Referenced classes of package com.pinterest.activity.report:
//            ReportPinSpamFragment

class add extends ArrayList
{

    final ReportPinSpamFragment this$0;

    ()
    {
        this$0 = ReportPinSpamFragment.this;
        super();
        add("spamPin");
        add("pinFromFakeAccount");
        add("pinFromHackedAccount");
    }
}
