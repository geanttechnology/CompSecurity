.class Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$ThreadPerTaskExecutor;
.super Ljava/lang/Object;
.source "FeedsServerCom.java"

# interfaces
.implements Ljava/util/concurrent/Executor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ThreadPerTaskExecutor"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;


# direct methods
.method private constructor <init>(Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$ThreadPerTaskExecutor;->this$0:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$ThreadPerTaskExecutor;)V
    .locals 0

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom$ThreadPerTaskExecutor;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;)V

    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "r"    # Ljava/lang/Runnable;

    .prologue
    .line 83
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 85
    return-void
.end method
