// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gs;

public final class th extends sd
{

    private static final th a = new th();

    private th()
    {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static tq a(Context context, ay ay, String s, wc wc)
    {
        Object obj;
label0:
        {
            if (pu.a(context) == 0)
            {
                tq tq = a.b(context, ay, s, wc);
                obj = tq;
                if (tq != null)
                {
                    break label0;
                }
            }
            acb.a("Using AdManager from the client jar.");
            obj = new ahi(context, ay, s, wc, new gs(0x648278, 0x648278, true));
        }
        return ((tq) (obj));
    }

    private tq b(Context context, ay ay, String s, wc wc)
    {
        try
        {
            ry ry = sb.a(context);
            context = tr.a(((tt)a(context)).a(ry, ay, s, wc, 0x648278));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            acb.d("Could not create remote AdManager.", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            acb.d("Could not create remote AdManager.", context);
            return null;
        }
        return context;
    }

    protected Object a(IBinder ibinder)
    {
        return b(ibinder);
    }

    protected tt b(IBinder ibinder)
    {
        return tu.a(ibinder);
    }

}
