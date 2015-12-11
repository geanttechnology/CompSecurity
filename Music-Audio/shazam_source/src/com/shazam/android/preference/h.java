// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.preference;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.shazam.android.activities.streaming.b;
import com.shazam.i.b.ai.e;
import com.shazam.i.b.g.b.a;

// Referenced classes of package com.shazam.android.preference:
//            i, j

public final class h
    implements android.content.DialogInterface.OnCancelListener, i
{

    private final Resources a;
    private Activity b;

    public h(Resources resources)
    {
        a = resources;
    }

    public final AlertDialog a(Activity activity, b b1, b b2)
    {
        b = activity;
        String s = a.getString(b2.d);
        String s1 = a.getString(b1.d);
        b1 = new j(activity, b1, b2.c, e.a(), e.b(), com.shazam.i.b.g.b.a.a());
        activity = new android.app.AlertDialog.Builder(activity);
        activity.setTitle(a.getString(0x7f090132, new Object[] {
            s1
        }));
        activity.setMessage(a.getString(0x7f090131, new Object[] {
            s, s1
        }));
        activity.setPositiveButton(a.getString(0x7f090130, new Object[] {
            s
        }), b1);
        activity.setNegativeButton(0x7f09004e, b1);
        activity.setOnCancelListener(this);
        return activity.create();
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        b.finish();
    }
}
