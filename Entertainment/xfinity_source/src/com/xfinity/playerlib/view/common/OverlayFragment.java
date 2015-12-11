// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.common;

import android.app.Activity;
import android.app.Fragment;

// Referenced classes of package com.xfinity.playerlib.view.common:
//            OverlayDismissedListener

public abstract class OverlayFragment extends Fragment
{

    private OverlayDismissedListener overlayDismissedListener;

    public OverlayFragment()
    {
    }

    protected void dismissOverlay(String s)
    {
        overlayDismissedListener.onOverlayDismissed(s);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        overlayDismissedListener = (OverlayDismissedListener)activity;
    }
}
