.class public Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;
.super Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
.source "ViewEntryWrapper.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Entry:",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;",
        ">",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;"
    }
.end annotation


# instance fields
.field private final entry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TEntry;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TEntry;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper<TEntry;>;"
    .local p1, "entry":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;, "TEntry;"
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;->entry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    .line 17
    return-void
.end method


# virtual methods
.method public getEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TEntry;"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper<TEntry;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;->entry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 21
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper<TEntry;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;->entry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->getType()I

    move-result v0

    return v0
.end method

.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 26
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper<TEntry;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;->entry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 31
    .local p0, "this":Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;, "Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper<TEntry;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntryWrapper;->entry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->isEnabled()Z

    move-result v0

    return v0
.end method
