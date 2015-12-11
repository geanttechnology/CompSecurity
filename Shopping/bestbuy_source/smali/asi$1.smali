.class Lasi$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lasi;->a(Ljava/util/List;J)V
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:J

.field final synthetic c:Lasi;


# direct methods
.method constructor <init>(Lasi;Ljava/util/List;J)V
    .locals 1

    iput-object p1, p0, Lasi$1;->c:Lasi;

    iput-object p2, p0, Lasi$1;->a:Ljava/util/List;

    iput-wide p3, p0, Lasi$1;->b:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    iget-object v0, p0, Lasi$1;->c:Lasi;

    iget-object v1, p0, Lasi$1;->a:Ljava/util/List;

    iget-wide v2, p0, Lasi$1;->b:J

    invoke-static {v0, v1, v2, v3}, Lasi;->a(Lasi;Ljava/util/List;J)V

    return-void
.end method
