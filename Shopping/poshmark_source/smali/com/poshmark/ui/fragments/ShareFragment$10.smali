.class Lcom/poshmark/ui/fragments/ShareFragment$10;
.super Ljava/lang/Object;
.source "ShareFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShareFragment;->setupListViewForListingShare(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShareFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0

    .prologue
    .line 475
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 478
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->DEFAULT:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 479
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment$10;->this$0:Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->shareToFollowers()V

    .line 480
    return-void
.end method
