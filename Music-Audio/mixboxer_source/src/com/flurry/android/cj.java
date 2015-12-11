// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.os.AsyncTask;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            FlurryAds, cg, fl, cy

final class cj extends AsyncTask
{

    private FlurryAds du;

    cj(FlurryAds flurryads)
    {
        du = flurryads;
        super();
    }

    private transient Void aw()
    {
        Object obj;
        Object obj1;
        List list;
        Throwable throwable1;
        List list1;
        Exception exception;
        boolean flag;
        try
        {
            flag = FlurryAds.a(du).exists();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Throwable) (obj)).printStackTrace();
            return null;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        obj1 = new DataInputStream(new FileInputStream(FlurryAds.a(du)));
        obj = obj1;
        list1 = cg.a(((java.io.DataInput) (obj1)));
        obj = obj1;
        list = du.hv;
        obj = obj1;
        list;
        JVM INSTR monitorenter ;
        du.hv.addAll(list1);
        list;
        JVM INSTR monitorexit ;
        obj = obj1;
        FlurryAds.b(du);
        fl.a(((java.io.Closeable) (obj1)));
_L4:
        if (FlurryAds.c(du)) goto _L2; else goto _L3
_L3:
        flag = FlurryAds.a(du).delete();
        if (flag);
_L2:
        return null;
        exception;
        list;
        JVM INSTR monitorexit ;
        obj = obj1;
        throw exception;
        throwable1;
_L7:
        obj = obj1;
        cy.b(FlurryAds.p, "Error when loading ad log data: ", throwable1);
        fl.a(((java.io.Closeable) (obj1)));
          goto _L4
        obj1;
        obj = null;
_L6:
        fl.a(((java.io.Closeable) (obj)));
        throw obj1;
        Throwable throwable;
        throwable;
        cy.b(FlurryAds.p, "", throwable);
        return null;
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        throwable1;
        obj1 = null;
          goto _L7
    }

    protected final volatile Object doInBackground(Object aobj[])
    {
        return aw();
    }
}
