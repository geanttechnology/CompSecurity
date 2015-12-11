.class public Lcom/amazon/zeroes/intentservice/DefaultZeroesPurchaseRequestDecorator;
.super Ljava/lang/Object;
.source "DefaultZeroesPurchaseRequestDecorator.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/ZeroesPurchaseRequestDecorator;


# direct methods
.method public constructor <init>()V
    .locals 0
    .annotation runtime Ljavax/inject/Inject;
    .end annotation

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public decorateZeroesPurchaseRequest(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    .locals 0
    .param p1, "request"    # Lorg/json/JSONObject;

    .prologue
    .line 21
    return-object p1
.end method
