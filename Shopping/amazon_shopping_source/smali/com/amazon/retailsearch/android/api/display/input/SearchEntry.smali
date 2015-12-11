.class public interface abstract Lcom/amazon/retailsearch/android/api/display/input/SearchEntry;
.super Ljava/lang/Object;
.source "SearchEntry.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/DisplayComponent;
.implements Lcom/amazon/retailsearch/android/api/display/input/SearchEntryListeners;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;
    }
.end annotation


# virtual methods
.method public abstract clearInputFocus()V
.end method

.method public abstract dismissSearch()V
.end method

.method public abstract getSearchBoxInfo()Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;
.end method

.method public abstract getViewLayoutParams()Landroid/view/ViewGroup$LayoutParams;
.end method

.method public abstract hasFocus()Z
.end method

.method public abstract openSearch()V
.end method

.method public abstract requestSearchBoxFocus()V
.end method

.method public abstract setQuery(Ljava/lang/String;)V
.end method

.method public abstract setViewLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
.end method
