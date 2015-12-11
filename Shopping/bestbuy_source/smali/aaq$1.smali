.class Laaq$1;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Laaq;->a()V
.end annotation


# instance fields
.field final synthetic a:Labd;

.field final synthetic b:Laaq;


# direct methods
.method constructor <init>(Laaq;Labd;)V
    .locals 0

    iput-object p1, p0, Laaq$1;->b:Laaq;

    iput-object p2, p0, Laaq$1;->a:Labd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Laaq$1;->b:Laaq;

    invoke-static {v0}, Laaq;->a(Laaq;)Laab;

    move-result-object v0

    iget-object v1, p0, Laaq$1;->a:Labd;

    invoke-interface {v0, v1}, Laab;->a(Labd;)V

    return-void
.end method
