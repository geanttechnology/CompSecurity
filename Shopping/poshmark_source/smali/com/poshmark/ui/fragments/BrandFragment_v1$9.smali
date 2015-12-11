.class Lcom/poshmark/ui/fragments/BrandFragment_v1$9;
.super Ljava/lang/Object;
.source "BrandFragment_v1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/BrandFragment_v1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V
    .locals 0

    .prologue
    .line 514
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$9;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 517
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 518
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 519
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$9;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 520
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$9;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$9;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$100(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Lcom/poshmark/data_model/models/Brand;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 521
    const-class v2, Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$9;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment_v1;->brand:Lcom/poshmark/data_model/models/Brand;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$100(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Lcom/poshmark/data_model/models/Brand;

    move-result-object v3

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 523
    :cond_0
    return-void
.end method
