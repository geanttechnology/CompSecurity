.class final Lax$1;
.super Lay;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lax;
.end annotation


# instance fields
.field private synthetic c:Lorg/apache/http/client/methods/HttpUriRequest;


# direct methods
.method constructor <init>(Lax;Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/methods/HttpUriRequest;)V
    .locals 0

    .prologue
    .line 168
    iput-object p4, p0, Lax$1;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    invoke-direct {p0, p1, p2, p3}, Lay;-><init>(Lax;Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)V

    return-void
.end method


# virtual methods
.method protected final a()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 171
    iget-object v0, p0, Lax$1;->a:Lorg/apache/http/client/HttpClient;

    iget-object v1, p0, Lax$1;->c:Lorg/apache/http/client/methods/HttpUriRequest;

    invoke-interface {v0, v1}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    iput-object v0, p0, Lax$1;->b:Lorg/apache/http/HttpResponse;

    .line 172
    iget-object v0, p0, Lax$1;->b:Lorg/apache/http/HttpResponse;

    return-object v0
.end method
