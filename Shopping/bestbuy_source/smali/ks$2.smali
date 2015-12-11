.class Lks$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lks;->a()V
.end annotation


# instance fields
.field final synthetic a:Lks;


# direct methods
.method constructor <init>(Lks;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lks$2;->a:Lks;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 6

    .prologue
    .line 43
    new-instance v0, Ljc;

    iget-object v1, p0, Lks$2;->a:Lks;

    invoke-static {v1}, Lks;->a(Lks;)Landroid/content/Context;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lks$2;->a:Lks;

    invoke-static {v2}, Lks;->b(Lks;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/base/BBYBaseFragment;

    const/4 v3, 0x0

    iget-object v4, p0, Lks$2;->a:Lks;

    invoke-static {v4}, Lks;->c(Lks;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lks$2;->a:Lks;

    invoke-static {v5}, Lks;->d(Lks;)Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Ljc;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljc;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 44
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 45
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 46
    const-string v1, "List Type"

    iget-object v2, p0, Lks$2;->a:Lks;

    invoke-static {v2}, Lks;->c(Lks;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    const-string v1, "List UUID"

    iget-object v2, p0, Lks$2;->a:Lks;

    invoke-static {v2}, Lks;->d(Lks;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    sget-object v1, Llu;->Q:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 49
    return-void
.end method
