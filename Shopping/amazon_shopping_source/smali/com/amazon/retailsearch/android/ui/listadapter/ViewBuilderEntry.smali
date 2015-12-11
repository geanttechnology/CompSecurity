.class public abstract Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
.super Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
.source "ViewBuilderEntry.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilder;


# instance fields
.field private final type:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "type"    # I

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;-><init>()V

    .line 19
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;->type:I

    .line 20
    return-void
.end method


# virtual methods
.method public getType()I
    .locals 1

    .prologue
    .line 28
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;->type:I

    return v0
.end method

.method public getView(Landroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 39
    if-nez p1, :cond_0

    invoke-virtual {p0, p2}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;->createView(Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 40
    .local v0, "view":Landroid/view/View;
    :goto_0
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;->buildView(Landroid/view/View;)V

    .line 41
    return-object v0

    .end local v0    # "view":Landroid/view/View;
    :cond_0
    move-object v0, p1

    .line 39
    goto :goto_0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x1

    return v0
.end method
