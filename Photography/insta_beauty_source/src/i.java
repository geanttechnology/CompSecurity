// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.app.ActionBarActivityDelegateBase;
import android.widget.PopupWindow;

public class i
    implements Runnable
{

    final ActionBarActivityDelegateBase a;

    public i(ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        a = actionbaractivitydelegatebase;
        super();
    }

    public void run()
    {
        a.i.showAtLocation(a.h, 55, 0, 0);
    }
}
