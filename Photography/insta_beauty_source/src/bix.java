// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.flurry.android.FlurryAgent;
import com.wantu.activity.mainpage.ViewMainPage1;

public class bix
    implements android.view.View.OnClickListener
{

    final ViewMainPage1 a;

    public bix(ViewMainPage1 viewmainpage1)
    {
        a = viewmainpage1;
        super();
    }

    public void onClick(View view)
    {
        if (a.clickerListener != null)
        {
            a.clickerListener.a(view, "proedit");
        }
        FlurryAgent.logEvent("HomeButton_Camera");
    }
}
