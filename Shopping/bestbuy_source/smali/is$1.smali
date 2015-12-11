.class Lis$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lis;->c()V
.end annotation


# instance fields
.field final synthetic a:Lis;


# direct methods
.method constructor <init>(Lis;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lis$1;->a:Lis;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 41
    iget-object v0, p0, Lis$1;->a:Lis;

    invoke-static {v0}, Lis;->a(Lis;)I

    .line 42
    new-instance v0, Lis;

    iget-object v1, p0, Lis$1;->a:Lis;

    invoke-static {v1}, Lis;->b(Lis;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lis$1;->a:Lis;

    invoke-static {v2}, Lis;->c(Lis;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lis;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 43
    return-void
.end method
