// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;

public class ahg
    implements android.view.View.OnClickListener
{

    final ProEditMosaicActivity a;

    public ahg(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void onClick(View view)
    {
        ProEditMosaicActivity proeditmosaicactivity = a;
        boolean flag;
        if (!view.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ProEditMosaicActivity.a(proeditmosaicactivity, flag);
    }
}
