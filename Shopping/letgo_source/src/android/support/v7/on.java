// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.formats.zzj;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            ln, ll, oc, ob

public class on extends ln
{

    public on()
    {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private ob b(Context context, FrameLayout framelayout, FrameLayout framelayout1)
    {
        lk lk = ll.a(context);
        framelayout = ll.a(framelayout);
        framelayout1 = ll.a(framelayout1);
        context = ob.a.zzu(((oc)zzar(context)).a(lk, framelayout, framelayout1, 0x7877d8));
        return context;
        context;
_L2:
        zzb.zzd("Could not create remote NativeAdViewDelegate.", context);
        return null;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ob a(Context context, FrameLayout framelayout, FrameLayout framelayout1)
    {
label0:
        {
            if (zzk.zzcE().zzR(context))
            {
                ob ob = b(context, framelayout, framelayout1);
                context = ob;
                if (ob != null)
                {
                    break label0;
                }
            }
            zzb.zzaC("Using NativeAdViewDelegate from the client jar.");
            context = new zzj(framelayout, framelayout1);
        }
        return context;
    }

    protected oc a(IBinder ibinder)
    {
        return oc.a.a(ibinder);
    }

    protected Object zzd(IBinder ibinder)
    {
        return a(ibinder);
    }
}
