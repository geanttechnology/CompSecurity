.class Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$1;
.super Ljava/lang/Object;
.source "GenericMetricsServiceAdapter.java"

# interfaces
.implements Landroid/os/Handler$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;


# direct methods
.method constructor <init>(Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$1;->this$0:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)Z
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter$1;->this$0:Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/GenericMetricsServiceAdapter;->handleMessageForService(Landroid/os/Message;)Z

    move-result v0

    return v0
.end method
