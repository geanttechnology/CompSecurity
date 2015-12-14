// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;


public interface CacheErrorLogger
{
    public static final class CacheErrorCategory extends Enum
    {

        private static final CacheErrorCategory $VALUES[];
        public static final CacheErrorCategory DELETE_FILE;
        public static final CacheErrorCategory EVICTION;
        public static final CacheErrorCategory GENERIC_IO;
        public static final CacheErrorCategory OTHER;
        public static final CacheErrorCategory READ_DECODE;
        public static final CacheErrorCategory READ_FILE;
        public static final CacheErrorCategory READ_FILE_NOT_FOUND;
        public static final CacheErrorCategory READ_INVALID_ENTRY;
        public static final CacheErrorCategory WRITE_CALLBACK_ERROR;
        public static final CacheErrorCategory WRITE_CREATE_DIR;
        public static final CacheErrorCategory WRITE_CREATE_TEMPFILE;
        public static final CacheErrorCategory WRITE_ENCODE;
        public static final CacheErrorCategory WRITE_INVALID_ENTRY;
        public static final CacheErrorCategory WRITE_RENAME_FILE_OTHER;
        public static final CacheErrorCategory WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
        public static final CacheErrorCategory WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
        public static final CacheErrorCategory WRITE_UPDATE_FILE_NOT_FOUND;

        public static CacheErrorCategory valueOf(String s)
        {
            return (CacheErrorCategory)Enum.valueOf(com/facebook/cache/common/CacheErrorLogger$CacheErrorCategory, s);
        }

        public static CacheErrorCategory[] values()
        {
            return (CacheErrorCategory[])$VALUES.clone();
        }

        static 
        {
            READ_DECODE = new CacheErrorCategory("READ_DECODE", 0);
            READ_FILE = new CacheErrorCategory("READ_FILE", 1);
            READ_FILE_NOT_FOUND = new CacheErrorCategory("READ_FILE_NOT_FOUND", 2);
            READ_INVALID_ENTRY = new CacheErrorCategory("READ_INVALID_ENTRY", 3);
            WRITE_ENCODE = new CacheErrorCategory("WRITE_ENCODE", 4);
            WRITE_CREATE_TEMPFILE = new CacheErrorCategory("WRITE_CREATE_TEMPFILE", 5);
            WRITE_UPDATE_FILE_NOT_FOUND = new CacheErrorCategory("WRITE_UPDATE_FILE_NOT_FOUND", 6);
            WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND", 7);
            WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND = new CacheErrorCategory("WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND", 8);
            WRITE_RENAME_FILE_OTHER = new CacheErrorCategory("WRITE_RENAME_FILE_OTHER", 9);
            WRITE_CREATE_DIR = new CacheErrorCategory("WRITE_CREATE_DIR", 10);
            WRITE_CALLBACK_ERROR = new CacheErrorCategory("WRITE_CALLBACK_ERROR", 11);
            WRITE_INVALID_ENTRY = new CacheErrorCategory("WRITE_INVALID_ENTRY", 12);
            DELETE_FILE = new CacheErrorCategory("DELETE_FILE", 13);
            EVICTION = new CacheErrorCategory("EVICTION", 14);
            GENERIC_IO = new CacheErrorCategory("GENERIC_IO", 15);
            OTHER = new CacheErrorCategory("OTHER", 16);
            $VALUES = (new CacheErrorCategory[] {
                READ_DECODE, READ_FILE, READ_FILE_NOT_FOUND, READ_INVALID_ENTRY, WRITE_ENCODE, WRITE_CREATE_TEMPFILE, WRITE_UPDATE_FILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND, WRITE_RENAME_FILE_OTHER, 
                WRITE_CREATE_DIR, WRITE_CALLBACK_ERROR, WRITE_INVALID_ENTRY, DELETE_FILE, EVICTION, GENERIC_IO, OTHER
            });
        }

        private CacheErrorCategory(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void logError(CacheErrorCategory cacheerrorcategory, Class class1, String s, Throwable throwable);
}
