// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

// Referenced classes of package com.tencent.mm.sdk.storage:
//            MDBItem, CursorFieldHelper

public abstract class MAutoDBItem
    implements MDBItem
{

    public static final String SYSTEM_ROWID_FIELD = "rowid";
    public long systemRowid;

    public MAutoDBItem()
    {
        systemRowid = -1L;
    }

    public static boolean checkIOEqual(ContentValues contentvalues, Cursor cursor)
    {
        if (contentvalues == null)
        {
            return cursor == null;
        }
        if (cursor == null || cursor.getCount() != 1)
        {
            return false;
        }
        cursor.moveToFirst();
        int l = cursor.getColumnCount();
        int k = contentvalues.size();
        int i = k;
        if (contentvalues.containsKey("rowid"))
        {
            i = k - 1;
        }
        k = l;
        if (cursor.getColumnIndex("rowid") != -1)
        {
            k = l - 1;
        }
        if (i != k)
        {
            return false;
        }
        Iterator iterator = contentvalues.valueSet().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (String)((java.util.Map.Entry)iterator.next()).getKey();
        if (((String) (obj)).equals("rowid")) goto _L4; else goto _L3
_L3:
        int j = cursor.getColumnIndex(((String) (obj)));
        if (j == -1)
        {
            return false;
        }
        byte abyte0[];
        if (contentvalues.get(((String) (obj))) instanceof byte[])
        {
            obj = (byte[])contentvalues.get(((String) (obj)));
            abyte0 = cursor.getBlob(j);
            break MISSING_BLOCK_LABEL_192;
        }
          goto _L5
_L7:
        if (j >= obj.length) goto _L4; else goto _L6
_L6:
        if (obj[j] != abyte0[j])
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_297;
_L5:
        if (cursor.getString(j) == null && contentvalues.get(((String) (obj))) != null)
        {
            return false;
        }
        if (contentvalues.get(((String) (obj))) == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = contentvalues.get(((String) (obj))).toString().equals(cursor.getString(j));
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            contentvalues.printStackTrace();
            return false;
        }
        if (!flag)
        {
            return false;
        }
          goto _L4
_L2:
        return true;
        if (obj.length != abyte0.length)
        {
            return false;
        }
        j = 0;
          goto _L7
        j++;
          goto _L7
    }

    public static Cursor getCursorForProjection(ContentValues contentvalues, String as[])
    {
        Object aobj[] = new Object[as.length];
        for (int i = 0; i < aobj.length; i++)
        {
            aobj[i] = contentvalues.get(as[i]);
        }

        contentvalues = new MatrixCursor(as);
        contentvalues.addRow(aobj);
        return contentvalues;
    }

    public static String[] getFullColumns(Field afield[])
    {
        String as[] = new String[afield.length + 1];
        for (int i = 0; i < afield.length; i++)
        {
            as[i] = afield[i].getName().substring(6);
        }

        as[afield.length] = "rowid";
        return as;
    }

    public static Field[] getValidFields(Class class1)
    {
        LinkedList linkedlist = new LinkedList();
        class1 = class1.getDeclaredFields();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            Field field = class1[i];
            int k = field.getModifiers();
            String s = field.getName();
            if (s == null || !s.startsWith("field_") || !Modifier.isPublic(k) || Modifier.isFinal(k))
            {
                continue;
            }
            if (s.endsWith("field_rowid"))
            {
                Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
            }
            linkedlist.add(field);
        }

        return (Field[])linkedlist.toArray(new Field[0]);
    }

    public static Map identify(Field afield[], StringBuilder stringbuilder, String s)
    {
        HashMap hashmap = new HashMap();
        int i = 0;
        while (i < afield.length) 
        {
            String s2 = CursorFieldHelper.type(afield[i].getType());
            if (s2 == null)
            {
                Log.e("MicroMsg.SDK.MAutoDBItem", (new StringBuilder("failed identify on column: ")).append(afield[i].getName()).append(", skipped").toString());
            } else
            {
                String s3 = afield[i].getName().substring(6);
                if (stringbuilder != null)
                {
                    StringBuilder stringbuilder1 = (new StringBuilder()).append(s3).append(" ").append(s2);
                    String s1;
                    if (s3.equals(s))
                    {
                        s1 = " PRIMARY KEY ";
                    } else
                    {
                        s1 = "";
                    }
                    stringbuilder.append(stringbuilder1.append(s1).toString());
                    if (i == afield.length - 1)
                    {
                        s1 = "";
                    } else
                    {
                        s1 = ", ";
                    }
                    stringbuilder.append(s1);
                }
                hashmap.put(s3, s2);
            }
            i++;
        }
        return hashmap;
    }

    public void convertFrom(Cursor cursor)
    {
        Field afield[];
        int i;
        int j;
        afield = fields();
        j = afield.length;
        i = 0;
_L2:
        Field field;
        Object obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        field = afield[i];
        obj = field.getName().substring(6);
        int k = cursor.getColumnIndexOrThrow(((String) (obj)));
        if (k == -1)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = CursorFieldHelper.get(field.getType(), false);
        if (obj != null)
        {
            try
            {
                ((Method) (obj)).invoke(null, new Object[] {
                    field, this, cursor, Integer.valueOf(k)
                });
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_147;
        try
        {
            i = cursor.getColumnIndexOrThrow("rowid");
        }
        catch (Exception exception)
        {
            i = -1;
        }
        if (i > 0)
        {
            systemRowid = cursor.getLong(i);
        }
        return;
        Exception exception2;
        exception2;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ContentValues convertTo()
    {
        ContentValues contentvalues;
        Field afield[];
        int i;
        int j;
        contentvalues = new ContentValues();
        afield = fields();
        j = afield.length;
        i = 0;
_L2:
        Field field;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        field = afield[i];
        Method method = CursorFieldHelper.get(field.getType(), true);
        if (method != null)
        {
            try
            {
                method.invoke(null, new Object[] {
                    field, this, contentvalues
                });
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_108;
        if (systemRowid > 0L)
        {
            contentvalues.put("rowid", Long.valueOf(systemRowid));
        }
        return contentvalues;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public abstract Field[] fields();
}
