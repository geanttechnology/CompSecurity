.class public Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;
.super Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;
.source "HttpPost.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;-><init>()V

    .line 64
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;-><init>()V

    .line 76
    invoke-static {p1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;->setURI(Ljava/net/URI;)V

    .line 77
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;)V
    .locals 0
    .param p1, "uri"    # Ljava/net/URI;

    .prologue
    .line 67
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;-><init>()V

    .line 68
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPost;->setURI(Ljava/net/URI;)V

    .line 69
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    const-string v0, "POST"

    return-object v0
.end method
