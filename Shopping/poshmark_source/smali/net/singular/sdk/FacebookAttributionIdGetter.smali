.class Lnet/singular/sdk/FacebookAttributionIdGetter;
.super Ljava/lang/Object;
.source "FacebookAttributionIdGetter.java"


# static fields
.field private static final ANDROID_ID_COLUMN_NAME:Ljava/lang/String; = "androidid"

.field private static final ATTRIBUTION_ID_COLUMN_NAME:Ljava/lang/String; = "aid"

.field private static final ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

.field private static final LIMIT_TRACKING_COLUMN_NAME:Ljava/lang/String; = "limit_tracking"


# instance fields
.field private final context:Landroid/content/Context;

.field private final log:Lnet/singular/sdk/SingularLog;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-string v0, "content://com.facebook.katana.provider.AttributionIdProvider"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lnet/singular/sdk/FacebookAttributionIdGetter;->ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lnet/singular/sdk/SingularLog;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "log"    # Lnet/singular/sdk/SingularLog;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p2, p0, Lnet/singular/sdk/FacebookAttributionIdGetter;->log:Lnet/singular/sdk/SingularLog;

    .line 18
    iput-object p1, p0, Lnet/singular/sdk/FacebookAttributionIdGetter;->context:Landroid/content/Context;

    .line 19
    return-void
.end method


# virtual methods
.method public getAdvertisingId()Ljava/lang/String;
    .locals 11

    .prologue
    const/4 v10, 0x0

    .line 46
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "androidid"

    aput-object v1, v2, v0

    const/4 v0, 0x1

    const-string v1, "limit_tracking"

    aput-object v1, v2, v0

    .line 47
    .local v2, "projection":[Ljava/lang/String;
    const/4 v7, 0x0

    .line 49
    .local v7, "c":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/FacebookAttributionIdGetter;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lnet/singular/sdk/FacebookAttributionIdGetter;->ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 50
    if-nez v7, :cond_2

    .line 51
    iget-object v0, p0, Lnet/singular/sdk/FacebookAttributionIdGetter;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v3, "Couldn\'t connect to facebook attribution content provider"

    invoke-virtual {v0, v1, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 72
    if-eqz v7, :cond_0

    .line 73
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_0
    move-object v0, v10

    :cond_1
    :goto_0
    return-object v0

    .line 54
    :cond_2
    :try_start_1
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_4

    .line 55
    iget-object v0, p0, Lnet/singular/sdk/FacebookAttributionIdGetter;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v3, "Couldn\'t get google aid from Facebook"

    invoke-virtual {v0, v1, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 72
    if-eqz v7, :cond_3

    .line 73
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_3
    move-object v0, v10

    goto :goto_0

    .line 59
    :cond_4
    :try_start_2
    const-string v0, "androidid"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 60
    .local v6, "androidIdColumnIndex":I
    const-string v0, "limit_tracking"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 64
    .local v9, "limitTrackingColumnIndex":I
    if-lez v6, :cond_5

    if-lez v9, :cond_5

    .line 65
    invoke-interface {v7, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v8

    .line 66
    .local v8, "limitTracking":Z
    if-nez v8, :cond_5

    .line 67
    invoke-interface {v7, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    .line 72
    if-eqz v7, :cond_1

    .line 73
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 72
    .end local v8    # "limitTracking":Z
    :cond_5
    if-eqz v7, :cond_6

    .line 73
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_6
    move-object v0, v10

    goto :goto_0

    .line 72
    .end local v6    # "androidIdColumnIndex":I
    .end local v9    # "limitTrackingColumnIndex":I
    :catchall_0
    move-exception v0

    if-eqz v7, :cond_7

    .line 73
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_7
    throw v0
.end method

.method public getAttributionId()Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 22
    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "aid"

    aput-object v1, v2, v0

    .line 23
    .local v2, "projection":[Ljava/lang/String;
    const/4 v7, 0x0

    .line 25
    .local v7, "c":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lnet/singular/sdk/FacebookAttributionIdGetter;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lnet/singular/sdk/FacebookAttributionIdGetter;->ATTRIBUTION_ID_CONTENT_URI:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 26
    if-nez v7, :cond_2

    .line 27
    iget-object v0, p0, Lnet/singular/sdk/FacebookAttributionIdGetter;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v3, "Couldn\'t connect to facebook attribution content provider"

    invoke-virtual {v0, v1, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 39
    if-eqz v7, :cond_0

    .line 40
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_0
    move-object v0, v8

    :cond_1
    :goto_0
    return-object v0

    .line 30
    :cond_2
    :try_start_1
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_4

    .line 31
    iget-object v0, p0, Lnet/singular/sdk/FacebookAttributionIdGetter;->log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v3, "Couldn\'t get attribution id from Facebook"

    invoke-virtual {v0, v1, v3}, Lnet/singular/sdk/SingularLog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    invoke-interface {v7}, Landroid/database/Cursor;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 39
    if-eqz v7, :cond_3

    .line 40
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_3
    move-object v0, v8

    goto :goto_0

    .line 36
    :cond_4
    :try_start_2
    const-string v0, "aid"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 37
    .local v6, "attributionColumnIndex":I
    invoke-interface {v7, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v0

    .line 39
    if-eqz v7, :cond_1

    .line 40
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 39
    .end local v6    # "attributionColumnIndex":I
    :catchall_0
    move-exception v0

    if-eqz v7, :cond_5

    .line 40
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_5
    throw v0
.end method
