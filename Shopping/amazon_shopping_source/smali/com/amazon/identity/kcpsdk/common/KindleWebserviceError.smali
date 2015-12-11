.class public Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;
.super Ljava/lang/Object;
.source "KindleWebserviceError.java"


# instance fields
.field private final mErrorType:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;)V
    .locals 0
    .param p1, "errorType"    # Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;->mErrorType:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    .line 13
    return-void
.end method


# virtual methods
.method public getErrorType()Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;->mErrorType:Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    return-object v0
.end method
