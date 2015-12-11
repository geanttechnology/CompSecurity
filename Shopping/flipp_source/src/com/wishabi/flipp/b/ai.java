// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.wishabi.flipp.b:
//            ah, ag

final class ai extends AsyncTask
{

    final Location a;
    final ah b;

    ai(ah ah1, Location location)
    {
        b = ah1;
        a = location;
        super();
    }

    private transient String a()
    {
        Object obj = b.a.getFromLocation(a.getLatitude(), a.getLongitude(), 1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (((List) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_114;
        }
        String s = ((Address)((List) (obj)).get(0)).getPostalCode();
        if (s == null)
        {
            return null;
        }
        obj = s;
        if (s.length() != 3)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj = s;
        if (!Character.isLetter(s.charAt(0)))
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj = (new StringBuilder()).append(s).append(" 1A1").toString();
        return ((String) (obj));
        obj;
_L2:
        return null;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj = null;
        return ((String) (obj));
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (String)obj;
        b.b.a(((String) (obj)));
    }
}
