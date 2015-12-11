.class public abstract Lorg/springframework/web/client/HttpStatusCodeException;
.super Lorg/springframework/web/client/RestClientException;
.source "HttpStatusCodeException.java"


# static fields
.field private static final DEFAULT_CHARSET:Ljava/nio/charset/Charset;


# instance fields
.field private final responseBody:[B

.field private final responseCharset:Ljava/nio/charset/Charset;

.field private final statusCode:Lorg/springframework/http/HttpStatus;

.field private final statusText:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-string v0, "ISO-8859-1"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Lorg/springframework/web/client/HttpStatusCodeException;->DEFAULT_CHARSET:Ljava/nio/charset/Charset;

    return-void
.end method

.method protected constructor <init>(Lorg/springframework/http/HttpStatus;Ljava/lang/String;[BLjava/nio/charset/Charset;)V
    .locals 2
    .param p1, "statusCode"    # Lorg/springframework/http/HttpStatus;
    .param p2, "statusText"    # Ljava/lang/String;
    .param p3, "responseBody"    # [B
    .param p4, "responseCharset"    # Ljava/nio/charset/Charset;

    .prologue
    .line 77
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lorg/springframework/http/HttpStatus;->value()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lorg/springframework/web/client/RestClientException;-><init>(Ljava/lang/String;)V

    .line 78
    iput-object p1, p0, Lorg/springframework/web/client/HttpStatusCodeException;->statusCode:Lorg/springframework/http/HttpStatus;

    .line 79
    iput-object p2, p0, Lorg/springframework/web/client/HttpStatusCodeException;->statusText:Ljava/lang/String;

    .line 80
    if-eqz p3, :cond_0

    .end local p3    # "responseBody":[B
    :goto_0
    iput-object p3, p0, Lorg/springframework/web/client/HttpStatusCodeException;->responseBody:[B

    .line 81
    if-eqz p4, :cond_1

    .end local p4    # "responseCharset":Ljava/nio/charset/Charset;
    :goto_1
    iput-object p4, p0, Lorg/springframework/web/client/HttpStatusCodeException;->responseCharset:Ljava/nio/charset/Charset;

    .line 82
    return-void

    .line 80
    .restart local p3    # "responseBody":[B
    .restart local p4    # "responseCharset":Ljava/nio/charset/Charset;
    :cond_0
    const/4 v0, 0x0

    new-array p3, v0, [B

    goto :goto_0

    .line 81
    .end local p3    # "responseBody":[B
    :cond_1
    sget-object p4, Lorg/springframework/web/client/HttpStatusCodeException;->DEFAULT_CHARSET:Ljava/nio/charset/Charset;

    goto :goto_1
.end method
