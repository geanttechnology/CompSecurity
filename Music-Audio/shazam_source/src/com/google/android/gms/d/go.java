// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            gm

public final class go
{

    final Context a;
    public String b;
    private final float c;
    private float d;
    private float e;
    private float f;
    private int g;

    public go(Context context)
    {
        g = 0;
        a = context;
        c = context.getResources().getDisplayMetrics().density;
    }

    public go(Context context, String s)
    {
        this(context);
        b = s;
    }

    private void a(int i, float f1, float f2)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        g = 0;
        d = f1;
        e = f2;
        f = f2;
_L4:
        return;
_L2:
        if (g == -1) goto _L4; else goto _L3
_L3:
        if (i != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f2 <= e) goto _L6; else goto _L5
_L5:
        e = f2;
_L8:
        if (e - f > 30F * c)
        {
            g = -1;
            return;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (f2 < f)
        {
            f = f2;
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (g == 0 || g == 2)
        {
            if (f1 - d >= 50F * c)
            {
                d = f1;
                g = g + 1;
            }
        } else
        if ((g == 1 || g == 3) && f1 - d <= -50F * c)
        {
            d = f1;
            g = g + 1;
        }
        if (g != 1 && g != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (f1 <= d) goto _L4; else goto _L9
_L9:
        d = f1;
        return;
        if (g != 2 || f1 >= d) goto _L4; else goto _L10
_L10:
        d = f1;
        return;
        if (i != 1 || g != 4) goto _L4; else goto _L11
_L11:
        Object obj;
        if (!(a instanceof Activity))
        {
            com.google.android.gms.ads.internal.util.client.b.a(4);
            return;
        }
        obj = b;
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L13; else goto _L12
_L12:
        obj = ((String) (obj)).replaceAll("\\+", "%20");
        Object obj1 = (new android.net.Uri.Builder()).encodedQuery(((String) (obj))).build();
        obj = new StringBuilder();
        p.e();
        obj1 = gm.a(((android.net.Uri) (obj1)));
        String s;
        for (Iterator iterator = ((Map) (obj1)).keySet().iterator(); iterator.hasNext(); ((StringBuilder) (obj)).append(s).append(" = ").append((String)((Map) (obj1)).get(s)).append("\n\n"))
        {
            s = (String)iterator.next();
        }

        obj = ((StringBuilder) (obj)).toString().trim();
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L13; else goto _L14
_L14:
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a);
        builder.setMessage(((CharSequence) (obj)));
        builder.setTitle("Ad Information");
        builder.setPositiveButton("Share", new android.content.DialogInterface.OnClickListener(((String) (obj))) {

            final String a;
            final go b;

            public final void onClick(DialogInterface dialoginterface, int j)
            {
                b.a.startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", a), "Share via"));
            }

            
            {
                b = go.this;
                a = s;
                super();
            }
        });
        builder.setNegativeButton("Close", new android.content.DialogInterface.OnClickListener() {

            final go a;

            public final void onClick(DialogInterface dialoginterface, int j)
            {
            }

            
            {
                a = go.this;
                super();
            }
        });
        builder.create().show();
        return;
_L13:
        obj = "No debug information";
        if (true) goto _L14; else goto _L15
_L15:
    }

    public final void a(MotionEvent motionevent)
    {
        int j = motionevent.getHistorySize();
        for (int i = 0; i < j; i++)
        {
            a(motionevent.getActionMasked(), motionevent.getHistoricalX(0, i), motionevent.getHistoricalY(0, i));
        }

        a(motionevent.getActionMasked(), motionevent.getX(), motionevent.getY());
    }
}
