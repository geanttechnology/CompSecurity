// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Dialog;
import android.content.Intent;
import com.socialin.android.net.b;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class a
    implements b
{

    private SquareFitFragment a;

    public final void a(Intent intent)
    {
        if ("intent.action.download.complete".equals(intent.getAction()))
        {
            SquareFitFragment.L(a).dismiss();
            int i = intent.getIntExtra("download_status", -1);
            intent = intent.getStringExtra("download_file_path");
            if ((i == 1 || i == 2) && SquareFitFragment.M(a).equals(intent))
            {
                SquareFitFragment.N(a);
            }
        }
    }

    (SquareFitFragment squarefitfragment)
    {
        a = squarefitfragment;
        super();
    }
}
