// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.cds:
//            CdsDatabaseHelper, CdsUtils

public final class AviaryCdsProvider extends ContentProvider
{

    private static final int DELETE_DOWNLOAD_ENTRY_BY_ID = 302;
    private static final int DOWNLOAD_PACK_ID = 48;
    private static final com.aviary.android.feather.common.log.LoggerFactory.Logger LOGGER;
    private static final int MATCH_ACTIVE_MESSAGE = 13;
    private static final int MATCH_ALL_MESSAGES = 2;
    private static final int MATCH_BULK_MESSAGE_AND_CONTENT = 402;
    private static final int MATCH_BULK_PACK_CONTENT_AND_ITEMS = 401;
    private static final int MATCH_BULK_SUBSCRIPTION_AND_CONTENT = 403;
    private static final int MATCH_FUTURE_MESSAGES = 22;
    private static final int MATCH_GET_PERMISSIONS = 55;
    private static final int MATCH_INSERT_DOWNLOAD_ENTRY = 103;
    private static final int MATCH_INSERT_MANIFEST_VERSION = 101;
    private static final int MATCH_LIST_CONTENT_AVAILABLE_BY_TYPE = 11;
    private static final int MATCH_LIST_CONTENT_AVAILABLE_FOR_RESTORE_BY_TYPE = 15;
    private static final int MATCH_LIST_CONTENT_HIDDEN_BY_TYPE = 19;
    private static final int MATCH_LIST_CONTENT_INSTALLED = 18;
    private static final int MATCH_LIST_CONTENT_INSTALLED_AND_PURCHASABLE_BY_TYPE = 20;
    private static final int MATCH_LIST_CONTENT_INSTALLED_BY_TYPE = 17;
    private static final int MATCH_MANIFEST_VERSION = 1;
    private static final int MATCH_MESSAGE_BY_IDENTIFIER = 3;
    private static final int MATCH_MESSAGE_CONTENT_BY_ID = 4;
    private static final int MATCH_NEXT_MESSAGE = 14;
    private static final int MATCH_PACKS_CONTENT = 43;
    private static final int MATCH_PACK_BY_ID = 5;
    private static final int MATCH_PACK_BY_IDENTIFIER = 6;
    private static final int MATCH_PACK_CONTENT_BY_ID = 8;
    private static final int MATCH_PACK_CONTENT_BY_IDENTIFIER = 9;
    private static final int MATCH_PACK_ITEM_BY_ID = 12;
    private static final int MATCH_PACK_ITEM_BY_IDENTIFIER = 21;
    private static final int MATCH_PACK_ITEM_LIST = 10;
    private static final int MATCH_PACK_LIST = 7;
    private static final int MATCH_REMOVE_MESSAGE = 301;
    private static final int MATCH_REMOVE_PACK_BY_ID = 303;
    private static final int MATCH_REPLACE_PERMISSIONS = 104;
    private static final int MATCH_STORE_FEATURED = 56;
    private static final int MATCH_STORE_FEATURED_BANNERS = 57;
    private static final int MATCH_SUBSCRIPTION_AND_CONTENT_LIST = 69;
    private static final int MATCH_SUBSCRIPTION_BY_IDENTIFIER = 66;
    private static final int MATCH_SUBSCRIPTION_CONTENT_BY_IDENTIFIER = 68;
    private static final int MATCH_SUBSCRIPTION_LIST = 67;
    private static final int MATCH_SUBSCRIPTION_PURCHASED_BY_TYPE = 65;
    private static final int MATCH_TRAY = 54;
    private static final int MATCH_UPDATE_CONTENT = 203;
    private static final int MATCH_UPDATE_CONTENT_MESSAGE = 202;
    private static final int MATCH_UPDATE_CONTENT_PURCHASED_STATUS = 207;
    private static final int MATCH_UPDATE_CONTENT_REQUEST_DOWNLOAD = 208;
    private static final int MATCH_UPDATE_MESSAGE = 201;
    private static final int MATCH_UPDATE_MESSAGE_VISITED = 209;
    private static final int MATCH_UPDATE_PACK_BY_ID = 204;
    private static final int MATCH_UPDATE_SUBSCRIPTION = 211;
    private static final int MATCH_UPDATE_SUBSCRIPTION_CONTENT = 212;
    private static final int MATCH_UPDATE_SUBSCRIPTION_PURCHASE_STATUS_BY_ID = 210;
    private static final int PACK_DOWNLOAD_STATUS = 47;
    private static final int UPDATE_DOWNLOAD_STATUS = 206;
    private static CdsDatabaseHelper mDbHelper;
    private static String mProviderBaseUri;
    private static UriMatcher mUriMatcher;

    public AviaryCdsProvider()
    {
    }

    public static String getProviderBaseUri(Context context)
    {
        if (mProviderBaseUri == null)
        {
            mProviderBaseUri = (new StringBuilder()).append("content://").append(PackageManagerUtils.getCDSProviderAuthority(context)).toString();
        }
        return mProviderBaseUri;
    }

    private void setupUriMatcher(Context context)
    {
        context = PackageManagerUtils.getCDSProviderAuthority(context);
        mUriMatcher = new UriMatcher(-1);
        mUriMatcher.addURI(context, "pack/identifier/*", 6);
        mUriMatcher.addURI(context, "pack/id/#", 5);
        mUriMatcher.addURI(context, "pack/list", 7);
        mUriMatcher.addURI(context, "pack/id/#/update", 204);
        mUriMatcher.addURI(context, "pack/id/#/remove", 303);
        mUriMatcher.addURI(context, "pack/content/list", 43);
        mUriMatcher.addURI(context, "pack/id/#/content/id/#/update", 203);
        mUriMatcher.addURI(context, "pack/id/#/content/id/#/updatePurchasedStatus/#", 207);
        mUriMatcher.addURI(context, "pack/id/#/requestDownload/#", 208);
        mUriMatcher.addURI(context, "pack/id/#/content", 8);
        mUriMatcher.addURI(context, "pack/identifier/*/content", 9);
        mUriMatcher.addURI(context, "pack/type/*/content/available/list", 11);
        mUriMatcher.addURI(context, "pack/type/*/content/hidden/list", 19);
        mUriMatcher.addURI(context, "pack/type/*/content/availableAndPurchasable/list", 20);
        mUriMatcher.addURI(context, "pack/type/*/content/restore/list", 15);
        mUriMatcher.addURI(context, "pack/type/*/content/installed/list", 17);
        mUriMatcher.addURI(context, "pack/content/installed/list", 18);
        mUriMatcher.addURI(context, "pack/#/item/list", 10);
        mUriMatcher.addURI(context, "pack/content/item/#", 12);
        mUriMatcher.addURI(context, "pack/*/item/*", 21);
        mUriMatcher.addURI(context, "subscription/purchased/type/*", 65);
        mUriMatcher.addURI(context, "subscription/update/id/#/updatePurchasedStatus/#", 210);
        mUriMatcher.addURI(context, "subscription/identifier/*", 66);
        mUriMatcher.addURI(context, "subscription/content/identifier/*", 68);
        mUriMatcher.addURI(context, "subscription/content/list", 69);
        mUriMatcher.addURI(context, "subscription/list", 67);
        mUriMatcher.addURI(context, "subscription/id/#/update", 211);
        mUriMatcher.addURI(context, "subscription/id/#/content/id/#/update", 212);
        mUriMatcher.addURI(context, "bulk/insertPackContentAndItems", 401);
        mUriMatcher.addURI(context, "bulk/insertMessageAndContent", 402);
        mUriMatcher.addURI(context, "bulk/insertSubscriptionAndContent", 403);
        mUriMatcher.addURI(context, "packTray/#/#/#/*", 54);
        mUriMatcher.addURI(context, "storeFeatured/#/#", 56);
        mUriMatcher.addURI(context, "storeFeatured/banners/#", 57);
        mUriMatcher.addURI(context, "manifestVersion", 1);
        mUriMatcher.addURI(context, "manifestVersion/insert", 101);
        mUriMatcher.addURI(context, "permissions/list", 55);
        mUriMatcher.addURI(context, "permissions/replace", 104);
        mUriMatcher.addURI(context, "message/list", 2);
        mUriMatcher.addURI(context, "message/active/*", 13);
        mUriMatcher.addURI(context, "message/next/*", 14);
        mUriMatcher.addURI(context, "message/future/*", 22);
        mUriMatcher.addURI(context, "message/identifier/*", 3);
        mUriMatcher.addURI(context, "message/id/#/content", 4);
        mUriMatcher.addURI(context, "message/id/#/remove", 301);
        mUriMatcher.addURI(context, "message/id/#/update", 201);
        mUriMatcher.addURI(context, "message/id/#/content/id/#/update", 202);
        mUriMatcher.addURI(context, "message/content/id/#/markasread/#", 209);
        mUriMatcher.addURI(context, "packDownloadStatus/#", 47);
        mUriMatcher.addURI(context, "insertPacksDownloadTable", 103);
        mUriMatcher.addURI(context, "downloadPackId/#", 48);
        mUriMatcher.addURI(context, "download/id/#/updateStatus/#", 206);
        mUriMatcher.addURI(context, "pack/#/delete_download_entry", 302);
    }

    public ContentProviderResult[] applyBatch(ArrayList arraylist)
    {
        SQLiteDatabase sqlitedatabase;
        ContentProviderResult acontentproviderresult[];
        acontentproviderresult = new ContentProviderResult[arraylist.size()];
        sqlitedatabase = mDbHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        arraylist = arraylist.iterator();
        int i = 0;
_L2:
        ContentProviderOperation contentprovideroperation;
        if (!arraylist.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        contentprovideroperation = (ContentProviderOperation)arraylist.next();
        int j = i + 1;
        acontentproviderresult[i] = contentprovideroperation.apply(this, acontentproviderresult, j);
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return acontentproviderresult;
        arraylist;
_L6:
        LOGGER.error("batch failed: %s", new Object[] {
            arraylist.getMessage()
        });
        sqlitedatabase.endTransaction();
        return acontentproviderresult;
        arraylist;
_L4:
        sqlitedatabase.endTransaction();
        throw arraylist;
        arraylist;
        if (true) goto _L4; else goto _L3
_L3:
        arraylist;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int bulkInsert(Uri uri, ContentValues acontentvalues[])
    {
        SQLiteDatabase sqlitedatabase;
        int i;
        int j;
        boolean flag1;
        j = 0;
        i = 0;
        flag1 = true;
        sqlitedatabase = CdsDatabaseHelper.getInstance(getContext()).getWritableDatabase();
        sqlitedatabase.beginTransaction();
        mUriMatcher.match(uri);
        JVM INSTR tableswitch 401 403: default 440
    //                   401 91
    //                   402 251
    //                   403 341;
           goto _L1 _L2 _L3 _L4
_L1:
        LOGGER.error("invalid uri");
        boolean flag = false;
_L10:
        if (!flag) goto _L6; else goto _L5
_L5:
        sqlitedatabase.setTransactionSuccessful();
_L6:
        sqlitedatabase.endTransaction();
        int k;
        long l;
        long l1;
        if (flag)
        {
            return i;
        } else
        {
            return 0;
        }
_L2:
        if (acontentvalues.length >= 3) goto _L8; else goto _L7
_L7:
        LOGGER.error("invalid size");
        sqlitedatabase.endTransaction();
        return 0;
_L8:
        l = CdsDatabaseHelper.insertValues("packs_table", acontentvalues[0], sqlitedatabase);
        if (l < 0L)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        uri = acontentvalues[1];
        uri.put("content_packId", Long.valueOf(l));
        l1 = CdsDatabaseHelper.insertValues("content_table", uri, sqlitedatabase);
        if (l1 < 0L)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        k = 2;
_L11:
        i = j;
        flag = flag1;
        if (k >= acontentvalues.length) goto _L10; else goto _L9
_L9:
        uri = acontentvalues[k];
        uri.put("item_packId", Long.valueOf(l));
        l1 = CdsDatabaseHelper.insertValues("items_table", uri, sqlitedatabase);
        if (l1 < 0L)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        j++;
        k++;
          goto _L11
_L3:
        i = acontentvalues.length;
        if (i != 2)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        l = CdsDatabaseHelper.insertValues("messages_table", acontentvalues[0], sqlitedatabase);
        if (l < 0L)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        uri = acontentvalues[1];
        uri.put("msgcnt_messageId", Long.valueOf(l));
        l = CdsDatabaseHelper.insertValues("messages_content_table", uri, sqlitedatabase);
        if (l < 0L)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        i = 1;
        flag = flag1;
          goto _L10
_L4:
        i = acontentvalues.length;
        if (i != 2)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        l = CdsDatabaseHelper.insertValues("subscription_table", acontentvalues[0], sqlitedatabase);
        if (l < 0L)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        uri = acontentvalues[1];
        uri.put("subscriptions_subscription_id", Long.valueOf(l));
        l = CdsDatabaseHelper.insertValues("subscriptions_content_table", uri, sqlitedatabase);
        if (l < 0L)
        {
            sqlitedatabase.endTransaction();
            return 0;
        }
        i = 1;
        flag = flag1;
          goto _L10
        uri;
        sqlitedatabase.endTransaction();
        throw uri;
    }

    Bundle clearAll(Bundle bundle)
    {
        if (!PackageManagerUtils.isDebugVersion(getContext()))
        {
            return null;
        } else
        {
            bundle = mDbHelper.getWritableDatabase();
            bundle.execSQL("DELETE FROM packs_table");
            bundle.execSQL("DELETE FROM version_table");
            bundle.execSQL("DELETE FROM content_table");
            bundle.execSQL("DELETE FROM content_table");
            bundle.execSQL("DELETE FROM messages_table");
            return null;
        }
    }

    public int delete(Uri uri, String s, String as[])
    {
        switch (mUriMatcher.match(uri))
        {
        default:
            return 0;

        case 303: 
            long l = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            return mDbHelper.deletePack(l);

        case 302: 
            long l1 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            mDbHelper.deletePackDownloadEntry(l1);
            return 0;

        case 301: 
            long l2 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            return mDbHelper.deleteMessage(l2);

        case 5: // '\005'
            long l3 = Long.parseLong(uri.getLastPathSegment());
            return mDbHelper.deletePackDownloadEntry(l3);
        }
    }

    Bundle dump(Bundle bundle)
    {
        Bundle bundle1 = new Bundle();
        if (bundle != null && bundle.containsKey("dst"))
        {
            bundle = new File(bundle.getString("dst"));
        } else
        {
            bundle = new File(Environment.getExternalStorageDirectory(), "aviarycds.sqlite");
        }
        bundle1.putBoolean("success", mDbHelper.dump(bundle));
        bundle1.putString("filename", bundle.getAbsolutePath());
        return bundle1;
    }

    public String getType(Uri uri)
    {
        return "vnd.android.cursor.item";
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        mUriMatcher.match(uri);
        JVM INSTR tableswitch 101 104: default 36
    //                   101 49
    //                   102 36
    //                   103 129
    //                   104 176;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        LOGGER.error("invalid uri");
_L6:
        return null;
_L2:
        long l;
        if (!contentvalues.containsKey("version_versionKey") || !contentvalues.containsKey("version_assetsBaseURL"))
        {
            LOGGER.error("missing version or asset url from values!");
            return null;
        }
        l = mDbHelper.insertValues("version_table", contentvalues);
        if (l <= -1L) goto _L6; else goto _L5
_L5:
        return CdsUtils.getContentUri(getContext(), (new StringBuilder()).append("manifestVersion/").append(l).toString());
_L3:
        l = mDbHelper.insertValues("packs_download_table", contentvalues);
        if (l <= -1L) goto _L6; else goto _L7
_L7:
        return CdsUtils.getContentUri(getContext(), (new StringBuilder()).append("downloadEntry/").append(l).toString());
_L4:
        long l1 = mDbHelper.replacePermissions(contentvalues);
        if (l1 > 0L)
        {
            return CdsUtils.getContentUri(getContext(), (new StringBuilder()).append("permissions/").append(l1).toString());
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public boolean onCreate()
    {
        LOGGER.info("onCreate");
        mDbHelper = CdsDatabaseHelper.getInstance(getContext());
        setupUriMatcher(getContext());
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        switch (mUriMatcher.match(uri))
        {
        case 16: // '\020'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 58: // ':'
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        default:
            LOGGER.error((new StringBuilder()).append("Unrecognized query: ").append(uri).toString());
            return null;

        case 43: // '+'
            return mDbHelper.getPacksContent(as, s, as1, s1);

        case 7: // '\007'
            return mDbHelper.getPacks(as, s, as1);

        case 9: // '\t'
            uri = (String)uri.getPathSegments().get(uri.getPathSegments().size() - 2);
            return mDbHelper.getPackContentByIdentifier(uri, as);

        case 8: // '\b'
            int i = Integer.parseInt((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            return mDbHelper.getPackContentById(i, as);

        case 10: // '\n'
            int j = Integer.parseInt((String)uri.getPathSegments().get(uri.getPathSegments().size() - 3));
            return mDbHelper.getPackItems(j, as);

        case 12: // '\f'
            int k = Integer.parseInt(uri.getLastPathSegment());
            return mDbHelper.getPackItemById(k, as);

        case 21: // '\025'
            s1 = (String)uri.getPathSegments().get(uri.getPathSegments().size() - 3);
            uri = uri.getLastPathSegment();
            return mDbHelper.getPackItemByIdentifier(s1, uri, as, s, as1);

        case 1: // '\001'
            return mDbHelper.getManifestVersion(as);

        case 6: // '\006'
            uri = uri.getLastPathSegment();
            return mDbHelper.getPackByIdentifier(uri, as);

        case 5: // '\005'
            long l2 = Long.parseLong(uri.getLastPathSegment());
            return mDbHelper.getPackById(l2, as);

        case 47: // '/'
            uri = uri.getLastPathSegment();
            return mDbHelper.getPackDownloadStatus(uri, as);

        case 48: // '0'
            uri = uri.getLastPathSegment();
            return mDbHelper.getPackIdOfDownload(uri, as);

        case 11: // '\013'
            uri = (String)uri.getPathSegments().get(uri.getPathSegments().size() - 4);
            return mDbHelper.getAvailablePacksByType(uri, as, s, as1, s1);

        case 19: // '\023'
            uri = (String)uri.getPathSegments().get(uri.getPathSegments().size() - 4);
            return mDbHelper.getHiddenPacksByType(uri, as, s, as1, s1);

        case 20: // '\024'
            uri = (String)uri.getPathSegments().get(uri.getPathSegments().size() - 4);
            return new MergeCursor(new Cursor[] {
                mDbHelper.getAvailablePacksByType(uri, as, s, as1, s1), mDbHelper.getHiddenPacksByType(uri, as, s, as1, s1)
            });

        case 17: // '\021'
            uri = (String)uri.getPathSegments().get(uri.getPathSegments().size() - 4);
            return mDbHelper.getInstalledPacksByType(uri, as, s1);

        case 18: // '\022'
            return mDbHelper.getInstalledPacks(as, s1);

        case 15: // '\017'
            uri = (String)uri.getPathSegments().get(uri.getPathSegments().size() - 4);
            return mDbHelper.getAvailableForRestorePacksByType(uri, as, s1);

        case 3: // '\003'
            uri = uri.getLastPathSegment();
            return mDbHelper.getMessageByIdentifier(uri, as);

        case 2: // '\002'
            return mDbHelper.getMessages(as, s, as1);

        case 13: // '\r'
            return mDbHelper.getActiveMessage(uri.getLastPathSegment(), as);

        case 14: // '\016'
            return mDbHelper.getNextMessage(uri.getLastPathSegment(), as);

        case 22: // '\026'
            return mDbHelper.getFutureMessages(uri.getLastPathSegment(), as);

        case 4: // '\004'
            long l3 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            return mDbHelper.getMessageContent(l3, as);

        case 54: // '6'
            as = uri.getLastPathSegment();
            int l = Integer.parseInt((String)uri.getPathSegments().get(uri.getPathSegments().size() - 4));
            int j1 = Integer.parseInt((String)uri.getPathSegments().get(uri.getPathSegments().size() - 3));
            int l1 = Integer.parseInt((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            uri = mDbHelper;
            boolean flag;
            boolean flag2;
            if (j1 != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (l1 != 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            return uri.getTray(as, l, flag, flag2);

        case 56: // '8'
            int i1 = Integer.parseInt(uri.getLastPathSegment());
            int k1 = Integer.parseInt((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            uri = mDbHelper;
            boolean flag1;
            if (k1 > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            return uri.getFeatured(flag1, i1);

        case 57: // '9'
            return mDbHelper.getFeaturedBanners(Integer.parseInt(uri.getLastPathSegment()));

        case 55: // '7'
            return mDbHelper.getPermissions(as);

        case 65: // 'A'
            uri = uri.getLastPathSegment();
            return mDbHelper.getPurchasedSubscriptionByType(uri);

        case 66: // 'B'
            uri = uri.getLastPathSegment();
            return mDbHelper.getSubscriptionByIdentifier(uri);

        case 67: // 'C'
            return mDbHelper.getSubscriptions(as, s, as1, s1);

        case 68: // 'D'
            uri = uri.getLastPathSegment();
            return mDbHelper.getSubscriptionContentByIdentifier(uri, as);

        case 69: // 'E'
            return mDbHelper.getSubscriptionsAndContent(as, s, as1, s1);
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        switch (mUriMatcher.match(uri))
        {
        case 205: 
        default:
            LOGGER.error("invalid uri");
            return 0;

        case 206: 
            long l1 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 3));
            int i = Integer.parseInt(uri.getLastPathSegment());
            return mDbHelper.updateDownloadStatus(l1, i);

        case 204: 
            long l2 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            return mDbHelper.updatePack(l2, contentvalues);

        case 203: 
            long l3 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            long l11 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 5));
            return mDbHelper.updatePackContent(l11, l3, contentvalues);

        case 201: 
            long l4 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            return mDbHelper.updateMessage(l4, contentvalues);

        case 202: 
            long l5 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 5));
            long l12 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            return mDbHelper.updateMessageContent(l5, l12, contentvalues);

        case 209: 
            long l6 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 3));
            int j = Integer.parseInt(uri.getLastPathSegment());
            return mDbHelper.setMessageasVisited(l6, j);

        case 207: 
            long l7 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 3));
            long l13 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 6));
            int k = Integer.parseInt(uri.getLastPathSegment());
            uri = null;
            if (contentvalues != null)
            {
                uri = contentvalues.getAsString("content_contentPath");
            }
            return mDbHelper.updatePackContentPurchasedStatus(l13, l7, k, uri);

        case 208: 
            long l8 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 3));
            int l = Integer.parseInt(uri.getLastPathSegment());
            return mDbHelper.updatePackContentRequestDownloadStatus(l8, l);

        case 210: 
            int i1 = Integer.parseInt((String)uri.getPathSegments().get(uri.getPathSegments().size() - 3));
            int j1 = Integer.parseInt(uri.getLastPathSegment());
            return mDbHelper.updateSubscriptionPurchasedStatus(i1, j1);

        case 211: 
            long l9 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            return mDbHelper.updateSubscription(l9, contentvalues);

        case 212: 
            long l10 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 2));
            long l14 = Long.parseLong((String)uri.getPathSegments().get(uri.getPathSegments().size() - 5));
            return mDbHelper.updateSubscriptionContent(l14, l10, contentvalues);
        }
    }

    Bundle updateMessageAndContent(Bundle bundle)
    {
        Bundle bundle1;
        ContentValues contentvalues;
        ContentValues contentvalues1;
        long l;
        long l1;
        if (bundle == null || !bundle.containsKey("messageValues") || !bundle.containsKey("messageContentValues") || !bundle.containsKey("messageId") || !bundle.containsKey("messageContentId"))
        {
            break MISSING_BLOCK_LABEL_183;
        }
        bundle1 = new Bundle();
        contentvalues = (ContentValues)bundle.getParcelable("messageValues");
        contentvalues1 = (ContentValues)bundle.getParcelable("messageContentValues");
        l = bundle.getLong("messageId");
        l1 = bundle.getLong("messageContentId");
        bundle = CdsDatabaseHelper.getInstance(getContext()).getWritableDatabase();
        bundle.beginTransaction();
        int j = mDbHelper.updateMessage(l, contentvalues, bundle);
        int i;
        i = j;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        j = mDbHelper.updateMessageContent(l, l1, contentvalues1, bundle);
        i = j;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        bundle.setTransactionSuccessful();
        i = j;
        bundle.endTransaction();
        bundle1.putInt("count", i);
        return bundle1;
        Exception exception;
        exception;
        bundle.endTransaction();
        throw exception;
        LOGGER.warn("[updateMessageAndContent] missing content");
        return null;
    }

    Bundle updatePackAndContent(Bundle bundle)
    {
        Bundle bundle1;
        ContentValues contentvalues;
        ContentValues contentvalues1;
        long l;
        long l1;
        if (bundle == null || !bundle.containsKey("packValues") || !bundle.containsKey("contentValues") || !bundle.containsKey("packId") || !bundle.containsKey("contentId"))
        {
            break MISSING_BLOCK_LABEL_183;
        }
        bundle1 = new Bundle();
        contentvalues = (ContentValues)bundle.getParcelable("packValues");
        contentvalues1 = (ContentValues)bundle.getParcelable("contentValues");
        l = bundle.getLong("packId");
        l1 = bundle.getLong("contentId");
        bundle = CdsDatabaseHelper.getInstance(getContext()).getWritableDatabase();
        bundle.beginTransaction();
        int j = mDbHelper.updatePack(l, contentvalues, bundle);
        int i;
        i = j;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        j = mDbHelper.updatePackContent(l, l1, contentvalues1, bundle);
        i = j;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        bundle.setTransactionSuccessful();
        i = j;
        bundle.endTransaction();
        bundle1.putInt("count", i);
        return bundle1;
        Exception exception;
        exception;
        bundle.endTransaction();
        throw exception;
        LOGGER.warn("[updatePacksAndContents] missing content");
        return null;
    }

    static 
    {
        LOGGER = LoggerFactory.getLogger(com/aviary/android/feather/cds/AviaryCdsProvider.getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
