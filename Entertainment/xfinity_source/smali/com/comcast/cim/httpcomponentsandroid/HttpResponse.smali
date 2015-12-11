.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
.super Ljava/lang/Object;
.source "HttpResponse.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;


# virtual methods
.method public abstract getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
.end method

.method public abstract getLocale()Ljava/util/Locale;
.end method

.method public abstract getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
.end method

.method public abstract setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
.end method

.method public abstract setLocale(Ljava/util/Locale;)V
.end method

.method public abstract setReasonPhrase(Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setStatusCode(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation
.end method

.method public abstract setStatusLine(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V
.end method
