.class public Lorg/springframework/web/client/HttpClientErrorException;
.super Lorg/springframework/web/client/HttpStatusCodeException;
.source "HttpClientErrorException.java"


# direct methods
.method public constructor <init>(Lorg/springframework/http/HttpStatus;Ljava/lang/String;[BLjava/nio/charset/Charset;)V
    .locals 0
    .param p1, "statusCode"    # Lorg/springframework/http/HttpStatus;
    .param p2, "statusText"    # Ljava/lang/String;
    .param p3, "responseBody"    # [B
    .param p4, "responseCharset"    # Ljava/nio/charset/Charset;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2, p3, p4}, Lorg/springframework/web/client/HttpStatusCodeException;-><init>(Lorg/springframework/http/HttpStatus;Ljava/lang/String;[BLjava/nio/charset/Charset;)V

    .line 66
    return-void
.end method
