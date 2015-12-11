.class Lcom/poshmark/webcommands/WebCommandsManager$3;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->removeRightNavButton(Lcom/poshmark/webcommands/WebCommand;)V
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
    .line 405
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$3;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 2
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 408
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$3;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->hideAllActionButtons(Z)V

    .line 409
    return-void
.end method
