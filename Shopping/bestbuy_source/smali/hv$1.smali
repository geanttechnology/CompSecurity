.class Lhv$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhv;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhv;


# direct methods
.method constructor <init>(Lhv;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lhv$1;->a:Lhv;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    .line 66
    iget-object v0, p0, Lhv$1;->a:Lhv;

    invoke-static {v0}, Lhv;->a(Lhv;)I

    .line 67
    new-instance v0, Lhv;

    iget-object v1, p0, Lhv$1;->a:Lhv;

    invoke-static {v1}, Lhv;->b(Lhv;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lhv$1;->a:Lhv;

    invoke-static {v2}, Lhv;->c(Lhv;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lhv$1;->a:Lhv;

    invoke-static {v3}, Lhv;->d(Lhv;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lhv$1;->a:Lhv;

    invoke-static {v4}, Lhv;->e(Lhv;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lhv$1;->a:Lhv;

    invoke-static {v5}, Lhv;->f(Lhv;)Landroid/os/Bundle;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lhv;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 68
    return-void
.end method
