// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import java.util.ArrayList;

public final class iy
{

    final ii a;
    final ArrayList b = new ArrayList();
    final il c;
    in d;

    iy(ii ii1)
    {
        a = ii1;
        c = ii1.b;
    }

    final int a(String s)
    {
        int j = b.size();
        for (int i = 0; i < j; i++)
        {
            if (((iz)b.get(i)).a.equals(s))
            {
                return i;
            }
        }

        return -1;
    }

    public final String a()
    {
        return c.a.getPackageName();
    }

    public final String toString()
    {
        return (new StringBuilder("MediaRouter.RouteProviderInfo{ packageName=")).append(a()).append(" }").toString();
    }
}
