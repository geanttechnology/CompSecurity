.class Lcom/poshmark/webcommands/WebCommandsManager$9;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->closeTillPageAndPushWebView(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$command:Lcom/poshmark/webcommands/WebCommand;

.field final synthetic val$pageName:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0

    .prologue
    .line 614
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$9;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$9;->val$pageName:Ljava/lang/String;

    iput-object p3, p0, Lcom/poshmark/webcommands/WebCommandsManager$9;->val$command:Lcom/poshmark/webcommands/WebCommand;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 2
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 617
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$9;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$9;->val$pageName:Ljava/lang/String;

    # invokes: Lcom/poshmark/webcommands/WebCommandsManager;->closeTillPage(Ljava/lang/String;)Z
    invoke-static {v0, v1}, Lcom/poshmark/webcommands/WebCommandsManager;->access$100(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 618
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$9;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$9;->val$command:Lcom/poshmark/webcommands/WebCommand;

    # invokes: Lcom/poshmark/webcommands/WebCommandsManager;->pushWebView(Lcom/poshmark/webcommands/WebCommand;)V
    invoke-static {v0, v1}, Lcom/poshmark/webcommands/WebCommandsManager;->access$200(Lcom/poshmark/webcommands/WebCommandsManager;Lcom/poshmark/webcommands/WebCommand;)V

    .line 619
    :cond_0
    return-void
.end method
