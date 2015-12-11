.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;
.super Landroid/widget/LinearLayout;
.source "RetailSearchEntryBar.java"


# instance fields
.field private listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryBarListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 30
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 25
    return-void
.end method


# virtual methods
.method public dispatchKeyEventPreIme(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryBarListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryBarListener;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Lcom/amazon/retailsearch/android/ui/entry/SearchEntryBarListener;->onDispatchKeyEventPreIme(Landroid/view/KeyEvent;Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 51
    const/4 v0, 0x1

    .line 53
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchKeyEventPreIme(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public setListener(Lcom/amazon/retailsearch/android/ui/entry/SearchEntryBarListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/ui/entry/SearchEntryBarListener;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;->listener:Lcom/amazon/retailsearch/android/ui/entry/SearchEntryBarListener;

    .line 40
    return-void
.end method
