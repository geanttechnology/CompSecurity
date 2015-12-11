// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.interfaces.a;

import com.target.mothership.model.common.a.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;
import com.target.mothership.services.x;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class com.target.mothership.model.list.interfaces.a.a extends b
{
    public static final class a extends Enum
        implements j
    {

        private static final a $VALUES[];
        public static final a ERROR_LIST_ABOVE_MAXIMUM_QUANTITY;
        public static final a ERROR_LIST_ABOVE_MAX_POSITION;
        public static final a ERROR_LIST_BELOW_MINIMUM_QUANTITY;
        public static final a ERROR_LIST_BELOW_MIN_POSITION;
        public static final a ERROR_LIST_CANNOT_DELETE_DEFAULT_LIST;
        public static final a ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST;
        public static final a ERROR_LIST_DATABASERROR;
        public static final a ERROR_LIST_DATABASE_ERROR;
        public static final a ERROR_LIST_INVALID_ITEM_ID;
        public static final a ERROR_LIST_INVALID_LIST_ID;
        public static final a ERROR_LIST_INVALID_USER_ID;
        public static final a ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED;
        public static final a ERROR_LIST_MAX_LIST_COUNT_EXCEEDED;
        public static final a ERROR_LIST_NETWORK_ERROR;
        public static final a ERROR_LIST_NETWORK_ISSUE;
        public static final a UNKNOWN;
        private c mErrorCodes[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/model/list/interfaces/a/a$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        public c[] a()
        {
            return mErrorCodes;
        }

        static 
        {
            ERROR_LIST_NETWORK_ISSUE = new a("ERROR_LIST_NETWORK_ISSUE", 0, new c[] {
                c._ERR_LIST_NETWORK_ERROR
            });
            ERROR_LIST_DATABASERROR = new a("ERROR_LIST_DATABASERROR", 1, new c[] {
                c._ERR_LIST_DATABASE_ERROR
            });
            ERROR_LIST_NETWORK_ERROR = new a("ERROR_LIST_NETWORK_ERROR", 2, new c[] {
                c._ERR_LIST_DATABASE_ERROR
            });
            ERROR_LIST_DATABASE_ERROR = new a("ERROR_LIST_DATABASE_ERROR", 3, new c[] {
                c._ERR_LIST_DATABASE_ERROR
            });
            ERROR_LIST_BELOW_MINIMUM_QUANTITY = new a("ERROR_LIST_BELOW_MINIMUM_QUANTITY", 4, new c[] {
                c._ERR_LIST_BELOW_MINIMUM_QUANTITY
            });
            ERROR_LIST_ABOVE_MAXIMUM_QUANTITY = new a("ERROR_LIST_ABOVE_MAXIMUM_QUANTITY", 5, new c[] {
                c._ERR_LIST_ABOVE_MAXIMUM_QUANTITY
            });
            ERROR_LIST_CANNOT_DELETE_DEFAULT_LIST = new a("ERROR_LIST_CANNOT_DELETE_DEFAULT_LIST", 6, new c[] {
                c._ERR_LIST_CANNOT_DELETE_DEFAULT_LIST
            });
            ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST = new a("ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST", 7, new c[] {
                c._ERR_LIST_CANNOT_FIND_SPECIFIED_LIST
            });
            ERROR_LIST_MAX_LIST_COUNT_EXCEEDED = new a("ERROR_LIST_MAX_LIST_COUNT_EXCEEDED", 8, new c[] {
                c._ERR_LIST_MAX_LIST_COUNT_EXCEEDED
            });
            ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED = new a("ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED", 9, new c[] {
                c._ERR_LIST_MAX_ITEM_COUNT_EXCEEDED
            });
            ERROR_LIST_INVALID_USER_ID = new a("ERROR_LIST_INVALID_USER_ID", 10, new c[] {
                c._ERR_LIST_INVALID_USER_ID
            });
            ERROR_LIST_INVALID_LIST_ID = new a("ERROR_LIST_INVALID_LIST_ID", 11, new c[] {
                c._ERR_LIST_INVALID_LIST_ID
            });
            ERROR_LIST_INVALID_ITEM_ID = new a("ERROR_LIST_INVALID_ITEM_ID", 12, new c[] {
                c._ERR_LIST_INVALID_ITEM_ID
            });
            ERROR_LIST_BELOW_MIN_POSITION = new a("ERROR_LIST_BELOW_MIN_POSITION", 13, new c[] {
                c._ERR_LIST_BELOW_MIN_POSITION
            });
            ERROR_LIST_ABOVE_MAX_POSITION = new a("ERROR_LIST_ABOVE_MAX_POSITION", 14, new c[] {
                c._ERR_LIST_ABOVE_MAX_POSITION
            });
            UNKNOWN = new a("UNKNOWN", 15, new c[] {
                c._ERR_UNKNOWN
            });
            $VALUES = (new a[] {
                ERROR_LIST_NETWORK_ISSUE, ERROR_LIST_DATABASERROR, ERROR_LIST_NETWORK_ERROR, ERROR_LIST_DATABASE_ERROR, ERROR_LIST_BELOW_MINIMUM_QUANTITY, ERROR_LIST_ABOVE_MAXIMUM_QUANTITY, ERROR_LIST_CANNOT_DELETE_DEFAULT_LIST, ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST, ERROR_LIST_MAX_LIST_COUNT_EXCEEDED, ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED, 
                ERROR_LIST_INVALID_USER_ID, ERROR_LIST_INVALID_LIST_ID, ERROR_LIST_INVALID_ITEM_ID, ERROR_LIST_BELOW_MIN_POSITION, ERROR_LIST_ABOVE_MAX_POSITION, UNKNOWN
            });
        }

        private transient a(String s, int i, c ac[])
        {
            super(s, i);
            mErrorCodes = ac;
        }
    }


    private x mCause;
    private a mReason;
    private List mReasons;
    private SQLException mSQLException;

    public com.target.mothership.model.list.interfaces.a.a()
    {
    }

    public com.target.mothership.model.list.interfaces.a.a(a a1)
    {
        mReasons = new ArrayList();
        mReasons.add(a1);
    }

    public com.target.mothership.model.list.interfaces.a.a(SQLException sqlexception)
    {
        mSQLException = sqlexception;
        mReasons = new ArrayList();
        mReasons.add(a.ERROR_LIST_DATABASE_ERROR);
    }

    public a a()
    {
        return mReason;
    }

    public volatile void a(j j)
    {
        a((a)j);
    }

    public void a(a a1)
    {
        mReason = a1;
    }

    public void a(x x)
    {
        mCause = x;
    }

    public void a(List list)
    {
        mReasons = list;
    }

    public a[] b()
    {
        return a.values();
    }

    public j[] c()
    {
        return b();
    }

    public x d()
    {
        return mCause;
    }

    public j e()
    {
        return a();
    }

    public List f()
    {
        return mReasons;
    }

    public String g()
    {
        StringBuffer stringbuffer = new StringBuffer();
        Iterator iterator = f().iterator();
        String s = "";
        while (iterator.hasNext()) 
        {
            c ac[] = ((a)iterator.next()).a();
            int j = ac.length;
            int i = 0;
            while (i < j) 
            {
                c c1 = ac[i];
                stringbuffer.append(s).append(c1.a());
                i++;
                s = ", ";
            }
        }
        return stringbuffer.toString();
    }
}
