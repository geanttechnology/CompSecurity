.class public Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;
.super Ljava/lang/Object;
.source "RetailSearchQueryEntry.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FilterListener"
.end annotation


# instance fields
.field private adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

.field private autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private searchMagnifier:Landroid/graphics/drawable/Drawable;

.field private workingSpinner:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "autoCompleteTextView"    # Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    .param p2, "workingSpinner"    # Landroid/graphics/drawable/Drawable;
    .param p3, "searchMagnifier"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 313
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 314
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 315
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    .line 316
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->workingSpinner:Landroid/graphics/drawable/Drawable;

    .line 317
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->searchMagnifier:Landroid/graphics/drawable/Drawable;

    .line 318
    return-void
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    .prologue
    .line 304
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    .prologue
    .line 304
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->workingSpinner:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    .prologue
    .line 304
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->searchMagnifier:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method


# virtual methods
.method public afterPublishResults(Ljava/lang/String;Ljava/util/List;)V
    .locals 1
    .param p1, "constraint"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 363
    .local p2, "suggestionRows":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    if-eqz v0, :cond_0

    .line 365
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->updateSuggestionContent(Ljava/lang/String;Ljava/util/List;)V

    .line 366
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->notifyDataSetChanged()V

    .line 368
    :cond_0
    return-void
.end method

.method public beforePerformFiltering()V
    .locals 2

    .prologue
    .line 331
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener$1;-><init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 344
    return-void
.end method

.method public beforePublishResults(Ljava/util/List;Z)V
    .locals 3
    .param p2, "hideSpinner"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .local p1, "suggestionRows":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;>;"
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 349
    if-eqz p1, :cond_0

    if-eqz p2, :cond_1

    .line 352
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->workingSpinner:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_1

    .line 354
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->workingSpinner:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1, v1}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 355
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->autoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->searchMagnifier:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1, v2, v2, v2}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 358
    :cond_1
    return-void
.end method

.method public setAdapter(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;)V
    .locals 0
    .param p1, "adapter"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    .prologue
    .line 325
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    .line 326
    return-void
.end method
