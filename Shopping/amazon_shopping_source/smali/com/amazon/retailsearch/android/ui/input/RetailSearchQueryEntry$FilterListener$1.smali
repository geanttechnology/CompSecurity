.class Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;
.super Ljava/lang/Object;
.source "RetailSearchQueryEntry.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->beforePerformFiltering()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)V
    .locals 0

    .prologue
    .line 332
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 336
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->access$300(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->workingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->access$400(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 338
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->access$300(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->searchMagnifier:Landroid/graphics/drawable/Drawable;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->access$500(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->workingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->access$400(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v0, v1, v3, v2, v3}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 340
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    # getter for: Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->workingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->access$400(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 342
    :cond_0
    return-void
.end method
