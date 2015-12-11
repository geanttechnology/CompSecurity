.class Lcom/poshmark/ui/PMContainerActivity$1$1;
.super Ljava/lang/Object;
.source "PMContainerActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/PMContainerActivity$1;->onBackStackChanged()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/PMContainerActivity$1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/PMContainerActivity$1;)V
    .locals 0

    .prologue
    .line 432
    iput-object p1, p0, Lcom/poshmark/ui/PMContainerActivity$1$1;->this$1:Lcom/poshmark/ui/PMContainerActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 435
    iget-object v1, p0, Lcom/poshmark/ui/PMContainerActivity$1$1;->this$1:Lcom/poshmark/ui/PMContainerActivity$1;

    iget-object v1, v1, Lcom/poshmark/ui/PMContainerActivity$1;->this$0:Lcom/poshmark/ui/PMContainerActivity;

    # invokes: Lcom/poshmark/ui/PMContainerActivity;->getTopFragmentFromBackStack()Lcom/poshmark/ui/fragments/PMFragment;
    invoke-static {v1}, Lcom/poshmark/ui/PMContainerActivity;->access$000(Lcom/poshmark/ui/PMContainerActivity;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v0

    .line 436
    .local v0, "topFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v0, :cond_0

    .line 437
    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->onLoadingComplete()V

    .line 439
    :cond_0
    return-void
.end method
