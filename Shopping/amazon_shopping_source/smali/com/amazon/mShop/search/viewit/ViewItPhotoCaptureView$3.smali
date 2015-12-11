.class Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;
.super Ljava/lang/Object;
.source "ViewItPhotoCaptureView.java"

# interfaces
.implements Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDrawerOpened()V
    .locals 2

    .prologue
    .line 195
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 216
    return-void
.end method
