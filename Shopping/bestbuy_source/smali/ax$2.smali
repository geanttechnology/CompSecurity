.class final Lax$2;
.super Lay;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lax;
.end annotation


# instance fields
.field private synthetic c:Lorg/apache/http/client/methods/HttpUriRequest;

.field private synthetic d:Lorg/apache/http/protocol/HttpContext;


# direct methods
.method constructor <init>(Lax;Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)V
    .locals 0

    .prologue
    .line 180
    iput-object p4, p0, Lax$2;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    iput-object p5, p0, Lax$2;->d:Lorg/apache/http/protocol/HttpContext;

    invoke-direct {p0, p1, p2, p3}, Lay;-><init>(Lax;Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)V

    return-void
.end method


# virtual methods
.method protected final a()Ljava/lang/Object;
    .locals 3

    .prologue
    .line 183
    iget-object v0, p0, Lax$2;->a:Lorg/apache/http/client/HttpClient;

    iget-object v1, p0, Lax$2;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    iget-object v2, p0, Lax$2;->d:Lorg/apache/http/protocol/HttpContext;

    invoke-interface {v0, v1, v2}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    iput-object v0, p0, Lax$2;->b:Lorg/apache/http/HttpResponse;

    .line 184
    iget-object v0, p0, Lax$2;->b:Lorg/apache/http/HttpResponse;

    return-object v0
.end method
