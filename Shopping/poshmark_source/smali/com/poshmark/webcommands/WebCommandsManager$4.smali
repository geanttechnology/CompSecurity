.class Lcom/poshmark/webcommands/WebCommandsManager$4;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->setNavRightButton(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;)V
    .locals 0

    .prologue
    .line 421
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$4;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 5
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 425
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager$4;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v3, v3, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/MappPageFragment;->hideAllActionButtons(Z)V

    move-object v0, p1

    .line 427
    check-cast v0, Lcom/poshmark/webcommands/WebCommand;

    .line 428
    .local v0, "command":Lcom/poshmark/webcommands/WebCommand;
    iget-object v3, p0, Lcom/poshmark/webcommands/WebCommandsManager$4;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v3, v3, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MappPageFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v1

    .line 429
    .local v1, "nextButton":Landroid/widget/Button;
    iget-object v3, v0, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v4, "title"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 430
    .local v2, "title":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 431
    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 434
    :cond_0
    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 435
    new-instance v3, Lcom/poshmark/webcommands/WebCommandsManager$4$1;

    invoke-direct {v3, p0}, Lcom/poshmark/webcommands/WebCommandsManager$4$1;-><init>(Lcom/poshmark/webcommands/WebCommandsManager$4;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 443
    return-void
.end method
