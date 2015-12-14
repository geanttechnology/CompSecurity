// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.FrameLayout;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;

public class ahd
    implements android.view.View.OnClickListener
{

    final ProEditMosaicActivity a;

    public ahd(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void onClick(View view)
    {
        ProEditMosaicActivity.a(a).setVisibility(8);
        aqx.b(a, ProEditMosaicActivity.b(a), false);
    }
}
