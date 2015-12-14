// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.view.View;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.adapter.a;

public final class j
    implements android.view.View.OnClickListener
{

    private a a;

    public j(a a1)
    {
        a = a1;
        super();
    }

    public final void onClick(View view)
    {
        a.a(-1, ItemControl.LOGIN, new Object[0]);
    }
}
