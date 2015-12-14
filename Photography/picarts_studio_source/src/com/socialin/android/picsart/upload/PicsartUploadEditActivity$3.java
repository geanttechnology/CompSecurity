// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.upload;

import android.widget.CompoundButton;

// Referenced classes of package com.socialin.android.picsart.upload:
//            PicsartUploadEditActivity

final class a
    implements android.widget.geListener
{

    private PicsartUploadEditActivity a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        PicsartUploadEditActivity.a(a, flag);
    }

    (PicsartUploadEditActivity picsartuploadeditactivity)
    {
        a = picsartuploadeditactivity;
        super();
    }
}
