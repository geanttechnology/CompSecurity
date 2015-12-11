// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.target.mothership.cache.f;

// Referenced classes of package com.target.mothership.cache.list:
//            g

static final class e extends f
{

    public void apply(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.execSQL("ALTER TABLE list_summary RENAME TO list_summary_backup");
_L7:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        sqlitedatabase.execSQL("CREATE TABLE list_summary (`mChannel` VARCHAR , `mDescription` VARCHAR , `mGuestId` VARCHAR , `mId` VARCHAR , `mLastModifiedDate` VARCHAR , `mLastModifiedUserId` VARCHAR , `mListToken` VARCHAR , `mLocation` VARCHAR , `mOrganization` VARCHAR , `mServerLastModifiedDate` VARCHAR , `mTitle` VARCHAR , `mTitleResourceId` VARCHAR , `mListPosition` BIGINT , `mIsDefaultList` SMALLINT , `mIsDeleting` SMALLINT , `mIsDirty` SMALLINT , `mItemCount` INTEGER , `mKey` INTEGER PRIMARY KEY AUTOINCREMENT )");
_L8:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        sqlitedatabase.execSQL("INSERT INTO list_summary (mChannel, mDescription, mGuestId, mId, mLastModifiedDate, mLastModifiedUserId, mListToken, mLocation, mOrganization, mTitle, mTitleResourceId, mListPosition, mIsDefaultList, mItemCount, mKey, mIsDirty, mIsDeleting) SELECT mChannel, mDescription, mGuestId, mId, strftime('%Y-%m-%d %H:%M:%S.000000', datetime(mLastModifiedDate/1000, 'unixepoch')), mLastModifiedUserId, mListToken, mLocation, mOrganization, mTitle, mTitleResourceId, mListPosition, mIsDefaultList, mItemCount, mKey, 0, 0 FROM list_summary_backup");
_L9:
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        sqlitedatabase.execSQL("DROP TABLE list_summary_backup");
_L10:
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
_L2:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "ALTER TABLE list_summary RENAME TO list_summary_backup");
          goto _L7
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
_L4:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE list_summary (`mChannel` VARCHAR , `mDescription` VARCHAR , `mGuestId` VARCHAR , `mId` VARCHAR , `mLastModifiedDate` VARCHAR , `mLastModifiedUserId` VARCHAR , `mListToken` VARCHAR , `mLocation` VARCHAR , `mOrganization` VARCHAR , `mServerLastModifiedDate` VARCHAR , `mTitle` VARCHAR , `mTitleResourceId` VARCHAR , `mListPosition` BIGINT , `mIsDefaultList` SMALLINT , `mIsDeleting` SMALLINT , `mIsDirty` SMALLINT , `mItemCount` INTEGER , `mKey` INTEGER PRIMARY KEY AUTOINCREMENT )");
          goto _L8
_L6:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "INSERT INTO list_summary (mChannel, mDescription, mGuestId, mId, mLastModifiedDate, mLastModifiedUserId, mListToken, mLocation, mOrganization, mTitle, mTitleResourceId, mListPosition, mIsDefaultList, mItemCount, mKey, mIsDirty, mIsDeleting) SELECT mChannel, mDescription, mGuestId, mId, strftime('%Y-%m-%d %H:%M:%S.000000', datetime(mLastModifiedDate/1000, 'unixepoch')), mLastModifiedUserId, mListToken, mLocation, mOrganization, mTitle, mTitleResourceId, mListPosition, mIsDefaultList, mItemCount, mKey, 0, 0 FROM list_summary_backup");
          goto _L9
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE list_summary_backup");
          goto _L10
    }

    public void revert(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L2; else goto _L1
_L1:
        sqlitedatabase.execSQL("ALTER TABLE list_summary rename to list_summary_backup");
_L7:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L4; else goto _L3
_L3:
        sqlitedatabase.execSQL("CREATE TABLE `list_summary` (`mChannel` VARCHAR , `mDescription` VARCHAR , `mGuestId` VARCHAR , `mId` VARCHAR , `mLastModifiedDate` BIGINT , `mLastModifiedTs` VARCHAR , `mLastModifiedUserId` VARCHAR , `mListToken` VARCHAR , `mLocation` VARCHAR , `mMetadataLastModifiedTs` VARCHAR , `mMetadataLastModifiedUser` VARCHAR , `mOrganization` VARCHAR , `mTitle` VARCHAR , `mTitleResourceId` VARCHAR , `mListPosition` BIGINT , `mIsDefaultList` SMALLINT , `mItemCount` INTEGER , `mKey` INTEGER PRIMARY KEY AUTOINCREMENT )");
_L8:
        if (sqlitedatabase instanceof SQLiteDatabase) goto _L6; else goto _L5
_L5:
        sqlitedatabase.execSQL("INSERT INTO list_summary (mChannel, mDescription, mGuestId, mId, mLastModifiedDate, mLastModifiedUserId, mListToken, mLocation, mOrganization, mTitle, mTitleResourceId, mListPosition, mIsDefaultList, mItemCount, mKey) SELECT mChannel, mDescription, mGuestId, mId, mLastModifiedDate, mLastModifiedUserId, mListToken, mLocation, mOrganization, mTitle, mTitleResourceId, mListPosition, mIsDefaultList, mItemCount, mKey FROM list_summary_backup WHERE mIsDeleting = 0");
_L9:
        if (sqlitedatabase instanceof SQLiteDatabase)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        sqlitedatabase.execSQL("DROP TABLE list_summary_backup");
_L10:
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
_L2:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "ALTER TABLE list_summary rename to list_summary_backup");
          goto _L7
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
_L4:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE `list_summary` (`mChannel` VARCHAR , `mDescription` VARCHAR , `mGuestId` VARCHAR , `mId` VARCHAR , `mLastModifiedDate` BIGINT , `mLastModifiedTs` VARCHAR , `mLastModifiedUserId` VARCHAR , `mListToken` VARCHAR , `mLocation` VARCHAR , `mMetadataLastModifiedTs` VARCHAR , `mMetadataLastModifiedUser` VARCHAR , `mOrganization` VARCHAR , `mTitle` VARCHAR , `mTitleResourceId` VARCHAR , `mListPosition` BIGINT , `mIsDefaultList` SMALLINT , `mItemCount` INTEGER , `mKey` INTEGER PRIMARY KEY AUTOINCREMENT )");
          goto _L8
_L6:
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "INSERT INTO list_summary (mChannel, mDescription, mGuestId, mId, mLastModifiedDate, mLastModifiedUserId, mListToken, mLocation, mOrganization, mTitle, mTitleResourceId, mListPosition, mIsDefaultList, mItemCount, mKey) SELECT mChannel, mDescription, mGuestId, mId, mLastModifiedDate, mLastModifiedUserId, mListToken, mLocation, mOrganization, mTitle, mTitleResourceId, mListPosition, mIsDefaultList, mItemCount, mKey FROM list_summary_backup WHERE mIsDeleting = 0");
          goto _L9
        SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE list_summary_backup");
          goto _L10
    }

    e(int i)
    {
        super(i);
    }
}
