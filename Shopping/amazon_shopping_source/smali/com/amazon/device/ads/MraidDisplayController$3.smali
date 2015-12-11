.class Lcom/amazon/device/ads/MraidDisplayController$3;
.super Ljava/lang/Object;
.source "MraidDisplayController.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/MraidDisplayController;->setKeyListenerToClose(Lcom/amazon/device/ads/MraidView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/MraidDisplayController;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidDisplayController;)V
    .locals 0

    .prologue
    .line 490
    iput-object p1, p0, Lcom/amazon/device/ads/MraidDisplayController$3;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 494
    const/4 v0, 0x4

    if-ne p2, v0, :cond_0

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 496
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController$3;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->close()V

    .line 497
    const/4 v0, 0x1

    .line 499
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
