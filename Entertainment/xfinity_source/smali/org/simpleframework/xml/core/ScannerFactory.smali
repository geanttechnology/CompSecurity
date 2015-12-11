.class Lorg/simpleframework/xml/core/ScannerFactory;
.super Ljava/lang/Object;
.source "ScannerFactory.java"


# instance fields
.field private final cache:Lorg/simpleframework/xml/util/Cache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/simpleframework/xml/util/Cache",
            "<",
            "Lorg/simpleframework/xml/core/Scanner;",
            ">;"
        }
    .end annotation
.end field

.field private final format:Lorg/simpleframework/xml/stream/Format;

.field private final support:Lorg/simpleframework/xml/core/Support;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/core/Support;Lorg/simpleframework/xml/stream/Format;)V
    .locals 1
    .param p1, "support"    # Lorg/simpleframework/xml/core/Support;
    .param p2, "format"    # Lorg/simpleframework/xml/stream/Format;

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    new-instance v0, Lorg/simpleframework/xml/util/ConcurrentCache;

    invoke-direct {v0}, Lorg/simpleframework/xml/util/ConcurrentCache;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/core/ScannerFactory;->cache:Lorg/simpleframework/xml/util/Cache;

    .line 63
    iput-object p1, p0, Lorg/simpleframework/xml/core/ScannerFactory;->support:Lorg/simpleframework/xml/core/Support;

    .line 64
    iput-object p2, p0, Lorg/simpleframework/xml/core/ScannerFactory;->format:Lorg/simpleframework/xml/stream/Format;

    .line 65
    return-void
.end method


# virtual methods
.method public getInstance(Ljava/lang/Class;)Lorg/simpleframework/xml/core/Scanner;
    .locals 2
    .param p1, "type"    # Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 81
    iget-object v1, p0, Lorg/simpleframework/xml/core/ScannerFactory;->cache:Lorg/simpleframework/xml/util/Cache;

    invoke-interface {v1, p1}, Lorg/simpleframework/xml/util/Cache;->fetch(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/simpleframework/xml/core/Scanner;

    .line 83
    .local v0, "schema":Lorg/simpleframework/xml/core/Scanner;
    if-nez v0, :cond_0

    .line 84
    iget-object v1, p0, Lorg/simpleframework/xml/core/ScannerFactory;->support:Lorg/simpleframework/xml/core/Support;

    invoke-virtual {v1, p1}, Lorg/simpleframework/xml/core/Support;->isPrimitive(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 85
    new-instance v0, Lorg/simpleframework/xml/core/PrimitiveScanner;

    .end local v0    # "schema":Lorg/simpleframework/xml/core/Scanner;
    invoke-direct {v0, p1}, Lorg/simpleframework/xml/core/PrimitiveScanner;-><init>(Ljava/lang/Class;)V

    .line 89
    .restart local v0    # "schema":Lorg/simpleframework/xml/core/Scanner;
    :goto_0
    iget-object v1, p0, Lorg/simpleframework/xml/core/ScannerFactory;->cache:Lorg/simpleframework/xml/util/Cache;

    invoke-interface {v1, p1, v0}, Lorg/simpleframework/xml/util/Cache;->cache(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 91
    :cond_0
    return-object v0

    .line 87
    :cond_1
    new-instance v0, Lorg/simpleframework/xml/core/ObjectScanner;

    .end local v0    # "schema":Lorg/simpleframework/xml/core/Scanner;
    iget-object v1, p0, Lorg/simpleframework/xml/core/ScannerFactory;->format:Lorg/simpleframework/xml/stream/Format;

    invoke-direct {v0, p1, v1}, Lorg/simpleframework/xml/core/ObjectScanner;-><init>(Ljava/lang/Class;Lorg/simpleframework/xml/stream/Format;)V

    .restart local v0    # "schema":Lorg/simpleframework/xml/core/Scanner;
    goto :goto_0
.end method
