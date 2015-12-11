.class Lcom/poshmark/ui/fragments/BrandFragment_v1$3;
.super Ljava/lang/Object;
.source "BrandFragment_v1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment_v1;->setupHeaderViewHolder(Landroid/view/View;)V
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
    .line 268
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$3;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 271
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 272
    .local v1, "bundle":Landroid/os/Bundle;
    const-string v2, "NAME"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$3;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$200(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 273
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$3;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 275
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    const-class v2, Lcom/poshmark/ui/fragments/BrandFragment_v1;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMContainerActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 276
    return-void
.end method
