.class final Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher;
.super Lcom/amazon/mShop/net/HttpFetcher;
.source "HttpFetcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/HttpFetcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "VoidFetcher"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher$VoidParams;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/net/HttpFetcher",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 366
    new-instance v0, Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher$VoidParams;

    invoke-direct {v0, p1}, Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher$VoidParams;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/amazon/mShop/net/HttpFetcher;-><init>(Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    .line 367
    return-void
.end method


# virtual methods
.method protected getParameterizedClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 376
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic handleResponse(Ljava/net/HttpURLConnection;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 363
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher;->handleResponse(Ljava/net/HttpURLConnection;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public handleResponse(Ljava/net/HttpURLConnection;)Ljava/lang/Void;
    .locals 1
    .param p1, "httpConnection"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 382
    const/4 v0, 0x0

    return-object v0
.end method

.method protected isVoidRequest()Z
    .locals 1

    .prologue
    .line 371
    const/4 v0, 0x1

    return v0
.end method
