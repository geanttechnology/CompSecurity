// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.mShop.AmazonApplication;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.sso.AccountCookiesSyncManager;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.Util;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.contentprovider:
//            AIVGroverRecommendationsProvider, WidgetDatabaseHelper, HomeServiceCallWrapper

public class WidgetContentProvider extends ContentProvider
{

    private static final String MATRIX[] = {
        "locale"
    };
    private static final Map sFeaturedMatcher;
    private static final UriMatcher sUriMatcher;
    private AIVGroverRecommendationsProvider mAIVGroverRecommendationsProvider;

    public WidgetContentProvider()
    {
    }

    private String getAppendedSelection(String s, String s1)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("featuredCategory=\"").append(s).append("\"");
        if (!TextUtils.isEmpty(s1))
        {
            s = (new StringBuilder()).append(" AND (").append(s1).append(')').toString();
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }

    public static Intent getContentUpdatedIntent()
    {
        Intent intent = new Intent();
        intent.setAction("com.amazon.provider.CONTENT_UPDATE");
        intent.setDataAndType(Uri.parse("content://com.amazon.mShop.android.WidgetContentProvider"), "text/update");
        return intent;
    }

    public static void sendContentUpdatedIntent(Context context)
    {
        context.sendBroadcast(getContentUpdatedIntent());
    }

    public int delete(Uri uri, String s, String as[])
    {
        throw new UnsupportedOperationException();
    }

    public String getType(Uri uri)
    {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        throw new UnsupportedOperationException();
    }

    public boolean onCreate()
    {
        if (AndroidPlatform.getInstance() == null)
        {
            AmazonApplication.setUp(getContext().getApplicationContext());
        }
        mAIVGroverRecommendationsProvider = new AIVGroverRecommendationsProvider(getContext());
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        int i = sUriMatcher.match(uri);
        i;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 63
    //                   2 227
    //                   3 188;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown URI:").append(uri).toString());
_L2:
        uri = WidgetDatabaseHelper.getInstance(getContext()).getReadableDatabase();
        String s2 = (String)sFeaturedMatcher.get(Integer.valueOf(i));
        if (!Util.isEmpty(s2))
        {
            s = getAppendedSelection(s2, s);
        }
        uri = uri.query("mShop", as, s, as1, null, null, s1);
_L6:
        as = getContext().getApplicationContext();
        if (i == 1 && (uri == null || uri.getCount() == 0) && SSOUtil.getCurrentIdentityType() == IdentityType.CENTRAL_SSO_TYPE)
        {
            s = SSOUtil.getCurrentAccount(as);
            if (!Util.isEmpty(s))
            {
                AccountCookiesSyncManager.syncAndWait(as, false, true, s, false);
                HomeServiceCallWrapper.startHomeCall(as);
            }
        }
        return uri;
_L4:
        uri = getAppendedSelection((String)sFeaturedMatcher.get(Integer.valueOf(i)), s);
        uri = mAIVGroverRecommendationsProvider.getAIVItems(as, uri, as1, s1);
        continue; /* Loop/switch isn't completed */
_L3:
        uri = new MatrixCursor(MATRIX);
        uri.addRow(new String[] {
            AppLocale.getInstance().getCurrentLocale().getCountry()
        });
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        throw new UnsupportedOperationException();
    }

    static 
    {
        sUriMatcher = new UriMatcher(-1);
        sUriMatcher.addURI("com.amazon.mShop.android.WidgetContentProvider", "featured", 1);
        sUriMatcher.addURI("com.amazon.mShop.android.WidgetContentProvider", "locale", 2);
        sUriMatcher.addURI("com.amazon.mShop.android.WidgetContentProvider", "aiv_featured", 3);
        sFeaturedMatcher = new HashMap();
        sFeaturedMatcher.put(Integer.valueOf(1), "mshop_shoveler_item");
        sFeaturedMatcher.put(Integer.valueOf(3), "aiv_shoveler_item");
    }
}
