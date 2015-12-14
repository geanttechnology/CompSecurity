// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.NewOneBeautyToolBar;

public class jb
    implements android.view.View.OnClickListener
{

    final NewOneBeautyToolBar a;

    public jb(NewOneBeautyToolBar newonebeautytoolbar)
    {
        a = newonebeautytoolbar;
        super();
    }

    public void onClick(View view)
    {
        if (a.mListener != null)
        {
            a.mListener.b();
        }
    }
}
