// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.socialin.android.brushlib.project.a;
import java.io.File;

// Referenced classes of package com.socialin.android.dialog:
//            h, i

final class a
    implements android.view..OnClickListener
{

    private EditText a;
    private h b;

    public final void onClick(View view)
    {
        boolean flag;
        flag = false;
        view = a.getText().toString();
        if (com.socialin.android.dialog.h.a(b) == null) goto _L2; else goto _L1
_L1:
        i j;
        int k;
        int l;
        j = com.socialin.android.dialog.h.a(b);
        l = view.length();
        k = 0;
_L5:
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ".contains(String.valueOf(view.charAt(k)))) goto _L4; else goto _L3
_L3:
        Toast.makeText(j.c, 0x7f08039f, 1).show();
        k = ((flag) ? 1 : 0);
_L6:
        if (k != 0)
        {
            com.socialin.android.dialog.h.a(b).a(view);
            b.dismiss();
        }
_L2:
        return;
_L4:
        k++;
          goto _L5
        if (view.length() < 3)
        {
            Toast.makeText(j.c, j.c.getString(0x7f0803a1, new Object[] {
                Integer.valueOf(3)
            }), 0).show();
            k = ((flag) ? 1 : 0);
        } else
        if ((new File(a.c, view)).exists())
        {
            Toast.makeText(j.c, 0x7f0803a0, 0).show();
            k = ((flag) ? 1 : 0);
        } else
        {
            k = 1;
        }
          goto _L6
    }

    oject.a(h h1, EditText edittext)
    {
        b = h1;
        a = edittext;
        super();
    }
}
