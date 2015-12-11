// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.bj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class tj
{

    public static final tj a = new tj();

    private tj()
    {
    }

    public static tj a()
    {
        return a;
    }

    public av a(Context context, tz tz1)
    {
        Object obj = tz1.a();
        String s;
        android.location.Location location;
        android.os.Bundle bundle;
        String s1;
        int i;
        int j;
        long l;
        boolean flag;
        boolean flag1;
        if (obj != null)
        {
            l = ((Date) (obj)).getTime();
        } else
        {
            l = -1L;
        }
        s = tz1.b();
        i = tz1.c();
        obj = tz1.d();
        if (!((Set) (obj)).isEmpty())
        {
            obj = Collections.unmodifiableList(new ArrayList(((java.util.Collection) (obj))));
        } else
        {
            obj = null;
        }
        flag = tz1.a(context);
        j = tz1.k();
        location = tz1.e();
        bundle = tz1.a(oi);
        flag1 = tz1.f();
        s1 = tz1.g();
        context = tz1.h();
        if (context != null)
        {
            context = new bj(context);
        } else
        {
            context = null;
        }
        return new av(4, l, bundle, i, ((java.util.List) (obj)), flag, j, flag1, s1, context, location, s, tz1.j());
    }

}
