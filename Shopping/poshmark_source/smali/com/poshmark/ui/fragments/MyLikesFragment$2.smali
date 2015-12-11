.class Lcom/poshmark/ui/fragments/MyLikesFragment$2;
.super Ljava/lang/Object;
.source "MyLikesFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MyLikesFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MyLikesFragment;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MyLikesFragment$2;->this$0:Lcom/poshmark/ui/fragments/MyLikesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public loadItems(Z)V
    .locals 0
    .param p1, "isPagination"    # Z

    .prologue
    .line 138
    return-void
.end method
