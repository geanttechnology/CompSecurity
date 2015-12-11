// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.m.d;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.services.aa;
import com.target.mothership.services.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a
    implements aa
{

    public a()
    {
    }

    public volatile Object a(Object obj)
    {
        return a((v)obj);
    }

    public List a(v v1)
    {
        if (v1 == null || v1.a() == null)
        {
            return Collections.emptyList();
        }
        v1 = (com.target.mothership.services.apigee.m.b.a[])b.a().k().a(v1.a(), [Lcom/target/mothership/services/apigee/m/b/a;);
        if (v1 == null)
        {
            return Collections.emptyList();
        } else
        {
            return new ArrayList(Arrays.asList(v1));
        }
    }
}
