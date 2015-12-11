.class public Lcom/comcast/cim/httpcomponentsandroid/client/HttpResponseException;
.super Lcom/comcast/cim/httpcomponentsandroid/client/ClientProtocolException;
.source "HttpResponseException.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final statusCode:I


# virtual methods
.method public getStatusCode()I
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/HttpResponseException;->statusCode:I

    return v0
.end method
