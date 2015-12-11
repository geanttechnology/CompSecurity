// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.os.Environment;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

// Referenced classes of package com.amazon.device.ads:
//            dn, bc, bm, bn, 
//            bl, cz, cn, ds, 
//            av, bg, ax, di

final class cm
{

    private static cm n = new cm(dn.a(), bc.a());
    av a;
    bg b;
    cz c;
    di d;
    boolean e;
    int f;
    long g;
    boolean h;
    File i;
    protected Context j;
    final bc k;
    private boolean l;
    private final dn m;

    private cm(dn dn1, bc bc1)
    {
        boolean flag;
        flag = false;
        super();
        h = false;
        m = dn1;
        k = bc1;
        bc1 = k;
        if (!"mounted".equals(Environment.getExternalStorageState())) goto _L2; else goto _L1
_L1:
        bn bn1;
        dn1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/com.amazon.device.ads.debug").toString();
        bn1 = bc1.a.a(dn1);
        if (!bn1.b()) goto _L2; else goto _L3
_L3:
        if (!bn1.a())
        {
            throw new IllegalStateException("A file has not been set, yet.");
        }
        if (((bl) (bn1)).a.length() <= 0x7fffffffL) goto _L4; else goto _L2
_L2:
        c = new cz();
        return;
_L4:
        if (bn1.c != null)
        {
            flag = true;
        }
        if (!flag && !bn1.f())
        {
            bn1.b.d("Could not open the file for reading", null);
            dn1 = null;
        } else
        {
            dn1 = bn1.g();
            bn1.close();
        }
        if (dn1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        dn1 = bc1.a(dn1);
        if (dn1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        dn1 = new ByteArrayInputStream(dn1);
        bc1.b.clear();
        bc1.b.load(dn1);
        try
        {
            dn1.close();
        }
        // Misplaced declaration of an exception variable
        catch (dn dn1)
        {
            bc1.d.b("Exception closing input stream.", null);
        }
_L6:
        if (Boolean.valueOf(bc1.b.getProperty("debug.mode", "false")).booleanValue())
        {
            bc1.c = true;
        }
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        bc1.d.b("Exception loading debug properties. %s", new Object[] {
            ((IOException) (obj)).getMessage()
        });
        try
        {
            dn1.close();
        }
        // Misplaced declaration of an exception variable
        catch (dn dn1)
        {
            bc1.d.b("Exception closing input stream.", null);
        }
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        try
        {
            dn1.close();
        }
        // Misplaced declaration of an exception variable
        catch (dn dn1)
        {
            bc1.d.b("Exception closing input stream.", null);
        }
        throw obj;
        if (true) goto _L2; else goto _L7
_L7:
    }

    public static cm a()
    {
        return n;
    }

    public final void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        dn dn1;
        if (l)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        l = true;
        j = context.getApplicationContext();
        i = context.getFilesDir();
        dn1 = m;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        ds.a(new dn._cls1(dn1, context));
        a = new av(context);
        b = new bg(context, new ax());
        d = new di();
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public final Context b()
    {
        return j;
    }

}
