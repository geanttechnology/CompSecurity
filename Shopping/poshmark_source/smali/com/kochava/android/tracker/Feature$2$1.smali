.class Lcom/kochava/android/tracker/Feature$2$1;
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
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature$2$1;->this$1:Lcom/kochava/android/tracker/Feature$2;

    .line 1183
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 1187
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$2$1;->this$1:Lcom/kochava/android/tracker/Feature$2;

    # getter for: Lcom/kochava/android/tracker/Feature$2;->this$0:Lcom/kochava/android/tracker/Feature;
    invoke-static {v0}, Lcom/kochava/android/tracker/Feature$2;->access$0(Lcom/kochava/android/tracker/Feature$2;)Lcom/kochava/android/tracker/Feature;

    move-result-object v0

    invoke-virtual {v0}, Lcom/kochava/android/tracker/Feature;->flush()V

    .line 1188
    return-void
.end method
