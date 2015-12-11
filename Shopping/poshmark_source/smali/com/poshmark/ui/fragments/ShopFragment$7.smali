.class Lcom/poshmark/ui/fragments/ShopFragment$7;
.super Ljava/lang/Object;
.source "ShopFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ShopFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShopFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShopFragment;)V
    .locals 0

    .prologue
    .line 412
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShopFragment$7;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 415
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;

    .line 416
    .local v0, "buttonInfo":Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;
    if-eqz v0, :cond_0

    .line 417
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment$7;->this$0:Lcom/poshmark/ui/fragments/ShopFragment;

    # invokes: Lcom/poshmark/ui/fragments/ShopFragment;->launchUrl(Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;)V
    invoke-static {v1, v0}, Lcom/poshmark/ui/fragments/ShopFragment;->access$000(Lcom/poshmark/ui/fragments/ShopFragment;Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;)V

    .line 419
    :cond_0
    return-void
.end method
