// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.google.android.apps.youtube.kids.activities.ParentalControlOptionsFragment;

public final class xv
    implements android.view.View.OnClickListener
{

    private ParentalControlOptionsFragment a;

    public xv(ParentalControlOptionsFragment parentalcontroloptionsfragment)
    {
        a = parentalcontroloptionsfragment;
        super();
    }

    public final void onClick(View view)
    {
        view = new Intent("ACTION_START_GFEEDBACK");
        a.getActivity().setResult(-1, view);
        a.getActivity().finish();
    }
}
