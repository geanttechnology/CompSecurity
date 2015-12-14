// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.alertAd.TAlertAdView;

public class hl
    implements android.view.View.OnClickListener
{

    final TAlertAdView a;

    public hl(TAlertAdView talertadview)
    {
        a = talertadview;
        super();
    }

    public void onClick(View view)
    {
        a.onClickEvent.b();
    }
}
