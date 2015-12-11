.class Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;
.super Ljava/lang/Object;
.source "MedialetsExtension.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->onServiceConnected()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 81
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    const/4 v1, 0x0

    # invokes: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->performListener(Z)V
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$000(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;Z)V

    .line 82
    const/4 v0, 0x1

    # setter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->sServiceConnected:Z
    invoke-static {v0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$102(Z)Z

    .line 83
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # invokes: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->turnOnServiceConnected()V
    invoke-static {v0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$200(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V

    .line 84
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->adContext:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    invoke-static {v0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$500(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->constants:Ltv/freewheel/hybrid/ad/interfaces/IConstants;
    invoke-static {v1}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$300(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IConstants;

    move-result-object v1

    invoke-interface {v1}, Ltv/freewheel/hybrid/ad/interfaces/IConstants;->EVENT_ACTIVITY_STATE_CHANGED()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$1;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->activityStateChangedEventListener:Ltv/freewheel/hybrid/ad/interfaces/IEventListener;
    invoke-static {v2}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$400(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/ad/interfaces/IEventListener;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->addEventListener(Ljava/lang/String;Ltv/freewheel/hybrid/ad/interfaces/IEventListener;)V

    .line 85
    return-void
.end method
