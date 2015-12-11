.class Lhy$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhy;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhy;


# direct methods
.method constructor <init>(Lhy;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lhy$1;->a:Lhy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    .line 60
    iget-object v0, p0, Lhy$1;->a:Lhy;

    invoke-static {v0}, Lhy;->a(Lhy;)I

    .line 61
    new-instance v0, Lhy;

    iget-object v1, p0, Lhy$1;->a:Lhy;

    invoke-static {v1}, Lhy;->b(Lhy;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lhy$1;->a:Lhy;

    invoke-static {v2}, Lhy;->c(Lhy;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lhy$1;->a:Lhy;

    invoke-static {v3}, Lhy;->d(Lhy;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lhy$1;->a:Lhy;

    invoke-static {v4}, Lhy;->e(Lhy;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lhy$1;->a:Lhy;

    invoke-static {v5}, Lhy;->f(Lhy;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lhy$1;->a:Lhy;

    invoke-static {v6}, Lhy;->g(Lhy;)Ljava/lang/String;

    move-result-object v6

    invoke-direct/range {v0 .. v6}, Lhy;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    return-void
.end method
