// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ajf
    implements akq
{

    private final Fragment a;
    private final akg b;

    public ajf(Fragment fragment, akg akg1)
    {
        b = (akg)ady.a(akg1);
        a = (Fragment)ady.a(fragment);
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        try
        {
            layoutinflater = b.a(sb.a(layoutinflater), sb.a(viewgroup), bundle);
        }
        // Misplaced declaration of an exception variable
        catch (LayoutInflater layoutinflater)
        {
            throw new anl(layoutinflater);
        }
        return (View)sb.a(layoutinflater);
    }

    public void a()
    {
    }

    public void a(aix aix)
    {
        try
        {
            b.a(new amz(aix) {

                final aix a;
                final ajf b;

                public void a(akd akd)
                {
                    a.a(new aiy(akd));
                }

            
            {
                b = ajf.this;
                a = aix1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aix aix)
        {
            throw new anl(aix);
        }
    }

    public void a(Activity activity, Bundle bundle, Bundle bundle1)
    {
        try
        {
            b.a(sb.a(activity), null, bundle1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new anl(activity);
        }
    }

    public void a(Bundle bundle)
    {
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        bundle1 = new Bundle();
        bundle = a.getArguments();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (bundle.containsKey("StreetViewPanoramaOptions"))
        {
            ane.a(bundle1, "StreetViewPanoramaOptions", bundle.getParcelable("StreetViewPanoramaOptions"));
        }
        b.a(bundle1);
        return;
        bundle;
        throw new anl(bundle);
    }

    public void b()
    {
        try
        {
            b.b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
    }

    public void b(Bundle bundle)
    {
        try
        {
            b.b(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new anl(bundle);
        }
    }

    public void c()
    {
        try
        {
            b.c();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
    }

    public void d()
    {
    }

    public void e()
    {
        try
        {
            b.d();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
    }

    public void f()
    {
        try
        {
            b.e();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
    }

    public void g()
    {
        try
        {
            b.f();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
    }
}
