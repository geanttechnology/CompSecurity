.class Lcom/poshmark/utils/PoshLearnDialog$1;
.super Ljava/lang/Object;
.source "PoshLearnDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/PoshLearnDialog;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/PoshLearnDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/PoshLearnDialog;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/poshmark/utils/PoshLearnDialog$1;->this$0:Lcom/poshmark/utils/PoshLearnDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 41
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalPartiesController;->enablePartyAlerts()V

    .line 42
    iget-object v0, p0, Lcom/poshmark/utils/PoshLearnDialog$1;->this$0:Lcom/poshmark/utils/PoshLearnDialog;

    invoke-virtual {v0}, Lcom/poshmark/utils/PoshLearnDialog;->dismiss()V

    .line 43
    return-void
.end method
