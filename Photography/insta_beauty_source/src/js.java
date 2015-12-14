// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.NewSecBeautyToolBar;

public class js
    implements android.view.View.OnClickListener
{

    final NewSecBeautyToolBar a;

    public js(NewSecBeautyToolBar newsecbeautytoolbar)
    {
        a = newsecbeautytoolbar;
        super();
    }

    public void onClick(View view)
    {
        if (a.mListener != null)
        {
            a.mListener.a(2);
            a.updateUiPensize(2);
        }
    }
}
