// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Rect;
import android.support.v7.app.ActionBarActivityDelegateBase;

public class h
    implements dd
{

    final ActionBarActivityDelegateBase a;

    public h(ActionBarActivityDelegateBase actionbaractivitydelegatebase)
    {
        a = actionbaractivitydelegatebase;
        super();
    }

    public void a(Rect rect)
    {
        rect.top = ActionBarActivityDelegateBase.c(a, rect.top);
    }
}
