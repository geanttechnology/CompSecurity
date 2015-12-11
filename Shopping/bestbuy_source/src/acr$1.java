// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.AsyncTask;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class  extends AsyncTask
{

    protected transient Void a(Void avoid[])
    {
        try
        {
            acr.f().a();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            acr.a(true);
            acr.a(null);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            acr.a(null);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            acr.a(null);
        }
        acr.g().countDown();
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    ()
    {
    }
}
