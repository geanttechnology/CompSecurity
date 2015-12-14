// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import java.net.URISyntaxException;

public class KindleSearch
{

    private static final String TAG = com/amazon/gallery/framework/kindle/util/KindleSearch.getName();

    public KindleSearch()
    {
    }

    public static boolean launchSearch(Activity activity)
    {
        try
        {
            Intent intent = Intent.parseUri("intent:#Intent;action=android.search.action.GLOBAL_SEARCH;end", 3);
            intent.putExtra("domain", "library");
            intent.putExtra("category", "Photos");
            activity.startActivityForResult(intent, 86);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e(TAG, "Cannot launch Unified Search App");
            return false;
        }
        return true;
    }

}
