// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.deviantart;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.deviantart:
//            DeviantArtOAuthMainActivity

final class a
    implements android.widget.r
{

    private DeviantArtOAuthMainActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((TextView)view).getText().toString();
        view = DeviantArtOAuthMainActivity.d(a);
        i = DeviantArtOAuthMainActivity.d(a).getText().toString().lastIndexOf(adapterview, DeviantArtOAuthMainActivity.c(a));
        view.setSelection(adapterview.length() + i + 1);
    }

    (DeviantArtOAuthMainActivity deviantartoauthmainactivity)
    {
        a = deviantartoauthmainactivity;
        super();
    }
}
