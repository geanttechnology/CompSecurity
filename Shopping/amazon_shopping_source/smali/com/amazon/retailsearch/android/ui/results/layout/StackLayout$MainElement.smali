.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;
.super Ljava/lang/Object;
.source "StackLayout.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MainElement"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;",
        ">;"
    }
.end annotation


# instance fields
.field private final layoutElementModel:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

.field private final position:I

.field private final priority:I

.field private final viewEntry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;IILcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 0
    .param p1, "viewEntry"    # Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
    .param p2, "position"    # I
    .param p3, "priority"    # I
    .param p4, "model"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .prologue
    .line 1210
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1211
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->viewEntry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    .line 1212
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->position:I

    .line 1213
    iput p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->priority:I

    .line 1214
    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->layoutElementModel:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .line 1215
    return-void
.end method


# virtual methods
.method public compareTo(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;)I
    .locals 3
    .param p1, "x"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;

    .prologue
    .line 1236
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->position:I

    iget v2, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->position:I

    sub-int v0, v1, v2

    .line 1237
    .local v0, "d":I
    if-eqz v0, :cond_0

    .end local v0    # "d":I
    :goto_0
    return v0

    .restart local v0    # "d":I
    :cond_0
    iget v1, p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->priority:I

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->priority:I

    sub-int v0, v1, v2

    goto :goto_0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 1200
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->compareTo(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;)I

    move-result v0

    return v0
.end method

.method getLayoutElementModel()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    .locals 1

    .prologue
    .line 1231
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->layoutElementModel:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    return-object v0
.end method

.method getPosition()I
    .locals 1

    .prologue
    .line 1222
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->position:I

    return v0
.end method

.method getPriority()I
    .locals 1

    .prologue
    .line 1226
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->priority:I

    return v0
.end method

.method getViewEntry()Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
    .locals 1

    .prologue
    .line 1218
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$MainElement;->viewEntry:Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;

    return-object v0
.end method
