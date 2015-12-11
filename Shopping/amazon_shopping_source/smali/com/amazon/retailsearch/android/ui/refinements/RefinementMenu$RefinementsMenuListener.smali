.class Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;
.super Ljava/lang/Object;
.source "RefinementMenu.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RefinementsMenuListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)V
    .locals 0

    .prologue
    .line 186
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;

    .prologue
    .line 186
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)V

    return-void
.end method


# virtual methods
.method public OnClearAllClick()V
    .locals 0

    .prologue
    .line 231
    return-void
.end method

.method public onHide()V
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 214
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;->onHide()V

    .line 216
    :cond_0
    return-void
.end method

.method public onRefinementClick(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 202
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # invokes: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->getSpinner()Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$200(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->show()V

    .line 203
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;->onRefinementClick(Ljava/lang/String;)V

    .line 207
    :cond_0
    return-void
.end method

.method public onUpdate(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 1
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 191
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->updateDialogHeight()V

    .line 192
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 194
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;->onUpdate(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V

    .line 196
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # invokes: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->getSpinner()Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$200(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->hide()V

    .line 197
    return-void
.end method

.method public onViewSizeChanged()V
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->updateDialogHeight()V

    .line 222
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 224
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    # getter for: Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;->onViewSizeChanged()V

    .line 226
    :cond_0
    return-void
.end method
