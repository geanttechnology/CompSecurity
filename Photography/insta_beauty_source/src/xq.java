// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.other.TProEditRotateBottomBar;

public class xq
    implements android.view.View.OnClickListener
{

    final TProEditRotateBottomBar a;

    public xq(TProEditRotateBottomBar tproeditrotatebottombar)
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
