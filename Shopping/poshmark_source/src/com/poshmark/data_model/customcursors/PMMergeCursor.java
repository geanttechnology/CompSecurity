// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.customcursors;

import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.DataSetObserver;

// Referenced classes of package com.poshmark.data_model.customcursors:
//            CustomMatrixCursor

public class PMMergeCursor extends AbstractCursor
{

    private CustomMatrixCursor mCursor;
    private CustomMatrixCursor mCursors[];
    private DataSetObserver mObserver;

    public PMMergeCursor(CustomMatrixCursor acustommatrixcursor[])
    {
        mObserver = new DataSetObserver() ;
        mCursors = acustommatrixcursor;
        mCursor = acustommatrixcursor[0];
        int i = 0;
        while (i < mCursors.length) 
        {
            if (mCursors[i] != null)
            {
                mCursors[i].registerDataSetObserver(mObserver);
            }
            i++;
        }
    }

    public void close()
    {
        int j = mCursors.length;
        int i = 0;
        while (i < j) 
        {
            if (mCursors[i] != null)
            {
                mCursors[i].close();
            }
            i++;
        }
        close();
    }

    public void deactivate()
    {
        int j = mCursors.length;
        for (int i = 0; i < j; i++)
        {
            if (mCursors[i] != null)
            {
                mCursors[i].deactivate();
            }
        }

        deactivate();
    }

    public Object get(int i)
    {
        return mCursor.get(i);
    }

    public byte[] getBlob(int i)
    {
        return mCursor.getBlob(i);
    }

    public String[] getColumnNames()
    {
        if (mCursor != null)
        {
            return mCursor.getColumnNames();
        } else
        {
            return new String[0];
        }
    }

    public int getCount()
    {
        int j = 0;
        int l = mCursors.length;
        for (int i = 0; i < l;)
        {
            int k = j;
            if (mCursors[i] != null)
            {
                k = j + mCursors[i].getCount();
            }
            i++;
            j = k;
        }

        return j;
    }

    public CustomMatrixCursor getCurrentCursor()
    {
        return mCursor;
    }

    public CustomMatrixCursor getCursorAtPos(int i)
    {
        if (i < mCursors.length)
        {
            return mCursors[i];
        } else
        {
            return null;
        }
    }

    public double getDouble(int i)
    {
        return mCursor.getDouble(i);
    }

    public float getFloat(int i)
    {
        return mCursor.getFloat(i);
    }

    public int getInt(int i)
    {
        return mCursor.getInt(i);
    }

    public long getLong(int i)
    {
        return mCursor.getLong(i);
    }

    public short getShort(int i)
    {
        return mCursor.getShort(i);
    }

    public String getString(int i)
    {
        return mCursor.getString(i);
    }

    public int getType(int i)
    {
        return mCursor.getType(i);
    }

    public boolean isNull(int i)
    {
        return mCursor.isNull(i);
    }

    public boolean onMove(int i, int j)
    {
        int k;
        int l;
        mCursor = null;
        k = 0;
        l = mCursors.length;
        i = 0;
_L5:
        if (i >= l) goto _L2; else goto _L1
_L1:
        if (mCursors[i] != null) goto _L4; else goto _L3
_L3:
        i++;
          goto _L5
_L4:
        if (j >= mCursors[i].getCount() + k)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        mCursor = mCursors[i];
_L2:
        if (mCursor != null)
        {
            return mCursor.moveToPosition(j - k);
        } else
        {
            return false;
        }
        k += mCursors[i].getCount();
          goto _L3
    }

    public void registerContentObserver(ContentObserver contentobserver)
    {
        int j = mCursors.length;
        for (int i = 0; i < j; i++)
        {
            if (mCursors[i] != null)
            {
                mCursors[i].registerContentObserver(contentobserver);
            }
        }

    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        int j = mCursors.length;
        for (int i = 0; i < j; i++)
        {
            if (mCursors[i] != null)
            {
                mCursors[i].registerDataSetObserver(datasetobserver);
            }
        }

    }

    public boolean requery()
    {
        int i;
        int j;
        j = mCursors.length;
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L1
_L5:
        i++;
        if (true) goto _L3; else goto _L2
_L1:
        if (mCursors[i] == null || mCursors[i].requery()) goto _L5; else goto _L4
_L4:
        return false;
_L2:
        return true;
    }

    public void setCursor(CustomMatrixCursor custommatrixcursor, int i)
    {
        if (i < mCursors.length)
        {
            int j = getPosition();
            mCursors[i] = custommatrixcursor;
            mCursor = null;
            mPos = -1;
            custommatrixcursor.registerDataSetObserver(mObserver);
            move(j);
        }
    }

    public void unregisterContentObserver(ContentObserver contentobserver)
    {
        int j = mCursors.length;
        for (int i = 0; i < j; i++)
        {
            if (mCursors[i] != null)
            {
                mCursors[i].unregisterContentObserver(contentobserver);
            }
        }

    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        int j = mCursors.length;
        for (int i = 0; i < j; i++)
        {
            if (mCursors[i] != null)
            {
                mCursors[i].unregisterDataSetObserver(datasetobserver);
            }
        }

    }


/*
    static int access$002(PMMergeCursor pmmergecursor, int i)
    {
        pmmergecursor.mPos = i;
        return i;
    }

*/


/*
    static int access$102(PMMergeCursor pmmergecursor, int i)
    {
        pmmergecursor.mPos = i;
        return i;
    }

*/
}
