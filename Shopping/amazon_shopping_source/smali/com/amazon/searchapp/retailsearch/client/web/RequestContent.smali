.class public abstract Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;
.super Ljava/lang/Object;
.source "RequestContent.java"


# instance fields
.field private final encoding:Ljava/lang/String;

.field private final length:J

.field private final repeatable:Z

.field private final type:Ljava/lang/String;


# virtual methods
.method public getEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->encoding:Ljava/lang/String;

    return-object v0
.end method

.method public getLength()J
    .locals 2

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->length:J

    return-wide v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->type:Ljava/lang/String;

    return-object v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 66
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/client/web/RequestContent;->repeatable:Z

    return v0
.end method

.method public abstract writeTo(Ljava/io/OutputStream;)V
.end method
