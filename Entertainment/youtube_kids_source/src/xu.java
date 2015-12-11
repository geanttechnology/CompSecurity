// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.activities.ParentalControlOptionsFragment;

public final class xu
    implements android.view.View.OnClickListener
{

    private ParentalControlOptionsFragment a;

    public xu(ParentalControlOptionsFragment parentalcontroloptionsfragment)
    {
        a = parentalcontroloptionsfragment;
        super();
    }

    public final void onClick(View view)
    {
        (new zl()).show(a.getFragmentManager(), "TimeLimitDialog");
    }
}
