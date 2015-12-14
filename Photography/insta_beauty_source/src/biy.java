// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.wantu.activity.mainpage.ViewMainPage1;

public class biy
    implements android.view.View.OnClickListener
{

    final ViewMainPage1 a;

    public biy(ViewMainPage1 viewmainpage1)
    {
        a = viewmainpage1;
        super();
    }

    public void onClick(View view)
    {
        Log.e("yyy1", "item_video");
        if (a.clickerListener != null)
        {
            a.clickerListener.a(view, "recordvideo");
        }
        FlurryAgent.logEvent("HomeButton_Video");
    }
}
