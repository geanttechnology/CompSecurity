// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.GalleryPermissionChecker;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.mixtape.account.AccountContextFactory;

public class SyncAccount
{

    private static final String TAG = com/amazon/gallery/thor/syncframework/SyncAccount.getName();

    public SyncAccount()
    {
    }

    public static Account getSyncAccount(Context context, String s, String s1)
    {
        s = AccountContextFactory.getContextForAccountId(context, s);
        String s2 = context.getResources().getString(0x7f0e0300);
        s = s.getSyncAccount(s2);
        context = (AccountManager)context.getSystemService("account");
        Account aaccount[] = context.getAccountsByType(s2);
        boolean flag = false;
        int j = aaccount.length;
        int i = 0;
        while (i < j) 
        {
            Account account = aaccount[i];
            if (flag || account.equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i++;
        }
        if (!flag)
        {
            if (!Api.isAtLeastMarshmallow() && !((GalleryPermissionChecker)ThorGalleryApplication.getBean(Keys.GALLERY_PERMISSION_CHECKER)).checkPermission("android.permission.AUTHENTICATE_ACCOUNTS"))
            {
                GLogger.e(TAG, "Failed to add account. Missing permissions.", new Object[0]);
                return null;
            }
            if (!context.addAccountExplicitly(s, null, null))
            {
                GLogger.e(TAG, "Failed to add account.", new Object[0]);
                return null;
            }
        }
        ContentResolver.setSyncAutomatically(s, s1, true);
        return s;
    }

}
