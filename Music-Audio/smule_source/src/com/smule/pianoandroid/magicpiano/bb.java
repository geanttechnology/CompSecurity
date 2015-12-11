// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.smule.android.f.p;
import com.smule.android.network.managers.a;
import com.smule.pianoandroid.a.z;
import com.smule.pianoandroid.utils.q;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, n, PurchaseActivity_

public class bb extends ag
{

    private static final String f = com/smule/pianoandroid/magicpiano/n.getName();
    protected TextView a;
    protected Button b;
    protected Button c;
    protected String d;
    protected String e;

    public bb()
    {
    }

    public static void a(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = z.a().c();
        editor.putBoolean("SEEN_TRIALS_POPUP", flag);
        p.a(editor);
    }

    public static boolean d()
    {
        return z.a().b().getBoolean("SEEN_TRIALS_POPUP", false);
    }

    protected void a()
    {
        q.A();
        Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/PurchaseActivity_);
        intent.putExtra("DESIRED_SUBSCRIPTION", d);
        startActivity(intent);
        finish();
    }

    protected void b()
    {
        finish();
    }

    protected void c()
    {
        Object obj = new HashMap();
        ((Map) (obj)).put("freeTrialStartKey", getString(0x7f0c029b));
        ((Map) (obj)).put("freeTrialCancelKey", getString(0x7f0c0299));
        obj = com.smule.android.network.managers.a.a().a("piandroid.purchasePage", "layout", ((Map) (obj)));
        b.setText((CharSequence)((Map) (obj)).get("freeTrialStartKey"));
        c.setText((CharSequence)((Map) (obj)).get("freeTrialCancelKey"));
        if (TextUtils.isEmpty(d))
        {
            a.setText(MessageFormat.format(getString(0x7f0c029a), new Object[] {
                "$1.99"
            }));
            return;
        } else
        {
            a.setText(MessageFormat.format(getString(0x7f0c029a), new Object[] {
                e
            }));
            return;
        }
    }

}
