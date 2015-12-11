// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.a.a.c;

// Referenced classes of package com.google.android.a.a.a:
//            b, d, f, r, 
//            w

public final class t
    implements c
{

    public f a;
    private d b;

    public t(d d1, f f1)
    {
        b = (d)com.google.android.a.a.a.b.a(d1, "connectionClient cannot be null");
        a = (f)com.google.android.a.a.a.b.a(f1, "embeddedPlayer cannot be null");
    }

    public final void a()
    {
        a(true);
    }

    public final void a(int i)
    {
        try
        {
            a.d(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new r(remoteexception);
        }
    }

    public final void a(com.google.android.a.a.c.a a1)
    {
        try
        {
            a.a(new g.a(a1) {

                final com.google.android.a.a.c.a a;
                final t b;

                public final void a(boolean flag)
                {
                    a.a(flag);
                }

            
            {
                b = t.this;
                a = a1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.a.a.c.a a1)
        {
            throw new r(a1);
        }
    }

    public final void a(String s)
    {
        try
        {
            a.b(s, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new r(s);
        }
    }

    public final void a(boolean flag)
    {
        try
        {
            a.a(flag);
            b.a(flag);
        }
        catch (RemoteException remoteexception)
        {
            throw new r(remoteexception);
        }
        b.d();
    }

    public final boolean a(int i, KeyEvent keyevent)
    {
        boolean flag;
        try
        {
            flag = a.a(i, keyevent);
        }
        // Misplaced declaration of an exception variable
        catch (KeyEvent keyevent)
        {
            throw new r(keyevent);
        }
        return flag;
    }

    public final boolean a(Bundle bundle)
    {
        boolean flag;
        try
        {
            flag = a.a(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new r(bundle);
        }
        return flag;
    }

    public final void b()
    {
        try
        {
            a.b(false);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new r(remoteexception);
        }
    }

    public final boolean b(int i, KeyEvent keyevent)
    {
        boolean flag;
        try
        {
            flag = a.b(i, keyevent);
        }
        // Misplaced declaration of an exception variable
        catch (KeyEvent keyevent)
        {
            throw new r(keyevent);
        }
        return flag;
    }

    public final View c()
    {
        View view;
        try
        {
            view = (View)w.a(a.s());
        }
        catch (RemoteException remoteexception)
        {
            throw new r(remoteexception);
        }
        return view;
    }

    public final Bundle d()
    {
        Bundle bundle;
        try
        {
            bundle = a.r();
        }
        catch (RemoteException remoteexception)
        {
            throw new r(remoteexception);
        }
        return bundle;
    }
}
