.class Lrs$7;
.super Ljava/lang/Object;

# interfaces
.implements Lrt;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lrs;->c()V
.end annotation


# instance fields
.field final synthetic a:Lrs;


# direct methods
.method constructor <init>(Lrs;)V
    .locals 0

    iput-object p1, p0, Lrs$7;->a:Lrs;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    const/4 v0, 0x5

    return v0
.end method

.method public a(Lrr;)V
    .locals 1

    iget-object v0, p0, Lrs$7;->a:Lrs;

    invoke-static {v0}, Lrs;->b(Lrs;)Lrr;

    move-result-object v0

    invoke-interface {v0}, Lrr;->b()V

    return-void
.end method
