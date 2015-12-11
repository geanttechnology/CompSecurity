.class Lcom/amazon/identity/auth/accounts/AccountRegistrar$5;
.super Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
.source "AccountRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountRegistrar;->getAccountCredentialsFromTokenAndKey(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

.field final synthetic val$adpToken:Ljava/lang/String;

.field final synthetic val$key:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountRegistrar;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 2131
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$5;->val$adpToken:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$5;->val$key:Ljava/lang/String;

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;-><init>()V

    return-void
.end method


# virtual methods
.method public getPrivateKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2141
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$5;->val$key:Ljava/lang/String;

    return-object v0
.end method

.method public getToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2135
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$5;->val$adpToken:Ljava/lang/String;

    return-object v0
.end method

.method public isStale(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 2147
    const/4 v0, 0x0

    return v0
.end method
