.class public Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage$GetTokenAction;
.super Ljava/lang/Object;
.source "NonCanonicalDataStorage.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/framework/IPCCommand;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetTokenAction"
.end annotation


# static fields
.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "directedId"

.field public static final KEY_KEY:Ljava/lang/String; = "key"

.field public static final KEY_VALUE:Ljava/lang/String; = "value"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 115
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getResult(Landroid/os/Bundle;)Ljava/lang/String;
    .locals 1
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 124
    const-string/jumbo v0, "value"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static parametersToBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "directedId"    # Ljava/lang/String;
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 129
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 130
    .local v0, "paramBundles":Landroid/os/Bundle;
    const-string/jumbo v1, "directedId"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    const-string/jumbo v1, "key"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    return-object v0
.end method


# virtual methods
.method public performIPCAction(Landroid/content/Context;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "givenParameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 138
    if-eqz p2, :cond_0

    move-object v3, p2

    .line 139
    .local v3, "parameters":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v5, "directedId"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 140
    .local v1, "directedId":Ljava/lang/String;
    const-string/jumbo v5, "key"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 142
    .local v2, "key":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/identity/auth/device/storage/NonCanonicalDataStorage;->access$000(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    .line 144
    .local v0, "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 145
    .local v4, "result":Landroid/os/Bundle;
    const-string/jumbo v5, "value"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    return-object v4

    .line 138
    .end local v0    # "dataStorage":Lcom/amazon/identity/auth/device/storage/DataStorage;
    .end local v1    # "directedId":Ljava/lang/String;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "parameters":Landroid/os/Bundle;
    .end local v4    # "result":Landroid/os/Bundle;
    :cond_0
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    goto :goto_0
.end method
