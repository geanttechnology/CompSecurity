// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.os.CountDownTimer;
import android.widget.RelativeLayout;
import com.bestbuy.android.bbyobjects.BBYTextView;

// Referenced classes of package com.bestbuy.android.activities.home:
//            DODHomeCard

public class a extends CountDownTimer
{

    final DODHomeCard a;

    public void onFinish()
    {
        DODHomeCard.b(a).setVisibility(0);
        DODHomeCard.b(a).setClickable(true);
        DODHomeCard.a(a).setText("00:00:00");
        DODHomeCard.a(a, true);
    }

    public void onTick(long l)
    {
        DODHomeCard.a(a).setText(DODHomeCard.a(a, l));
    }

    (DODHomeCard dodhomecard, long l, long l1)
    {
        a = dodhomecard;
        super(l, l1);
    }
}
