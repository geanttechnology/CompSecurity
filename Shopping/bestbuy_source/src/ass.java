// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class ass
    implements rr
{

    private final aga a;

    private ass(aga aga1)
    {
        a = aga1;
    }

    ass(aga aga1, com.google.android.gms.wallet.fragment.SupportWalletFragment._cls1 _pcls1)
    {
        this(aga1);
    }

    private void a(int i, int j, Intent intent)
    {
        try
        {
            a.a(i, j, intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            throw new RuntimeException(intent);
        }
    }

    public static void a(ass ass1, int i, int j, Intent intent)
    {
        ass1.a(i, j, intent);
    }

    static void a(ass ass1, MaskedWallet maskedwallet)
    {
        ass1.a(maskedwallet);
    }

    static void a(ass ass1, MaskedWalletRequest maskedwalletrequest)
    {
        ass1.a(maskedwalletrequest);
    }

    static void a(ass ass1, WalletFragmentInitParams walletfragmentinitparams)
    {
        ass1.a(walletfragmentinitparams);
    }

    static void a(ass ass1, boolean flag)
    {
        ass1.a(flag);
    }

    private void a(MaskedWallet maskedwallet)
    {
        try
        {
            a.a(maskedwallet);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MaskedWallet maskedwallet)
        {
            throw new RuntimeException(maskedwallet);
        }
    }

    private void a(MaskedWalletRequest maskedwalletrequest)
    {
        try
        {
            a.a(maskedwalletrequest);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MaskedWalletRequest maskedwalletrequest)
        {
            throw new RuntimeException(maskedwalletrequest);
        }
    }

    private void a(WalletFragmentInitParams walletfragmentinitparams)
    {
        try
        {
            a.a(walletfragmentinitparams);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WalletFragmentInitParams walletfragmentinitparams)
        {
            throw new RuntimeException(walletfragmentinitparams);
        }
    }

    private void a(boolean flag)
    {
        try
        {
            a.a(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        try
        {
            layoutinflater = (View)sb.a(a.a(sb.a(layoutinflater), sb.a(viewgroup), bundle));
        }
        // Misplaced declaration of an exception variable
        catch (LayoutInflater layoutinflater)
        {
            throw new RuntimeException(layoutinflater);
        }
        return layoutinflater;
    }

    public void a()
    {
        try
        {
            a.a();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
    }

    public void a(Activity activity, Bundle bundle, Bundle bundle1)
    {
        bundle = (WalletFragmentOptions)bundle.getParcelable("extraWalletFragmentOptions");
        try
        {
            a.a(sb.a(activity), bundle, bundle1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
    }

    public void a(Bundle bundle)
    {
        try
        {
            a.a(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new RuntimeException(bundle);
        }
    }

    public void b()
    {
        try
        {
            a.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
    }

    public void b(Bundle bundle)
    {
        try
        {
            a.b(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new RuntimeException(bundle);
        }
    }

    public void c()
    {
        try
        {
            a.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
    }

    public void d()
    {
        try
        {
            a.d();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
    }

    public void e()
    {
    }

    public void f()
    {
    }

    public void g()
    {
    }
}
