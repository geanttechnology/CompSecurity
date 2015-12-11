// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.internal:
//            zzlj, zzqw, zzli, zzlk

public class zzlg
    implements zzlj
{

    private final Context mContext;
    private final GoogleApiAvailability zzaaP;
    private final com.google.android.gms.common.api.Api.zza zzaaQ;
    private final Set zzabA = new HashSet();
    private zzqw zzabB;
    private int zzabC;
    private boolean zzabD;
    private boolean zzabE;
    private zzp zzabF;
    private boolean zzabG;
    private boolean zzabH;
    private final com.google.android.gms.common.internal.zzf zzabI;
    private final Map zzabJ;
    private ArrayList zzabK;
    private final zzli zzabr;
    private final Lock zzabt;
    private ConnectionResult zzabu;
    private int zzabv;
    private int zzabw;
    private boolean zzabx;
    private int zzaby;
    private final Bundle zzabz = new Bundle();

    public zzlg(zzli zzli1, zzf zzf1, Map map, GoogleApiAvailability googleapiavailability, com.google.android.gms.common.api.Api.zza zza1, Lock lock, Context context)
    {
        zzabw = 0;
        zzabx = false;
        zzabK = new ArrayList();
        zzabr = zzli1;
        zzabI = zzf1;
        zzabJ = map;
        zzaaP = googleapiavailability;
        zzaaQ = zza1;
        zzabt = lock;
        mContext = context;
    }

    private void zzY(boolean flag)
    {
        if (zzabB != null)
        {
            if (zzabB.isConnected() && flag)
            {
                zzabB.zzCe();
            }
            zzabB.disconnect();
            zzabF = null;
        }
    }

    static Context zza(zzlg zzlg1)
    {
        return zzlg1.mContext;
    }

    private void zza(ResolveAccountResponse resolveaccountresponse)
    {
        if (!zzbn(0))
        {
            return;
        }
        ConnectionResult connectionresult = resolveaccountresponse.zzpr();
        if (connectionresult.isSuccess())
        {
            zzabF = resolveaccountresponse.zzpq();
            zzabE = true;
            zzabG = resolveaccountresponse.zzps();
            zzabH = resolveaccountresponse.zzpt();
            zznQ();
            return;
        }
        if (zze(connectionresult))
        {
            zznV();
            zznQ();
            return;
        } else
        {
            zzf(connectionresult);
            return;
        }
    }

    static void zza(zzlg zzlg1, ConnectionResult connectionresult)
    {
        zzlg1.zzf(connectionresult);
    }

    static void zza(zzlg zzlg1, ConnectionResult connectionresult, Api api, int i)
    {
        zzlg1.zzb(connectionresult, api, i);
    }

    static void zza(zzlg zzlg1, ResolveAccountResponse resolveaccountresponse)
    {
        zzlg1.zza(resolveaccountresponse);
    }

    private boolean zza(int i, int j, ConnectionResult connectionresult)
    {
        while (j == 1 && !zzd(connectionresult) || zzabu != null && i >= zzabv) 
        {
            return false;
        }
        return true;
    }

    static boolean zza(zzlg zzlg1, int i)
    {
        return zzlg1.zzbn(i);
    }

    static GoogleApiAvailability zzb(zzlg zzlg1)
    {
        return zzlg1.zzaaP;
    }

    private void zzb(ConnectionResult connectionresult, Api api, int i)
    {
        if (i != 2)
        {
            int j = api.zznv().getPriority();
            if (zza(j, i, connectionresult))
            {
                zzabu = connectionresult;
                zzabv = j;
            }
        }
        zzabr.zzach.put(api.zznx(), connectionresult);
    }

    static boolean zzb(zzlg zzlg1, ConnectionResult connectionresult)
    {
        return zzlg1.zze(connectionresult);
    }

    private boolean zzbn(int i)
    {
        if (zzabw != i)
        {
            Log.i("GoogleApiClientConnecting", zzabr.zzog());
            Log.wtf("GoogleApiClientConnecting", (new StringBuilder("GoogleApiClient connecting is in step ")).append(zzbo(zzabw)).append(" but received callback for step ").append(zzbo(i)).toString(), new Exception());
            zzf(new ConnectionResult(8, null));
            return false;
        } else
        {
            return true;
        }
    }

    private String zzbo(int i)
    {
        switch (i)
        {
        default:
            return "UNKNOWN";

        case 0: // '\0'
            return "STEP_GETTING_SERVICE_BINDINGS";

        case 1: // '\001'
            return "STEP_VALIDATING_ACCOUNT";

        case 2: // '\002'
            return "STEP_AUTHENTICATING";

        case 3: // '\003'
            return "STEP_GETTING_REMOTE_SERVICE";
        }
    }

    static Lock zzc(zzlg zzlg1)
    {
        return zzlg1.zzabt;
    }

    private void zzc(ConnectionResult connectionresult)
    {
        if (!zzbn(2))
        {
            return;
        }
        if (connectionresult.isSuccess())
        {
            zznT();
            return;
        }
        if (zze(connectionresult))
        {
            zznV();
            zznT();
            return;
        } else
        {
            zzf(connectionresult);
            return;
        }
    }

    static void zzc(zzlg zzlg1, ConnectionResult connectionresult)
    {
        zzlg1.zzc(connectionresult);
    }

    static zzli zzd(zzlg zzlg1)
    {
        return zzlg1.zzabr;
    }

    private boolean zzd(ConnectionResult connectionresult)
    {
        while (connectionresult.hasResolution() || zzaaP.zzbi(connectionresult.getErrorCode()) != null) 
        {
            return true;
        }
        return false;
    }

    private boolean zze(ConnectionResult connectionresult)
    {
        return zzabC == 2 || zzabC == 1 && !connectionresult.hasResolution();
    }

    static boolean zze(zzlg zzlg1)
    {
        return zzlg1.zzabD;
    }

    static zzqw zzf(zzlg zzlg1)
    {
        return zzlg1.zzabB;
    }

    private void zzf(ConnectionResult connectionresult)
    {
        zznW();
        boolean flag;
        if (!connectionresult.hasResolution())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzY(flag);
        zzabr.zzach.clear();
        zzabr.zzg(connectionresult);
        if (!zzaaP.zzd(mContext, connectionresult.getErrorCode()))
        {
            zzabr.zzof();
        }
        if (!zzabx && !zzabr.zzoc())
        {
            zzabr.zzabZ.zzi(connectionresult);
        }
        zzabx = false;
        zzabr.zzabZ.zzpk();
    }

    static zzp zzg(zzlg zzlg1)
    {
        return zzlg1.zzabF;
    }

    static Set zzh(zzlg zzlg1)
    {
        return zzlg1.zznX();
    }

    static void zzi(zzlg zzlg1)
    {
        zzlg1.zznV();
    }

    static void zzj(zzlg zzlg1)
    {
        zzlg1.zznT();
    }

    static boolean zzk(zzlg zzlg1)
    {
        return zzlg1.zznP();
    }

    static void zzl(zzlg zzlg1)
    {
        zzlg1.zznQ();
    }

    static void zzm(zzlg zzlg1)
    {
        zzlg1.zznS();
    }

    private boolean zznP()
    {
        zzaby = zzaby - 1;
        if (zzaby > 0)
        {
            return false;
        }
        if (zzaby < 0)
        {
            Log.i("GoogleApiClientConnecting", zzabr.zzog());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzf(new ConnectionResult(8, null));
            return false;
        }
        if (zzabu != null)
        {
            zzf(zzabu);
            return false;
        } else
        {
            return true;
        }
    }

    private void zznQ()
    {
        if (zzaby == 0)
        {
            if (zzabD)
            {
                if (zzabE)
                {
                    zznR();
                    return;
                }
            } else
            {
                zznT();
                return;
            }
        }
    }

    private void zznR()
    {
        ArrayList arraylist = new ArrayList();
        zzabw = 1;
        zzaby = zzabr.zzacg.size();
        Iterator iterator = zzabr.zzacg.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.Api.zzc zzc1 = (com.google.android.gms.common.api.Api.zzc)iterator.next();
            if (zzabr.zzach.containsKey(zzc1))
            {
                if (zznP())
                {
                    zznS();
                }
            } else
            {
                arraylist.add(zzabr.zzacg.get(zzc1));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            zzabK.add(zzlk.zzoj().submit(new zzh(arraylist)));
        }
    }

    private void zznS()
    {
        zzabw = 2;
        zzabr.zzaci = zznX();
        zzabK.add(zzlk.zzoj().submit(new zzc(null)));
    }

    private void zznT()
    {
        ArrayList arraylist = new ArrayList();
        zzabw = 3;
        zzaby = zzabr.zzacg.size();
        Iterator iterator = zzabr.zzacg.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.Api.zzc zzc1 = (com.google.android.gms.common.api.Api.zzc)iterator.next();
            if (zzabr.zzach.containsKey(zzc1))
            {
                if (zznP())
                {
                    zznU();
                }
            } else
            {
                arraylist.add(zzabr.zzacg.get(zzc1));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            zzabK.add(zzlk.zzoj().submit(new zzf(arraylist)));
        }
    }

    private void zznU()
    {
        zzabr.zzob();
        zzlk.zzoj().execute(new _cls1());
        if (zzabB != null)
        {
            if (zzabG)
            {
                zzabB.zza(zzabF, zzabH);
            }
            zzY(false);
        }
        com.google.android.gms.common.api.Api.zzc zzc1;
        for (Iterator iterator = zzabr.zzach.keySet().iterator(); iterator.hasNext(); ((com.google.android.gms.common.api.Api.zzb)zzabr.zzacg.get(zzc1)).disconnect())
        {
            zzc1 = (com.google.android.gms.common.api.Api.zzc)iterator.next();
        }

        if (zzabx)
        {
            zzabx = false;
            disconnect();
            return;
        }
        Bundle bundle;
        if (zzabz.isEmpty())
        {
            bundle = null;
        } else
        {
            bundle = zzabz;
        }
        zzabr.zzabZ.zzh(bundle);
    }

    private void zznV()
    {
        zzabD = false;
        zzabr.zzaci = Collections.emptySet();
        Iterator iterator = zzabA.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.Api.zzc zzc1 = (com.google.android.gms.common.api.Api.zzc)iterator.next();
            if (!zzabr.zzach.containsKey(zzc1))
            {
                zzabr.zzach.put(zzc1, new ConnectionResult(17, null));
            }
        } while (true);
    }

    private void zznW()
    {
        for (Iterator iterator = zzabK.iterator(); iterator.hasNext(); ((Future)iterator.next()).cancel(true)) { }
        zzabK.clear();
    }

    private Set zznX()
    {
        HashSet hashset = new HashSet(zzabI.zzoK());
        Map map = zzabI.zzoM();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Api api = (Api)iterator.next();
            if (!zzabr.zzach.containsKey(api.zznx()))
            {
                hashset.addAll(((com.google.android.gms.common.internal.zzf.zza)map.get(api)).zzTm);
            }
        } while (true);
        return hashset;
    }

    public void begin()
    {
        zzabr.zzabZ.zzpl();
        zzabr.zzach.clear();
        zzabx = false;
        zzabD = false;
        zzabu = null;
        zzabw = 0;
        zzabC = 2;
        zzabE = false;
        zzabG = false;
        HashMap hashmap = new HashMap();
        Iterator iterator = zzabJ.keySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            Api api = (Api)iterator.next();
            com.google.android.gms.common.api.Api.zzb zzb1 = (com.google.android.gms.common.api.Api.zzb)zzabr.zzacg.get(api.zznx());
            int i = ((Integer)zzabJ.get(api)).intValue();
            boolean flag1;
            if (api.zznv().getPriority() == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (zzb1.zzlN())
            {
                zzabD = true;
                if (i < zzabC)
                {
                    zzabC = i;
                }
                if (i != 0)
                {
                    zzabA.add(api.zznx());
                }
            }
            hashmap.put(zzb1, new zzd(api, i));
            flag = flag1 | flag;
        }
        if (flag)
        {
            zzabD = false;
        }
        if (zzabD)
        {
            zzabI.zza(Integer.valueOf(zzabr.getSessionId()));
            zzg zzg1 = new zzg(null);
            zzabB = (zzqw)zzaaQ.zza(mContext, zzabr.getLooper(), zzabI, zzabI.zzoQ(), zzg1, zzg1);
        }
        zzaby = zzabr.zzacg.size();
        zzabK.add(zzlk.zzoj().submit(new zze(hashmap)));
    }

    public void connect()
    {
        zzabx = false;
    }

    public void disconnect()
    {
        Iterator iterator = zzabr.zzaca.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            zzli.zzf zzf1 = (zzli.zzf)iterator.next();
            if (zzf1.zznK() != 1)
            {
                zzf1.cancel();
                iterator.remove();
            }
        } while (true);
        zzabr.zznY();
        if (zzabu == null && !zzabr.zzaca.isEmpty())
        {
            zzabx = true;
            return;
        } else
        {
            zznW();
            zzY(true);
            zzabr.zzach.clear();
            zzabr.zzg(null);
            zzabr.zzabZ.zzpk();
            return;
        }
    }

    public String getName()
    {
        return "CONNECTING";
    }

    public void onConnected(Bundle bundle)
    {
        if (zzbn(3))
        {
            if (bundle != null)
            {
                zzabz.putAll(bundle);
            }
            if (zznP())
            {
                zznU();
                return;
            }
        }
    }

    public void onConnectionSuspended(int i)
    {
        zzf(new ConnectionResult(8, null));
    }

    public zzlb.zza zza(zzlb.zza zza1)
    {
        zzabr.zzaca.add(zza1);
        return zza1;
    }

    public void zza(ConnectionResult connectionresult, Api api, int i)
    {
        if (zzbn(3))
        {
            zzb(connectionresult, api, i);
            if (zznP())
            {
                zznU();
                return;
            }
        }
    }

    public zzlb.zza zzb(zzlb.zza zza1)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    private class zzh extends zzi
    {
        private class zzi
            implements Runnable
        {

            final zzlg zzabL;

            public void run()
            {
                zzlg.zzc(zzabL).lock();
                boolean flag = Thread.interrupted();
                if (flag)
                {
                    zzlg.zzc(zzabL).unlock();
                    return;
                }
                zznO();
                zzlg.zzc(zzabL).unlock();
                return;
                Object obj;
                obj;
                zzlg.zzd(zzabL).zza(((RuntimeException) (obj)));
                zzlg.zzc(zzabL).unlock();
                return;
                obj;
                zzlg.zzc(zzabL).unlock();
                throw obj;
            }

            protected abstract void zznO();

            private zzi()
            {
                zzabL = zzlg.this;
                super();
            }

            zzi(_cls1 _pcls1)
            {
                this();
            }
        }


        final zzlg zzabL;
        private final ArrayList zzabX;

        public void zznO()
        {
            for (Iterator iterator = zzabX.iterator(); iterator.hasNext(); ((com.google.android.gms.common.api.Api.zzb)iterator.next()).zza(zzlg.zzg(zzabL))) { }
        }

        public zzh(ArrayList arraylist)
        {
            zzabL = zzlg.this;
            super(null);
            zzabX = arraylist;
        }
    }


    private class zzc extends zzi
    {

        final zzlg zzabL;

        public void zznO()
        {
            com.google.android.gms.internal.zzlg.zzf(zzabL).zza(zzlg.zzg(zzabL), zzlg.zzd(zzabL).zzaci, zzabL. new zza());
        }

        private zzc()
        {
            zzabL = zzlg.this;
            super(null);
        }

        zzc(_cls1 _pcls1)
        {
            this();
        }

        private class zza extends zzb
        {

            private final WeakReference zzabM;

            public void zza(ConnectionResult connectionresult, AuthAccountResult authaccountresult)
            {
                authaccountresult = (zzlg)zzabM.get();
                if (authaccountresult == null)
                {
                    return;
                } else
                {
                    class _cls1 extends zzli.zzb
                    {

                        final zzlg zzabN;
                        final ConnectionResult zzabO;
                        final zza zzabP;

                        public void zznO()
                        {
                            zzlg.zzc(zzabN, zzabO);
                        }

                    _cls1(zzlj zzlj1, zzlg zzlg1, ConnectionResult connectionresult)
                    {
                        zzabP = zza.this;
                        zzabN = zzlg1;
                        zzabO = connectionresult;
                        super(zzlj1);
                    }
                    }

                    zzlg.zzd(authaccountresult).zza(new _cls1(authaccountresult, authaccountresult, connectionresult));
                    return;
                }
            }

            zza()
            {
                zzabM = new WeakReference(zzlg.this);
            }
        }

    }


    private class zzf extends zzi
    {

        final zzlg zzabL;
        private final ArrayList zzabX;

        public void zznO()
        {
            Set set = zzlg.zzd(zzabL).zzaci;
            if (set.isEmpty())
            {
                set = zzlg.zzh(zzabL);
            }
            for (Iterator iterator = zzabX.iterator(); iterator.hasNext(); ((com.google.android.gms.common.api.Api.zzb)iterator.next()).zza(zzlg.zzg(zzabL), set)) { }
        }

        public zzf(ArrayList arraylist)
        {
            zzabL = zzlg.this;
            super(null);
            zzabX = arraylist;
        }
    }


    private class _cls1
        implements Runnable
    {

        final zzlg zzabL;

        public void run()
        {
            com.google.android.gms.internal.zzlg.zzb(zzabL).zzac(zzlg.zza(zzabL));
        }

        _cls1()
        {
            zzabL = zzlg.this;
            super();
        }
    }


    private class zzd
        implements com.google.android.gms.common.api.GoogleApiClient.zza
    {

        private final WeakReference zzabM;
        private final Api zzabS;
        private final int zzabT;

        public void zza(ConnectionResult connectionresult)
        {
            zzlg zzlg1;
            boolean flag = false;
            zzlg1 = (zzlg)zzabM.get();
            if (zzlg1 == null)
            {
                return;
            }
            if (Looper.myLooper() == zzlg.zzd(zzlg1).getLooper())
            {
                flag = true;
            }
            zzx.zza(flag, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zzlg.zzc(zzlg1).lock();
            boolean flag1 = zzlg.zza(zzlg1, 0);
            if (!flag1)
            {
                zzlg.zzc(zzlg1).unlock();
                return;
            }
            if (!connectionresult.isSuccess())
            {
                zzlg.zza(zzlg1, connectionresult, zzabS, zzabT);
            }
            if (com.google.android.gms.internal.zzlg.zzk(zzlg1))
            {
                zzlg.zzl(zzlg1);
            }
            zzlg.zzc(zzlg1).unlock();
            return;
            connectionresult;
            zzlg.zzc(zzlg1).unlock();
            throw connectionresult;
        }

        public void zzb(ConnectionResult connectionresult)
        {
            zzlg zzlg1;
            boolean flag = true;
            zzlg1 = (zzlg)zzabM.get();
            if (zzlg1 == null)
            {
                return;
            }
            if (Looper.myLooper() != zzlg.zzd(zzlg1).getLooper())
            {
                flag = false;
            }
            zzx.zza(flag, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            zzlg.zzc(zzlg1).lock();
            flag = zzlg.zza(zzlg1, 1);
            if (!flag)
            {
                zzlg.zzc(zzlg1).unlock();
                return;
            }
            if (!connectionresult.isSuccess())
            {
                zzlg.zza(zzlg1, connectionresult, zzabS, zzabT);
            }
            if (com.google.android.gms.internal.zzlg.zzk(zzlg1))
            {
                zzlg.zzm(zzlg1);
            }
            zzlg.zzc(zzlg1).unlock();
            return;
            connectionresult;
            zzlg.zzc(zzlg1).unlock();
            throw connectionresult;
        }

        public zzd(Api api, int i)
        {
            zzabM = new WeakReference(zzlg.this);
            zzabS = api;
            zzabT = i;
        }
    }


    private class zzg
        implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        final zzlg zzabL;

        public void onConnected(Bundle bundle)
        {
            com.google.android.gms.internal.zzlg.zzf(zzabL).zza(zzabL. new zzb());
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            zzlg.zzc(zzabL).lock();
            if (!com.google.android.gms.internal.zzlg.zzb(zzabL, connectionresult)) goto _L2; else goto _L1
_L1:
            zzlg.zzi(zzabL);
            zzlg.zzj(zzabL);
_L4:
            zzlg.zzc(zzabL).unlock();
            return;
_L2:
            zzlg.zza(zzabL, connectionresult);
            if (true) goto _L4; else goto _L3
_L3:
            connectionresult;
            zzlg.zzc(zzabL).unlock();
            throw connectionresult;
        }

        public void onConnectionSuspended(int i)
        {
        }

        private zzg()
        {
            zzabL = zzlg.this;
            super();
        }

        zzg(_cls1 _pcls1)
        {
            this();
        }

        private class zzb extends com.google.android.gms.common.internal.zzt.zza
        {

            private final WeakReference zzabM;

            public void zzb(ResolveAccountResponse resolveaccountresponse)
            {
                zzlg zzlg1 = (zzlg)zzabM.get();
                if (zzlg1 == null)
                {
                    return;
                } else
                {
                    class _cls1 extends zzli.zzb
                    {

                        final zzlg zzabN;
                        final ResolveAccountResponse zzabQ;
                        final zzb zzabR;

                        public void zznO()
                        {
                            zzlg.zza(zzabN, zzabQ);
                        }

                    _cls1(zzlj zzlj1, zzlg zzlg1, ResolveAccountResponse resolveaccountresponse)
                    {
                        zzabR = zzb.this;
                        zzabN = zzlg1;
                        zzabQ = resolveaccountresponse;
                        super(zzlj1);
                    }
                    }

                    zzlg.zzd(zzlg1).zza(new _cls1(zzlg1, zzlg1, resolveaccountresponse));
                    return;
                }
            }

            zzb()
            {
                zzabM = new WeakReference(zzlg.this);
            }
        }

    }


    private class zze extends zzi
    {

        final zzlg zzabL;
        private final Map zzabU;

        public void zznO()
        {
            int i = com.google.android.gms.internal.zzlg.zzb(zzabL).isGooglePlayServicesAvailable(zzlg.zza(zzabL));
            if (i != 0)
            {
                ConnectionResult connectionresult = new ConnectionResult(i, null);
                class _cls1 extends zzli.zzb
                {

                    final ConnectionResult zzabV;
                    final zze zzabW;

                    public void zznO()
                    {
                        zzlg.zza(zzabW.zzabL, zzabV);
                    }

                _cls1(zzlj zzlj1, ConnectionResult connectionresult)
                {
                    zzabW = zze.this;
                    zzabV = connectionresult;
                    super(zzlj1);
                }
                }

                zzlg.zzd(zzabL).zza(new _cls1(zzabL, connectionresult));
            } else
            {
                if (zzlg.zze(zzabL))
                {
                    com.google.android.gms.internal.zzlg.zzf(zzabL).connect();
                }
                Iterator iterator = zzabU.keySet().iterator();
                while (iterator.hasNext()) 
                {
                    com.google.android.gms.common.api.Api.zzb zzb1 = (com.google.android.gms.common.api.Api.zzb)iterator.next();
                    zzb1.zza((com.google.android.gms.common.api.GoogleApiClient.zza)zzabU.get(zzb1));
                }
            }
        }

        public zze(Map map)
        {
            zzabL = zzlg.this;
            super(null);
            zzabU = map;
        }
    }

}
