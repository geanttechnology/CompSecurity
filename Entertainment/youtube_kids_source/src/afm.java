// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.ui.InterstitialLayout;

public final class afm
    implements android.view.View.OnClickListener
{

    private InterstitialLayout a;

    public afm(InterstitialLayout interstitiallayout)
    {
        a = interstitiallayout;
        super();
    }

    public final void onClick(View view)
    {
        if (InterstitialLayout.a(a) != null)
        {
            InterstitialLayout.a(a).a();
        }
    }
}
