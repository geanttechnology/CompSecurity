// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.flurry.android.FlurryAgent;
import com.fotoable.fullscreenad.FullScreenAdView;

public class aoh
    implements android.view.View.OnClickListener
{

    final FullScreenAdView a;

    public aoh(FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }

    public void onClick(View view)
    {
        FlurryAgent.logEvent(FullScreenAdView.access$700(a));
        FullScreenAdView.access$500(a);
    }
}
