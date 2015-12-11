.class Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil;
.super Ljava/lang/Object;
.source "AdLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "OnLayoutChangeListenerUtil"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 599
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static setOnLayoutChangeListenerForRoot(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V
    .locals 2
    .param p0, "adLayout"    # Lcom/amazon/device/ads/AdLayout;
    .param p1, "loadListener"    # Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 610
    new-instance v0, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;

    invoke-direct {v0, p0, p1}, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;-><init>(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    .line 625
    .local v0, "listener":Landroid/view/View$OnLayoutChangeListener;
    # getter for: Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;
    invoke-static {p0}, Lcom/amazon/device/ads/AdLayout;->access$300(Lcom/amazon/device/ads/AdLayout;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/View;->addOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 626
    return-void
.end method
