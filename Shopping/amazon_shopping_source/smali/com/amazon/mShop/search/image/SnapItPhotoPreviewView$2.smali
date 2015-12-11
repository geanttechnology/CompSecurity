.class Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$2;
.super Ljava/lang/Object;
.source "SnapItPhotoPreviewView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$2;->this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 46
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$2;->this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    # invokes: Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->doUsePhoto()V
    invoke-static {v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->access$000(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V

    .line 50
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
