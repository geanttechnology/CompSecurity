.class Lasi$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lasi;->a(Laqk;)V
.end annotation


# instance fields
.field final synthetic a:Laqk;

.field final synthetic b:Lasi;


# direct methods
.method constructor <init>(Lasi;Laqk;)V
    .locals 0

    iput-object p1, p0, Lasi$2;->b:Lasi;

    iput-object p2, p0, Lasi$2;->a:Laqk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lasi$2;->a:Laqk;

    iget-object v1, p0, Lasi$2;->b:Lasi;

    invoke-static {v1}, Lasi;->a(Lasi;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Laqk;->a(Ljava/util/List;)V

    return-void
.end method
