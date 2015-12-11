.class Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$1;
.super Ljava/lang/Object;
.source "SnapItPhotoPreviewView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$1;->this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 37
    invoke-virtual {p1}, Landroid/view/View;->isInTouchMode()Z

    move-result v0

    if-nez v0, :cond_0

    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView$1;->this$0:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    # invokes: Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->doUsePhoto()V
    invoke-static {v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;->access$000(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;)V

    .line 40
    :cond_0
    return-void
.end method
