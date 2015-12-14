// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.x;
import java.util.List;

// Referenced classes of package com.picsart.studio:
//            ImagePickerActivity

final class a
    implements android.view.ity._cls1
{

    private ImagePickerActivity a;

    public final void onClick(View view)
    {
        if (ImagePickerActivity.a(a).size() != 1 || ImagePickerActivity.a(a).size() == 1 && !((String)ImagePickerActivity.a(a).get(0)).contains("current"))
        {
            x.a();
            x.b();
            ImagePickerActivity.b(a);
        }
        AnalyticUtils.getInstance(a).trackLocalAction("first:clearRecents");
    }

    tils(ImagePickerActivity imagepickeractivity)
    {
        a = imagepickeractivity;
        super();
    }
}
