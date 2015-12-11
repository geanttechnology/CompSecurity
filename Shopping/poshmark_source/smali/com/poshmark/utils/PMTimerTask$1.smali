.class Lcom/poshmark/utils/PMTimerTask$1;
.super Ljava/lang/Object;
.source "PMTimerTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/PMTimerTask;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/PMTimerTask;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/PMTimerTask;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/poshmark/utils/PMTimerTask$1;->this$0:Lcom/poshmark/utils/PMTimerTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/poshmark/utils/PMTimerTask$1;->this$0:Lcom/poshmark/utils/PMTimerTask;

    iget-object v0, v0, Lcom/poshmark/utils/PMTimerTask;->callback:Lcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;

    invoke-interface {v0}, Lcom/poshmark/utils/PMTimerTask$PMTimerTaskCallback;->timerCallback()V

    .line 29
    return-void
.end method
