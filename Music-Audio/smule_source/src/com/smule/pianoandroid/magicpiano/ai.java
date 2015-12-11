// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import com.smule.android.network.models.ListingV2;
import com.smule.pianoandroid.utils.j;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            aj, ak

public class ai extends Dialog
{

    private static final String a = com/smule/pianoandroid/magicpiano/ai.getName();
    private View b;
    private View c;
    private ak d;

    public ai(Activity activity, ListingV2 listingv2, boolean flag, ak ak)
    {
        super(activity, 0x7f0d007f);
        requestWindowFeature(1);
        View view = activity.getLayoutInflater().inflate(0x7f030053, null, false);
        j.a(view, activity);
        setCancelable(true);
        setContentView(view);
        d = ak;
        b = view.findViewById(0x7f0a008b);
        b.setOnClickListener(new aj(this, listingv2, false, d));
        c = view.findViewById(0x7f0a008c);
        c.setOnClickListener(new aj(this, listingv2, true, d));
        view.findViewById(0x7f0a0063).setOnClickListener(new android.view.View.OnClickListener() {

            final ai a;

            public void onClick(View view1)
            {
                a.dismiss();
            }

            
            {
                a = ai.this;
                super();
            }
        });
    }

    public static ai a(Activity activity, ListingV2 listingv2, boolean flag, ak ak)
    {
        return new ai(activity, listingv2, flag, ak);
    }

}
