// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import com.fotoable.comlib.util.AsyncTask;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TadvertiseUtil

class  extends AsyncTask
{

    protected transient Boolean doInBackground(Void avoid[])
    {
        try
        {
            avoid = (HttpURLConnection)(new URL("http://fotorus.fotoable.com")).openConnection();
            avoid.setConnectTimeout(999);
            avoid.setRequestMethod("GET");
            avoid.setDoInput(true);
            avoid.connect();
            if (avoid.getResponseCode() == 200)
            {
                return Boolean.valueOf(true);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(false);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    ()
    {
    }
}
