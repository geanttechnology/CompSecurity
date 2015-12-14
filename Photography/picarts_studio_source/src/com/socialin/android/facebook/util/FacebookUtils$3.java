// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook.util;

import android.app.Activity;
import com.facebook.AccessToken;
import com.socialin.android.facebook.p;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.socialin.android.facebook.util:
//            FacebookUtils

final class d
    implements p
{

    private List a;
    private p b;
    private Activity c;
    private String d[];

    public final void a()
    {
        if (AccessToken.getCurrentAccessToken().getPermissions().containsAll(a))
        {
            b.a();
            return;
        } else
        {
            FacebookUtils.access$900(c, b, d);
            return;
        }
    }

    (List list, p p1, Activity activity, String as[])
    {
        a = list;
        b = p1;
        c = activity;
        d = as;
        super();
    }
}
