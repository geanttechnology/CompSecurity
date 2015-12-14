// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.socialin.android.googledrive:
//            GoogleAccountPickerActivity

final class a
    implements android.widget.r
{

    private GoogleAccountPickerActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)adapterview.getItemAtPosition(i);
        GoogleAccountPickerActivity.a(a, adapterview);
    }

    (GoogleAccountPickerActivity googleaccountpickeractivity)
    {
        a = googleaccountpickeractivity;
        super();
    }
}
