.class Lcom/poshmark/utils/ShareManager_Old$2;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/ShareManager_Old;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/ShareManager_Old;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ShareManager_Old;)V
    .locals 0

    .prologue
    .line 199
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old$2;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public dialogDismissed()V
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old$2;->this$0:Lcom/poshmark/utils/ShareManager_Old;

    # getter for: Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v0}, Lcom/poshmark/utils/ShareManager_Old;->access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 203
    return-void
.end method
