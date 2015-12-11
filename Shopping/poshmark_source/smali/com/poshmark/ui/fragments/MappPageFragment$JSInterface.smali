.class public Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;
.super Ljava/lang/Object;
.source "MappPageFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/MappPageFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "JSInterface"
.end annotation


# instance fields
.field mContext:Landroid/content/Context;

.field final synthetic this$0:Lcom/poshmark/ui/fragments/MappPageFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MappPageFragment;Landroid/content/Context;)V
    .locals 0
    .param p2, "c"    # Landroid/content/Context;

    .prologue
    .line 399
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 400
    iput-object p2, p0, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;->mContext:Landroid/content/Context;

    .line 401
    return-void
.end method


# virtual methods
.method public executeCommand(Ljava/lang/String;)V
    .locals 2
    .param p1, "commandString"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 405
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/MappPageFragment;->commandsManager:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-virtual {v1, p1}, Lcom/poshmark/webcommands/WebCommandsManager;->launchWebCommand(Ljava/lang/String;)V

    .line 406
    new-instance v0, Lcom/poshmark/utils/UIThreadTask;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;->this$0:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/UIThreadTask;-><init>(Lcom/poshmark/ui/PMActivity;)V

    .line 407
    .local v0, "task":Lcom/poshmark/utils/UIThreadTask;
    new-instance v1, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface$1;-><init>(Lcom/poshmark/ui/fragments/MappPageFragment$JSInterface;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/UIThreadTask;->setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V

    .line 413
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V

    .line 416
    return-void
.end method
