// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import com.smule.android.network.models.ListingV2;
import com.smule.pianoandroid.utils.i;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ak

class aj
    implements android.view.View.OnClickListener
{

    private Dialog a;
    private ListingV2 b;
    private boolean c;
    private ak d;

    public aj(Dialog dialog, ListingV2 listingv2, boolean flag, ak ak)
    {
        a = dialog;
        b = listingv2;
        c = flag;
        d = ak;
    }

    static ListingV2 a(aj aj1)
    {
        return aj1.b;
    }

    static boolean b(aj aj1)
    {
        return aj1.c;
    }

    static ak c(aj aj1)
    {
        return aj1.d;
    }

    public void onClick(View view)
    {
        i.d().a(b, c);
        a.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final aj a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                aj.c(a).a(aj.a(a), aj.b(a));
            }

            
            {
                a = aj.this;
                super();
            }
        });
        a.dismiss();
    }
}
