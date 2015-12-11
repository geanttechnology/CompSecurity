.class Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;
.super Ljava/lang/Object;
.source "AccountRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountRegistrar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RegisterInfo"
.end annotation


# instance fields
.field public error:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

.field public userData:Landroid/os/Bundle;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 113
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 114
    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "accountUserData"    # Landroid/os/Bundle;

    .prologue
    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->userData:Landroid/os/Bundle;

    .line 110
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)V
    .locals 0
    .param p1, "regError"    # Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 104
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->error:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    .line 105
    return-void
.end method

.method private commonGetUserDataAttribute(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->userData:Landroid/os/Bundle;

    if-nez v0, :cond_0

    .line 130
    const/4 v0, 0x0

    .line 133
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->userData:Landroid/os/Bundle;

    invoke-virtual {v0, p1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public getDirectedId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.acctId"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->commonGetUserDataAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    const-string/jumbo v0, "com.amazon.dcp.sso.property.username"

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/AccountRegistrar$RegisterInfo;->commonGetUserDataAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
