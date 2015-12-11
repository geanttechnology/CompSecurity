.class Ltv/freewheel/renderers/temporal/VideoRenderer$3;
.super Ljava/lang/Object;
.source "VideoRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/renderers/temporal/VideoRenderer;->dispose()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

.field final synthetic val$slotBase:Landroid/view/ViewGroup;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/temporal/VideoRenderer;Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 730
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$3;->this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

    iput-object p2, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$3;->val$slotBase:Landroid/view/ViewGroup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 732
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$3;->this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

    # getter for: Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;
    invoke-static {v0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->access$000(Ltv/freewheel/renderers/temporal/VideoRenderer;)Ltv/freewheel/renderers/temporal/VideoAdView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Ltv/freewheel/renderers/temporal/VideoAdView;->setVisibility(I)V

    .line 733
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$3;->val$slotBase:Landroid/view/ViewGroup;

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$3;->this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

    # getter for: Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->access$000(Ltv/freewheel/renderers/temporal/VideoRenderer;)Ltv/freewheel/renderers/temporal/VideoAdView;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 734
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$3;->this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

    const/4 v1, 0x0

    # setter for: Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;
    invoke-static {v0, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->access$002(Ltv/freewheel/renderers/temporal/VideoRenderer;Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/renderers/temporal/VideoAdView;

    .line 735
    return-void
.end method
