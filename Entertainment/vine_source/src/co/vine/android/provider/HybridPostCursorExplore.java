// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.Cursor;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VinePost;
import co.vine.android.util.CrashUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package co.vine.android.provider:
//            HybridPostCursor

public class HybridPostCursorExplore extends HybridPostCursor
{

    public HybridPostCursorExplore(Cursor cursor)
    {
        this(cursor, 20);
    }

    public HybridPostCursorExplore(Cursor cursor, int i)
    {
        super(cursor, i);
    }

    public HybridPostCursorExplore(ArrayList arraylist, int i)
    {
        super(arraylist, i);
    }

    public void onPrepare()
    {
        VinePost vinepost1;
        Cursor cursor;
        int i;
        long l;
        boolean flag;
        cursor = mCursor;
        i = 0;
        flag = false;
        if (cursor == null || !cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_211;
        }
        l = 0L;
        vinepost1 = null;
        mList = new ArrayList();
_L2:
        VinePost vinepost;
        int j;
        long l1;
        long l2;
        l2 = cursor.getLong(1);
        j = i;
        l1 = l;
        vinepost = vinepost1;
        if (l2 != l)
        {
            j = i;
            if (vinepost1 != null)
            {
                mList.add(vinepost1);
                j = i + 1;
            }
            l1 = l2;
            vinepost = VinePost.fromExplore(cursor);
        }
        boolean flag1 = cursor.moveToNext();
        flag = flag1;
_L3:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        l = l1;
        vinepost1 = vinepost;
        if (j < mLimit) goto _L2; else goto _L1
_L1:
        if (vinepost != null)
        {
            mList.add(vinepost);
        }
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        CrashUtil.logException(new VineLoggingException(), "Failed to get cursor's row id. total: {}, current: {}, limit: {}, postId: {}.", new Object[] {
            Integer.valueOf(cursor.getCount()), Integer.valueOf(j), Integer.valueOf(mLimit), Long.valueOf(l2)
        });
          goto _L3
        mList = null;
        return;
    }
}
