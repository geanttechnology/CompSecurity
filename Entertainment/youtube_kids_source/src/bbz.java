// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class bbz
{

    private static boolean a = true;
    private static final avt b = new bca();

    public static void a(Context context, Integer integer, Long long1, Integer integer1, Integer integer2, Bundle bundle)
    {
        if (!a)
        {
            return;
        }
        context = (new awj(context)).a(b);
        Object obj = bau.a;
        ((awj) (context)).b.put(obj, null);
        obj = ((awa) (obj)).c;
        int j = ((List) (obj)).size();
        for (int i = 0; i < j; i++)
        {
            ((awj) (context)).a.add(((cm)((List) (obj)).get(i)).d());
        }

        context = context.a();
        context.a();
        bau.b.a(context, integer, long1, integer1, integer2, bundle).a(new bcb(context));
    }

    static boolean a(boolean flag)
    {
        a = false;
        return false;
    }

}
