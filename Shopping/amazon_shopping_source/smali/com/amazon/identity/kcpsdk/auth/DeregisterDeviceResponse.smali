.class public Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;
.super Ljava/lang/Object;
.source "DeregisterDeviceResponse.java"


# instance fields
.field private mError:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    return-void
.end method


# virtual methods
.method public getError()Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;

    return-object v0
.end method

.method public setError(Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;)V
    .locals 0
    .param p1, "err"    # Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;

    .line 21
    return-void
.end method
