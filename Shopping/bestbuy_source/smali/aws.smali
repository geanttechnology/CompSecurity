.class public final Laws;
.super Lrl;

# interfaces
.implements Latx;


# instance fields
.field private final c:I


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/data/DataHolder;II)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lrl;-><init>(Lcom/google/android/gms/common/data/DataHolder;I)V

    iput p3, p0, Laws;->c:I

    return-void
.end method


# virtual methods
.method public synthetic a()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Laws;->e()Latx;

    move-result-object v0

    return-object v0
.end method

.method public b()Landroid/net/Uri;
    .locals 1

    const-string v0, "path"

    invoke-virtual {p0, v0}, Laws;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public c()[B
    .locals 1

    const-string v0, "data"

    invoke-virtual {p0, v0}, Laws;->c(Ljava/lang/String;)[B

    move-result-object v0

    return-object v0
.end method

.method public d()Ljava/util/Map;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Laty;",
            ">;"
        }
    .end annotation

    new-instance v1, Ljava/util/HashMap;

    iget v0, p0, Laws;->c:I

    invoke-direct {v1, v0}, Ljava/util/HashMap;-><init>(I)V

    const/4 v0, 0x0

    :goto_0
    iget v2, p0, Laws;->c:I

    if-ge v0, v2, :cond_1

    new-instance v2, Lawp;

    iget-object v3, p0, Laws;->a:Lcom/google/android/gms/common/data/DataHolder;

    iget v4, p0, Laws;->b:I

    add-int/2addr v4, v0

    invoke-direct {v2, v3, v4}, Lawp;-><init>(Lcom/google/android/gms/common/data/DataHolder;I)V

    invoke-virtual {v2}, Lawp;->c()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_0

    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    invoke-virtual {v2}, Lawp;->c()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_1
    return-object v1
.end method

.method public e()Latx;
    .locals 1

    new-instance v0, Lawq;

    invoke-direct {v0, p0}, Lawq;-><init>(Latx;)V

    return-object v0
.end method
