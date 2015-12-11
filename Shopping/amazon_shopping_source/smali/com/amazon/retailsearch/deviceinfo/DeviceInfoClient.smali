.class public Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;
.super Ljava/lang/Object;
.source "DeviceInfoClient.java"


# static fields
.field private static final DEVICE_INFO_URL:Ljava/lang/String; = "content://com.amazon.mas.client.framework.DeviceInfoContentProvider"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDeviceInfo(Landroid/content/Context;)Ljava/util/Map;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 86
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;->getDeviceInfoUrl(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;->getDeviceInfo(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceInfo(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Map;
    .locals 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 27
    if-nez p1, :cond_1

    .line 78
    :cond_0
    :goto_0
    return-object v2

    .line 32
    :cond_1
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 34
    .local v7, "cursor":Landroid/database/Cursor;
    if-eqz v7, :cond_0

    .line 39
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 41
    .local v8, "deviceInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    .line 43
    :goto_1
    invoke-interface {v7}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v0

    if-nez v0, :cond_6

    .line 45
    invoke-interface {v7}, Landroid/database/Cursor;->getColumnNames()[Ljava/lang/String;

    move-result-object v6

    .line 47
    .local v6, "columnNames":[Ljava/lang/String;
    if-eqz v6, :cond_5

    array-length v0, v6

    if-lez v0, :cond_5

    .line 49
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_2
    array-length v0, v6

    if-ge v9, v0, :cond_2

    .line 51
    aget-object v0, v6, v9

    invoke-interface {v7, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v8, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    add-int/lit8 v9, v9, 0x1

    goto :goto_2

    .line 54
    :cond_2
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 56
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "DeviceInfoContentProvider fields ("

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    array-length v1, v6

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "): "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    .line 59
    .local v10, "sb":Ljava/lang/StringBuilder;
    const/4 v9, 0x0

    :goto_3
    array-length v0, v6

    if-ge v9, v0, :cond_4

    .line 61
    aget-object v0, v6, v9

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-interface {v7, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 63
    array-length v0, v6

    add-int/lit8 v0, v0, -0x1

    if-ge v9, v0, :cond_3

    .line 65
    const-string/jumbo v0, ", "

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 59
    :cond_3
    add-int/lit8 v9, v9, 0x1

    goto :goto_3

    .line 69
    :cond_4
    sget-object v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoClient;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->debug(Ljava/lang/String;)V

    .line 73
    .end local v9    # "i":I
    .end local v10    # "sb":Ljava/lang/StringBuilder;
    :cond_5
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_1

    .line 76
    .end local v6    # "columnNames":[Ljava/lang/String;
    :cond_6
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    move-object v2, v8

    .line 78
    goto/16 :goto_0
.end method

.method public getDeviceInfoUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    const-string/jumbo v0, "content://com.amazon.mas.client.framework.DeviceInfoContentProvider"

    return-object v0
.end method

.method public getDeviceInfoUrl(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 96
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "content://com.amazon.mas.client.framework.DeviceInfoContentProvider-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
