.class public abstract Lcom/comcast/cim/utils/EitherJacksonMixIn;
.super Ljava/lang/Object;
.source "EitherJacksonMixIn.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonSubTypes;
    value = {
        .subannotation Lcom/fasterxml/jackson/annotation/JsonSubTypes$Type;
            name = "left"
            value = Lcom/comcast/cim/cmasl/utils/container/LeftEither;
        .end subannotation,
        .subannotation Lcom/fasterxml/jackson/annotation/JsonSubTypes$Type;
            name = "right"
            value = Lcom/comcast/cim/cmasl/utils/container/RightEither;
        .end subannotation
    }
.end annotation

.annotation runtime Lcom/fasterxml/jackson/annotation/JsonTypeInfo;
    include = .enum Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;->PROPERTY:Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;
    property = "type"
    use = .enum Lcom/fasterxml/jackson/annotation/JsonTypeInfo$Id;->NAME:Lcom/fasterxml/jackson/annotation/JsonTypeInfo$Id;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/utils/EitherJacksonMixIn$RightEitherMixIn;,
        Lcom/comcast/cim/utils/EitherJacksonMixIn$LeftEitherMixIn;
    }
.end annotation


# static fields
.field public static final MIX_IN_CONFIG:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/Class",
            "<*>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 23
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    .line 24
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class<*>;Ljava/lang/Class<*>;>;"
    const-class v1, Lcom/comcast/cim/cmasl/utils/container/Either;

    const-class v2, Lcom/comcast/cim/utils/EitherJacksonMixIn;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    const-class v1, Lcom/comcast/cim/cmasl/utils/container/LeftEither;

    const-class v2, Lcom/comcast/cim/utils/EitherJacksonMixIn$LeftEitherMixIn;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    const-class v1, Lcom/comcast/cim/cmasl/utils/container/RightEither;

    const-class v2, Lcom/comcast/cim/utils/EitherJacksonMixIn$RightEitherMixIn;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    sput-object v1, Lcom/comcast/cim/utils/EitherJacksonMixIn;->MIX_IN_CONFIG:Ljava/util/Map;

    .line 28
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    return-void
.end method
