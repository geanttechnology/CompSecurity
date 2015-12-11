.class public Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;
.super Ljava/lang/Object;
.source "VirtuosoContentBox.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$TestInterface;
    }
.end annotation


# static fields
.field static FULL_PROJECTION:[Ljava/lang/String;

.field private static final LOG_TAG:Ljava/lang/String;

.field static iApplicationContext:Landroid/content/Context;


# instance fields
.field private iBound:Z

.field iCurrentAuthority:Ljava/lang/String;

.field private iDownloadLock:Ljava/lang/Object;

.field private iDownloadedCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

.field private iDownloadedObservers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IDownloadedObserver;",
            ">;"
        }
    .end annotation
.end field

.field private iEngineCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

.field private iEngineLock:Ljava/lang/Object;

.field private iEngineObservers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IEngineObserver;",
            ">;"
        }
    .end annotation
.end field

.field iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

.field private iQueueCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

.field private iQueueLock:Ljava/lang/Object;

.field private iQueueObservers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IQueueObserver;",
            ">;"
        }
    .end annotation
.end field

.field private iRegisteredCallbacks:S

.field iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

.field private iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

.field private iServiceComponent:Landroid/content/ComponentName;

.field private iServiceConnectedCallback:Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;

.field private iServiceConnection:Landroid/content/ServiceConnection;

.field private iTestWrapper:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$TestInterface;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 51
    const-class v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    .line 53
    const/4 v0, 0x0

    sput-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    .line 680
    const/16 v0, 0x18

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    .line 681
    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    .line 682
    const-string v2, "uuid"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    .line 683
    const-string v2, "parentUuid"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    .line 684
    const-string v2, "assetId"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    .line 685
    const-string v2, "assetUrl"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    .line 686
    const-string v2, "creationTime"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    .line 687
    const-string v2, "currentSize"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    .line 688
    const-string v2, "description"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    .line 689
    const-string v2, "errorType"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    .line 690
    const-string v2, "expectedSize"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    .line 691
    const-string v2, "fileHash"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    .line 692
    const-string v2, "filePath"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    .line 693
    const-string v2, "mimeType"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    .line 694
    const-string v2, "modifyTime"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    .line 695
    const-string v2, "completeTime"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    .line 696
    const-string v2, "errorCount"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    .line 697
    const-string v2, "hashState"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    .line 698
    const-string v2, "pending"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    .line 699
    const-string v2, "addedToQueue"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    .line 700
    const-string v2, "contentType"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    .line 701
    const-string v2, "clientAuthority"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    .line 702
    const-string v2, "hlsFragmentCompletedCount"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    .line 703
    const-string v2, "hlsFragmentCount"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    .line 704
    const-string v2, "contentState"

    aput-object v2, v0, v1

    .line 680
    sput-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->FULL_PROJECTION:[Ljava/lang/String;

    .line 49
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;Landroid/content/ComponentName;)V
    .locals 6
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "iscc"    # Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;
    .param p3, "service"    # Landroid/content/ComponentName;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 320
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceConnectedCallback:Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;

    .line 56
    iput-object v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    .line 57
    iput-boolean v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iBound:Z

    .line 58
    iput-object v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceConnection:Landroid/content/ServiceConnection;

    .line 74
    new-instance v3, Ljava/lang/Object;

    invoke-direct {v3}, Ljava/lang/Object;-><init>()V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineLock:Ljava/lang/Object;

    .line 75
    new-instance v3, Ljava/lang/Object;

    invoke-direct {v3}, Ljava/lang/Object;-><init>()V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadLock:Ljava/lang/Object;

    .line 76
    new-instance v3, Ljava/lang/Object;

    invoke-direct {v3}, Ljava/lang/Object;-><init>()V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueLock:Ljava/lang/Object;

    .line 77
    iput-short v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    .line 79
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;

    .line 80
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineObservers:Ljava/util/List;

    .line 81
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedObservers:Ljava/util/List;

    .line 129
    new-instance v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;

    invoke-direct {v3, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$1;-><init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    .line 254
    new-instance v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$2;

    invoke-direct {v3, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$2;-><init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    .line 304
    new-instance v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$3;

    invoke-direct {v3, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$3;-><init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

    .line 2284
    iput-object v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iTestWrapper:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$TestInterface;

    .line 321
    if-nez p1, :cond_0

    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Context is invalid"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 322
    :cond_0
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    if-nez v3, :cond_1

    .line 323
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    sput-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    .line 326
    :cond_1
    :try_start_0
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    sget-object v4, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x80

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 327
    .local v0, "ai":Landroid/content/pm/ApplicationInfo;
    iget-object v1, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 329
    .local v1, "b":Landroid/os/Bundle;
    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 334
    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 335
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "cannot retrieve authority. was the metadata for com.penthera.virtuososdk.client.pckg specified in the manifest under application?"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 331
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v1    # "b":Landroid/os/Bundle;
    :catch_0
    move-exception v2

    .line 332
    .local v2, "e":Ljava/lang/Exception;
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "cannot retrieve authority"

    invoke-direct {v3, v4, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 336
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .restart local v1    # "b":Landroid/os/Bundle;
    :cond_2
    iput-object p3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    .line 337
    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    if-eqz v3, :cond_3

    .line 338
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Component Logging"

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Component CN "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    invoke-virtual {v5}, Landroid/content/ComponentName;->getClassName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Component PN "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    invoke-virtual {v5}, Landroid/content/ComponentName;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 341
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Component SCN "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    invoke-virtual {v5}, Landroid/content/ComponentName;->getShortClassName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Component FSS "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    invoke-virtual {v5}, Landroid/content/ComponentName;->flattenToShortString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 343
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Component FS "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    invoke-virtual {v5}, Landroid/content/ComponentName;->flattenToString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 344
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Component SS "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    invoke-virtual {v5}, Landroid/content/ComponentName;->toShortString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 347
    :cond_3
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->createRoot(Landroid/content/Context;)Z

    .line 348
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->createMediaRoot(Landroid/content/Context;)Z

    .line 349
    iput-object p2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceConnectedCallback:Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;

    .line 350
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->initService()V

    .line 352
    new-instance v3, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    sget-object v4, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-direct {v3, v4, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    .line 353
    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    const-string v4, "root_destination_path"

    invoke-virtual {v3, v4}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 354
    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    const-string v4, "root_destination_path"

    sget-object v5, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-static {v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->getMediaRoot(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 356
    :cond_4
    new-instance v3, Lcom/penthera/virtuososdk/manager/FileManager;

    invoke-direct {v3}, Lcom/penthera/virtuososdk/manager/FileManager;-><init>()V

    iput-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

    .line 357
    return-void
.end method

.method static synthetic access$0(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .locals 1

    .prologue
    .line 97
    invoke-direct/range {p0 .. p7}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFileWithMinData(Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$10(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V
    .locals 0

    .prologue
    .line 495
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->registerCallbackHandlers()V

    return-void
.end method

.method static synthetic access$11(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceConnectedCallback:Lcom/penthera/virtuososdk/client/IServiceConnectedCallback;

    return-object v0
.end method

.method static synthetic access$12(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Z)V
    .locals 0

    .prologue
    .line 57
    iput-boolean p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iBound:Z

    return-void
.end method

.method static synthetic access$13(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;S)V
    .locals 0

    .prologue
    .line 77
    iput-short p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    return-void
.end method

.method static synthetic access$14(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

    return-object v0
.end method

.method static synthetic access$2(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineObservers:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$3(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Ljava/util/List;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedObservers:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$8()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$9(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    return-void
.end method

.method public static appDiskUsage(Landroid/content/ContentResolver;Ljava/lang/String;)D
    .locals 14
    .param p0, "cr"    # Landroid/content/ContentResolver;
    .param p1, "authority"    # Ljava/lang/String;

    .prologue
    .line 2040
    const-wide/16 v12, 0x0

    .line 2041
    .local v12, "totalUsage":D
    const/4 v10, 0x0

    .line 2043
    .local v10, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v3, "contentType=1"

    .line 2044
    .local v3, "WHERE_IS_FILE":Ljava/lang/String;
    invoke-static {p1}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v4, "currentSize"

    aput-object v4, v2, v0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 2045
    if-eqz v10, :cond_1

    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2047
    :cond_0
    const/4 v0, 0x0

    invoke-interface {v10, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    long-to-double v0, v0

    add-double/2addr v12, v0

    .line 2048
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    .line 2046
    if-nez v0, :cond_0

    .line 2050
    :cond_1
    if-eqz v10, :cond_2

    .line 2051
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 2052
    const/4 v10, 0x0

    .line 2054
    :cond_2
    invoke-static {p1}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    const/4 v0, 0x1

    new-array v6, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "currentSize"

    aput-object v1, v6, v0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v4, p0

    invoke-virtual/range {v4 .. v9}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 2055
    if-eqz v10, :cond_4

    invoke-interface {v10}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 2057
    :cond_3
    const/4 v0, 0x0

    invoke-interface {v10, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    long-to-double v0, v0

    add-double/2addr v12, v0

    .line 2058
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    .line 2056
    if-nez v0, :cond_3

    .line 2059
    invoke-interface {v10}, Landroid/database/Cursor;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2060
    const/4 v10, 0x0

    .line 2067
    :cond_4
    if-eqz v10, :cond_5

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 2070
    .end local v3    # "WHERE_IS_FILE":Ljava/lang/String;
    :cond_5
    :goto_0
    return-wide v12

    .line 2063
    :catch_0
    move-exception v11

    .line 2064
    .local v11, "e":Ljava/lang/Exception;
    :try_start_1
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Caught exception while fetching total disk usage size: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2067
    if-eqz v10, :cond_5

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 2066
    .end local v11    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 2067
    if-eqz v10, :cond_6

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 2068
    :cond_6
    throw v0
.end method

.method private bind()V
    .locals 5

    .prologue
    .line 420
    iget-boolean v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iBound:Z

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    if-nez v2, :cond_1

    .line 421
    :cond_0
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 422
    .local v1, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceComponent:Landroid/content/ComponentName;

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 424
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 425
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "com.penthera.virtuososdk.client.pckg"

    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 426
    sget-object v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceConnection:Landroid/content/ServiceConnection;

    .line 427
    const/4 v4, 0x1

    .line 426
    invoke-virtual {v2, v1, v3, v4}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v2

    iput-boolean v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iBound:Z

    .line 429
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_1
    return-void
.end method

.method private create(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V
    .locals 6
    .param p1, "item"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    .prologue
    .line 2079
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {p1, v2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setClientProviderAuth(Ljava/lang/String;)V

    .line 2080
    sget-object v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 2081
    .local v1, "resolver":Landroid/content/ContentResolver;
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->type()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_1

    move-object v2, p1

    .line 2082
    check-cast v2, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    move-object v3, p1

    check-cast v3, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    iget-object v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    sget-object v5, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-static {v3, v1, v4, v5}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->generateFilePath(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setLocalBaseDir(Ljava/lang/String;)V

    .line 2086
    :cond_0
    :goto_0
    const/4 v2, 0x3

    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {p1, v2, v1, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->save(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ILandroid/content/ContentResolver;Ljava/lang/String;)I

    move-result v0

    .line 2087
    .local v0, "item_id":I
    invoke-interface {p1, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setId(I)V

    .line 2089
    return-void

    .line 2083
    .end local v0    # "item_id":I
    :cond_1
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->type()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    move-object v2, p1

    .line 2084
    check-cast v2, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    move-object v3, p1

    check-cast v3, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    iget-object v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    sget-object v5, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-static {v3, v1, v4, v5}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->generateFilePath(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setFilePath(Ljava/lang/String;)V

    goto :goto_0
.end method

.method static generateFilePath(Lcom/penthera/virtuososdk/client/IVirtuosoAsset;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    .locals 11
    .param p0, "vi"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .param p1, "cr"    # Landroid/content/ContentResolver;
    .param p2, "authority"    # Ljava/lang/String;
    .param p3, "cx"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x0

    const/4 v10, 0x4

    .line 2139
    if-eqz p0, :cond_a

    .line 2141
    const/4 v1, 0x0

    .line 2142
    .local v1, "extension":Ljava/lang/String;
    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v8

    if-eq v8, v10, :cond_0

    .line 2145
    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetURL()Ljava/lang/String;

    move-result-object v8

    const-string v9, "."

    invoke-virtual {v8, v9}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v4

    .line 2146
    .local v4, "idx":I
    if-ltz v4, :cond_b

    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetURL()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 2149
    .end local v4    # "idx":I
    :cond_0
    :goto_0
    new-instance v5, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-direct {v5, p1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 2152
    .local v5, "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    const-string v7, "root_destination_path"

    invoke-virtual {v5, v7}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2155
    .local v0, "bp":Ljava/lang/String;
    const-string v7, "destination_path_override"

    invoke-virtual {v5, v7}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2156
    .local v6, "relpath":Ljava/lang/String;
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-nez v7, :cond_2

    :cond_1
    const-string v7, "destination_path"

    invoke-virtual {v5, v7}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 2157
    :cond_2
    if-nez v6, :cond_3

    const-string v6, "/"

    .line 2159
    :cond_3
    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_4

    const-string v7, "/"

    invoke-virtual {v0, v7}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_4

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "/"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 2160
    :cond_4
    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    const-string v7, "/"

    invoke-virtual {v0, v7}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    const-string v7, "/"

    const-string v8, ""

    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 2161
    :cond_5
    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 2164
    :cond_6
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 2166
    .local v3, "fp":Ljava/lang/StringBuffer;
    invoke-virtual {v3, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2168
    invoke-virtual {v3, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2169
    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v7

    if-ne v7, v10, :cond_7

    .line 2170
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, "/"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2173
    :cond_7
    new-instance v2, Ljava/io/File;

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v2, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 2174
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v7

    if-nez v7, :cond_8

    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    .line 2175
    :cond_8
    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v7

    if-eq v7, v10, :cond_9

    .line 2177
    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2178
    if-eqz v1, :cond_9

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v7

    const/4 v8, 0x6

    if-ge v7, v8, :cond_9

    invoke-virtual {v3, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2180
    :cond_9
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    .line 2182
    .end local v0    # "bp":Ljava/lang/String;
    .end local v1    # "extension":Ljava/lang/String;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "fp":Ljava/lang/StringBuffer;
    .end local v5    # "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    .end local v6    # "relpath":Ljava/lang/String;
    :cond_a
    return-object v7

    .restart local v1    # "extension":Ljava/lang/String;
    .restart local v4    # "idx":I
    :cond_b
    move-object v1, v7

    .line 2146
    goto/16 :goto_0
.end method

.method private getFileWithMinData(Ljava/lang/String;IDDI)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .locals 5
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "errorOrdinal"    # I
    .param p3, "expected"    # D
    .param p5, "current"    # D
    .param p7, "fragsComplete"    # I

    .prologue
    .line 100
    sget-object v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {p0, v2, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v1

    .line 101
    .local v1, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v1, :cond_0

    .line 102
    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 122
    :pswitch_0
    sget-object v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "UNSUPPORTED IDENTIFIER TYPE "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    const/4 v1, 0x0

    .line 126
    :cond_0
    :goto_0
    return-object v1

    :pswitch_1
    move-object v0, v1

    .line 105
    check-cast v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    .line 106
    .local v0, "f":Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;
    invoke-virtual {v0, p7}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setCompletedCount(I)V

    .line 107
    invoke-virtual {v0, p3, p4}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setExpectedSize(D)V

    .line 108
    invoke-virtual {v0, p5, p6}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setCurrentSize(D)V

    .line 109
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v2

    aget-object v2, v2, p2

    invoke-virtual {v0, v2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    goto :goto_0

    .end local v0    # "f":Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;
    :pswitch_2
    move-object v0, v1

    .line 115
    check-cast v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;

    .line 116
    .local v0, "f":Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;
    invoke-virtual {v0, p5, p6}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setCurrentSize(D)V

    .line 117
    invoke-virtual {v0, p3, p4}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setExpectedSize(D)V

    .line 118
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v2

    aget-object v2, v2, p2

    invoke-virtual {v0, v2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    goto :goto_0

    .line 102
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method static getFiles(ILjava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p0, "flags"    # I
    .param p1, "collectionUuid"    # Ljava/lang/String;
    .param p2, "aAuthority"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation

    .prologue
    .line 742
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-static {v0, p0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFiles(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method static getFiles(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 17
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "flags"    # I
    .param p2, "collectionUuid"    # Ljava/lang/String;
    .param p3, "aAuthority"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation

    .prologue
    .line 746
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 747
    .local v10, "l":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;>;"
    const/4 v9, 0x0

    .line 748
    .local v9, "c":Landroid/database/Cursor;
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 751
    .local v1, "cr":Landroid/content/ContentResolver;
    const-string v4, ""

    .line 752
    .local v4, "WHERE_CLAUSE":Ljava/lang/String;
    and-int/lit8 v2, p1, 0xe

    const/16 v3, 0xe

    if-eq v2, v3, :cond_0

    .line 753
    and-int/lit8 v2, p1, 0x2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_6

    .line 754
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "pending=1 AND errorType != "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " AND "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 762
    :cond_0
    :goto_0
    const-string v7, "creationTime LIMIT "

    .line 763
    .local v7, "SORT_BY":Ljava/lang/String;
    and-int/lit8 v2, p1, 0x4

    const/4 v3, 0x4

    if-ne v2, v3, :cond_1

    and-int/lit8 v2, p1, 0xe

    const/16 v3, 0xe

    if-eq v2, v3, :cond_1

    .line 765
    const-string v7, "completeTime LIMIT "

    .line 768
    :cond_1
    and-int/lit8 v2, p1, 0x10

    const/16 v3, 0x10

    if-eq v2, v3, :cond_8

    .line 769
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "contentState = 0 AND "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 774
    :goto_1
    const-string v8, "clientAuthority =? AND parentUuid"

    .line 775
    .local v8, "WHERE":Ljava/lang/String;
    const/4 v5, 0x0

    check-cast v5, [Ljava/lang/String;

    .line 776
    .local v5, "args":[Ljava/lang/String;
    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 777
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " IS NULL"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 778
    const/4 v2, 0x1

    new-array v5, v2, [Ljava/lang/String;

    .end local v5    # "args":[Ljava/lang/String;
    const/4 v2, 0x0

    aput-object p3, v5, v2

    .line 785
    .restart local v5    # "args":[Ljava/lang/String;
    :goto_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 787
    const/16 v11, 0xfa

    .line 788
    .local v11, "limit":I
    const/4 v13, 0x0

    .line 789
    .local v13, "offset":I
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xfa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 792
    .local v12, "limit_clause":Ljava/lang/String;
    :try_start_0
    invoke-static/range {p3 .. p3}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 793
    :goto_3
    if-eqz v9, :cond_2

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-gtz v2, :cond_a

    .line 806
    :cond_2
    and-int/lit8 v2, p1, 0x1

    const/4 v3, 0x1

    if-ne v2, v3, :cond_4

    .line 807
    const/4 v15, 0x0

    .line 809
    .local v15, "uuids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    and-int/lit8 v2, p1, 0x2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_d

    .line 810
    new-instance v14, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    move-object/from16 v0, p3

    invoke-direct {v14, v1, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 811
    .local v14, "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    move-object/from16 v0, p2

    invoke-virtual {v14, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v15

    .line 812
    move-object/from16 v0, p2

    invoke-virtual {v14, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v15, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 818
    .end local v14    # "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    :cond_3
    :goto_4
    move-object/from16 v0, p3

    invoke-static {v10, v15, v1, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->orderedList(Ljava/util/List;Ljava/util/List;Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v10

    .line 823
    .end local v15    # "uuids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_4
    if-eqz v9, :cond_5

    invoke-interface {v9}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_5

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 825
    :cond_5
    :goto_5
    return-object v10

    .line 755
    .end local v5    # "args":[Ljava/lang/String;
    .end local v7    # "SORT_BY":Ljava/lang/String;
    .end local v8    # "WHERE":Ljava/lang/String;
    .end local v11    # "limit":I
    .end local v12    # "limit_clause":Ljava/lang/String;
    .end local v13    # "offset":I
    :cond_6
    and-int/lit8 v2, p1, 0x4

    const/4 v3, 0x4

    if-ne v2, v3, :cond_7

    .line 756
    const-string v4, "pending=0 AND "

    goto/16 :goto_0

    .line 758
    :cond_7
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "pending=1 AND errorType = "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " AND "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_0

    .line 771
    .restart local v7    # "SORT_BY":Ljava/lang/String;
    :cond_8
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "contentState = 1 AND "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_1

    .line 780
    .restart local v5    # "args":[Ljava/lang/String;
    .restart local v8    # "WHERE":Ljava/lang/String;
    :cond_9
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " =?"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 781
    const/4 v2, 0x2

    new-array v5, v2, [Ljava/lang/String;

    .end local v5    # "args":[Ljava/lang/String;
    const/4 v2, 0x0

    aput-object p3, v5, v2

    const/4 v2, 0x1

    aput-object p2, v5, v2

    .restart local v5    # "args":[Ljava/lang/String;
    goto/16 :goto_2

    .line 794
    .restart local v11    # "limit":I
    .restart local v12    # "limit_clause":Ljava/lang/String;
    .restart local v13    # "offset":I
    :cond_a
    :try_start_1
    sget-object v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v6, "retrieving paged results: ["

    invoke-direct {v3, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v6

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, ", "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, "]"

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 795
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-eqz v2, :cond_c

    .line 797
    :cond_b
    invoke-static {v9}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->hydrate(Landroid/database/Cursor;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v2

    invoke-interface {v10, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 798
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    .line 796
    if-nez v2, :cond_b

    .line 800
    :cond_c
    add-int/lit16 v13, v13, 0xfa

    .line 801
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xfa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 802
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 803
    const/4 v9, 0x0

    .line 804
    invoke-static/range {p3 .. p3}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const/4 v3, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v6, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    goto/16 :goto_3

    .line 814
    .restart local v15    # "uuids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_d
    and-int/lit8 v2, p1, 0x8

    const/16 v3, 0x8

    if-ne v2, v3, :cond_3

    .line 815
    new-instance v14, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    move-object/from16 v0, p3

    invoke-direct {v14, v1, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 816
    .restart local v14    # "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    move-object/from16 v0, p2

    invoke-virtual {v14, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->unqueuedQueue(Ljava/lang/String;)Ljava/util/List;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v15

    goto/16 :goto_4

    .line 820
    .end local v14    # "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    .end local v15    # "uuids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_0
    move-exception v2

    .line 823
    if-eqz v9, :cond_5

    invoke-interface {v9}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_5

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    goto/16 :goto_5

    .line 822
    :catchall_0
    move-exception v2

    .line 823
    if-eqz v9, :cond_e

    invoke-interface {v9}, Landroid/database/Cursor;->isClosed()Z

    move-result v3

    if-nez v3, :cond_e

    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 824
    :cond_e
    throw v2
.end method

.method public static getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .locals 10
    .param p0, "cr"    # Landroid/content/ContentResolver;
    .param p1, "uuid"    # Ljava/lang/String;
    .param p2, "Auth"    # Ljava/lang/String;

    .prologue
    .line 709
    const/4 v9, 0x0

    .line 710
    .local v9, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    const/4 v7, 0x0

    .line 712
    .local v7, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v4, "uuid =?"

    .line 713
    .local v4, "WHERE_CLAUSE":Ljava/lang/String;
    invoke-static {p2}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->FULL_PROJECTION:[Ljava/lang/String;

    const/4 v1, 0x1

    new-array v5, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v5, v1

    const/4 v6, 0x0

    move-object v1, p0

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 715
    if-eqz v7, :cond_0

    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 716
    invoke-static {v7}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->hydrate(Landroid/database/Cursor;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v9

    .line 718
    :cond_0
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 719
    const/4 v7, 0x0

    .line 721
    if-eqz v9, :cond_1

    invoke-interface {v9}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1

    .line 722
    move-object v0, v9

    check-cast v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    move-object v1, v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 730
    :cond_1
    if-eqz v7, :cond_2

    invoke-interface {v7}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_2

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 733
    .end local v4    # "WHERE_CLAUSE":Ljava/lang/String;
    :cond_2
    :goto_0
    return-object v9

    .line 726
    :catch_0
    move-exception v8

    .line 727
    .local v8, "e":Ljava/lang/Exception;
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Caught exception while fetching uuid : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 730
    if-eqz v7, :cond_2

    invoke-interface {v7}, Landroid/database/Cursor;->isClosed()Z

    move-result v1

    if-nez v1, :cond_2

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 729
    .end local v8    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    .line 730
    if-eqz v7, :cond_3

    invoke-interface {v7}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_3

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 731
    :cond_3
    throw v1
.end method

.method private static hydrate(Landroid/database/Cursor;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .locals 5
    .param p0, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v3, 0x2

    .line 603
    const/4 v1, 0x0

    .line 604
    .local v1, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    const-string v2, "contentType"

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 605
    .local v0, "type":I
    if-eq v0, v3, :cond_0

    const/4 v2, 0x3

    if-ne v0, v2, :cond_2

    .line 608
    :cond_0
    if-ne v0, v3, :cond_1

    .line 609
    new-instance v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;

    .end local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-direct {v1, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFolderCollection;-><init>(Landroid/database/Cursor;)V

    .line 677
    .restart local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_0
    return-object v1

    .line 616
    :cond_1
    new-instance v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContainerCollection;

    .end local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-direct {v1, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContainerCollection;-><init>(Landroid/database/Cursor;)V

    .restart local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_0

    .line 630
    :cond_2
    const/4 v2, 0x1

    if-ne v0, v2, :cond_3

    .line 653
    new-instance v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;

    .end local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-direct {v1, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoFile;-><init>(Landroid/database/Cursor;)V

    .restart local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_0

    .line 655
    :cond_3
    const/4 v2, 0x4

    if-ne v0, v2, :cond_4

    .line 673
    new-instance v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    .end local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-direct {v1, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;-><init>(Landroid/database/Cursor;)V

    .restart local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    goto :goto_0

    .line 675
    :cond_4
    sget-object v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Unknown identifier type "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private initService()V
    .locals 1

    .prologue
    .line 362
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;

    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$4;-><init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iServiceConnection:Landroid/content/ServiceConnection;

    .line 409
    return-void
.end method

.method private markForDelete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)Z
    .locals 10
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    const/4 v6, 0x1

    .line 1420
    const/4 v3, 0x0

    .line 1421
    .local v3, "updated":I
    if-eqz p1, :cond_0

    .line 1422
    sget-object v7, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Marking "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " for deletion"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    move-object v4, p1

    .line 1423
    check-cast v4, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 1424
    .local v4, "va":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    sget-object v7, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 1425
    .local v0, "cr":Landroid/content/ContentResolver;
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 1426
    .local v5, "values":Landroid/content/ContentValues;
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 1427
    .local v1, "date":Ljava/util/Date;
    const-string v7, "modifyTime"

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1428
    const-string v7, "contentState"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v5, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1430
    :try_start_0
    iget-object v7, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v7}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->id()I

    move-result v8

    int-to-long v8, v8

    invoke-static {v7, v8, v9}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v7

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual {v0, v7, v5, v8, v9}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    .line 1432
    sget-object v7, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Marking "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " for deletion updated "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1439
    .end local v0    # "cr":Landroid/content/ContentResolver;
    .end local v1    # "date":Ljava/util/Date;
    .end local v4    # "va":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v5    # "values":Landroid/content/ContentValues;
    :cond_0
    :goto_0
    if-lez v3, :cond_1

    :goto_1
    return v6

    .line 1433
    .restart local v0    # "cr":Landroid/content/ContentResolver;
    .restart local v1    # "date":Ljava/util/Date;
    .restart local v4    # "va":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .restart local v5    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v2

    .line 1435
    .local v2, "e":Ljava/lang/Exception;
    sget-object v7, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Marking "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " for deletion FAILED"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1436
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 1439
    .end local v0    # "cr":Landroid/content/ContentResolver;
    .end local v1    # "date":Ljava/util/Date;
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v4    # "va":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v5    # "values":Landroid/content/ContentValues;
    :cond_1
    const/4 v6, 0x0

    goto :goto_1
.end method

.method private static orderedList(Ljava/util/List;Ljava/util/List;Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/util/List;
    .locals 12
    .param p2, "cr"    # Landroid/content/ContentResolver;
    .param p3, "aAuthority"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Landroid/content/ContentResolver;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation

    .prologue
    .local p0, "l":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;>;"
    .local p1, "orderedUuids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v11, 0x0

    .line 829
    if-eqz p1, :cond_0

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v8

    if-lez v8, :cond_0

    .line 831
    new-instance v5, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-direct {v5, p2, p3}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 832
    .local v5, "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    const/4 v2, 0x0

    .local v2, "idx":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v8

    if-lt v2, v8, :cond_1

    .line 867
    .end local v2    # "idx":I
    .end local v5    # "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    :cond_0
    return-object p0

    .line 833
    .restart local v2    # "idx":I
    .restart local v5    # "registry":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    :cond_1
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v8

    if-ge v2, v8, :cond_0

    .line 835
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 836
    .local v6, "uuid":Ljava/lang/String;
    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 837
    .local v7, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v8

    invoke-interface {p1, v8}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 838
    const-string v8, "TestRunner"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " NOT A REGISTERED ITEM"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 839
    sget-object v8, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " NOT A REGISTERED ITEM"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 841
    :cond_2
    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 832
    :cond_3
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 843
    :cond_4
    const/4 v3, 0x0

    .line 844
    .local v3, "itemFound":Z
    move v1, v2

    .local v1, "i":I
    :goto_2
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v8

    if-lt v1, v8, :cond_6

    .line 853
    :goto_3
    if-nez v3, :cond_3

    .line 854
    sget-object v8, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " IN QUEUE NOT FOUND"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 856
    invoke-virtual {v5, v11}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    .line 857
    .local v4, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v5, v11}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 860
    .local v0, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v4, v6}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 861
    invoke-virtual {v5, v11, v4}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 862
    :cond_5
    invoke-interface {v0, v6}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 863
    invoke-virtual {v5, v11, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V

    goto :goto_1

    .line 845
    .end local v0    # "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v4    # "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_6
    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    .end local v7    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    check-cast v7, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 846
    .restart local v7    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 847
    const/4 v3, 0x1

    .line 848
    invoke-interface {p0, v7}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 849
    invoke-interface {p0, v2, v7}, Ljava/util/List;->add(ILjava/lang/Object;)V

    goto :goto_3

    .line 844
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_2
.end method

.method private overrideDoubleSetting(Ljava/lang/String;D)V
    .locals 2
    .param p1, "settingKey"    # Ljava/lang/String;
    .param p2, "aValue"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 2351
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 2352
    .local v0, "extras":Landroid/os/Bundle;
    invoke-virtual {v0, p1, p2, p3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 2353
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideSetting(Landroid/os/Bundle;)V

    .line 2354
    return-void
.end method

.method private overrideSetting(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "aExtras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 2366
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->performSettingsOverride(Landroid/os/Bundle;)I

    move-result v0

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalSettingChanged(I)V

    .line 2367
    return-void
.end method

.method private registerCallback(I)V
    .locals 6
    .param p1, "callback"    # I

    .prologue
    const/4 v2, 0x4

    const/4 v5, 0x2

    const/4 v4, 0x1

    .line 447
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    if-eqz v1, :cond_2

    .line 449
    and-int/lit8 v1, p1, 0x4

    if-ne v1, v2, :cond_0

    :try_start_0
    iget-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v1, v1, 0x4

    if-eq v1, v2, :cond_0

    .line 450
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->registerQueueCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;Ljava/lang/String;)V

    .line 451
    iget-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    or-int/lit8 v1, v1, 0x4

    int-to-short v1, v1

    iput-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    .line 454
    :cond_0
    and-int/lit8 v1, p1, 0x1

    if-ne v1, v4, :cond_1

    iget-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v1, v1, 0x1

    if-eq v1, v4, :cond_1

    .line 455
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->registerEngineCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;Ljava/lang/String;)V

    .line 456
    iget-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    or-int/lit8 v1, v1, 0x1

    int-to-short v1, v1

    iput-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    .line 459
    :cond_1
    and-int/lit8 v1, p1, 0x2

    if-ne v1, v5, :cond_2

    iget-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v1, v1, 0x2

    if-eq v1, v5, :cond_2

    .line 460
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, v2, v3}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->registerDownloadCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;Ljava/lang/String;)V

    .line 461
    iget-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    or-int/lit8 v1, v1, 0x2

    int-to-short v1, v1

    iput-short v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 468
    :cond_2
    :goto_0
    return-void

    .line 464
    :catch_0
    move-exception v0

    .line 465
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    goto :goto_0
.end method

.method private registerCallbackHandlers()V
    .locals 5

    .prologue
    const/4 v4, 0x4

    const/4 v3, 0x2

    const/4 v2, 0x1

    .line 496
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueLock:Ljava/lang/Object;

    monitor-enter v1

    .line 497
    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-short v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v0, v0, 0x4

    if-eq v0, v4, :cond_0

    .line 498
    const/4 v0, 0x4

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->registerCallback(I)V

    .line 496
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 501
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineLock:Ljava/lang/Object;

    monitor-enter v1

    .line 502
    :try_start_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineObservers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    iget-short v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v0, v0, 0x1

    if-eq v0, v2, :cond_1

    .line 503
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->registerCallback(I)V

    .line 501
    :cond_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 506
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadLock:Ljava/lang/Object;

    monitor-enter v1

    .line 507
    :try_start_2
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedObservers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    iget-short v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v0, v0, 0x2

    if-eq v0, v3, :cond_2

    .line 508
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->registerCallback(I)V

    .line 506
    :cond_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 511
    return-void

    .line 496
    :catchall_0
    move-exception v0

    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0

    .line 501
    :catchall_1
    move-exception v0

    :try_start_4
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v0

    .line 506
    :catchall_2
    move-exception v0

    :try_start_5
    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    throw v0
.end method

.method private remove(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 2
    .param p1, "vi"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 1443
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {p1, v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->remove(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Landroid/content/Context;Ljava/lang/String;)V

    .line 1444
    return-void
.end method

.method public static remove(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p0, "vi"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "authority"    # Ljava/lang/String;

    .prologue
    .line 1448
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;

    invoke-direct {v1, p1, p0, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$6;-><init>(Landroid/content/Context;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1469
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1471
    return-void
.end method

.method private removeAllButItem(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;I)V
    .locals 10
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "flags"    # I

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 1285
    sget-object v5, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    .line 1286
    .local v3, "cr":Landroid/content/ContentResolver;
    const-string v1, ""

    .line 1287
    .local v1, "WHERE_CLAUSE":Ljava/lang/String;
    const/16 v5, 0xe

    if-eq p2, v5, :cond_0

    and-int/lit8 v5, p2, 0x2

    if-ne v5, v9, :cond_0

    .line 1288
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "pending=1 AND errorType != "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v6, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v6}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " AND "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1290
    :cond_0
    if-eqz p1, :cond_1

    .line 1291
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "uuid !=? AND "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1293
    :cond_1
    const-string v0, "clientAuthority =?"

    .line 1294
    .local v0, "WHERE":Ljava/lang/String;
    const/4 v2, 0x0

    check-cast v2, [Ljava/lang/String;

    .line 1295
    .local v2, "args":[Ljava/lang/String;
    if-nez p1, :cond_2

    .line 1296
    new-array v2, v8, [Ljava/lang/String;

    .end local v2    # "args":[Ljava/lang/String;
    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    aput-object v5, v2, v7

    .line 1300
    .restart local v2    # "args":[Ljava/lang/String;
    :goto_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1303
    :try_start_0
    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v5}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v3, v5, v1, v2}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1307
    :goto_1
    return-void

    .line 1298
    :cond_2
    new-array v2, v9, [Ljava/lang/String;

    .end local v2    # "args":[Ljava/lang/String;
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v7

    iget-object v5, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    aput-object v5, v2, v8

    .restart local v2    # "args":[Ljava/lang/String;
    goto :goto_0

    .line 1304
    :catch_0
    move-exception v4

    .line 1305
    .local v4, "e":Ljava/lang/Exception;
    sget-object v5, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    const-string v6, "problem with remove all but "

    invoke-static {v5, v6, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method private removeAllFragmentsButChildOf(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 6
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 1257
    const/4 v0, 0x0

    .line 1258
    .local v0, "WHERE":Ljava/lang/String;
    const/4 v1, 0x0

    check-cast v1, [Ljava/lang/String;

    .line 1259
    .local v1, "args":[Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 1260
    const-string v0, "parentUuid =?"

    .line 1261
    const/4 v4, 0x1

    new-array v1, v4, [Ljava/lang/String;

    .end local v1    # "args":[Ljava/lang/String;
    const/4 v4, 0x0

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v4

    .line 1264
    .restart local v1    # "args":[Ljava/lang/String;
    :cond_0
    :try_start_0
    sget-object v4, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    .line 1265
    .local v2, "cr":Landroid/content/ContentResolver;
    iget-object v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v4}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v4, v0, v1}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1269
    .end local v2    # "cr":Landroid/content/ContentResolver;
    :goto_0
    return-void

    .line 1266
    :catch_0
    move-exception v3

    .line 1267
    .local v3, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    const-string v5, "problem with removeFragmentsForParents "

    invoke-static {v4, v5, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method private static save(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ILandroid/content/ContentResolver;Ljava/lang/String;)I
    .locals 13
    .param p0, "vi"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p1, "flags"    # I
    .param p2, "resolver"    # Landroid/content/ContentResolver;
    .param p3, "authority"    # Ljava/lang/String;

    .prologue
    .line 2093
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    .line 2094
    const-string v1, "uuid"

    aput-object v1, v2, v0

    const/4 v0, 0x1

    .line 2095
    const-string v1, "_id"

    aput-object v1, v2, v0

    .line 2097
    .local v2, "PROJECTION":[Ljava/lang/String;
    const/4 v11, -0x1

    .line 2098
    .local v11, "ret":I
    const/4 v6, 0x0

    .line 2101
    .local v6, "cursor":Landroid/database/Cursor;
    :try_start_0
    const-string v3, "uuid =?"

    .line 2102
    .local v3, "WHERE_CLAUSE":Ljava/lang/String;
    invoke-static/range {p3 .. p3}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    const/4 v5, 0x0

    move-object v0, p2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 2103
    invoke-static {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->unhydrate(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;I)Landroid/content/ContentValues;

    move-result-object v12

    .line 2104
    .local v12, "values":Landroid/content/ContentValues;
    new-instance v7, Ljava/util/Date;

    invoke-direct {v7}, Ljava/util/Date;-><init>()V

    .line 2105
    .local v7, "date":Ljava/util/Date;
    const-string v0, "modifyTime"

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2107
    if-eqz v6, :cond_2

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2109
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "updating db:  "

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2110
    invoke-static/range {p3 .. p3}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v4

    invoke-virtual {p2, v0, v12, v3, v1}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 2111
    const-string v0, "_id"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getInt(I)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v11

    .line 2132
    :cond_0
    :goto_0
    if-eqz v6, :cond_1

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 2134
    .end local v3    # "WHERE_CLAUSE":Ljava/lang/String;
    .end local v7    # "date":Ljava/util/Date;
    .end local v12    # "values":Landroid/content/ContentValues;
    :cond_1
    :goto_1
    return v11

    .line 2113
    .restart local v3    # "WHERE_CLAUSE":Ljava/lang/String;
    .restart local v7    # "date":Ljava/util/Date;
    .restart local v12    # "values":Landroid/content/ContentValues;
    :cond_2
    and-int/lit8 v0, p1, 0x4

    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    .line 2114
    :try_start_1
    const-string v0, "creationTime"

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v12, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2116
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v4, "inserting into db:  "

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2118
    invoke-static/range {p3 .. p3}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p2, v0, v12}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v10

    .line 2120
    .local v10, "insertion":Landroid/net/Uri;
    invoke-virtual {v10}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 2121
    .local v9, "fileDbId":Ljava/lang/String;
    invoke-static {v9}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v11

    goto :goto_0

    .line 2124
    .end local v3    # "WHERE_CLAUSE":Ljava/lang/String;
    .end local v7    # "date":Ljava/util/Date;
    .end local v9    # "fileDbId":Ljava/lang/String;
    .end local v10    # "insertion":Landroid/net/Uri;
    .end local v12    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v8

    .line 2125
    .local v8, "e":Ljava/lang/IllegalArgumentException;
    :try_start_2
    sget-object v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    const-string v1, "save(): delete issue "

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 2132
    if-eqz v6, :cond_1

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 2127
    .end local v8    # "e":Ljava/lang/IllegalArgumentException;
    :catchall_0
    move-exception v0

    .line 2132
    if-eqz v6, :cond_3

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 2133
    :cond_3
    throw v0
.end method

.method public static saveFileState(Landroid/content/ContentResolver;Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;I)V
    .locals 1
    .param p0, "resolver"    # Landroid/content/ContentResolver;
    .param p1, "file"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    .param p2, "flags"    # I

    .prologue
    .line 2334
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->clientProviderAuth()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, p2, p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->save(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ILandroid/content/ContentResolver;Ljava/lang/String;)I

    .line 2335
    return-void
.end method

.method private signalDownloadedChange()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 968
    new-instance v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$5;

    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$5;-><init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V

    .line 981
    .local v0, "r":Ljava/lang/Runnable;
    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 982
    return-void
.end method

.method private signalQueueChange(Z)V
    .locals 3
    .param p1, "notifyDownloader"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 986
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, v2, p1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->signalQueueChange(Ljava/lang/String;Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    .line 993
    return-void

    .line 987
    :catch_0
    move-exception v0

    .line 988
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    .line 989
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 990
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 991
    .local v0, "e":Ljava/lang/NullPointerException;
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v2, "Service is not connected"

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private signalSettingChanged(I)V
    .locals 3
    .param p1, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 2493
    sget-object v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    const-string v2, "doInterruptOnSettingChange"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2495
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, v2, p1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->signalDownloadSettingChange(Ljava/lang/String;I)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    .line 2502
    return-void

    .line 2496
    :catch_0
    move-exception v0

    .line 2497
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    .line 2498
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 2499
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 2500
    .local v0, "e":Ljava/lang/NullPointerException;
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v2, "Service is not connected"

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private toBytes(D)D
    .locals 5
    .param p1, "aMBValue"    # D

    .prologue
    const-wide/high16 v2, 0x4090000000000000L    # 1024.0

    .line 2414
    const-wide/16 v0, 0x0

    cmpg-double v0, p1, v0

    if-gez v0, :cond_0

    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 2415
    :goto_0
    return-wide v0

    :cond_0
    mul-double v0, p1, v2

    mul-double/2addr v0, v2

    goto :goto_0
.end method

.method private static unhydrate(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;I)Landroid/content/ContentValues;
    .locals 1
    .param p0, "vi"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p1, "flags"    # I

    .prologue
    .line 2186
    invoke-interface {p0}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 2198
    const/4 v0, 0x0

    .end local p0    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :goto_0
    return-object v0

    .line 2190
    .restart local p0    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :pswitch_0
    check-cast p0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;

    .end local p0    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-static {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->unhydrateCollection(Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;I)Landroid/content/ContentValues;

    move-result-object v0

    goto :goto_0

    .line 2192
    .restart local p0    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :pswitch_1
    check-cast p0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    .end local p0    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-static {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->unhydrateFile(Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;I)Landroid/content/ContentValues;

    move-result-object v0

    goto :goto_0

    .line 2194
    .restart local p0    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :pswitch_2
    check-cast p0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    .end local p0    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-static {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->unhydrateHLSFile(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;I)Landroid/content/ContentValues;

    move-result-object v0

    goto :goto_0

    .line 2186
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private static unhydrateCollection(Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;I)Landroid/content/ContentValues;
    .locals 4
    .param p0, "vfile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;
    .param p1, "flags"    # I

    .prologue
    .line 2226
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 2227
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "assetId"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->assetId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2228
    const-string v1, "assetUrl"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->assetURL()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2229
    and-int/lit8 v1, p1, 0x1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 2230
    const-string v1, "description"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->metadata()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2231
    :cond_0
    const-string v1, "uuid"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2232
    const-string v1, "parentUuid"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->parentUuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2233
    const-string v1, "errorType"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v2

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2234
    const-string v1, "addedToQueue"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->isAdded()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 2235
    const-string v1, "contentType"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->type()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2236
    const-string v1, "completeTime"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->completionTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2237
    const-string v1, "clientAuthority"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVCollection;->clientProviderAuth()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2239
    return-object v0
.end method

.method private static unhydrateFile(Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;I)Landroid/content/ContentValues;
    .locals 4
    .param p0, "vfile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    .param p1, "flags"    # I

    .prologue
    .line 2244
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 2245
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "assetId"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->assetId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2246
    const-string v1, "assetUrl"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->assetURL()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2247
    const-string v1, "currentSize"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->currentSize()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 2248
    and-int/lit8 v1, p1, 0x1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 2249
    const-string v1, "description"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->metadata()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2250
    :cond_0
    const-string v1, "errorType"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v2

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2251
    const-string v1, "expectedSize"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->expectedSize()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 2252
    const-string v1, "fileHash"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->fileMD5()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2253
    const-string v1, "filePath"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2254
    const-string v1, "mimeType"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->mimeType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2255
    const-string v1, "uuid"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2256
    const-string v1, "errorCount"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->errorCount()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2257
    const-string v1, "pending"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->isPending()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 2258
    const-string v1, "contentType"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->type()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2259
    const-string v1, "completeTime"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->completionTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2260
    const-string v1, "parentUuid"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->parentUuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2261
    and-int/lit8 v1, p1, 0x2

    const/4 v2, 0x2

    if-ne v1, v2, :cond_1

    .line 2262
    const-string v1, "hashState"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->md5StateAsByteArray()[B

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 2264
    :cond_1
    const-string v1, "clientAuthority"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2265
    return-object v0
.end method

.method private static unhydrateHLSFile(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;I)Landroid/content/ContentValues;
    .locals 4
    .param p0, "vfile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
    .param p1, "flags"    # I

    .prologue
    .line 2204
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 2205
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "assetId"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->assetId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2206
    const-string v1, "assetUrl"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->assetURL()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2207
    const-string v1, "currentSize"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->currentSize()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 2208
    and-int/lit8 v1, p1, 0x1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 2209
    const-string v1, "description"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->metadata()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2210
    :cond_0
    const-string v1, "errorType"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v2

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2211
    const-string v1, "expectedSize"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->expectedSize()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 2212
    const-string v1, "filePath"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2213
    const-string v1, "uuid"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2214
    const-string v1, "pending"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->isPending()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 2215
    const-string v1, "contentType"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->type()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2216
    const-string v1, "completeTime"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->completionTime()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 2217
    const-string v1, "parentUuid"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->parentUuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2218
    const-string v1, "clientAuthority"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 2219
    const-string v1, "hlsFragmentCompletedCount"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->totalFragmentsComplete()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2220
    const-string v1, "hlsFragmentCount"

    invoke-interface {p0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->totalFragments()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 2221
    return-object v0
.end method


# virtual methods
.method public addDownloadedObserver(Lcom/penthera/virtuososdk/client/IDownloadedObserver;)V
    .locals 3
    .param p1, "obs"    # Lcom/penthera/virtuososdk/client/IDownloadedObserver;

    .prologue
    const/4 v2, 0x2

    .line 557
    if-nez p1, :cond_0

    .line 566
    :goto_0
    return-void

    .line 558
    :cond_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadLock:Ljava/lang/Object;

    monitor-enter v1

    .line 559
    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedObservers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 560
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedObservers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 562
    :cond_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedObservers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    iget-short v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v0, v0, 0x2

    if-eq v0, v2, :cond_2

    .line 563
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->registerCallback(I)V

    .line 558
    :cond_2
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public addEngineObserver(Lcom/penthera/virtuososdk/client/IEngineObserver;)V
    .locals 3
    .param p1, "obs"    # Lcom/penthera/virtuososdk/client/IEngineObserver;

    .prologue
    const/4 v2, 0x1

    .line 545
    if-nez p1, :cond_0

    .line 554
    :goto_0
    return-void

    .line 546
    :cond_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineLock:Ljava/lang/Object;

    monitor-enter v1

    .line 547
    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineObservers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 548
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineObservers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 550
    :cond_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iEngineObservers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    iget-short v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v0, v0, 0x1

    if-eq v0, v2, :cond_2

    .line 551
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->registerCallback(I)V

    .line 546
    :cond_2
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public addQueueObserver(Lcom/penthera/virtuososdk/client/IQueueObserver;)V
    .locals 3
    .param p1, "obs"    # Lcom/penthera/virtuososdk/client/IQueueObserver;

    .prologue
    const/4 v2, 0x4

    .line 534
    if-nez p1, :cond_0

    .line 543
    :goto_0
    return-void

    .line 535
    :cond_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueLock:Ljava/lang/Object;

    monitor-enter v1

    .line 536
    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 537
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 539
    :cond_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iQueueObservers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    iget-short v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegisteredCallbacks:S

    and-int/lit8 v0, v0, 0x4

    if-eq v0, v2, :cond_2

    .line 540
    const/4 v0, 0x4

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->registerCallback(I)V

    .line 535
    :cond_2
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method addToCollection(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 7
    .param p1, "collection"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "item"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 949
    if-nez p2, :cond_1

    .line 964
    :cond_0
    :goto_0
    return-void

    .line 950
    :cond_1
    const/4 v0, 0x0

    .line 951
    .local v0, "collectionUuid":Ljava/lang/String;
    if-eqz p1, :cond_2

    .line 952
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v0

    .line 953
    :cond_2
    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v3, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 954
    .local v2, "pq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v3, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 955
    .local v1, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 959
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 960
    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v3, v0, v2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;)V

    move-object v3, p2

    .line 961
    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    sget-object v6, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-interface {v3, v6}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 962
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    iget-object v6, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {p2, v5, v3, v6}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->save(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ILandroid/content/ContentResolver;Ljava/lang/String;)I

    .line 963
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    if-ne v3, v4, :cond_3

    move v3, v4

    :goto_1
    invoke-direct {p0, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalQueueChange(Z)V

    goto :goto_0

    :cond_3
    move v3, v5

    goto :goto_1
.end method

.method public addToQueue(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 1
    .param p1, "item"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 915
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->addToCollection(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 916
    return-void
.end method

.method public configure(Landroid/os/Bundle;II)V
    .locals 3
    .param p1, "headers"    # Landroid/os/Bundle;
    .param p2, "connectionTimeout"    # I
    .param p3, "socketTimeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 2006
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, p1, p2, p3, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->configure(Landroid/os/Bundle;IILjava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    .line 2014
    return-void

    .line 2007
    :catch_0
    move-exception v0

    .line 2009
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    .line 2010
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 2011
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 2012
    .local v0, "e":Ljava/lang/NullPointerException;
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v2, "Service is not connected"

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public delete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 12
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    .line 1370
    if-nez p1, :cond_1

    .line 1417
    :cond_0
    :goto_0
    return-void

    .line 1371
    :cond_1
    const/4 v3, 0x0

    .line 1372
    .local v3, "parent":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 1373
    sget-object v8, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {p0, v8, v11}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v3

    .line 1375
    :cond_2
    const/4 v6, 0x0

    .line 1376
    .local v6, "queue_name":Ljava/lang/String;
    if-eqz v3, :cond_3

    .line 1377
    invoke-interface {v3}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v6

    .line 1379
    :cond_3
    iget-object v8, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v8, v6}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    .line 1380
    .local v5, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v8, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v8, v6}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 1381
    .local v1, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v8

    if-lez v8, :cond_5

    invoke-interface {v5, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v8, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    move v2, v9

    .line 1382
    .local v2, "isCurrentDownload":Z
    :goto_1
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v8}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_6

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v1, v8}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_6

    move v7, v10

    .line 1385
    .local v7, "wasInQueue":Z
    :goto_2
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v5, v8}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1386
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v1, v8}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1387
    iget-object v8, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v8, v6, v1}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 1388
    iget-object v8, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v8, v6, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 1389
    const/4 v4, 0x0

    .line 1390
    .local v4, "path":Ljava/lang/String;
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v8

    const/4 v11, 0x4

    if-ne v8, v11, :cond_7

    move-object v8, p1

    .line 1391
    check-cast v8, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-interface {v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v4

    .line 1395
    :cond_4
    :goto_3
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->markForDelete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)Z

    .line 1396
    if-eqz v2, :cond_8

    .line 1399
    :try_start_0
    iget-object v8, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v8, v9, p1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->signalDelete(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    goto/16 :goto_0

    .line 1400
    :catch_0
    move-exception v0

    .line 1402
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    .line 1403
    new-instance v8, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8

    .end local v0    # "e":Landroid/os/RemoteException;
    .end local v2    # "isCurrentDownload":Z
    .end local v4    # "path":Ljava/lang/String;
    .end local v7    # "wasInQueue":Z
    :cond_5
    move v2, v10

    .line 1381
    goto :goto_1

    .restart local v2    # "isCurrentDownload":Z
    :cond_6
    move v7, v9

    .line 1382
    goto :goto_2

    .line 1392
    .restart local v4    # "path":Ljava/lang/String;
    .restart local v7    # "wasInQueue":Z
    :cond_7
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v8

    if-ne v8, v9, :cond_4

    move-object v8, p1

    .line 1393
    check-cast v8, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    invoke-interface {v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v4

    goto :goto_3

    .line 1404
    :catch_1
    move-exception v0

    .line 1405
    .local v0, "e":Ljava/lang/NullPointerException;
    new-instance v8, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v9, "Service is not connected"

    invoke-direct {v8, v9, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8

    .line 1408
    .end local v0    # "e":Ljava/lang/NullPointerException;
    :cond_8
    iget-object v8, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

    invoke-virtual {v8, v4}, Lcom/penthera/virtuososdk/manager/FileManager;->remove(Ljava/lang/String;)V

    .line 1410
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->remove(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 1411
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v8

    sget-object v9, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v8, v9, :cond_9

    .line 1412
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalDownloadedChange()V

    .line 1413
    :cond_9
    if-eqz v7, :cond_0

    .line 1414
    invoke-direct {p0, v10}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalQueueChange(Z)V

    goto/16 :goto_0
.end method

.method public deleteAllFiles()V
    .locals 14
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    const/16 v13, 0xe

    const/4 v12, 0x0

    const/4 v11, 0x0

    .line 1315
    const/4 v1, 0x0

    .line 1317
    .local v1, "current_uuid":Ljava/lang/String;
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v9, v11}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v7

    .line 1318
    .local v7, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v9, v11}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 1320
    .local v3, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v7, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1321
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    if-lez v9, :cond_0

    invoke-interface {v7, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "current_uuid":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 1322
    .restart local v1    # "current_uuid":Ljava/lang/String;
    :cond_0
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v10

    add-int v8, v9, v10

    .line 1323
    .local v8, "qSize":I
    invoke-interface {v7}, Ljava/util/List;->clear()V

    .line 1324
    invoke-interface {v3}, Ljava/util/List;->clear()V

    .line 1325
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v9, v11, v3}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 1326
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v9, v11, v3}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 1329
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 1330
    .local v6, "paths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v13, v11, v9}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFiles(ILjava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    .line 1331
    .local v5, "files":Ljava/util/List;, "Ljava/util/List<Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;>;"
    const/4 v0, 0x0

    .line 1332
    .local v0, "current_file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_1
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_5

    .line 1344
    invoke-direct {p0, v0, v13}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->removeAllButItem(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;I)V

    .line 1345
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->removeAllFragmentsButChildOf(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 1346
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v9

    if-lez v9, :cond_2

    .line 1347
    iget-object v10, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

    new-array v9, v12, [Ljava/lang/String;

    invoke-interface {v6, v9}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Ljava/lang/String;

    invoke-virtual {v10, v9}, Lcom/penthera/virtuososdk/manager/FileManager;->remove([Ljava/lang/String;)V

    .line 1349
    :cond_2
    if-eqz v0, :cond_8

    .line 1352
    :try_start_0
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v10, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v9, v10, v0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->signalDelete(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1363
    :cond_3
    :goto_1
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v9

    sub-int/2addr v9, v8

    if-lez v9, :cond_4

    .line 1365
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalDownloadedChange()V

    .line 1367
    :cond_4
    return-void

    .line 1332
    :cond_5
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 1333
    .local v4, "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_7

    .line 1334
    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v10

    const/4 v11, 0x4

    if-ne v10, v11, :cond_6

    .line 1335
    check-cast v4, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    .end local v4    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {v4}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v6, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1336
    .restart local v4    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_6
    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v10

    const/4 v11, 0x1

    if-ne v10, v11, :cond_1

    .line 1337
    check-cast v4, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    .end local v4    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {v4}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v6, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1341
    .restart local v4    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_7
    move-object v0, v4

    goto :goto_0

    .line 1353
    .end local v4    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :catch_0
    move-exception v2

    .line 1355
    .local v2, "e":Landroid/os/RemoteException;
    invoke-virtual {v2}, Landroid/os/RemoteException;->printStackTrace()V

    .line 1356
    new-instance v9, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v2}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10, v2}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v9

    .line 1357
    .end local v2    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v2

    .line 1358
    .local v2, "e":Ljava/lang/NullPointerException;
    new-instance v9, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v10, "Service is not connected"

    invoke-direct {v9, v10, v2}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v9

    .line 1361
    .end local v2    # "e":Ljava/lang/NullPointerException;
    :cond_8
    if-lez v8, :cond_3

    invoke-direct {p0, v12}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalQueueChange(Z)V

    goto :goto_1
.end method

.method public downloadedRootList()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation

    .prologue
    .line 871
    const/4 v0, 0x4

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFiles(ILjava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public expire(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 14
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 1146
    if-nez p1, :cond_1

    .line 1198
    :cond_0
    :goto_0
    return-void

    .line 1147
    :cond_1
    const/4 v4, 0x0

    .line 1148
    .local v4, "parent":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 1149
    sget-object v9, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {p0, v9, v12}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v4

    .line 1151
    :cond_2
    const/4 v7, 0x0

    .line 1152
    .local v7, "queue_name":Ljava/lang/String;
    if-eqz v4, :cond_3

    .line 1153
    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v7

    .line 1155
    :cond_3
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v9, v7}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 1156
    .local v6, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v9, v7}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 1157
    .local v1, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v9

    if-lez v9, :cond_5

    invoke-interface {v6, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v9, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5

    move v3, v10

    .line 1158
    .local v3, "isCurrentDownload":Z
    :goto_1
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v6, v9}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_6

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v1, v9}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_6

    move v8, v11

    .line 1161
    .local v8, "wasInQueue":Z
    :goto_2
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v6, v9}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1162
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v1, v9}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1163
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v9, v7, v1}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 1164
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v9, v7, v6}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 1166
    const/4 v5, 0x0

    .line 1167
    .local v5, "path":Ljava/lang/String;
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v9

    const/4 v12, 0x4

    if-ne v9, v12, :cond_7

    move-object v9, p1

    .line 1168
    check-cast v9, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-interface {v9}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v5

    move-object v9, p1

    .line 1169
    check-cast v9, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-interface {v9, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setPending(Z)V

    :cond_4
    :goto_3
    move-object v2, p1

    .line 1175
    check-cast v2, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    .line 1176
    .local v2, "evi":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    sget-object v9, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-interface {v2, v9}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1177
    new-instance v9, Ljava/util/Date;

    invoke-direct {v9}, Ljava/util/Date;-><init>()V

    invoke-virtual {v9}, Ljava/util/Date;->getTime()J

    move-result-wide v12

    invoke-interface {v2, v12, v13}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setCompletionTime(J)V

    .line 1178
    sget-object v9, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v9

    iget-object v10, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v2, v11, v9, v10}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->save(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ILandroid/content/ContentResolver;Ljava/lang/String;)I

    .line 1179
    if-eqz v3, :cond_8

    .line 1182
    :try_start_0
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v10, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v9, v10, p1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->signalExpire(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    goto/16 :goto_0

    .line 1183
    :catch_0
    move-exception v0

    .line 1184
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    .line 1185
    new-instance v9, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v9

    .end local v0    # "e":Landroid/os/RemoteException;
    .end local v2    # "evi":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    .end local v3    # "isCurrentDownload":Z
    .end local v5    # "path":Ljava/lang/String;
    .end local v8    # "wasInQueue":Z
    :cond_5
    move v3, v11

    .line 1157
    goto :goto_1

    .restart local v3    # "isCurrentDownload":Z
    :cond_6
    move v8, v10

    .line 1158
    goto :goto_2

    .line 1170
    .restart local v5    # "path":Ljava/lang/String;
    .restart local v8    # "wasInQueue":Z
    :cond_7
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v9

    if-ne v9, v10, :cond_4

    move-object v9, p1

    .line 1171
    check-cast v9, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    invoke-interface {v9}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v5

    move-object v9, p1

    .line 1172
    check-cast v9, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    invoke-interface {v9, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setPending(Z)V

    move-object v9, p1

    .line 1173
    check-cast v9, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    const-wide/16 v12, 0x0

    invoke-interface {v9, v12, v13}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setCurrentSize(D)V

    goto :goto_3

    .line 1186
    .restart local v2    # "evi":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    :catch_1
    move-exception v0

    .line 1187
    .local v0, "e":Ljava/lang/NullPointerException;
    new-instance v9, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v10, "Service is not connected"

    invoke-direct {v9, v10, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v9

    .line 1190
    .end local v0    # "e":Ljava/lang/NullPointerException;
    :cond_8
    iget-object v9, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

    invoke-virtual {v9, v5}, Lcom/penthera/virtuososdk/manager/FileManager;->remove(Ljava/lang/String;)V

    .line 1193
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalDownloadedChange()V

    .line 1194
    if-eqz v8, :cond_0

    .line 1195
    invoke-direct {p0, v11}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalQueueChange(Z)V

    goto/16 :goto_0
.end method

.method getItem(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uuid"    # Ljava/lang/String;

    .prologue
    .line 737
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 738
    .local v0, "cr":Landroid/content/ContentResolver;
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v0, p2, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v1

    return-object v1
.end method

.method public move(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;I)V
    .locals 16
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "aNewPosition"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 1021
    if-nez p1, :cond_1

    .line 1142
    :cond_0
    :goto_0
    return-void

    .line 1022
    :cond_1
    const/4 v8, 0x0

    .line 1023
    .local v8, "parent":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v13

    if-nez v13, :cond_2

    .line 1024
    sget-object v13, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    invoke-virtual {v0, v13, v14}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v8

    .line 1026
    :cond_2
    const/4 v12, 0x0

    .line 1027
    .local v12, "queue_name":Ljava/lang/String;
    if-eqz v8, :cond_3

    .line 1028
    invoke-interface {v8}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v12

    .line 1030
    :cond_3
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v13, v12}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v10

    .line 1031
    .local v10, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v13, v12}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    .line 1033
    .local v5, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v10, v13}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    .line 1034
    .local v3, "curr_pq":Z
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v5, v13}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    .line 1035
    .local v2, "curr_eq":Z
    if-nez v3, :cond_4

    if-eqz v2, :cond_0

    .line 1041
    :cond_4
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7, v10}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 1042
    .local v7, "fl":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v7, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1043
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v7, v13}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v6

    .line 1045
    .local v6, "f_index":I
    const/4 v9, 0x0

    .line 1046
    .local v9, "position_0_changed":Z
    const/4 v11, 0x0

    .line 1048
    .local v11, "q_changed":Z
    const/4 v1, 0x0

    .line 1050
    .local v1, "curr_download":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v3, :cond_d

    .line 1052
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v13

    if-lez v13, :cond_8

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v13

    move/from16 v0, p2

    if-lt v0, v13, :cond_8

    .line 1055
    if-nez v6, :cond_6

    if-lez p2, :cond_6

    const/4 v9, 0x1

    .line 1057
    :goto_1
    if-eqz v9, :cond_5

    .line 1058
    sget-object v14, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    const/4 v13, 0x0

    invoke-interface {v7, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v13}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v1

    .line 1060
    :cond_5
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v7, v13}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1061
    const/4 v13, 0x0

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->max(II)I

    move-result p2

    .line 1062
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v13

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->min(II)I

    move-result p2

    .line 1063
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    move/from16 v0, p2

    invoke-interface {v7, v0, v13}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 1064
    const/4 v13, 0x0

    add-int/lit8 v14, p2, 0x1

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v15

    invoke-static {v14, v15}, Ljava/lang/Math;->min(II)I

    move-result v14

    invoke-interface {v7, v13, v14}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v10

    .line 1065
    add-int/lit8 v13, p2, 0x1

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v14

    invoke-static {v13, v14}, Ljava/lang/Math;->min(II)I

    move-result v13

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v14

    invoke-interface {v7, v13, v14}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v5

    .line 1067
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v7, v13}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v13

    if-eq v13, v6, :cond_7

    const/4 v11, 0x1

    .line 1132
    :goto_2
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v13, v12, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 1133
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v13, v12, v10}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 1140
    if-eqz v11, :cond_0

    .line 1141
    move-object/from16 v0, p0

    invoke-direct {v0, v9}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalQueueChange(Z)V

    goto/16 :goto_0

    .line 1055
    :cond_6
    const/4 v9, 0x0

    goto :goto_1

    .line 1067
    :cond_7
    const/4 v11, 0x0

    goto :goto_2

    .line 1071
    :cond_8
    if-nez v6, :cond_b

    if-lez p2, :cond_b

    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v13

    const/4 v14, 0x1

    if-le v13, v14, :cond_b

    const/4 v9, 0x1

    .line 1072
    :goto_3
    if-nez v9, :cond_9

    if-lez v6, :cond_9

    if-gtz p2, :cond_9

    .line 1073
    const/4 v9, 0x1

    .line 1075
    :cond_9
    if-eqz v9, :cond_a

    .line 1076
    sget-object v14, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    const/4 v13, 0x0

    invoke-interface {v7, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v13}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v1

    .line 1078
    :cond_a
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v10, v13}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1079
    const/4 v13, 0x0

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->max(II)I

    move-result p2

    .line 1080
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v13

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->min(II)I

    move-result p2

    .line 1081
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    move/from16 v0, p2

    invoke-interface {v10, v0, v13}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 1083
    invoke-interface {v7}, Ljava/util/List;->clear()V

    .line 1084
    invoke-interface {v7, v10}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1085
    invoke-interface {v7, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1086
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v7, v13}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v13

    if-eq v13, v6, :cond_c

    const/4 v11, 0x1

    :goto_4
    goto :goto_2

    .line 1071
    :cond_b
    const/4 v9, 0x0

    goto :goto_3

    .line 1086
    :cond_c
    const/4 v11, 0x0

    goto :goto_4

    .line 1092
    :cond_d
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v13

    move/from16 v0, p2

    if-lt v0, v13, :cond_e

    if-nez p2, :cond_11

    .line 1094
    :cond_e
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v4

    .line 1095
    .local v4, "curr_size":I
    if-gtz p2, :cond_10

    const/4 v9, 0x1

    .line 1096
    :goto_5
    if-lez v4, :cond_f

    if-eqz v9, :cond_f

    .line 1097
    sget-object v14, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    const/4 v13, 0x0

    invoke-interface {v7, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v13}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v1

    .line 1100
    :cond_f
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v7, v13}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1101
    const/4 v13, 0x0

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->max(II)I

    move-result p2

    .line 1102
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v13

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->min(II)I

    move-result p2

    .line 1103
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    move/from16 v0, p2

    invoke-interface {v7, v0, v13}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 1104
    add-int/lit8 v4, v4, 0x1

    .line 1105
    const/4 v13, 0x0

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v14

    invoke-static {v4, v14}, Ljava/lang/Math;->min(II)I

    move-result v14

    invoke-interface {v7, v13, v14}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v10

    .line 1106
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v13

    invoke-static {v4, v13}, Ljava/lang/Math;->min(II)I

    move-result v13

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v14

    invoke-interface {v7, v13, v14}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v5

    .line 1108
    const/4 v11, 0x1

    goto/16 :goto_2

    .line 1095
    :cond_10
    const/4 v9, 0x0

    goto :goto_5

    .line 1111
    .end local v4    # "curr_size":I
    :cond_11
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v5, v13}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1112
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v13

    sub-int p2, p2, v13

    .line 1113
    const/4 v13, 0x0

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->max(II)I

    move-result p2

    .line 1114
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v13

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->min(II)I

    move-result p2

    .line 1115
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    move/from16 v0, p2

    invoke-interface {v5, v0, v13}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 1117
    if-nez v6, :cond_12

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v5, v13}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v13

    if-eqz v13, :cond_12

    .line 1119
    const/4 v9, 0x1

    .line 1120
    const/4 v13, 0x0

    invoke-interface {v5, v13}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    invoke-interface {v10, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1123
    :cond_12
    invoke-interface {v7}, Ljava/util/List;->clear()V

    .line 1124
    invoke-interface {v7, v10}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1125
    invoke-interface {v7, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1126
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-interface {v7, v13}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v13

    if-ne v13, v6, :cond_13

    if-nez v9, :cond_13

    const/4 v11, 0x0

    :goto_6
    goto/16 :goto_2

    :cond_13
    const/4 v11, 0x1

    goto :goto_6
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 442
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->bind()V

    .line 443
    return-void
.end method

.method public overrideBatteryThreshold(D)V
    .locals 3
    .param p1, "aNewThreshold"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 1721
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config;->BUILD:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->EGold:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    if-ne v0, v1, :cond_1

    .line 1722
    const-wide/16 v0, 0x0

    cmpg-double v0, p1, v0

    if-gez v0, :cond_0

    const-wide/16 p1, 0x0

    .line 1723
    :cond_0
    const-string v0, "battery_threshold_override"

    invoke-direct {p0, v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideDoubleSetting(Ljava/lang/String;D)V

    .line 1725
    :cond_1
    return-void
.end method

.method public overrideCellularDataQuota(D)V
    .locals 3
    .param p1, "aNewQuota"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 1690
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config;->BUILD:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->EGold:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    if-ne v0, v1, :cond_1

    .line 1691
    const-wide/16 v0, 0x0

    cmpg-double v0, p1, v0

    if-gez v0, :cond_0

    const-wide/high16 p1, -0x4010000000000000L    # -1.0

    .line 1692
    :cond_0
    const-string v0, "cell_data_quota_override"

    invoke-direct {p0, v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideDoubleSetting(Ljava/lang/String;D)V

    .line 1694
    :cond_1
    return-void
.end method

.method public overrideHeadroom(D)V
    .locals 5
    .param p1, "aNewHeadroom"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 1628
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config;->BUILD:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->EGold:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    if-ne v0, v1, :cond_1

    .line 1629
    const-wide/16 v0, 0x0

    cmpg-double v0, p1, v0

    if-gez v0, :cond_0

    const-wide/16 p1, 0x0

    .line 1630
    :cond_0
    const-string v0, "headroom_override"

    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->toBytes(D)D

    move-result-wide v2

    invoke-direct {p0, v0, v2, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideDoubleSetting(Ljava/lang/String;D)V

    .line 1632
    :cond_1
    return-void
.end method

.method public overrideMaxStorageAllowed(D)V
    .locals 5
    .param p1, "aMaxStorageAllowed"    # D
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 1659
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config;->BUILD:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->EGold:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    if-ne v0, v1, :cond_1

    .line 1660
    const-wide/16 v0, 0x0

    cmpg-double v0, p1, v0

    if-gez v0, :cond_0

    const-wide/high16 p1, -0x4010000000000000L    # -1.0

    .line 1661
    :cond_0
    const-string v0, "max_storage_override"

    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->toBytes(D)D

    move-result-wide v2

    invoke-direct {p0, v0, v2, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->overrideDoubleSetting(Ljava/lang/String;D)V

    .line 1663
    :cond_1
    return-void
.end method

.method public pauseDownloads()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 1508
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->pauseDownloads(Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1516
    return-void

    .line 1509
    :catch_0
    move-exception v0

    .line 1511
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    .line 1512
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1513
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 1514
    .local v0, "e":Ljava/lang/NullPointerException;
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v2, "Service is not connected"

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method performSettingsOverride(Landroid/os/Bundle;)I
    .locals 3
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 2427
    sget-object v1, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;

    const-string v2, "SettingsOverride Callback"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2429
    const/4 v0, 0x0

    .line 2430
    .local v0, "setting_changed":I
    const-string v1, "destination_path_override"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2431
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    const-string v2, "destination_path_override"

    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "destination_path_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_0

    .line 2432
    or-int/lit16 v0, v0, 0x200

    .line 2434
    :cond_0
    const-string v1, "headroom_override"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2435
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    const-string v2, "headroom_override"

    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "headroom_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_1

    .line 2436
    or-int/lit8 v0, v0, 0x20

    .line 2438
    :cond_1
    const-string v1, "max_storage_override"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 2439
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    const-string v2, "max_storage_override"

    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "max_storage_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_2

    .line 2440
    or-int/lit8 v0, v0, 0x10

    .line 2442
    :cond_2
    const-string v1, "cell_data_quota_override"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 2443
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    const-string v2, "cell_data_quota_override"

    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "cell_data_quota_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_3

    .line 2444
    or-int/lit16 v0, v0, 0x80

    .line 2446
    :cond_3
    const-string v1, "battery_threshold_override"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 2447
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    const-string v2, "battery_threshold_override"

    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "battery_threshold_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_4

    .line 2448
    or-int/lit16 v0, v0, 0x100

    .line 2450
    :cond_4
    const-string v1, "client_configuration_fragment_rate"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 2451
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    const-string v2, "client_configuration_fragment_rate"

    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "client_configuration_fragment_rate"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    if-eq v1, v2, :cond_5

    .line 2452
    or-int/lit16 v0, v0, 0x400

    .line 2455
    :cond_5
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iRegistry:Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->updateRegistry(Landroid/os/Bundle;)V

    .line 2456
    return v0
.end method

.method public queuedRootList()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;",
            ">;"
        }
    .end annotation

    .prologue
    .line 873
    const/4 v0, 0x3

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getFiles(ILjava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public resumeDownloads()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 1526
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->resumeDownloads(Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1534
    return-void

    .line 1527
    :catch_0
    move-exception v0

    .line 1529
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    .line 1530
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1531
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 1532
    .local v0, "e":Ljava/lang/NullPointerException;
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v2, "Service is not connected"

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public status()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 1811
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iService:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService;->status(Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    return-object v1

    .line 1812
    :catch_0
    move-exception v0

    .line 1814
    .local v0, "e":Landroid/os/RemoteException;
    invoke-virtual {v0}, Landroid/os/RemoteException;->printStackTrace()V

    .line 1815
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1816
    .end local v0    # "e":Landroid/os/RemoteException;
    :catch_1
    move-exception v0

    .line 1817
    .local v0, "e":Ljava/lang/NullPointerException;
    new-instance v1, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v2, "Service is not connected"

    invoke-direct {v1, v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public update(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)Z
    .locals 10
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 1482
    const/4 v3, 0x0

    .line 1483
    .local v3, "updated":I
    if-eqz p1, :cond_0

    move-object v4, p1

    .line 1484
    check-cast v4, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 1485
    .local v4, "va":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    sget-object v6, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iApplicationContext:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 1486
    .local v0, "cr":Landroid/content/ContentResolver;
    new-instance v5, Landroid/content/ContentValues;

    invoke-direct {v5}, Landroid/content/ContentValues;-><init>()V

    .line 1487
    .local v5, "values":Landroid/content/ContentValues;
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 1488
    .local v1, "date":Ljava/util/Date;
    const-string v6, "modifyTime"

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 1489
    const-string v6, "description"

    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->metadata()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1491
    :try_start_0
    iget-object v6, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v6}, Lcom/penthera/virtuososdk/database/impl/provider/File$FileColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->id()I

    move-result v7

    int-to-long v8, v7

    invoke-static {v6, v8, v9}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v6

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual {v0, v6, v5, v7, v8}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 1496
    .end local v0    # "cr":Landroid/content/ContentResolver;
    .end local v1    # "date":Ljava/util/Date;
    .end local v4    # "va":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v5    # "values":Landroid/content/ContentValues;
    :cond_0
    :goto_0
    if-lez v3, :cond_1

    const/4 v6, 0x1

    :goto_1
    return v6

    .line 1492
    .restart local v0    # "cr":Landroid/content/ContentResolver;
    .restart local v1    # "date":Ljava/util/Date;
    .restart local v4    # "va":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .restart local v5    # "values":Landroid/content/ContentValues;
    :catch_0
    move-exception v2

    .line 1493
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 1496
    .end local v0    # "cr":Landroid/content/ContentResolver;
    .end local v1    # "date":Ljava/util/Date;
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v4    # "va":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v5    # "values":Landroid/content/ContentValues;
    :cond_1
    const/4 v6, 0x0

    goto :goto_1
.end method

.method public virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
    .locals 2
    .param p1, "aAssetId"    # Ljava/lang/String;
    .param p2, "aMetadata"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/client/ServiceException;
        }
    .end annotation

    .prologue
    .line 891
    invoke-static {p1, p2}, Lcom/penthera/virtuososdk/internal/interfaces/InternalInterfaceFactory;->virtuosoHLSFile(Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    move-result-object v0

    .local v0, "f":Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
    move-object v1, v0

    .line 892
    check-cast v1, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->create(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V

    .line 893
    return-object v0
.end method
