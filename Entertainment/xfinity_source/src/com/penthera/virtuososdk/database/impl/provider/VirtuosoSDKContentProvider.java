// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.penthera.virtuososdk.database.impl.VSdkDb;
import java.util.HashMap;
import java.util.List;

public abstract class VirtuosoSDKContentProvider extends ContentProvider
    implements android.os.Handler.Callback
{

    private static final Uri CATALOG_URI_LIST = Uri.parse("content://com.penthera.baratheon.catalog/list/");
    private static final String LOG_TAG = com/penthera/virtuososdk/database/impl/provider/VirtuosoSDKContentProvider.getName();
    private static HashMap iCatalogProjectionMap;
    private static final UriMatcher iCatalogUriMatcher = new UriMatcher(-1);
    private static HashMap iFileProjectionMap;
    private static final UriMatcher iFileUriMatcher = new UriMatcher(-1);
    private static HashMap iFragmentProjectionMap;
    private static final UriMatcher iFragmentUriMatcher = new UriMatcher(-1);
    private static HashMap iNetworkProjectionMap;
    private static UriMatcher iNetworkUriMatcher;
    private static HashMap iProviderProjectionMap;
    private static final UriMatcher iProviderUriMatcher = new UriMatcher(-1);
    private static HashMap iRegistryProjectionMap;
    private static final UriMatcher iRegistryUriMatcher = new UriMatcher(-1);
    private boolean catalog_enabled;
    private com.penthera.virtuososdk.database.impl.VSdkDb.DatabaseHelper mOpenHelper;

    public VirtuosoSDKContentProvider()
    {
        catalog_enabled = false;
    }

    private int deleteCatalog(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iCatalogUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 191
    //                   1 82
    //                   2 48
    //                   3 48
    //                   4 103;
           goto _L1 _L2 _L1 _L1 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.delete("catalog", s, as);
_L5:
        mOpenHelper.releaseDatabase();
        return i;
_L3:
        StringBuilder stringbuilder;
        uri = (String)uri.getPathSegments().get(1);
        stringbuilder = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s))
        {
            break; /* Loop/switch isn't completed */
        }
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L6:
        i = sqlitedatabase.delete("catalog", stringbuilder.append(uri).toString(), as);
        if (true) goto _L5; else goto _L4
_L4:
        uri = "";
          goto _L6
        if (true) goto _L5; else goto _L7
_L7:
    }

    private int deleteFile(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase;
        String s1;
        sqlitedatabase = mOpenHelper.getWritableDatabase();
        s1 = getAssetId(as);
        iFileUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 365
    //                   1 86
    //                   2 136
    //                   3 52
    //                   4 276;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.delete("file", s, as);
_L11:
        mOpenHelper.releaseDatabase();
        if (i > 0 && (!TextUtils.isEmpty(s1) || isDeleteAll(s, as)))
        {
            deleteJoinCatalog(s1);
        }
        return i;
_L3:
        Object obj;
        obj = (String)uri.getPathSegments().get(2);
        uri = (String[])null;
        if (as == null) goto _L6; else goto _L5
_L5:
        uri = new String[as.length + 1];
        int j;
        i = 0 + 1;
        uri[0] = obj;
        j = 0;
_L15:
        if (j < as.length) goto _L8; else goto _L7
_L7:
        StringBuilder stringbuilder = new StringBuilder("uuid=?");
        if (TextUtils.isEmpty(s)) goto _L10; else goto _L9
_L9:
        obj = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L16:
        i = sqlitedatabase.delete("file", stringbuilder.append(((String) (obj))).toString(), uri);
        File.FileColumns.CONTENT_URI(getAuthority());
          goto _L11
_L6:
        uri = new String[1];
        uri[0] = obj;
          goto _L7
_L4:
        uri = (String)uri.getPathSegments().get(1);
        obj = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s)) goto _L13; else goto _L12
_L12:
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L14:
        i = sqlitedatabase.delete("file", ((StringBuilder) (obj)).append(uri).toString(), as);
          goto _L11
_L13:
        uri = "";
          goto _L14
_L8:
        uri[i] = as[j];
        j++;
        i++;
          goto _L15
_L10:
        obj = "";
          goto _L16
    }

    private int deleteFragment(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iFragmentUriMatcher.match(uri);
        JVM INSTR tableswitch 1 5: default 333
    //                   1 86
    //                   2 52
    //                   3 52
    //                   4 244
    //                   5 108;
           goto _L1 _L2 _L1 _L1 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.delete("fragment", s, as);
_L11:
        mOpenHelper.releaseDatabase();
        return i;
_L4:
        Object obj;
        obj = (String)uri.getPathSegments().get(2);
        uri = (String[])null;
        if (as == null) goto _L6; else goto _L5
_L5:
        uri = new String[as.length + 1];
        int j;
        i = 0 + 1;
        uri[0] = obj;
        j = 0;
_L15:
        if (j < as.length) goto _L8; else goto _L7
_L7:
        as = new StringBuilder("parentUuid=?");
        if (TextUtils.isEmpty(s)) goto _L10; else goto _L9
_L9:
        s = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L16:
        i = sqlitedatabase.delete("fragment", as.append(s).toString(), uri);
        FileFragment.FragmentColumns.CONTENT_URI(getAuthority());
          goto _L11
_L6:
        uri = new String[1];
        uri[0] = obj;
          goto _L7
_L3:
        uri = (String)uri.getPathSegments().get(1);
        obj = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s)) goto _L13; else goto _L12
_L12:
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L14:
        i = sqlitedatabase.delete("fragment", ((StringBuilder) (obj)).append(uri).toString(), as);
          goto _L11
_L13:
        uri = "";
          goto _L14
_L8:
        uri[i] = as[j];
        j++;
        i++;
          goto _L15
_L10:
        s = "";
          goto _L16
    }

    private void deleteJoinCatalog(String s)
        throws IllegalArgumentException
    {
        if (!catalog_enabled)
        {
            return;
        }
        SQLiteDatabase sqlitedatabase;
        ContentValues contentvalues;
        sqlitedatabase = mOpenHelper.getWritableDatabase();
        contentvalues = new ContentValues();
        contentvalues.put("filePath", "");
        contentvalues.put("errorType", Integer.valueOf(-1));
        contentvalues.put("fileUuid", "");
        contentvalues.put("viewedTime", Integer.valueOf(0));
        contentvalues.put("completeTime", Integer.valueOf(0));
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int i = sqlitedatabase.update("catalog", contentvalues, "_id=?", new String[] {
            s
        });
_L8:
        if (i > 0) goto _L4; else goto _L3
_L3:
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("delete error: ")).append(i).toString());
_L6:
        mOpenHelper.releaseDatabase();
        return;
_L2:
        i = sqlitedatabase.update("catalog", contentvalues, null, null);
        continue; /* Loop/switch isn't completed */
_L4:
        getContext().getApplicationContext().getContentResolver().notifyChange(CATALOG_URI_LIST, null);
        if (true) goto _L6; else goto _L5
_L5:
        s;
        mOpenHelper.releaseDatabase();
        throw s;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private int deleteProvider(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iProviderUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 193
    //                   1 82
    //                   2 48
    //                   3 48
    //                   4 104;
           goto _L1 _L2 _L1 _L1 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.delete("providers", s, as);
_L5:
        mOpenHelper.releaseDatabase();
        return i;
_L3:
        StringBuilder stringbuilder;
        uri = (String)uri.getPathSegments().get(1);
        stringbuilder = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s))
        {
            break; /* Loop/switch isn't completed */
        }
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L6:
        i = sqlitedatabase.delete("providers", stringbuilder.append(uri).toString(), as);
        if (true) goto _L5; else goto _L4
_L4:
        uri = "";
          goto _L6
        if (true) goto _L5; else goto _L7
_L7:
    }

    private int deleteRegistry(Uri uri, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iRegistryUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 282
    //                   1 82
    //                   2 48
    //                   3 104
    //                   4 193;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.delete("registry", s, as);
_L7:
        mOpenHelper.releaseDatabase();
        return i;
_L3:
        StringBuilder stringbuilder;
        uri = (String)uri.getPathSegments().get(2);
        stringbuilder = (new StringBuilder("name='")).append(uri).append("'");
        if (TextUtils.isEmpty(s)) goto _L6; else goto _L5
_L5:
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L11:
        i = sqlitedatabase.delete("registry", stringbuilder.append(uri).toString(), as);
          goto _L7
_L4:
        uri = (String)uri.getPathSegments().get(1);
        stringbuilder = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s)) goto _L9; else goto _L8
_L8:
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L10:
        i = sqlitedatabase.delete("registry", stringbuilder.append(uri).toString(), as);
          goto _L7
_L9:
        uri = "";
          goto _L10
_L6:
        uri = "";
          goto _L11
    }

    private int fragmentBulkInsert(Uri uri, ContentValues acontentvalues[])
    {
        SQLiteDatabase sqlitedatabase;
        int i;
        sqlitedatabase = mOpenHelper.getWritableDatabase();
        sqlitedatabase.beginTransaction();
        i = 0;
_L2:
        if (i < acontentvalues.length)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        sqlitedatabase.setTransactionSuccessful();
        i = acontentvalues.length;
        sqlitedatabase.endTransaction();
        mOpenHelper.releaseDatabase();
        return i;
        if (sqlitedatabase.insertOrThrow("fragment", null, acontentvalues[i]) <= 0L)
        {
            throw new SQLException((new StringBuilder("Failed to insert row into ")).append(uri).toString());
        }
        break MISSING_BLOCK_LABEL_100;
        uri;
        sqlitedatabase.endTransaction();
        mOpenHelper.releaseDatabase();
        throw uri;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String getAssetId(String as[])
    {
        Object obj1;
        Cursor cursor;
        Object obj2;
        obj2 = null;
        obj1 = null;
        cursor = null;
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        Object obj;
        obj = obj2;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        obj = obj2;
        if (as.length != 1)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        as = as[0];
        obj = cursor;
        cursor = sqlitedatabase.query("file", null, "uuid=?", new String[] {
            as
        }, null, null, null);
        as = obj1;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        as = obj1;
        obj = cursor;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_107;
        }
        obj = cursor;
        as = cursor.getString(cursor.getColumnIndex("assetId"));
        obj = as;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        cursor.close();
        obj = as;
        mOpenHelper.releaseDatabase();
        return ((String) (obj));
        as;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        ((Cursor) (obj)).close();
        throw as;
        as;
        mOpenHelper.releaseDatabase();
        throw as;
    }

    private Uri insertCatalog(Uri uri, ContentValues contentvalues)
    {
        Object obj;
        long l;
        if (contentvalues != null)
        {
            contentvalues = new ContentValues(contentvalues);
        } else
        {
            contentvalues = new ContentValues();
        }
        obj = Long.valueOf(System.currentTimeMillis());
        if (!contentvalues.containsKey("creationTime"))
        {
            contentvalues.put("creationTime", ((Long) (obj)));
        }
        if (!contentvalues.containsKey("modifyTime"))
        {
            contentvalues.put("modifyTime", ((Long) (obj)));
        }
        obj = mOpenHelper.getWritableDatabase();
        l = ((SQLiteDatabase) (obj)).insert("catalog", "desc", contentvalues);
        mOpenHelper.releaseDatabase();
        if (l > -1L)
        {
            return ContentUris.withAppendedId(Catalog.CatalogColumns.CONTENT_URI(getAuthority()), l);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to insert row into ")).append(uri).toString());
        }
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
    }

    private Uri insertFile(Uri uri, ContentValues contentvalues)
    {
        ContentValues contentvalues1;
        Object obj;
        if (contentvalues != null)
        {
            contentvalues1 = new ContentValues(contentvalues);
        } else
        {
            contentvalues1 = new ContentValues();
        }
        if (!contentvalues1.containsKey("uuid"))
        {
            throw new IllegalArgumentException("New Files must have a UUID");
        }
        obj = Long.valueOf(System.currentTimeMillis());
        if (!contentvalues1.containsKey("creationTime"))
        {
            contentvalues1.put("creationTime", ((Long) (obj)));
        }
        if (!contentvalues1.containsKey("modifyTime"))
        {
            contentvalues1.put("modifyTime", ((Long) (obj)));
        }
        obj = mOpenHelper.getWritableDatabase();
        long l = ((SQLiteDatabase) (obj)).insert("file", "description", contentvalues1);
        mOpenHelper.releaseDatabase();
        if (l > -1L)
        {
            try
            {
                updateJoinCatalog(contentvalues);
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                uri.printStackTrace();
            }
            return ContentUris.withAppendedId(File.FileColumns.CONTENT_URI(getAuthority()), l);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to insert row into ")).append(uri).toString());
        }
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
    }

    private Uri insertFragment(Uri uri, ContentValues contentvalues)
    {
        Object obj;
        if (contentvalues != null)
        {
            contentvalues = new ContentValues(contentvalues);
        } else
        {
            contentvalues = new ContentValues();
        }
        if (!contentvalues.containsKey("parentUuid"))
        {
            throw new IllegalArgumentException("New Fragments must have a PARENT_UUID");
        }
        obj = Long.valueOf(System.currentTimeMillis());
        if (!contentvalues.containsKey("creationTime"))
        {
            contentvalues.put("creationTime", ((Long) (obj)));
        }
        if (!contentvalues.containsKey("modifyTime"))
        {
            contentvalues.put("modifyTime", ((Long) (obj)));
        }
        obj = mOpenHelper.getWritableDatabase();
        long l = ((SQLiteDatabase) (obj)).insert("fragment", "filePath", contentvalues);
        mOpenHelper.releaseDatabase();
        if (l > -1L)
        {
            return ContentUris.withAppendedId(FileFragment.FragmentColumns.CONTENT_URI(getAuthority()), l);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to insert row into ")).append(uri).toString());
        }
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
    }

    private Uri insertProvider(Uri uri, ContentValues contentvalues)
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        long l = sqlitedatabase.insert("providers", null, contentvalues);
        mOpenHelper.releaseDatabase();
        if (l > -1L)
        {
            return ContentUris.withAppendedId(Provider.ProviderColumns.CONTENT_URI(getAuthority()), l);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to insert row into ")).append(uri).toString());
        }
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
    }

    private Uri insertRegistry(Uri uri, ContentValues contentvalues)
    {
        String s;
        SQLiteDatabase sqlitedatabase;
        if (contentvalues == null)
        {
            throw new IllegalArgumentException("Insertion must have values");
        }
        contentvalues = new ContentValues(contentvalues);
        if (!contentvalues.containsKey("name") || !contentvalues.containsKey("value"))
        {
            throw new IllegalArgumentException("New registry entry must have a name and a value");
        }
        s = contentvalues.getAsString("name");
        sqlitedatabase = mOpenHelper.getWritableDatabase();
        long l = sqlitedatabase.insert("registry", "value", contentvalues);
        mOpenHelper.releaseDatabase();
        if (l > -1L)
        {
            uri = Uri.parse((new StringBuilder()).append(Registry.RegistryColumns.CONTENT_URI(getAuthority())).append("/name/").append(s).toString());
            ContentUris.withAppendedId(Registry.RegistryColumns.CONTENT_URI(getAuthority()), l);
            return uri;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to insert row into ")).append(uri).toString());
        }
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
    }

    private boolean isDeleteAll(String s, String as[])
    {
        boolean flag = s.equals("clientAuthority =?");
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_19;
        s;
        s.printStackTrace();
        return false;
    }

    private Cursor queryCatalog(Uri uri, String as[], String s, String as1[], String s1)
    {
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("catalog");
        sqlitequerybuilder.setProjectionMap(iCatalogProjectionMap);
        switch (iCatalogUriMatcher.match(uri))
        {
        case 2: // '\002'
        case 3: // '\003'
        default:
            throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());

        case 4: // '\004'
            sqlitequerybuilder.appendWhere((new StringBuilder("_id=")).append((String)uri.getPathSegments().get(1)).toString());
            break;

        case 1: // '\001'
            break;
        }
        if (TextUtils.isEmpty(s1))
        {
            uri = "_id ASC ";
        } else
        {
            uri = s1;
        }
        uri = sqlitequerybuilder.query(mOpenHelper.getReadableDatabase(), as, s, as1, null, null, uri);
        mOpenHelper.releaseDatabase();
        return uri;
    }

    private Cursor queryFile(Uri uri, String as[], String s, String as1[], String s1)
    {
        String as2[];
        String s2;
        SQLiteQueryBuilder sqlitequerybuilder;
        sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("file");
        sqlitequerybuilder.setProjectionMap(iFileProjectionMap);
        s2 = s;
        as2 = as1;
        iFileUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 68
    //                   1 203
    //                   2 92
    //                   3 68
    //                   4 289;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
_L3:
        as2 = (String)uri.getPathSegments().get(2);
        uri = (String[])null;
        if (as1 == null) goto _L6; else goto _L5
_L5:
        int i;
        int j;
        uri = new String[as1.length + 1];
        uri[0] = as2;
        j = 0;
        i = 0 + 1;
_L9:
        if (j < as1.length) goto _L8; else goto _L7
_L7:
        as1 = new StringBuilder("uuid=?");
        if (!TextUtils.isEmpty(s))
        {
            s = (new StringBuilder(" AND (")).append(s).append(')').toString();
        } else
        {
            s = "";
        }
        s2 = as1.append(s).toString();
        as2 = uri;
_L2:
        if (TextUtils.isEmpty(s1))
        {
            uri = "_id ASC ";
        } else
        {
            uri = s1;
        }
        uri = sqlitequerybuilder.query(mOpenHelper.getReadableDatabase(), as, s2, as2, null, null, uri);
        mOpenHelper.releaseDatabase();
        return uri;
_L8:
        uri[i] = as1[j];
        j++;
        i++;
          goto _L9
_L6:
        uri = new String[1];
        uri[0] = as2;
          goto _L7
_L4:
        sqlitequerybuilder.appendWhere((new StringBuilder("_id=")).append((String)uri.getPathSegments().get(1)).toString());
        s2 = s;
        as2 = as1;
          goto _L2
    }

    private Cursor queryFragment(Uri uri, String as[], String s, String as1[], String s1)
    {
        String as2[];
        String s2;
        SQLiteQueryBuilder sqlitequerybuilder;
        sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("fragment");
        sqlitequerybuilder.setProjectionMap(iFragmentProjectionMap);
        s2 = s;
        as2 = as1;
        iFragmentUriMatcher.match(uri);
        JVM INSTR tableswitch 1 5: default 72
    //                   1 207
    //                   2 72
    //                   3 72
    //                   4 293
    //                   5 96;
           goto _L1 _L2 _L1 _L1 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
_L4:
        as2 = (String)uri.getPathSegments().get(2);
        uri = (String[])null;
        if (as1 == null) goto _L6; else goto _L5
_L5:
        int i;
        int j;
        uri = new String[as1.length + 1];
        uri[0] = as2;
        j = 0;
        i = 0 + 1;
_L9:
        if (j < as1.length) goto _L8; else goto _L7
_L7:
        as1 = new StringBuilder("parentUuid=?");
        if (!TextUtils.isEmpty(s))
        {
            s = (new StringBuilder(" AND (")).append(s).append(')').toString();
        } else
        {
            s = "";
        }
        s2 = as1.append(s).toString();
        as2 = uri;
_L2:
        if (TextUtils.isEmpty(s1))
        {
            uri = "_id ASC ";
        } else
        {
            uri = s1;
        }
        uri = sqlitequerybuilder.query(mOpenHelper.getReadableDatabase(), as, s2, as2, null, null, uri);
        mOpenHelper.releaseDatabase();
        return uri;
_L8:
        uri[i] = as1[j];
        j++;
        i++;
          goto _L9
_L6:
        uri = new String[1];
        uri[0] = as2;
          goto _L7
_L3:
        sqlitequerybuilder.appendWhere((new StringBuilder("_id=")).append((String)uri.getPathSegments().get(1)).toString());
        s2 = s;
        as2 = as1;
          goto _L2
    }

    private Cursor queryProvider(Uri uri, String as[], String s, String as1[], String s1)
    {
        SQLiteQueryBuilder sqlitequerybuilder = new SQLiteQueryBuilder();
        sqlitequerybuilder.setTables("providers");
        sqlitequerybuilder.setProjectionMap(iProviderProjectionMap);
        switch (iProviderUriMatcher.match(uri))
        {
        case 2: // '\002'
        case 3: // '\003'
        default:
            throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());

        case 4: // '\004'
            sqlitequerybuilder.appendWhere((new StringBuilder("_id=")).append((String)uri.getPathSegments().get(1)).toString());
            break;

        case 1: // '\001'
            break;
        }
        if (TextUtils.isEmpty(s1))
        {
            uri = "_id ASC ";
        } else
        {
            uri = s1;
        }
        uri = sqlitequerybuilder.query(mOpenHelper.getReadableDatabase(), as, s, as1, null, null, uri);
        mOpenHelper.releaseDatabase();
        return uri;
    }

    private Cursor queryRegistry(Uri uri, String as[], String s, String as1[], String s1)
    {
        s1 = new SQLiteQueryBuilder();
        s1.setTables("registry");
        s1.setProjectionMap(iRegistryProjectionMap);
        iRegistryUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 64
    //                   1 128
    //                   2 64
    //                   3 88
    //                   4 157;
           goto _L1 _L2 _L1 _L3 _L4
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
_L3:
        s1.appendWhere((new StringBuilder("name='")).append((String)uri.getPathSegments().get(2)).append("'").toString());
_L6:
        uri = s1.query(mOpenHelper.getReadableDatabase(), as, s, as1, null, null, null);
        mOpenHelper.releaseDatabase();
        return uri;
_L4:
        s1.appendWhere((new StringBuilder("_id=")).append((String)uri.getPathSegments().get(1)).toString());
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected static void setAuthority(String s)
    {
        iFileUriMatcher.addURI(s, "content", 1);
        iFileUriMatcher.addURI(s, "content/cid/*", 2);
        iFileUriMatcher.addURI(s, "content/#", 4);
        iRegistryUriMatcher.addURI(s, "registry", 1);
        iRegistryUriMatcher.addURI(s, "registry/name/*", 3);
        iRegistryUriMatcher.addURI(s, "registry/#", 4);
        iFragmentUriMatcher.addURI(s, "fragment", 1);
        iFragmentUriMatcher.addURI(s, "fragment/parent/*", 5);
        iFragmentUriMatcher.addURI(s, "fragment/#", 4);
        iProviderUriMatcher.addURI(s, "provider", 1);
        iProviderUriMatcher.addURI(s, "provider/#", 4);
        iCatalogUriMatcher.addURI(s, "catalog", 1);
        iCatalogUriMatcher.addURI(s, "catalog/#", 4);
        iNetworkUriMatcher = new UriMatcher(-1);
        iNetworkUriMatcher.addURI(s, "network", 1);
        iNetworkUriMatcher.addURI(s, "network/#", 4);
    }

    private int updateCatalog(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iCatalogUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 195
    //                   1 82
    //                   2 48
    //                   3 48
    //                   4 105;
           goto _L1 _L2 _L1 _L1 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.update("catalog", contentvalues, s, as);
_L5:
        mOpenHelper.releaseDatabase();
        return i;
_L3:
        StringBuilder stringbuilder;
        uri = (String)uri.getPathSegments().get(1);
        stringbuilder = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s))
        {
            break; /* Loop/switch isn't completed */
        }
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L6:
        i = sqlitedatabase.update("catalog", contentvalues, stringbuilder.append(uri).toString(), as);
        if (true) goto _L5; else goto _L4
_L4:
        uri = "";
          goto _L6
        if (true) goto _L5; else goto _L7
_L7:
    }

    private int updateFile(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iFileUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 357
    //                   1 82
    //                   2 116
    //                   3 48
    //                   4 258;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.update("file", contentvalues, s, as);
_L11:
        int j;
        mOpenHelper.releaseDatabase();
        Object obj;
        if (i > 0)
        {
            try
            {
                updateJoinCatalog(contentvalues);
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                uri.printStackTrace();
                return i;
            }
        }
        return i;
_L3:
        obj = (String)uri.getPathSegments().get(2);
        uri = (String[])null;
        if (as == null) goto _L6; else goto _L5
_L5:
        uri = new String[as.length + 1];
        i = 0 + 1;
        uri[0] = obj;
        j = 0;
_L15:
        if (j < as.length) goto _L8; else goto _L7
_L7:
        as = new StringBuilder("uuid=?");
        if (TextUtils.isEmpty(s)) goto _L10; else goto _L9
_L9:
        s = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L16:
        i = sqlitedatabase.update("file", contentvalues, as.append(s).toString(), uri);
        File.FileColumns.CONTENT_URI(getAuthority());
          goto _L11
_L6:
        uri = new String[1];
        uri[0] = obj;
          goto _L7
_L4:
        uri = (String)uri.getPathSegments().get(1);
        obj = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s)) goto _L13; else goto _L12
_L12:
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L14:
        i = sqlitedatabase.update("file", contentvalues, ((StringBuilder) (obj)).append(uri).toString(), as);
          goto _L11
_L13:
        uri = "";
          goto _L14
_L8:
        uri[i] = as[j];
        j++;
        i++;
          goto _L15
_L10:
        s = "";
          goto _L16
    }

    private int updateFragment(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iFragmentUriMatcher.match(uri);
        JVM INSTR tableswitch 1 5: default 343
    //                   1 86
    //                   2 52
    //                   3 52
    //                   4 252
    //                   5 110;
           goto _L1 _L2 _L1 _L1 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.update("fragment", contentvalues, s, as);
_L11:
        mOpenHelper.releaseDatabase();
        return i;
_L4:
        Object obj;
        obj = (String)uri.getPathSegments().get(2);
        uri = (String[])null;
        if (as == null) goto _L6; else goto _L5
_L5:
        uri = new String[as.length + 1];
        int j;
        i = 0 + 1;
        uri[0] = obj;
        j = 0;
_L15:
        if (j < as.length) goto _L8; else goto _L7
_L7:
        as = new StringBuilder("parentUuid=?");
        if (TextUtils.isEmpty(s)) goto _L10; else goto _L9
_L9:
        s = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L16:
        i = sqlitedatabase.update("fragment", contentvalues, as.append(s).toString(), uri);
        FileFragment.FragmentColumns.CONTENT_URI(getAuthority());
          goto _L11
_L6:
        uri = new String[1];
        uri[0] = obj;
          goto _L7
_L3:
        uri = (String)uri.getPathSegments().get(1);
        obj = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s)) goto _L13; else goto _L12
_L12:
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L14:
        i = sqlitedatabase.update("fragment", contentvalues, ((StringBuilder) (obj)).append(uri).toString(), as);
          goto _L11
_L13:
        uri = "";
          goto _L14
_L8:
        uri[i] = as[j];
        j++;
        i++;
          goto _L15
_L10:
        s = "";
          goto _L16
    }

    private void updateJoinCatalog(ContentValues contentvalues)
        throws IllegalArgumentException
    {
        SQLiteDatabase sqlitedatabase;
        if (!catalog_enabled)
        {
            return;
        }
        sqlitedatabase = mOpenHelper.getWritableDatabase();
        ContentValues contentvalues1 = new ContentValues();
        if (!contentvalues.containsKey("assetId")) goto _L2; else goto _L1
_L1:
        String s;
        s = contentvalues.getAsString("assetId");
        if (contentvalues.containsKey("filePath"))
        {
            contentvalues1.put("filePath", contentvalues.getAsString("filePath"));
        }
        if (!contentvalues.containsKey("uuid")) goto _L4; else goto _L3
_L3:
        contentvalues1.put("fileUuid", contentvalues.getAsString("uuid"));
        if (contentvalues.containsKey("errorType"))
        {
            contentvalues1.put("errorType", contentvalues.getAsString("errorType"));
        }
        if (contentvalues.containsKey("completeTime"))
        {
            contentvalues1.put("completeTime", contentvalues.getAsString("completeTime"));
        }
        if (sqlitedatabase.update("catalog", contentvalues1, "_id=?", new String[] {
    s
}) <= 0)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        getContext().getApplicationContext().getContentResolver().notifyChange(CATALOG_URI_LIST, null);
_L5:
        mOpenHelper.releaseDatabase();
        return;
_L2:
        throw new IllegalArgumentException("must supply asset ID");
        contentvalues;
        mOpenHelper.releaseDatabase();
        throw contentvalues;
_L4:
        throw new IllegalArgumentException("must supply UUID");
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, (new StringBuilder("update failed: ")).append(contentvalues1).toString());
          goto _L5
    }

    private int updateProvider(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iProviderUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 197
    //                   1 82
    //                   2 48
    //                   3 48
    //                   4 106;
           goto _L1 _L2 _L1 _L1 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.update("providers", contentvalues, s, as);
_L5:
        mOpenHelper.releaseDatabase();
        return i;
_L3:
        StringBuilder stringbuilder;
        uri = (String)uri.getPathSegments().get(1);
        stringbuilder = (new StringBuilder("_id=")).append(uri);
        if (TextUtils.isEmpty(s))
        {
            break; /* Loop/switch isn't completed */
        }
        uri = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L6:
        i = sqlitedatabase.update("providers", contentvalues, stringbuilder.append(uri).toString(), as);
        if (true) goto _L5; else goto _L4
_L4:
        uri = "";
          goto _L6
        if (true) goto _L5; else goto _L7
_L7:
    }

    private int updateRegistry(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SQLiteDatabase sqlitedatabase = mOpenHelper.getWritableDatabase();
        iRegistryUriMatcher.match(uri);
        JVM INSTR tableswitch 1 4: default 320
    //                   1 82
    //                   2 48
    //                   3 134
    //                   4 227;
           goto _L1 _L2 _L1 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        uri;
        mOpenHelper.releaseDatabase();
        throw uri;
_L2:
        int i = sqlitedatabase.update("registry", contentvalues, s, as);
_L7:
        mOpenHelper.releaseDatabase();
        int j = i;
        if (i == 0)
        {
            j = i;
            if (insertRegistry(uri, contentvalues) != null)
            {
                j = i + 1;
            }
        }
        return j;
_L3:
        Object obj;
        obj = (String)uri.getPathSegments().get(2);
        obj = (new StringBuilder("name='")).append(((String) (obj))).append("'");
        if (TextUtils.isEmpty(s)) goto _L6; else goto _L5
_L5:
        s = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L11:
        i = sqlitedatabase.update("registry", contentvalues, ((StringBuilder) (obj)).append(s).toString(), as);
          goto _L7
_L4:
        obj = (String)uri.getPathSegments().get(1);
        obj = (new StringBuilder("_id=")).append(((String) (obj)));
        if (TextUtils.isEmpty(s)) goto _L9; else goto _L8
_L8:
        s = (new StringBuilder(" AND (")).append(s).append(')').toString();
_L10:
        i = sqlitedatabase.update("registry", contentvalues, ((StringBuilder) (obj)).append(s).toString(), as);
          goto _L7
_L9:
        s = "";
          goto _L10
_L6:
        s = "";
          goto _L11
    }

    public void attachInfo(Context context, ProviderInfo providerinfo)
    {
        super.attachInfo(context, providerinfo);
        try
        {
            catalog_enabled = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.penthera.virtuososdk.catalog.enabled");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public int bulkInsert(Uri uri, ContentValues acontentvalues[])
    {
        if (iFragmentUriMatcher.match(uri) > 0)
        {
            return fragmentBulkInsert(uri, acontentvalues);
        }
        if (iFileUriMatcher.match(uri) > 0 || iRegistryUriMatcher.match(uri) > 0 || iCatalogUriMatcher.match(uri) > 0 || iNetworkUriMatcher.match(uri) > 0)
        {
            return super.bulkInsert(uri, acontentvalues);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to insert bulk unknown uri ")).append(uri).toString());
        }
    }

    public int delete(Uri uri, String s, String as[])
    {
        if (iFileUriMatcher.match(uri) > 0)
        {
            return deleteFile(uri, s, as);
        }
        if (iRegistryUriMatcher.match(uri) > 0)
        {
            return deleteRegistry(uri, s, as);
        }
        if (iFragmentUriMatcher.match(uri) > 0)
        {
            return deleteFragment(uri, s, as);
        }
        if (iCatalogUriMatcher.match(uri) > 0)
        {
            return deleteCatalog(uri, s, as);
        }
        if (iProviderUriMatcher.match(uri) > 0)
        {
            return deleteProvider(uri, s, as);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to delete, unknown URI")).append(uri).toString());
        }
    }

    protected abstract String getAuthority();

    public SQLiteDatabase getDBHandle()
    {
        return mOpenHelper.getReadableDatabase();
    }

    public String getType(Uri uri)
    {
        int i = iFileUriMatcher.match(uri);
        if (i > 0)
        {
            if (i == 1)
            {
                return "vnd.android.cursor.dir/vnd.virtuososdk.file";
            } else
            {
                return "vnd.android.cursor.item/vnd.virtuososdk.file";
            }
        }
        i = iRegistryUriMatcher.match(uri);
        if (i > 0)
        {
            if (i == 1)
            {
                return "vnd.android.cursor.dir/vnd.virtuososdk.registry";
            } else
            {
                return "vnd.android.cursor.item/vnd.virtuososdk.registry";
            }
        }
        i = iFragmentUriMatcher.match(uri);
        if (i > 0)
        {
            if (i == 1)
            {
                return "vnd.android.cursor.dir/vnd.virtuososdk.fragment";
            } else
            {
                return "vnd.android.cursor.item/vnd.virtuososdk.fragment";
            }
        }
        i = iCatalogUriMatcher.match(uri);
        if (i > 0)
        {
            if (i == 1)
            {
                return "vnd.android.cursor.dir/vnd.virtuososdk.Catalog";
            } else
            {
                return "vnd.android.cursor.item/vnd.virtuososdk.Catalog";
            }
        }
        i = iProviderUriMatcher.match(uri);
        if (i > 0)
        {
            if (i == 1)
            {
                return "vnd.android.cursor.dir/vnd.virtuososdk.provider";
            } else
            {
                return "vnd.android.cursor.item/vnd.virtuososdk.provider";
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        }
    }

    public boolean handleMessage(Message message)
    {
        return false;
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        if (iFileUriMatcher.match(uri) == 1)
        {
            return insertFile(uri, contentvalues);
        }
        if (iRegistryUriMatcher.match(uri) == 1)
        {
            return insertRegistry(uri, contentvalues);
        }
        if (iFragmentUriMatcher.match(uri) == 1)
        {
            return insertFragment(uri, contentvalues);
        }
        if (iCatalogUriMatcher.match(uri) == 1)
        {
            return insertCatalog(uri, contentvalues);
        }
        if (iProviderUriMatcher.match(uri) == 1)
        {
            return insertProvider(uri, contentvalues);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown URI ")).append(uri).toString());
        }
    }

    public boolean onCreate()
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "getting helper");
        if (VSdkDb.getInstance() == null)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Orpheus Db is null. initialising...");
            VSdkDb.init(getContext().getApplicationContext(), getAuthority());
        }
        mOpenHelper = VSdkDb.getHelper();
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("helper is ")).append(mOpenHelper).toString());
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        if (iFileUriMatcher.match(uri) > 0)
        {
            return queryFile(uri, as, s, as1, s1);
        }
        if (iRegistryUriMatcher.match(uri) > 0)
        {
            return queryRegistry(uri, as, s, as1, s1);
        }
        if (iFragmentUriMatcher.match(uri) > 0)
        {
            return queryFragment(uri, as, s, as1, s1);
        }
        if (iCatalogUriMatcher.match(uri) > 0)
        {
            return queryCatalog(uri, as, s, as1, s1);
        }
        if (iProviderUriMatcher.match(uri) > 0)
        {
            return queryProvider(uri, as, s, as1, s1);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to query, unknown URI: ")).append(uri).toString());
        }
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        if (iFileUriMatcher.match(uri) > 0)
        {
            return updateFile(uri, contentvalues, s, as);
        }
        if (iRegistryUriMatcher.match(uri) > 0)
        {
            return updateRegistry(uri, contentvalues, s, as);
        }
        if (iFragmentUriMatcher.match(uri) > 0)
        {
            return updateFragment(uri, contentvalues, s, as);
        }
        if (iCatalogUriMatcher.match(uri) > 0)
        {
            return updateCatalog(uri, contentvalues, s, as);
        }
        if (iProviderUriMatcher.match(uri) > 0)
        {
            return updateProvider(uri, contentvalues, s, as);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Failed to update, unknown URI")).append(uri).toString());
        }
    }

    static 
    {
        iProviderProjectionMap = new HashMap();
        iProviderProjectionMap.put("_id", "_id");
        iProviderProjectionMap.put("provider", "provider");
        iFileProjectionMap = new HashMap();
        iFileProjectionMap.put("_id", "_id");
        iFileProjectionMap.put("uuid", "uuid");
        iFileProjectionMap.put("parentUuid", "parentUuid");
        iFileProjectionMap.put("assetUrl", "assetUrl");
        iFileProjectionMap.put("description", "description");
        iFileProjectionMap.put("expectedSize", "expectedSize");
        iFileProjectionMap.put("currentSize", "currentSize");
        iFileProjectionMap.put("filePath", "filePath");
        iFileProjectionMap.put("errorType", "errorType");
        iFileProjectionMap.put("assetId", "assetId");
        iFileProjectionMap.put("mimeType", "mimeType");
        iFileProjectionMap.put("fileHash", "fileHash");
        iFileProjectionMap.put("errorCount", "errorCount");
        iFileProjectionMap.put("creationTime", "creationTime");
        iFileProjectionMap.put("modifyTime", "modifyTime");
        iFileProjectionMap.put("completeTime", "completeTime");
        iFileProjectionMap.put("pending", "pending");
        iFileProjectionMap.put("addedToQueue", "addedToQueue");
        iFileProjectionMap.put("contentType", "contentType");
        iFileProjectionMap.put("clientAuthority", "clientAuthority");
        iFileProjectionMap.put("hashState", "hashState");
        iFileProjectionMap.put("hlsFragmentCount", "hlsFragmentCount");
        iFileProjectionMap.put("hlsFragmentCompletedCount", "hlsFragmentCompletedCount");
        iFileProjectionMap.put("contentState", "contentState");
        iRegistryProjectionMap = new HashMap();
        iRegistryProjectionMap.put("_id", "_id");
        iRegistryProjectionMap.put("name", "name");
        iRegistryProjectionMap.put("value", "value");
        iFragmentProjectionMap = new HashMap();
        iFragmentProjectionMap.put("_id", "_id");
        iFragmentProjectionMap.put("parentUuid", "parentUuid");
        iFragmentProjectionMap.put("assetUrl", "assetUrl");
        iFragmentProjectionMap.put("expectedSize", "expectedSize");
        iFragmentProjectionMap.put("currentSize", "currentSize");
        iFragmentProjectionMap.put("filePath", "filePath");
        iFragmentProjectionMap.put("errorType", "errorType");
        iFragmentProjectionMap.put("creationTime", "creationTime");
        iFragmentProjectionMap.put("modifyTime", "modifyTime");
        iFragmentProjectionMap.put("completeTime", "completeTime");
        iFragmentProjectionMap.put("pending", "pending");
        iCatalogProjectionMap = new HashMap();
        iCatalogProjectionMap.put("_id", "_id");
        iCatalogProjectionMap.put("accessWindow", "accessWindow");
        iCatalogProjectionMap.put("category", "category");
        iCatalogProjectionMap.put("catalogExpiry", "catalogExpiry");
        iCatalogProjectionMap.put("completeTime", "completeTime");
        iCatalogProjectionMap.put("vnd.android.cursor.item/vnd.virtuososdk.Catalog", "vnd.android.cursor.item/vnd.virtuososdk.Catalog");
        iCatalogProjectionMap.put("contentRating", "contentRating");
        iCatalogProjectionMap.put("vnd.android.cursor.dir/vnd.virtuososdk.Catalog", "vnd.android.cursor.dir/vnd.virtuososdk.Catalog");
        iCatalogProjectionMap.put("contentUrl", "contentUrl");
        iCatalogProjectionMap.put("creationTime", "creationTime");
        iCatalogProjectionMap.put("desc", "desc");
        iCatalogProjectionMap.put("downloadEnabled", "downloadEnabled");
        iCatalogProjectionMap.put("downloadExpiry", "downloadExpiry");
        iCatalogProjectionMap.put("duration", "duration");
        iCatalogProjectionMap.put("expiryDate", "expiryDate");
        iCatalogProjectionMap.put("featured", "featured");
        iCatalogProjectionMap.put("genre", "genre");
        iCatalogProjectionMap.put("image", "image");
        iCatalogProjectionMap.put("thumbnail", "thumbnail");
        iCatalogProjectionMap.put("modifyTime", "modifyTime");
        iCatalogProjectionMap.put("parent", "parent");
        iCatalogProjectionMap.put("streamUrl", "streamUrl");
        iCatalogProjectionMap.put("viewedTime", "viewedTime");
        iCatalogProjectionMap.put("popular", "popular");
        iCatalogProjectionMap.put("title", "title");
        iCatalogProjectionMap.put("type", "type");
        iCatalogProjectionMap.put("filePath", "filePath");
        iCatalogProjectionMap.put("errorType", "errorType");
        iCatalogProjectionMap.put("fileUuid", "fileUuid");
        iCatalogProjectionMap.put("userRating", "userRating");
        iCatalogProjectionMap.put("network", "network");
        iNetworkProjectionMap = new HashMap();
        iNetworkProjectionMap.put("_id", "_id");
        iNetworkProjectionMap.put("network_name", "network_name");
        iNetworkProjectionMap.put("network_image_url", "network_image_url");
        iNetworkProjectionMap.put("network_image_thumbnail_url", "network_image_thumbnail_url");
    }
}
