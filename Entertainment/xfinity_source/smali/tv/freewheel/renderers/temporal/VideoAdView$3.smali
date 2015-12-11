.class Ltv/freewheel/renderers/temporal/VideoAdView$3;
.super Ljava/lang/Object;
.source "VideoAdView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnInfoListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/renderers/temporal/VideoAdView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/temporal/VideoAdView;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/temporal/VideoAdView;)V
    .locals 0

    .prologue
    .line 201
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoAdView$3;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onInfo(Landroid/media/MediaPlayer;II)Z
    .locals 4
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    const/4 v3, 0x1

    .line 204
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView$3;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$000(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onInfo("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 205
    packed-switch p2, :pswitch_data_0

    .line 216
    :goto_0
    return v3

    .line 207
    :pswitch_0
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView$3;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;
    invoke-static {v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$400(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/renderers/temporal/VideoRenderer;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdViewBuffered(Z)V

    goto :goto_0

    .line 210
    :pswitch_1
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoAdView$3;->this$0:Ltv/freewheel/renderers/temporal/VideoAdView;

    # getter for: Ltv/freewheel/renderers/temporal/VideoAdView;->hostRenderer:Ltv/freewheel/renderers/temporal/VideoRenderer;
    invoke-static {v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->access$400(Ltv/freewheel/renderers/temporal/VideoAdView;)Ltv/freewheel/renderers/temporal/VideoRenderer;

    move-result-object v0

    invoke-virtual {v0, v3}, Ltv/freewheel/renderers/temporal/VideoRenderer;->onAdViewBuffered(Z)V

    goto :goto_0

    .line 205
    :pswitch_data_0
    .packed-switch 0x2bd
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
