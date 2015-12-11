.class Lcom/amazon/device/ads/MraidDisplayController$2;
.super Ljava/lang/Object;
.source "MraidDisplayController.java"

# interfaces
.implements Lcom/amazon/device/ads/MraidView$OnCloseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/MraidDisplayController;->expand(Ljava/lang/String;IIZZ)V
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
    .line 430
    iput-object p1, p0, Lcom/amazon/device/ads/MraidDisplayController$2;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClose(Lcom/amazon/device/ads/MraidView;Lcom/amazon/device/ads/MraidView$ViewState;)V
    .locals 1
    .param p1, "view"    # Lcom/amazon/device/ads/MraidView;
    .param p2, "newViewState"    # Lcom/amazon/device/ads/MraidView$ViewState;

    .prologue
    .line 432
    iget-object v0, p0, Lcom/amazon/device/ads/MraidDisplayController$2;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidDisplayController;->close()V

    .line 433
    return-void
.end method
