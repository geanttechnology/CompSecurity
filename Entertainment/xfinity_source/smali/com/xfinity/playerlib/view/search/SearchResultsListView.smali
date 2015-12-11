.class public Lcom/xfinity/playerlib/view/search/SearchResultsListView;
.super Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;
.source "SearchResultsListView.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;-><init>(Landroid/content/Context;)V

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 29
    invoke-direct {p0, p1, p2, p3}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 30
    return-void
.end method


# virtual methods
.method public hasFocus()Z
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x1

    return v0
.end method

.method public hasWindowFocus()Z
    .locals 1

    .prologue
    .line 34
    const/4 v0, 0x1

    return v0
.end method

.method public isFocused()Z
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x1

    return v0
.end method
