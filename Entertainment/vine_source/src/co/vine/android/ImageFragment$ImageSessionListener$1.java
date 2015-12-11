// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.support.v4.app.FragmentActivity;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            ImageFragment

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        Util.showCenteredToast(getActivity(), 0x7f0e0119);
        getActivity().finish();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
