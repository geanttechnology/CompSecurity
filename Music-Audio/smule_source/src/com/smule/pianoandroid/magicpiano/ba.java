// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smule.android.d.u;
import com.smule.android.network.managers.a;
import com.smule.android.network.models.f;
import com.smule.pianoandroid.utils.j;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            MagicApplication

public class ba extends RelativeLayout
{

    TextView a;
    TextView b;
    TextView c;
    LinearLayout d;
    protected Context e;

    public ba(Context context)
    {
        super(context);
        e = context;
    }

    public ba(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = context;
    }

    public void a(f f1, u u1, android.view.View.OnClickListener onclicklistener)
    {
        Object obj = MagicApplication.getInstance();
        Object obj1 = new HashMap();
        ((Map) (obj1)).put("unlockModalButtonColorOn", "#0c3ff7");
        ((Map) (obj1)).put("unlockModalButtonColorOff", "#187efe");
        ((Map) (obj1)).put("freeTrialKey", ((Context) (obj)).getString(0x7f0c0297));
        obj1 = com.smule.android.network.managers.a.a().a("piandroid.purchasePage", "layout", ((Map) (obj1)));
        if (((Map) (obj1)).size() > 0)
        {
            d.setBackgroundDrawable(j.a((String)((Map) (obj1)).get("unlockModalButtonColorOn"), (String)((Map) (obj1)).get("unlockModalButtonColorOff")));
        }
        a.setText(f1.modalLabelKey);
        if (f1.trial)
        {
            a.setText(f1.modalTrialLabelKey);
            b.setVisibility(0);
            b.setText(MessageFormat.format(f1.trialDescriptionKey, new Object[] {
                u1.b()
            }));
        } else
        {
            b.setVisibility(8);
        }
        obj = c;
        if (f1.trial)
        {
            f1 = (String)((Map) (obj1)).get("freeTrialKey");
        } else
        {
            f1 = u1.b();
        }
        ((TextView) (obj)).setText(f1);
        setOnClickListener(onclicklistener);
    }
}
