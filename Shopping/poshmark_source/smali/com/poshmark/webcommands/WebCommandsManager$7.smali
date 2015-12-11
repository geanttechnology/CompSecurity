.class Lcom/poshmark/webcommands/WebCommandsManager$7;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->hideHUDForWebView(Lcom/poshmark/webcommands/WebCommand;)V
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
    .line 479
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$7;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 1
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 482
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$7;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->hideProgressDialog()V

    .line 483
    return-void
.end method
