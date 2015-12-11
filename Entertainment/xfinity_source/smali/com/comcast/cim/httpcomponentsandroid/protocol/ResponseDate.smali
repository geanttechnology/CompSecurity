.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/ResponseDate;
.super Ljava/lang/Object;
.source "ResponseDate.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;


# static fields
.field private static final DATE_GENERATOR:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpDateGenerator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpDateGenerator;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpDateGenerator;-><init>()V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/protocol/ResponseDate;->DATE_GENERATOR:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpDateGenerator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 4
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 54
    if-nez p1, :cond_0

    .line 55
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "HTTP response may not be null."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 58
    :cond_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v1

    .line 59
    .local v1, "status":I
    const/16 v2, 0xc8

    if-lt v1, v2, :cond_1

    const-string v2, "Date"

    invoke-interface {p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->containsHeader(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 61
    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/protocol/ResponseDate;->DATE_GENERATOR:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpDateGenerator;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpDateGenerator;->getCurrentDate()Ljava/lang/String;

    move-result-object v0

    .line 62
    .local v0, "httpdate":Ljava/lang/String;
    const-string v2, "Date"

    invoke-interface {p1, v2, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    .end local v0    # "httpdate":Ljava/lang/String;
    :cond_1
    return-void
.end method
