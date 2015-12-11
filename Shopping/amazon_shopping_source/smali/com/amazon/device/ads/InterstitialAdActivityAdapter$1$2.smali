.class Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;
.super Ljava/lang/Object;
.source "InterstitialAdActivityAdapter.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->doInBackground([Ljava/lang/Void;)Landroid/widget/RelativeLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;

.field final synthetic val$closeButton:Landroid/widget/ImageView;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;Landroid/widget/ImageView;)V
    .locals 0

    .prologue
    .line 149
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;->this$1:Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;

    iput-object p2, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;->val$closeButton:Landroid/widget/ImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 153
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 162
    :goto_0
    const/4 v0, 0x0

    return v0

    .line 156
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;->val$closeButton:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;->this$1:Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;

    iget-object v1, v1, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$closePressed:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 159
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;->val$closeButton:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;->this$1:Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;

    iget-object v1, v1, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$closeNormal:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 153
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
