.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;
.super Ljava/lang/Object;
.source "RetailSearchSuggestionFilter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FilterResultValue"
.end annotation


# instance fields
.field public rows:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;"
        }
    .end annotation
.end field

.field public searchTerm:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;Ljava/util/List;Ljava/lang/String;)V
    .locals 0
    .param p3, "searchTerm"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 42
    .local p2, "rows":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;->rows:Ljava/util/List;

    .line 44
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter$FilterResultValue;->searchTerm:Ljava/lang/String;

    .line 45
    return-void
.end method
