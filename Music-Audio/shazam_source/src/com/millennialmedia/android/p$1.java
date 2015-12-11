// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            p, ao, aj

final class a
    implements Callable
{

    final Map a;
    final p b;

    public final Object call()
    {
        Object obj = (ao)b.c.get();
        if (obj != null)
        {
            Object obj1 = ((ao) (obj)).g();
            obj = a;
            if (obj1 != null)
            {
                if (!((Activity) (obj1)).isFinishing())
                {
                    obj1 = (new android.app.tDialog.Builder(((android.content.Context) (obj1)))).create();
                    if (((Map) (obj)).containsKey("title"))
                    {
                        ((AlertDialog) (obj1)).setTitle((CharSequence)((Map) (obj)).get("title"));
                    }
                    if (((Map) (obj)).containsKey("message"))
                    {
                        ((AlertDialog) (obj1)).setMessage((CharSequence)((Map) (obj)).get("message"));
                    }
                    if (((Map) (obj)).containsKey("cancelButton"))
                    {
                        ((AlertDialog) (obj1)).setButton(-2, (CharSequence)((Map) (obj)).get("cancelButton"), b);
                    }
                    if (((Map) (obj)).containsKey("buttons"))
                    {
                        String as[] = ((String)((Map) (obj)).get("buttons")).split(",");
                        if (as.length > 0)
                        {
                            ((AlertDialog) (obj1)).setButton(-3, as[0], b);
                        }
                        if (as.length > 1)
                        {
                            ((AlertDialog) (obj1)).setButton(-1, as[1], b);
                        }
                    }
                    ((AlertDialog) (obj1)).show();
                }
                as = new aj();
                as.c = 1;
                as.d = Integer.valueOf(p.a(b));
                return as;
            }
        }
        return null;
    }

    (p p1, Map map)
    {
        b = p1;
        a = map;
        super();
    }
}
