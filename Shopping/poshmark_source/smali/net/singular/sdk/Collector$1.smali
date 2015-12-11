.class Lnet/singular/sdk/Collector$1;
.super Ljava/lang/Object;
.source "Collector.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/Collector;->getFacebookAttributionId()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/Collector;


# direct methods
.method constructor <init>(Lnet/singular/sdk/Collector;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lnet/singular/sdk/Collector$1;->this$0:Lnet/singular/sdk/Collector;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 126
    iget-object v0, p0, Lnet/singular/sdk/Collector$1;->this$0:Lnet/singular/sdk/Collector;

    iget-object v1, p0, Lnet/singular/sdk/Collector$1;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->facebookAttributionGetter:Lnet/singular/sdk/FacebookAttributionIdGetter;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$100(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/FacebookAttributionIdGetter;

    move-result-object v1

    invoke-virtual {v1}, Lnet/singular/sdk/FacebookAttributionIdGetter;->getAttributionId()Ljava/lang/String;

    move-result-object v1

    # setter for: Lnet/singular/sdk/Collector;->facebookAttributionId:Ljava/lang/String;
    invoke-static {v0, v1}, Lnet/singular/sdk/Collector;->access$002(Lnet/singular/sdk/Collector;Ljava/lang/String;)Ljava/lang/String;

    .line 127
    return-void
.end method
