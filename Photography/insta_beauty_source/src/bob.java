// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.telephony.TelephonyManager;
import com.fotoable.comlib.util.AsyncTask;

public class bob extends AsyncTask
{

    private Context a;
    private bry b;

    public bob(Context context, bry bry)
    {
        a = context;
        b = bry;
    }

    protected transient String a(String as[])
    {
        as = ((TelephonyManager)a.getSystemService("phone")).getDeviceId();
        if (as != null)
        {
            try
            {
                boc.a(a, as, "android", b);
            }
            // Misplaced declaration of an exception variable
            catch (String as[]) { }
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }
}
