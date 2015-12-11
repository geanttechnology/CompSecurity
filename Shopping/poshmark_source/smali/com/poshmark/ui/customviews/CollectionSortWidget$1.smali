.class Lcom/poshmark/ui/customviews/CollectionSortWidget$1;
.super Ljava/lang/Object;
.source "CollectionSortWidget.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/CollectionSortWidget;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/CollectionSortWidget;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->listener:Lcom/poshmark/utils/CollectionSortWidgetListener;

    if-eqz v0, :cond_1

    .line 59
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    # invokes: Lcom/poshmark/ui/customviews/CollectionSortWidget;->unselectButton(Lcom/poshmark/ui/customviews/PMButton;)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->access$000(Lcom/poshmark/ui/customviews/CollectionSortWidget;Lcom/poshmark/ui/customviews/PMButton;)V

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/CollectionSortWidget;->leftButton:Lcom/poshmark/ui/customviews/PMButton;

    iput-object v1, v0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 63
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/CollectionSortWidget;->currentActiveButton:Lcom/poshmark/ui/customviews/PMButton;

    # invokes: Lcom/poshmark/ui/customviews/CollectionSortWidget;->selectButton(Lcom/poshmark/ui/customviews/PMButton;)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/customviews/CollectionSortWidget;->access$100(Lcom/poshmark/ui/customviews/CollectionSortWidget;Lcom/poshmark/ui/customviews/PMButton;)V

    .line 64
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CollectionSortWidget$1;->this$0:Lcom/poshmark/ui/customviews/CollectionSortWidget;

    iget-object v1, v0, Lcom/poshmark/ui/customviews/CollectionSortWidget;->listener:Lcom/poshmark/utils/CollectionSortWidgetListener;

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;

    invoke-interface {v1, v0}, Lcom/poshmark/utils/CollectionSortWidgetListener;->sortWidgetClicked(Lcom/poshmark/ui/customviews/CollectionSortWidget$SortType;)V

    .line 66
    :cond_1
    return-void
.end method
