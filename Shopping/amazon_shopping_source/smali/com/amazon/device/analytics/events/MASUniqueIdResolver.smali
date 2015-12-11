.class public Lcom/amazon/device/analytics/events/MASUniqueIdResolver;
.super Lcom/amazon/device/analytics/events/UniqueIdResolverChain;
.source "MASUniqueIdResolver.java"


# static fields
.field private static final logging:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final appContext:Landroid/content/Context;

.field private final fileManager:Lcom/amazon/device/analytics/util/FileManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;->logging:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/analytics/util/FileManager;Landroid/content/Context;Lcom/amazon/device/analytics/events/UniqueIdResolver;)V
    .locals 1
    .param p1, "fileManager"    # Lcom/amazon/device/analytics/util/FileManager;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "resolver"    # Lcom/amazon/device/analytics/events/UniqueIdResolver;

    .prologue
    .line 32
    invoke-direct {p0, p3}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;-><init>(Lcom/amazon/device/analytics/events/UniqueIdResolver;)V

    .line 33
    invoke-virtual {p2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;->appContext:Landroid/content/Context;

    .line 34
    iput-object p1, p0, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;->fileManager:Lcom/amazon/device/analytics/util/FileManager;

    .line 35
    return-void
.end method


# virtual methods
.method public tryResolve()Ljava/lang/String;
    .locals 5

    .prologue
    .line 43
    :try_start_0
    new-instance v2, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "/data/data/com.amazon.venezia"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "files"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 44
    .local v2, "worldReadableDir":Ljava/io/File;
    new-instance v1, Ljava/io/File;

    const-string/jumbo v3, "amzn-unique.txt"

    invoke-direct {v1, v2, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 45
    .local v1, "uniqueIdFile":Ljava/io/File;
    iget-object v3, p0, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;->fileManager:Lcom/amazon/device/analytics/util/FileManager;

    invoke-virtual {v3, v1}, Lcom/amazon/device/analytics/util/FileManager;->readFileContents(Ljava/io/File;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 48
    .end local v1    # "uniqueIdFile":Ljava/io/File;
    .end local v2    # "worldReadableDir":Ljava/io/File;
    :goto_0
    return-object v3

    .line 46
    :catch_0
    move-exception v0

    .line 47
    .local v0, "ex":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;->logging:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v4, "Error reading file contents"

    invoke-virtual {v3, v4, v0}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 48
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public tryStore(Ljava/lang/String;)Z
    .locals 7
    .param p1, "uniqueId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 57
    const-string/jumbo v4, "com.amazon.venezia"

    iget-object v5, p0, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;->appContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 59
    :try_start_0
    iget-object v4, p0, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;->appContext:Landroid/content/Context;

    const-string/jumbo v5, "amzn-unique.txt"

    const/4 v6, 0x1

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v1

    .line 60
    .local v1, "fos":Ljava/io/FileOutputStream;
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/io/FileOutputStream;->write([B)V

    .line 61
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    .end local v1    # "fos":Ljava/io/FileOutputStream;
    :goto_0
    return v2

    .line 64
    :catch_0
    move-exception v0

    .line 65
    .local v0, "ex":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/device/analytics/events/MASUniqueIdResolver;->logging:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v4, "Error writing file contents"

    invoke-virtual {v2, v4, v0}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    move v2, v3

    .line 66
    goto :goto_0

    .end local v0    # "ex":Ljava/lang/Exception;
    :cond_0
    move v2, v3

    .line 69
    goto :goto_0
.end method
