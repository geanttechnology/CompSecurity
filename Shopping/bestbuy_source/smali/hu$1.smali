.class Lhu$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhu;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhu;


# direct methods
.method constructor <init>(Lhu;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lhu$1;->a:Lhu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    .line 60
    iget-object v0, p0, Lhu$1;->a:Lhu;

    invoke-static {v0}, Lhu;->a(Lhu;)I

    .line 61
    new-instance v0, Lhu;

    iget-object v1, p0, Lhu$1;->a:Lhu;

    invoke-static {v1}, Lhu;->b(Lhu;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lhu$1;->a:Lhu;

    invoke-static {v2}, Lhu;->c(Lhu;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lhu$1;->a:Lhu;

    invoke-static {v3}, Lhu;->d(Lhu;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lhu$1;->a:Lhu;

    invoke-static {v4}, Lhu;->e(Lhu;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lhu$1;->a:Lhu;

    invoke-static {v5}, Lhu;->f(Lhu;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lhu$1;->a:Lhu;

    invoke-static {v6}, Lhu;->g(Lhu;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lhu$1;->a:Lhu;

    invoke-static {v7}, Lhu;->h(Lhu;)Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lhu$1;->a:Lhu;

    invoke-static {v8}, Lhu;->i(Lhu;)Ljava/lang/String;

    move-result-object v8

    invoke-direct/range {v0 .. v8}, Lhu;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    return-void
.end method
