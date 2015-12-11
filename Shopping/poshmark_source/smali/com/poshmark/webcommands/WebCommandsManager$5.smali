.class Lcom/poshmark/webcommands/WebCommandsManager$5;
.super Lcom/poshmark/webcommands/CommandCompletionHandler;
.source "WebCommandsManager.java"


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
    .line 447
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$5;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-direct {p0}, Lcom/poshmark/webcommands/CommandCompletionHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Lcom/poshmark/webcommands/WebCommand;Landroid/content/Intent;)V
    .locals 2
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/MappPageFragment;
    .param p2, "command"    # Lcom/poshmark/webcommands/WebCommand;
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 449
    instance-of v0, p1, Lcom/poshmark/ui/fragments/MappPageFragment;

    if-eqz v0, :cond_0

    .line 450
    iget-object v0, p2, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v1, "callbackMethod"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->fireJSCallback(Ljava/lang/String;)V

    .line 452
    :cond_0
    return-void
.end method
