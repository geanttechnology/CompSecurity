// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.view.actionbar.CommonActionBarView;

public class ayf
    implements android.view.View.OnClickListener
{

    final CommonActionBarView a;

    public ayf(CommonActionBarView commonactionbarview)
    {
        a = commonactionbarview;
        super();
    }

    public void onClick(View view)
    {
        a.layout_accept.setEnabled(false);
        if (a.listener != null)
        {
            a.listener.a();
        }
        a.layout_accept.setEnabled(true);
    }
}
