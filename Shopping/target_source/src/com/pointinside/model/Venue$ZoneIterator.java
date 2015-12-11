// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.pointinside.model:
//            Venue, Zone

private static class <init>
{
    private static final class Move extends Enum
    {

        private static final Move $VALUES[];
        public static final Move NEXT;
        public static final Move PREV;

        public static Move valueOf(String s)
        {
            return (Move)Enum.valueOf(com/pointinside/model/Venue$ZoneIterator$Move, s);
        }

        public static Move[] values()
        {
            return (Move[])$VALUES.clone();
        }

        static 
        {
            NEXT = new Move("NEXT", 0);
            PREV = new Move("PREV", 1);
            $VALUES = (new Move[] {
                NEXT, PREV
            });
        }

        private Move(String s, int i)
        {
            super(s, i);
        }
    }


    private Move mLastMove;
    private List mList;
    private ListIterator mListIter;

    private Zone getCurrent()
    {
        Zone zone1;
        switch (com.pointinside.model.Venue.ZoneIterator.Move[mLastMove.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            Zone zone = (Zone)mListIter.previous();
            mLastMove = Move.PREV;
            return zone;

        case 2: // '\002'
            zone1 = (Zone)mListIter.next();
            break;
        }
        mLastMove = Move.NEXT;
        return zone1;
    }

    private void gotoFirst()
    {
        mLastMove = Move.PREV;
        mListIter = mList.listIterator();
    }

    private void gotoLast()
    {
        mLastMove = Move.NEXT;
        mListIter = mList.listIterator(mList.size());
    }

    private void moveToUUID(String s)
        throws IllegalArgumentException
    {
        gotoFirst();
        for (; mListIter.hasNext() && !getCurrent().getUUID().equals(s); next()) { }
        if (!getCurrent().getUUID().equals(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("UUID: ").append(s).append(" not found in venue").toString());
        } else
        {
            return;
        }
    }

    private Zone next()
    {
        if (mLastMove == Move.PREV)
        {
            mListIter.next();
        }
        if (!mListIter.hasNext())
        {
            gotoFirst();
        }
        mLastMove = Move.NEXT;
        return (Zone)mListIter.next();
    }

    private Zone previous()
    {
        if (mLastMove == Move.NEXT)
        {
            mListIter.previous();
        }
        if (!mListIter.hasPrevious())
        {
            gotoLast();
        }
        mLastMove = Move.PREV;
        return (Zone)mListIter.previous();
    }






    private Move(List list)
    {
        mList = list;
        mListIter = mList.listIterator();
        mLastMove = Move.PREV;
    }

    Move.PREV(List list, Move.PREV prev)
    {
        this(list);
    }
}
