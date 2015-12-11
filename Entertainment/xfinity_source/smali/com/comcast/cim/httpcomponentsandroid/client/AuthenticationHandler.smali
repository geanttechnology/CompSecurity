.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/client/AuthenticationHandler;
.super Ljava/lang/Object;
.source "AuthenticationHandler.java"


# virtual methods
.method public abstract getChallenges(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;",
            "Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;
        }
    .end annotation
.end method

.method public abstract isAuthenticationRequested(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Z
.end method

.method public abstract selectScheme(Ljava/util/Map;Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;",
            "Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;",
            ")",
            "Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
        }
    .end annotation
.end method
