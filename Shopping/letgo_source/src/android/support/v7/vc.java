// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;

// Referenced classes of package android.support.v7:
//            uz

public class vc extends l
{

    public vc(Context context, Looper looper, h h, com.google.android.gms.common.api.c.b b, com.google.android.gms.common.api.c.c c)
    {
        super(context, looper, 19, h, b, c);
    }

    public uz a()
        throws DeadObjectException
    {
        return (uz)zzoA();
    }

    protected uz a(IBinder ibinder)
    {
        return uz.a.a(ibinder);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return a(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }
}
