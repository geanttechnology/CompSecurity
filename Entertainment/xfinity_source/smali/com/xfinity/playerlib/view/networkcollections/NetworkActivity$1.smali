.class Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity$1;
.super Ljava/lang/Object;
.source "NetworkActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->loadNetworkLogo(Lcom/xfinity/playerlib/model/tags/Network;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity$1;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;

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
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity$1;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->title:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 47
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 48
    return-void
.end method

.method public onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 2
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity$1;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->title:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 53
    return-void
.end method
