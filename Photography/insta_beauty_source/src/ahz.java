// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;

public class ahz
    implements android.view.View.OnClickListener
{

    final ProEditNewStretchActivity a;

    public ahz(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }

    public void onClick(View view)
    {
        a.onResetClicked();
    }
}
