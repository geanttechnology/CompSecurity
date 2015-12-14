// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.os.AsyncTask;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.livemixtapes:
//            AsyncHttp

private static abstract class json extends AsyncTask
{

    protected final back callback;
    protected final Boolean json;
    protected final Map params;
    protected final String url;

    protected transient abstract ata doInBackground(Void avoid[]);

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected ata getDataResponse(HttpResponse httpresponse)
    {
        ata ata = new ata(null);
        StatusLine statusline = httpresponse.getStatusLine();
        ata.data = readEntity(httpresponse.getEntity());
        ata.reasonPhrase = statusline.getReasonPhrase();
        ata.statusCode = statusline.getStatusCode();
        return ata;
    }

    protected ata getExceptionResponse(Exception exception)
    {
        ata ata = new ata(null);
        ata.exception = exception;
        return ata;
    }

    protected void onPostExecute(ata ata)
    {
        if (callback == null)
        {
            return;
        }
        if (ata.exception != null)
        {
            callback.exception(ata.exception);
        } else
        {
            callback.success(ata.data, ata.reasonPhrase, ata.statusCode);
        }
        callback.always();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ata)obj);
    }

    protected String readEntity(HttpEntity httpentity)
    {
        try
        {
            httpentity = EntityUtils.toString(httpentity);
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            return "";
        }
        return httpentity;
    }

    public back(String s, Map map, back back, Boolean boolean1)
    {
        url = s;
        params = map;
        callback = back;
        json = boolean1;
    }
}
