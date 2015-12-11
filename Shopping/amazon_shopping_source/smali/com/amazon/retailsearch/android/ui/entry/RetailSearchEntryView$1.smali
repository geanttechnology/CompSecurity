.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$1;
.super Ljava/lang/Object;
.source "RetailSearchEntryView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;)V
    .locals 0

    .prologue
    .line 184
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x0

    .line 188
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 190
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setFocusableInTouchMode(Z)V

    .line 191
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->clearFocus()V

    .line 192
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 198
    :goto_0
    return v2

    .line 196
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$1;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setFocusableInTouchMode(Z)V

    goto :goto_0
.end method
