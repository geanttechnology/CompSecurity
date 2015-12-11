.class public abstract Lcom/amazon/ansel/fetch/tools/web/RequestContent;
.super Ljava/lang/Object;
.source "RequestContent.java"


# instance fields
.field private final length:J

.field private final repeatable:Z


# virtual methods
.method public getLength()J
    .locals 2

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/amazon/ansel/fetch/tools/web/RequestContent;->length:J

    return-wide v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 66
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/tools/web/RequestContent;->repeatable:Z

    return v0
.end method

.method public abstract writeTo(Ljava/io/OutputStream;)V
.end method
