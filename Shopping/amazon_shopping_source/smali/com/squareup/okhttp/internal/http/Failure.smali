.class public final Lcom/squareup/okhttp/internal/http/Failure;
.super Ljava/lang/Object;
.source "Failure.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/okhttp/internal/http/Failure$1;,
        Lcom/squareup/okhttp/internal/http/Failure$Builder;
    }
.end annotation


# instance fields
.field private final exception:Ljava/lang/Throwable;

.field private final request:Lcom/squareup/okhttp/internal/http/Request;


# direct methods
.method private constructor <init>(Lcom/squareup/okhttp/internal/http/Failure$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/squareup/okhttp/internal/http/Failure$Builder;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    # getter for: Lcom/squareup/okhttp/internal/http/Failure$Builder;->request:Lcom/squareup/okhttp/internal/http/Request;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Failure$Builder;->access$000(Lcom/squareup/okhttp/internal/http/Failure$Builder;)Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Failure;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 27
    # getter for: Lcom/squareup/okhttp/internal/http/Failure$Builder;->exception:Ljava/lang/Throwable;
    invoke-static {p1}, Lcom/squareup/okhttp/internal/http/Failure$Builder;->access$100(Lcom/squareup/okhttp/internal/http/Failure$Builder;)Ljava/lang/Throwable;

    move-result-object v0

    iput-object v0, p0, Lcom/squareup/okhttp/internal/http/Failure;->exception:Ljava/lang/Throwable;

    .line 28
    return-void
.end method

.method synthetic constructor <init>(Lcom/squareup/okhttp/internal/http/Failure$Builder;Lcom/squareup/okhttp/internal/http/Failure$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/squareup/okhttp/internal/http/Failure$Builder;
    .param p2, "x1"    # Lcom/squareup/okhttp/internal/http/Failure$1;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/squareup/okhttp/internal/http/Failure;-><init>(Lcom/squareup/okhttp/internal/http/Failure$Builder;)V

    return-void
.end method


# virtual methods
.method public exception()Ljava/lang/Throwable;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Failure;->exception:Ljava/lang/Throwable;

    return-object v0
.end method

.method public request()Lcom/squareup/okhttp/internal/http/Request;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Failure;->request:Lcom/squareup/okhttp/internal/http/Request;

    return-object v0
.end method
