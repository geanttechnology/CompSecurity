// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ajb
    implements akq
{

    private final ViewGroup a;
    private final akj b;
    private View c;

    public ajb(ViewGroup viewgroup, akj akj1)
    {
        b = (akj)ady.a(akj1);
        a = (ViewGroup)ady.a(viewgroup);
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
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
                final ajb b;

                public void a(akd akd)
                {
                    a.a(new aiy(akd));
                }

            
            {
                b = ajb.this;
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
        throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    public void a(Bundle bundle)
    {
        try
        {
            b.a(bundle);
            c = (View)sb.a(b.f());
            a.removeAllViews();
            a.addView(c);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new anl(bundle);
        }
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
        throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }

    public void f()
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

    public void g()
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
}
