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
        bundle = new android.app.DialogTermFragment(new ContextThemeWrapper(getActivity(), 0x7f0800e7));
        bundle.getActivity(getActivity().getLayoutInflater().inflate(0x7f030049, null));
        return bundle.Inflater();
    }

    public I()
    {
        this$0 = ContactUsActivity.this;
        super();
    }
}
