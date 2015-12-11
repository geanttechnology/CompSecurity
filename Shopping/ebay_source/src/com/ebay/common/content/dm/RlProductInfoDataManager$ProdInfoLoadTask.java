// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidParameterException;

// Referenced classes of package com.ebay.common.content.dm:
//            RlProductInfoDataManager

public final class param extends AsyncTask
{

    private onPostExecute param;
    final RlProductInfoDataManager this$0;

    protected transient param doInBackground(param aparam[])
    {
        Object obj = null;
        if (isCancelled())
        {
            return null;
        }
        if (aparam.length != 1 || aparam[0] == null)
        {
            throw new InvalidParameterException("ProdInfoLoadTask expects a single param");
        }
        param = aparam[0];
        try
        {
            aparam = new equest(param.e, param.code, param.codeType);
            aparam = ((esponse)com.ebay.nautilus.kernel.net.ponse(getEbayContext(), aparam)).getRlProductInfo();
        }
        // Misplaced declaration of an exception variable
        catch (param aparam[])
        {
            aparam.printStackTrace();
            aparam = obj;
        }
        // Misplaced declaration of an exception variable
        catch (param aparam[])
        {
            aparam.tackTrace();
            aparam = obj;
        }
        // Misplaced declaration of an exception variable
        catch (param aparam[])
        {
            aparam.StackTrace();
            aparam = obj;
        }
        // Misplaced declaration of an exception variable
        catch (param aparam[])
        {
            aparam.printStackTrace();
            aparam = obj;
        }
        // Misplaced declaration of an exception variable
        catch (param aparam[])
        {
            aparam.printStackTrace();
            aparam = obj;
        }
        return aparam;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((doInBackground[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        RlProductInfoDataManager.access$000(RlProductInfoDataManager.this, param, null);
    }

    protected void onPostExecute(param param1)
    {
        super.onPostExecute(param1);
        RlProductInfoDataManager.access$000(RlProductInfoDataManager.this, param, param1);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((onPostExecute)obj);
    }

    public esponse()
    {
        this$0 = RlProductInfoDataManager.this;
        super();
        param = null;
    }
}
