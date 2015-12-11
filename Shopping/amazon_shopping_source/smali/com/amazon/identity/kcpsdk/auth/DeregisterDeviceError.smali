.class public Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;
.super Ljava/lang/Object;
.source "DeregisterDeviceError.java"


# instance fields
.field private final mErrorType:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;)V
    .locals 0
    .param p1, "errorType"    # Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;->mErrorType:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    .line 12
    return-void
.end method


# virtual methods
.method public getType()Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceError;->mErrorType:Lcom/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType;

    return-object v0
.end method
