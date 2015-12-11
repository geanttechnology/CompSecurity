.class public abstract Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
.super Ljava/lang/Object;
.source "ViewEntry.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x1

    return v0
.end method

.method public abstract getType()I
.end method

.method public getType(I)I
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->getType()I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "index"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 45
    invoke-virtual {p0, p2, p3}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public abstract getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end method

.method public abstract isEnabled()Z
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;->isEnabled()Z

    move-result v0

    return v0
.end method
