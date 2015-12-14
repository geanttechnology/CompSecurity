// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.ProEidtMainActionBarView;

public class amp
    implements android.view.View.OnClickListener
{

    final ProEidtMainActionBarView a;

    public amp(ProEidtMainActionBarView proeidtmainactionbarview)
    {
        a = proeidtmainactionbarview;
        super();
    }

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.a();
        }
    }
}
