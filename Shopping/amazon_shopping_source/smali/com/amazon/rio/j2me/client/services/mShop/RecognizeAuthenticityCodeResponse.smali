.class public Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;
.super Ljava/lang/Object;
.source "RecognizeAuthenticityCodeResponse.java"


# instance fields
.field private codeType:Ljava/lang/String;

.field private landingUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCodeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;->codeType:Ljava/lang/String;

    return-object v0
.end method

.method public getLandingUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;->landingUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setCodeType(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;->codeType:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setLandingUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/RecognizeAuthenticityCodeResponse;->landingUrl:Ljava/lang/String;

    .line 37
    return-void
.end method
