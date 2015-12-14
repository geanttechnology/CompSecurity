// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.activity.guide.GuideView;

public class bii
    implements android.view.View.OnClickListener
{

    final GuideView a;

    public bii(GuideView guideview)
    {
        a = guideview;
        super();
    }

    public void onClick(View view)
    {
        if (a.lisener != null)
        {
            a.lisener.a();
        }
    }
}
