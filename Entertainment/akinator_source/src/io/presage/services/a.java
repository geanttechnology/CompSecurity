// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services;

import android.os.AsyncTask;
import io.presage.services.for.j;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package io.presage.services:
//            AbstractPresageService

final class a extends AsyncTask
{

    final AbstractPresageService a;

    a(AbstractPresageService abstractpresageservice)
    {
        a = abstractpresageservice;
        super();
    }

    protected final Object doInBackground(Object aobj[])
    {
        j j1;
        for (aobj = AbstractPresageService.a(a).values().iterator(); ((Iterator) (aobj)).hasNext() && !isCancelled(); j1.b())
        {
            j1 = (j)((Iterator) (aobj)).next();
            j1.h();
        }

        return null;
    }
}
