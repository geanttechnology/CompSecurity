.class public final Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper;
.super Ljava/lang/Object;
.source "AccountAuthenticatorResponseHelper.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    return-void
.end method

.method public static createCallbackToAccountAuthenticatorResponseAdapter(Lcom/amazon/identity/auth/device/api/Callback;)Landroid/accounts/AccountAuthenticatorResponse;
    .locals 3
    .param p0, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 20
    new-instance v0, Landroid/accounts/AccountAuthenticatorResponse;

    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper$1;

    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper$1;-><init>(Lcom/amazon/identity/auth/device/api/Callback;)V

    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v2

    invoke-interface {v1}, Landroid/accounts/IAccountAuthenticatorResponse;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    const/4 v1, 0x0

    invoke-virtual {v2, v1}, Landroid/os/Parcel;->setDataPosition(I)V

    invoke-direct {v0, v2}, Landroid/accounts/AccountAuthenticatorResponse;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method
