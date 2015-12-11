// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class agj extends sd
{

    private static agj a;

    protected agj()
    {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static aga a(Activity activity, rv rv, WalletFragmentOptions walletfragmentoptions, agd agd)
    {
        int i = pu.a(activity);
        if (i != 0)
        {
            throw new ps(i);
        }
        try
        {
            activity = ((agg)a().a(((android.content.Context) (activity)))).a(sb.a(activity), rv, walletfragmentoptions, agd);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        return activity;
    }

    private static agj a()
    {
        if (a == null)
        {
            a = new agj();
        }
        return a;
    }

    protected Object a(IBinder ibinder)
    {
        return b(ibinder);
    }

    protected agg b(IBinder ibinder)
    {
        return agh.a(ibinder);
    }
}
