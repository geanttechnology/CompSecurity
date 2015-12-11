// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

// Referenced classes of package com.google.android.gms.internal:
//            et, bj, cn

public final class ca
{

    public static boolean a(Context context, bj bj1, cn cn1)
    {
        if (bj1 == null)
        {
            et.d("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(bj1.c))
        {
            et.d("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(bj1.d))
        {
            intent.setDataAndType(Uri.parse(bj1.c), bj1.d);
        } else
        {
            intent.setData(Uri.parse(bj1.c));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(bj1.e))
        {
            intent.setPackage(bj1.e);
        }
        if (!TextUtils.isEmpty(bj1.f))
        {
            String as[] = bj1.f.split("/", 2);
            if (as.length < 2)
            {
                et.d((new StringBuilder("Could not parse component name from open GMSG: ")).append(bj1.f).toString());
                return false;
            }
            intent.setClassName(as[0], as[1]);
        }
        try
        {
            et.c((new StringBuilder("Launching an intent: ")).append(intent).toString());
            context.startActivity(intent);
            cn1.q();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            et.d(context.getMessage());
            return false;
        }
        return true;
    }
}
