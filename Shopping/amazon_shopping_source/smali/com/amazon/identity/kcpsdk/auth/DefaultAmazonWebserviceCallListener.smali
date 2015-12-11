.class public Lcom/amazon/identity/kcpsdk/auth/DefaultAmazonWebserviceCallListener;
.super Ljava/lang/Object;
.source "DefaultAmazonWebserviceCallListener.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 0

    .prologue
    .line 11
    return-void
.end method

.method public onNetworkFailure()V
    .locals 0

    .prologue
    .line 26
    return-void
.end method

.method public onParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 0
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;

    .prologue
    .line 16
    return-void
.end method

.method public onResponseComplete(Ljava/lang/Object;)V
    .locals 0
    .param p1, "response"    # Ljava/lang/Object;

    .prologue
    .line 21
    return-void
.end method
