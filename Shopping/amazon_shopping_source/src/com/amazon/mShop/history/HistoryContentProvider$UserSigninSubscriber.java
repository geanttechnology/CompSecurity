// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.util.DBException;

// Referenced classes of package com.amazon.mShop.history:
//            HistoryContentProvider

private class mContext
    implements UserListener
{

    private Context mContext;
    final HistoryContentProvider this$0;

    public void userSignedIn(User user)
    {
        try
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("email", user.getFullName());
            mContext.getContentResolver().update(HistoryContentProvider.PRODUCT_URI, contentvalues, "email=?", new String[] {
                ""
            });
            mContext.getContentResolver().update(HistoryContentProvider.VISUAL_SEARCH_URI, contentvalues, "email=?", new String[] {
                ""
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (User user)
        {
            Log.i(HistoryContentProvider.access$000(), user.getMessage());
        }
    }

    public void userSignedOut()
    {
    }

    public void userUpdated(User user)
    {
    }

    (Context context)
    {
        this$0 = HistoryContentProvider.this;
        super();
        mContext = context;
    }
}
