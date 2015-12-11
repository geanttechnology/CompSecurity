.class public final Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SchemeRegistryFactory;
.super Ljava/lang/Object;
.source "SchemeRegistryFactory.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createDefault()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;
    .locals 5

    .prologue
    .line 42
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;-><init>()V

    .line 43
    .local v0, "registry":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    const-string v2, "http"

    const/16 v3, 0x50

    invoke-static {}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;->getSocketFactory()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/PlainSocketFactory;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;-><init>(Ljava/lang/String;ILcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;->register(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;)Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    .line 45
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    const-string v2, "https"

    const/16 v3, 0x1bb

    invoke-static {}, Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;->getSocketFactory()Lcom/comcast/cim/httpcomponentsandroid/conn/ssl/SSLSocketFactory;

    move-result-object v4

    invoke-direct {v1, v2, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;-><init>(Ljava/lang/String;ILcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeSocketFactory;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;->register(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;)Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;

    .line 47
    return-object v0
.end method
