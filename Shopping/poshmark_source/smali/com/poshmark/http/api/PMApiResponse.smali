.class public Lcom/poshmark/http/api/PMApiResponse;
.super Lcom/poshmark/http/PMHttpResponse;
.source "PMApiResponse.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/poshmark/http/PMHttpResponse;"
    }
.end annotation


# instance fields
.field public final apiError:Lcom/poshmark/http/api/PMApiError;

.field public final apiRequest:Lcom/poshmark/http/api/PMApiRequest;

.field public final data:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field public final headerArray:[Lorg/apache/http/Header;


# direct methods
.method public constructor <init>(I[Lorg/apache/http/Header;Ljava/lang/String;Ljava/lang/Object;Lcom/poshmark/http/api/PMApiRequest;Lcom/poshmark/http/api/PMApiError;)V
    .locals 6
    .param p1, "httpCode"    # I
    .param p2, "headerArray"    # [Lorg/apache/http/Header;
    .param p3, "responseString"    # Ljava/lang/String;
    .param p5, "apiRequest"    # Lcom/poshmark/http/api/PMApiRequest;
    .param p6, "apiError"    # Lcom/poshmark/http/api/PMApiError;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[",
            "Lorg/apache/http/Header;",
            "Ljava/lang/String;",
            "TT;",
            "Lcom/poshmark/http/api/PMApiRequest;",
            "Lcom/poshmark/http/api/PMApiError;",
            ")V"
        }
    .end annotation

    .prologue
    .line 20
    .local p0, "this":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<TT;>;"
    .local p4, "data":Ljava/lang/Object;, "TT;"
    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Lcom/poshmark/http/PMHttpResponse;-><init>(I[Lorg/apache/http/Header;Ljava/lang/String;Lcom/poshmark/http/PMHttpRequest;Lcom/poshmark/http/PMHttpError;)V

    .line 22
    iput-object p4, p0, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    .line 23
    iput-object p5, p0, Lcom/poshmark/http/api/PMApiResponse;->apiRequest:Lcom/poshmark/http/api/PMApiRequest;

    .line 24
    iput-object p6, p0, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    .line 25
    iput-object p2, p0, Lcom/poshmark/http/api/PMApiResponse;->headerArray:[Lorg/apache/http/Header;

    .line 26
    return-void
.end method
