// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

// Referenced classes of package co.vine.android.util:
//            BuildUtil, CrashUtil

public class ContactsHelper
    implements android.support.v4.app.LoaderManager.LoaderCallbacks
{
    private static class ContactCursorLoader extends CursorLoader
    {

        public Cursor loadInBackground()
        {
            Cursor cursor;
            try
            {
                cursor = super.loadInBackground();
            }
            catch (Throwable throwable)
            {
                CrashUtil.logException(throwable);
                return null;
            }
            return cursor;
        }

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        public ContactCursorLoader(Context context, Uri uri, String as[], String s, String as1[], String s1)
        {
            super(context, uri, as, s, as1, s1);
        }
    }

    public static interface ContactHelperListener
    {

        public abstract void onEmailLoaded(String s);

        public abstract void onNameLoaded(String s);

        public abstract void onPhoneNumberLoaded(String s);
    }

    private static interface ProfileQuery
    {

        public static final int INDEX_MIME_TYPE = 2;
        public static final int INDEX_PHONE_NUMBER = 1;
        public static final String PROJECTION[] = {
            "_id", "data1", "mimetype"
        };

    }


    private static final String GOOGLE_ACCOUNT = "com.google";
    private static final int LOADER_ID_CONTACTS_DATA = 2;
    private static final int LOADER_ID_CONTACTS_PROFILE = 1;
    private Fragment mFragment;
    private ContactHelperListener mListener;

    public ContactsHelper(Fragment fragment, ContactHelperListener contacthelperlistener)
    {
        mFragment = fragment;
        mListener = contacthelperlistener;
    }

    public static void loadContacts(Fragment fragment, ContactHelperListener contacthelperlistener)
    {
        (new ContactsHelper(fragment, contacthelperlistener)).init();
    }

    public void init()
    {
        if (!BuildUtil.isExplore())
        {
            LoaderManager loadermanager = mFragment.getLoaderManager();
            loadermanager.initLoader(1, null, this);
            loadermanager.initLoader(2, null, this);
            Account aaccount[] = AccountManager.get(mFragment.getActivity()).getAccountsByType("com.google");
            if (aaccount != null && aaccount.length > 0)
            {
                mListener.onEmailLoaded(aaccount[0].name);
            }
        }
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return new ContactCursorLoader(mFragment.getActivity(), android.provider.ContactsContract.Profile.CONTENT_URI, new String[] {
                "display_name"
            }, null, null, null);

        case 2: // '\002'
            return new ContactCursorLoader(mFragment.getActivity(), Uri.withAppendedPath(android.provider.ContactsContract.Profile.CONTENT_URI, "data"), ProfileQuery.PROJECTION, "mimetype=?", new String[] {
                "vnd.android.cursor.item/phone_v2"
            }, null);
        }
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        loader.getId();
        JVM INSTR tableswitch 1 2: default 28
    //                   1 29
    //                   2 68;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (cursor != null && cursor.moveToFirst())
        {
            loader = cursor.getString(cursor.getColumnIndex("display_name"));
            mListener.onNameLoaded(loader);
            return;
        }
          goto _L1
_L3:
        Object obj = null;
        loader = obj;
        if (cursor != null)
        {
            loader = obj;
            if (cursor.moveToFirst())
            {
                loader = obj;
                if ("vnd.android.cursor.item/phone_v2".equals(cursor.getString(2)))
                {
                    loader = cursor.getString(1);
                }
            }
        }
        cursor = loader;
        if (TextUtils.isEmpty(loader))
        {
            cursor = ((TelephonyManager)mFragment.getActivity().getSystemService("phone")).getLine1Number();
        }
        mListener.onPhoneNumberLoaded(cursor);
        return;
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }
}
