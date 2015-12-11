// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zziz;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzh, zzj, zzq, zzi

public class zzk extends FrameLayout
    implements zzh
{

    private final FrameLayout zzBN;
    private final zzq zzBO = new zzq(this);
    private zzi zzBP;
    private boolean zzBQ;
    private boolean zzBR;
    private TextView zzBS;
    private long zzBT;
    private long zzBU;
    private String zzBV;
    private final zziz zzoM;
    private String zzxZ;

    public zzk(Context context, zziz zziz1, int i, zzcg zzcg, zzce zzce)
    {
        super(context);
        zzoM = zziz1;
        zzBN = new FrameLayout(context);
        addView(zzBN, new android.widget.FrameLayout.LayoutParams(-1, -1));
        zzb.zzs(zziz1.zzhb());
        zzBP = zziz1.zzhb().zzoH.zza(context, zziz1, i, zzcg, zzce);
        if (zzBP != null)
        {
            zzBN.addView(zzBP, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        }
        zzBS = new TextView(context);
        zzBS.setBackgroundColor(0xff000000);
        zzeY();
        zzBO.zzfg();
        if (zzBP != null)
        {
            zzBP.zza(this);
        }
        if (zzBP == null)
        {
            zzh("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private transient void zza(String s, String as[])
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", s);
        int j = as.length;
        int i = 0;
        s = null;
        while (i < j) 
        {
            String s1 = as[i];
            if (s == null)
            {
                s = s1;
            } else
            {
                hashmap.put(s, s1);
                s = null;
            }
            i++;
        }
        zzoM.zzb("onVideoEvent", hashmap);
    }

    public static void zzd(zziz zziz1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("event", "no_video_view");
        zziz1.zzb("onVideoEvent", hashmap);
    }

    private void zzeY()
    {
        if (!zzfa())
        {
            zzBN.addView(zzBS, new android.widget.FrameLayout.LayoutParams(-1, -1));
            zzBN.bringChildToFront(zzBS);
        }
    }

    private void zzeZ()
    {
        if (zzfa())
        {
            zzBN.removeView(zzBS);
        }
    }

    private boolean zzfa()
    {
        return zzBS.getParent() != null;
    }

    private void zzfb()
    {
        if (zzoM.zzgZ() != null && !zzBQ)
        {
            boolean flag;
            if ((zzoM.zzgZ().getWindow().getAttributes().flags & 0x80) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzBR = flag;
            if (!zzBR)
            {
                zzoM.zzgZ().getWindow().addFlags(128);
                zzBQ = true;
                return;
            }
        }
    }

    private void zzfc()
    {
        while (zzoM.zzgZ() == null || !zzBQ || zzBR) 
        {
            return;
        }
        zzoM.zzgZ().getWindow().clearFlags(128);
        zzBQ = false;
    }

    public void destroy()
    {
        zzBO.cancel();
        if (zzBP != null)
        {
            zzBP.stop();
        }
        zzfc();
    }

    public void onPaused()
    {
        zza("pause", new String[0]);
        zzfc();
    }

    public void pause()
    {
        if (zzBP == null)
        {
            return;
        } else
        {
            zzBP.pause();
            return;
        }
    }

    public void play()
    {
        if (zzBP == null)
        {
            return;
        } else
        {
            zzBP.play();
            return;
        }
    }

    public void seekTo(int i)
    {
        if (zzBP == null)
        {
            return;
        } else
        {
            zzBP.seekTo(i);
            return;
        }
    }

    public void setMimeType(String s)
    {
        zzBV = s;
    }

    public void zza(float f)
    {
        if (zzBP == null)
        {
            return;
        } else
        {
            zzBP.zza(f);
            return;
        }
    }

    public void zzan(String s)
    {
        zzxZ = s;
    }

    public void zzd(int i, int j, int k, int l)
    {
        if (k == 0 || l == 0)
        {
            return;
        } else
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(k + 2, l + 2);
            layoutparams.setMargins(i - 1, j - 1, 0, 0);
            zzBN.setLayoutParams(layoutparams);
            requestLayout();
            return;
        }
    }

    public void zzd(MotionEvent motionevent)
    {
        if (zzBP == null)
        {
            return;
        } else
        {
            zzBP.dispatchTouchEvent(motionevent);
            return;
        }
    }

    public void zzeQ()
    {
    }

    public void zzeR()
    {
        while (zzBP == null || zzBU != 0L) 
        {
            return;
        }
        zza("canplaythrough", new String[] {
            "duration", String.valueOf((float)zzBP.getDuration() / 1000F), "videoWidth", String.valueOf(zzBP.getVideoWidth()), "videoHeight", String.valueOf(zzBP.getVideoHeight())
        });
    }

    public void zzeS()
    {
        zzfb();
    }

    public void zzeT()
    {
        zza("ended", new String[0]);
        zzfc();
    }

    public void zzeU()
    {
        zzeY();
        zzBU = zzBT;
    }

    public void zzeV()
    {
        if (zzBP == null)
        {
            return;
        }
        if (!TextUtils.isEmpty(zzxZ))
        {
            zzBP.setMimeType(zzBV);
            zzBP.setVideoPath(zzxZ);
            return;
        } else
        {
            zza("no_src", new String[0]);
            return;
        }
    }

    public void zzeW()
    {
        if (zzBP == null)
        {
            return;
        } else
        {
            TextView textview = new TextView(zzBP.getContext());
            textview.setText((new StringBuilder()).append("AdMob - ").append(zzBP.zzer()).toString());
            textview.setTextColor(0xffff0000);
            textview.setBackgroundColor(-256);
            zzBN.addView(textview, new android.widget.FrameLayout.LayoutParams(-2, -2, 17));
            zzBN.bringChildToFront(textview);
            return;
        }
    }

    void zzeX()
    {
        long l;
        if (zzBP != null)
        {
            if (zzBT != (l = zzBP.getCurrentPosition()) && l > 0L)
            {
                zzeZ();
                zza("timeupdate", new String[] {
                    "time", String.valueOf((float)l / 1000F)
                });
                zzBT = l;
                return;
            }
        }
    }

    public void zzex()
    {
        if (zzBP == null)
        {
            return;
        } else
        {
            zzBP.zzex();
            return;
        }
    }

    public void zzey()
    {
        if (zzBP == null)
        {
            return;
        } else
        {
            zzBP.zzey();
            return;
        }
    }

    public void zzh(String s, String s1)
    {
        zza("error", new String[] {
            "what", s, "extra", s1
        });
    }
}
