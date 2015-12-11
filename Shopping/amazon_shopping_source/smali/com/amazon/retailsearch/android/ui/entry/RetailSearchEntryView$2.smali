.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$2;
.super Ljava/lang/Object;
.source "RetailSearchEntryView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 203
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 207
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 208
    .local v0, "query":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-virtual {v1, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->doSearch(Ljava/lang/String;)V

    .line 209
    return-void
.end method
