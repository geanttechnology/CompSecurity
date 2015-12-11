.class Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;
.super Landroid/os/AsyncTask;
.source "InterstitialAdActivityAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->addNativeCloseButton(Landroid/widget/FrameLayout;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Landroid/widget/RelativeLayout;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/InterstitialAdActivityAdapter;

.field final synthetic val$buttonSize:I

.field final synthetic val$closeNormal:Landroid/graphics/drawable/BitmapDrawable;

.field final synthetic val$closePressed:Landroid/graphics/drawable/BitmapDrawable;

.field final synthetic val$parentView:Landroid/widget/FrameLayout;

.field final synthetic val$tapTargetSize:I


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAdActivityAdapter;Landroid/widget/FrameLayout;Landroid/graphics/drawable/BitmapDrawable;Landroid/graphics/drawable/BitmapDrawable;II)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->this$0:Lcom/amazon/device/ads/InterstitialAdActivityAdapter;

    iput-object p2, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$parentView:Landroid/widget/FrameLayout;

    iput-object p3, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$closeNormal:Landroid/graphics/drawable/BitmapDrawable;

    iput-object p4, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$closePressed:Landroid/graphics/drawable/BitmapDrawable;

    iput p5, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$buttonSize:I

    iput p6, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$tapTargetSize:I

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Landroid/widget/RelativeLayout;
    .locals 7
    .param p1, "empty"    # [Ljava/lang/Void;

    .prologue
    .line 135
    new-instance v4, Landroid/widget/RelativeLayout;

    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v5}, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v4, v5}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 136
    .local v4, "tapTarget":Landroid/widget/RelativeLayout;
    new-instance v0, Landroid/widget/ImageButton;

    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v5}, Landroid/widget/FrameLayout;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct {v0, v5}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;)V

    .line 137
    .local v0, "closeButton":Landroid/widget/ImageView;
    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$closeNormal:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 138
    sget-object v5, Landroid/widget/ImageView$ScaleType;->FIT_CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 139
    const/4 v5, 0x0

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 140
    new-instance v1, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$1;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$1;-><init>(Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;)V

    .line 146
    .local v1, "onClickListener":Landroid/view/View$OnClickListener;
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 147
    invoke-virtual {v4, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 148
    new-instance v2, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;

    invoke-direct {v2, p0, v0}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$2;-><init>(Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;Landroid/widget/ImageView;)V

    .line 166
    .local v2, "onTouchListener":Landroid/view/View$OnTouchListener;
    invoke-virtual {v4, v2}, Landroid/widget/RelativeLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 167
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 169
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    iget v5, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$buttonSize:I

    iget v6, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$buttonSize:I

    invoke-direct {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 170
    .local v3, "params":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v5, 0xd

    invoke-virtual {v3, v5}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 171
    invoke-virtual {v4, v0, v3}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 173
    return-object v4
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 131
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->doInBackground([Ljava/lang/Void;)Landroid/widget/RelativeLayout;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Landroid/widget/RelativeLayout;)V
    .locals 5
    .param p1, "tapTarget"    # Landroid/widget/RelativeLayout;

    .prologue
    const/4 v4, 0x0

    .line 179
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    iget v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$tapTargetSize:I

    iget v2, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$tapTargetSize:I

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    .line 180
    .local v0, "layoutParams":Landroid/widget/FrameLayout$LayoutParams;
    iput v4, v0, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    .line 181
    iput v4, v0, Landroid/widget/FrameLayout$LayoutParams;->rightMargin:I

    .line 182
    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->val$parentView:Landroid/widget/FrameLayout;

    invoke-virtual {v1, p1, v0}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 183
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 131
    check-cast p1, Landroid/widget/RelativeLayout;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->onPostExecute(Landroid/widget/RelativeLayout;)V

    return-void
.end method
