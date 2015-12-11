.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/auth/ContextAwareAuthScheme;
.super Ljava/lang/Object;
.source "ContextAwareAuthScheme.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;


# virtual methods
.method public abstract authenticate(Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
        }
    .end annotation
.end method
