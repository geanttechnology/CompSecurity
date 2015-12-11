.class Lcom/poshmark/ui/fragments/BrandFragment_v1$1;
.super Ljava/lang/Object;
.source "BrandFragment_v1.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment_v1;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
    .line 147
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$1;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 1
    .param p1, "isPagination"    # Z

    .prologue
    .line 150
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$1;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # invokes: Lcom/poshmark/ui/fragments/BrandFragment_v1;->getSearchResults(Z)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$000(Lcom/poshmark/ui/fragments/BrandFragment_v1;Z)V

    .line 151
    return-void
.end method
