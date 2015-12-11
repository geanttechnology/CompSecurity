// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.v;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuPresenter

class rCallback extends v
{

    final ActionMenuPresenter this$0;

    public void onDismiss()
    {
        super.onDismiss();
        ActionMenuPresenter.access$400(ActionMenuPresenter.this).close();
        ActionMenuPresenter.access$202(ActionMenuPresenter.this, null);
    }

    public A(Context context, i j, View view, boolean flag)
    {
        this$0 = ActionMenuPresenter.this;
        super(context, j, view, flag, android.support.v7.appcompat.s._fld0);
        setGravity(0x800005);
        setCallback(mPopupPresenterCallback);
    }
}
