.class public Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;
.super Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;
.source "StackLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "LoaderScrollListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/ansel/fetch/ResourceProvider;)V
    .locals 0
    .param p2, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;

    .prologue
    .line 1272
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    .line 1273
    invoke-direct {p0, p2}, Lcom/amazon/ansel/fetch/listview/PredictiveScrollListener;-><init>(Lcom/amazon/ansel/fetch/ResourceProvider;)V

    .line 1274
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
    .param p2, "x1"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .param p3, "x2"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;

    .prologue
    .line 1271
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/ansel/fetch/ResourceProvider;)V

    return-void
.end method


# virtual methods
.method protected getLoadersFor(I)Ljava/util/List;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/collection/Factory",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceLoader",
            "<*>;>;>;"
        }
    .end annotation

    .prologue
    .line 1281
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->getLoadersFor(I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
