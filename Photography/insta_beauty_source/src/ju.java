// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.NewSecBeautyToolBar;

public class ju
    implements kk
{

    final NewSecBeautyToolBar a;

    public ju(NewSecBeautyToolBar newsecbeautytoolbar)
    {
        a = newsecbeautytoolbar;
        super();
    }

    public void a()
    {
        if (a.mListener != null)
        {
            a.mListener.a(true);
        }
    }

    public void b()
    {
        if (a.mListener != null)
        {
            a.mListener.a(false);
        }
    }
}
