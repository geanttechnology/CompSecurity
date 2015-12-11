.class public Lcom/poshmark/db/SqlStore;
.super Ljava/lang/Object;
.source "SqlStore.java"


# static fields
.field public static final ADD_LAST_INSERT_DTM_COL_TO_FOLLOWING_BRANDS:Ljava/lang/String; = "ALTER TABLE following ADD COLUMN insert_dtm text not null default \'%s\'"

.field public static final BRANDS_TABLE_CREATE:Ljava/lang/String; = "create table brands(_id integer primary key autoincrement, canonical_name text not null collate nocase, description text, following integer);"

.field public static final BRANDS_TABLE_NAME_INDEX:Ljava/lang/String; = "create index canonical_name_index on brands(canonical_name);"

.field public static final CATEGORY_SIZES_TABLE_CREATE:Ljava/lang/String; = "create table sizes(_id text not null, short_name text not null collate nocase, long_name text not null collate nocase,  FOREIGN KEY (_id) REFERENCES category (_id));"

.field public static final CATEGORY_SUBCATEGORY_TABLE_CREATE:Ljava/lang/String; = "create table subcategory(_id text not null, name text not null, category_id text not null,  FOREIGN KEY (category_id) REFERENCES category (_id));"

.field public static final CATEGORY_TABLE_CREATE:Ljava/lang/String; = "create table category(_id text primary key, canonical_name text not null collate nocase);"

.field public static final COLORS_TABLE_CREATE:Ljava/lang/String; = "create table colors(_id text primary key, rgb text not null);"

.field public static final FETCH_ALL_BRANDS:Ljava/lang/String; = " SELECT * from brands"

.field public static final FETCH_ALL_CATEGORIES:Ljava/lang/String; = " SELECT * from category"

.field public static final FETCH_ALL_COLORS:Ljava/lang/String; = " SELECT * from colors"

.field public static final FETCH_ALL_FOLLOWING_BRANDS_FOR_USER:Ljava/lang/String; = "SELECT canonical_name FROM following WHERE user=\'%s\'"

.field public static final FETCH_ALL_FOLLOWING_BRANDS_FOR_USER_SUB_QUERY:Ljava/lang/String; = "select canonical_name,Null  from following WHERE user=\'%s\'"

.field public static final FETCH_ALL_PARTIALLY_MATCHING_SAVED_SEARCHES_FOR_USER:Ljava/lang/String; = "SELECT keyword FROM saved_searches WHERE keyword LIKE \'%s%%\'  AND user = \'%s\'"

.field public static final FETCH_ALL_PERFECTLY_MATCHING_SAVED_SEARCHES_FOR_USER:Ljava/lang/String; = "SELECT keyword FROM saved_searches WHERE keyword =\'%s\'  AND user = \'%s\'"

.field public static final FETCH_BRAND_FROM_RECENT_BRANDS_FOR_USER:Ljava/lang/String; = "select * from recent_brands WHERE user=\'%s\' AND canonical_name =\'%s\'"

.field public static final FETCH_COUNT_OF_ALL_FOLLOWING_BRANDS_FOR_USER:Ljava/lang/String; = "SELECT COUNT(*)  FROM following WHERE user=\'%s\'"

.field public static final FETCH_RECENT_BRANDS_FOR_USER:Ljava/lang/String; = "select * from recent_brands WHERE user=\'%s\' ORDER BY insert_dtm COLLATE NOCASE DESC"

.field public static final FETCH_RECENT_BRANDS_FOR_USER_SUB_QUERY:Ljava/lang/String; = "select canonical_name,insert_dtm from recent_brands WHERE user=\'%s\'"

.field public static final FETCH_RECENT_SAVED_SEARCHES_FOR_USER:Ljava/lang/String; = "select * from saved_searches WHERE user=\'%s\' ORDER BY insert_dtm desc  LIMIT %s"

.field public static final FETCH_TIME_STAMP:Ljava/lang/String; = "SELECT * FROM timestamps WHERE tag=\'%s\'"

.field public static final FIND_ALL_SIZES_FOR_CATEGORY:Ljava/lang/String; = " SELECT * from sizes WHERE _id =\'%s\'"

.field public static final FIND_ALL_SUBCATEGORIES_FOR_CATEGORY:Ljava/lang/String; = " SELECT * from subcategory WHERE category_id =\'%s\'"

.field public static final FIND_BRAND_IN_ALL_BRANDS:Ljava/lang/String; = " SELECT canonical_name from brands WHERE canonical_name =\'%s\'"

.field public static final FIND_CATEGORY_IN_ALL_ALL_CATEGORIES_BY_ID:Ljava/lang/String; = " SELECT canonical_name from category WHERE _id =\'%s\'"

.field public static final FIND_CATEGORY_IN_ALL_CATEGORIES_BY_DISPLAY_NAME:Ljava/lang/String; = " SELECT * from category WHERE canonical_name =\'%s\'"

.field public static final FIND_COLOR_FROM_LABEL:Ljava/lang/String; = " SELECT * from colors WHERE _id =\'%s\'"

.field public static final FIND_SIZE_FOR_CATEGORY_FROM_LABEL:Ljava/lang/String; = "SELECT *  FROM sizes WHERE short_name = \'%s\'  AND _id = \'%s\'"

.field public static final FIND_SUBCATEGORY_FROM_ID:Ljava/lang/String; = " SELECT _id,name from subcategory WHERE _id =\'%s\'"

.field public static final FIND_SUBCATEGORY_FROM_LABEL:Ljava/lang/String; = " SELECT _id,name from subcategory WHERE name =\'%s\'"

.field public static final FOLLOWING_BRANDS_PLUS_RECENT_BRANDS:Ljava/lang/String; = "select canonical_name from (%s)"

.field public static final FOLLOWING_BRANDS_TABLE_CREATE:Ljava/lang/String; = "create table following(_id integer primary key autoincrement, user text not null, canonical_name text not null);"

.field public static final IS_FOLLOWING_BRANDS:Ljava/lang/String; = "SELECT canonical_name FROM following WHERE canonical_name=\'%s\' AND user =\'%s\'  COLLATE NOCASE"

.field public static final RECENTS_BRANDS_TABLE_CREATE:Ljava/lang/String; = "create table recent_brands(_id integer primary key autoincrement, user text not null, canonical_name text not null, insert_dtm text not null);"

.field public static final SAVED_SEARCH_TABLE_CREATE:Ljava/lang/String; = "create table saved_searches(_id integer primary key autoincrement, user text not null, keyword text not null, type text, insert_dtm text not null);"

.field public static final SAVED_SEARCH_TABLE_KEYWORD_INDEX:Ljava/lang/String; = "create index search_keyword_index on saved_searches(keyword);"

.field public static final TIMESTAMP_TABLE_CREATE:Ljava/lang/String; = "create table timestamps(tag text not null, last_update_dtm text not null);"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static sqlEscape(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "string"    # Ljava/lang/String;

    .prologue
    .line 226
    const-string v0, "\'"

    const-string v1, "\'\'"

    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
