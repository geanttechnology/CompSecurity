.class public Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpOptions;
.super Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;
.source "HttpOptions.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;-><init>()V

    .line 65
    return-void
.end method


# virtual methods
.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    const-string v0, "OPTIONS"

    return-object v0
.end method
