.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/client/RedirectHandler;
.super Ljava/lang/Object;
.source "RedirectHandler.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# virtual methods
.method public abstract getLocationURI(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/net/URI;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation
.end method

.method public abstract isRedirectRequested(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z
.end method
