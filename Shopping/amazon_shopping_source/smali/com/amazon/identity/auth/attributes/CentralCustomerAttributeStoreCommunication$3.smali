.class Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$3;
.super Ljava/lang/Object;
.source "CentralCustomerAttributeStoreCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->queryCentralStore(Lorg/json/JSONObject;)Landroid/os/Bundle;
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
.field final synthetic this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

.field final synthetic val$command:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 236
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$3;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$3;->val$command:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public useContentProviderClient(Landroid/content/ContentProviderClient;)Landroid/os/Bundle;
    .locals 7
    .param p1, "client"    # Landroid/content/ContentProviderClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 241
    sget-object v1, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->CUSTOMER_ATTRIBUTE_STORE_URI:Landroid/net/Uri;

    sget-object v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->COLUMNS:Ljava/util/List;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/String;

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$3;->val$command:Ljava/lang/String;

    move-object v0, p1

    move-object v5, v4

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentProviderClient;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 250
    .local v6, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$3;->val$command:Ljava/lang/String;

    invoke-static {v6, v0}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->parseCursor(Landroid/database/Cursor;Ljava/lang/String;)Landroid/os/Bundle;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 254
    if-eqz v6, :cond_0

    .line 256
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_0
    return-object v0

    .line 254
    :catchall_0
    move-exception v0

    if-eqz v6, :cond_1

    .line 256
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_1
    throw v0
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
    .line 236
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$3;->useContentProviderClient(Landroid/content/ContentProviderClient;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method
