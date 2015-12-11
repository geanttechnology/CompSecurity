.class Lcom/localytics/android/AnalyticsHandler$15;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/localytics/android/AnalyticsHandler;

.field final synthetic val$dimension:I


# direct methods
.method constructor <init>(Lcom/localytics/android/AnalyticsHandler;I)V
    .locals 0

    .prologue
    .line 720
    iput-object p1, p0, Lcom/localytics/android/AnalyticsHandler$15;->this$0:Lcom/localytics/android/AnalyticsHandler;

    iput p2, p0, Lcom/localytics/android/AnalyticsHandler$15;->val$dimension:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 720
    invoke-virtual {p0}, Lcom/localytics/android/AnalyticsHandler$15;->call()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public call()Ljava/lang/String;
    .locals 2

    .prologue
    .line 724
    iget-object v0, p0, Lcom/localytics/android/AnalyticsHandler$15;->this$0:Lcom/localytics/android/AnalyticsHandler;

    iget v1, p0, Lcom/localytics/android/AnalyticsHandler$15;->val$dimension:I

    # invokes: Lcom/localytics/android/AnalyticsHandler;->_getCustomDimension(I)Ljava/lang/String;
    invoke-static {v0, v1}, Lcom/localytics/android/AnalyticsHandler;->access$1500(Lcom/localytics/android/AnalyticsHandler;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
