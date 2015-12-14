// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.text.TextUtils;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.apiv3:
//            SwyftAnalytics

public class <init>
{

    private final String id;
    private final HashMap params;
    final SwyftAnalytics this$0;

    public <init> addParam(String s, Object obj)
    {
        if (obj != null)
        {
            params.put(s, obj);
        }
        return this;
    }

    public params addParam(String s, String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            params.put(s, s1);
        }
        return this;
    }

    public void track()
    {
        SwyftAnalytics.access$100(SwyftAnalytics.this, id, params);
    }

    private (String s)
    {
        this$0 = SwyftAnalytics.this;
        super();
        id = s;
        params = new HashMap();
    }

    params(String s, params params1)
    {
        this(s);
    }
}
