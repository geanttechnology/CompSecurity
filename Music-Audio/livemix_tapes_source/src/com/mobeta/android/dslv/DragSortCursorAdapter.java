// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class DragSortCursorAdapter extends CursorAdapter
    implements DragSortListView.DragSortListener
{

    public static final int REMOVED = -1;
    private SparseIntArray mListMapping;
    private ArrayList mRemovedCursorPositions;

    public DragSortCursorAdapter(Context context, Cursor cursor)
    {
        super(context, cursor);
        mListMapping = new SparseIntArray();
        mRemovedCursorPositions = new ArrayList();
    }

    public DragSortCursorAdapter(Context context, Cursor cursor, int i)
    {
        super(context, cursor, i);
        mListMapping = new SparseIntArray();
        mRemovedCursorPositions = new ArrayList();
    }

    public DragSortCursorAdapter(Context context, Cursor cursor, boolean flag)
    {
        super(context, cursor, flag);
        mListMapping = new SparseIntArray();
        mRemovedCursorPositions = new ArrayList();
    }

    private void cleanMapping()
    {
        ArrayList arraylist;
        int i;
        int j;
        arraylist = new ArrayList();
        j = mListMapping.size();
        i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        j = arraylist.size();
        i = 0;
_L4:
        if (i >= j)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_78;
_L2:
        if (mListMapping.keyAt(i) == mListMapping.valueAt(i))
        {
            arraylist.add(Integer.valueOf(mListMapping.keyAt(i)));
        }
        i++;
          goto _L3
        mListMapping.delete(((Integer)arraylist.get(i)).intValue());
        i++;
          goto _L4
    }

    private void resetMappings()
    {
        mListMapping.clear();
        mRemovedCursorPositions.clear();
    }

    public void changeCursor(Cursor cursor)
    {
        super.changeCursor(cursor);
        resetMappings();
    }

    public void drag(int i, int j)
    {
    }

    public void drop(int i, int j)
    {
        if (i == j) goto _L2; else goto _L1
_L1:
        int k;
        k = mListMapping.get(i, i);
        if (i <= j)
        {
            break MISSING_BLOCK_LABEL_71;
        }
_L5:
        if (i > j) goto _L4; else goto _L3
_L3:
        mListMapping.put(j, k);
        cleanMapping();
        notifyDataSetChanged();
_L2:
        return;
_L4:
        mListMapping.put(i, mListMapping.get(i - 1, i - 1));
        i--;
          goto _L5
        while (i < j) 
        {
            mListMapping.put(i, mListMapping.get(i + 1, i + 1));
            i++;
        }
          goto _L3
    }

    public int getCount()
    {
        return super.getCount() - mRemovedCursorPositions.size();
    }

    public int getCursorPosition(int i)
    {
        return mListMapping.get(i, i);
    }

    public ArrayList getCursorPositions()
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        do
        {
            if (i >= getCount())
            {
                return arraylist;
            }
            arraylist.add(Integer.valueOf(mListMapping.get(i, i)));
            i++;
        } while (true);
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return super.getDropDownView(mListMapping.get(i, i), view, viewgroup);
    }

    public Object getItem(int i)
    {
        return super.getItem(mListMapping.get(i, i));
    }

    public long getItemId(int i)
    {
        return super.getItemId(mListMapping.get(i, i));
    }

    public int getListPosition(int i)
    {
        if (mRemovedCursorPositions.contains(Integer.valueOf(i)))
        {
            i = -1;
        } else
        {
            int j = mListMapping.indexOfValue(i);
            if (j >= 0)
            {
                return mListMapping.keyAt(j);
            }
        }
        return i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return super.getView(mListMapping.get(i, i), view, viewgroup);
    }

    public void remove(int i)
    {
        int j = mListMapping.get(i, i);
        if (!mRemovedCursorPositions.contains(Integer.valueOf(j)))
        {
            mRemovedCursorPositions.add(Integer.valueOf(j));
        }
        j = getCount();
        do
        {
            if (i >= j)
            {
                mListMapping.delete(j);
                cleanMapping();
                notifyDataSetChanged();
                return;
            }
            mListMapping.put(i, mListMapping.get(i + 1, i + 1));
            i++;
        } while (true);
    }

    public void reset()
    {
        resetMappings();
        notifyDataSetChanged();
    }

    public Cursor swapCursor(Cursor cursor)
    {
        cursor = super.swapCursor(cursor);
        resetMappings();
        return cursor;
    }
}
