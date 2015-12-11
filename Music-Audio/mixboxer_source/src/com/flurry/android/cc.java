// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.android:
//            fp, InstallReceiver, cy, fl

final class cc extends fp
{

    private String ef;
    private InstallReceiver eg;

    cc(InstallReceiver installreceiver, String s)
    {
        eg = installreceiver;
        ef = s;
        super();
    }

    public final void c()
    {
        Object obj;
        Object obj1;
        Object obj3;
        obj1 = null;
        obj3 = null;
        obj = obj1;
        File file = InstallReceiver.a(eg).getParentFile();
        obj = obj1;
        (new StringBuilder()).append("dir is...").append(file.toString()).toString();
        obj = obj1;
        if (file.mkdirs())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        obj = obj1;
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        obj = obj1;
        cy.d("InstallReceiver", (new StringBuilder()).append("Unable to create persistent dir: ").append(file).toString());
        fl.a(null);
        return;
        obj = obj1;
        obj1 = new FileOutputStream(InstallReceiver.a(eg));
        ((FileOutputStream) (obj1)).write(ef.getBytes());
        java.util.Map.Entry entry;
        for (obj = InstallReceiver.h(InstallReceiver.c(InstallReceiver.a(eg))).entrySet().iterator(); ((Iterator) (obj)).hasNext(); (new StringBuilder()).append("entry: ").append((String)entry.getKey()).append("=").append(entry.getValue()).toString())
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

          goto _L1
        Object obj2;
        obj2;
_L5:
        obj = obj1;
        cy.b("InstallReceiver", "", ((Throwable) (obj2)));
        fl.a(((java.io.Closeable) (obj1)));
        return;
_L1:
        fl.a(((java.io.Closeable) (obj1)));
        return;
        obj2;
        obj1 = obj;
        obj = obj2;
_L3:
        fl.a(((java.io.Closeable) (obj1)));
        throw obj;
        obj;
        if (true) goto _L3; else goto _L2
_L2:
        obj2;
        obj1 = obj3;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
