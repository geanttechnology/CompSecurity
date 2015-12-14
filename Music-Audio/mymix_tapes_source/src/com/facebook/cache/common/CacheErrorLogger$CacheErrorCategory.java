// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;


// Referenced classes of package com.facebook.cache.common:
//            CacheErrorLogger

public static final class  extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER DELETE_FILE;
    public static final OTHER EVICTION;
    public static final OTHER GENERIC_IO;
    public static final OTHER OTHER;
    public static final OTHER READ_DECODE;
    public static final OTHER READ_FILE;
    public static final OTHER READ_FILE_NOT_FOUND;
    public static final OTHER READ_INVALID_ENTRY;
    public static final OTHER WRITE_CALLBACK_ERROR;
    public static final OTHER WRITE_CREATE_DIR;
    public static final OTHER WRITE_CREATE_TEMPFILE;
    public static final OTHER WRITE_ENCODE;
    public static final OTHER WRITE_INVALID_ENTRY;
    public static final OTHER WRITE_RENAME_FILE_OTHER;
    public static final OTHER WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
    public static final OTHER WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
    public static final OTHER WRITE_UPDATE_FILE_NOT_FOUND;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/facebook/cache/common/CacheErrorLogger$CacheErrorCategory, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        READ_DECODE = new <init>("READ_DECODE", 0);
        READ_FILE = new <init>("READ_FILE", 1);
        READ_FILE_NOT_FOUND = new <init>("READ_FILE_NOT_FOUND", 2);
        READ_INVALID_ENTRY = new <init>("READ_INVALID_ENTRY", 3);
        WRITE_ENCODE = new <init>("WRITE_ENCODE", 4);
        WRITE_CREATE_TEMPFILE = new <init>("WRITE_CREATE_TEMPFILE", 5);
        WRITE_UPDATE_FILE_NOT_FOUND = new <init>("WRITE_UPDATE_FILE_NOT_FOUND", 6);
        WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND = new <init>("WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND", 7);
        WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND = new <init>("WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND", 8);
        WRITE_RENAME_FILE_OTHER = new <init>("WRITE_RENAME_FILE_OTHER", 9);
        WRITE_CREATE_DIR = new <init>("WRITE_CREATE_DIR", 10);
        WRITE_CALLBACK_ERROR = new <init>("WRITE_CALLBACK_ERROR", 11);
        WRITE_INVALID_ENTRY = new <init>("WRITE_INVALID_ENTRY", 12);
        DELETE_FILE = new <init>("DELETE_FILE", 13);
        EVICTION = new <init>("EVICTION", 14);
        GENERIC_IO = new <init>("GENERIC_IO", 15);
        OTHER = new <init>("OTHER", 16);
        $VALUES = (new .VALUES[] {
            READ_DECODE, READ_FILE, READ_FILE_NOT_FOUND, READ_INVALID_ENTRY, WRITE_ENCODE, WRITE_CREATE_TEMPFILE, WRITE_UPDATE_FILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND, WRITE_RENAME_FILE_OTHER, 
            WRITE_CREATE_DIR, WRITE_CALLBACK_ERROR, WRITE_INVALID_ENTRY, DELETE_FILE, EVICTION, GENERIC_IO, OTHER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
