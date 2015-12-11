.class public Lcom/comcast/cim/android/concurrent/UIThreadExecutor;
.super Ljava/lang/Object;
.source "UIThreadExecutor.java"

# interfaces
.implements Ljava/util/concurrent/Executor;


# instance fields
.field private final handler:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/os/Handler;)V
    .locals 0
    .param p1, "handler"    # Landroid/os/Handler;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/android/concurrent/UIThreadExecutor;->handler:Landroid/os/Handler;

    .line 14
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/comcast/cim/android/concurrent/UIThreadExecutor;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 19
    return-void
.end method
