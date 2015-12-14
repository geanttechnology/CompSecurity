// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzgi, zziz

public class zzgj extends zzgi
{

    private Object zzDw;
    private PopupWindow zzDx;
    private boolean zzDy;

    zzgj(Context context, zzhs.zza zza, zziz zziz1, zzgg.zza zza1)
    {
        super(context, zza, zziz1, zza1);
        zzDw = new Object();
        zzDy = false;
    }

    private void zzfA()
    {
        synchronized (zzDw)
        {
            zzDy = true;
            if ((mContext instanceof Activity) && ((Activity)mContext).isDestroyed())
            {
                zzDx = null;
            }
            if (zzDx != null)
            {
                if (zzDx.isShowing())
                {
                    zzDx.dismiss();
                }
                zzDx = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void cancel()
    {
        zzfA();
        super.cancel();
    }

    protected void zzfz()
    {
        FrameLayout framelayout;
        if (mContext instanceof Activity)
        {
            obj = ((Activity)mContext).getWindow();
        } else
        {
            obj = null;
        }
        while (obj == null || ((Window) (obj)).getDecorView() == null || ((Activity)mContext).isDestroyed()) 
        {
            return;
        }
        framelayout = new FrameLayout(mContext);
        framelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        framelayout.addView(zzoM.getView(), -1, -1);
        synchronized (zzDw)
        {
            if (!zzDy)
            {
                break MISSING_BLOCK_LABEL_108;
            }
        }
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        zzDx = new PopupWindow(framelayout, 1, 1, false);
        zzDx.setOutsideTouchable(true);
        zzDx.setClippingEnabled(false);
        zzb.zzaF("Displaying the 1x1 popup off the screen.");
        zzDx.showAtLocation(((Window) (obj)).getDecorView(), 0, -1, -1);
_L1:
        obj1;
        JVM INSTR monitorexit ;
        return;
        obj;
        zzDx = null;
          goto _L1
    }

    protected void zzz(int i)
    {
        zzfA();
        super.zzz(i);
    }
}
