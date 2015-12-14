// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.view.View;
import android.widget.AdapterView;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.photo.textart:
//            b, TextPreview

final class a
    implements android.widget.terView.OnItemClickListener
{

    private b a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("textart:setStyle");
        b.g(i);
        b.e(a, b.b());
        i = b.a(a).getSelectionEnd();
        b.f(a, b.c());
        b.a(a).setText(b.a(a).getText());
        b.a(a).invalidate();
        b.a(a).setSelection(i);
        b.a(a).invalidate();
    }

    Preview(b b1)
    {
        a = b1;
        super();
    }
}
