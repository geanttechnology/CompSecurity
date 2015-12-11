.class Lcom/poshmark/webcommands/WebCommandsManager$12$1$1;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager$12$1;->handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/poshmark/webcommands/WebCommandsManager$12$1;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager$12$1;)V
    .locals 0

    .prologue
    .line 738
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1$1;->this$2:Lcom/poshmark/webcommands/WebCommandsManager$12$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 741
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$12$1$1;->this$2:Lcom/poshmark/webcommands/WebCommandsManager$12$1;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager$12$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$12;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->reload()V

    .line 742
    return-void
.end method
