.class public Lorg/springframework/http/converter/HttpMessageNotWritableException;
.super Lorg/springframework/http/converter/HttpMessageConversionException;
.source "HttpMessageNotWritableException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-direct {p0, p1}, Lorg/springframework/http/converter/HttpMessageConversionException;-><init>(Ljava/lang/String;)V

    .line 39
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Lorg/springframework/http/converter/HttpMessageConversionException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 49
    return-void
.end method
