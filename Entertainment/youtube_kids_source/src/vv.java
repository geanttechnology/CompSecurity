// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.google.android.apps.youtube.kids.activities.ParentalControlActivity;

final class vv
    implements android.view.View.OnClickListener
{

    private View a;
    private vq b;

    vv(vq vq1, View view)
    {
        b = vq1;
        a = view;
        super();
    }

    public final void onClick(View view)
    {
        a.setEnabled(false);
        b.g.b(0x7f080014);
        b.startActivityForResult(ParentalControlActivity.a(b), 1);
    }
}
