.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;
.super Ljava/lang/Object;
.source "RetailSearchEditTextWatcher.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;)V
    .locals 0

    .prologue
    .line 256
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 260
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$200(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    # invokes: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->getSearchMagnifierImage()Landroid/graphics/drawable/Drawable;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->access$300(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$200(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v0, v1, v3, v2, v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 264
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;->this$1:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$200(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 266
    :cond_0
    return-void
.end method
