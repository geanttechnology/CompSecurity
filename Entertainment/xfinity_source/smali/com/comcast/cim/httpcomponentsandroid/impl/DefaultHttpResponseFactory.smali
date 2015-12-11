.class public Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpResponseFactory;
.super Ljava/lang/Object;
.source "DefaultHttpResponseFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponseFactory;


# instance fields
.field protected final reasonCatalog:Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/EnglishReasonPhraseCatalog;->INSTANCE:Lcom/comcast/cim/httpcomponentsandroid/impl/EnglishReasonPhraseCatalog;

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpResponseFactory;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;)V

    .line 72
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;)V
    .locals 2
    .param p1, "catalog"    # Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;

    .prologue
    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    if-nez p1, :cond_0

    .line 60
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Reason phrase catalog must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpResponseFactory;->reasonCatalog:Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;

    .line 64
    return-void
.end method


# virtual methods
.method protected determineLocale(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/Locale;
    .locals 1
    .param p1, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 110
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    return-object v0
.end method

.method public newHttpResponse(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .locals 3
    .param p1, "statusline"    # Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 92
    if-nez p1, :cond_0

    .line 93
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Status line may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 95
    :cond_0
    invoke-virtual {p0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpResponseFactory;->determineLocale(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Ljava/util/Locale;

    move-result-object v0

    .line 96
    .local v0, "loc":Ljava/util/Locale;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpResponseFactory;->reasonCatalog:Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;

    invoke-direct {v1, p1, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;Ljava/util/Locale;)V

    return-object v1
.end method
