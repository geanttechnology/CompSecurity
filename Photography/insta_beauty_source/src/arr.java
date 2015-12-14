// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.photoselector.activity.CommonActionBarView;

public class arr
    implements android.view.View.OnClickListener
{

    final CommonActionBarView a;

    public arr(CommonActionBarView commonactionbarview)
    {
        a = commonactionbarview;
        super();
    }

    public void onClick(View view)
    {
        a.next_btn.setEnabled(false);
        if (a.listener != null)
        {
            a.listener.a();
        }
        a.next_btn.setEnabled(true);
    }
}
