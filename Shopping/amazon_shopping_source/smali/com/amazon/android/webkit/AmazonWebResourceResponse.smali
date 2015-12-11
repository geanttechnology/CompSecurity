.class public Lcom/amazon/android/webkit/AmazonWebResourceResponse;
.super Ljava/lang/Object;
.source "AmazonWebResourceResponse.java"


# instance fields
.field private data:Ljava/io/InputStream;

.field private encoding:Ljava/lang/String;

.field private mimeType:Ljava/lang/String;


# virtual methods
.method public getData()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebResourceResponse;->data:Ljava/io/InputStream;

    return-object v0
.end method

.method public getEncoding()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebResourceResponse;->encoding:Ljava/lang/String;

    return-object v0
.end method

.method public getMimeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/android/webkit/AmazonWebResourceResponse;->mimeType:Ljava/lang/String;

    return-object v0
.end method
