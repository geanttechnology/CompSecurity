.class Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;
.super Ljava/lang/Object;
.source "RefinementMenu.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 112
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # invokes: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->getSpinner()Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$200(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->show()V

    .line 113
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$300(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->clearAll()V

    .line 114
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;->OnClearAllClick()V

    .line 116
    :cond_0
    return-void
.end method
