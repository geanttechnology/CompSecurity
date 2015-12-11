.class Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$1;
.super Ljava/lang/Object;
.source "VideoRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->preload()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

.field final synthetic val$slotBase:Landroid/view/ViewGroup;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 365
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    iput-object p2, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$1;->val$slotBase:Landroid/view/ViewGroup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 367
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$1;->val$slotBase:Landroid/view/ViewGroup;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    # getter for: Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    invoke-static {v1}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->access$000(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 368
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$1;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    # getter for: Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->access$000(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoAdView;->bringToFront()V

    .line 369
    return-void
.end method
