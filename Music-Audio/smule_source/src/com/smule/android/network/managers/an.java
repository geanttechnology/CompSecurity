// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.os.AsyncTask;
import com.smule.android.network.core.v;
import java.io.IOException;

// Referenced classes of package com.smule.android.network.managers:
//            ap, ao, aq

public class an extends AsyncTask
{

    private ao a;

    public an(ao ao1)
    {
        a = ao1;
    }

    protected transient aq a(Void avoid[])
    {
        try
        {
            avoid = ap.a().i();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return null;
        }
        return avoid;
    }

    protected void a(aq aq1)
    {
        if (a != null)
        {
            a.a(aq1);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((aq)obj);
    }
}
