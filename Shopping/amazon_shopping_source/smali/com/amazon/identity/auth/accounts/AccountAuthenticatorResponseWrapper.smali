.class public Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;
.super Ljava/lang/Object;
.source "AccountAuthenticatorResponseWrapper.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mInner:Landroid/accounts/AccountAuthenticatorResponse;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/accounts/AccountAuthenticatorResponse;)V
    .locals 0
    .param p1, "inner"    # Landroid/accounts/AccountAuthenticatorResponse;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    new-instance v0, Landroid/accounts/AccountAuthenticatorResponse;

    invoke-direct {v0, p1}, Landroid/accounts/AccountAuthenticatorResponse;-><init>(Landroid/os/Parcel;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    .line 27
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    if-nez v0, :cond_0

    .line 71
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Account Authenticator Response is null, can\'t call describeContents"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    const/4 v0, 0x0

    .line 75
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    invoke-virtual {v0}, Landroid/accounts/AccountAuthenticatorResponse;->describeContents()I

    move-result v0

    goto :goto_0
.end method

.method public getInner()Landroid/accounts/AccountAuthenticatorResponse;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    return-object v0
.end method

.method public onError(ILjava/lang/String;)V
    .locals 2
    .param p1, "errorCode"    # I
    .param p2, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    if-nez v0, :cond_0

    .line 60
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Account Authenticator Response is null, can\'t call onError"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    :goto_0
    return-void

    .line 64
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    invoke-virtual {v0, p1, p2}, Landroid/accounts/AccountAuthenticatorResponse;->onError(ILjava/lang/String;)V

    goto :goto_0
.end method

.method public onRequestContinued()V
    .locals 2

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    if-nez v0, :cond_0

    .line 49
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Account Authenticator Response is null, can\'t call onRequestContinued"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    :goto_0
    return-void

    .line 53
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    invoke-virtual {v0}, Landroid/accounts/AccountAuthenticatorResponse;->onRequestContinued()V

    goto :goto_0
.end method

.method public onResult(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    if-nez v0, :cond_0

    .line 38
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Account Authenticator Response is null, can\'t call onResult"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    :goto_0
    return-void

    .line 42
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    invoke-virtual {v0, p1}, Landroid/accounts/AccountAuthenticatorResponse;->onResult(Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    if-nez v0, :cond_0

    .line 82
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Account Authenticator Response is null, can\'t call writeToParcel"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    :goto_0
    return-void

    .line 86
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseWrapper;->mInner:Landroid/accounts/AccountAuthenticatorResponse;

    invoke-virtual {v0, p1, p2}, Landroid/accounts/AccountAuthenticatorResponse;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_0
.end method
