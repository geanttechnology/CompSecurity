// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import com.google.android.apps.youtube.kids.activities.ParentalControlOptionsFragment;
import com.google.android.apps.youtube.kids.activities.SettingsActivity;

public final class xw
    implements android.view.View.OnClickListener
{

    private ParentalControlOptionsFragment a;

    public xw(ParentalControlOptionsFragment parentalcontroloptionsfragment)
    {
        a = parentalcontroloptionsfragment;
        super();
    }

    public final void onClick(View view)
    {
        a.getActivity().finish();
        a.startActivity(SettingsActivity.a(a.getActivity()));
    }
}
