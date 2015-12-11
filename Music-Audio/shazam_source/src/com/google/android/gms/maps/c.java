// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.maps.a.b;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.d;

// Referenced classes of package com.google.android.gms.maps:
//            a, f

public final class com.google.android.gms.maps.c
{
    public static interface a
    {

        public abstract void onCancel();

        public abstract void onFinish();
    }

    public static interface b
    {

        public abstract View getInfoContents(com.google.android.gms.maps.model.c c1);

        public abstract View getInfoWindow(com.google.android.gms.maps.model.c c1);
    }

    public static interface c
    {

        public abstract void onCameraChange(CameraPosition cameraposition);
    }

    public static interface d
    {

        public abstract void onInfoWindowClick(com.google.android.gms.maps.model.c c1);
    }

    public static interface e
    {

        public abstract boolean onMarkerClick(com.google.android.gms.maps.model.c c1);
    }

    public static interface f
    {

        public abstract boolean a();
    }

    private static final class g extends com.google.android.gms.maps.a.m.a
    {

        private final a a;

        public final void a()
        {
            a.onFinish();
        }

        public final void b()
        {
            a.onCancel();
        }

        g(a a1)
        {
            a = a1;
        }
    }


    public final com.google.android.gms.maps.a.b a;

    protected com.google.android.gms.maps.c(com.google.android.gms.maps.a.b b1)
    {
        a = (com.google.android.gms.maps.a.b)w.a(b1);
    }

    public final CameraPosition a()
    {
        CameraPosition cameraposition;
        try
        {
            cameraposition = a.a();
        }
        catch (RemoteException remoteexception)
        {
            throw new com.google.android.gms.maps.model.d(remoteexception);
        }
        return cameraposition;
    }

    public final com.google.android.gms.maps.model.c a(MarkerOptions markeroptions)
    {
        try
        {
            markeroptions = a.a(markeroptions);
        }
        // Misplaced declaration of an exception variable
        catch (MarkerOptions markeroptions)
        {
            throw new com.google.android.gms.maps.model.d(markeroptions);
        }
        if (markeroptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        markeroptions = new com.google.android.gms.maps.model.c(markeroptions);
        return markeroptions;
        return null;
    }

    public final void a(com.google.android.gms.maps.a a1, int i, a a2)
    {
        com.google.android.gms.maps.a.b b1;
        com.google.android.gms.b.c c1;
        try
        {
            b1 = a;
            c1 = a1.a;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.maps.a a1)
        {
            throw new com.google.android.gms.maps.model.d(a1);
        }
        if (a2 != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        a1 = null;
        b1.a(c1, i, a1);
        return;
        a1 = new g(a2);
        break MISSING_BLOCK_LABEL_18;
    }

    public final void a(boolean flag)
    {
        try
        {
            a.c(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new com.google.android.gms.maps.model.d(remoteexception);
        }
    }

    public final float b()
    {
        float f1;
        try
        {
            f1 = a.c();
        }
        catch (RemoteException remoteexception)
        {
            throw new com.google.android.gms.maps.model.d(remoteexception);
        }
        return f1;
    }

    public final com.google.android.gms.maps.f c()
    {
        com.google.android.gms.maps.f f1;
        try
        {
            f1 = new com.google.android.gms.maps.f(a.l());
        }
        catch (RemoteException remoteexception)
        {
            throw new com.google.android.gms.maps.model.d(remoteexception);
        }
        return f1;
    }

    // Unreferenced inner class com/google/android/gms/maps/c$1

/* anonymous class */
    public final class _cls1 extends com.google.android.gms.maps.a.x.a
    {

        final e a;
        final com.google.android.gms.maps.c b;

        public final boolean a(com.google.android.gms.maps.model.a.f f1)
        {
            return a.onMarkerClick(new com.google.android.gms.maps.model.c(f1));
        }

            public 
            {
                b = com.google.android.gms.maps.c.this;
                a = e1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/maps/c$2

/* anonymous class */
    public final class _cls2 extends com.google.android.gms.maps.a.r.a
    {

        final d a;
        final com.google.android.gms.maps.c b;

        public final void a(com.google.android.gms.maps.model.a.f f1)
        {
            a.onInfoWindowClick(new com.google.android.gms.maps.model.c(f1));
        }

            public 
            {
                b = com.google.android.gms.maps.c.this;
                a = d1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/maps/c$3

/* anonymous class */
    public final class _cls3 extends com.google.android.gms.maps.a.o.a
    {

        final b a;
        final com.google.android.gms.maps.c b;

        public final com.google.android.gms.b.c a(com.google.android.gms.maps.model.a.f f1)
        {
            return com.google.android.gms.b.d.a(a.getInfoWindow(new com.google.android.gms.maps.model.c(f1)));
        }

        public final com.google.android.gms.b.c b(com.google.android.gms.maps.model.a.f f1)
        {
            return com.google.android.gms.b.d.a(a.getInfoContents(new com.google.android.gms.maps.model.c(f1)));
        }

            public 
            {
                b = com.google.android.gms.maps.c.this;
                a = b1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/maps/c$4

/* anonymous class */
    public final class _cls4 extends com.google.android.gms.maps.a.z.a
    {

        final f a;
        final com.google.android.gms.maps.c b;

        public final boolean a()
        {
            return a.a();
        }

            public 
            {
                b = com.google.android.gms.maps.c.this;
                a = f1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/maps/c$5

/* anonymous class */
    public final class _cls5 extends com.google.android.gms.maps.a.p.a
    {

        final c a;
        final com.google.android.gms.maps.c b;

        public final void a(CameraPosition cameraposition)
        {
            a.onCameraChange(cameraposition);
        }

            public 
            {
                b = com.google.android.gms.maps.c.this;
                a = c2;
                super();
            }
    }

}
