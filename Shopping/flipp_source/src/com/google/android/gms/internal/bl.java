// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.a.a.b;
import com.google.a.a.h;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            bo, et, bw, bq

public final class bl extends bo
{

    Map a;

    public bl()
    {
    }

    private bq b(String s)
    {
        Object obj;
        try
        {
            obj = Class.forName(s, false, com/google/android/gms/internal/bl.getClassLoader());
            if (!com/google/a/a/b.isAssignableFrom(((Class) (obj))))
            {
                et.d((new StringBuilder("Could not instantiate mediation adapter: ")).append(s).append(".").toString());
                throw new RemoteException();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            et.d((new StringBuilder("Could not instantiate mediation adapter: ")).append(s).append(". ").append(((Throwable) (obj)).getMessage()).toString());
            throw new RemoteException();
        }
        obj = (b)((Class) (obj)).newInstance();
        obj = new bw(((b) (obj)), (h)a.get(((b) (obj)).a()));
        return ((bq) (obj));
    }

    public final bq a(String s)
    {
        return b(s);
    }
}
