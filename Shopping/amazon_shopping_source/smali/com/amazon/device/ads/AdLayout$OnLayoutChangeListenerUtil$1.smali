.class final Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;
.super Ljava/lang/Object;
.source "AdLayout.java"

# interfaces
.implements Landroid/view/View$OnLayoutChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil;->setOnLayoutChangeListenerForRoot(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$adLayout:Lcom/amazon/device/ads/AdLayout;

.field final synthetic val$loadListener:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V
    .locals 0

    .prologue
    .line 611
    iput-object p1, p0, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;->val$adLayout:Lcom/amazon/device/ads/AdLayout;

    iput-object p2, p0, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;->val$loadListener:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLayoutChange(Landroid/view/View;IIIIIIII)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I
    .param p6, "oldLeft"    # I
    .param p7, "oldTop"    # I
    .param p8, "oldRight"    # I
    .param p9, "oldBottom"    # I

    .prologue
    .line 614
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;->val$adLayout:Lcom/amazon/device/ads/AdLayout;

    # getter for: Lcom/amazon/device/ads/AdLayout;->needsToLoadAdOnLayout:Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-static {v0}, Lcom/amazon/device/ads/AdLayout;->access$200(Lcom/amazon/device/ads/AdLayout;)Ljava/util/concurrent/atomic/AtomicBoolean;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 618
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;->val$adLayout:Lcom/amazon/device/ads/AdLayout;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdLayout;->setFloatingWindowDimensions()V

    .line 619
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;->val$adLayout:Lcom/amazon/device/ads/AdLayout;

    iget-object v1, p0, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;->val$loadListener:Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/AdLayout;->loadAdFromAdController(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)V

    .line 620
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout$OnLayoutChangeListenerUtil$1;->val$adLayout:Lcom/amazon/device/ads/AdLayout;

    # getter for: Lcom/amazon/device/ads/AdLayout;->activityRootView:Landroid/view/View;
    invoke-static {v0}, Lcom/amazon/device/ads/AdLayout;->access$300(Lcom/amazon/device/ads/AdLayout;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->removeOnLayoutChangeListener(Landroid/view/View$OnLayoutChangeListener;)V

    .line 622
    :cond_0
    return-void
.end method
