// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;

public class ahe
    implements android.view.View.OnClickListener
{

    final ProEditMosaicActivity a;

    public ahe(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void onClick(View view)
    {
        if (view.isSelected())
        {
            return;
        } else
        {
            ProEditMosaicActivity.a(a, ProEditMosaicActivity.q(a), false);
            ProEditMosaicActivity.a(a, ProEditMosaicActivity.f(a));
            return;
        }
    }
}
