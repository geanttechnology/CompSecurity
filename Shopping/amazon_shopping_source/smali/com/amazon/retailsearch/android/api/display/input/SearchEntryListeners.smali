.class public interface abstract Lcom/amazon/retailsearch/android/api/display/input/SearchEntryListeners;
.super Ljava/lang/Object;
.source "SearchEntryListeners.java"


# virtual methods
.method public abstract addListener(Landroid/view/View$OnFocusChangeListener;)V
.end method

.method public abstract addListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract removeListener(Landroid/view/View$OnFocusChangeListener;)V
.end method

.method public abstract removeListener(Landroid/view/View$OnLongClickListener;)V
.end method

.method public abstract removeListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;)V
.end method

.method public abstract removeListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract setListener(Landroid/view/View$OnLongClickListener;)V
.end method

.method public abstract setListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;)V
.end method
