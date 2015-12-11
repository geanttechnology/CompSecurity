.class public Lcom/disney/datg/videoplatforms/sdk/service/serialization/GeoApiDeserializer;
.super Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;
.source "GeoApiDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    invoke-direct {p0, v0}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;-><init>(Ljava/lang/Class;)V

    .line 21
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
            "Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;",
            ">;I",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 37
    .local p1, "request":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;"
    .local p3, "asyncHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;"
    invoke-super {p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
