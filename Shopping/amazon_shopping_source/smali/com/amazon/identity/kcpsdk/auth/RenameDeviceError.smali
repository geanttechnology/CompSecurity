.class public Lcom/amazon/identity/kcpsdk/auth/RenameDeviceError;
.super Ljava/lang/Object;
.source "RenameDeviceError.java"


# instance fields
.field private final mErrorText:Ljava/lang/String;

.field private final mErrorType:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;Ljava/lang/String;)V
    .locals 0
    .param p1, "errorType"    # Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;
    .param p2, "errorText"    # Ljava/lang/String;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceError;->mErrorType:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    .line 13
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceError;->mErrorText:Ljava/lang/String;

    .line 14
    return-void
.end method


# virtual methods
.method public getErrorText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceError;->mErrorText:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceError;->mErrorType:Lcom/amazon/identity/kcpsdk/auth/RenameDeviceErrorType;

    return-object v0
.end method
