// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.app.t;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.google.android.gms.internal:
//            zzll

public class zzlp extends Fragment
    implements android.content.DialogInterface.OnCancelListener
{

    private static final GoogleApiAvailability zzacJ = GoogleApiAvailability.getInstance();
    private boolean mStarted;
    private boolean zzacK;
    private int zzacL;
    private ConnectionResult zzacM;
    private final Handler zzacN = new Handler(Looper.getMainLooper());
    private zzll zzacO;
    private final SparseArray zzacP = new SparseArray();

    public zzlp()
    {
        zzacL = -1;
    }

    static int zza(zzlp zzlp1, int i)
    {
        zzlp1.zzacL = i;
        return i;
    }

    static ConnectionResult zza(zzlp zzlp1, ConnectionResult connectionresult)
    {
        zzlp1.zzacM = connectionresult;
        return connectionresult;
    }

    static zzll zza(zzlp zzlp1, zzll zzll1)
    {
        zzlp1.zzacO = zzll1;
        return zzll1;
    }

    public static zzlp zza(t t1)
    {
label0:
        {
            zzx.zzci("Must be called from main thread of process");
            t1 = t1.getSupportFragmentManager();
            zzlp zzlp1;
            try
            {
                zzlp1 = (zzlp)t1.a("GmsSupportLifecycleFragment");
            }
            // Misplaced declaration of an exception variable
            catch (t t1)
            {
                throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", t1);
            }
            if (zzlp1 != null)
            {
                t1 = zzlp1;
                if (!zzlp1.isRemoving())
                {
                    break label0;
                }
            }
            t1 = null;
        }
        return t1;
    }

    private void zza(int i, ConnectionResult connectionresult)
    {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        Object obj = (zza)zzacP.get(i);
        if (obj != null)
        {
            zzbp(i);
            obj = ((zza) (obj)).zzacS;
            if (obj != null)
            {
                ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (obj)).onConnectionFailed(connectionresult);
            }
        }
        zzok();
    }

    static void zza(zzlp zzlp1, int i, ConnectionResult connectionresult)
    {
        zzlp1.zza(i, connectionresult);
    }

    static boolean zza(zzlp zzlp1)
    {
        return zzlp1.mStarted;
    }

    static boolean zza(zzlp zzlp1, boolean flag)
    {
        zzlp1.zzacK = flag;
        return flag;
    }

    public static zzlp zzb(t t1)
    {
        zzlp zzlp1 = zza(t1);
        aa aa1 = t1.getSupportFragmentManager();
        t1 = zzlp1;
        if (zzlp1 == null)
        {
            t1 = new zzlp();
            aa1.a().a(t1, "GmsSupportLifecycleFragment").c();
            aa1.b();
        }
        return t1;
    }

    static boolean zzb(zzlp zzlp1)
    {
        return zzlp1.zzacK;
    }

    static void zzc(zzlp zzlp1)
    {
        zzlp1.zzok();
    }

    static Handler zzd(zzlp zzlp1)
    {
        return zzlp1.zzacN;
    }

    private void zzok()
    {
        zzacK = false;
        zzacL = -1;
        zzacM = null;
        if (zzacO != null)
        {
            zzacO.unregister();
            zzacO = null;
        }
        for (int i = 0; i < zzacP.size(); i++)
        {
            ((zza)zzacP.valueAt(i)).zzacR.connect();
        }

    }

    static GoogleApiAvailability zzol()
    {
        return zzacJ;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.dump(s, filedescriptor, printwriter, as);
        for (int i = 0; i < zzacP.size(); i++)
        {
            ((zza)zzacP.valueAt(i)).dump(s, filedescriptor, printwriter, as);
        }

    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        boolean flag = true;
        i;
        JVM INSTR tableswitch 1 2: default 28
    //                   1 58
    //                   2 39;
           goto _L1 _L2 _L3
_L1:
        i = 0;
_L4:
        if (i != 0)
        {
            zzok();
            return;
        } else
        {
            zza(zzacL, zzacM);
            return;
        }
_L3:
        if (zzacJ.isGooglePlayServicesAvailable(getActivity()) != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
          goto _L4
_L2:
        i = ((flag) ? 1 : 0);
        if (j == -1) goto _L4; else goto _L5
_L5:
        if (j == 0)
        {
            zzacM = new ConnectionResult(13, null);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        zza(zzacL, new ConnectionResult(13, null));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            zzacK = bundle.getBoolean("resolving_error", false);
            zzacL = bundle.getInt("failed_client_id", -1);
            if (zzacL >= 0)
            {
                zzacM = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent)bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", zzacK);
        if (zzacL >= 0)
        {
            bundle.putInt("failed_client_id", zzacL);
            bundle.putInt("failed_status", zzacM.getErrorCode());
            bundle.putParcelable("failed_resolution", zzacM.getResolution());
        }
    }

    public void onStart()
    {
        super.onStart();
        mStarted = true;
        if (!zzacK)
        {
            for (int i = 0; i < zzacP.size(); i++)
            {
                ((zza)zzacP.valueAt(i)).zzacR.connect();
            }

        }
    }

    public void onStop()
    {
        super.onStop();
        mStarted = false;
        for (int i = 0; i < zzacP.size(); i++)
        {
            ((zza)zzacP.valueAt(i)).zzacR.disconnect();
        }

    }

    public void zza(int i, GoogleApiClient googleapiclient, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        zzx.zzb(googleapiclient, "GoogleApiClient instance cannot be null");
        boolean flag;
        if (zzacP.indexOfKey(i) < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, (new StringBuilder("Already managing a GoogleApiClient with id ")).append(i).toString());
        onconnectionfailedlistener = new zza(i, googleapiclient, onconnectionfailedlistener);
        zzacP.put(i, onconnectionfailedlistener);
        if (mStarted && !zzacK)
        {
            googleapiclient.connect();
        }
    }

    public void zzbp(int i)
    {
        zza zza1 = (zza)zzacP.get(i);
        zzacP.remove(i);
        if (zza1 != null)
        {
            zza1.zzom();
        }
    }


    private class zza
        implements com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        public final int zzacQ;
        public final GoogleApiClient zzacR;
        public final com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener zzacS;
        final zzlp zzacT;

        public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
        {
            printwriter.append(s).append("GoogleApiClient #").print(zzacQ);
            printwriter.println(":");
            zzacR.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            zzlp.zzd(zzacT).post(zzacT. new zzb(zzacQ, connectionresult));
        }

        public void zzom()
        {
            zzacR.unregisterConnectionFailedListener(this);
            zzacR.disconnect();
        }

        public zza(int i, GoogleApiClient googleapiclient, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            zzacT = zzlp.this;
            super();
            zzacQ = i;
            zzacR = googleapiclient;
            zzacS = onconnectionfailedlistener;
            googleapiclient.registerConnectionFailedListener(this);
        }

        private class zzb
            implements Runnable
        {

            final zzlp zzacT;
            private final int zzacU;
            private final ConnectionResult zzacV;

            public void run()
            {
                if (!zzlp.zza(zzacT) || zzlp.zzb(zzacT))
                {
                    return;
                }
                zzlp.zza(zzacT, true);
                zzlp.zza(zzacT, zzacU);
                zzlp.zza(zzacT, zzacV);
                if (zzacV.hasResolution())
                {
                    try
                    {
                        int i = zzacT.getActivity().getSupportFragmentManager().d().indexOf(zzacT);
                        zzacV.startResolutionForResult(zzacT.getActivity(), (i + 1 << 16) + 1);
                        return;
                    }
                    catch (android.content.IntentSender.SendIntentException sendintentexception)
                    {
                        zzlp.zzc(zzacT);
                    }
                    return;
                }
                if (zzlp.zzol().isUserResolvableError(zzacV.getErrorCode()))
                {
                    GooglePlayServicesUtil.showErrorDialogFragment(zzacV.getErrorCode(), zzacT.getActivity(), zzacT, 2, zzacT);
                    return;
                }
                if (zzacV.getErrorCode() == 18)
                {
                    Dialog dialog = zzlp.zzol().zza(zzacT.getActivity(), zzacT);
                    class _cls1 extends zzll
                    {

                        final Dialog zzacW;
                        final zzb zzacX;

                        protected void zzoi()
                        {
                            zzlp.zzc(zzacX.zzacT);
                            zzacW.dismiss();
                        }

                    _cls1(Dialog dialog)
                    {
                        zzacX = zzb.this;
                        zzacW = dialog;
                        super();
                    }
                    }

                    zzlp.zza(zzacT, zzll.zza(zzacT.getActivity().getApplicationContext(), new _cls1(dialog)));
                    return;
                } else
                {
                    zzlp.zza(zzacT, zzacU, zzacV);
                    return;
                }
            }

            public zzb(int i, ConnectionResult connectionresult)
            {
                zzacT = zzlp.this;
                super();
                zzacU = i;
                zzacV = connectionresult;
            }
        }

    }

}
