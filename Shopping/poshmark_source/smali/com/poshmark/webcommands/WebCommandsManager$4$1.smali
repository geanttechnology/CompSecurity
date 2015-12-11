.class Lcom/poshmark/webcommands/WebCommandsManager$4$1;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager$4;->runOnUIThread(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/webcommands/WebCommandsManager$4;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager$4;)V
    .locals 0

    .prologue
    .line 435
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$4$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 438
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/webcommands/WebCommand;

    move-object v0, v1

    check-cast v0, Lcom/poshmark/webcommands/WebCommand;

    .line 439
    .local v0, "command":Lcom/poshmark/webcommands/WebCommand;
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$4$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$4;

    iget-object v1, v1, Lcom/poshmark/webcommands/WebCommandsManager$4;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v1, v1, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/webcommands/WebCommand;->handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Landroid/content/Intent;)V

    .line 440
    return-void
.end method
