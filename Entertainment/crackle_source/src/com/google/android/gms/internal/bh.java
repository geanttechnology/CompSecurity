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
//            ct, bj, bq

public final class bh
{

    public static boolean a(Context context, bj bj1, bq bq1)
    {
        if (bj1 == null)
        {
            ct.v("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(bj1.go))
        {
            ct.v("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(bj1.mimeType))
        {
            intent.setDataAndType(Uri.parse(bj1.go), bj1.mimeType);
        } else
        {
            intent.setData(Uri.parse(bj1.go));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(bj1.packageName))
        {
            intent.setPackage(bj1.packageName);
        }
        if (!TextUtils.isEmpty(bj1.gp))
        {
            String as[] = bj1.gp.split("/", 2);
            if (as.length < 2)
            {
                ct.v((new StringBuilder()).append("Could not parse component name from open GMSG: ").append(bj1.gp).toString());
                return false;
            }
            intent.setClassName(as[0], as[1]);
        }
        try
        {
            ct.u((new StringBuilder()).append("Launching an intent: ").append(intent).toString());
            context.startActivity(intent);
            bq1.z();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ct.v(context.getMessage());
            return false;
        }
        return true;
    }
}
