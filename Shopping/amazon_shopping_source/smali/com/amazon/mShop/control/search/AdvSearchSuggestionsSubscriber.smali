.class public interface abstract Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;
.super Ljava/lang/Object;
.source "AdvSearchSuggestionsSubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/control/GenericSubscriber;


# virtual methods
.method public abstract onSearchSuggestionsReceived(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SearchSuggestion;",
            ">;)V"
        }
    .end annotation
.end method
