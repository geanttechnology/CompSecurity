.class Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$1;
.super Ljava/util/HashMap;
.source "CacheableApiDeserializer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

.field final synthetic val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;Lcom/disney/datg/videoplatforms/sdk/service/Request;)V
    .locals 2

    .prologue
    .line 108
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$1;, "Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer.1;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$1;->this$0:Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer;

    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$1;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 110
    const-string v0, "host"

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$1;->val$request:Lcom/disney/datg/videoplatforms/sdk/service/Request;

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->getServiceUri()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/CacheableApiDeserializer$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    return-void
.end method
