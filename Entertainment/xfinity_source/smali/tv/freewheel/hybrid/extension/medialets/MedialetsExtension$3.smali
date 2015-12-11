.class Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$3;
.super Ljava/lang/Object;
.source "MedialetsExtension.java"

# interfaces
.implements Ljava/lang/reflect/InvocationHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->init(Ltv/freewheel/hybrid/ad/interfaces/IAdContext;)V
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
    .line 206
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$3;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public invoke(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "proxy"    # Ljava/lang/Object;
    .param p2, "method"    # Ljava/lang/reflect/Method;
    .param p3, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 208
    invoke-virtual {p2}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "onServiceConnected"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$3;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # getter for: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$600(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    const-string v1, "The Proxy is called back to launch onServiceConnected"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 210
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension$3;->this$0:Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;

    # invokes: Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->onServiceConnected()V
    invoke-static {v0}, Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;->access$900(Ltv/freewheel/hybrid/extension/medialets/MedialetsExtension;)V

    .line 212
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method
