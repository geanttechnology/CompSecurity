.class public abstract Lcom/amazon/mShop/net/HttpFetcher$Params;
.super Ljava/lang/Object;
.source "HttpFetcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/HttpFetcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Params"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected mCached:Z

.field private final mSubscriber:Lcom/amazon/mShop/net/HttpFetcher$Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<TT;>;"
        }
    .end annotation
.end field

.field protected mTag:Ljava/lang/Object;

.field protected mUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 109
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    .local p2, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 110
    iput-object p1, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mUrl:Ljava/lang/String;

    .line 111
    iput-object p2, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mSubscriber:Lcom/amazon/mShop/net/HttpFetcher$Subscriber;

    .line 112
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mTag:Ljava/lang/Object;

    .line 113
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;Ljava/lang/Object;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p3, "tag"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<TT;>;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 115
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    .local p2, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 116
    iput-object p1, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mUrl:Ljava/lang/String;

    .line 117
    iput-object p2, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mSubscriber:Lcom/amazon/mShop/net/HttpFetcher$Subscriber;

    .line 118
    iput-object p3, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mTag:Ljava/lang/Object;

    .line 119
    return-void
.end method


# virtual methods
.method public getCacheKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/net/HttpFetcher$Params;->getUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public abstract getServiceCallIdentifier()Lcom/amazon/mShop/net/ServiceCallIdentifier;
.end method

.method public getSubscriber()Lcom/amazon/mShop/net/HttpFetcher$Subscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 89
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mSubscriber:Lcom/amazon/mShop/net/HttpFetcher$Subscriber;

    return-object v0
.end method

.method public getTag()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 95
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mTag:Ljava/lang/Object;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setCached(Z)V
    .locals 0
    .param p1, "cached"    # Z

    .prologue
    .line 106
    .local p0, "this":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<TT;>;"
    iput-boolean p1, p0, Lcom/amazon/mShop/net/HttpFetcher$Params;->mCached:Z

    .line 107
    return-void
.end method
