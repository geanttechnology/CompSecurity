.class Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;
.super Ljava/lang/Object;
.source "GenericIPCSender.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->queryCentralStore(Landroid/os/Bundle;)Landroid/os/Bundle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback",
        "<",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

.field final synthetic val$command:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/GenericIPCSender;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 363
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;->this$0:Lcom/amazon/identity/auth/device/framework/GenericIPCSender;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;->val$command:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public useContentProviderClient(Landroid/content/ContentProviderClient;)Landroid/os/Bundle;
    .locals 8
    .param p1, "client"    # Landroid/content/ContentProviderClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 368
    sget-object v1, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->GENERIC_IPC_URI:Landroid/net/Uri;

    # getter for: Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->COLUMNS:[Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender;->access$500()[Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;->val$command:Ljava/lang/String;

    move-object v0, p1

    move-object v5, v4

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentProviderClient;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 376
    .local v6, "cursor":Landroid/database/Cursor;
    if-nez v6, :cond_1

    .line 378
    :try_start_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "Got a null cursor calling Generic IPC central store."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 400
    :catchall_0
    move-exception v0

    if-eqz v6, :cond_0

    .line 402
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v0

    .line 381
    :cond_1
    :try_start_1
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_2

    .line 383
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "Got an empty cursor calling Generic IPC central store."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 386
    :cond_2
    const-string/jumbo v0, "bundle_value"

    invoke-static {v6, v0}, Lcom/amazon/identity/auth/device/utils/DBUtils;->getString(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 389
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ParcelUtils;->stringToBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v7

    .line 391
    .local v7, "result":Landroid/os/Bundle;
    if-nez v7, :cond_3

    .line 393
    new-instance v0, Ljava/lang/RuntimeException;

    const-string/jumbo v1, "Corrupted value returned."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 400
    :cond_3
    if-eqz v6, :cond_4

    .line 402
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_4
    return-object v7
.end method

.method public bridge synthetic useContentProviderClient(Landroid/content/ContentProviderClient;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/content/ContentProviderClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 363
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/framework/GenericIPCSender$1;->useContentProviderClient(Landroid/content/ContentProviderClient;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method
