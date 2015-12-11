.class public Lco/vine/android/provider/VineUploadProvider;
.super Landroid/content/ContentProvider;
.source "VineUploadProvider.java"


# static fields
.field private static final ALL_UPLOADS:I = 0x1

.field public static final AUTHORITY:Ljava/lang/String;

.field public static final CONTENT_AUTHORITY:Ljava/lang/String;

.field private static final DELETE_ALL_UPLOADS:I = 0x5

.field private static final DELETE_UPLOAD:I = 0x4

.field private static final GET_LAST_PATH:I = 0x3

.field private static final LOGGABLE:Z

.field private static final PUT_HASH:I = 0x7

.field private static final PUT_MESSAGE_ROW_ID:I = 0xe

.field private static final PUT_NEW_UPLOAD:I = 0x6

.field private static final PUT_POST_INFO:I = 0xa

.field private static final PUT_STATUS:I = 0x8

.field private static final PUT_UPLOAD_TIME:I = 0xb

.field private static final PUT_URIS:I = 0x9

.field private static final PUT_VALUES:I = 0xc

.field private static final REFERENCE:I = 0xd

.field public static final SCHEME:Ljava/lang/String; = "content"

.field private static final TAG:Ljava/lang/String; = "VineUploadProvider"

.field private static final UPLOAD:I = 0x2

.field private static final sUriMatcher:Landroid/content/UriMatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v1, 0x1

    .line 31
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "VineUploadProvider"

    const/4 v2, 0x3

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    move v0, v1

    :goto_0
    sput-boolean v0, Lco/vine/android/provider/VineUploadProvider;->LOGGABLE:Z

    .line 34
    const-string v0, ".provider.VineUploadProvider"

    invoke-static {v0}, Lco/vine/android/util/BuildUtil;->getAuthority(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    .line 35
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "content://"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/provider/VineUploadProvider;->CONTENT_AUTHORITY:Ljava/lang/String;

    .line 52
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v2, -0x1

    invoke-direct {v0, v2}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    .line 56
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v2, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v3, "uploads/#"

    invoke-virtual {v0, v2, v3, v1}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 57
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/upload/#"

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 58
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/reference/#"

    const/16 v3, 0xd

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 61
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/delete_upload"

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 64
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/put_new_upload"

    const/4 v3, 0x6

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 65
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/put_hash"

    const/4 v3, 0x7

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 66
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/put_status"

    const/16 v3, 0x8

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 67
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/put_uris"

    const/16 v3, 0x9

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 68
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/put_post_info"

    const/16 v3, 0xa

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 69
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/put_upload_time"

    const/16 v3, 0xb

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 70
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/put_values"

    const/16 v3, 0xc

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 71
    sget-object v0, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    sget-object v1, Lco/vine/android/provider/VineUploadProvider;->AUTHORITY:Ljava/lang/String;

    const-string v2, "uploads/put_message_row_id"

    const/16 v3, 0xe

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 72
    return-void

    .line 31
    :cond_1
    const/4 v0, 0x0

    goto/16 :goto_0
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 7
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 191
    const/4 v2, 0x0

    .line 192
    .local v2, "rowsDeleted":I
    invoke-virtual {p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineUploadDatabaseHelper;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 195
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-boolean v3, Lco/vine/android/provider/VineUploadProvider;->LOGGABLE:Z

    if-eqz v3, :cond_0

    .line 196
    const-string v3, "VineUploadProvider"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "QUERY: uri "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " -> "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v5, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 199
    :cond_0
    sget-object v3, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v3, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 200
    .local v1, "match":I
    packed-switch v1, :pswitch_data_0

    .line 214
    :goto_0
    if-lez v2, :cond_1

    .line 215
    invoke-virtual {p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    sget-object v4, Lco/vine/android/provider/VineUploads$Uploads;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v3, v4, v6}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 217
    :cond_1
    return v2

    .line 202
    :pswitch_0
    const-string v3, "uploads"

    invoke-virtual {v0, v3, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 203
    goto :goto_0

    .line 206
    :pswitch_1
    const-string v3, "uploads"

    const-string v4, "1"

    invoke-virtual {v0, v3, v4, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v2

    .line 207
    goto :goto_0

    .line 200
    nop

    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 156
    const/4 v0, 0x0

    return-object v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 8
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v7, 0x0

    .line 161
    const-wide/16 v2, -0x1

    .line 162
    .local v2, "rowId":J
    invoke-virtual {p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineUploadDatabaseHelper;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 165
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-boolean v4, Lco/vine/android/provider/VineUploadProvider;->LOGGABLE:Z

    if-eqz v4, :cond_0

    .line 166
    const-string v4, "VineUploadProvider"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "QUERY: uri "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " -> "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v6, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 169
    :cond_0
    sget-object v4, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v4, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v1

    .line 170
    .local v1, "match":I
    packed-switch v1, :pswitch_data_0

    .line 183
    :cond_1
    :goto_0
    const-wide/16 v4, 0x0

    cmp-long v4, v2, v4

    if-ltz v4, :cond_2

    .line 184
    invoke-virtual {p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    sget-object v5, Lco/vine/android/provider/VineUploads$Uploads;->CONTENT_URI:Landroid/net/Uri;

    invoke-virtual {v4, v5, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 186
    :cond_2
    return-object v7

    .line 172
    :pswitch_0
    const-string v4, "uploads"

    invoke-virtual {v0, v4, v7, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v2

    .line 173
    sget-boolean v4, Lco/vine/android/provider/VineUploadProvider;->LOGGABLE:Z

    if-eqz v4, :cond_1

    .line 174
    const-string v4, "VineUploadProvider"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Upload inserted with rowId="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 170
    nop

    :pswitch_data_0
    .packed-switch 0x6
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 76
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 16
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 83
    const/4 v6, 0x0

    .line 87
    .local v6, "groupBy":Ljava/lang/String;
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineUploadDatabaseHelper;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 95
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    :goto_0
    new-instance v1, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v1}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 96
    .local v1, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    sget-boolean v3, Lco/vine/android/provider/VineUploadProvider;->LOGGABLE:Z

    if-eqz v3, :cond_0

    .line 97
    const-string v3, "VineUploadProvider"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "QUERY: uri "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " -> "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v5, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 100
    :cond_0
    sget-object v3, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v12

    .line 101
    .local v12, "match":I
    sparse-switch v12, :sswitch_data_0

    .line 134
    const-string v3, "uploads"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 140
    :goto_1
    const/4 v7, 0x0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-object/from16 v8, p5

    :try_start_1
    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 143
    .local v10, "c":Landroid/database/Cursor;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    move-object/from16 v0, p1

    invoke-interface {v10, v3, v0}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 144
    .end local v6    # "groupBy":Ljava/lang/String;
    .end local v10    # "c":Landroid/database/Cursor;
    :goto_2
    return-object v10

    .line 89
    .end local v1    # "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    .end local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    .end local v12    # "match":I
    .restart local v6    # "groupBy":Ljava/lang/String;
    :catch_0
    move-exception v11

    .line 90
    .local v11, "e":Landroid/database/sqlite/SQLiteException;
    const-string v3, "Failed to get a readable database on query."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v11, v3, v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 91
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineUploadDatabaseHelper;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .restart local v2    # "db":Landroid/database/sqlite/SQLiteDatabase;
    goto :goto_0

    .line 103
    .end local v11    # "e":Landroid/database/sqlite/SQLiteException;
    .restart local v1    # "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    .restart local v12    # "match":I
    :sswitch_0
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v13

    .line 104
    .local v13, "ownerId":Ljava/lang/String;
    const-string v3, "uploads"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 105
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "owner_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->appendWhere(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 109
    .end local v13    # "ownerId":Ljava/lang/String;
    :sswitch_1
    const-string v3, "uploads"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 110
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v13

    .line 111
    .restart local v13    # "ownerId":Ljava/lang/String;
    const-string v3, "path"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 112
    .local v14, "path":Ljava/lang/String;
    invoke-static {v14}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 113
    const-string p3, "path=? AND owner_id=?"

    .line 114
    sget-object v3, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x2

    new-array v5, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v14, v5, v4

    const/4 v4, 0x1

    aput-object v13, v5, v4

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "_id ASC"

    .end local v6    # "groupBy":Ljava/lang/String;
    const-string v9, "1"

    move-object/from16 v4, p3

    invoke-virtual/range {v1 .. v9}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    goto :goto_2

    .line 118
    .restart local v6    # "groupBy":Ljava/lang/String;
    :cond_1
    const/4 v10, 0x0

    goto :goto_2

    .line 121
    .end local v13    # "ownerId":Ljava/lang/String;
    .end local v14    # "path":Ljava/lang/String;
    :sswitch_2
    const-string v3, "uploads"

    invoke-virtual {v1, v3}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 122
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v13

    .line 123
    .restart local v13    # "ownerId":Ljava/lang/String;
    const-string v3, "reference"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 124
    .local v15, "reference":Ljava/lang/String;
    invoke-static {v15}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 125
    const-string p3, "reference=? AND owner_id=?"

    .line 126
    sget-object v3, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x2

    new-array v5, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v15, v5, v4

    const/4 v4, 0x1

    aput-object v13, v5, v4

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, "_id ASC"

    .end local v6    # "groupBy":Ljava/lang/String;
    move-object/from16 v4, p3

    invoke-virtual/range {v1 .. v8}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 129
    .restart local v10    # "c":Landroid/database/Cursor;
    goto/16 :goto_2

    .line 131
    .end local v10    # "c":Landroid/database/Cursor;
    .restart local v6    # "groupBy":Ljava/lang/String;
    :cond_2
    const/4 v10, 0x0

    goto/16 :goto_2

    .line 145
    .end local v13    # "ownerId":Ljava/lang/String;
    .end local v15    # "reference":Ljava/lang/String;
    :catch_1
    move-exception v11

    .line 146
    .local v11, "e":Ljava/lang/Exception;
    sget-boolean v3, Lco/vine/android/provider/VineUploadProvider;->LOGGABLE:Z

    if-eqz v3, :cond_3

    .line 147
    const-string v3, "Cannot execute {} {}  {} {} {} {}"

    const/4 v4, 0x5

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x1

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->getTables()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    const/4 v5, 0x2

    aput-object p3, v4, v5

    const/4 v5, 0x3

    aput-object v6, v4, v5

    const/4 v5, 0x4

    aput-object p5, v4, v5

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 150
    :cond_3
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v11}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3

    .line 101
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0xd -> :sswitch_2
    .end sparse-switch
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 21
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 222
    const/4 v11, 0x0

    .line 224
    .local v11, "rowsUpdated":I
    if-nez p2, :cond_0

    .line 225
    new-instance p2, Landroid/content/ContentValues;

    .end local p2    # "values":Landroid/content/ContentValues;
    invoke-direct/range {p2 .. p2}, Landroid/content/ContentValues;-><init>()V

    .line 228
    .restart local p2    # "values":Landroid/content/ContentValues;
    :cond_0
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getDatabaseHelper(Landroid/content/Context;)Lco/vine/android/provider/VineUploadDatabaseHelper;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Lco/vine/android/provider/VineUploadDatabaseHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v4

    .line 231
    .local v4, "db":Landroid/database/sqlite/SQLiteDatabase;
    sget-boolean v17, Lco/vine/android/provider/VineUploadProvider;->LOGGABLE:Z

    if-eqz v17, :cond_1

    .line 232
    const-string v17, "VineUploadProvider"

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "QUERY: uri "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " -> "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    sget-object v19, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, v19

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 235
    :cond_1
    sget-object v17, Lco/vine/android/provider/VineUploadProvider;->sUriMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v7

    .line 236
    .local v7, "match":I
    packed-switch v7, :pswitch_data_0

    .line 307
    :pswitch_0
    const-string v13, "uploads"

    .line 313
    .local v13, "tableName":Ljava/lang/String;
    :goto_0
    :try_start_0
    invoke-virtual/range {p2 .. p2}, Landroid/content/ContentValues;->keySet()Ljava/util/Set;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/util/Set;->isEmpty()Z

    move-result v17

    if-nez v17, :cond_2

    .line 314
    move-object/from16 v0, p2

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v4, v13, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v11

    .line 324
    :cond_2
    if-lez v11, :cond_3

    .line 325
    const-string v17, "status"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 326
    .local v12, "status":Ljava/lang/String;
    const/16 v17, 0x2

    invoke-static/range {v17 .. v17}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_3

    .line 327
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/provider/VineUploadProvider;->getContext()Landroid/content/Context;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v17

    sget-object v18, Lco/vine/android/provider/VineUploads$Uploads;->CONTENT_URI:Landroid/net/Uri;

    const/16 v19, 0x0

    invoke-virtual/range {v17 .. v19}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 331
    .end local v12    # "status":Ljava/lang/String;
    :cond_3
    return v11

    .line 238
    .end local v13    # "tableName":Ljava/lang/String;
    :pswitch_1
    const-string v13, "uploads"

    .line 239
    .restart local v13    # "tableName":Ljava/lang/String;
    const-string v17, "path"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 240
    .local v9, "path":Ljava/lang/String;
    const-string v17, "hash"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 241
    .local v6, "hash":Ljava/lang/String;
    const-string v17, "PUT_HASH path={}, hash={}"

    move-object/from16 v0, v17

    invoke-static {v0, v9, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 242
    const-string p3, "path=?"

    .line 243
    const/16 v17, 0x1

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 p4, v0

    .end local p4    # "selectionArgs":[Ljava/lang/String;
    const/16 v17, 0x0

    aput-object v9, p4, v17

    .line 244
    .restart local p4    # "selectionArgs":[Ljava/lang/String;
    const-string v17, "hash"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 248
    .end local v6    # "hash":Ljava/lang/String;
    .end local v9    # "path":Ljava/lang/String;
    .end local v13    # "tableName":Ljava/lang/String;
    :pswitch_2
    const-string v13, "uploads"

    .line 249
    .restart local v13    # "tableName":Ljava/lang/String;
    const-string v17, "path"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 250
    .restart local v9    # "path":Ljava/lang/String;
    const-string v17, "status"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 251
    .restart local v12    # "status":Ljava/lang/String;
    const-string v17, "captcha_url"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 252
    .local v3, "captcha":Ljava/lang/String;
    const-string v17, "PUT_STATUS path={}, status={}"

    move-object/from16 v0, v17

    invoke-static {v0, v9, v12}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 253
    const-string p3, "path=?"

    .line 254
    const/16 v17, 0x1

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 p4, v0

    .end local p4    # "selectionArgs":[Ljava/lang/String;
    const/16 v17, 0x0

    aput-object v9, p4, v17

    .line 255
    .restart local p4    # "selectionArgs":[Ljava/lang/String;
    const-string v17, "status"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    const-string v17, "captcha_url"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 260
    .end local v3    # "captcha":Ljava/lang/String;
    .end local v9    # "path":Ljava/lang/String;
    .end local v12    # "status":Ljava/lang/String;
    .end local v13    # "tableName":Ljava/lang/String;
    :pswitch_3
    const-string v13, "uploads"

    .line 261
    .restart local v13    # "tableName":Ljava/lang/String;
    const-string v17, "path"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 262
    .restart local v9    # "path":Ljava/lang/String;
    const-string v17, "video_url"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 263
    .local v16, "videoUrl":Ljava/lang/String;
    const-string v17, "thumbnail_url"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 264
    .local v14, "thumbnailUrl":Ljava/lang/String;
    const-string v17, "PUT_URIS path={}, videoUrl={}, thumbnailUrl={}"

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-static {v0, v9, v1, v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 265
    const-string p3, "path=?"

    .line 266
    const/16 v17, 0x1

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 p4, v0

    .end local p4    # "selectionArgs":[Ljava/lang/String;
    const/16 v17, 0x0

    aput-object v9, p4, v17

    .line 267
    .restart local p4    # "selectionArgs":[Ljava/lang/String;
    const-string v17, "video_url"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    move-object/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 268
    const-string v17, "thumbnail_url"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v14}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 272
    .end local v9    # "path":Ljava/lang/String;
    .end local v13    # "tableName":Ljava/lang/String;
    .end local v14    # "thumbnailUrl":Ljava/lang/String;
    .end local v16    # "videoUrl":Ljava/lang/String;
    :pswitch_4
    const-string v13, "uploads"

    .line 273
    .restart local v13    # "tableName":Ljava/lang/String;
    const-string v17, "path"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 274
    .restart local v9    # "path":Ljava/lang/String;
    const-string v17, "post_info"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 275
    .local v10, "postInfo":Ljava/lang/String;
    const-string v17, "PUT_POST_INFO path={}, postInfo={}"

    move-object/from16 v0, v17

    invoke-static {v0, v9, v10}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 276
    const-string p3, "path=?"

    .line 277
    const/16 v17, 0x1

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 p4, v0

    .end local p4    # "selectionArgs":[Ljava/lang/String;
    const/16 v17, 0x0

    aput-object v9, p4, v17

    .line 278
    .restart local p4    # "selectionArgs":[Ljava/lang/String;
    const-string v17, "post_info"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v10}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 282
    .end local v9    # "path":Ljava/lang/String;
    .end local v10    # "postInfo":Ljava/lang/String;
    .end local v13    # "tableName":Ljava/lang/String;
    :pswitch_5
    const-string v13, "uploads"

    .line 283
    .restart local v13    # "tableName":Ljava/lang/String;
    const-string v17, "path"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 284
    .restart local v9    # "path":Ljava/lang/String;
    const-string v17, "upload_time"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 285
    .local v15, "uploadTime":Ljava/lang/String;
    const-string v17, "PUT_UPLOAD_TIME path={}, uploadTime={}"

    move-object/from16 v0, v17

    invoke-static {v0, v9, v15}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 286
    const-string p3, "path=?"

    .line 287
    const/16 v17, 0x1

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 p4, v0

    .end local p4    # "selectionArgs":[Ljava/lang/String;
    const/16 v17, 0x0

    aput-object v9, p4, v17

    .line 288
    .restart local p4    # "selectionArgs":[Ljava/lang/String;
    const-string v17, "upload_time"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v15}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 292
    .end local v9    # "path":Ljava/lang/String;
    .end local v13    # "tableName":Ljava/lang/String;
    .end local v15    # "uploadTime":Ljava/lang/String;
    :pswitch_6
    const-string v17, "PUT_VALUES selectionArgs={}, values={}"

    invoke-virtual/range {p2 .. p2}, Landroid/content/ContentValues;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, p4

    move-object/from16 v2, v18

    invoke-static {v0, v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 293
    const-string v13, "uploads"

    .line 294
    .restart local v13    # "tableName":Ljava/lang/String;
    goto/16 :goto_0

    .line 297
    .end local v13    # "tableName":Ljava/lang/String;
    :pswitch_7
    const-string v13, "uploads"

    .line 298
    .restart local v13    # "tableName":Ljava/lang/String;
    const-string v17, "path"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 299
    .restart local v9    # "path":Ljava/lang/String;
    const-string v17, "message_row_id"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 300
    .local v8, "messageId":Ljava/lang/String;
    const-string v17, "PUT_MESSAGE_ROW_ID path={}, id={}"

    move-object/from16 v0, v17

    invoke-static {v0, v9, v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 301
    const-string p3, "path=?"

    .line 302
    const/16 v17, 0x1

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 p4, v0

    .end local p4    # "selectionArgs":[Ljava/lang/String;
    const/16 v17, 0x0

    aput-object v9, p4, v17

    .line 303
    .restart local p4    # "selectionArgs":[Ljava/lang/String;
    const-string v17, "message_row"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 316
    .end local v8    # "messageId":Ljava/lang/String;
    .end local v9    # "path":Ljava/lang/String;
    :catch_0
    move-exception v5

    .line 317
    .local v5, "e":Landroid/database/sqlite/SQLiteException;
    sget-boolean v17, Lco/vine/android/provider/VineUploadProvider;->LOGGABLE:Z

    if-eqz v17, :cond_4

    .line 318
    const-string v17, "Cannot execute update with db={}, tablename={}, selection={}, selectionArgs={}"

    const/16 v18, 0x4

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->toString()Ljava/lang/String;

    move-result-object v20

    aput-object v20, v18, v19

    const/16 v19, 0x1

    aput-object v13, v18, v19

    const/16 v19, 0x2

    aput-object p3, v18, v19

    const/16 v19, 0x3

    invoke-static/range {p4 .. p4}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v20

    aput-object v20, v18, v19

    invoke-static/range {v17 .. v18}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 321
    :cond_4
    new-instance v17, Ljava/lang/RuntimeException;

    move-object/from16 v0, v17

    invoke-direct {v0, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v17

    .line 236
    nop

    :pswitch_data_0
    .packed-switch 0x7
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_0
        :pswitch_7
    .end packed-switch
.end method
