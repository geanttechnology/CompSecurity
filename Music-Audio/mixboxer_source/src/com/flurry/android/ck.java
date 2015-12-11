// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.os.AsyncTask;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

// Referenced classes of package com.flurry.android:
//            FlurryAds, fl, cy, ca

final class ck extends AsyncTask
{

    private FlurryAds du;

    ck(FlurryAds flurryads)
    {
        du = flurryads;
        super();
    }

    private transient Void aw()
    {
        Object obj;
        DataInputStream datainputstream;
        Throwable throwable1;
        boolean flag;
        try
        {
            flag = FlurryAds.d(du).exists();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Throwable) (obj)).printStackTrace();
            return null;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        datainputstream = new DataInputStream(new FileInputStream(FlurryAds.d(du)));
        obj = datainputstream;
        du.a(datainputstream);
        fl.a(datainputstream);
_L5:
        if (FlurryAds.e(du)) goto _L4; else goto _L3
_L3:
        flag = FlurryAds.d(du).delete();
        if (flag);
_L2:
        return null;
        throwable1;
        datainputstream = null;
_L8:
        obj = datainputstream;
        cy.b(FlurryAds.p, "Error when loading persistent freqCap file", throwable1);
        fl.a(datainputstream);
          goto _L5
        Exception exception;
        exception;
        obj = null;
_L7:
        fl.a(((java.io.Closeable) (obj)));
        throw exception;
_L4:
        du.ho.as();
        return null;
        Throwable throwable;
        throwable;
        cy.b(FlurryAds.p, "", throwable);
        return null;
        exception;
        if (true) goto _L7; else goto _L6
_L6:
        throwable1;
          goto _L8
    }

    protected final volatile Object doInBackground(Object aobj[])
    {
        return aw();
    }
}
