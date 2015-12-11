// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzo

public class zzm extends FrameLayout
    implements android.view.View.OnClickListener
{

    private final ImageButton zzBW;
    private final zzo zzBX;

    public zzm(Context context, int i, zzo zzo1)
    {
        super(context);
        zzBX = zzo1;
        setOnClickListener(this);
        zzBW = new ImageButton(context);
        zzBW.setImageResource(0x1080017);
        zzBW.setBackgroundColor(0);
        zzBW.setOnClickListener(this);
        zzBW.setPadding(0, 0, 0, 0);
        zzBW.setContentDescription("Interstitial close button");
        i = zzl.zzcF().zzb(context, i);
        addView(zzBW, new android.widget.FrameLayout.LayoutParams(i, i, 17));
    }

    public void onClick(View view)
    {
        if (zzBX != null)
        {
            zzBX.zzeE();
        }
    }

    public void zza(boolean flag, boolean flag1)
    {
        if (flag1)
        {
            if (flag)
            {
                zzBW.setVisibility(4);
                return;
            } else
            {
                zzBW.setVisibility(8);
                return;
            }
        } else
        {
            zzBW.setVisibility(0);
            return;
        }
    }
}
