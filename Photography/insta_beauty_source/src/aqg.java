// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.homewall.THomewallView;

public class aqg
    implements android.view.View.OnClickListener
{

    final THomewallView a;

    public aqg(THomewallView thomewallview)
    {
        a = thomewallview;
        super();
    }

    public void onClick(View view)
    {
        THomewallView.access$000(a);
    }
}
