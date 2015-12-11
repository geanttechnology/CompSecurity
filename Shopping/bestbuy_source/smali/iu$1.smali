.class Liu$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Liu;->c()V
.end annotation


# instance fields
.field final synthetic a:Liu;


# direct methods
.method constructor <init>(Liu;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Liu$1;->a:Liu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    .line 61
    invoke-static {}, Liu;->f()I

    .line 62
    new-instance v0, Liu;

    iget-object v1, p0, Liu$1;->a:Liu;

    invoke-static {v1}, Liu;->a(Liu;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Liu$1;->a:Liu;

    invoke-static {v2}, Liu;->b(Liu;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    iget-object v3, p0, Liu$1;->a:Liu;

    invoke-static {v3}, Liu;->c(Liu;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Liu$1;->a:Liu;

    invoke-static {v4}, Liu;->d(Liu;)Landroid/view/View;

    move-result-object v4

    iget-object v5, p0, Liu$1;->a:Liu;

    invoke-static {v5}, Liu;->e(Liu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Liu;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Landroid/view/View;Lcom/bestbuy/android/bbyobjects/BBYWebView;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liu;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 63
    return-void
.end method
