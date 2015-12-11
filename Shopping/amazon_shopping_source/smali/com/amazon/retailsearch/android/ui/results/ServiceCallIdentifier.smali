.class public Lcom/amazon/retailsearch/android/ui/results/ServiceCallIdentifier;
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
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/ServiceCallIdentifier;->mServiceName:Ljava/lang/String;

    .line 15
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/ServiceCallIdentifier;->mMethodName:Ljava/lang/String;

    .line 16
    return-void
.end method


# virtual methods
.method public getMethodName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ServiceCallIdentifier;->mMethodName:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/ServiceCallIdentifier;->mServiceName:Ljava/lang/String;

    return-object v0
.end method
