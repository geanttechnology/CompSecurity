.class Lcom/poshmark/webcommands/WebCommandsManager$10;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->closeTillPageAndRefresh(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$pageName:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 628
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$10;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$10;->val$pageName:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 4
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 631
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager$10;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager$10;->val$pageName:Ljava/lang/String;

    # invokes: Lcom/poshmark/webcommands/WebCommandsManager;->closeTillPage(Ljava/lang/String;)Z
    invoke-static {v2, v3}, Lcom/poshmark/webcommands/WebCommandsManager;->access$100(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;)Z

    .line 633
    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager$10;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v2, v2, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    invoke-virtual {v2}, Lcom/poshmark/ui/PMActivity;->getVisibleFragment()Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    .line 634
    .local v0, "fragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v0, :cond_0

    instance-of v2, v0, Lcom/poshmark/ui/fragments/MappPageFragment;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 635
    check-cast v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    .line 636
    .local v1, "mappPageFragment":Lcom/poshmark/ui/fragments/MappPageFragment;
    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->reload()V

    .line 638
    .end local v1    # "mappPageFragment":Lcom/poshmark/ui/fragments/MappPageFragment;
    :cond_0
    return-void
.end method
