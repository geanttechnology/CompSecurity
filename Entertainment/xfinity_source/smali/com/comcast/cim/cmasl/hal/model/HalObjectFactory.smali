.class public abstract Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;
.super Ljava/lang/Object;
.source "HalObjectFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<R:",
        "Ljava/lang/Object;",
        "T::",
        "Lcom/comcast/cim/cmasl/hal/model/HalParseable;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const-class v0, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;, "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory<TR;TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TR;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TR;>;>;)TT;"
        }
    .end annotation

    .prologue
    .line 14
    .local p0, "this":Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;, "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory<TR;TT;>;"
    .local p2, "halHttpClient":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TR;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TR;>;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;->get()Lcom/comcast/cim/cmasl/hal/model/HalParseable;

    move-result-object v1

    .line 16
    .local v1, "halObject":Lcom/comcast/cim/cmasl/hal/model/HalParseable;, "TT;"
    invoke-virtual {p2, p1}, Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;->fetchMicroData(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v0

    .line 17
    .local v0, "halContent":Lcom/comcast/cim/microdata/model/MicrodataItem;
    new-instance v2, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    invoke-direct {v2, v0}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;-><init>(Lcom/comcast/cim/microdata/model/MicrodataItem;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/hal/model/HalParseable;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 19
    return-object v1
.end method

.method protected abstract get()Lcom/comcast/cim/cmasl/hal/model/HalParseable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation
.end method
