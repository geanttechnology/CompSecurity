// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import com.socialin.android.facebook.l;
import com.socialin.android.facebook.p;
import java.util.Date;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class d
    implements p
{

    private l a;
    private String b;
    private Date c;
    private p d;

    public final void a()
    {
        FacebookUtils.SSO_CHECK_MODE = false;
        if (FacebookUtils.access$300() != null && FacebookUtils.access$300().a.equals(a.a))
        {
            FacebookUtils.setSSOMode(true);
            FacebookUtils.setConnectionState(true);
        } else
        {
            FacebookUtils.setSSOMode(false);
            FacebookUtils.setUserData(a);
            FacebookUtils.access$600(b, c);
        }
        FacebookUtils.access$400();
        d.a();
    }

    _cls9(l l1, String s, Date date, p p1)
    {
        a = l1;
        b = s;
        c = date;
        d = p1;
        super();
    }
}
