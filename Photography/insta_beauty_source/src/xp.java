// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.other.TProEditRotateBottomBar;

public class xp
    implements android.view.View.OnClickListener
{

    final TProEditRotateBottomBar a;

    public xp(TProEditRotateBottomBar tproeditrotatebottombar)
    {
        a = tproeditrotatebottombar;
        super();
    }

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.a("left", view);
        }
    }
}
