.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;
.super Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;
.source "VirtuosoHLSFile.java"

# interfaces
.implements Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;
    }
.end annotation


# static fields
.field static final LOG_TAG:Ljava/lang/String;


# instance fields
.field iAssetId:Ljava/lang/String;

.field iCompletedCount:I

.field iCurrentSize:D

.field iExpectedSize:D

.field iFilePath:Ljava/lang/String;

.field iFragmentCount:I

.field iIsPending:Z

.field iMetaData:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->LOG_TAG:Ljava/lang/String;

    .line 33
    return-void
.end method

.method constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x4

    const/4 v2, 0x0

    const-wide/16 v0, 0x0

    .line 46
    invoke-direct {p0, v3, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>(II)V

    .line 38
    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iExpectedSize:D

    .line 39
    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    .line 40
    iput v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    .line 41
    iput v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    .line 43
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iIsPending:Z

    .line 47
    return-void
.end method

.method constructor <init>(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;-><init>()V

    .line 64
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->refresh(Landroid/database/Cursor;)V

    .line 65
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 3
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v2, 0x0

    const-wide/16 v0, 0x0

    .line 57
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;-><init>()V

    .line 38
    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iExpectedSize:D

    .line 39
    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    .line 40
    iput v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    .line 41
    iput v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    .line 43
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iIsPending:Z

    .line 59
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->readFromParcel(Landroid/os/Parcel;)V

    .line 60
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "aAssetId"    # Ljava/lang/String;
    .param p2, "aMetadata"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;-><init>()V

    .line 52
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "aAssetId must be provided"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 53
    :cond_0
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iAssetId:Ljava/lang/String;

    .line 54
    iput-object p2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iMetaData:Ljava/lang/String;

    .line 55
    return-void
.end method

.method static synthetic access$0(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;Ljava/lang/String;I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 230
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->generateFragmentPath(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private generateContentValues(Ljava/lang/String;Landroid/content/Context;Landroid/content/ContentResolver;)Landroid/content/ContentValues;
    .locals 4
    .param p1, "aFragmentUrl"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "contentResolver"    # Landroid/content/ContentResolver;

    .prologue
    const/4 v3, -0x1

    .line 265
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 266
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "assetUrl"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 267
    const-string v1, "completeTime"

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 268
    const-string v1, "currentSize"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 269
    const-string v1, "expectedSize"

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 270
    const-string v1, "errorType"

    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 273
    const-string v1, "pending"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 274
    const-string v1, "parentUuid"

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iUuid:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 275
    return-object v0
.end method

.method private generateFragmentPath(Ljava/lang/String;I)Ljava/lang/String;
    .locals 8
    .param p1, "aFragmentUrl"    # Ljava/lang/String;
    .param p2, "aFragmentId"    # I

    .prologue
    const/4 v4, 0x0

    .line 232
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 261
    :goto_0
    return-object v4

    .line 235
    :cond_0
    :try_start_0
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 236
    .local v0, "fp":Ljava/lang/StringBuffer;
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 238
    new-instance v3, Ljava/net/URL;

    invoke-direct {v3, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 239
    .local v3, "uri":Ljava/net/URL;
    invoke-virtual {v3}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 240
    .local v2, "s":Ljava/lang/String;
    const-string v6, "TestRunner"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v5, "Path ["

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    const-string v5, ""

    :goto_1
    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, "]"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v6, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    const-string v5, "/"

    invoke-virtual {v2, v5}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v5

    add-int/lit8 v1, v5, 0x1

    .line 249
    .local v1, "idx":I
    if-ltz v1, :cond_2

    invoke-virtual {v2, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    .line 250
    :goto_2
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 251
    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 256
    :goto_3
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .end local v1    # "idx":I
    :cond_1
    move-object v5, v2

    .line 240
    goto :goto_1

    .restart local v1    # "idx":I
    :cond_2
    move-object v2, v4

    .line 249
    goto :goto_2

    .line 253
    :cond_3
    invoke-virtual {v0, p2}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 254
    const-string v5, ".ts"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_3

    .line 258
    .end local v0    # "fp":Ljava/lang/StringBuffer;
    .end local v1    # "idx":I
    .end local v2    # "s":Ljava/lang/String;
    .end local v3    # "uri":Ljava/net/URL;
    :catch_0
    move-exception v5

    goto :goto_0
.end method

.method private verifyCanAdd(Landroid/content/ContentResolver;)Z
    .locals 11
    .param p1, "cr"    # Landroid/content/ContentResolver;

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    .line 213
    const/4 v6, 0x0

    .line 215
    .local v6, "c":Landroid/database/Cursor;
    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/cid/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iUuid:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v3, "_id"

    aput-object v3, v2, v0

    const/4 v0, 0x1

    const-string v3, "errorType"

    aput-object v3, v2, v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 216
    if-eqz v6, :cond_4

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 217
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    const-string v1, "errorType"

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-int v1, v2

    aget-object v8, v0, v1

    .line 218
    .local v8, "fds":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v8, v0, :cond_1

    move v0, v9

    .line 224
    :goto_0
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 227
    .end local v8    # "fds":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    :cond_0
    :goto_1
    return v0

    .restart local v8    # "fds":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    :cond_1
    move v0, v10

    .line 218
    goto :goto_0

    .line 220
    .end local v8    # "fds":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    :catch_0
    move-exception v7

    .line 221
    .local v7, "e":Ljava/lang/Exception;
    :try_start_1
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->LOG_TAG:Ljava/lang/String;

    const-string v1, "error verifying HLS file instance"

    invoke-static {v0, v1, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 224
    if-eqz v6, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .end local v7    # "e":Ljava/lang/Exception;
    :cond_2
    :goto_2
    move v0, v10

    .line 227
    goto :goto_1

    .line 223
    :catchall_0
    move-exception v0

    .line 224
    if-eqz v6, :cond_3

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_3

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 225
    :cond_3
    throw v0

    .line 224
    :cond_4
    if-eqz v6, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_2
.end method


# virtual methods
.method public addFragments(Landroid/content/Context;Ljava/util/List;)I
    .locals 15
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 280
    .local p2, "aFragmentUrls":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez p2, :cond_0

    new-instance v13, Ljava/lang/IllegalArgumentException;

    const-string v14, "aFragmentUrls cannot be null"

    invoke-direct {v13, v14}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 281
    :cond_0
    if-nez p1, :cond_1

    new-instance v13, Ljava/lang/IllegalArgumentException;

    const-string v14, "Invalid Context"

    invoke-direct {v13, v14}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v13

    .line 282
    :cond_1
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    .line 283
    .local v3, "cr":Landroid/content/ContentResolver;
    const/4 v11, 0x0

    .line 284
    .local v11, "total_added":I
    invoke-direct {p0, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->verifyCanAdd(Landroid/content/ContentResolver;)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 287
    invoke-interface/range {p2 .. p2}, Ljava/util/List;->size()I

    move-result v8

    .line 288
    .local v8, "size":I
    const/16 v7, 0x3e8

    .line 289
    .local v7, "offset":I
    invoke-static {v7, v8}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 290
    .local v5, "end":I
    const/4 v9, 0x0

    .line 292
    .local v9, "start":I
    :goto_0
    if-lt v9, v8, :cond_3

    .line 317
    .end local v5    # "end":I
    .end local v7    # "offset":I
    .end local v8    # "size":I
    .end local v9    # "start":I
    :cond_2
    iget v13, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    add-int/2addr v13, v11

    iput v13, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    .line 318
    return v11

    .line 293
    .restart local v5    # "end":I
    .restart local v7    # "offset":I
    .restart local v8    # "size":I
    .restart local v9    # "start":I
    :cond_3
    move-object/from16 v0, p2

    invoke-interface {v0, v9, v5}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v10

    .line 295
    .local v10, "sub":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v13

    new-array v12, v13, [Landroid/content/ContentValues;

    .line 296
    .local v12, "values":[Landroid/content/ContentValues;
    const/4 v6, 0x0

    .local v6, "idx":I
    :goto_1
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v13

    if-lt v6, v13, :cond_5

    .line 299
    const/4 v2, 0x0

    .line 301
    .local v2, "client":Landroid/content/ContentProviderClient;
    :try_start_0
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v13}, Landroid/content/ContentResolver;->acquireContentProviderClient(Ljava/lang/String;)Landroid/content/ContentProviderClient;

    move-result-object v2

    .line 302
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v13

    invoke-virtual {v2, v13, v12}, Landroid/content/ContentProviderClient;->bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 303
    .local v1, "added":I
    add-int/2addr v9, v1

    .line 304
    add-int/2addr v11, v1

    .line 309
    if-eqz v2, :cond_4

    .line 310
    invoke-virtual {v2}, Landroid/content/ContentProviderClient;->release()Z

    .line 313
    .end local v1    # "added":I
    :cond_4
    :goto_2
    add-int v13, v9, v7

    invoke-static {v13, v8}, Ljava/lang/Math;->min(II)I

    move-result v5

    goto :goto_0

    .line 297
    .end local v2    # "client":Landroid/content/ContentProviderClient;
    :cond_5
    invoke-interface {v10, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    move-object/from16 v0, p1

    invoke-direct {p0, v13, v0, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->generateContentValues(Ljava/lang/String;Landroid/content/Context;Landroid/content/ContentResolver;)Landroid/content/ContentValues;

    move-result-object v13

    aput-object v13, v12, v6

    .line 296
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 305
    .restart local v2    # "client":Landroid/content/ContentProviderClient;
    :catch_0
    move-exception v4

    .line 306
    .local v4, "e":Ljava/lang/Exception;
    :try_start_1
    sget-object v13, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->LOG_TAG:Ljava/lang/String;

    const-string v14, "failure bulk insert on fragment list"

    invoke-static {v13, v14, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 309
    if-eqz v2, :cond_4

    .line 310
    invoke-virtual {v2}, Landroid/content/ContentProviderClient;->release()Z

    goto :goto_2

    .line 308
    .end local v4    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v13

    .line 309
    if-eqz v2, :cond_6

    .line 310
    invoke-virtual {v2}, Landroid/content/ContentProviderClient;->release()Z

    .line 312
    :cond_6
    throw v13
.end method

.method public addFragments(Ljava/util/List;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 428
    .local p1, "aFragmentUrls":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {p0, v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->addFragments(Landroid/content/Context;Ljava/util/List;)I

    move-result v0

    return v0
.end method

.method public assetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iAssetId:Ljava/lang/String;

    return-object v0
.end method

.method public assetURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    const/4 v0, 0x0

    return-object v0
.end method

.method public currentSize()D
    .locals 2

    .prologue
    .line 182
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    return-wide v0
.end method

.method public expectedSize()D
    .locals 6

    .prologue
    .line 153
    iget v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    if-nez v2, :cond_0

    .line 154
    const-wide/16 v2, 0x0

    .line 156
    :goto_0
    return-wide v2

    .line 155
    :cond_0
    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    iget v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    int-to-double v4, v4

    div-double v0, v2, v4

    .line 156
    .local v0, "avg":D
    iget v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    int-to-double v2, v2

    mul-double/2addr v2, v0

    goto :goto_0
.end method

.method public fractionComplete()D
    .locals 4

    .prologue
    .line 192
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    if-gtz v0, :cond_0

    const-wide/16 v0, 0x0

    .line 193
    :goto_0
    return-wide v0

    :cond_0
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    int-to-double v0, v0

    iget v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    int-to-double v2, v2

    div-double/2addr v0, v2

    goto :goto_0
.end method

.method public fragments()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IFileFragment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 433
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->fragments(Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public fragments(Landroid/content/Context;)Ljava/util/List;
    .locals 14
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IFileFragment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 438
    if-nez p1, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Invalid Context"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 439
    :cond_0
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 440
    .local v8, "l":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IFileFragment;>;"
    const/4 v6, 0x0

    .line 441
    .local v6, "c":Landroid/database/Cursor;
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 444
    .local v0, "cr":Landroid/content/ContentResolver;
    const/16 v9, 0x3e8

    .line 445
    .local v9, "limit":I
    const/4 v11, 0x0

    .line 446
    .local v11, "offset":I
    :try_start_0
    const-string v12, "_id ASC LIMIT "

    .line 447
    .local v12, "sort":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x3e8

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 449
    .local v10, "limit_clause":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/parent/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iUuid:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v13, "_id ASC LIMIT "

    invoke-direct {v5, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 450
    :goto_0
    if-eqz v6, :cond_1

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-gtz v1, :cond_3

    .line 466
    :cond_1
    if-eqz v6, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_2

    .line 467
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 470
    .end local v10    # "limit_clause":Ljava/lang/String;
    .end local v12    # "sort":Ljava/lang/String;
    :cond_2
    :goto_1
    return-object v8

    .line 451
    .restart local v10    # "limit_clause":Ljava/lang/String;
    .restart local v12    # "sort":Ljava/lang/String;
    :cond_3
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "retrieving paged fragment results: ["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 452
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 454
    :cond_4
    new-instance v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;

    invoke-direct {v1, p0, v6}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;-><init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;Landroid/database/Cursor;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 455
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    .line 453
    if-nez v1, :cond_4

    .line 457
    :cond_5
    add-int/lit16 v11, v11, 0x3e8

    .line 458
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x3e8

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 459
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 460
    const/4 v6, 0x0

    .line 461
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/parent/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iUuid:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v13, "_id ASC LIMIT "

    invoke-direct {v5, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v6

    goto/16 :goto_0

    .line 463
    .end local v10    # "limit_clause":Ljava/lang/String;
    .end local v12    # "sort":Ljava/lang/String;
    :catch_0
    move-exception v7

    .line 464
    .local v7, "e":Ljava/lang/Exception;
    :try_start_2
    sget-object v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "problem retrieving fragments for ["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iUuid:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 466
    if-eqz v6, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_2

    .line 467
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto/16 :goto_1

    .line 465
    .end local v7    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    .line 466
    if-eqz v6, :cond_6

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_6

    .line 467
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 469
    :cond_6
    throw v1
.end method

.method public isPending()Z
    .locals 1

    .prologue
    .line 203
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iIsPending:Z

    return v0
.end method

.method public localBaseDir()Ljava/lang/String;
    .locals 2

    .prologue
    .line 115
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFilePath:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFilePath:Ljava/lang/String;

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFilePath:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "/"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFilePath:Ljava/lang/String;

    .line 117
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFilePath:Ljava/lang/String;

    return-object v0
.end method

.method public metadata()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iMetaData:Ljava/lang/String;

    return-object v0
.end method

.method public pendingFragments(Landroid/content/Context;)Ljava/util/List;
    .locals 14
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 390
    if-nez p1, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Invalid Context"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 391
    :cond_0
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 392
    .local v8, "l":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;>;"
    const/4 v6, 0x0

    .line 393
    .local v6, "c":Landroid/database/Cursor;
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 396
    .local v0, "cr":Landroid/content/ContentResolver;
    const/16 v9, 0x3e8

    .line 397
    .local v9, "limit":I
    const/4 v11, 0x0

    .line 398
    .local v11, "offset":I
    :try_start_0
    const-string v12, "_id ASC LIMIT "

    .line 399
    .local v12, "sort":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x3e8

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 400
    .local v10, "limit_clause":Ljava/lang/String;
    const-string v3, "pending=1"

    .line 402
    .local v3, "WHERE":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/parent/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iUuid:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v13, "_id ASC LIMIT "

    invoke-direct {v5, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 403
    :goto_0
    if-eqz v6, :cond_1

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-gtz v1, :cond_3

    .line 419
    :cond_1
    if-eqz v6, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_2

    .line 420
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 423
    .end local v3    # "WHERE":Ljava/lang/String;
    .end local v10    # "limit_clause":Ljava/lang/String;
    .end local v12    # "sort":Ljava/lang/String;
    :cond_2
    :goto_1
    return-object v8

    .line 404
    .restart local v3    # "WHERE":Ljava/lang/String;
    .restart local v10    # "limit_clause":Ljava/lang/String;
    .restart local v12    # "sort":Ljava/lang/String;
    :cond_3
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "retrieving paged fragment results: ["

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ", "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "]"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 405
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 407
    :cond_4
    new-instance v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;

    invoke-direct {v1, p0, v6}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;-><init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;Landroid/database/Cursor;)V

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 408
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    .line 406
    if-nez v1, :cond_4

    .line 410
    :cond_5
    add-int/lit16 v11, v11, 0x3e8

    .line 411
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x3e8

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 412
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 413
    const/4 v6, 0x0

    .line 414
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/parent/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iUuid:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v13, "_id ASC LIMIT "

    invoke-direct {v5, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v6

    goto/16 :goto_0

    .line 416
    .end local v3    # "WHERE":Ljava/lang/String;
    .end local v10    # "limit_clause":Ljava/lang/String;
    .end local v12    # "sort":Ljava/lang/String;
    :catch_0
    move-exception v7

    .line 417
    .local v7, "e":Ljava/lang/Exception;
    :try_start_2
    sget-object v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "problem retrieving fragments for ["

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iUuid:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "]"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 419
    if-eqz v6, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_2

    .line 420
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto/16 :goto_1

    .line 418
    .end local v7    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    .line 419
    if-eqz v6, :cond_6

    invoke-interface {v6}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_6

    .line 420
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 422
    :cond_6
    throw v1
.end method

.method protected readFromParcel(Landroid/os/Parcel;)V
    .locals 4
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v0, 0x1

    .line 87
    invoke-super {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->readFromParcel(Landroid/os/Parcel;)V

    .line 88
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iAssetId:Ljava/lang/String;

    .line 89
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iMetaData:Ljava/lang/String;

    .line 90
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iExpectedSize:D

    .line 91
    invoke-virtual {p1}, Landroid/os/Parcel;->readDouble()D

    move-result-wide v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    .line 92
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->readStringProperty(Landroid/os/Parcel;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFilePath:Ljava/lang/String;

    .line 93
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iIsPending:Z

    .line 94
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    .line 95
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    .line 96
    return-void

    .line 93
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method refresh(Landroid/database/Cursor;)V
    .locals 4
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    const/4 v0, 0x1

    .line 68
    const-string v1, "assetId"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setAssetId(Ljava/lang/String;)V

    .line 69
    const-string v1, "currentSize"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-double v2, v2

    invoke-virtual {p0, v2, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setCurrentSize(D)V

    .line 70
    const-string v1, "expectedSize"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-double v2, v2

    invoke-virtual {p0, v2, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setExpectedSize(D)V

    .line 71
    const-string v1, "description"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iMetaData:Ljava/lang/String;

    .line 72
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v1

    const-string v2, "errorType"

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p1, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-int v2, v2

    aget-object v1, v1, v2

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 73
    const-string v1, "filePath"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setLocalBaseDir(Ljava/lang/String;)V

    .line 74
    const-string v1, "uuid"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setUuid(Ljava/lang/String;)V

    .line 75
    const-string v1, "pending"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getShort(I)S

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setPending(Z)V

    .line 76
    const-string v0, "parentUuid"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setParentUuid(Ljava/lang/String;)V

    .line 77
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setId(I)V

    .line 78
    const-string v0, "completeTime"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setCompletionTime(J)V

    .line 79
    const-string v0, "clientAuthority"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setClientProviderAuth(Ljava/lang/String;)V

    .line 80
    const-string v0, "hlsFragmentCount"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    .line 81
    const-string v0, "hlsFragmentCompletedCount"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    .line 82
    const-string v0, "contentState"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setContentState(I)V

    .line 83
    return-void

    .line 75
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public regenerateFilePath(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)V
    .locals 1
    .param p1, "cr"    # Landroid/content/ContentResolver;
    .param p2, "client"    # Ljava/lang/String;
    .param p3, "cx"    # Landroid/content/Context;

    .prologue
    .line 609
    invoke-static {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->generateFilePath(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setLocalBaseDir(Ljava/lang/String;)V

    .line 610
    return-void
.end method

.method public setAssetId(Ljava/lang/String;)V
    .locals 0
    .param p1, "aAssetId"    # Ljava/lang/String;

    .prologue
    .line 143
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iAssetId:Ljava/lang/String;

    .line 144
    return-void
.end method

.method public setCompletedCount(I)V
    .locals 0
    .param p1, "completed"    # I

    .prologue
    .line 177
    iput p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    .line 178
    return-void
.end method

.method public setCurrentSize(D)V
    .locals 1
    .param p1, "s"    # D

    .prologue
    .line 187
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    .line 188
    return-void
.end method

.method public setExpectedSize(D)V
    .locals 1
    .param p1, "s"    # D

    .prologue
    .line 161
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iExpectedSize:D

    .line 162
    return-void
.end method

.method public setLocalBaseDir(Ljava/lang/String;)V
    .locals 0
    .param p1, "aPath"    # Ljava/lang/String;

    .prologue
    .line 198
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFilePath:Ljava/lang/String;

    .line 199
    return-void
.end method

.method public setMetadata(Ljava/lang/String;)V
    .locals 0
    .param p1, "aMetaData"    # Ljava/lang/String;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iMetaData:Ljava/lang/String;

    .line 149
    return-void
.end method

.method public setPending(Z)V
    .locals 0
    .param p1, "aPending"    # Z

    .prologue
    .line 209
    iput-boolean p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iIsPending:Z

    .line 210
    return-void
.end method

.method public totalFragments()I
    .locals 1

    .prologue
    .line 166
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    return v0
.end method

.method public totalFragmentsComplete()I
    .locals 1

    .prologue
    .line 172
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    return v0
.end method

.method public updateFragment(Landroid/content/Context;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "iFileFragment"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;

    .prologue
    .line 333
    invoke-interface {p2, p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->update(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flag"    # I

    .prologue
    .line 101
    invoke-super {p0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoIdentifier;->writeToParcel(Landroid/os/Parcel;I)V

    .line 102
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iAssetId:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 103
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iMetaData:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 104
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->expectedSize()D

    move-result-wide v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 105
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeDouble(D)V

    .line 106
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFilePath:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->writeStringProperty(Landroid/os/Parcel;Ljava/lang/String;)V

    .line 107
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iIsPending:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 108
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iFragmentCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 109
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCompletedCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 110
    return-void

    .line 107
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
