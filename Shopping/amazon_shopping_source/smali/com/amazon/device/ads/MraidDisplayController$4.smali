.class Lcom/amazon/device/ads/MraidDisplayController$4;
.super Ljava/lang/Object;
.source "MraidDisplayController.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/MraidDisplayController;->createExpansionViewContainer(Landroid/view/View;II)Landroid/view/ViewGroup;
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
    .line 561
    iput-object p1, p0, Lcom/amazon/device/ads/MraidDisplayController$4;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 563
    const/4 v0, 0x1

    return v0
.end method
