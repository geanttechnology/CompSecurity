.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;
.super Lcom/comcast/cim/httpcomponentsandroid/HttpException;
.source "TunnelRefusedException.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;)V

    .line 49
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    .line 50
    return-void
.end method


# virtual methods
.method public getResponse()Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/TunnelRefusedException;->response:Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;

    return-object v0
.end method
