// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio:
//            f, ImagePickerActivity

final class 
    implements android.view..OnClickListener
{

    private int a;
    private f b;

    public final void onClick(View view)
    {
        AnalyticUtils.getInstance(b.a).trackLocalAction("first:imgFromRecent");
        view = (new File((String)ImagePickerActivity.a(b.a).get(a))).getParentFile().getName();
        view = x.a().a(new File(x.d(), view));
        if (ImagePickerActivity.l(b.a).size() >= a + 1 && ImagePickerActivity.a(b.a).size() >= a + 1)
        {
            ImagePickerActivity.a(b.a, (String)ImagePickerActivity.a(b.a).get(a), m.d((String)ImagePickerActivity.a(b.a).get(a)), 2, (HashMap)ImagePickerActivity.l(b.a).get(a), "", view);
        }
    }

    il.x(f f1, int i)
    {
        b = f1;
        a = i;
        super();
    }
}
