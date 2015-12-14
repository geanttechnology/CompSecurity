// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ActionBar;
import com.example.android.bitmapfun.util.ImageDetailActivity;

public class gp
    implements android.view.View.OnSystemUiVisibilityChangeListener
{

    final ActionBar a;
    final ImageDetailActivity b;

    public gp(ImageDetailActivity imagedetailactivity, ActionBar actionbar)
    {
        b = imagedetailactivity;
        a = actionbar;
        super();
    }

    public void onSystemUiVisibilityChange(int i)
    {
        if ((i & 1) != 0)
        {
            a.hide();
            return;
        } else
        {
            a.show();
            return;
        }
    }
}
