// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.youcammakeup.database.more.i;
import com.cyberlink.youcammakeup.h;
import com.pf.common.utility.m;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.database.more.makeup:
//            MakeupItemMetadata

public class e
{

    private final SQLiteDatabase a = h.a();
    private final SQLiteDatabase b = h.b();

    public e()
    {
    }

    public MakeupItemMetadata a(long l)
    {
        Cursor cursor;
        String as[] = i.a();
        cursor = a.query("MakeupItemCache", as, "MIid=?", new String[] {
            String.valueOf(l)
        }, null, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        Object obj = cursor;
        m.e("MakeupItemDAO", "Failed to query: cursor is null");
        if (cursor != null)
        {
            cursor.close();
        }
        obj = null;
_L4:
        return ((MakeupItemMetadata) (obj));
_L2:
        obj = cursor;
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj = cursor;
        m.b("MakeupItemDAO", "Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        obj = cursor;
        int j = cursor.getColumnIndex("JsonString");
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = cursor;
        m.e("MakeupItemDAO", "cursor.getColumnIndex() returned negative number");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        obj = cursor;
        MakeupItemMetadata makeupitemmetadata = new MakeupItemMetadata(new JSONObject(cursor.getString(j)));
        obj = makeupitemmetadata;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return makeupitemmetadata;
        Exception exception1;
        exception1;
        cursor = null;
_L8:
        obj = cursor;
        m.e("MakeupItemDAO", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        Exception exception;
        exception;
        obj = null;
_L6:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public MakeupItemMetadata a(long l, MakeupItemMetadata makeupitemmetadata)
    {
        MakeupItemMetadata makeupitemmetadata1 = a(l);
        if (makeupitemmetadata1 != null)
        {
            makeupitemmetadata = makeupitemmetadata1;
        } else
        {
            android.content.ContentValues contentvalues = makeupitemmetadata.a(l, 0L);
            try
            {
                l = b.insert("MakeupItemCache", null, contentvalues);
            }
            // Misplaced declaration of an exception variable
            catch (MakeupItemMetadata makeupitemmetadata)
            {
                return null;
            }
            if (l < 0L)
            {
                return null;
            }
        }
        return makeupitemmetadata;
    }

    public MakeupItemMetadata a(String s)
    {
        Cursor cursor;
        String as[] = i.a();
        cursor = a.query("MakeupItemCache", as, "Ext_1=?", new String[] {
            s
        }, null, null, null, null);
        if (cursor != null) goto _L2; else goto _L1
_L1:
        s = cursor;
        m.e("MakeupItemDAO", "Failed to query: cursor is null");
        if (cursor != null)
        {
            cursor.close();
        }
        s = null;
_L4:
        return s;
_L2:
        s = cursor;
        if (cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_90;
        }
        s = cursor;
        m.b("MakeupItemDAO", "Failure of cursor.moveToFirst().");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        s = cursor;
        int j = cursor.getColumnIndex("JsonString");
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        s = cursor;
        m.e("MakeupItemDAO", "cursor.getColumnIndex() returned negative number");
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        s = cursor;
        MakeupItemMetadata makeupitemmetadata = new MakeupItemMetadata(new JSONObject(cursor.getString(j)));
        s = makeupitemmetadata;
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return makeupitemmetadata;
        Exception exception1;
        exception1;
        cursor = null;
_L8:
        s = cursor;
        m.e("MakeupItemDAO", (new StringBuilder()).append("Exception: ").append(exception1.getMessage()).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        return null;
        Exception exception;
        exception;
        s = null;
_L6:
        if (s != null)
        {
            s.close();
        }
        throw exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean a()
    {
        try
        {
            b.delete("MakeupItemCache", null, null);
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }
}
