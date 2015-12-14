// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.tools;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.picsart.studio.PicsartContext;
import com.socialin.android.util.Utils;
import com.socialin.android.util.n;
import com.socialin.android.util.w;

// Referenced classes of package com.socialin.android.photo.tools:
//            ResizeDialogActivity

final class b
    implements android.view.izeDialogActivity._cls5
{

    private EditText a;
    private EditText b;
    private ResizeDialogActivity c;

    public final void onClick(View view)
    {
        boolean flag = true;
        if (!a.getText().toString().equals("") && !b.getText().toString().equals(""))
        {
            int i = Integer.parseInt(b.getText().toString());
            int j = Integer.parseInt(a.getText().toString());
            if (i >= 50 && j >= 50)
            {
                if (i == ResizeDialogActivity.c(c) && j == ResizeDialogActivity.b(c))
                {
                    c.setResult(0);
                    c.finish();
                } else
                if (i * j <= PicsartContext.a())
                {
                    view = new Intent();
                    view.putExtra("width", i);
                    view.putExtra("height", j);
                    c.setResult(-1, view);
                    c.finish();
                } else
                {
                    view = w.a(new n(i, j), PicsartContext.a());
                    view = (new StringBuilder()).append(c.getResources().getString(0x7f080567, new Object[] {
                        Integer.valueOf(Math.round(PicsartContext.a() / 0x100000))
                    })).append(" (").append(((n) (view)).a).append("x").append(((n) (view)).b).append(")").toString();
                    Utils.c(c, view);
                }
            } else
            {
                view = c.getResources().getString(0x7f080566);
                Utils.c(c, view);
            }
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            c.setResult(0);
            c.finish();
        }
    }

    (ResizeDialogActivity resizedialogactivity, EditText edittext, EditText edittext1)
    {
        c = resizedialogactivity;
        a = edittext;
        b = edittext1;
        super();
    }
}
