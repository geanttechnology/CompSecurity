.class Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$1;
.super Ljava/lang/Object;
.source "InterstitialAdActivityAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$1;->this$1:Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1$1;->this$1:Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;

    iget-object v0, v0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;->this$0:Lcom/amazon/device/ads/InterstitialAdActivityAdapter;

    # getter for: Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;
    invoke-static {v0}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->access$000(Lcom/amazon/device/ads/InterstitialAdActivityAdapter;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 144
    return-void
.end method
