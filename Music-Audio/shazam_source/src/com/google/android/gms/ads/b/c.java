// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.b;

import android.os.RemoteException;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.ads.b:
//            a

public abstract class c extends FrameLayout
{

    private final FrameLayout a;

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.addView(view, i, layoutparams);
        super.bringChildToFront(a);
    }

    public void bringChildToFront(View view)
    {
        super.bringChildToFront(view);
        if (a != view)
        {
            super.bringChildToFront(a);
        }
    }

    public void removeAllViews()
    {
        super.removeAllViews();
        super.addView(a);
    }

    public void removeView(View view)
    {
        if (a == view)
        {
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setNativeAd(a a1)
    {
        try
        {
            a1.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            b.a("Unable to call setNativeAd on delegate", a1);
        }
    }
}
