// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.support.v4.app.aa;
import android.support.v4.app.t;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzlp, zzll

class zzacV
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
            catch (android.content.der.SendIntentException sendintentexception)
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
                final zzlp.zzb zzacX;

                protected void zzoi()
                {
                    zzlp.zzc(zzacX.zzacT);
                    zzacW.dismiss();
                }

            _cls1(Dialog dialog)
            {
                zzacX = zzlp.zzb.this;
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

    public esult(zzlp zzlp1, int i, ConnectionResult connectionresult)
    {
        zzacT = zzlp1;
        super();
        zzacU = i;
        zzacV = connectionresult;
    }
}
