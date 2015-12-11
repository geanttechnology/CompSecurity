.class public Lorg/springframework/http/converter/HttpMessageNotReadableException;
.super Lorg/springframework/http/converter/HttpMessageConversionException;
.source "HttpMessageNotReadableException.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 47
    invoke-direct {p0, p1, p2}, Lorg/springframework/http/converter/HttpMessageConversionException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 48
    return-void
.end method
