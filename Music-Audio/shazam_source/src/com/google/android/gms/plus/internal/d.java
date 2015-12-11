// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.a.a;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.internal:
//            PlusCommonExtras, PlusSession, c, a

public final class d extends l
{
    public static final class a extends com.google.android.gms.plus.internal.a
    {

        private final com.google.android.gms.common.api.k.b a;

        public final void a(int i, Bundle bundle)
        {
            if (bundle != null)
            {
                bundle = (PendingIntent)bundle.getParcelable("pendingIntent");
            } else
            {
                bundle = null;
            }
            bundle = new Status(i, null, bundle);
            a.a(bundle);
        }

        public a(com.google.android.gms.common.api.k.b b1)
        {
            a = b1;
        }
    }


    public com.google.android.gms.plus.a.a.a a;
    private final PlusSession g;

    public d(Context context, Looper looper, h h1, PlusSession plussession, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1)
    {
        super(context, looper, 2, h1, b1, c1);
        g = plussession;
    }

    private Bundle q()
    {
        Object obj = g;
        Bundle bundle = new Bundle();
        bundle.setClassLoader(com/google/android/gms/plus/internal/PlusCommonExtras.getClassLoader());
        PlusCommonExtras pluscommonextras = ((PlusSession) (obj)).j;
        obj = Parcel.obtain();
        pluscommonextras.writeToParcel(((Parcel) (obj)), 0);
        byte abyte0[] = ((Parcel) (obj)).marshall();
        ((Parcel) (obj)).recycle();
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", abyte0);
        bundle.putStringArray("request_visible_actions", g.d);
        bundle.putString("auth_package", g.f);
        return bundle;
    }

    protected final IInterface a(IBinder ibinder)
    {
        return com.google.android.gms.plus.internal.c.a.a(ibinder);
    }

    protected final String a()
    {
        return "com.google.android.gms.plus.service.START";
    }

    protected final void a(int i, IBinder ibinder, Bundle bundle, int j)
    {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person"))
        {
            a = PersonEntity.a(bundle.getByteArray("loaded_person"));
        }
        super.a(i, ibinder, bundle, j);
    }

    protected final String b()
    {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public final String c()
    {
        l();
        String s;
        try
        {
            s = ((c)m()).a();
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return s;
    }

    public final boolean f()
    {
        Object obj = super.c;
        Object obj1 = com.google.android.gms.plus.d.c;
        obj1 = (com.google.android.gms.common.internal.h.a)((h) (obj)).d.get(obj1);
        if (obj1 == null || ((com.google.android.gms.common.internal.h.a) (obj1)).a.isEmpty())
        {
            obj = ((h) (obj)).b;
        } else
        {
            obj = new HashSet(((h) (obj)).b);
            ((Set) (obj)).addAll(((com.google.android.gms.common.internal.h.a) (obj1)).a);
        }
        if (obj == null || ((Set) (obj)).isEmpty())
        {
            return false;
        }
        return ((Set) (obj)).size() != 1 || !((Set) (obj)).contains(new Scope("plus_one_placeholder_scope"));
    }

    protected final Bundle k()
    {
        return q();
    }

    protected final Bundle n()
    {
        return q();
    }

    public final void p()
    {
        l();
        try
        {
            a = null;
            ((c)m()).b();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
    }
}
