.class public Lcom/amazon/mShop/net/ServiceCallIdentifier;
.super Ljava/lang/Object;
.source "ServiceCallIdentifier.java"


# instance fields
.field private final mMethodName:Ljava/lang/String;

.field private final mServiceName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "serviceName"    # Ljava/lang/String;
    .param p2, "methodName"    # Ljava/lang/String;

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput-object p1, p0, Lcom/amazon/mShop/net/ServiceCallIdentifier;->mServiceName:Ljava/lang/String;

    .line 10
    iput-object p2, p0, Lcom/amazon/mShop/net/ServiceCallIdentifier;->mMethodName:Ljava/lang/String;

    .line 11
    return-void
.end method


# virtual methods
.method public getMethodName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/net/ServiceCallIdentifier;->mMethodName:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/mShop/net/ServiceCallIdentifier;->mServiceName:Ljava/lang/String;

    return-object v0
.end method
