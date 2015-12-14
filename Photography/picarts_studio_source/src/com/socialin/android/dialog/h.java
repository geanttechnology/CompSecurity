// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.socialin.android.brushlib.project.a;
import java.io.File;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.dialog:
//            d, i

public final class h extends d
{

    public i a;
    public String b;

    public h()
    {
        setStyle(1, 0x7f0c0181);
    }

    static i a(h h1)
    {
        return h1.a;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300aa, viewgroup, false);
        if (!TextUtils.isEmpty(b))
        {
            m.b(layoutinflater).setText(b);
        }
        viewgroup = (EditText)layoutinflater.findViewById(0x7f100398);
        if (a != null)
        {
            bundle = a.a();
            if (bundle != null)
            {
                viewgroup.setText(bundle);
            }
        }
        layoutinflater.findViewById(0x7f100125).setOnClickListener(new android.view.View.OnClickListener(viewgroup) {

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

            
            {
                b = h.this;
                a = edittext;
                super();
            }
        });
        layoutinflater.findViewById(0x7f100395).setOnClickListener(new android.view.View.OnClickListener() {

            private h a;

            public final void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = h.this;
                super();
            }
        });
        return layoutinflater;
    }
}
