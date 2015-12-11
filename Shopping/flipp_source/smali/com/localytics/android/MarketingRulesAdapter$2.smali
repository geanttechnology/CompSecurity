.class Lcom/localytics/android/MarketingRulesAdapter$2;
.super Ljava/lang/Thread;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/localytics/android/MarketingRulesAdapter;

.field final synthetic val$fTask:Ljava/util/concurrent/FutureTask;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingRulesAdapter;Ljava/util/concurrent/FutureTask;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/localytics/android/MarketingRulesAdapter$2;->this$0:Lcom/localytics/android/MarketingRulesAdapter;

    iput-object p2, p0, Lcom/localytics/android/MarketingRulesAdapter$2;->val$fTask:Ljava/util/concurrent/FutureTask;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 68
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingRulesAdapter$2;->val$fTask:Ljava/util/concurrent/FutureTask;

    invoke-virtual {v0}, Ljava/util/concurrent/FutureTask;->run()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    :goto_0
    return-void

    .line 70
    :catch_0
    move-exception v0

    .line 72
    const-string v1, "Caught an exception"

    invoke-static {v1, v0}, Lcom/localytics/android/Localytics$Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
