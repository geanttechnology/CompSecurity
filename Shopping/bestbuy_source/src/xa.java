// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.do;

public final class xa
{

    public static boolean a(Context context, do do1, xj xj1)
    {
        if (do1 == null)
        {
            acb.e("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(do1.c))
        {
            acb.e("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(do1.d))
        {
            intent.setDataAndType(Uri.parse(do1.c), do1.d);
        } else
        {
            intent.setData(Uri.parse(do1.c));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(do1.e))
        {
            intent.setPackage(do1.e);
        }
        if (!TextUtils.isEmpty(do1.f))
        {
            String as[] = do1.f.split("/", 2);
            if (as.length < 2)
            {
                acb.e((new StringBuilder()).append("Could not parse component name from open GMSG: ").append(do1.f).toString());
                return false;
            }
            intent.setClassName(as[0], as[1]);
        }
        try
        {
            acb.d((new StringBuilder()).append("Launching an intent: ").append(intent).toString());
            context.startActivity(intent);
            xj1.r();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            acb.e(context.getMessage());
            return false;
        }
        return true;
    }
}
