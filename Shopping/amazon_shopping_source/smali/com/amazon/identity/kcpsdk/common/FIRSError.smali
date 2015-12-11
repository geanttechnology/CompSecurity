.class public Lcom/amazon/identity/kcpsdk/common/FIRSError;
.super Ljava/lang/Object;
.source "FIRSError.java"


# instance fields
.field private mErrorType:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;)V
    .locals 0
    .param p1, "errorType"    # Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/FIRSError;->mErrorType:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    .line 12
    return-void
.end method


# virtual methods
.method public getErrorType()Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/FIRSError;->mErrorType:Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    return-object v0
.end method
