// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.ProEidtActionBarView;

public class kf
    implements android.view.View.OnClickListener
{

    final ProEidtActionBarView a;

    public kf(ProEidtActionBarView proeidtactionbarview)
    {
        a = proeidtactionbarview;
        super();
    }

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.d();
        }
    }
}
