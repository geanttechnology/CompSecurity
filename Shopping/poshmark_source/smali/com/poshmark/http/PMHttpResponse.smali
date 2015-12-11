.class public Lcom/poshmark/http/PMHttpResponse;
.super Ljava/lang/Object;
.source "PMHttpResponse.java"


# instance fields
.field public headerArray:[Lorg/apache/http/Header;

.field public final httpCode:I

.field public final httpError:Lcom/poshmark/http/PMHttpError;

.field public final httpRequest:Lcom/poshmark/http/PMHttpRequest;

.field public final responseString:Ljava/lang/String;


# direct methods
.method public constructor <init>(I[Lorg/apache/http/Header;Ljava/lang/String;Lcom/poshmark/http/PMHttpRequest;Lcom/poshmark/http/PMHttpError;)V
    .locals 0
    .param p1, "httpCode"    # I
    .param p2, "headerArray"    # [Lorg/apache/http/Header;
    .param p3, "responseString"    # Ljava/lang/String;
    .param p4, "httpRequest"    # Lcom/poshmark/http/PMHttpRequest;
    .param p5, "httpError"    # Lcom/poshmark/http/PMHttpError;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput p1, p0, Lcom/poshmark/http/PMHttpResponse;->httpCode:I

    .line 20
    iput-object p3, p0, Lcom/poshmark/http/PMHttpResponse;->responseString:Ljava/lang/String;

    .line 21
    iput-object p4, p0, Lcom/poshmark/http/PMHttpResponse;->httpRequest:Lcom/poshmark/http/PMHttpRequest;

    .line 22
    iput-object p5, p0, Lcom/poshmark/http/PMHttpResponse;->httpError:Lcom/poshmark/http/PMHttpError;

    .line 23
    iput-object p2, p0, Lcom/poshmark/http/PMHttpResponse;->headerArray:[Lorg/apache/http/Header;

    .line 24
    return-void
.end method


# virtual methods
.method public hasError()Z
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/poshmark/http/PMHttpResponse;->httpError:Lcom/poshmark/http/PMHttpError;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
