// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import java.util.Set;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.google.android.gms.signin.internal:
//            zzf, AuthAccountResult, zze

public class zzi extends zzj
    implements zzqw
{

    private final boolean zzaVl;
    private final ExecutorService zzaVm;
    private final zzqx zzaaT;
    private final zzf zzabI;
    private Integer zzafj;

    public zzi(Context context, Looper looper, boolean flag, zzf zzf1, zzqx zzqx1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, 
            ExecutorService executorservice)
    {
        super(context, looper, 44, zzf1, connectioncallbacks, onconnectionfailedlistener);
        zzaVl = flag;
        zzabI = zzf1;
        zzaaT = zzqx1;
        zzafj = zzf1.zzoR();
        zzaVm = executorservice;
    }

    public static Bundle zza(zzqx zzqx1, Integer integer, ExecutorService executorservice)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzqx1.zzCf());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzqx1.zzlY());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzqx1.zzmb());
        if (zzqx1.zzCg() != null)
        {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper((new zza(zzqx1, executorservice)).asBinder()));
        }
        if (integer != null)
        {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", integer.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", zzqx1.zzCh());
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzqx1.zzma());
        return bundle;
    }

    public void connect()
    {
        zza(new com.google.android.gms.common.internal.zzj.zzf(this));
    }

    public void zzCe()
    {
        try
        {
            ((com.google.android.gms.signin.internal.zzf)zzpc()).zzjq(zzafj.intValue());
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzdO(ibinder);
    }

    public void zza(zzp zzp, Set set, zze zze1)
    {
        zzx.zzb(zze1, "Expecting a valid ISignInCallbacks");
        try
        {
            ((com.google.android.gms.signin.internal.zzf)zzpc()).zza(new AuthAccountRequest(zzp, set), zze1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzp zzp)
        {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
        }
        try
        {
            zze1.zza(new ConnectionResult(8, null), new AuthAccountResult());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Set set)
        {
            Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.", zzp);
        }
    }

    public void zza(zzp zzp, boolean flag)
    {
        try
        {
            ((com.google.android.gms.signin.internal.zzf)zzpc()).zza(zzp, zzafj.intValue(), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzp zzp)
        {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzt zzt1)
    {
        zzx.zzb(zzt1, "Expecting a valid IResolveAccountCallbacks");
        try
        {
            android.accounts.Account account = zzabI.zzoI();
            ((com.google.android.gms.signin.internal.zzf)zzpc()).zza(new ResolveAccountRequest(account, zzafj.intValue()), zzt1);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try
            {
                zzt1.zzb(new ResolveAccountResponse(8));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (zzt zzt1)
            {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.", remoteexception);
            }
            return;
        }
    }

    protected com.google.android.gms.signin.internal.zzf zzdO(IBinder ibinder)
    {
        return zzf.zza.zzdN(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.signin.service.START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public boolean zzlN()
    {
        return zzaVl;
    }

    protected Bundle zzly()
    {
        Bundle bundle = zza(zzaaT, zzabI.zzoR(), zzaVm);
        String s = zzabI.zzoN();
        if (!getContext().getPackageName().equals(s))
        {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", zzabI.zzoN());
        }
        return bundle;
    }

    private class zza extends zzd.zza
    {

        private final ExecutorService zzaVm;
        private final zzqx zzaaT;

        private com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks zzCg()
        {
            return zzaaT.zzCg();
        }

        static com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks zza(zza zza1)
        {
            return zza1.zzCg();
        }

        public void zza(String s, String s1, com.google.android.gms.signin.internal.zzf zzf1)
        {
            class _cls2
                implements Runnable
            {

                final String zzaVo;
                final com.google.android.gms.signin.internal.zzf zzaVp;
                final zza zzaVq;
                final String zzaVr;

                public void run()
                {
                    try
                    {
                        boolean flag = zza.zza(zzaVq).onUploadServerAuthCode(zzaVo, zzaVr);
                        zzaVp.zzaq(flag);
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", remoteexception);
                    }
                }

                _cls2(String s, String s1, com.google.android.gms.signin.internal.zzf zzf1)
                {
                    zzaVq = zza.this;
                    zzaVo = s;
                    zzaVr = s1;
                    zzaVp = zzf1;
                    super();
                }
            }

            zzaVm.submit(new _cls2(s, s1, zzf1));
        }

        public void zza(String s, List list, com.google.android.gms.signin.internal.zzf zzf1)
        {
            class _cls1
                implements Runnable
            {

                final List zzaVn;
                final String zzaVo;
                final com.google.android.gms.signin.internal.zzf zzaVp;
                final zza zzaVq;

                public void run()
                {
                    try
                    {
                        Object obj = zza.zza(zzaVq);
                        Set set = Collections.unmodifiableSet(new HashSet(zzaVn));
                        obj = ((com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks) (obj)).onCheckServerAuthorization(zzaVo, set);
                        obj = new CheckServerAuthResult(((com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult) (obj)).zznD(), ((com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult) (obj)).zznE());
                        zzaVp.zza(((CheckServerAuthResult) (obj)));
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", remoteexception);
                    }
                }

                _cls1(List list, String s, com.google.android.gms.signin.internal.zzf zzf1)
                {
                    zzaVq = zza.this;
                    zzaVn = list;
                    zzaVo = s;
                    zzaVp = zzf1;
                    super();
                }
            }

            zzaVm.submit(new _cls1(list, s, zzf1));
        }

        public zza(zzqx zzqx1, ExecutorService executorservice)
        {
            zzaaT = zzqx1;
            zzaVm = executorservice;
        }
    }

}
