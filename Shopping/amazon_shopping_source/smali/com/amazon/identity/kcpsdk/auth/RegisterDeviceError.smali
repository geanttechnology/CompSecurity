.class public Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
.super Ljava/lang/Object;
.source "RegisterDeviceError.java"


# instance fields
.field private final mErrorType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V
    .locals 0
    .param p1, "errorType"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;->mErrorType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 12
    return-void
.end method


# virtual methods
.method public getType()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;->mErrorType:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    return-object v0
.end method
