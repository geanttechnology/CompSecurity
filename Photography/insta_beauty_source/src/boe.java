// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotobeauty.FileSystemActivity;
import com.wantu.setting.BackPathActionBarView;

public class boe
    implements android.view.View.OnClickListener
{

    final BackPathActionBarView a;

    public boe(BackPathActionBarView backpathactionbarview)
    {
        a = backpathactionbarview;
        super();
    }

    public void onClick(View view)
    {
        if (a.backTopLayerListener != null && (a.backTopLayerListener instanceof FileSystemActivity))
        {
            a.backTopLayerListener.c();
            return;
        } else
        {
            a.backTopLayerListener.e();
            return;
        }
    }
}
