// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.view.SvgCropView;
import myobfuscated.bk.a;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            z

final class a
    implements android.view..OnClickListener
{

    private z a;

    public final void onClick(View view)
    {
        int j = com.picsart.studio.editor.fragment.z.a(a).e.c;
        view = a;
        com.socialin.android.colorpicker.c c = z.b(a);
        int i = j;
        if (j == -256)
        {
            i = 0xff000000;
        }
        com.picsart.studio.editor.fragment.z.a(view, c, i);
    }

    iew(z z1)
    {
        a = z1;
        super();
    }
}
