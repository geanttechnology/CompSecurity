// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.ContentValues;
import com.amazon.gallery.foundation.utils.DebugAssert;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            SQLiteDaoUtil, ReadWriteSQLiteDatabase

public class EditHelper
{

    private final String columns[];
    private final ReadWriteSQLiteDatabase db;
    private ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement deleteStatement;
    private ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement insertStatement;
    private ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement replaceStatement;
    private final String tableName;
    private final String updateDeleteKeys[];
    private final int updateKeyIndices[];
    private ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement updateStatement;

    public transient EditHelper(ReadWriteSQLiteDatabase readwritesqlitedatabase, String s, String as[], String as1[])
    {
        db = readwritesqlitedatabase;
        tableName = s;
        columns = as;
        updateDeleteKeys = as1;
        updateKeyIndices = findKeyIndex(as, as1);
    }

    private void bindColumnValues(ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement, ContentValues contentvalues)
    {
        for (int i = 0; i < columns.length; i++)
        {
            readwritesqlitestatement.bindObject(i + 1, contentvalues.get(columns[i]));
        }

    }

    private String buildWhereClause()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("(");
        String as[] = updateDeleteKeys;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(as[i]).append(" = ? AND ");
        }

        stringbuilder.replace(stringbuilder.length() - 5, stringbuilder.length(), ")");
        return stringbuilder.toString();
    }

    private void closeStatement(ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement)
    {
        if (readwritesqlitestatement != null)
        {
            readwritesqlitestatement.close();
        }
    }

    private static int[] findKeyIndex(String as[], String as1[])
    {
        int ai[] = new int[as1.length];
        int i = 0;
label0:
        do
        {
            if (i < as1.length)
            {
                String s = as1[i];
                boolean flag1 = false;
                int j = 0;
                do
                {
label1:
                    {
                        boolean flag = flag1;
                        if (j < as.length)
                        {
                            if (!s.equals(as[j]))
                            {
                                break label1;
                            }
                            ai[i] = j + 1;
                            flag = true;
                        }
                        if (!flag)
                        {
                            ai[i] = -1;
                            DebugAssert.assertMsg((new StringBuilder()).append("columns doesn't contain the update / delete key: ").append(s).toString());
                        }
                        i++;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            return ai;
        } while (true);
    }

    private ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement getDeleteStatement()
    {
        if (deleteStatement == null)
        {
            String s = buildWhereClause();
            s = SQLiteDaoUtil.deleteClause(tableName, s);
            deleteStatement = db.compileStatement(s);
        } else
        {
            deleteStatement.clearBindings();
        }
        return deleteStatement;
    }

    private ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement getInsertStatement()
    {
        if (insertStatement == null)
        {
            String s = SQLiteDaoUtil.insertClause(tableName, columns);
            insertStatement = db.compileStatement(s);
        } else
        {
            insertStatement.clearBindings();
        }
        return insertStatement;
    }

    private ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement getReplaceStatement()
    {
        if (replaceStatement == null)
        {
            String s = SQLiteDaoUtil.replaceClause(tableName, columns);
            replaceStatement = db.compileStatement(s);
        } else
        {
            replaceStatement.clearBindings();
        }
        return replaceStatement;
    }

    private ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement getUpdateStatement()
    {
        if (updateStatement == null)
        {
            String s = buildWhereClause();
            s = SQLiteDaoUtil.updateClause(tableName, columns, s);
            updateStatement = db.compileStatement(s);
        } else
        {
            updateStatement.clearBindings();
        }
        return updateStatement;
    }

    public void close()
    {
        closeStatement(insertStatement);
        closeStatement(replaceStatement);
        closeStatement(updateStatement);
        closeStatement(deleteStatement);
    }

    public transient int delete(Object aobj[])
    {
        if (aobj == null || aobj.length != updateDeleteKeys.length)
        {
            throw new IllegalArgumentException();
        }
        ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement = getDeleteStatement();
        for (int i = 0; i < updateDeleteKeys.length; i++)
        {
            readwritesqlitestatement.bindObject(i + 1, aobj[i]);
        }

        return readwritesqlitestatement.executeUpdateDelete();
    }

    public long insert(ContentValues contentvalues)
    {
        ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement = getInsertStatement();
        bindColumnValues(readwritesqlitestatement, contentvalues);
        return readwritesqlitestatement.executeInsert();
    }

    public long replace(ContentValues contentvalues)
    {
        ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement = getReplaceStatement();
        bindColumnValues(readwritesqlitestatement, contentvalues);
        return readwritesqlitestatement.executeInsert();
    }

    public transient int update(ContentValues contentvalues, Object aobj[])
    {
        if (aobj == null || aobj.length != updateDeleteKeys.length)
        {
            throw new IllegalArgumentException();
        }
        ReadWriteSQLiteDatabase.ReadWriteSQLiteStatement readwritesqlitestatement = getUpdateStatement();
        bindColumnValues(readwritesqlitestatement, contentvalues);
        for (int i = 0; i < updateDeleteKeys.length; i++)
        {
            int j = updateKeyIndices[i];
            if (j > 0)
            {
                readwritesqlitestatement.bindObject(j, aobj[i]);
            }
            readwritesqlitestatement.bindObject(columns.length + i + 1, aobj[i]);
        }

        return readwritesqlitestatement.executeUpdateDelete();
    }
}
