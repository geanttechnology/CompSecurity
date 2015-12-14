// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzfh, zziz, zzid, zzfi

public class zzfc extends zzfh
{

    static final Set zzAb = new HashSet(Arrays.asList(new String[] {
        "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"
    }));
    private String zzAc;
    private boolean zzAd;
    private int zzAe;
    private int zzAf;
    private int zzAg;
    private int zzAh;
    private final Activity zzAi;
    private ImageView zzAj;
    private LinearLayout zzAk;
    private zzfi zzAl;
    private PopupWindow zzAm;
    private RelativeLayout zzAn;
    private ViewGroup zzAo;
    private int zznQ;
    private int zznR;
    private final zziz zzoM;
    private final Object zzpd = new Object();
    private AdSizeParcel zzzm;

    public zzfc(zziz zziz1, zzfi zzfi1)
    {
        super(zziz1, "resize");
        zzAc = "top-right";
        zzAd = true;
        zzAe = 0;
        zzAf = 0;
        zznR = -1;
        zzAg = 0;
        zzAh = 0;
        zznQ = -1;
        zzoM = zziz1;
        zzAi = zziz1.zzgZ();
        zzAl = zzfi1;
    }

    private int[] zzee()
    {
        if (!zzeg())
        {
            return null;
        }
        if (zzAd)
        {
            return (new int[] {
                zzAe + zzAg, zzAf + zzAh
            });
        }
        int ai[] = zzp.zzbv().zzh(zzAi);
        int ai1[] = zzp.zzbv().zzj(zzAi);
        int l = ai[0];
        int j = zzAe + zzAg;
        int k = zzAf + zzAh;
        int i;
        if (j < 0)
        {
            i = 0;
        } else
        {
            i = j;
            if (zznQ + j > l)
            {
                i = l - zznQ;
            }
        }
        if (k < ai1[0])
        {
            j = ai1[0];
        } else
        {
            j = k;
            if (zznR + k > ai1[1])
            {
                j = ai1[1] - zznR;
            }
        }
        return (new int[] {
            i, j
        });
    }

    private void zzf(Map map)
    {
        if (!TextUtils.isEmpty((CharSequence)map.get("width")))
        {
            zznQ = zzp.zzbv().zzaA((String)map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence)map.get("height")))
        {
            zznR = zzp.zzbv().zzaA((String)map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence)map.get("offsetX")))
        {
            zzAg = zzp.zzbv().zzaA((String)map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence)map.get("offsetY")))
        {
            zzAh = zzp.zzbv().zzaA((String)map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence)map.get("allowOffscreen")))
        {
            zzAd = Boolean.parseBoolean((String)map.get("allowOffscreen"));
        }
        map = (String)map.get("customClosePosition");
        if (!TextUtils.isEmpty(map))
        {
            zzAc = map;
        }
    }

    public void zza(int i, int j, boolean flag)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        zzAe = i;
        zzAf = j;
        if (zzAm == null || !flag)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        int ai[] = zzee();
        if (ai == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        zzAm.update(zzl.zzcF().zzb(zzAi, ai[0]), zzl.zzcF().zzb(zzAi, ai[1]), zzAm.getWidth(), zzAm.getHeight());
        zzc(ai[0], ai[1]);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        zzn(true);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void zzb(int i, int j)
    {
        if (zzAl != null)
        {
            zzAl.zza(i, j, zznQ, zznR);
        }
    }

    void zzc(int i, int j)
    {
        zzb(i, j - zzp.zzbv().zzj(zzAi)[0], zznQ, zznR);
    }

    public void zzd(int i, int j)
    {
        zzAe = i;
        zzAf = j;
    }

    boolean zzed()
    {
        return zznQ >= 0 && zznR >= 0;
    }

    public boolean zzef()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzAm != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean zzeg()
    {
        int ai[];
        int i;
        int k;
        int ai1[] = zzp.zzbv().zzh(zzAi);
        ai = zzp.zzbv().zzj(zzAi);
        k = ai1[0];
        i = ai1[1];
        if (zznQ >= 50 && zznQ <= k) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Width is too small or too large.");
_L18:
        return false;
_L2:
        String s;
        if (zznR < 50 || zznR > i)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Height is too small or too large.");
            return false;
        }
        if (zznR == i && zznQ == k)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot resize to a full-screen ad.");
            return false;
        }
        if (!zzAd)
        {
            break; /* Loop/switch isn't completed */
        }
        s = zzAc;
        i = -1;
        s.hashCode();
        JVM INSTR lookupswitch 6: default 180
    //                   -1364013995: 311
    //                   -1012429441: 283
    //                   -655373719: 325
    //                   1163912186: 353
    //                   1288627767: 339
    //                   1755462605: 297;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        i;
        JVM INSTR tableswitch 0 5: default 220
    //                   0 367
    //                   1 393
    //                   2 427
    //                   3 471
    //                   4 505
    //                   5 547;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L10:
        int j;
        j = (zzAe + zzAg + zznQ) - 50;
        i = zzAf + zzAh;
_L19:
        if (j < 0 || j + 50 > k || i < ai[0] || i + 50 > ai[1]) goto _L18; else goto _L17
_L17:
        return true;
_L5:
        if (s.equals("top-left"))
        {
            i = 0;
        }
          goto _L3
_L9:
        if (s.equals("top-center"))
        {
            i = 1;
        }
          goto _L3
_L4:
        if (s.equals("center"))
        {
            i = 2;
        }
          goto _L3
_L6:
        if (s.equals("bottom-left"))
        {
            i = 3;
        }
          goto _L3
_L8:
        if (s.equals("bottom-center"))
        {
            i = 4;
        }
          goto _L3
_L7:
        if (s.equals("bottom-right"))
        {
            i = 5;
        }
          goto _L3
_L11:
        i = zzAe;
        j = zzAg + i;
        i = zzAf + zzAh;
          goto _L19
_L12:
        j = (zzAe + zzAg + zznQ / 2) - 25;
        i = zzAf + zzAh;
          goto _L19
_L13:
        j = (zzAe + zzAg + zznQ / 2) - 25;
        i = (zzAf + zzAh + zznR / 2) - 25;
          goto _L19
_L14:
        i = zzAe;
        j = zzAg + i;
        i = (zzAf + zzAh + zznR) - 50;
          goto _L19
_L15:
        j = (zzAe + zzAg + zznQ / 2) - 25;
        i = (zzAf + zzAh + zznR) - 50;
          goto _L19
_L16:
        j = (zzAe + zzAg + zznQ) - 50;
        i = (zzAf + zzAh + zznR) - 50;
          goto _L19
        if (true) goto _L21; else goto _L20
_L21:
        if (true) goto _L18; else goto _L20
_L20:
    }

    public void zzg(Map map)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzAi != null)
                {
                    break label0;
                }
                zzak("Not an activity context. Cannot resize.");
            }
            return;
        }
        if (zzoM.zzaN() != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        zzak("Webview is not yet available, size is not set.");
        obj;
        JVM INSTR monitorexit ;
        return;
        map;
        obj;
        JVM INSTR monitorexit ;
        throw map;
        if (!zzoM.zzaN().zztf)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        zzak("Is interstitial. Cannot resize an interstitial.");
        obj;
        JVM INSTR monitorexit ;
        return;
        if (!zzoM.zzhi())
        {
            break MISSING_BLOCK_LABEL_97;
        }
        zzak("Cannot resize an expanded banner.");
        obj;
        JVM INSTR monitorexit ;
        return;
        zzf(map);
        if (zzed())
        {
            break MISSING_BLOCK_LABEL_119;
        }
        zzak("Invalid width and height options. Cannot resize.");
        obj;
        JVM INSTR monitorexit ;
        return;
        map = zzAi.getWindow();
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (map.getDecorView() != null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        zzak("Activity context is not ready, cannot get window or decor view.");
        obj;
        JVM INSTR monitorexit ;
        return;
        int ai[] = zzee();
        if (ai != null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        zzak("Resize location out of screen or close button is not visible.");
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        int i;
        int j;
        i = zzl.zzcF().zzb(zzAi, zznQ);
        j = zzl.zzcF().zzb(zzAi, zznR);
        obj1 = zzoM.getView().getParent();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        if (!(obj1 instanceof ViewGroup)) goto _L2; else goto _L3
_L3:
        ((ViewGroup)obj1).removeView(zzoM.getView());
        if (zzAm != null) goto _L5; else goto _L4
_L4:
        zzAo = (ViewGroup)obj1;
        obj1 = zzp.zzbv().zzk(zzoM.getView());
        zzAj = new ImageView(zzAi);
        zzAj.setImageBitmap(((android.graphics.Bitmap) (obj1)));
        zzzm = zzoM.zzaN();
        zzAo.addView(zzAj);
_L13:
        zzAn = new RelativeLayout(zzAi);
        zzAn.setBackgroundColor(0);
        zzAn.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, j));
        zzAm = zzp.zzbv().zza(zzAn, i, j, false);
        zzAm.setOutsideTouchable(true);
        zzAm.setTouchable(true);
        obj1 = zzAm;
        String s;
        boolean flag;
        if (!zzAd)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((PopupWindow) (obj1)).setClippingEnabled(flag);
        zzAn.addView(zzoM.getView(), -1, -1);
        zzAk = new LinearLayout(zzAi);
        obj1 = new android.widget.RelativeLayout.LayoutParams(zzl.zzcF().zzb(zzAi, 50), zzl.zzcF().zzb(zzAi, 50));
        s = zzAc;
        s.hashCode();
        JVM INSTR lookupswitch 6: default 1017
    //                   -1364013995: 767
    //                   -1012429441: 735
    //                   -655373719: 783
    //                   1163912186: 815
    //                   1288627767: 799
    //                   1755462605: 751;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L22:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
_L21:
        zzAk.setOnClickListener(new android.view.View.OnClickListener() {

            final zzfc zzAp;

            public void onClick(View view)
            {
                zzAp.zzn(true);
            }

            
            {
                zzAp = zzfc.this;
                super();
            }
        });
        zzAk.setContentDescription("Close button");
        zzAn.addView(zzAk, ((android.view.ViewGroup.LayoutParams) (obj1)));
        zzAm.showAtLocation(map.getDecorView(), 0, zzl.zzcF().zzb(zzAi, ai[0]), zzl.zzcF().zzb(zzAi, ai[1]));
        zzb(ai[0], ai[1]);
        zzoM.zza(new AdSizeParcel(zzAi, new AdSize(zznQ, zznR)));
        zzc(ai[0], ai[1]);
        zzam("resized");
        obj;
        JVM INSTR monitorexit ;
        return;
_L5:
        zzAm.dismiss();
          goto _L13
_L2:
        zzak("Webview is detached, probably in the middle of a resize or expand.");
        obj;
        JVM INSTR monitorexit ;
        return;
_L8:
        if (!s.equals("top-left")) goto _L6; else goto _L14
_L14:
        i = 0;
          goto _L15
_L12:
        if (!s.equals("top-center")) goto _L6; else goto _L16
_L16:
        i = 1;
          goto _L15
_L7:
        if (!s.equals("center")) goto _L6; else goto _L17
_L17:
        i = 2;
          goto _L15
_L9:
        if (!s.equals("bottom-left")) goto _L6; else goto _L18
_L18:
        i = 3;
          goto _L15
_L11:
        if (!s.equals("bottom-center")) goto _L6; else goto _L19
_L19:
        i = 4;
          goto _L15
_L10:
        if (!s.equals("bottom-right")) goto _L6; else goto _L20
_L20:
        i = 5;
          goto _L15
_L23:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
          goto _L21
_L24:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
          goto _L21
_L25:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(13);
          goto _L21
_L26:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
          goto _L21
_L27:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
          goto _L21
_L28:
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
          goto _L21
        map;
        zzak((new StringBuilder("Cannot show popup window: ")).append(map.getMessage()).toString());
        zzAn.removeView(zzoM.getView());
        if (zzAo != null)
        {
            zzAo.removeView(zzAj);
            zzAo.addView(zzoM.getView());
            zzoM.zza(zzzm);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
_L6:
        i = -1;
_L15:
        i;
        JVM INSTR tableswitch 0 5: default 1060
    //                   0 831
    //                   1 848
    //                   2 865
    //                   3 875
    //                   4 892
    //                   5 909;
           goto _L22 _L23 _L24 _L25 _L26 _L27 _L28
    }

    public void zzn(boolean flag)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzAm == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        zzAm.dismiss();
        zzAn.removeView(zzoM.getView());
        if (zzAo != null)
        {
            zzAo.removeView(zzAj);
            zzAo.addView(zzoM.getView());
            zzoM.zza(zzzm);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        zzam("default");
        if (zzAl != null)
        {
            zzAl.zzbc();
        }
        zzAm = null;
        zzAn = null;
        zzAo = null;
        zzAk = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
