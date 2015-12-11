.class Lcom/amazon/mShop/photo/PhotoCaptureView$1;
.super Ljava/lang/Object;
.source "PhotoCaptureView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/photo/PhotoCaptureView;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/photo/PhotoCaptureView;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$1;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 82
    invoke-virtual {p1}, Landroid/view/View;->isInTouchMode()Z

    move-result v0

    if-nez v0, :cond_0

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView$1;->this$0:Lcom/amazon/mShop/photo/PhotoCaptureView;

    # invokes: Lcom/amazon/mShop/photo/PhotoCaptureView;->doCancelPhoto()V
    invoke-static {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->access$000(Lcom/amazon/mShop/photo/PhotoCaptureView;)V

    .line 85
    :cond_0
    return-void
.end method
