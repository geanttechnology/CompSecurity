.class public Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPut;
.super Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;
.source "HttpPut.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;-><init>()V

    .line 56
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;)V
    .locals 0
    .param p1, "uri"    # Ljava/net/URI;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;-><init>()V

    .line 60
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpPut;->setURI(Ljava/net/URI;)V

    .line 61
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    const-string v0, "PUT"

    return-object v0
.end method
