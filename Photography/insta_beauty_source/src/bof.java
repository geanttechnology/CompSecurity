// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.wantu.setting.BackPathActionBarView;

public class bof
    implements android.view.View.OnClickListener
{

    final BackPathActionBarView a;

    public bof(BackPathActionBarView backpathactionbarview)
    {
        a = backpathactionbarview;
        super();
    }

    public void onClick(View view)
    {
        if (a.backTopLayerListener != null)
        {
            a.backTopLayerListener.e();
        }
    }
}
