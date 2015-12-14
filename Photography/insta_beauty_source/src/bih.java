// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.Button;
import com.wantu.activity.guide.GuideView;

public class bih
    implements android.view.View.OnClickListener
{

    final GuideView a;

    public bih(GuideView guideview)
    {
        a = guideview;
        super();
    }

    public void onClick(View view)
    {
        view = a.btnCheck;
        boolean flag;
        if (!a.btnCheck.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setSelected(flag);
        if (a.lisener != null)
        {
            a.lisener.a(a.btnCheck.isSelected());
        }
    }
}
