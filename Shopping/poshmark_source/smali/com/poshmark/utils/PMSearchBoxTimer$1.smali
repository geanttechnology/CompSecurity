.class Lcom/poshmark/utils/PMSearchBoxTimer$1;
.super Ljava/lang/Object;
.source "PMSearchBoxTimer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/PMSearchBoxTimer;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/PMSearchBoxTimer;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/PMSearchBoxTimer;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/poshmark/utils/PMSearchBoxTimer$1;->this$0:Lcom/poshmark/utils/PMSearchBoxTimer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 31
    iget-object v0, p0, Lcom/poshmark/utils/PMSearchBoxTimer$1;->this$0:Lcom/poshmark/utils/PMSearchBoxTimer;

    iget-object v0, v0, Lcom/poshmark/utils/PMSearchBoxTimer;->callback:Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;

    iget-object v1, p0, Lcom/poshmark/utils/PMSearchBoxTimer$1;->this$0:Lcom/poshmark/utils/PMSearchBoxTimer;

    iget-object v1, v1, Lcom/poshmark/utils/PMSearchBoxTimer;->searchString:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/poshmark/utils/PMSearchBoxTimer$PMSearchTimerTaskCallback;->timerCallback(Ljava/lang/String;)V

    .line 32
    return-void
.end method
