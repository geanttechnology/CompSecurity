// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.message;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage;

// Referenced classes of package com.tencent.mm.sdk.message:
//            RMsgInfoDB, RMsgInfo

public class RMsgInfoStorage extends MStorage
{

    public static final String AUTHORITY = "com.tencent.mm.sdk.msginfo.provider";
    public static final String PRIMARY_KEY = "msgId";
    ISQLiteDatabase P;

    private RMsgInfoStorage(ISQLiteDatabase isqlitedatabase)
    {
        P = null;
        P = isqlitedatabase;
    }

    public static RMsgInfoStorage create(Context context)
    {
        return new RMsgInfoStorage(new RMsgInfoDB(context));
    }

    public int doDelete(long l)
    {
        int i = P.delete("message", "msgId=?", new String[] {
            String.valueOf(l)
        });
        if (i > 0)
        {
            notify();
        }
        return i;
    }

    public long doInsert(RMsgInfo rmsginfo)
    {
        long l;
        if (rmsginfo == null || Util.isNullOrNil(rmsginfo.field_talker))
        {
            l = -1L;
        } else
        {
            rmsginfo = rmsginfo.convertTo();
            long l1 = P.insert("message", "msgId", rmsginfo);
            l = l1;
            if (l1 > 0L)
            {
                notify();
                return l1;
            }
        }
        return l;
    }

    public int doUpdate(long l, RMsgInfo rmsginfo)
    {
        int i;
        if (rmsginfo == null || Util.isNullOrNil(rmsginfo.field_talker))
        {
            i = -1;
        } else
        {
            rmsginfo = rmsginfo.convertTo();
            int j = P.update("message", rmsginfo, "msgId=?", new String[] {
                String.valueOf(l)
            });
            i = j;
            if (j > 0)
            {
                notify();
                return j;
            }
        }
        return i;
    }

    public RMsgInfo getMsgById(long l)
    {
        Cursor cursor = P.query("message", null, "msgId=?", new String[] {
            String.valueOf(l)
        }, null, null, null);
        if (cursor == null)
        {
            return null;
        }
        if (cursor.getCount() == 0)
        {
            cursor.close();
            return null;
        } else
        {
            RMsgInfo rmsginfo = new RMsgInfo();
            rmsginfo.convertFrom(cursor);
            return rmsginfo;
        }
    }

    public Cursor getMsgByTalker(String s)
    {
        return P.query("message", null, "talker=?", new String[] {
            s
        }, null, null, null);
    }
}
