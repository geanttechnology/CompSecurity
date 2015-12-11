// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.millennialmedia.android:
//            ai, aj, ao

final class p extends ai
    implements android.content.DialogInterface.OnClickListener
{

    private String a;
    private String d;
    private int e;

    p()
    {
        a = "alert";
        d = "vibrate";
    }

    static int a(p p1)
    {
        return p1.e;
    }

    private aj a(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        map = a(new Callable(map) {

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
                            obj1 = (new android.app.AlertDialog.Builder(((Context) (obj1)))).create();
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

            
            {
                b = p.this;
                a = map;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return map;
        map;
        throw map;
    }

    final aj a(String s, Map map)
    {
        String s1 = null;
        if (!a.equals(s)) goto _L2; else goto _L1
_L1:
        s = a(map);
_L6:
        s1 = s;
_L4:
        return s1;
_L2:
        if (!d.equals(s)) goto _L4; else goto _L3
_L3:
        s = (Context)b.get();
        long l;
        if (map.containsKey("duration"))
        {
            l = (long)((double)Float.parseFloat((String)map.get("duration")) * 1000D);
        } else
        {
            l = 0L;
        }
        if (s != null && l > 0L)
        {
            if (s.getPackageManager().checkPermission("android.permission.VIBRATE", s.getPackageName()) == 0)
            {
                ((Vibrator)s.getSystemService("vibrator")).vibrate(l);
                s = aj.a((new StringBuilder("Vibrating for ")).append(l).toString());
            } else
            {
                s = aj.b("The required permissions to vibrate are not set.");
            }
        } else
        {
            s = null;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i != -2)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        e = 0;
        if (i != -3)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        e = 1;
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        e = 2;
        dialoginterface.cancel();
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        dialoginterface;
        throw dialoginterface;
    }
}
