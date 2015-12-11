.class Lorg/simpleframework/xml/core/ExpressionBuilder;
.super Ljava/lang/Object;
.source "ExpressionBuilder.java"


# instance fields
.field private final cache:Lorg/simpleframework/xml/util/Cache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/simpleframework/xml/util/Cache",
            "<",
            "Lorg/simpleframework/xml/core/Expression;",
            ">;"
        }
    .end annotation
.end field

.field private final format:Lorg/simpleframework/xml/stream/Format;

.field private final type:Lorg/simpleframework/xml/strategy/Type;


# direct methods
.method public constructor <init>(Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/Class;
    .param p2, "format"    # Lorg/simpleframework/xml/stream/Format;

    .prologue
    .line 64
    new-instance v0, Lorg/simpleframework/xml/core/ClassType;

    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/ClassType;-><init>(Ljava/lang/Class;)V

    invoke-direct {p0, v0, p2}, Lorg/simpleframework/xml/core/ExpressionBuilder;-><init>(Lorg/simpleframework/xml/strategy/Type;Lorg/simpleframework/xml/stream/Format;)V

    .line 65
    return-void
.end method

.method public constructor <init>(Lorg/simpleframework/xml/strategy/Type;Lorg/simpleframework/xml/stream/Format;)V
    .locals 1
    .param p1, "type"    # Lorg/simpleframework/xml/strategy/Type;
    .param p2, "format"    # Lorg/simpleframework/xml/stream/Format;

    .prologue
    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    new-instance v0, Lorg/simpleframework/xml/util/LimitedCache;

    invoke-direct {v0}, Lorg/simpleframework/xml/util/LimitedCache;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ExpressionBuilder;->cache:Lorg/simpleframework/xml/util/Cache;

    .line 77
    iput-object p2, p0, Lorg/simpleframework/xml/core/ExpressionBuilder;->format:Lorg/simpleframework/xml/stream/Format;

    .line 78
    iput-object p1, p0, Lorg/simpleframework/xml/core/ExpressionBuilder;->type:Lorg/simpleframework/xml/strategy/Type;

    .line 79
    return-void
.end method

.method private create(Ljava/lang/String;)Lorg/simpleframework/xml/core/Expression;
    .locals 3
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 110
    new-instance v0, Lorg/simpleframework/xml/core/PathParser;

    iget-object v1, p0, Lorg/simpleframework/xml/core/ExpressionBuilder;->type:Lorg/simpleframework/xml/strategy/Type;

    iget-object v2, p0, Lorg/simpleframework/xml/core/ExpressionBuilder;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-direct {v0, p1, v1, v2}, Lorg/simpleframework/xml/core/PathParser;-><init>(Ljava/lang/String;Lorg/simpleframework/xml/strategy/Type;Lorg/simpleframework/xml/stream/Format;)V

    .line 112
    .local v0, "expression":Lorg/simpleframework/xml/core/Expression;
    iget-object v1, p0, Lorg/simpleframework/xml/core/ExpressionBuilder;->cache:Lorg/simpleframework/xml/util/Cache;

    if-eqz v1, :cond_0

    .line 113
    iget-object v1, p0, Lorg/simpleframework/xml/core/ExpressionBuilder;->cache:Lorg/simpleframework/xml/util/Cache;

    invoke-interface {v1, p1, v0}, Lorg/simpleframework/xml/util/Cache;->cache(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 115
    :cond_0
    return-object v0
.end method


# virtual methods
.method public build(Ljava/lang/String;)Lorg/simpleframework/xml/core/Expression;
    .locals 2
    .param p1, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 92
    iget-object v1, p0, Lorg/simpleframework/xml/core/ExpressionBuilder;->cache:Lorg/simpleframework/xml/util/Cache;

    invoke-interface {v1, p1}, Lorg/simpleframework/xml/util/Cache;->fetch(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/core/Expression;

    .line 94
    .local v0, "expression":Lorg/simpleframework/xml/core/Expression;
    if-nez v0, :cond_0

    .line 95
    invoke-direct {p0, p1}, Lorg/simpleframework/xml/core/ExpressionBuilder;->create(Ljava/lang/String;)Lorg/simpleframework/xml/core/Expression;

    move-result-object v0

    .line 97
    .end local v0    # "expression":Lorg/simpleframework/xml/core/Expression;
    :cond_0
    return-object v0
.end method
