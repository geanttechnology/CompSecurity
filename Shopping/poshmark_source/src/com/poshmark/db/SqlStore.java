// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;


public class SqlStore
{

    public static final String ADD_LAST_INSERT_DTM_COL_TO_FOLLOWING_BRANDS = "ALTER TABLE following ADD COLUMN insert_dtm text not null default '%s'";
    public static final String BRANDS_TABLE_CREATE = "create table brands(_id integer primary key autoincrement, canonical_name text not null collate nocase, description text, following integer);";
    public static final String BRANDS_TABLE_NAME_INDEX = "create index canonical_name_index on brands(canonical_name);";
    public static final String CATEGORY_SIZES_TABLE_CREATE = "create table sizes(_id text not null, short_name text not null collate nocase, long_name text not null collate nocase,  FOREIGN KEY (_id) REFERENCES category (_id));";
    public static final String CATEGORY_SUBCATEGORY_TABLE_CREATE = "create table subcategory(_id text not null, name text not null, category_id text not null,  FOREIGN KEY (category_id) REFERENCES category (_id));";
    public static final String CATEGORY_TABLE_CREATE = "create table category(_id text primary key, canonical_name text not null collate nocase);";
    public static final String COLORS_TABLE_CREATE = "create table colors(_id text primary key, rgb text not null);";
    public static final String FETCH_ALL_BRANDS = " SELECT * from brands";
    public static final String FETCH_ALL_CATEGORIES = " SELECT * from category";
    public static final String FETCH_ALL_COLORS = " SELECT * from colors";
    public static final String FETCH_ALL_FOLLOWING_BRANDS_FOR_USER = "SELECT canonical_name FROM following WHERE user='%s'";
    public static final String FETCH_ALL_FOLLOWING_BRANDS_FOR_USER_SUB_QUERY = "select canonical_name,Null  from following WHERE user='%s'";
    public static final String FETCH_ALL_PARTIALLY_MATCHING_SAVED_SEARCHES_FOR_USER = "SELECT keyword FROM saved_searches WHERE keyword LIKE '%s%%'  AND user = '%s'";
    public static final String FETCH_ALL_PERFECTLY_MATCHING_SAVED_SEARCHES_FOR_USER = "SELECT keyword FROM saved_searches WHERE keyword ='%s'  AND user = '%s'";
    public static final String FETCH_BRAND_FROM_RECENT_BRANDS_FOR_USER = "select * from recent_brands WHERE user='%s' AND canonical_name ='%s'";
    public static final String FETCH_COUNT_OF_ALL_FOLLOWING_BRANDS_FOR_USER = "SELECT COUNT(*)  FROM following WHERE user='%s'";
    public static final String FETCH_RECENT_BRANDS_FOR_USER = "select * from recent_brands WHERE user='%s' ORDER BY insert_dtm COLLATE NOCASE DESC";
    public static final String FETCH_RECENT_BRANDS_FOR_USER_SUB_QUERY = "select canonical_name,insert_dtm from recent_brands WHERE user='%s'";
    public static final String FETCH_RECENT_SAVED_SEARCHES_FOR_USER = "select * from saved_searches WHERE user='%s' ORDER BY insert_dtm desc  LIMIT %s";
    public static final String FETCH_TIME_STAMP = "SELECT * FROM timestamps WHERE tag='%s'";
    public static final String FIND_ALL_SIZES_FOR_CATEGORY = " SELECT * from sizes WHERE _id ='%s'";
    public static final String FIND_ALL_SUBCATEGORIES_FOR_CATEGORY = " SELECT * from subcategory WHERE category_id ='%s'";
    public static final String FIND_BRAND_IN_ALL_BRANDS = " SELECT canonical_name from brands WHERE canonical_name ='%s'";
    public static final String FIND_CATEGORY_IN_ALL_ALL_CATEGORIES_BY_ID = " SELECT canonical_name from category WHERE _id ='%s'";
    public static final String FIND_CATEGORY_IN_ALL_CATEGORIES_BY_DISPLAY_NAME = " SELECT * from category WHERE canonical_name ='%s'";
    public static final String FIND_COLOR_FROM_LABEL = " SELECT * from colors WHERE _id ='%s'";
    public static final String FIND_SIZE_FOR_CATEGORY_FROM_LABEL = "SELECT *  FROM sizes WHERE short_name = '%s'  AND _id = '%s'";
    public static final String FIND_SUBCATEGORY_FROM_ID = " SELECT _id,name from subcategory WHERE _id ='%s'";
    public static final String FIND_SUBCATEGORY_FROM_LABEL = " SELECT _id,name from subcategory WHERE name ='%s'";
    public static final String FOLLOWING_BRANDS_PLUS_RECENT_BRANDS = "select canonical_name from (%s)";
    public static final String FOLLOWING_BRANDS_TABLE_CREATE = "create table following(_id integer primary key autoincrement, user text not null, canonical_name text not null);";
    public static final String IS_FOLLOWING_BRANDS = "SELECT canonical_name FROM following WHERE canonical_name='%s' AND user ='%s'  COLLATE NOCASE";
    public static final String RECENTS_BRANDS_TABLE_CREATE = "create table recent_brands(_id integer primary key autoincrement, user text not null, canonical_name text not null, insert_dtm text not null);";
    public static final String SAVED_SEARCH_TABLE_CREATE = "create table saved_searches(_id integer primary key autoincrement, user text not null, keyword text not null, type text, insert_dtm text not null);";
    public static final String SAVED_SEARCH_TABLE_KEYWORD_INDEX = "create index search_keyword_index on saved_searches(keyword);";
    public static final String TIMESTAMP_TABLE_CREATE = "create table timestamps(tag text not null, last_update_dtm text not null);";

    public SqlStore()
    {
    }

    public static String sqlEscape(String s)
    {
        return s.replace("'", "''");
    }
}
