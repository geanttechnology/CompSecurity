// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;
import java.util.Collections;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzo, AdOverlayInfoParcel, zzg, zza, 
//            zzm

public class zzd extends com.google.android.gms.internal.zzfk.zza
    implements zzo
{

    static final int zzBh = Color.argb(0, 0, 0, 0);
    private final Activity mActivity;
    RelativeLayout zzAn;
    AdOverlayInfoParcel zzBi;
    zzc zzBj;
    zzm zzBk;
    boolean zzBl;
    FrameLayout zzBm;
    android.webkit.WebChromeClient.CustomViewCallback zzBn;
    boolean zzBo;
    boolean zzBp;
    boolean zzBq;
    int zzBr;
    private boolean zzBs;
    private boolean zzBt;
    private boolean zzBu;
    zziz zzoM;

    public zzd(Activity activity)
    {
        zzBl = false;
        zzBo = false;
        zzBp = false;
        zzBq = false;
        zzBr = 0;
        zzBt = false;
        zzBu = true;
        mActivity = activity;
    }

    static Activity zza(zzd zzd1)
    {
        return zzd1.mActivity;
    }

    public void close()
    {
        zzBr = 2;
        mActivity.finish();
    }

    public void onBackPressed()
    {
        zzBr = 0;
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag = false;
        if (bundle != null)
        {
            flag = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        zzBo = flag;
        zzBi = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zzb(mActivity.getIntent());
        if (zzBi == null)
        {
            throw new zza("Could not get info for ad overlay.");
        }
          goto _L1
_L10:
        return;
_L1:
        if (zzBi.zzqj.zzJw > 0x7270e0)
        {
            zzBr = 3;
        }
        if (mActivity.getIntent() != null)
        {
            zzBu = mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
        }
        if (zzBi.zzBM == null) goto _L3; else goto _L2
_L2:
        zzBp = zzBi.zzBM.zzpt;
_L9:
        if (((Boolean)zzby.zzvz.get()).booleanValue() && zzBp && zzBi.zzBM.zzpv != null)
        {
            (new zzd()).zzgz();
        }
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        if (zzBi.zzBC != null && zzBu)
        {
            zzBi.zzBC.zzaW();
        }
        if (zzBi.zzBJ != 1 && zzBi.zzBB != null)
        {
            zzBi.zzBB.onAdClicked();
        }
        zzAn = new zzb(mActivity, zzBi.zzBL);
        zzBi.zzBJ;
        JVM INSTR tableswitch 1 4: default 430
    //                   1 334
    //                   2 340
    //                   3 364
    //                   4 370;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        throw new zza("Could not determine ad overlay type.");
_L3:
        zzBp = false;
          goto _L9
_L5:
        try
        {
            zzv(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(bundle.getMessage());
            zzBr = 3;
            mActivity.finish();
        }
          goto _L10
_L6:
        zzBj = new zzc(zzBi.zzBD);
        zzv(false);
        return;
_L7:
        zzv(true);
        return;
_L8:
        if (zzBo)
        {
            zzBr = 3;
            mActivity.finish();
            return;
        }
        if (zzp.zzbs().zza(mActivity, zzBi.zzBA, zzBi.zzBI)) goto _L10; else goto _L11
_L11:
        zzBr = 3;
        mActivity.finish();
        return;
    }

    public void onDestroy()
    {
        if (zzoM != null)
        {
            zzAn.removeView(zzoM.getView());
        }
        zzeH();
    }

    public void onPause()
    {
        zzeD();
        if (zzoM != null && (!mActivity.isFinishing() || zzBj == null))
        {
            zzp.zzbx().zza(zzoM.getWebView());
        }
        zzeH();
    }

    public void onRestart()
    {
    }

    public void onResume()
    {
        if (zzBi != null && zzBi.zzBJ == 4)
        {
            if (zzBo)
            {
                zzBr = 3;
                mActivity.finish();
            } else
            {
                zzBo = true;
            }
        }
        if (zzoM != null && !zzoM.isDestroyed())
        {
            zzp.zzbx().zzb(zzoM.getWebView());
            return;
        } else
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("The webview does not exit. Ignoring action.");
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", zzBo);
    }

    public void onStart()
    {
    }

    public void onStop()
    {
        zzeH();
    }

    public void setRequestedOrientation(int i)
    {
        mActivity.setRequestedOrientation(i);
    }

    public void zza(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        zzBm = new FrameLayout(mActivity);
        zzBm.setBackgroundColor(0xff000000);
        zzBm.addView(view, -1, -1);
        mActivity.setContentView(zzBm);
        zzaE();
        zzBn = customviewcallback;
        zzBl = true;
    }

    public void zza(boolean flag, boolean flag1)
    {
        if (zzBk != null)
        {
            zzBk.zza(flag, flag1);
        }
    }

    public void zzaE()
    {
        zzBs = true;
    }

    public void zzeD()
    {
        if (zzBi != null && zzBl)
        {
            setRequestedOrientation(zzBi.orientation);
        }
        if (zzBm != null)
        {
            mActivity.setContentView(zzAn);
            zzaE();
            zzBm.removeAllViews();
            zzBm = null;
        }
        if (zzBn != null)
        {
            zzBn.onCustomViewHidden();
            zzBn = null;
        }
        zzBl = false;
    }

    public void zzeE()
    {
        zzBr = 1;
        mActivity.finish();
    }

    public boolean zzeF()
    {
        zzBr = 0;
        boolean flag;
        if (zzoM == null)
        {
            flag = true;
        } else
        {
            boolean flag1 = zzoM.zzhk();
            flag = flag1;
            if (!flag1)
            {
                zzoM.zzb("onbackblocked", Collections.emptyMap());
                return flag1;
            }
        }
        return flag;
    }

    public void zzeG()
    {
        zzAn.removeView(zzBk);
        zzu(true);
    }

    protected void zzeH()
    {
        if (mActivity.isFinishing() && !zzBt)
        {
            zzBt = true;
            if (zzoM != null)
            {
                zzv(zzBr);
                zzAn.removeView(zzoM.getView());
                if (zzBj != null)
                {
                    zzoM.setContext(zzBj.context);
                    zzoM.zzC(false);
                    zzBj.zzBx.addView(zzoM.getView(), zzBj.index, zzBj.zzBw);
                    zzBj = null;
                }
                zzoM = null;
            }
            if (zzBi != null && zzBi.zzBC != null)
            {
                zzBi.zzBC.zzaV();
                return;
            }
        }
    }

    public void zzeI()
    {
        if (zzBq)
        {
            zzBq = false;
            zzeJ();
        }
    }

    protected void zzeJ()
    {
        zzoM.zzeJ();
    }

    public void zzu(boolean flag)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams;
        byte byte0;
        if (flag)
        {
            byte0 = 50;
        } else
        {
            byte0 = 32;
        }
        zzBk = new zzm(mActivity, byte0, this);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(10);
        if (flag)
        {
            byte0 = 11;
        } else
        {
            byte0 = 9;
        }
        layoutparams.addRule(byte0);
        zzBk.zza(flag, zzBi.zzBG);
        zzAn.addView(zzBk, layoutparams);
    }

    protected void zzv(int i)
    {
        zzoM.zzv(i);
    }

    protected void zzv(boolean flag)
    {
        if (!zzBs)
        {
            mActivity.requestWindowFeature(1);
        }
        Object obj = mActivity.getWindow();
        if (obj == null)
        {
            throw new zza("Invalid activity, no window available.");
        }
        if (!zzBp || zzBi.zzBM != null && zzBi.zzBM.zzpu)
        {
            ((Window) (obj)).setFlags(1024, 1024);
        }
        boolean flag3 = zzBi.zzBD.zzhe().zzbY();
        zzBq = false;
        if (flag3)
        {
            if (zzBi.orientation == zzp.zzbx().zzgG())
            {
                boolean flag1;
                if (mActivity.getResources().getConfiguration().orientation == 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                zzBq = flag1;
            } else
            if (zzBi.orientation == zzp.zzbx().zzgH())
            {
                boolean flag2;
                if (mActivity.getResources().getConfiguration().orientation == 2)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                zzBq = flag2;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaF((new StringBuilder("Delay onShow to next orientation change: ")).append(zzBq).toString());
        setRequestedOrientation(zzBi.orientation);
        if (zzp.zzbx().zza(((Window) (obj))))
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Hardware acceleration on the AdActivity window enabled.");
        }
        if (!zzBp)
        {
            zzAn.setBackgroundColor(0xff000000);
        } else
        {
            zzAn.setBackgroundColor(zzBh);
        }
        mActivity.setContentView(zzAn);
        zzaE();
        if (flag)
        {
            zzoM = zzp.zzbw().zza(mActivity, zzBi.zzBD.zzaN(), true, flag3, null, zzBi.zzqj);
            zzoM.zzhe().zzb(null, null, zzBi.zzBE, zzBi.zzBI, true, zzBi.zzBK, null, zzBi.zzBD.zzhe().zzhq(), null);
            zzoM.zzhe().zza(new com.google.android.gms.internal.zzja.zza() {

                final com.google.android.gms.ads.internal.overlay.zzd zzBv;

                public void zza(zziz zziz1, boolean flag4)
                {
                    zziz1.zzeJ();
                }

            
            {
                zzBv = zzd.this;
                super();
            }
            });
            if (zzBi.url != null)
            {
                zzoM.loadUrl(zzBi.url);
            } else
            if (zzBi.zzBH != null)
            {
                zzoM.loadDataWithBaseURL(zzBi.zzBF, zzBi.zzBH, "text/html", "UTF-8", null);
            } else
            {
                throw new zza("No URL or HTML to display in ad overlay.");
            }
            if (zzBi.zzBD != null)
            {
                zzBi.zzBD.zzc(this);
            }
        } else
        {
            zzoM = zzBi.zzBD;
            zzoM.setContext(mActivity);
        }
        zzoM.zzb(this);
        obj = zzoM.getParent();
        if (obj != null && (obj instanceof ViewGroup))
        {
            ((ViewGroup)obj).removeView(zzoM.getView());
        }
        if (zzBp)
        {
            zzoM.setBackgroundColor(zzBh);
        }
        zzAn.addView(zzoM.getView(), -1, -1);
        if (!flag && !zzBq)
        {
            zzeJ();
        }
        zzu(flag3);
        if (zzoM.zzhf())
        {
            zza(flag3, true);
        }
    }


    private class zza extends Exception
    {

        public zza(String s)
        {
            super(s);
        }
    }


    private class zzd extends zzhz
    {

        final com.google.android.gms.ads.internal.overlay.zzd zzBv;

        public void onStop()
        {
        }

        public void zzbn()
        {
            Object obj = zzp.zzbv().zzg(com.google.android.gms.ads.internal.overlay.zzd.zza(zzBv), zzBv.zzBi.zzBM.zzpv);
            if (obj != null)
            {
                obj = zzp.zzbx().zza(com.google.android.gms.ads.internal.overlay.zzd.zza(zzBv), ((android.graphics.Bitmap) (obj)), zzBv.zzBi.zzBM.zzpw, zzBv.zzBi.zzBM.zzpx);
                zzid.zzIE.post(new Runnable(((Drawable) (obj))) {

                    final Drawable zzBy;
                    final zzd zzBz;

                    public void run()
                    {
                        com.google.android.gms.ads.internal.overlay.zzd.zza(zzBz.zzBv).getWindow().setBackgroundDrawable(zzBy);
                    }

                
                {
                    zzBz = zzd.this;
                    zzBy = drawable;
                    super();
                }
                });
            }
        }

        private zzd()
        {
            zzBv = com.google.android.gms.ads.internal.overlay.zzd.this;
            super();
        }

    }


    private class zzb extends RelativeLayout
    {

        zzif zzqQ;

        public final boolean onInterceptTouchEvent(MotionEvent motionevent)
        {
            zzqQ.zze(motionevent);
            return false;
        }

        public zzb(Context context, String s)
        {
            super(context);
            zzqQ = new zzif(context, s);
        }
    }


    private class zzc
    {

        public final Context context;
        public final int index;
        public final android.view.ViewGroup.LayoutParams zzBw;
        public final ViewGroup zzBx;

        public zzc(zziz zziz1)
        {
            zzBw = zziz1.getLayoutParams();
            android.view.ViewParent viewparent = zziz1.getParent();
            context = zziz1.zzha();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                zzBx = (ViewGroup)viewparent;
                index = zzBx.indexOfChild(zziz1.getView());
                zzBx.removeView(zziz1.getView());
                zziz1.zzC(true);
                return;
            } else
            {
                throw new zza("Could not get the parent of the WebView for an overlay.");
            }
        }
    }

}
