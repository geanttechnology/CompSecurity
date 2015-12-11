// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.tasks;

import android.os.AsyncTask;
import com.crashlytics.android.Crashlytics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadWebpageAsyncTask extends AsyncTask
{

    private String urlString;

    public ReadWebpageAsyncTask(String s)
    {
        urlString = s;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        StringBuffer stringbuffer;
        as = new BufferedReader(new InputStreamReader((new URL(urlString)).openStream()));
        stringbuffer = new StringBuffer();
_L1:
        String s = as.readLine();
label0:
        {
            if (s == null)
            {
                break label0;
            }
            try
            {
                stringbuffer.append(s);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Crashlytics.logException(as);
                return null;
            }
        }
          goto _L1
        as.close();
        as = stringbuffer.toString();
        return as;
    }
}
