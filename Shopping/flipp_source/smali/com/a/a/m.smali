.class final Lcom/a/a/m;
.super Ljava/net/CacheResponse;
.source "SourceFile"


# instance fields
.field private final a:Lcom/a/a/l;

.field private final b:Lcom/a/a/a/i;

.field private final c:Ljava/io/InputStream;


# direct methods
.method public constructor <init>(Lcom/a/a/l;Lcom/a/a/a/i;)V
    .locals 1

    .prologue
    .line 680
    invoke-direct {p0}, Ljava/net/CacheResponse;-><init>()V

    .line 681
    iput-object p1, p0, Lcom/a/a/m;->a:Lcom/a/a/l;

    .line 682
    iput-object p2, p0, Lcom/a/a/m;->b:Lcom/a/a/a/i;

    .line 683
    invoke-static {p2}, Lcom/a/a/f;->a(Lcom/a/a/a/i;)Ljava/io/InputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/m;->c:Ljava/io/InputStream;

    .line 684
    return-void
.end method

.method static synthetic a(Lcom/a/a/m;)Lcom/a/a/a/i;
    .locals 1

    .prologue
    .line 675
    iget-object v0, p0, Lcom/a/a/m;->b:Lcom/a/a/a/i;

    return-object v0
.end method


# virtual methods
.method public final getBody()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 691
    iget-object v0, p0, Lcom/a/a/m;->c:Ljava/io/InputStream;

    return-object v0
.end method

.method public final getHeaders()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 687
    iget-object v0, p0, Lcom/a/a/m;->a:Lcom/a/a/l;

    iget-object v0, v0, Lcom/a/a/l;->d:Lcom/a/a/a/a/v;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->a(Z)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method
