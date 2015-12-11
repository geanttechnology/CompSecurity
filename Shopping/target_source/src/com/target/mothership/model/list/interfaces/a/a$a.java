// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list.interfaces.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.j;

// Referenced classes of package com.target.mothership.model.list.interfaces.a:
//            a

public static final class mErrorCodes extends Enum
    implements j
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN ERROR_LIST_ABOVE_MAXIMUM_QUANTITY;
    public static final UNKNOWN ERROR_LIST_ABOVE_MAX_POSITION;
    public static final UNKNOWN ERROR_LIST_BELOW_MINIMUM_QUANTITY;
    public static final UNKNOWN ERROR_LIST_BELOW_MIN_POSITION;
    public static final UNKNOWN ERROR_LIST_CANNOT_DELETE_DEFAULT_LIST;
    public static final UNKNOWN ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST;
    public static final UNKNOWN ERROR_LIST_DATABASERROR;
    public static final UNKNOWN ERROR_LIST_DATABASE_ERROR;
    public static final UNKNOWN ERROR_LIST_INVALID_ITEM_ID;
    public static final UNKNOWN ERROR_LIST_INVALID_LIST_ID;
    public static final UNKNOWN ERROR_LIST_INVALID_USER_ID;
    public static final UNKNOWN ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED;
    public static final UNKNOWN ERROR_LIST_MAX_LIST_COUNT_EXCEEDED;
    public static final UNKNOWN ERROR_LIST_NETWORK_ERROR;
    public static final UNKNOWN ERROR_LIST_NETWORK_ISSUE;
    public static final UNKNOWN UNKNOWN;
    private c mErrorCodes[];

    public static mErrorCodes valueOf(String s)
    {
        return (mErrorCodes)Enum.valueOf(com/target/mothership/model/list/interfaces/a/a$a, s);
    }

    public static mErrorCodes[] values()
    {
        return (mErrorCodes[])$VALUES.clone();
    }

    public c[] a()
    {
        return mErrorCodes;
    }

    static 
    {
        ERROR_LIST_NETWORK_ISSUE = new <init>("ERROR_LIST_NETWORK_ISSUE", 0, new c[] {
            c._ERR_LIST_NETWORK_ERROR
        });
        ERROR_LIST_DATABASERROR = new <init>("ERROR_LIST_DATABASERROR", 1, new c[] {
            c._ERR_LIST_DATABASE_ERROR
        });
        ERROR_LIST_NETWORK_ERROR = new <init>("ERROR_LIST_NETWORK_ERROR", 2, new c[] {
            c._ERR_LIST_DATABASE_ERROR
        });
        ERROR_LIST_DATABASE_ERROR = new <init>("ERROR_LIST_DATABASE_ERROR", 3, new c[] {
            c._ERR_LIST_DATABASE_ERROR
        });
        ERROR_LIST_BELOW_MINIMUM_QUANTITY = new <init>("ERROR_LIST_BELOW_MINIMUM_QUANTITY", 4, new c[] {
            c._ERR_LIST_BELOW_MINIMUM_QUANTITY
        });
        ERROR_LIST_ABOVE_MAXIMUM_QUANTITY = new <init>("ERROR_LIST_ABOVE_MAXIMUM_QUANTITY", 5, new c[] {
            c._ERR_LIST_ABOVE_MAXIMUM_QUANTITY
        });
        ERROR_LIST_CANNOT_DELETE_DEFAULT_LIST = new <init>("ERROR_LIST_CANNOT_DELETE_DEFAULT_LIST", 6, new c[] {
            c._ERR_LIST_CANNOT_DELETE_DEFAULT_LIST
        });
        ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST = new <init>("ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST", 7, new c[] {
            c._ERR_LIST_CANNOT_FIND_SPECIFIED_LIST
        });
        ERROR_LIST_MAX_LIST_COUNT_EXCEEDED = new <init>("ERROR_LIST_MAX_LIST_COUNT_EXCEEDED", 8, new c[] {
            c._ERR_LIST_MAX_LIST_COUNT_EXCEEDED
        });
        ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED = new <init>("ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED", 9, new c[] {
            c._ERR_LIST_MAX_ITEM_COUNT_EXCEEDED
        });
        ERROR_LIST_INVALID_USER_ID = new <init>("ERROR_LIST_INVALID_USER_ID", 10, new c[] {
            c._ERR_LIST_INVALID_USER_ID
        });
        ERROR_LIST_INVALID_LIST_ID = new <init>("ERROR_LIST_INVALID_LIST_ID", 11, new c[] {
            c._ERR_LIST_INVALID_LIST_ID
        });
        ERROR_LIST_INVALID_ITEM_ID = new <init>("ERROR_LIST_INVALID_ITEM_ID", 12, new c[] {
            c._ERR_LIST_INVALID_ITEM_ID
        });
        ERROR_LIST_BELOW_MIN_POSITION = new <init>("ERROR_LIST_BELOW_MIN_POSITION", 13, new c[] {
            c._ERR_LIST_BELOW_MIN_POSITION
        });
        ERROR_LIST_ABOVE_MAX_POSITION = new <init>("ERROR_LIST_ABOVE_MAX_POSITION", 14, new c[] {
            c._ERR_LIST_ABOVE_MAX_POSITION
        });
        UNKNOWN = new <init>("UNKNOWN", 15, new c[] {
            c._ERR_UNKNOWN
        });
        $VALUES = (new .VALUES[] {
            ERROR_LIST_NETWORK_ISSUE, ERROR_LIST_DATABASERROR, ERROR_LIST_NETWORK_ERROR, ERROR_LIST_DATABASE_ERROR, ERROR_LIST_BELOW_MINIMUM_QUANTITY, ERROR_LIST_ABOVE_MAXIMUM_QUANTITY, ERROR_LIST_CANNOT_DELETE_DEFAULT_LIST, ERROR_LIST_CANNOT_FIND_SPECIFIED_LIST, ERROR_LIST_MAX_LIST_COUNT_EXCEEDED, ERROR_LIST_MAX_ITEM_COUNT_EXCEEDED, 
            ERROR_LIST_INVALID_USER_ID, ERROR_LIST_INVALID_LIST_ID, ERROR_LIST_INVALID_ITEM_ID, ERROR_LIST_BELOW_MIN_POSITION, ERROR_LIST_ABOVE_MAX_POSITION, UNKNOWN
        });
    }

    private transient (String s, int i, c ac[])
    {
        super(s, i);
        mErrorCodes = ac;
    }
}
