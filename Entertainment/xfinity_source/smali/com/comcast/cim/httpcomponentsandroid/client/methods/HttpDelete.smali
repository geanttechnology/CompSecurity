.class public Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpDelete;
.super Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;
.source "HttpDelete.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;-><init>()V

    .line 57
    return-void
.end method

.method public constructor <init>(Ljava/net/URI;)V
    .locals 0
    .param p1, "uri"    # Ljava/net/URI;

    .prologue
    .line 60
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;-><init>()V

    .line 61
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpDelete;->setURI(Ljava/net/URI;)V

    .line 62
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    const-string v0, "DELETE"

    return-object v0
.end method
