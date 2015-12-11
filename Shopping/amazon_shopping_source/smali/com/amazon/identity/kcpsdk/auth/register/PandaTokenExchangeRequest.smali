.class public Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;
.super Ljava/lang/Object;
.source "PandaTokenExchangeRequest.java"


# instance fields
.field private final mRequest:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Lorg/json/JSONObject;)V
    .locals 0
    .param p1, "request"    # Lorg/json/JSONObject;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;->mRequest:Lorg/json/JSONObject;

    .line 45
    return-void
.end method

.method public static builder()Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;
    .locals 1

    .prologue
    .line 54
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder;-><init>()V

    return-object v0
.end method


# virtual methods
.method public getRequest()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequest;->mRequest:Lorg/json/JSONObject;

    return-object v0
.end method
