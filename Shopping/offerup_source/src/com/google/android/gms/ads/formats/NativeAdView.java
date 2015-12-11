// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzco;
import com.google.android.gms.internal.zzda;

// Referenced classes of package com.google.android.gms.ads.formats:
//            NativeAd

public abstract class NativeAdView extends FrameLayout
{

    private final FrameLayout zznZ;
    private final zzco zzoa;

    public NativeAdView(Context context)
    {
        super(context);
        zznZ = zzm(context);
        zzoa = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        zznZ = zzm(context);
        zzoa = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        zznZ = zzm(context);
        zzoa = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        zznZ = zzm(context);
        zzoa = zzaI();
    }

    private zzco zzaI()
    {
        zzx.zzb(zznZ, "createDelegate must be called after mOverlayFrame has been created");
        return zzl.zzcJ().zza(zznZ.getContext(), this, zznZ);
    }

    private FrameLayout zzm(Context context)
    {
        context = zzn(context);
        context.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        addView(context);
        return context;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, i, layoutparams);
        super.bringChildToFront(zznZ);
    }

    public void bringChildToFront(View view)
    {
        super.bringChildToFront(view);
        if (zznZ != view)
        {
            super.bringChildToFront(zznZ);
        }
    }

    public void removeAllViews()
    {
        super.removeAllViews();
        super.addView(zznZ);
    }

    public void removeView(View view)
    {
        if (zznZ == view)
        {
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setNativeAd(NativeAd nativead)
    {
        try
        {
            zzoa.zzb((zzd)nativead.zzaH());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (NativeAd nativead)
        {
            zzb.zzb("Unable to call setNativeAd on delegate", nativead);
        }
    }

    protected void zza(String s, View view)
    {
        try
        {
            zzoa.zza(s, zze.zzy(view));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzb.zzb("Unable to call setAssetView on delegate", s);
        }
    }

    protected View zzm(String s)
    {
        s = zzoa.zzW(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        s = (View)zze.zzp(s);
        return s;
        s;
        zzb.zzb("Unable to call getAssetView on delegate", s);
        return null;
    }

    FrameLayout zzn(Context context)
    {
        return new FrameLayout(context);
    }
}
