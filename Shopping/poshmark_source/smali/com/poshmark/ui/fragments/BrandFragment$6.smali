.class Lcom/poshmark/ui/fragments/BrandFragment$6;
.super Ljava/lang/Object;
.source "BrandFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment;->setupHeaderViewHolder(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandFragment;)V
    .locals 0

    .prologue
    .line 349
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment$6;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 352
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$6;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    const-string v1, ""

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment$6;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/BrandFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0602a5

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/BrandFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 353
    return-void
.end method
