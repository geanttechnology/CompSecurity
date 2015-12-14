// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

// Referenced classes of package my.googlemusic.play.activities:
//            ContactUsActivity

public class this._cls0 extends DialogFragment
{

    final ContactUsActivity this$0;

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.app.logContactFragment(new ContextThemeWrapper(getActivity(), 0x7f0800e7));
    /* block-local class not found */
    class _cls2 {}

    /* block-local class not found */
    class _cls1 {}

        bundle._mth1(getActivity().getLayoutInflater().inflate(0x7f030048, null)).later("Send email", new _cls2()).logContactFragment("Cancel", new _cls1());
        return bundle.logContactFragment();
    }

    public _cls1()
    {
        this$0 = ContactUsActivity.this;
        super();
    }
}
