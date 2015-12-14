// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditRotateBottomBar;

public class amy
    implements android.view.View.OnClickListener
{

    final TProEditRotateBottomBar a;

    public amy(TProEditRotateBottomBar tproeditrotatebottombar)
    {
        a = tproeditrotatebottombar;
        super();
    }

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.a("right", view);
        }
    }
}
