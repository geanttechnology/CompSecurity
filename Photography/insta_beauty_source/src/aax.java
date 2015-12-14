// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotoback.FotoHomeBackView;

public class aax
    implements android.view.View.OnClickListener
{

    final FotoHomeBackView a;

    public aax(FotoHomeBackView fotohomebackview)
    {
        a = fotohomebackview;
        super();
    }

    public void onClick(View view)
    {
        if (FotoHomeBackView.access$000(a) != null)
        {
            FotoHomeBackView.access$000(a).c();
            FlurryAgent.logEvent("event_downloadApp");
        }
    }
}
