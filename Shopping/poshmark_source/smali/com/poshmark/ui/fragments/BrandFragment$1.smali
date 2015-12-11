.class Lcom/poshmark/ui/fragments/BrandFragment$1;
.super Ljava/lang/Object;
.source "BrandFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
    .line 159
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 1
    .param p1, "isPagination"    # Z

    .prologue
    .line 162
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment$1;->this$0:Lcom/poshmark/ui/fragments/BrandFragment;

    # invokes: Lcom/poshmark/ui/fragments/BrandFragment;->getSearchResults(Z)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/BrandFragment;->access$000(Lcom/poshmark/ui/fragments/BrandFragment;Z)V

    .line 163
    return-void
.end method
