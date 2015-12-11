.class Lcom/kochava/android/tracker/Feature$2$3;
.super Ljava/util/TimerTask;
.source "Feature.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kochava/android/tracker/Feature$2;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/kochava/android/tracker/Feature$2;


# direct methods
.method constructor <init>(Lcom/kochava/android/tracker/Feature$2;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature$2$3;->this$1:Lcom/kochava/android/tracker/Feature$2;

    .line 1212
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1217
    sget-boolean v0, Lcom/kochava/android/tracker/Global;->DEBUG:Z

    if-eqz v0, :cond_0

    const-string v0, "KochavaTracker"

    const-string v1, "Scheduling timer to que initial event if needed."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1218
    :cond_0
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$2$3;->this$1:Lcom/kochava/android/tracker/Feature$2;

    # getter for: Lcom/kochava/android/tracker/Feature$2;->this$0:Lcom/kochava/android/tracker/Feature;
    invoke-static {v0}, Lcom/kochava/android/tracker/Feature$2;->access$0(Lcom/kochava/android/tracker/Feature$2;)Lcom/kochava/android/tracker/Feature;

    move-result-object v0

    const/4 v1, 0x0

    # invokes: Lcom/kochava/android/tracker/Feature;->queInitial(Z)V
    invoke-static {v0, v1}, Lcom/kochava/android/tracker/Feature;->access$32(Lcom/kochava/android/tracker/Feature;Z)V

    .line 1219
    return-void
.end method
