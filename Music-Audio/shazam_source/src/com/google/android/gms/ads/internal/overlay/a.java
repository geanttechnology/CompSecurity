// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            AdLauncherIntentInfoParcel, n

public final class a
{

    public a()
    {
    }

    public static boolean a(Context context, AdLauncherIntentInfoParcel adlauncherintentinfoparcel, n n1)
    {
        if (adlauncherintentinfoparcel == null)
        {
            b.a(5);
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(adlauncherintentinfoparcel.c))
        {
            b.a(5);
            return false;
        }
        if (!TextUtils.isEmpty(adlauncherintentinfoparcel.d))
        {
            intent.setDataAndType(Uri.parse(adlauncherintentinfoparcel.c), adlauncherintentinfoparcel.d);
        } else
        {
            intent.setData(Uri.parse(adlauncherintentinfoparcel.c));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(adlauncherintentinfoparcel.e))
        {
            intent.setPackage(adlauncherintentinfoparcel.e);
        }
        if (!TextUtils.isEmpty(adlauncherintentinfoparcel.f))
        {
            String as[] = adlauncherintentinfoparcel.f.split("/", 2);
            if (as.length < 2)
            {
                (new StringBuilder("Could not parse component name from open GMSG: ")).append(adlauncherintentinfoparcel.f);
                b.a(5);
                return false;
            }
            intent.setClassName(as[0], as[1]);
        }
        adlauncherintentinfoparcel = adlauncherintentinfoparcel.g;
        if (!TextUtils.isEmpty(adlauncherintentinfoparcel))
        {
            int i;
            try
            {
                i = Integer.parseInt(adlauncherintentinfoparcel);
            }
            // Misplaced declaration of an exception variable
            catch (AdLauncherIntentInfoParcel adlauncherintentinfoparcel)
            {
                b.a(5);
                i = 0;
            }
            intent.addFlags(i);
        }
        try
        {
            (new StringBuilder("Launching an intent: ")).append(intent.toURI());
            b.a(2);
            context.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.getMessage();
            b.a(5);
            return false;
        }
        if (n1 == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        n1.l();
        return true;
    }
}
