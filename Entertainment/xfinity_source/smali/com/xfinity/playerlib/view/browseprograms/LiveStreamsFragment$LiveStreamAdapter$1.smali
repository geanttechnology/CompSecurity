.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter$1;
.super Ljava/lang/Object;
.source "LiveStreamsFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->bindItem(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;

.field final synthetic val$holder:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;

.field final synthetic val$placeHolderTitleIsPresent:Z


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;ZLcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;

    .prologue
    .line 665
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter$1;->this$1:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;

    iput-boolean p2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter$1;->val$placeHolderTitleIsPresent:Z

    iput-object p3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter$1;->val$holder:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;
    .param p3, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 668
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter$1;->val$placeHolderTitleIsPresent:Z

    if-eqz v0, :cond_0

    .line 669
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter$1;->val$holder:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->placeholderTitle:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 671
    :cond_0
    return-void
.end method

.method public onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 0
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 674
    return-void
.end method
