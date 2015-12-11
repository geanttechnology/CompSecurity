.class Lcom/amazon/identity/auth/accounts/DeregisterAccount$1;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$1;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createAccountRegistrar()Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$1;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->createAccountRegistrar()Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    move-result-object v0

    return-object v0
.end method

.method public createSubAuthConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .locals 1
    .param p1, "description"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$1;->this$0:Lcom/amazon/identity/auth/accounts/DeregisterAccount;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->createSubAuthConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    move-result-object v0

    return-object v0
.end method
