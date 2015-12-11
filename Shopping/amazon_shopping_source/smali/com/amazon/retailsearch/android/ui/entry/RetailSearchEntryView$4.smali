.class Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$4;
.super Ljava/lang/Object;
.source "RetailSearchEntryView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->updateEntryView()V
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
    .line 286
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$4;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 293
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$4;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->requestFocus()Z

    .line 294
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$4;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView$4;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryView;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setSelection(I)V

    .line 295
    return-void
.end method
