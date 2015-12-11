.class public Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;
.super Ljava/lang/Object;
.source "MASHNavOperation.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mobile/mash/nav/MASHNavOperation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MASHNavRequest"
.end annotation


# instance fields
.field private mMethod:Ljava/lang/String;

.field private mParams:Lorg/json/JSONObject;

.field private mUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 164
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->mMethod:Ljava/lang/String;

    return-object v0
.end method

.method public getParams()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->mParams:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setMethod(Ljava/lang/String;)V
    .locals 0
    .param p1, "method"    # Ljava/lang/String;

    .prologue
    .line 208
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->mMethod:Ljava/lang/String;

    .line 209
    return-void
.end method

.method public setParams(Lorg/json/JSONObject;)V
    .locals 0
    .param p1, "params"    # Lorg/json/JSONObject;

    .prologue
    .line 222
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->mParams:Lorg/json/JSONObject;

    .line 223
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/amazon/mobile/mash/nav/MASHNavOperation$MASHNavRequest;->mUrl:Ljava/lang/String;

    .line 195
    return-void
.end method
