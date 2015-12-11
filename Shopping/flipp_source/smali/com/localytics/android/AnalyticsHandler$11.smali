.class Lcom/localytics/android/AnalyticsHandler$11;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/localytics/android/AnalyticsHandler;

.field final synthetic val$isOptingOut:Z


# direct methods
.method constructor <init>(Lcom/localytics/android/AnalyticsHandler;Z)V
    .locals 0

    .prologue
    .line 446
    iput-object p1, p0, Lcom/localytics/android/AnalyticsHandler$11;->this$0:Lcom/localytics/android/AnalyticsHandler;

    iput-boolean p2, p0, Lcom/localytics/android/AnalyticsHandler$11;->val$isOptingOut:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 450
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler$11;->this$0:Lcom/localytics/android/AnalyticsHandler;

    iget-boolean v1, p0, Lcom/localytics/android/AnalyticsHandler$11;->val$isOptingOut:Z

    # invokes: Lcom/localytics/android/AnalyticsHandler;->_setOptedOut(Z)V
    invoke-static {v0, v1}, Lcom/localytics/android/AnalyticsHandler;->access$1100(Lcom/localytics/android/AnalyticsHandler;Z)V

    .line 451
    return-void
.end method
