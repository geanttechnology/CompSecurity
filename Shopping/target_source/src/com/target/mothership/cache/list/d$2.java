// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.target.mothership.cache.f;

// Referenced classes of package com.target.mothership.cache.list:
//            d

static final class e extends f
{

    public void apply(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.execSQL("ALTER TABLE list_item RENAME TO list_item_backup");
_L7:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        sqlitedatabase.execSQL("CREATE TABLE `list_item` (`mLastModifiedDate` VARCHAR , `mListId` VARCHAR , `mListItemId` VARCHAR , `mNote` VARCHAR , `mServerLastModifiedDate` VARCHAR , `mTcinString` VARCHAR , `mTitle` VARCHAR , `mDesiredQuantity` INTEGER , `mItemPosition` BIGINT , `mIsDeleting` SMALLINT , `mIsDirty` SMALLINT , `mKey` INTEGER PRIMARY KEY AUTOINCREMENT , `mListKey` INTEGER , `mPurchasedQuantity` INTEGER, `mIsCompleted` SMALLINT)");
_L8:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        sqlitedatabase.execSQL("INSERT INTO list_item (mLastModifiedDate, mListId, mListItemId, mNote, mTcinString, mTitle, mDesiredQuantity, mItemPosition, mKey, mListKey, mPurchasedQuantity, mIsDirty, mIsDeleting, mIsCompleted) SELECT mLastModifiedDate, mListId, mListItemId, mNote, mTcinString, mTitle, mDesiredQuantity, mItemPosition, mKey, mListKey, mPurchasedQuantity, mIsDirty, mIsDeleting, 0 FROM list_item_backup");
_L9:
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        sqlitedatabase.execSQL("DROP TABLE list_item_backup");
_L10:
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
_L2:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "ALTER TABLE list_item RENAME TO list_item_backup");
          goto _L7
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
_L4:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE `list_item` (`mLastModifiedDate` VARCHAR , `mListId` VARCHAR , `mListItemId` VARCHAR , `mNote` VARCHAR , `mServerLastModifiedDate` VARCHAR , `mTcinString` VARCHAR , `mTitle` VARCHAR , `mDesiredQuantity` INTEGER , `mItemPosition` BIGINT , `mIsDeleting` SMALLINT , `mIsDirty` SMALLINT , `mKey` INTEGER PRIMARY KEY AUTOINCREMENT , `mListKey` INTEGER , `mPurchasedQuantity` INTEGER, `mIsCompleted` SMALLINT)");
          goto _L8
_L6:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "INSERT INTO list_item (mLastModifiedDate, mListId, mListItemId, mNote, mTcinString, mTitle, mDesiredQuantity, mItemPosition, mKey, mListKey, mPurchasedQuantity, mIsDirty, mIsDeleting, mIsCompleted) SELECT mLastModifiedDate, mListId, mListItemId, mNote, mTcinString, mTitle, mDesiredQuantity, mItemPosition, mKey, mListKey, mPurchasedQuantity, mIsDirty, mIsDeleting, 0 FROM list_item_backup");
          goto _L9
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE list_item_backup");
          goto _L10
    }

    public void revert(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.execSQL("ALTER TABLE list_item RENAME TO list_item_backup");
_L7:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        sqlitedatabase.execSQL("CREATE TABLE `list_item` (`mLastModifiedDate` VARCHAR , `mListId` VARCHAR , `mListItemId` VARCHAR , `mNote` VARCHAR , `mServerLastModifiedDate` VARCHAR , `mTcinString` VARCHAR , `mTitle` VARCHAR , `mDesiredQuantity` INTEGER , `mItemPosition` BIGINT , `mIsDeleting` SMALLINT , `mIsDirty` SMALLINT , `mKey` INTEGER PRIMARY KEY AUTOINCREMENT , `mListKey` INTEGER , `mPurchasedQuantity` INTEGER )");
_L8:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        sqlitedatabase.execSQL("INSERT INTO list_item (mLastModifiedDate, mListId, mListItemId, mNote, mTcinString, mTitle, mDesiredQuantity, mItemPosition, mKey, mListKey, mPurchasedQuantity, mIsDirty, mIsDeleting) SELECT mLastModifiedDate, mListId, mListItemId, mNote, mTcinString, mTitle, mDesiredQuantity, mItemPosition, mKey, mListKey, mPurchasedQuantity, mIsDirty, mIsDeleting FROM list_item_backup WHERE mIsCompleted=0");
_L9:
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        sqlitedatabase.execSQL("DROP TABLE list_item_backup");
_L10:
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
_L2:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "ALTER TABLE list_item RENAME TO list_item_backup");
          goto _L7
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
_L4:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE `list_item` (`mLastModifiedDate` VARCHAR , `mListId` VARCHAR , `mListItemId` VARCHAR , `mNote` VARCHAR , `mServerLastModifiedDate` VARCHAR , `mTcinString` VARCHAR , `mTitle` VARCHAR , `mDesiredQuantity` INTEGER , `mItemPosition` BIGINT , `mIsDeleting` SMALLINT , `mIsDirty` SMALLINT , `mKey` INTEGER PRIMARY KEY AUTOINCREMENT , `mListKey` INTEGER , `mPurchasedQuantity` INTEGER )");
          goto _L8
_L6:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "INSERT INTO list_item (mLastModifiedDate, mListId, mListItemId, mNote, mTcinString, mTitle, mDesiredQuantity, mItemPosition, mKey, mListKey, mPurchasedQuantity, mIsDirty, mIsDeleting) SELECT mLastModifiedDate, mListId, mListItemId, mNote, mTcinString, mTitle, mDesiredQuantity, mItemPosition, mKey, mListKey, mPurchasedQuantity, mIsDirty, mIsDeleting FROM list_item_backup WHERE mIsCompleted=0");
          goto _L9
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE list_item_backup");
          goto _L10
    }

    e(int i)
    {
        super(i);
    }
}
