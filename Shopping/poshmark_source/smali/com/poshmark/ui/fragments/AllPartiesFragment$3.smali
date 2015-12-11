.class Lcom/poshmark/ui/fragments/AllPartiesFragment$3;
.super Ljava/lang/Object;
.source "AllPartiesFragment.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/AllPartiesFragment;->setListScrollHandler()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/AllPartiesFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/AllPartiesFragment;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment$3;->this$0:Lcom/poshmark/ui/fragments/AllPartiesFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 1
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 156
    sget-boolean v0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->bIsFetchingFeedOnScroll:Z

    if-nez v0, :cond_0

    if-lez p4, :cond_0

    add-int v0, p2, p3

    if-lt v0, p4, :cond_0

    .line 157
    const/4 v0, 0x1

    sput-boolean v0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->bIsFetchingFeedOnScroll:Z

    .line 159
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 165
    return-void
.end method
