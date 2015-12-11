.class public Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;
.super Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;
.source "ConfigApiDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer",
        "<",
        "Ljava/lang/String;",
        "Lcom/disney/datg/videoplatforms/sdk/models/api/Config;",
        ">;"
    }
.end annotation


# static fields
.field protected static CACHE_CAPACITY:I

.field protected static CACHE_CONTAINER:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const/16 v0, 0x64

    sput v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;->CACHE_CAPACITY:I

    .line 18
    const-string v0, "Config"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;->CACHE_CONTAINER:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    .prologue
    .line 21
    const/4 v0, 0x0

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;->CACHE_CONTAINER:Ljava/lang/String;

    sget v2, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;->CACHE_CAPACITY:I

    const-class v3, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;-><init>(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;)V

    .line 22
    return-void
.end method


# virtual methods
.method public executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    .locals 1
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/Request",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Config;",
            ">;I",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Config;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Config;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 42
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    .local p3, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    invoke-super {p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
