// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.Cursor;
import co.vine.android.util.CrashUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package co.vine.android.provider:
//            GroupCursor

public abstract class ExclusiveHybridCursor extends GroupCursor
{
    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode CURSOR;
        public static final Mode LIST;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(co/vine/android/provider/ExclusiveHybridCursor$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            CURSOR = new Mode("CURSOR", 0);
            LIST = new Mode("LIST", 1);
            $VALUES = (new Mode[] {
                CURSOR, LIST
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }


    private Mode mMode;
    private List mRemoteData;

    public ExclusiveHybridCursor(Cursor cursor)
    {
        this(cursor, 20);
    }

    public ExclusiveHybridCursor(Cursor cursor, int i)
    {
        super(cursor, i);
        mMode = Mode.CURSOR;
    }

    public ExclusiveHybridCursor(ArrayList arraylist)
    {
        super(null);
        mMode = Mode.CURSOR;
        mRemoteData = arraylist;
    }

    public abstract Object createItemFromCursor(Cursor cursor);

    public abstract Object createItemsFromRemoteData(Object obj);

    public Mode getMode()
    {
        return mMode;
    }

    public boolean isLastItem()
    {
        return mRemoteData != null && mRemoteData.size() >= mCursorPosition + 1 || mCursor != null && mCursor.getCount() >= mCursorPosition;
    }

    public void onPrepare()
    {
        static class _cls1
        {

            static final int $SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode[];

            static 
            {
                $SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode = new int[Mode.values().length];
                try
                {
                    $SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode[Mode.LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode[Mode.CURSOR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.co.vine.android.provider.ExclusiveHybridCursor.Mode[mMode.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 102;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        mList = new ArrayList();
        int j = mRemoteData.size();
        int i = 0;
        while (i < j && i < mLimit) 
        {
            mList.add(createItemsFromRemoteData(mRemoteData.get(i)));
            i++;
        }
          goto _L1
_L3:
        Cursor cursor = mCursor;
        if (cursor != null && cursor.moveToFirst())
        {
            mList = new ArrayList();
            do
            {
                mList.add(createItemFromCursor(cursor));
                boolean flag;
                try
                {
                    flag = cursor.moveToNext();
                }
                catch (IllegalStateException illegalstateexception)
                {
                    CrashUtil.log("Failed to get cursor's row id.");
                    System.gc();
                    flag = cursor.moveToNext();
                }
            } while (flag && mLimit < 0);
            return;
        } else
        {
            mList = null;
            return;
        }
    }

    public void setMode(Mode mode)
    {
        mMode = mode;
    }
}
