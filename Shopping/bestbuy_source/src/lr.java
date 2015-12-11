// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.bestbuy.android.api.lib.models.releasemgt.SupportedVersionsParent;
import com.bestbuy.android.api.lib.models.releasemgt.SupportedVersionsResponse;
import com.bestbuy.android.api.lib.models.releasemgt.SupportedVserionsData;

public class lr
{

    private static final String a = Thread.currentThread().getStackTrace()[2].getClass().getSimpleName();
    private String b;
    private SupportedVersionsResponse c;

    public lr()
    {
    }

    public boolean a(Context context)
    {
label0:
        {
label1:
            {
                if (c == null || c.getType() == 0 || c.getSi() == null || c.getSi().getResponse() == null || c.getSi().getResponse().getCurrentVersion() == null || c.getSi().getResponse().getCurrentVersion().equals(context.getResources().getString(0x7f080068)))
                {
                    break MISSING_BLOCK_LABEL_198;
                }
                boolean flag;
                try
                {
                    if (c.getType() != 100)
                    {
                        break label1;
                    }
                    nt nt1 = new nt(c.getSi().getResponse().getCurrentVersion());
                    b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                    kf.e(a, (new StringBuilder()).append("localVersionText-").append(b).toString());
                    flag = nt1.a(new nt(b));
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    kf.a(a, context);
                    return false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
        return false;
    }

    public boolean a(SupportedVersionsResponse supportedversionsresponse, Context context)
    {
        c = supportedversionsresponse;
        return a(context);
    }

    public boolean b(SupportedVersionsResponse supportedversionsresponse, Context context)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (supportedversionsresponse == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        boolean flag2;
        try
        {
            supportedversionsresponse = supportedversionsresponse.getSi();
        }
        // Misplaced declaration of an exception variable
        catch (SupportedVersionsResponse supportedversionsresponse)
        {
            kf.a(a, supportedversionsresponse);
            return false;
        }
        flag = flag1;
        if (supportedversionsresponse == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        supportedversionsresponse = supportedversionsresponse.getResponse();
        flag = flag1;
        if (supportedversionsresponse == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        supportedversionsresponse = new nt(supportedversionsresponse.getMinimumSupportedVersion());
        b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        flag2 = supportedversionsresponse.a(new nt(b));
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        return flag;
    }

    public lc c(SupportedVersionsResponse supportedversionsresponse, Context context)
    {
        if (supportedversionsresponse.getType() != 0 && supportedversionsresponse.getStoreLink() != null)
        {
            lc lc1 = new lc(context, "New Version Available", supportedversionsresponse.getSi().getResponse().getCurrentVersionMessage());
            lc1.a(supportedversionsresponse.getStoreLink());
            if (b == null)
            {
                try
                {
                    b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    b = "unknown";
                    kf.e(a, (new StringBuilder()).append("Could not get local version: ").append(context.getLocalizedMessage()).toString());
                }
            }
            lc1.a(supportedversionsresponse.getUpdateButtonTitle(), b, supportedversionsresponse.getSi().getResponse().getCurrentVersion());
            return lc1;
        } else
        {
            return null;
        }
    }

}
