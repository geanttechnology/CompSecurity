// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.activity.mainpage.ViewMainPage2;

public class bjc
    implements android.view.View.OnClickListener
{

    final ViewMainPage2 a;

    public bjc(ViewMainPage2 viewmainpage2)
    {
        a = viewmainpage2;
        super();
    }

    public void onClick(View view)
    {
        if (a.clickerListener != null)
        {
            a.clickerListener.a(view, "prev_page");
        }
    }
}
