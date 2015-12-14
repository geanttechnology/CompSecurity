// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarActivityDelegateBase;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.View;

class h extends ActionBarActivityDelegateBase
    implements bw
{

    private NativeActionModeAwareLayout k;

    h(ActionBarActivity actionbaractivity)
    {
        super(actionbaractivity);
    }

    public ActionMode a(View view, android.view.ActionMode.Callback callback)
    {
        view = b(new t(view.getContext(), callback));
        if (view != null)
        {
            return new s(a, view);
        } else
        {
            return null;
        }
    }

    boolean a(int i, KeyEvent keyevent)
    {
        return false;
    }

    void q()
    {
        k = (NativeActionModeAwareLayout)a.findViewById(0x1020002);
        if (k != null)
        {
            k.setActionModeForChildListener(this);
        }
    }
}
