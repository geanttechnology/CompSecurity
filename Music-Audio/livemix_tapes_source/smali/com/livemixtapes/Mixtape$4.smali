.class Lcom/livemixtapes/Mixtape$4;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;

    .line 341
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Mixtape$4;)Lcom/livemixtapes/Mixtape;
    .locals 1

    .prologue
    .line 341
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 344
    sget-boolean v3, Lcom/livemixtapes/App;->isUnzipping:Z

    if-eqz v3, :cond_0

    .line 350
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    check-cast v3, Lcom/livemixtapes/ui/BaseActivity;

    new-instance v4, Lcom/livemixtapes/Mixtape$4$1;

    invoke-direct {v4, p0}, Lcom/livemixtapes/Mixtape$4$1;-><init>(Lcom/livemixtapes/Mixtape$4;)V

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ui/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 447
    :goto_0
    return-void

    .line 380
    :cond_0
    invoke-static {}, Lcom/livemixtapes/User;->isGuest()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 382
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;

    # invokes: Lcom/livemixtapes/Mixtape;->showGuestWarning()V
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$0(Lcom/livemixtapes/Mixtape;)V

    goto :goto_0

    .line 386
    :cond_1
    const/4 v3, 0x1

    sput-boolean v3, Lcom/livemixtapes/App;->isUnzipping:Z

    .line 390
    sget-object v3, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-string v4, "layout_inflater"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/LayoutInflater;

    const v4, 0x7f03001f

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 393
    .local v2, "downloadZipView":Landroid/view/View;
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-direct {v1, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 394
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    const-string v3, ""

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 395
    invoke-virtual {v3, v6}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 397
    invoke-virtual {v3, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 405
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 410
    .local v0, "alert":Landroid/app/AlertDialog;
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v4, p0, Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v4, v4, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v5, "id"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/livemixtapes/Mixtape;->downloadMixtapeZip(Ljava/lang/String;Landroid/view/View;Landroid/app/AlertDialog;)V
    invoke-static {v3, v4, v2, v0}, Lcom/livemixtapes/Mixtape;->access$1(Lcom/livemixtapes/Mixtape;Ljava/lang/String;Landroid/view/View;Landroid/app/AlertDialog;)V

    .line 417
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$4;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    check-cast v3, Lcom/livemixtapes/ui/BaseActivity;

    new-instance v4, Lcom/livemixtapes/Mixtape$4$2;

    invoke-direct {v4, p0}, Lcom/livemixtapes/Mixtape$4$2;-><init>(Lcom/livemixtapes/Mixtape$4;)V

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ui/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
