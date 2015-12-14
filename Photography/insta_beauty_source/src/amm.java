// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.view.ui.ProEidtActionBarView;

public class amm
    implements android.view.View.OnClickListener
{

    final ProEidtActionBarView a;

    public amm(ProEidtActionBarView proeidtactionbarview)
    {
        a = proeidtactionbarview;
        super();
    }

    public void onClick(View view)
    {
        a.layout_accept.setEnabled(false);
        if (a.listener != null)
        {
            a.listener.d();
        }
        a.layout_accept.setEnabled(true);
    }
}
