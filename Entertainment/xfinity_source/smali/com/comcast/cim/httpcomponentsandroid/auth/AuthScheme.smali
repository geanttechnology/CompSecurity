.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
.super Ljava/lang/Object;
.source "AuthScheme.java"


# virtual methods
.method public abstract authenticate(Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract getRealm()Ljava/lang/String;
.end method

.method public abstract getSchemeName()Ljava/lang/String;
.end method

.method public abstract isComplete()Z
.end method

.method public abstract isConnectionBased()Z
.end method

.method public abstract processChallenge(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;
        }
    .end annotation
.end method
