.class Lcom/localytics/android/BaseHandler$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/localytics/android/BaseHandler;

.field final synthetic val$fTask:Ljava/util/concurrent/FutureTask;


# direct methods
.method constructor <init>(Lcom/localytics/android/BaseHandler;Ljava/util/concurrent/FutureTask;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/localytics/android/BaseHandler$1;->this$0:Lcom/localytics/android/BaseHandler;

    iput-object p2, p0, Lcom/localytics/android/BaseHandler$1;->val$fTask:Ljava/util/concurrent/FutureTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/localytics/android/BaseHandler$1;->val$fTask:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0}, Ljava/util/concurrent/FutureTask;->run()V

    .line 92
    return-void
.end method
