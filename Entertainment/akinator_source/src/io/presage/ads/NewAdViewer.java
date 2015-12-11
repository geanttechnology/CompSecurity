// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package io.presage.ads:
//            NewAdController, NewAd

public abstract class NewAdViewer
{

    protected Context a;
    protected NewAdController b;
    protected NewAd c;
    protected int d;

    public NewAdViewer(NewAdController newadcontroller, NewAd newad, int i)
    {
        a = newadcontroller.getContext();
        b = newadcontroller;
        c = newad;
        d = i;
    }

    public boolean hasFlag(int i)
    {
        return (d & i) != 0;
    }

    public abstract void hide();

    protected void onHide()
    {
        Intent intent = new Intent();
        intent.setAction("io.presage.ad.HIDE");
        intent.putExtra("id", c.getId());
        a.sendBroadcast(intent);
    }

    protected void onShow()
    {
        Intent intent = new Intent();
        intent.setAction("io.presage.ad.SHOW");
        intent.putExtra("id", c.getId());
        a.sendBroadcast(intent);
    }

    public abstract void show();
}
