// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.NewSecBeautyToolBar;

public class jr
    implements android.view.View.OnClickListener
{

    final NewSecBeautyToolBar a;

    public jr(NewSecBeautyToolBar newsecbeautytoolbar)
    {
        a = newsecbeautytoolbar;
        super();
    }

    public void onClick(View view)
    {
        if (a.mListener != null)
        {
            a.mListener.a(1);
            a.updateUiPensize(1);
        }
    }
}
