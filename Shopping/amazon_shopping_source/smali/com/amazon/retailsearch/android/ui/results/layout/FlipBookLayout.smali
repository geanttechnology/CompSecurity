.class public Lcom/amazon/retailsearch/android/ui/results/layout/FlipBookLayout;
.super Ljava/lang/Object;
.source "FlipBookLayout.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/layout/SearchLayout;


# instance fields
.field private final asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

.field private final container:Landroid/view/ViewGroup;

.field private final resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;


# direct methods
.method public constructor <init>(Landroid/view/ViewGroup;Lcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;)V
    .locals 0
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .param p3, "asinImpressionTracker"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/FlipBookLayout;->container:Landroid/view/ViewGroup;

    .line 15
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/FlipBookLayout;->resourceProvider:Lcom/amazon/ansel/fetch/ResourceProvider;

    .line 16
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/results/layout/FlipBookLayout;->asinImpressionTracker:Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;

    .line 17
    return-void
.end method


# virtual methods
.method public changeOrientation(ILcom/amazon/retailsearch/android/ui/results/layout/UserState;)V
    .locals 0
    .param p1, "orientation"    # I
    .param p2, "userState"    # Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .prologue
    .line 57
    return-void
.end method

.method public disable()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
    .locals 1

    .prologue
    .line 31
    const/4 v0, 0x0

    return-object v0
.end method

.method public enable(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V
    .locals 0
    .param p1, "state"    # Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .prologue
    .line 24
    return-void
.end method

.method public getUserState()Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
    .locals 1

    .prologue
    .line 50
    const/4 v0, 0x0

    return-object v0
.end method

.method public pause()V
    .locals 0

    .prologue
    .line 44
    return-void
.end method

.method public resume()V
    .locals 0

    .prologue
    .line 38
    return-void
.end method

.method public setEntryGroupAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 63
    return-void
.end method
