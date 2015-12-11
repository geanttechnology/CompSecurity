.class public Lcom/poshmark/db/PMDbContentProvider;
.super Landroid/content/ContentProvider;
.source "PMDbContentProvider.java"


# static fields
.field public static final AUTHORITY:Ljava/lang/String;

.field public static final BRANDS:I = 0x1

.field public static final CATEGORY:I = 0x6

.field public static final CATEGORY_SIZES:I = 0x7

.field public static final CATEGORY_STYLETAGS:I = 0x8

.field public static final COLORS:I = 0x9

.field public static final CONTENT_URI_BRANDS:Landroid/net/Uri;

.field public static final CONTENT_URI_CATEGORY:Landroid/net/Uri;

.field public static final CONTENT_URI_CATEGORY_SIZES:Landroid/net/Uri;

.field public static final CONTENT_URI_CATEGORY_STYLE_TAGS:Landroid/net/Uri;

.field public static final CONTENT_URI_COLORS:Landroid/net/Uri;

.field public static final CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

.field public static final CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

.field public static final CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

.field public static final CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

.field public static final FOLLOWING_BRANDS:I = 0x3

.field public static final RECENTS:I = 0x4

.field public static final SAVED_SEARCHES:I = 0x5

.field public static final TIMESTAMPS:I = 0x2

.field private static final sURIMatcher:Landroid/content/UriMatcher;


# instance fields
.field private database:Lcom/poshmark/db/PMDbHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 20
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f06004c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    .line 22
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "category"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    .line 25
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "sizes"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_SIZES:Landroid/net/Uri;

    .line 28
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "subcategory"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY_STYLE_TAGS:Landroid/net/Uri;

    .line 31
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "colors"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_COLORS:Landroid/net/Uri;

    .line 34
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "brands"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    .line 37
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "timestamps"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    .line 40
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "following"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    .line 43
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "recent_brands"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    .line 46
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "content://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "saved_searches"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

    .line 62
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    .line 64
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "category"

    const/4 v3, 0x6

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 65
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "sizes"

    const/4 v3, 0x7

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 66
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "subcategory"

    const/16 v3, 0x8

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 67
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "colors"

    const/16 v3, 0x9

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 68
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "brands"

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 69
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "timestamps"

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 70
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "following"

    const/4 v3, 0x3

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 71
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "recent_brands"

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 72
    sget-object v0, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "saved_searches"

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 73
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public declared-synchronized bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    .locals 12
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # [Landroid/content/ContentValues;

    .prologue
    .line 226
    monitor-enter p0

    :try_start_0
    iget-object v9, p0, Lcom/poshmark/db/PMDbContentProvider;->database:Lcom/poshmark/db/PMDbHelper;

    invoke-virtual {v9}, Lcom/poshmark/db/PMDbHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 227
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-object v9, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v9, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v5

    .line 230
    .local v5, "match":I
    packed-switch v5, :pswitch_data_0

    .line 357
    :pswitch_0
    new-instance v9, Ljava/lang/UnsupportedOperationException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "unsupported uri: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 226
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v5    # "match":I
    :catchall_0
    move-exception v9

    monitor-exit p0

    throw v9

    .line 232
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v5    # "match":I
    :pswitch_1
    :try_start_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 234
    const-string v9, "insert into category(_id,canonical_name) values (?,?)"

    invoke-virtual {v1, v9}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v3

    .line 239
    .local v3, "insert":Landroid/database/sqlite/SQLiteStatement;
    move-object v0, p2

    .local v0, "arr$":[Landroid/content/ContentValues;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v4, :cond_0

    aget-object v8, v0, v2

    .line 241
    .local v8, "value":Landroid/content/ContentValues;
    const/4 v9, 0x1

    const-string v10, "_id"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 242
    const/4 v9, 0x2

    const-string v10, "canonical_name"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 243
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 239
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 245
    .end local v8    # "value":Landroid/content/ContentValues;
    :cond_0
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 246
    array-length v6, p2

    .line 247
    .local v6, "numInserted":I
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 248
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v9

    sget-object v10, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 361
    :goto_1
    monitor-exit p0

    return v6

    .line 251
    .end local v0    # "arr$":[Landroid/content/ContentValues;
    .end local v2    # "i$":I
    .end local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    .end local v4    # "len$":I
    .end local v6    # "numInserted":I
    :pswitch_2
    :try_start_2
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 253
    const-string v9, "insert into subcategory(_id,name,category_id) values (?,?,?)"

    invoke-virtual {v1, v9}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v3

    .line 259
    .restart local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    move-object v0, p2

    .restart local v0    # "arr$":[Landroid/content/ContentValues;
    array-length v4, v0

    .restart local v4    # "len$":I
    const/4 v2, 0x0

    .restart local v2    # "i$":I
    :goto_2
    if-ge v2, v4, :cond_1

    aget-object v8, v0, v2

    .line 261
    .restart local v8    # "value":Landroid/content/ContentValues;
    const/4 v9, 0x1

    const-string v10, "_id"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 262
    const/4 v9, 0x2

    const-string v10, "name"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 263
    const/4 v9, 0x3

    const-string v10, "category_id"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 264
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 259
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 266
    .end local v8    # "value":Landroid/content/ContentValues;
    :cond_1
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 267
    array-length v6, p2

    .line 268
    .restart local v6    # "numInserted":I
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 269
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v9

    sget-object v10, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto :goto_1

    .line 272
    .end local v0    # "arr$":[Landroid/content/ContentValues;
    .end local v2    # "i$":I
    .end local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    .end local v4    # "len$":I
    .end local v6    # "numInserted":I
    :pswitch_3
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 274
    const-string v9, "insert into sizes(_id,short_name,long_name) values (?,?,?)"

    invoke-virtual {v1, v9}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v3

    .line 280
    .restart local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    move-object v0, p2

    .restart local v0    # "arr$":[Landroid/content/ContentValues;
    array-length v4, v0

    .restart local v4    # "len$":I
    const/4 v2, 0x0

    .restart local v2    # "i$":I
    :goto_3
    if-ge v2, v4, :cond_2

    aget-object v8, v0, v2

    .line 282
    .restart local v8    # "value":Landroid/content/ContentValues;
    const/4 v9, 0x1

    const-string v10, "_id"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 283
    const/4 v9, 0x2

    const-string v10, "short_name"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 284
    const/4 v9, 0x3

    const-string v10, "long_name"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 285
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 280
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 287
    .end local v8    # "value":Landroid/content/ContentValues;
    :cond_2
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 288
    array-length v6, p2

    .line 289
    .restart local v6    # "numInserted":I
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 290
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v9

    sget-object v10, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto/16 :goto_1

    .line 293
    .end local v0    # "arr$":[Landroid/content/ContentValues;
    .end local v2    # "i$":I
    .end local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    .end local v4    # "len$":I
    .end local v6    # "numInserted":I
    :pswitch_4
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 295
    const-string v9, "insert into colors(_id,rgb) values (?,RTRIM(?))"

    invoke-virtual {v1, v9}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v3

    .line 300
    .restart local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    move-object v0, p2

    .restart local v0    # "arr$":[Landroid/content/ContentValues;
    array-length v4, v0

    .restart local v4    # "len$":I
    const/4 v2, 0x0

    .restart local v2    # "i$":I
    :goto_4
    if-ge v2, v4, :cond_3

    aget-object v8, v0, v2

    .line 302
    .restart local v8    # "value":Landroid/content/ContentValues;
    const/4 v9, 0x1

    const-string v10, "_id"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 303
    const/4 v9, 0x2

    const-string v10, "rgb"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 304
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 300
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .line 306
    .end local v8    # "value":Landroid/content/ContentValues;
    :cond_3
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 307
    array-length v6, p2

    .line 308
    .restart local v6    # "numInserted":I
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 309
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v9

    sget-object v10, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_CATEGORY:Landroid/net/Uri;

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto/16 :goto_1

    .line 313
    .end local v0    # "arr$":[Landroid/content/ContentValues;
    .end local v2    # "i$":I
    .end local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    .end local v4    # "len$":I
    .end local v6    # "numInserted":I
    :pswitch_5
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 315
    const-string v9, "insert into brands(_id,canonical_name,description,following) values (?,?,?,?)"

    invoke-virtual {v1, v9}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v3

    .line 322
    .restart local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    move-object v0, p2

    .restart local v0    # "arr$":[Landroid/content/ContentValues;
    array-length v4, v0

    .restart local v4    # "len$":I
    const/4 v2, 0x0

    .restart local v2    # "i$":I
    :goto_5
    if-ge v2, v4, :cond_4

    aget-object v8, v0, v2

    .line 324
    .restart local v8    # "value":Landroid/content/ContentValues;
    const/4 v9, 0x2

    const-string v10, "canonical_name"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 325
    const/4 v9, 0x3

    const-string v10, "description"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 326
    const-string v9, "following"

    invoke-virtual {v8, v9}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v7

    .line 327
    .local v7, "val":I
    const/4 v9, 0x4

    const-string v10, "following"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Integer;->intValue()I

    move-result v10

    int-to-long v10, v10

    invoke-virtual {v3, v9, v10, v11}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 328
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 322
    add-int/lit8 v2, v2, 0x1

    goto :goto_5

    .line 330
    .end local v7    # "val":I
    .end local v8    # "value":Landroid/content/ContentValues;
    :cond_4
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 331
    array-length v6, p2

    .line 332
    .restart local v6    # "numInserted":I
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 333
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v9

    sget-object v10, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    goto/16 :goto_1

    .line 336
    .end local v0    # "arr$":[Landroid/content/ContentValues;
    .end local v2    # "i$":I
    .end local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    .end local v4    # "len$":I
    .end local v6    # "numInserted":I
    :pswitch_6
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransaction()V

    .line 338
    const-string v9, "insert into following(_id,user,canonical_name) values (?,?,?)"

    invoke-virtual {v1, v9}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v3

    .line 344
    .restart local v3    # "insert":Landroid/database/sqlite/SQLiteStatement;
    move-object v0, p2

    .restart local v0    # "arr$":[Landroid/content/ContentValues;
    array-length v4, v0

    .restart local v4    # "len$":I
    const/4 v2, 0x0

    .restart local v2    # "i$":I
    :goto_6
    if-ge v2, v4, :cond_5

    aget-object v8, v0, v2

    .line 346
    .restart local v8    # "value":Landroid/content/ContentValues;
    const/4 v9, 0x2

    const-string v10, "user"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 347
    const/4 v9, 0x3

    const-string v10, "canonical_name"

    invoke-virtual {v8, v10}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v3, v9, v10}, Landroid/database/sqlite/SQLiteStatement;->bindString(ILjava/lang/String;)V

    .line 348
    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteStatement;->execute()V

    .line 344
    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    .line 350
    .end local v8    # "value":Landroid/content/ContentValues;
    :cond_5
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 351
    array-length v6, p2

    .line 352
    .restart local v6    # "numInserted":I
    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 353
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v9

    sget-object v10, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_1

    .line 230
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_5
        :pswitch_0
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_2
        :pswitch_4
    .end packed-switch
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 6
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 162
    iget-object v3, p0, Lcom/poshmark/db/PMDbContentProvider;->database:Lcom/poshmark/db/PMDbHelper;

    invoke-virtual {v3}, Lcom/poshmark/db/PMDbHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 163
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-object v3, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    .line 164
    .local v2, "match":I
    const/4 v0, 0x0

    .line 165
    .local v0, "count":I
    packed-switch v2, :pswitch_data_0

    .line 188
    :pswitch_0
    new-instance v3, Ljava/lang/UnsupportedOperationException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "unsupported uri: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 167
    :pswitch_1
    const-string v3, "category"

    instance-of v4, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_0

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 190
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    return v0

    .line 167
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, p2, p3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 170
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_2
    const-string v3, "colors"

    instance-of v4, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_1

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 171
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_1
    goto :goto_0

    .line 170
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_1
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, p2, p3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_1

    .line 173
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_3
    const-string v3, "brands"

    instance-of v4, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_2

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 174
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_2
    goto :goto_0

    .line 173
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_2
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, p2, p3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_2

    .line 176
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_4
    const-string v3, "following"

    instance-of v4, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_3

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 177
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_3
    goto :goto_0

    .line 176
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_3
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, p2, p3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_3

    .line 179
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_5
    const-string v3, "timestamps"

    instance-of v4, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_4

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 180
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_4
    goto :goto_0

    .line 179
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_4
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, p2, p3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_4

    .line 182
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_6
    const-string v3, "subcategory"

    instance-of v4, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_5

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 183
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_5
    goto :goto_0

    .line 182
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_5
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, p2, p3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_5

    .line 185
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_7
    const-string v3, "sizes"

    instance-of v4, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_6

    invoke-virtual {v1, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 186
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_6
    goto :goto_0

    .line 185
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_6
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, v3, p2, p3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->delete(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    goto :goto_6

    .line 165
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_5
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_7
        :pswitch_6
        :pswitch_2
    .end packed-switch
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 133
    const/4 v0, 0x0

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 4
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v3, 0x0

    .line 138
    iget-object v1, p0, Lcom/poshmark/db/PMDbContentProvider;->database:Lcom/poshmark/db/PMDbHelper;

    invoke-virtual {v1}, Lcom/poshmark/db/PMDbHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 139
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v1, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 156
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown URI: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 141
    :pswitch_0
    const-string v1, "brands"

    instance-of v2, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_0

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 142
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    .line 154
    :goto_1
    return-object v1

    .line 141
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v1, v3, p2}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_0

    .line 144
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_1
    const-string v1, "timestamps"

    instance-of v2, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_1

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 145
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_2
    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_TIMESTAMPS:Landroid/net/Uri;

    goto :goto_1

    .line 144
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_1
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v1, v3, p2}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_2

    .line 147
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_2
    const-string v1, "recent_brands"

    instance-of v2, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_2

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 148
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_3
    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_RECENTS_BRANDS:Landroid/net/Uri;

    goto :goto_1

    .line 147
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_2
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v1, v3, p2}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_3

    .line 150
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_3
    const-string v1, "saved_searches"

    instance-of v2, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_3

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 151
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_4
    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_SAVED_SEARCHES:Landroid/net/Uri;

    goto :goto_1

    .line 150
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_3
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v1, v3, p2}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_4

    .line 153
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_4
    const-string v1, "following"

    instance-of v2, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_4

    invoke-virtual {v0, v1, v3, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 154
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_5
    sget-object v1, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_FOLLOWING_BRANDS:Landroid/net/Uri;

    goto :goto_1

    .line 153
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_4
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v1, v3, p2}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->insert(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_5

    .line 139
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_4
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public onCreate()Z
    .locals 2

    .prologue
    .line 78
    new-instance v0, Lcom/poshmark/db/PMDbHelper;

    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/poshmark/db/PMDbHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/poshmark/db/PMDbContentProvider;->database:Lcom/poshmark/db/PMDbHelper;

    .line 79
    const/4 v0, 0x0

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 5
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 84
    iget-object v2, p0, Lcom/poshmark/db/PMDbContentProvider;->database:Lcom/poshmark/db/PMDbHelper;

    invoke-virtual {v2}, Lcom/poshmark/db/PMDbHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 86
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v2, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 126
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown URI: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 88
    :pswitch_0
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_0

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 89
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .local v0, "cursor":Landroid/database/Cursor;
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 128
    :goto_1
    return-object v0

    .line 88
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0

    .line 92
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_1
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_1

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 93
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :goto_2
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto :goto_1

    .line 92
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_1
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_2

    .line 97
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_2
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_2

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 98
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :goto_3
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto :goto_1

    .line 97
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_2
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_3

    .line 102
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_3
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_3

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 103
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :goto_4
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto :goto_1

    .line 102
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_3
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_4

    .line 106
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_4
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_4

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 107
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :goto_5
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto :goto_1

    .line 106
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_4
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_5

    .line 110
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_5
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_5

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 111
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :goto_6
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto/16 :goto_1

    .line 110
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_5
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_6

    .line 114
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_6
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_6

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 115
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :goto_7
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto/16 :goto_1

    .line 114
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_6
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_7

    .line 118
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_7
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_7

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 119
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :goto_8
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto/16 :goto_1

    .line 118
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_7
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_8

    .line 122
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_8
    instance-of v2, v1, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v2, :cond_8

    invoke-virtual {v1, p3, v3}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 123
    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v0    # "cursor":Landroid/database/Cursor;
    :goto_9
    invoke-virtual {p0}, Lcom/poshmark/db/PMDbContentProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-interface {v0, v2, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    goto/16 :goto_1

    .line 122
    .end local v0    # "cursor":Landroid/database/Cursor;
    .restart local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_8
    check-cast v1, Landroid/database/sqlite/SQLiteDatabase;

    .end local v1    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v1, p3, v3}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->rawQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_9

    .line 86
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_4
        :pswitch_5
        :pswitch_8
        :pswitch_6
        :pswitch_7
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 6
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 196
    iget-object v3, p0, Lcom/poshmark/db/PMDbContentProvider;->database:Lcom/poshmark/db/PMDbHelper;

    invoke-virtual {v3}, Lcom/poshmark/db/PMDbHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 197
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-object v3, Lcom/poshmark/db/PMDbContentProvider;->sURIMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 198
    .local v1, "match":I
    const/4 v2, 0x0

    .line 200
    .local v2, "numUpdated":I
    packed-switch v1, :pswitch_data_0

    .line 216
    :pswitch_0
    new-instance v3, Ljava/lang/UnsupportedOperationException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "unsupported uri: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 208
    :pswitch_1
    const-string v3, "recent_brands"

    instance-of v4, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_0

    invoke-virtual {v0, v3, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 219
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    :pswitch_2
    return v2

    .line 208
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_0
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v3, p2, p3, p4}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->update(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    goto :goto_0

    .line 212
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :pswitch_3
    const-string v3, "saved_searches"

    instance-of v4, v0, Landroid/database/sqlite/SQLiteDatabase;

    if-nez v4, :cond_1

    invoke-virtual {v0, v3, p2, p3, p4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 213
    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_1
    goto :goto_0

    .line 212
    .restart local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    :cond_1
    check-cast v0, Landroid/database/sqlite/SQLiteDatabase;

    .end local v0    # "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-static {v0, v3, p2, p3, p4}, Lcom/newrelic/agent/android/instrumentation/SQLiteInstrumentation;->update(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    goto :goto_1

    .line 200
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method
