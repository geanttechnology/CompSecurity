// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.picsart.studio.editor.view.SvgCropView;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.frame.a;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            z

final class b
    implements android.view..OnClickListener
{

    private ViewGroup a;
    private int b;
    private z c;

    public final void onClick(View view)
    {
        View view1 = a.getChildAt(z.c(c));
        if (view == view1)
        {
            return;
        }
        AnalyticUtils.getInstance(c.getActivity()).trackLocalAction((new StringBuilder("frameSvgCategory:svg selected ")).append(b).toString());
        com.picsart.studio.editor.fragment.z.a(c).setSvgRes(a.f[b]);
        if (view1 != null)
        {
            view1.setSelected(false);
        }
        view.setSelected(true);
        com.picsart.studio.editor.fragment.z.a(c, b);
    }

    iew(z z1, ViewGroup viewgroup, int i)
    {
        c = z1;
        a = viewgroup;
        b = i;
        super();
    }
}
