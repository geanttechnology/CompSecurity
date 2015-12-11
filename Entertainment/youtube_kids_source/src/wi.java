// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.KeyEvent;
import android.view.View;
import com.google.android.apps.youtube.kids.activities.BrowserActivity;

public final class wi
    implements android.view.View.OnKeyListener
{

    private BrowserActivity a;

    public wi(BrowserActivity browseractivity)
    {
        a = browseractivity;
        super();
    }

    public final boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 111)
        {
            a.finish();
            return true;
        } else
        {
            return false;
        }
    }
}
