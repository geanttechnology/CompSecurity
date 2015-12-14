// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.DateTimeUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import java.io.File;

// Referenced classes of package com.aviary.android.feather.cds:
//            PermissionColumns, SubscriptionsColumns, SubscriptionsContentColumns, AviaryCdsDefaultContentLoader

final class CdsDatabaseHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "aviarycds.sqlite";
    private static final int DATABASE_VERSION = 8;
    private static final int INSERT_ERROR = -1;
    private static volatile CdsDatabaseHelper instance;
    private static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private static Context mContext;

    CdsDatabaseHelper(Context context)
    {
        super(context, "aviarycds.sqlite", null, 8);
        mContext = context;
    }

    public static CdsDatabaseHelper getInstance(Context context)
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/aviary/android/feather/cds/CdsDatabaseHelper;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new CdsDatabaseHelper(context);
        }
        com/aviary/android/feather/cds/CdsDatabaseHelper;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        context;
        com/aviary/android/feather/cds/CdsDatabaseHelper;
        JVM INSTR monitorexit ;
        throw context;
    }

    static String getPackFeaturedLabel(String s)
    {
        s = AviaryCds.PackType.fromString(s);
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType = new int[AviaryCds.PackType.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[AviaryCds.PackType.FRAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[AviaryCds.PackType.EFFECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[AviaryCds.PackType.STICKER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$cds$AviaryCds$PackType[AviaryCds.PackType.OVERLAY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (s != null)
        {
            switch (_cls1..SwitchMap.com.aviary.android.feather.cds.AviaryCds.PackType[s.ordinal()])
            {
            default:
                return "Featured";

            case 1: // '\001'
                return "Featured Frames";

            case 2: // '\002'
                return "Featured Effects";

            case 3: // '\003'
                return "Featured Stickers";

            case 4: // '\004'
                return "Featured Overlays";
            }
        } else
        {
            return "Featured";
        }
    }

    private int getTrayFeaturedCount(String s, boolean flag)
    {
        logger.info("getTrayFeaturedCount: packType: %s, freeOnly: %b", new Object[] {
            s, Boolean.valueOf(flag)
        });
        Object obj1 = (new StringBuilder()).append("SELECT COUNT(pack_id) as _count  FROM packs_table, content_table WHERE pack_id=content_packId AND pack_visible=1 AND pack_finishedDownloading=1");
        String s1;
        int i;
        if (flag)
        {
            s1 = " AND content_isFree=1";
        } else
        {
            s1 = "";
        }
        s1 = ((StringBuilder) (obj1)).append(s1).append(" AND ").append("content_iconPath").append(" NOT NULL").append(" AND ").append("content_purchased").append("=0").append(" AND ").append("pack_type").append("='").append(s).append("' ").append(" ORDER BY ").append("pack_displayOrder").append(" ASC").toString();
        obj1 = getReadableDatabase();
        s = null;
        if (obj1 != null)
        {
            s = ((SQLiteDatabase) (obj1)).rawQuery(s1, null);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_181;
        }
        i = s.getInt(0);
        IOUtils.closeSilently(s);
        return i;
        IOUtils.closeSilently(s);
_L2:
        return 0;
        Object obj;
        obj;
        logger.error((new StringBuilder()).append("handled: ").append(obj).toString());
        IOUtils.closeSilently(s);
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        IOUtils.closeSilently(s);
        throw obj;
    }

    private int getTrayInstalledCount(String s)
    {
        int i;
        i = 0;
        String s1 = (new StringBuilder()).append("SELECT count(pack_id) as _count FROM packs_table, content_table WHERE pack_id=content_packId AND pack_type='").append(s).append("'").append(" AND ").append("content_purchased").append("=1").append(" AND ").append("content_contentPath").append(" NOT NULL").toString();
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        s = null;
        if (sqlitedatabase != null)
        {
            s = sqlitedatabase.rawQuery(s1, null);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        if (!s.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        i = s.getInt(0);
        IOUtils.closeSilently(s);
        return i;
        IOUtils.closeSilently(s);
        return 0;
        Object obj;
        obj;
        logger.error((new StringBuilder()).append("handled: ").append(obj).toString());
        IOUtils.closeSilently(s);
        return 0;
        obj;
        IOUtils.closeSilently(s);
        throw obj;
    }

    static long insertValues(String s, ContentValues contentvalues, SQLiteDatabase sqlitedatabase)
    {
        long l = sqlitedatabase.insertWithOnConflict(s, null, contentvalues, 4);
        if (l == -1L)
        {
            logger.warn((new StringBuilder()).append("Error occurred inserting ").append(contentvalues.toString()).append(" into ").append(s).toString());
        }
        return l;
    }

    int delete(SQLiteDatabase sqlitedatabase, String s, String s1, String as[])
    {
        return sqlitedatabase.delete(s, s1, as);
    }

    int deleteMessage(long l)
    {
        int i = 0;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            i = sqlitedatabase.delete("messages_table", "msg_id=?", new String[] {
                String.valueOf(l)
            });
        }
        return i;
    }

    int deletePack(long l)
    {
        int i = 0;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            i = sqlitedatabase.delete("packs_table", "pack_id=?", new String[] {
                String.valueOf(l)
            });
        }
        return i;
    }

    int deletePackDownloadEntry(long l)
    {
        int i = 0;
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            i = sqlitedatabase.delete("packs_download_table", "download_packId=?", new String[] {
                String.valueOf(l)
            });
        }
        return i;
    }

    public boolean dump(File file)
    {
        logger.info("dump: %s", new Object[] {
            file
        });
        logger.warn("dump not available in release");
        return false;
    }

    Cursor getActiveMessage(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("messages_table JOIN messages_content_table ON (messages_table.msg_id = messages_content_table.msgcnt_messageId), packs_table, content_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "msg_type=? AND msgcnt_visited=0 AND msgcnt_contentPath NOT NULL AND (strftime('%s', datetime('now')) BETWEEN strftime('%s',msgcnt_beginDate) AND strftime('%s', msgcnt_endDate)) AND pack_id=content_packId AND pack_identifier=msgcnt_contentIdentifier AND content_purchased=0", new String[] {
                s
            }, null, null, "msgcnt_beginDate DESC");
        }
        return cursor;
    }

    Cursor getAvailableForRestorePacksByType(String s, String as[], String s1)
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table JOIN content_table ON (packs_table.pack_id = content_table.content_packId)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "(content_purchased=0 OR ifnull(length(content_contentPath), 0) < 1 ) AND pack_type=? AND pack_markedForDeletion=0", new String[] {
                s
            }, null, null, s1);
        }
        return cursor;
    }

    Cursor getAvailablePacksByType(String s, String as[], String s1, String as1[], String s2)
    {
        s1 = null;
        as1 = new SQLiteQueryBuilder();
        as1.setTables("packs_table JOIN content_table ON (packs_table.pack_id = content_table.content_packId)");
        as1.appendWhere("pack_finishedDownloading=1 AND ");
        as1.appendWhere((new StringBuilder()).append("pack_type='").append(s).append("' AND ").toString());
        as1.appendWhere("(pack_visible=1 OR (pack_visible=0 AND content_purchased=1)) AND ");
        as1.appendWhere("pack_markedForDeletion=0 ");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        s = s1;
        if (sqlitedatabase != null)
        {
            s = as1.query(sqlitedatabase, as, null, null, null, null, s2);
        }
        return s;
    }

    Context getContext()
    {
        return mContext;
    }

    public Cursor getFeatured(boolean flag, int i)
    {
        Cursor cursor = null;
        StringBuilder stringbuilder = new StringBuilder();
        if (flag)
        {
            stringbuilder.append("SELECT * FROM (  SELECT -1 as _id, '' as identifier, 'effect' as packType, 'Featured Effects' as displayName, '' as iconPath, '' as free, '' as purchased, '' as contentPath, 0 as type)");
            stringbuilder.append(" UNION ALL ");
        }
        String as[] = new String[4];
        as[0] = "effect";
        as[1] = "frame";
        as[2] = "sticker";
        as[3] = "overlay";
        for (int j = 0; j < as.length; j++)
        {
            stringbuilder.append((new StringBuilder()).append("SELECT * FROM (  SELECT -1 as _id, '' as identifier, '").append(as[j]).append("' as ").append("packType").append(", ").append("'").append(getPackFeaturedLabel(as[j])).append("' as ").append("displayName").append(", ").append("'' as ").append("iconPath").append(", ").append("'' as ").append("free").append(", ").append("'' as ").append("purchased").append(", ").append("'' as ").append("contentPath").append(", ").append(1).append(" as ").append("type").append(")").toString());
            stringbuilder.append(" UNION ALL ");
            stringbuilder.append((new StringBuilder()).append("SELECT * FROM ( SELECT pack_id as _id, pack_identifier as identifier, pack_type as packType, content_displayName as displayName, content_iconPath as iconPath, content_isFree as free, content_purchased as purchased, content_contentPath as contentPath, 2 as type FROM packs_table JOIN content_table ON ( packs_table.pack_id = content_table.content_packId) WHERE pack_type='").append(as[j]).append("'").append(" AND ").append("pack_visible").append("=1").append(" AND ").append("pack_finishedDownloading").append("=1").append(" AND ").append("pack_markedForDeletion").append("=0").append(" ORDER BY ").append("content_purchased").append(" ASC, ").append("pack_displayOrder").append(" ASC").append(" LIMIT 0, ").append(i).append(" )").toString());
            if (j + 1 < as.length)
            {
                stringbuilder.append(" UNION ALL ");
            }
        }

        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitedatabase.rawQuery(stringbuilder.toString(), null);
        }
        return cursor;
    }

    public Cursor getFeaturedBanners(int i)
    {
        if (i >= 1)
        {
            String s = (new StringBuilder()).append("SELECT pack_id as _id, pack_identifier as identifier, pack_type as packType, content_displayName as displayName, content_featureImageURL as featureURL, content_featureImageLocalPath as featureImageLocalPath, content_isFree as free, content_purchased as purchased, 0 as type FROM (SELECT * FROM content_table JOIN packs_table ON (packs_table.pack_id=content_table.content_packId) WHERE ifnull(length(content_featureImageURL), 0) > 0 ORDER BY content_isFree DESC, pack_displayOrder DESC, pack_id DESC ) GROUP BY pack_type LIMIT 0, ").append(i).toString();
            SQLiteDatabase sqlitedatabase = getReadableDatabase();
            if (sqlitedatabase != null)
            {
                return sqlitedatabase.rawQuery(s, null);
            }
        }
        return null;
    }

    Cursor getFutureMessages(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("messages_table JOIN messages_content_table ON (messages_table.msg_id = messages_content_table.msgcnt_messageId), packs_table, content_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "msg_type=? AND msgcnt_visited=0 AND ( strftime('%s', datetime('now')) BETWEEN strftime('%s',msgcnt_beginDate) AND strftime('%s', msgcnt_endDate) ) AND pack_id=content_packId AND pack_identifier=msgcnt_contentIdentifier AND content_purchased=0", new String[] {
                s
            }, null, null, "msgcnt_beginDate DESC");
        }
        return cursor;
    }

    Cursor getHiddenPacksByType(String s, String as[], String s1, String as1[], String s2)
    {
        as1 = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table JOIN content_table ON (packs_table.pack_id = content_table.content_packId)");
        sqlitequerybuilder.appendWhere("pack_finishedDownloading=1 AND ");
        sqlitequerybuilder.appendWhere((new StringBuilder()).append("pack_type='").append(s).append("' AND ").toString());
        s = new StringBuilder();
        s.append("pack_visible=0 AND content_purchased=0");
        if (s1 != null)
        {
            s.append(" AND ");
            s.append(s1);
        }
        s.append(" AND ");
        sqlitequerybuilder.appendWhere(s);
        sqlitequerybuilder.appendWhere("pack_markedForDeletion=0 ");
        s1 = getReadableDatabase();
        s = as1;
        if (s1 != null)
        {
            s = sqlitequerybuilder.query(s1, as, null, null, null, null, s2);
        }
        return s;
    }

    Cursor getInstalledPacks(String as[], String s)
    {
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table JOIN content_table ON (packs_table.pack_id = content_table.content_packId)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase == null)
        {
            return null;
        } else
        {
            return sqlitequerybuilder.query(sqlitedatabase, as, "content_purchased=1  AND pack_markedForDeletion=0 AND content_contentPath NOT NULL ", null, null, null, s);
        }
    }

    Cursor getInstalledPacksByType(String s, String as[], String s1)
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table JOIN content_table ON (packs_table.pack_id = content_table.content_packId)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "content_purchased=1  AND pack_type=? AND pack_markedForDeletion=0 AND content_contentPath NOT NULL ", new String[] {
                s
            }, null, null, s1);
        }
        return cursor;
    }

    Cursor getManifestVersion(String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("version_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, null, null, null, null, "version_id DESC");
        }
        return cursor;
    }

    Cursor getMessageByIdentifier(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("messages_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "msg_identifier=?", new String[] {
                s
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getMessageContent(long l, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("messages_table JOIN messages_content_table ON (messages_table.msg_id = messages_content_table.msgcnt_messageId)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "msg_id=?", new String[] {
                String.valueOf(l)
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getMessages(String as[], String s, String as1[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("messages_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, null, null, null);
        }
        return cursor;
    }

    Cursor getNextMessage(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("messages_table JOIN messages_content_table ON (messages_table.msg_id = messages_content_table.msgcnt_messageId), packs_table, content_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "msg_type=? AND msgcnt_visited=0 AND msgcnt_contentPath IS NULL AND ( strftime('%s', datetime('now')) BETWEEN strftime('%s',msgcnt_beginDate) AND strftime('%s', msgcnt_endDate) ) AND pack_id=content_packId AND pack_identifier=msgcnt_contentIdentifier AND content_purchased=0", new String[] {
                s
            }, null, null, "msgcnt_beginDate DESC");
        }
        return cursor;
    }

    Cursor getPackById(long l, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "pack_id=?", new String[] {
                String.valueOf(l)
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getPackByIdentifier(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "pack_identifier=?", new String[] {
                s
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getPackContentById(int i, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        sqlitequerybuilder.setTables("packs_table JOIN content_table ON (packs_table.pack_id = content_table.content_packId)");
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "packs_table.pack_id=?", new String[] {
                String.valueOf(i)
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getPackContentByIdentifier(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table JOIN content_table ON (packs_table.pack_id = content_table.content_packId)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "packs_table.pack_identifier=?", new String[] {
                s
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getPackDownloadStatus(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_download_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "download_packId=?", new String[] {
                String.valueOf(s)
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getPackIdOfDownload(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_download_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "download_refId=?", new String[] {
                String.valueOf(s)
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getPackItemById(long l, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("items_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "item_id=?", new String[] {
                String.valueOf(l)
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getPackItemByIdentifier(String s, String s1, String as[], String s2, String as1[])
    {
        Object obj = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table, content_table, items_table");
        sqlitequerybuilder.appendWhere("pack_id= content_packId AND item_packId=pack_id");
        sqlitequerybuilder.appendWhere(" AND pack_identifier=");
        sqlitequerybuilder.appendWhereEscapeString(s);
        sqlitequerybuilder.appendWhere(" AND item_identifier=");
        sqlitequerybuilder.appendWhereEscapeString(s1);
        s1 = getReadableDatabase();
        s = obj;
        if (s1 != null)
        {
            s = sqlitequerybuilder.query(s1, as, s2, as1, null, null, null);
        }
        return s;
    }

    Cursor getPackItems(int i, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table JOIN items_table ON (packs_table.pack_id = items_table.item_packId)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "pack_id=?", new String[] {
                String.valueOf(i)
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getPacks(String as[], String s, String as1[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, null, null, null);
        }
        return cursor;
    }

    Cursor getPacksContent(String as[], String s, String as1[], String s1)
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("packs_table JOIN content_table ON (packs_table.pack_id = content_table.content_packId)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, null, null, s1);
        }
        return cursor;
    }

    Cursor getPermissions(String as[])
    {
        Cursor cursor = null;
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitedatabase.query("permission_table", as, null, null, null, null, "perm_id DESC");
        }
        return cursor;
    }

    Cursor getPurchasedSubscriptionByType(String s)
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("subscriptions_content_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, null, (new StringBuilder()).append("subscriptions_content_purchased=1 AND subscriptions_content_unlock_type LIKE '%").append(s).append("%'").toString(), null, null, null, null);
        }
        return cursor;
    }

    Cursor getSubscriptionByIdentifier(String s)
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("subscription_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, null, "subscription_identifier=?", new String[] {
                s
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getSubscriptionContentByIdentifier(String s, String as[])
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("subscription_table JOIN subscriptions_content_table ON (subscription_table.subscription_id = subscriptions_content_table.subscriptions_subscription_id)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, "subscription_table.subscription_identifier=?", new String[] {
                s
            }, null, null, null);
        }
        return cursor;
    }

    Cursor getSubscriptions(String as[], String s, String as1[], String s1)
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("subscription_table");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, null, null, s1);
        }
        return cursor;
    }

    Cursor getSubscriptionsAndContent(String as[], String s, String as1[], String s1)
    {
        Cursor cursor = null;
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("subscription_table JOIN subscriptions_content_table ON (subscription_table.subscription_id = subscriptions_content_table.subscriptions_subscription_id)");
        SQLiteDatabase sqlitedatabase = getReadableDatabase();
        if (sqlitedatabase != null)
        {
            cursor = sqlitequerybuilder.query(sqlitedatabase, as, s, as1, null, null, s1);
        }
        return cursor;
    }

    Cursor getTray(String s, int i, boolean flag, boolean flag1)
    {
        int j = getTrayFeaturedCount(s, flag);
        int k = getTrayInstalledCount(s);
        Object obj;
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        boolean flag2;
        boolean flag3;
        if (j > 1 || k > 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (j > 0)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        logger.info("getTray, packType: %s, featuredCount: %d, freeOnly: %b, showItems: %b", new Object[] {
            s, Integer.valueOf(i), Boolean.valueOf(flag), Boolean.valueOf(flag1)
        });
        logger.log("availableFeatured: %d", new Object[] {
            Integer.valueOf(j)
        });
        logger.log("installedCount: %d", new Object[] {
            Integer.valueOf(k)
        });
        stringbuilder = new StringBuilder();
        if (flag2)
        {
            stringbuilder.append("SELECT -1 as _id, -1 as _order, '' as packagename, '' as identifier, 5 as type, '' as displayName, '' as path, '' as installDate, 0 as isFree, -1 as packId UNION ALL ");
        }
        stringbuilder1 = (new StringBuilder()).append(" SELECT * from ( SELECT * from (SELECT pack_id as _id, pack_displayOrder as _order, pack_identifier as packagename, pack_identifier as identifier, 1 as type, content_displayName as displayName, content_iconPath as path, content_installDate as installDate, content_isFree as isFree, pack_id as packId FROM packs_table, content_table WHERE pack_id=content_packId AND pack_visible=1 AND pack_finishedDownloading=1");
        if (flag)
        {
            obj = " AND content_isFree=1";
        } else
        {
            obj = "";
        }
        stringbuilder.append(stringbuilder1.append(((String) (obj))).append(" AND ").append("content_iconPath").append(" NOT NULL ").append(" AND ").append("content_purchased").append("=0 ").append(" AND ").append("pack_type").append("=? ").append(" ORDER BY ").append("pack_displayOrder").append(" ASC LIMIT ").append(i).append(" )").append(" ORDER BY ").append("_order").append(" DESC )").toString());
        if (flag3)
        {
            stringbuilder.append(" UNION ALL SELECT -1 as _id, -1 as _order, '' as packagename, '' as identifier, 3 as type, '' as displayName, '' as path, '' as installDate, 0 as isFree, -1 as packId");
        }
        stringbuilder.append(" UNION ALL SELECT * from (SELECT DISTINCT pack_id as _id, (pack_id * 10000) as _order, pack_identifier as packagename, pack_identifier as identifier, 2 as type, content_displayName as displayName, content_iconPath as path, content_installDate as installDate, content_isFree as isFree, pack_id as packId FROM packs_table, content_table, items_table WHERE pack_id=content_packId  AND pack_id=item_packId AND pack_type=?  AND content_purchased=1  AND content_contentPath NOT NULL");
        if (flag1)
        {
            stringbuilder.append(" UNION ALL SELECT item_id as _id, ((pack_id * 10000) + item_id ) as _order, pack_identifier as packagename, item_identifier as identifier, 0 as type, item_displayName as displayName, content_contentPath as path, content_installDate as installDate, content_isFree as isFree, pack_id as packId FROM packs_table, content_table, items_table WHERE pack_id=content_packId AND pack_id=item_packId AND pack_type=?  AND content_purchased=1  AND content_contentPath NOT NULL  ORDER BY installDate DESC, _order ASC)");
        } else
        {
            stringbuilder.append(" ORDER BY installDate DESC, _order ASC)");
        }
        if (flag3)
        {
            stringbuilder.append(" UNION ALL SELECT -1 as _id, -1 as _order, '' as packagename, '' as identifier, 4 as type, '' as displayName, '' as path, '' as installDate, 0 as isFree, -1 as packId");
        }
        if (flag2)
        {
            stringbuilder.append(" UNION ALL SELECT -1 as _id, -1 as _order, '' as packagename, '' as identifier, 6 as type, '' as displayName, '' as path, '' as installDate, 0 as isFree, -1 as packId");
        }
        if (flag1)
        {
            obj = new String[3];
            obj[0] = s;
            obj[1] = s;
            obj[2] = s;
            s = ((String) (obj));
        } else
        {
            String as[] = new String[2];
            as[0] = s;
            as[1] = s;
            s = as;
        }
        obj = getReadableDatabase();
        if (obj != null)
        {
            return ((SQLiteDatabase) (obj)).rawQuery(stringbuilder.toString(), s);
        } else
        {
            return null;
        }
    }

    long insertValues(String s, ContentValues contentvalues)
    {
        return insertValues(s, contentvalues, getWritableDatabase());
    }

    public void onConfigure(SQLiteDatabase sqlitedatabase)
    {
        logger.info("onConfigure");
        if (!sqlitedatabase.isReadOnly())
        {
            sqlitedatabase.execSQL("PRAGMA foreign_keys=ON;");
            sqlitedatabase.execSQL("PRAGMA encoding=\"UTF-8\";");
            sqlitedatabase.execSQL("PRAGMA page_size=4096;");
            sqlitedatabase.execSQL("PRAGMA cache_size=5000;");
        }
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        logger.info("onCreate");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS version_table (version_id INTEGER PRIMARY KEY AUTOINCREMENT, version_versionKey VARCHAR(255) NOT NULL, version_assetsBaseURL VARCHAR(255) NOT NULL );");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS packs_table (pack_id INTEGER PRIMARY KEY AUTOINCREMENT, pack_identifier VARCHAR(255) NOT NULL UNIQUE, pack_type VARCHAR(255) NOT NULL, pack_finishedDownloading INTEGER NOT NULL DEFAULT 0, pack_markedForDeletion INTEGER NOT NULL DEFAULT 0, pack_visible INTEGER NOT NULL DEFAULT 1, pack_displayOrder INTEGER NOT NULL DEFAULT 0 ,pack_creationDate DATETIME DEFAULT (datetime('now','localtime')), pack_versionKey VARCHAR(255) NOT NULL);");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS messages_table (msg_id INTEGER PRIMARY KEY AUTOINCREMENT, msg_type VARCHAR(255) NOT NULL, msg_identifier VARCHAR(255) NOT NULL UNIQUE, msg_versionKey VARCHAR(255) NOT NULL);");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS messages_content_table ( msgcnt_id INTEGER PRIMARY KEY AUTOINCREMENT, msgcnt_messageId INTEGER NOT NULL, msgcnt_contentIdentifier VARCHAR(255), msgcnt_beginDate DATETIME, msgcnt_endDate DATETIME, msgcnt_contentURL TEXT NOT NULL, msgcnt_actionButton VARCHAR(255), msgcnt_dismissButton VARCHAR(255) NOT NULL, msgcnt_layoutStyle VARCHAR(255), msgcnt_paragraph TEXT NOT NULL, msgcnt_showNewBanner INTEGER NOT NULL DEFAULT 1, msgcnt_contentPath TEXT DEFAULT NULL, msgcnt_visited INTEGER NOT NULL DEFAULT 0, msgcnt_title VARCHAR(255),  FOREIGN KEY( msgcnt_messageId ) REFERENCES messages_table( msg_id ) ON DELETE CASCADE );");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS content_table (content_id INTEGER PRIMARY KEY AUTOINCREMENT, content_packId INTEGER NOT NULL, content_contentVersion VARCHAR(255) NOT NULL, content_previewVersion VARCHAR(255) NOT NULL, content_iconVersion VARCHAR(255) NOT NULL,content_previewURL VARCHAR(255) NOT NULL, content_contentURL VARCHAR(255) NOT NULL, content_iconUrl VARCHAR(255) NOT NULL, content_isFree INTEGER DEFAULT 0, content_displayName VARCHAR(255) NOT NULL, content_displayDescription VARCHAR(255), content_downloadRequested INTEGER NOT NULL DEFAULT 0, content_purchased INTEGER NOT NULL DEFAULT 0, content_previewPath VARCHAR(255), content_contentPath VARCHAR(255), content_author VARCHAR(255) DEFAULT '', content_authorHyperlink VARCHAR(255) DEFAULT '', content_socialMediaString VARCHAR(255) DEFAULT '', content_shopBackgroundColor VARCHAR(255) DEFAULT '', content_featureImageURL VARCHAR(255) DEFAULT '', content_featureImageVersion VARCHAR(255) DEFAULT '', content_detailImageURL VARCHAR(255) DEFAULT '', content_detailImageVersion VARCHAR(255) DEFAULT '', content_detailImageLocalPath VARCHAR(255) DEFAULT '', content_featureImageLocalPath VARCHAR(255) DEFAULT '', content_iconPath VARCHAR(255), content_iconNeedDownload INTEGER NOT NULL DEFAULT 0, content_previewNeedDownload INTEGER NOT NULL DEFAULT 0, content_contentNeedDownload INTEGER NOT NULL DEFAULT 0, content_installDate DATETIME NOT NULL DEFAULT (datetime(current_timestamp)), content_numItems INTEGER DEFAULT 0, FOREIGN KEY(content_packId) REFERENCES packs_table(pack_id) ON DELETE CASCADE);");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS items_table (item_id INTEGER PRIMARY KEY AUTOINCREMENT, item_identifier VARCHAR(255) NOT NULL, item_displayName VARCHAR(255), item_contentPath VARCHAR(255), item_options BLOB, item_packId INTEGER NOT NULL, FOREIGN KEY(item_packId) REFERENCES packs_table(pack_id) ON DELETE CASCADE);");
        sqlitedatabase.execSQL("CREATE TABLE IF NOT EXISTS packs_download_table (downloadId INTEGER PRIMARY KEY AUTOINCREMENT, download_packId INTEGER NOT NULL UNIQUE, download_refId INTEGER, download_status INTEGER DEFAULT 0, FOREIGN KEY(download_packId) REFERENCES packs_table(pack_id) ON DELETE CASCADE);");
        PermissionColumns.create(sqlitedatabase);
        SubscriptionsColumns.create(sqlitedatabase);
        SubscriptionsContentColumns.create(sqlitedatabase);
        sqlitedatabase.execSQL("CREATE TRIGGER notify_download_finished AFTER UPDATE OF content_iconPath ON content_table BEGIN UPDATE packs_table SET pack_finishedDownloading = 1 WHERE packs_table.pack_id = OLD.content_packId; END;");
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        logger.info("onDowngrade from %d to %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        if (getContext().deleteDatabase("aviarycds.sqlite"))
        {
            onCreate(sqlitedatabase);
        }
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        logger.info("onOpen, isReadOnly: %b", new Object[] {
            Boolean.valueOf(sqlitedatabase.isReadOnly())
        });
        if (!sqlitedatabase.isReadOnly())
        {
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                onConfigure(sqlitedatabase);
            }
            (new AviaryCdsDefaultContentLoader(mContext)).loadDefaultContent(sqlitedatabase);
        }
        super.onOpen(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (sqlitedatabase.isReadOnly())
        {
            logger.warn("Could not upgrade table, db is read only");
        } else
        {
            logger.info("onUpgrade: %d >> %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            });
            if (i <= 3)
            {
                PermissionColumns.create(sqlitedatabase);
            }
            if (i <= 4)
            {
                SubscriptionsColumns.create(sqlitedatabase);
                SubscriptionsContentColumns.create(sqlitedatabase);
            }
            if (i <= 5)
            {
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS subscription_table");
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS subscriptions_content_table");
                SubscriptionsColumns.create(sqlitedatabase);
                SubscriptionsContentColumns.create(sqlitedatabase);
            }
            if (i <= 6)
            {
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_author VARCHAR(255) DEFAULT ''");
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_authorHyperlink VARCHAR(255) DEFAULT ''");
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_socialMediaString VARCHAR(255) DEFAULT ''");
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_shopBackgroundColor VARCHAR(255) DEFAULT ''");
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_featureImageURL VARCHAR(255) DEFAULT ''");
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_featureImageVersion VARCHAR(255) DEFAULT ''");
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_detailImageURL VARCHAR(255) DEFAULT ''");
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_detailImageVersion VARCHAR(255) DEFAULT ''");
            }
            if (i <= 7)
            {
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_detailImageLocalPath VARCHAR(255) DEFAULT ''");
                sqlitedatabase.execSQL("ALTER TABLE content_table ADD COLUMN content_featureImageLocalPath VARCHAR(255) DEFAULT ''");
                return;
            }
        }
    }

    long replacePermissions(ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase;
        long l;
        l = 0L;
        sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        sqlitedatabase.beginTransaction();
        delete(sqlitedatabase, "permission_table", null, null);
        l = insertValues("permission_table", contentvalues, sqlitedatabase);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return l;
        contentvalues;
        sqlitedatabase.setTransactionSuccessful();
        throw contentvalues;
    }

    int setMessageasVisited(long l, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("msgcnt_visited", Integer.valueOf(i));
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("messages_content_table", contentvalues, "msgcnt_id=?", new String[] {
                String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updateDownloadStatus(long l, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("download_status", Integer.valueOf(i));
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("packs_download_table", contentvalues, "download_refId=?", new String[] {
                String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updateMessage(long l, ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("messages_table", contentvalues, "msg_id=?", new String[] {
                String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updateMessage(long l, ContentValues contentvalues, SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("messages_table", contentvalues, "msg_id=?", new String[] {
                String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updateMessageContent(long l, long l1, ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("messages_content_table", contentvalues, "msgcnt_messageId=? AND msgcnt_id=?", new String[] {
                String.valueOf(l), String.valueOf(l1)
            });
        } else
        {
            return -1;
        }
    }

    int updateMessageContent(long l, long l1, ContentValues contentvalues, SQLiteDatabase sqlitedatabase)
    {
        return sqlitedatabase.update("messages_content_table", contentvalues, "msgcnt_id=? AND msgcnt_messageId=?", new String[] {
            String.valueOf(l1), String.valueOf(l)
        });
    }

    int updatePack(long l, ContentValues contentvalues)
    {
        return updatePack(l, contentvalues, getWritableDatabase());
    }

    int updatePack(long l, ContentValues contentvalues, SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("packs_table", contentvalues, "pack_id=?", new String[] {
                String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updatePackContent(long l, long l1, ContentValues contentvalues)
    {
        return updatePackContent(l, l1, contentvalues, getWritableDatabase());
    }

    int updatePackContent(long l, long l1, ContentValues contentvalues, SQLiteDatabase sqlitedatabase)
    {
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("content_table", contentvalues, "content_id=? AND content_packId=?", new String[] {
                String.valueOf(l1), String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updatePackContentPurchasedStatus(long l, long l1, int i, String s)
    {
        logger.info("updatePackContentPurchasedstatus: %d, content: %s", new Object[] {
            Long.valueOf(l), s
        });
        ContentValues contentvalues = new ContentValues();
        if (s != null)
        {
            contentvalues.put("content_contentPath", s);
            contentvalues.put("content_installDate", DateTimeUtils.toSqlDateTime(System.currentTimeMillis()));
        } else
        {
            contentvalues.putNull("content_contentPath");
        }
        contentvalues.put("content_purchased", Integer.valueOf(i));
        s = getWritableDatabase();
        if (s != null)
        {
            return s.update("content_table", contentvalues, "content_id=? AND content_packId=?", new String[] {
                String.valueOf(l1), String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updatePackContentRequestDownloadStatus(long l, int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("content_downloadRequested", Integer.valueOf(i));
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("content_table", contentvalues, "content_packId=?", new String[] {
                String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updateSubscription(long l, ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("subscription_table", contentvalues, "subscription_id=?", new String[] {
                String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updateSubscriptionContent(long l, long l1, ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("subscriptions_content_table", contentvalues, "subscriptions_content_id=? AND subscriptions_subscription_id=?", new String[] {
                String.valueOf(l1), String.valueOf(l)
            });
        } else
        {
            return -1;
        }
    }

    int updateSubscriptionPurchasedStatus(int i, int j)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("subscriptions_content_purchased", Integer.valueOf(j));
        SQLiteDatabase sqlitedatabase = getWritableDatabase();
        if (sqlitedatabase != null)
        {
            return sqlitedatabase.update("subscriptions_content_table", contentvalues, "subscriptions_subscription_id=?", new String[] {
                String.valueOf(i)
            });
        } else
        {
            return -1;
        }
    }

    static 
    {
        logger = LoggerFactory.getLogger("CdsDatabaseHelper", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
