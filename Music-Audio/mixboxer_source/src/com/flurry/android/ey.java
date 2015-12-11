// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.android.responses.AppCloudEnumSearchResultCompletionHandler;
import com.flurry.android.responses.AppCloudError;
import com.flurry.android.responses.AppCloudSearchResultCompletionHandler;

// Referenced classes of package com.flurry.android:
//            AppCloudSearch

final class ey
    implements AppCloudSearchResultCompletionHandler
{

    private AppCloudEnumSearchResultCompletionHandler gE;
    private int gF;
    private int gG;
    private boolean gH;
    private AppCloudSearch gq;

    ey(AppCloudSearch appcloudsearch, AppCloudEnumSearchResultCompletionHandler appcloudenumsearchresultcompletionhandler, int i, int j, boolean flag)
    {
        gq = appcloudsearch;
        gE = appcloudenumsearchresultcompletionhandler;
        gF = i;
        gG = j;
        gH = flag;
        super();
    }

    public final void onError(AppCloudError appclouderror)
    {
        if (gH && appclouderror.getErrorCode() == 404 && appclouderror.getErrorMessage().equals("Not Found"))
        {
            return;
        } else
        {
            gE.onError(appclouderror);
            return;
        }
    }

    public final void onOperationSucceed(Object aobj[])
    {
        boolean flag1 = gE.onOperationSucceed(aobj, gF);
        boolean flag;
        if (aobj.length >= gG - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag1 && flag)
        {
            AppCloudSearch.a(gq, gG, gF + 1, gE);
        }
    }
}
