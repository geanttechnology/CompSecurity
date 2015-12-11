.class Lcom/amazon/device/ads/MraidBrowser$6;
.super Ljava/lang/Object;
.source "MraidBrowser.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/MraidBrowser;->initializeButtons(Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/MraidBrowser;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidBrowser;)V
    .locals 0

    .prologue
    .line 213
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser$6;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 215
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$6;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidBrowser;->access$000(Lcom/amazon/device/ads/MraidBrowser;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 216
    return-void
.end method
