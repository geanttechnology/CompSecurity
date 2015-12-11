.class Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$3;
.super Ljava/lang/Object;
.source "RetailSearchQueryEntry.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setUpAutoComplete()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)V
    .locals 0

    .prologue
    .line 223
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$3;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTextCleared()V
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$3;->this$0:Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->openSearch()V

    .line 228
    return-void
.end method
